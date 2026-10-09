package io.github.nexalloy.morphe.youtube.interaction.loop

import app.morphe.extension.youtube.patches.LoopVideoPatch as ExtensionLoopVideoPatch
import app.morphe.extension.youtube.videoplayer.LoopVideoButton
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.layout.buttons.overlay.addPlayerOverlayPreferences
import io.github.nexalloy.morphe.youtube.layout.player.buttons.addPlayerBottomButton
import io.github.nexalloy.morphe.youtube.layout.player.buttons.playerOverlayButtonsHook
import io.github.nexalloy.morphe.youtube.misc.playercontrols.LegacyPlayerControls
import io.github.nexalloy.morphe.youtube.misc.playertype.PlayerTypeHook
import io.github.nexalloy.morphe.youtube.misc.playertype.videoStateFingerprint
import io.github.nexalloy.morphe.youtube.misc.playertype.videoStateParameterField
import io.github.nexalloy.morphe.youtube.misc.settings.PreferenceScreen
import io.github.nexalloy.morphe.youtube.video.information.VideoInformationPatch
import io.github.nexalloy.morphe.youtube.video.information.videoTimeHooks
import io.github.nexalloy.patch

val LoopVideoPatch = patch(
    name = "Loop video",
    description = "Adds an option to loop videos and display loop video button in the video player.",
) {
    dependsOn(
        LegacyPlayerControls,
        playerOverlayButtonsHook,
        VideoInformationPatch,
        PlayerTypeHook,
    )

    PreferenceScreen.PLAYER.addPreferences(
        SwitchPreference("morphe_loop_video"),
        SwitchPreference("morphe_do_not_remember_loop_video", summary = true)
    )

    addPlayerOverlayPreferences(
        SwitchPreference("morphe_loop_video_button")
    )
    addPlayerBottomButton(LoopVideoButton::initializeLegacyButton)

    videoTimeHooks.add { time ->
        ExtensionLoopVideoPatch.videoTimeChanged(time)
    }

    ::videoStateFingerprint.hookMethod {
        val field = ::videoStateParameterField.field
        before { param ->
            val status = field.get(param.args[0]) as Enum<*>
            ExtensionLoopVideoPatch.shouldLoopVideo(status)
        }
    }
}
