# Get started with state Codelab

This app is the result of following the [State in Jetpack Compose Codelab](https://developer.android.com/codelabs/jetpack-compose-state)
This is one of the steps of the [Jetpack Compose official course (pathways)](https://developer.android.com/courses/pathways/compose).

The solution source code is available on [this GitHub repository](https://github.com/android/codelab-android-compose).

## Useful notes from the course

- [State in Jetpack Compose code-along](https://youtu.be/PMMY23F0CFg?si=lx4_HEwM9XY2Ig85)
- [Thinking in Compose](https://developer.android.com/jetpack/compose/mental-model)
- Types [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State) and [MutableState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/MutableState)
allows to make the State observable
- The function [mutableStateOf](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#mutableStateOf(kotlin.Any,androidx.compose.runtime.SnapshotMutationPolicy))
can be used to create an observable `MutableState`
- The composable function [remember](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#remember(kotlin.Function0))
is used as a mechanism to store a unique object in the composition. Thus the stored value is maintained
between recompositions
- [rememberSaveable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/package-summary#rememberSaveable(kotlin.Array,androidx.compose.runtime.saveable.Saver,kotlin.String,kotlin.Function0))
does the same as remember but it also saves the state in a bundle if there is any configuration change when
the activity or process is recreated
- [State and Jetpack Compose](https://developer.android.com/jetpack/compose/state)
- The [documentation about states on Compose](https://developer.android.com/jetpack/compose/state#state-in-composables)
shows the three different ways to declare a `MutableState` inside a composable element. It also explains
about using the [delegate property](https://kotlinlang.org/docs/delegated-properties.html) `by` as a syntax sugar to produce a more readable code
- [Other libraries interoperation with Compose States](https://developer.android.com/jetpack/compose/libraries#streams)
- [Life cycle of the composable elements](https://developer.android.com/jetpack/compose/lifecycle#lifecycle-overview)
- [How to restore state on Compose](https://developer.android.com/jetpack/compose/state#restore-ui-state)
- [Unidirectional data flow](https://developer.android.com/jetpack/compose/architecture#udf-compose) Is 
an architectural design pattern where the state flows down and events flows up.
- [Documentation about state hoisting on Compose](https://developer.android.com/jetpack/compose/state#state-hoisting)
- [Data Layer](https://developer.android.com/jetpack/guide/data-layer)
- [How to react to scroll position on Lazy components](https://developer.android.com/jetpack/compose/lists?hl=pt-br#react-to-scroll-position)
- [LazyListState](https://developer.android.com/reference/kotlin/androidx/compose/foundation/lazy/LazyListState) is a
state that can be hoisted to control and observe scrolling
- [Scaffold](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#scaffold) and 
[rememberScaffoldState](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#rememberScaffoldState(androidx.compose.material.DrawerState,androidx.compose.material.SnackbarHostState))
- [Restoring state on Compose](https://developer.android.com/jetpack/compose/state#restore-ui-state)
- [Documentation about saving UI State](https://developer.android.com/topic/libraries/architecture/saving-states#onsaveinstancestate)
- [Options for preserving UI state](https://developer.android.com/topic/libraries/architecture/saving-states#options)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Navigating on Compose](https://developer.android.com/jetpack/compose/navigation)
- [Documentation from the UI layer](https://developer.android.com/jetpack/guide/ui-layer#define-ui-state) and its
architecture
- The composable function [viewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/viewmodel/compose/package-summary#viewModel(androidx.lifecycle.ViewModelStoreOwner,kotlin.String,androidx.lifecycle.ViewModelProvider.Factory,androidx.lifecycle.viewmodel.CreationExtras))
integrates a ViewModel to the Composable UI
- [About how to maintain the app UI state](https://developer.android.com/topic/libraries/architecture/saving-states)
- [ViewModels as state owners](https://developer.android.com/jetpack/compose/state-hoisting?hl=pt-br#viewmodels-as-state-owner)
- [ViewModels on the Documentation about Compose and other libraries](https://developer.android.com/jetpack/compose/libraries#viewmodel)

## License

This  code is available under the [MIT License](https://github.com/fabio-blanco/kotlin-android-samples/blob/main/LICENSE).