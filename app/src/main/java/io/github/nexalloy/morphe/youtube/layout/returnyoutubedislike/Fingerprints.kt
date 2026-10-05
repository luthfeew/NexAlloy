package io.github.nexalloy.morphe.youtube.layout.returnyoutubedislike

import io.github.nexalloy.morphe.AccessFlags
import io.github.nexalloy.morphe.Fingerprint
import io.github.nexalloy.morphe.InstructionLocation
import io.github.nexalloy.morphe.Opcode
import io.github.nexalloy.morphe.fieldAccess
import io.github.nexalloy.morphe.findClassDirect
import io.github.nexalloy.morphe.findFieldDirect
import io.github.nexalloy.morphe.findMethodDirect
import io.github.nexalloy.morphe.methodCall
import io.github.nexalloy.morphe.string

internal object EndpointServiceNameFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PROTECTED, AccessFlags.FINAL),
    parameters = listOf(),
    returnType = "L",
    filters = listOf(
        string("serviceName"),
        fieldAccess(
            opcode = Opcode.IGET_OBJECT,
            definingClass = "this",
            type = "Ljava/lang/String;"
        )
    )
)

internal object DislikeFingerprint : Fingerprint(
    returnType = "V",
    filters = listOf(
        string("like/dislike")
    )
)

internal fun requestParameterCheckFingerprint(definingClass: String) = Fingerprint(
    definingClass = definingClass,
    accessFlags = listOf(AccessFlags.PROTECTED, AccessFlags.FINAL),
    parameters = listOf(),
    filters = listOf(
        // playlistId
        fieldAccess(
            opcode = Opcode.IGET_OBJECT,
            type = "Ljava/lang/String;"
        ),
        methodCall(
            opcode = Opcode.INVOKE_VIRTUAL,
            smali = "Ljava/lang/String;->isEmpty()Z"
        ),
        // videoId
        fieldAccess(
            opcode = Opcode.IGET_OBJECT,
            type = "Ljava/lang/String;"
        )
    )
)

internal fun likeEndpointParserFingerprint(definingClass: String) = Fingerprint(
    definingClass = definingClass,
    returnType = "V",
    filters = listOf(
        fieldAccess(
            opcode = Opcode.SGET_OBJECT,
            location = InstructionLocation.MatchFirst()
        ),
        fieldAccess(
            opcode = Opcode.IPUT_OBJECT,
            definingClass = "this"
        ),
        string("")
    )
)

val likeEndpointParserClass = findClassDirect {
    DislikeFingerprint().declaredClass!!.superClass!!
}

val endPointServiceNameField = findFieldDirect {
    EndpointServiceNameFingerprint.instructionMatches.last().instruction.fieldRef!!
}

val videoIdField = findFieldDirect {
    val parserClass = likeEndpointParserClass()
    requestParameterCheckFingerprint(parserClass.descriptor)
        .instructionMatches.last().instruction.fieldRef!!
}

val likeEndpointParserMethod = findMethodDirect {
    val parserClass = likeEndpointParserClass()
    likeEndpointParserFingerprint(parserClass.descriptor).run()
}

val targetField = findFieldDirect {
    val parserClass = likeEndpointParserClass()
    likeEndpointParserFingerprint(parserClass.descriptor)
        .instructionMatches[1].instruction.fieldRef!!
}

internal object ComponentHostSetContentDescriptionFingerprint : Fingerprint(
    definingClass = "Lcom/facebook/litho/ComponentHost;",
    name = "setContentDescription",
    returnType = "V",
    parameters = listOf("Ljava/lang/CharSequence;")
)

internal object YogaSetWidthFingerprint : Fingerprint(
    definingClass = "Lcom/facebook/yoga/YogaNodeJNIBase;",
    returnType = "V",
    parameters = listOf("F"),
    filters = listOf(
        fieldAccess(
            opcode = Opcode.IGET_WIDE,
            definingClass = "this",
            type = "J"
        ),
        methodCall(
            definingClass = "Lcom/facebook/yoga/YogaNative;",
            name = "jni_YGNodeStyleSetWidthJNI",
        )
    )
)

val nativePointerField = findFieldDirect {
    YogaSetWidthFingerprint.instructionMatches.first().instruction.fieldRef!!
}
