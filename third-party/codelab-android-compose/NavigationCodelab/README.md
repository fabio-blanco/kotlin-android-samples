# Navigation in Jetpack Compose Codelab

This folder contains the source code for the
[Navigation in Jetpack Compose Codelab](https://developer.android.com/codelabs/jetpack-compose-navigation)
codelab.

[The original repository with the Codelab source code](https://github.com/android/codelab-android-compose).

## Useful notes from the Codelab study

- [Android App Navigation](https://developer.android.com/guide/navigation)
- [Navigation with Compose](https://developer.android.com/jetpack/compose/navigation)
- [Rally](https://m2.material.io/design/material-studies/rally.html) is a personal finance app
that uses Material Design components (from version 2) and Material Theming to create an on-brand experience with
data-driven aesthetic
- [NavController](https://developer.android.com/jetpack/compose/navigation?#getting-started) is the main
navigation component of Compose
- The [rememberNavController](https://developer.android.com/reference/kotlin/androidx/navigation/compose/package-summary#rememberNavController(kotlin.Array))
function creates and stores in memory a `NavController` that survive configuration changes by using 
[rememberSaveable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/package-summary#rememberSaveable(kotlin.Array,androidx.compose.runtime.saveable.Saver,kotlin.String,kotlin.Function0))
- The [NavHost](https://developer.android.com/jetpack/compose/navigation#create-navhost) links the `NavController`
with a navigation graph that specifies the composable destinations
- [NavGraph](https://developer.android.com/reference/androidx/navigation/NavGraph) is a navigation graph that
specifies the accessible destinations
- The `NavGraph` can be built by a [NavGraphBuilder](https://developer.android.com/guide/navigation/navigation-kotlin-dsl?hl=pt-br#navgraphbuilder)
- [Navigate to a composable](https://developer.android.com/jetpack/compose/navigation#nav-to-composable)
- [NavOptionsBuilder](https://developer.android.com/reference/kotlin/androidx/navigation/NavOptionsBuilder) 
can use some flags to control and customise the navigation behavior
- There is a [documentation that describes multiple backstacks support](https://developer.android.com/guide/navigation/multi-back-stacks)
if there is the need to manage more than one backstack
- [NavDestination](https://developer.android.com/reference/kotlin/androidx/navigation/NavDestination) represents
one node within an overall navigation graph
- [Navigate with arguments](https://developer.android.com/jetpack/compose/navigation#nav-with-args)
- `NavHost` has access to [NavBackStackEntry](https://developer.android.com/reference/kotlin/androidx/navigation/NavBackStackEntry),
a class that stores information about the actual rote and pass arguments from one backstack entry
- [Deep links](https://developer.android.com/jetpack/compose/navigation#deeplinks) and 
[how to create an implicit deep link](https://developer.android.com/guide/navigation/design/deep-link#implicit)
- It is possible to test if a deep link is working by using adb. See an example:
```shell
adb shell am start -d "rally://single_account/Checking" -a android.intent.action.VIEW
```
- [To know more about advanced tests with the navigation code](https://developer.android.com/guide/navigation/navigation-testing)
- To know more about other subjects and informations as the [integration of the navigation bar in the bottom of the
screen](https://developer.android.com/jetpack/compose/navigation#bottom-nav), navigation with many modules 
and [nested navigation](https://developer.android.com/jetpack/compose/navigation#nested-nav), see 
[the Now in Android Github repository](https://github.com/android/nowinandroid) and see how the implementation is done.

## License
```
Copyright 2022 The Android Open Source Project

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

