package quanti.com.kotlinlog.utils

/**
 * Created by Trnka Vladislav on 11.09.2017.
 *
 * TODO: description
 */

fun Throwable.convertToLogCatString(): String { //todo add surpressed and other shiots ???

    val sb = StringBuilder()

    sb.append(this.toString())
    sb.append("\n")

    this.stackTrace.forEach {
        sb.append("\t\t\t\t")
        if (it.isNativeMethod)
            sb.append("\t")
        sb.append(it.className)
        sb.append(".")
        sb.append(it.methodName)
        sb.append("(")
        sb.append(it.fileName)
        sb.append(":")
        sb.append(it.lineNumber.toString())
        sb.append(")")
        sb.append("\n")
    }

    return sb.toString()

}