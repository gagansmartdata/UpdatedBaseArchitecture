package com.ggn.updatedbasearchitecture.base

/**
 * Base data class for UI state
 */
data class UIState<G>(
    val isLoading: Boolean = false,
    val data: G? = null,
    val error: String = ""
)

