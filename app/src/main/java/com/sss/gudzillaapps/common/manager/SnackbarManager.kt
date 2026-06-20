package com.sss.gudzillaapps.common.manager

import com.sss.gudzillaapps.common.model.SnackbarData
import kotlinx.coroutines.flow.MutableSharedFlow

object SnackbarManager {
    val snackbarFlow = MutableSharedFlow<SnackbarData>(
        replay = 0,
        extraBufferCapacity = 1
    )

    suspend fun showSnackbar(data: SnackbarData) {
        snackbarFlow.emit(data)
    }
}