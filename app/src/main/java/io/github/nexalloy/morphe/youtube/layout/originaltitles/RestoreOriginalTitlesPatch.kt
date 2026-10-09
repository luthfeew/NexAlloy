package io.github.nexalloy.morphe.youtube.layout.originaltitles

import app.morphe.extension.youtube.patches.originaltitles.RestoreOriginalTitlesPatch as ExtensionRestoreOriginalTitlesPatch
import io.github.nexalloy.morphe.shared.misc.proto.hookElement
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.shared.misc.textcomponent.hookLithoSpannableString
import io.github.nexalloy.morphe.shared.misc.textcomponent.textComponentPatch
import io.github.nexalloy.morphe.youtube.misc.proto.elementProtoParserHookPatch
import io.github.nexalloy.morphe.youtube.misc.settings.PreferenceScreen
import io.github.nexalloy.morphe.youtube.video.videoid.VideoId
import io.github.nexalloy.morphe.youtube.video.videoid.videoIdHooks
import io.github.nexalloy.patch

val RestoreOriginalTitlesPatch = patch(
    name = "Restore original titles",
    description = "Adds an option to show the original video titles, video descriptions and channel descriptions instead of the auto-translated ones.",
) {
    dependsOn(
        textComponentPatch,
        elementProtoParserHookPatch,
        VideoId,
    )

    PreferenceScreen.FEED.addPreferences(
        SwitchPreference("morphe_restore_original_titles", summary = true)
    )

    hookElement(ExtensionRestoreOriginalTitlesPatch::restoreOriginalTitle)
    hookLithoSpannableString(ExtensionRestoreOriginalTitlesPatch::onLithoTextLoaded)

    videoIdHooks.add { videoId ->
        ExtensionRestoreOriginalTitlesPatch.newVideoLoaded(videoId)
    }
}
