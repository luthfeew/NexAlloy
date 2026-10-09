package io.github.nexalloy.morphe.youtube.misc.links

import app.morphe.extension.youtube.patches.OpenLinksExternallyPatch as ExtensionOpenLinksExternallyPatch
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.misc.settings.PreferenceScreen
import io.github.nexalloy.patch
import org.luckypray.dexkit.wrap.DexMethod

val OpenLinksExternallyPatch = patch(
    name = "Open links externally",
    description = "Adds an option to always open links in your browser instead of with the in-app browser.",
) {
    PreferenceScreen.MISC.addPreferences(
        SwitchPreference("morphe_external_browser", summary = true),
    )

    DexMethod("Landroid/content/Intent;-><init>(Ljava/lang/String;)V").hookMethod {
        before {
            if (it.args[0] == "android.support.customtabs.action.CustomTabsService") {
                it.args[0] = ExtensionOpenLinksExternallyPatch.getIntent(it.args[0] as String)
            }
        }
    }

    DexMethod("Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;").hookMethod {
        before {
            if (it.args[0] == "android.support.customtabs.action.CustomTabsService") {
                it.args[0] = ExtensionOpenLinksExternallyPatch.getIntent(it.args[0] as String)
            }
        }
    }
}
