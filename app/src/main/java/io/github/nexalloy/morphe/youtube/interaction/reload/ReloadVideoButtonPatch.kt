package io.github.nexalloy.morphe.youtube.interaction.reload

import app.morphe.extension.youtube.videoplayer.ReloadVideoButton
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.layout.buttons.overlay.addPlayerOverlayPreferences
import io.github.nexalloy.morphe.youtube.layout.player.buttons.addPlayerBottomButton
import io.github.nexalloy.morphe.youtube.layout.player.buttons.playerOverlayButtonsHook
import io.github.nexalloy.morphe.youtube.misc.playercontrols.LegacyPlayerControls
import io.github.nexalloy.patch

val ReloadVideoButtonPatch = patch(
    name = "Reload video",
    description = "Adds an option to display reload video button in the video player.",
) {
    dependsOn(
        LegacyPlayerControls,
        playerOverlayButtonsHook,
    )

    addPlayerOverlayPreferences(
        SwitchPreference("morphe_reload_video_button", summary = true)
    )

    addPlayerBottomButton(ReloadVideoButton::initializeLegacyButton)
}
