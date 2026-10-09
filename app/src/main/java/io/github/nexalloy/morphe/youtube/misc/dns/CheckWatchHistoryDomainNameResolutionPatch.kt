package io.github.nexalloy.morphe.youtube.misc.dns

import android.app.Activity
import app.morphe.extension.shared.patches.CheckWatchHistoryDomainNameResolutionPatch as ExtensionCheckWatchHistoryPatch
import io.github.nexalloy.morphe.youtube.shared.YOUTUBE_MAIN_ACTIVITY_CLASS_TYPE
import io.github.nexalloy.patch
import org.luckypray.dexkit.wrap.DexMethod

val CheckWatchHistoryDomainNameResolutionPatch = patch(
    name = "Check watch history domain name resolution",
    description = "Checks if the device DNS server is preventing user watch history from being saved.",
) {
    DexMethod("$YOUTUBE_MAIN_ACTIVITY_CLASS_TYPE->onCreate(Landroid/os/Bundle;)V").hookMethod {
        after {
            val mainActivity = it.thisObject as? Activity ?: return@after
            ExtensionCheckWatchHistoryPatch.checkDnsResolver(mainActivity)
        }
    }
}
