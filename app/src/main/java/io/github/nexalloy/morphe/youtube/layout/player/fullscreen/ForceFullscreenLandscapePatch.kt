package io.github.nexalloy.morphe.youtube.layout.player.fullscreen

import app.morphe.extension.youtube.patches.ForceFullscreenLandscapePatch as ExtensionForceFullscreenLandscapePatch
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.misc.playertype.PlayerTypeFingerprint
import io.github.nexalloy.morphe.youtube.misc.playertype.PlayerTypeHook
import io.github.nexalloy.morphe.youtube.misc.settings.PreferenceScreen
import io.github.nexalloy.patch

val ForceFullscreenLandscapePatch = patch(
    name = "Force fullscreen landscape",
    description = "Adds an option to rotate the player to landscape when entering fullscreen mode on tablets and other large screen devices.",
) {
    dependsOn(PlayerTypeHook)

    PreferenceScreen.PLAYER.addPreferences(
        SwitchPreference("morphe_force_fullscreen_landscape", summary = true)
    )

    PlayerTypeFingerprint.hookMethod {
        before { param ->
            ExtensionForceFullscreenLandscapePatch.onPlayerTypeChanged(param.args[0] as? Enum<*>)
        }
    }
}
