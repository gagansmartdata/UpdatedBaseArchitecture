//use this viewModel if you need to maintain any state for the activity.
abstract class GViewModel<S> : ViewModel() {
    protected abstract val mutableState: MutableStateFlow<S>

    fun state(): StateFlow<S> = mutableState.readOnly()
    protected fun stateVal(): S = state().value

  //use this function to update state for any activity from viewmodel
    protected suspend fun updateState(update: suspend (S) -> S) {
        mutableState.value = update(stateVal())
    }

    protected fun updateStateNonBlocking(update: (S) -> S) {
        mutableState.value = update(stateVal())
    }
}
