package com.ggn.updatedbasearchitecture.common.compose_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
    fun CircularLoading(show : Boolean){
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        , horizontalArrangement = Arrangement.Center) {
            if (show) {
                CircularProgressIndicator()
            }
        }
    }