package io.github.nexalloy.morphe.shared.misc.textcomponent

import app.morphe.extension.shared.patches.components.ContextInterface
import io.github.nexalloy.morphe.shared.SpannableStringBuilderFingerprint
import io.github.nexalloy.morphe.shared.misc.litho.context.ConversionContext
import io.github.nexalloy.morphe.shared.spannableStringBuilderGetSpannedMethod
import io.github.nexalloy.patch

val textComponentPatch = patch(
    description = "Provides hooks into text components for extension filtering."
) {
    SpannableStringBuilderFingerprint.hookMethod {
        val getSpannedMethod = ::spannableStringBuilderGetSpannedMethod.method
        after {
            val result = it.result as? CharSequence ?: return@after
            if (result.isEmpty())
                return@after

            val spannedContext = it.args[0]
            val conversionContext = ConversionContext(spannedContext)
            val spanned = getSpannedMethod(it.args[2]) as String
            // TODO EmojiCompat.process(spanned)
            hooks.forEach { hook -> hook(conversionContext, spanned) }

            var currentResult = result
            overrides.forEach { override ->
                currentResult = override(conversionContext, currentResult)
            }
            it.result = currentResult
        }
    }
}

private val hooks = mutableListOf<(ContextInterface, CharSequence) -> Unit>()
private val overrides = mutableListOf<(ContextInterface, CharSequence) -> CharSequence>()

internal fun hookSpannableString(
    hook: (ContextInterface, CharSequence) -> Unit,
) {
    hooks.add { a, b -> hook(a, b) }
}

fun hookLithoSpannableString(
    hook: (ContextInterface, CharSequence) -> CharSequence,
) {
    overrides.add(hook)
}