package com.example.mobiledevlabs.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object LoggingUtils {

    private const val TAG = "AppLogger"
    private val dateFormat = SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())

    private fun buildLogMessage(className: String, methodName: String, message: String): String {
        val time = dateFormat.format(Date())
        // Simplified class name by removing package path
        val simpleClassName = className.substringAfterLast('.')
        return "[$time] [$simpleClassName:$methodName] $message"
    }

    private fun getStackTraceElement(): StackTraceElement {
        // The magic index 4 is determined by the call stack:
        // 0: Thread.getStackTrace()
        // 1: LoggingUtils.getStackTraceElement()
        // 2: LoggingUtils.log() (or d, i, w, e)
        // 3: The actual method that called the logger
        // We need to find the first element outside of LoggingUtils
        val stackTrace = Thread.currentThread().stackTrace
        for (i in 3 until stackTrace.size) {
            if (stackTrace[i].className != LoggingUtils::class.java.name) {
                return stackTrace[i]
            }
        }
        // Fallback to a default value if something goes wrong
        return StackTraceElement("UnknownClass", "UnknownMethod", "UnknownFile", -1)
    }

    fun d(message: String) {
        val stackTraceElement = getStackTraceElement()
        val className = stackTraceElement.className
        val methodName = stackTraceElement.methodName
        Log.d(TAG, buildLogMessage(className, methodName, message))
    }

    fun i(message: String) {
        val stackTraceElement = getStackTraceElement()
        val className = stackTraceElement.className
        val methodName = stackTraceElement.methodName
        Log.i(TAG, buildLogMessage(className, methodName, message))
    }

    fun w(message: String) {
        val stackTraceElement = getStackTraceElement()
        val className = stackTraceElement.className
        val methodName = stackTraceElement.methodName
        Log.w(TAG, buildLogMessage(className, methodName, message))
    }

    fun e(message: String, throwable: Throwable? = null) {
        val stackTraceElement = getStackTraceElement()
        val className = stackTraceElement.className
        val methodName = stackTraceElement.methodName
        if (throwable != null) {
            Log.e(TAG, buildLogMessage(className, methodName, message), throwable)
        } else {
            Log.e(TAG, buildLogMessage(className, methodName, message))
        }
    }
}
