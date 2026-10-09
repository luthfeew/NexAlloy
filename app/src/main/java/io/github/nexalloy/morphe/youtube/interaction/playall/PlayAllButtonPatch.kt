package io.github.nexalloy.morphe.youtube.interaction.playall

import app.morphe.extension.youtube.videoplayer.PlayAllButton
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.layout.buttons.overlay.addPlayerOverlayPreferences
import io.github.nexalloy.morphe.youtube.layout.player.buttons.addPlayerBottomButton
import io.github.nexalloy.morphe.youtube.layout.player.buttons.playerOverlayButtonsHook
import io.github.nexalloy.morphe.youtube.misc.playercontrols.LegacyPlayerControls
import io.github.nexalloy.patch

val PlayAllButtonPatch = patch(
    name = "Play all",
    description = "Adds an option to play all the videos from a channel and to display play all button in the video player.",
) {
    dependsOn(
        LegacyPlayerControls,
        playerOverlayButtonsHook,
    )

    addPlayerOverlayPreferences(
        SwitchPreference("morphe_play_all_button", summary = true)
    )

    addPlayerBottomButton(PlayAllButton::initializeLegacyButton)
}
