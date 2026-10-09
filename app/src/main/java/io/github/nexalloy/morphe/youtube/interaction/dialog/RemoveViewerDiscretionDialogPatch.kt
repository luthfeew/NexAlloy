package io.github.nexalloy.morphe.youtube.interaction.dialog

import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.misc.settings.PreferenceScreen
import io.github.nexalloy.patch

val RemoveViewerDiscretionDialogPatch = patch(
    name = "Remove viewer discretion dialog",
    description = "Adds an option to remove the dialog that appears when opening a video that has been age-restricted by accepting it automatically. This does not bypass the age restriction.",
) {
    PreferenceScreen.GENERAL.addPreferences(
        SwitchPreference("morphe_remove_viewer_discretion_dialog")
    )
}
