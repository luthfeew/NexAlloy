package io.github.nexalloy.morphe.youtube.interaction.pip

import app.morphe.extension.youtube.videoplayer.PipButton
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.layout.buttons.overlay.addPlayerOverlayPreferences
import io.github.nexalloy.morphe.youtube.layout.player.buttons.addPlayerBottomButton
import io.github.nexalloy.morphe.youtube.layout.player.buttons.playerOverlayButtonsHook
import io.github.nexalloy.morphe.youtube.misc.playercontrols.LegacyPlayerControls
import io.github.nexalloy.patch

val PipButtonPatch = patch(
    name = "Picture-in-picture button",
    description = "Adds an option to display a picture-in-picture button in the video player.",
) {
    dependsOn(
        LegacyPlayerControls,
        playerOverlayButtonsHook,
    )

    addPlayerOverlayPreferences(
        SwitchPreference("morphe_pip_button_overlay", summary = true)
    )

    addPlayerBottomButton(PipButton::initializeLegacyButton)
}
