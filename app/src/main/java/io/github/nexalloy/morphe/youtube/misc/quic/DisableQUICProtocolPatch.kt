package io.github.nexalloy.morphe.youtube.misc.quic

import app.morphe.extension.shared.patches.DisableQUICProtocolPatch as ExtensionDisableQUICProtocolPatch
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.misc.settings.PreferenceScreen
import io.github.nexalloy.patch
import org.luckypray.dexkit.wrap.DexMethod

val DisableQUICProtocolPatch = patch(
    name = "Disable QUIC protocol",
    description = "Adds an option to disable QUIC (Quick UDP Internet Connections) network protocol.",
) {
    PreferenceScreen.MISC.addPreferences(
        SwitchPreference("morphe_disable_quic_protocol")
    )

    DexMethod("Lorg/chromium/net/CronetEngine\$Builder;->enableQuic(Z)Lorg/chromium/net/CronetEngine\$Builder;").hookMethod {
        before {
            it.args[0] = ExtensionDisableQUICProtocolPatch.disableQUICProtocol(it.args[0] as Boolean)
        }
    }
    DexMethod("Lorg/chromium/net/ExperimentalCronetEngine\$Builder;->enableQuic(Z)Lorg/chromium/net/ExperimentalCronetEngine\$Builder;").hookMethod {
        before {
            it.args[0] = ExtensionDisableQUICProtocolPatch.disableQUICProtocol(it.args[0] as Boolean)
        }
    }
}
