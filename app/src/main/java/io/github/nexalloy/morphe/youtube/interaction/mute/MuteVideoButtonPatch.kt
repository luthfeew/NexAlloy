package io.github.nexalloy.morphe.youtube.interaction.mute

import app.morphe.extension.youtube.videoplayer.MuteVideoButton
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.layout.buttons.overlay.addPlayerOverlayPreferences
import io.github.nexalloy.morphe.youtube.layout.player.buttons.addPlayerBottomButton
import io.github.nexalloy.morphe.youtube.layout.player.buttons.playerOverlayButtonsHook
import io.github.nexalloy.morphe.youtube.misc.playercontrols.LegacyPlayerControls
import io.github.nexalloy.patch

val MuteVideoButtonPatch = patch(
    name = "Mute button",
    description = "Adds an option to show a player button that mutes the video audio.",
) {
    dependsOn(
        LegacyPlayerControls,
        playerOverlayButtonsHook,
    )

    addPlayerOverlayPreferences(
        SwitchPreference("morphe_mute_video_button")
    )

    addPlayerBottomButton(MuteVideoButton::initializeButton)
}
