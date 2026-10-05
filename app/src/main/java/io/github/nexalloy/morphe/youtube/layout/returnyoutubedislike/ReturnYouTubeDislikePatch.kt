package io.github.nexalloy.morphe.youtube.layout.returnyoutubedislike

import app.morphe.extension.shared.returnyoutubedislike.ui.ReturnYouTubeDislikeAboutPreference
import app.morphe.extension.shared.returnyoutubedislike.ui.ReturnYouTubeDislikeDebugStatsPreferenceCategory
import app.morphe.extension.youtube.patches.ReturnYouTubeDislikePatch
import com.facebook.litho.ComponentHost
import io.github.nexalloy.morphe.shared.misc.settings.preference.NonInteractivePreference
import io.github.nexalloy.morphe.shared.misc.settings.preference.PreferenceCategory
import io.github.nexalloy.morphe.shared.misc.settings.preference.PreferenceScreenPreference
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.shared.misc.textcomponent.hookLithoSpannableString
import io.github.nexalloy.morphe.shared.misc.textcomponent.textComponentPatch
import io.github.nexalloy.morphe.youtube.misc.playertype.PlayerTypeHook
import io.github.nexalloy.morphe.youtube.misc.settings.PreferenceScreen
import io.github.nexalloy.morphe.youtube.video.videoid.VideoId
import io.github.nexalloy.morphe.youtube.video.videoid.hookPlayerResponseVideoId
import io.github.nexalloy.morphe.youtube.video.videoid.videoIdHooks
import io.github.nexalloy.patch

val ReturnYouTubeDislike = patch(
    name = "Return YouTube Dislike",
    description = "Adds an option to show the dislike count of videos with Return YouTube Dislike.",
) {
    dependsOn(
        VideoId,
        PlayerTypeHook,
        textComponentPatch,
    )

    PreferenceScreen.RETURN_YOUTUBE_DISLIKE.addPreferences(
        SwitchPreference("morphe_ryd_enabled"),
        SwitchPreference("morphe_ryd_dislike_percentage", summary = true),
        SwitchPreference("morphe_ryd_estimated_like", summary = true),
        SwitchPreference("morphe_ryd_toast_on_connection_error", summary = true),
        NonInteractivePreference(
            key = "morphe_ryd_attribution",
            tag = ReturnYouTubeDislikeAboutPreference::class.java,
            selectable = true,
        ),
        PreferenceCategory(
            key = "morphe_ryd_statistics_category",
            sorting = PreferenceScreenPreference.Sorting.UNSORTED,
            preferences = emptySet(), // Preferences are added by custom class at runtime.
            tag = ReturnYouTubeDislikeDebugStatsPreferenceCategory::class.java,
        )
    )

    // region Inject newVideoLoaded event handler to update dislikes when a new video is loaded.

    videoIdHooks.add { videoId ->
        ReturnYouTubeDislikePatch.newVideoLoaded(videoId)
    }

    // Hook the player response video ID, to start loading RYD sooner in the background.
    hookPlayerResponseVideoId { videoId, isShortAndOpeningOrPlaying ->
        ReturnYouTubeDislikePatch.preloadVideoId(videoId, isShortAndOpeningOrPlaying)
    }

    // endregion

    // region Hook like/dislike/remove like button clicks to send votes to the API.

    ::likeEndpointParserMethod.hookMethod {
        after {
            val serviceName = ::endPointServiceNameField.field.get(it.thisObject) as? String
            val targetObj = ::targetField.field.get(it.thisObject)
                ?: it.args.firstOrNull { arg -> arg != null && arg.javaClass == ::videoIdField.field.declaringClass }
            val videoId = targetObj?.let { obj -> ::videoIdField.field.get(obj) as? String }
            if (serviceName != null && videoId != null) {
                ReturnYouTubeDislikePatch.sendVote(serviceName, videoId)
            }
        }
    }

    // endregion

    // region Litho text & action bar buttons

    hookLithoSpannableString(ReturnYouTubeDislikePatch::onLithoTextLoaded)

    ComponentHostSetContentDescriptionFingerprint.hookMethod {
        before {
            val host = it.thisObject as ComponentHost
            val description = it.args[0] as? CharSequence
            it.args[0] = ReturnYouTubeDislikePatch.onComponentHostContentDescription(host, description)
        }
    }

    YogaSetWidthFingerprint.hookMethod {
        before {
            val width = it.args[0] as Float
            val nodePointer = ::nativePointerField.field.getLong(it.thisObject)
            ReturnYouTubeDislikePatch.onYogaSetWidth(nodePointer, width)
        }
    }

    // endregion
}
