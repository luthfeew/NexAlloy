package io.github.nexalloy.morphe.youtube.layout.scrolling

import app.morphe.extension.youtube.patches.DisableScrollSpeedLimitPatch as ExtensionDisableScrollSpeedLimitPatch
import io.github.nexalloy.morphe.shared.misc.settings.preference.SwitchPreference
import io.github.nexalloy.morphe.youtube.misc.playservice.is_20_35_or_greater
import io.github.nexalloy.morphe.youtube.misc.playservice.VersionCheck
import io.github.nexalloy.morphe.youtube.misc.settings.PreferenceScreen
import io.github.nexalloy.patch
import org.luckypray.dexkit.wrap.DexMethod

val DisableScrollSpeedLimitPatch = patch(
    name = "Disable scrolling speed limit",
    description = "Adds an option to remove limits of how fast the home and subscription feed can be scrolled.",
) {
    dependsOn(VersionCheck)

    if (!is_20_35_or_greater) {
        return@patch
    }

    PreferenceScreen.MISC.addPreferences(
        SwitchPreference("morphe_disable_scrolling_speed_limit")
    )

    DexMethod("Lcom/google/android/apps/youtube/app/common/rendering/SnappyRecyclerView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V").hookMethod {
        after {
            val view = it.thisObject
            view::class.java.declaredFields.filter { f -> f.type == java.lang.Boolean.TYPE }.forEach { field ->
                field.isAccessible = true
                field.setBoolean(view, ExtensionDisableScrollSpeedLimitPatch.disableSpeedScrolling(field.getBoolean(view)))
            }
        }
    }
}
