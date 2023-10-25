# Advanced State in Jetpack Compose Codelab

This folder contains the source code for the
[Advanced State in Jetpack Compose Codelab](https://developer.android.com/codelabs/jetpack-compose-advanced-state-side-effects)
codelab.

The project is built in multiple git branches in the [original repository](https://github.com/android/codelab-android-compose):
* `main` – the starter code for this project, you will make changes to this to complete the codelab
* `end` – contains the solution to this codelab

[The original repository with the Codelab source code](https://github.com/android/codelab-android-compose).

## Useful notes from the Codelab study

- [Elements of the UI state production pipeline ](https://developer.android.com/topic/architecture/ui-layer/stateholders#elements-ui)
- [UI State Production](https://developer.android.com/topic/architecture/ui-layer/state-production)
- [StateFlow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/)
- [Consuming flows safely in Jetpack Compose](https://medium.com/androiddevelopers/consuming-flows-safely-in-jetpack-compose-cde014d0d5a3)
- [The difference between Android LiveData and Flow](https://firatgurgur.medium.com/understanding-the-differences-between-android-livedata-and-flow-92a89913d42b)
- [Dependency Injection with Hilt on Android apps](https://developer.android.com/training/dependency-injection/hilt-android)
- [Dagger](https://github.com/google/dagger) is a compile time dependency injector for Java and Android
- [Dagger Basics](https://developer.android.com/training/dependency-injection/dagger-basics)
- [How to use Dagger in Android apps](https://developer.android.com/training/dependency-injection/dagger-android)
- [LaunchedEffect](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#LaunchedEffect(kotlin.Any,kotlin.coroutines.SuspendFunction1))
is used to safely call suspension functions from within a composable element. It starts a collateral effect
with Compose coroutine scope
- [rememberUpdatedState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#rememberUpdatedState(kotlin.Any))
should be used when parameters or values computed during composition are referenced by a long-lived 
lambda or object expression
- [Lifecycle of composables](https://developer.android.com/jetpack/compose/lifecycle)
- [ScaffoldState](https://developer.android.com/reference/kotlin/androidx/compose/material/ScaffoldState)
- [DrawerState](https://developer.android.com/reference/kotlin/androidx/compose/material/DrawerState)
- [rememberSaveable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/package-summary#rememberSaveable(kotlin.Array,androidx.compose.runtime.saveable.Saver,kotlin.String,kotlin.Function0))
does the same as `remember` but the stored value also survive the recreations of processes and activities. This
is straightforward for objects that can be stored in a [Bundle](https://developer.android.com/reference/android/os/Bundle)
- [Saver](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/package-summary#Saver(kotlin.Function2,kotlin.Function1)) can
be used together with `rememberSaveable` when working with objects that can't be usually saved in a Bundle. The
`Saver` describes how an object can be converted into something that is [Saveable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/Saver)
- [listSaver](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/package-summary#listSaver(kotlin.Function2,kotlin.Function1)) or
[mapSaver](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/package-summary#mapSaver(kotlin.Function2,kotlin.Function1)) can 
be used to reduce the amount of code needed to implement [Saver](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/package-summary#Saver(kotlin.Function2,kotlin.Function1))
for some class
- [snapshotFlow](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#snapshotFlow(kotlin.Function0))
convert [State<T>](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State) objects from 
Compose into a [Flow](https://developer.android.com/kotlin/flow)
- [LifecycleEventObserver](https://developer.android.com/reference/androidx/lifecycle/LifecycleEventObserver) observer
that reacts to events from the [LifecycleOwner](https://developer.android.com/reference/androidx/lifecycle/LifecycleOwner)
of the Compose
- [DisposableEffect](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#DisposableEffect(kotlin.Any,kotlin.Function1))
is an API to use with collateral effects that need to be cleaned after the keys change or the compose function
go out of the composition
- [MapView](https://developers.google.com/android/reference/com/google/android/gms/maps/MapView) is a View which displays a 
map (with data obtained from the Google Maps service). It extends [FrameLayout](https://developer.android.com/reference/android/widget/FrameLayout.html).
In a real Compose app, a [Maps Compose library](https://developers.google.com/maps/documentation/android-sdk/maps-compose)
should be used instead
- [produceState](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#produceState(kotlin.Any,kotlin.coroutines.SuspendFunction1))
returns an observable [snapshot](https://developer.android.com/reference/kotlin/androidx/compose/runtime/snapshots/Snapshot) 
[State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State) that produces values over time
without a defined data source. It allows to convert to Compose state a state that does not originates from compose.
- [derivedStateOf](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#derivedStateOf(kotlin.Function0))
is used to avoid constant recalculation on Recompositions. A new calculation will be executed only when reading
[State.value](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State#value()) of the
derived state. `derivedStateOf` may be used when we need a compose State that is "derived" from another `State`

## [Optional] Google Maps SDK setup

Seeing the city on the MapView is not necessary to complete the codelab. However, if you want
to get the MapView to render on the screen, you need to get an API key as
the [documentation says](https://developers.google.com/maps/documentation/android-sdk/get-api-key),
and include it in the `local.properties` file as follows:

```
google.maps.key={insert_your_api_key_here}
```

When restricting the Key to Android apps, use `androidx.compose.samples.crane` as package name, and
`A0:BD:B3:B6:F0:C4:BE:90:C6:9D:5F:4C:1D:F0:90:80:7F:D7:FE:1F` as SHA-1 certificate fingerprint.

## License
```
Copyright 2021 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```