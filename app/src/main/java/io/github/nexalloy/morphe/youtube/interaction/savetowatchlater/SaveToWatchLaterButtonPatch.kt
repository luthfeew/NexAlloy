package io.github.nexalloy.morphe.youtube.interaction.savetowatchlater

import app.morphe.extension.youtube.videoplayer.SaveToWatchLaterButton
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.layout.buttons.overlay.addPlayerOverlayPreferences
import io.github.nexalloy.morphe.youtube.layout.player.buttons.addPlayerBottomButton
import io.github.nexalloy.morphe.youtube.layout.player.buttons.playerOverlayButtonsHook
import io.github.nexalloy.morphe.youtube.misc.playercontrols.LegacyPlayerControls
import io.github.nexalloy.patch

val SaveToWatchLaterButtonPatch = patch(
    name = "Save to Watch later",
    description = "Adds an option to display save to Watch later button in the video player.",
) {
    dependsOn(
        LegacyPlayerControls,
        playerOverlayButtonsHook,
    )

    addPlayerOverlayPreferences(
        SwitchPreference("morphe_save_to_watch_later_overlay_button", summary = true),
        SwitchPreference("morphe_swap_save_and_queue_actions", summary = true)
    )

    addPlayerBottomButton(SaveToWatchLaterButton::initializeLegacyButton)
}
