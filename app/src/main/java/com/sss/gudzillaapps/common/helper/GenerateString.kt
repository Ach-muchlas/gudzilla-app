package com.sss.gudzillaapps.common.helper

import java.util.UUID

object GenerateString {
    fun generateRandomId(): String {
        return UUID.randomUUID().toString()
    }

}