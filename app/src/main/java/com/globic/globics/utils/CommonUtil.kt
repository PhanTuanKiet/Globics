package com.globic.globics.utils

import android.text.TextUtils
import android.util.Patterns
import java.util.*

class CommonUtil {

    companion object {
        val ISO8601_DATE_TIME_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss.000'Z'"
    }

    fun isValidEmail(email: CharSequence?): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun getFormatDateTime(birthDate: String): String? {
        var birthDate = birthDate
        if (TextUtils.isEmpty(birthDate)) return ""
        if (birthDate.contains("/")) return birthDate
        if (birthDate.contains("T")) birthDate = birthDate.split("T").toTypedArray()[0]
        val sArray = birthDate.split("-").toTypedArray()
        return String.format(
            Locale.getDefault(),
            "%s/%s/%s",
            sArray[1],
            sArray[2],
            sArray[0]
        )
    }

}