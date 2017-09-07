package quanti.com.kotlinlog.base

/**
 * Created by Trnka Vladislav on 30.05.2017.
 *
 * Logger interface for derived logger
 */
interface ILogger {

    /**
     * Basic log
     */
    fun log(androidLogLevel: Int, tag: String, methodName: String, text: String)

    /**
     * Log error
     */
    fun logThrowable(androidLogLevel: Int, tag: String, methodName: String, text: String, t: Throwable)

}
