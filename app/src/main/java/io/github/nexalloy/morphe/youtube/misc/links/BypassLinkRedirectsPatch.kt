package io.github.nexalloy.morphe.youtube.misc.links

import android.net.Uri
import app.morphe.extension.youtube.patches.BypassLinkRedirectsPatch as ExtensionBypassLinkRedirectsPatch
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.misc.settings.PreferenceScreen
import io.github.nexalloy.patch
import org.luckypray.dexkit.wrap.DexMethod

val BypassLinkRedirectsPatch = patch(
    name = "Bypass link redirects",
    description = "Adds an option to bypass redirects and open the original link directly.",
) {
    PreferenceScreen.MISC.addPreferences(
        SwitchPreference("morphe_bypass_link_redirects", summary = true),
    )

    DexMethod("Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V").hookMethod {
        before {
            val uri = it.args[1] as? Uri ?: return@before
            it.args[1] = ExtensionBypassLinkRedirectsPatch.parseRedirectUri(uri)
        }
    }

    DexMethod("Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;").hookMethod {
        before {
            val uri = it.args[0] as? Uri ?: return@before
            it.args[0] = ExtensionBypassLinkRedirectsPatch.parseRedirectUri(uri)
        }
    }
}
