# Migrating to Jetpack Compose

This folder contains the source code for the [Migrating to Jetpack Compose codelab](https://developer.android.com/codelabs/jetpack-compose-migration).

The codelab which migrates parts of [Sunflower](https://github.com/android/sunflower)'s Plant
details screen to Jetpack Compose is built in multiple GitHub branches in the [original repository](https://github.com/android/codelab-android-compose):

* `main` is the codelab's starting point.
* `end` contains the solution to this codelab.

In the present repository this is just my execution of the proposed Codelab exercises. Please see the
[original repository](https://github.com/android/codelab-android-compose) if you want the original files.

## Pre-requisites
* Experience with Kotlin syntax, including lambdas.
* Knowing the [basics of Compose](https://developer.android.com/codelabs/jetpack-compose-basics/).

## Getting Started
1. Install the latest Android Studio [canary](https://developer.android.com/studio/preview/).
2. Download the sample.
3. Import the sample into Android Studio.
4. Build and run the sample.


## Screenshots

![List of plants](screenshots/phone_plant_list.png "A list of plants")
![Plant details](screenshots/phone_plant_detail.png "Details for a specific plant")
![My Garden](screenshots/phone_my_garden.png "Plants that have been added to your garden")

## Useful notes from the Codelab study

- [Ui state and hoist state](https://developer.android.com/jetpack/compose/state-hoisting#screen-ui)
- [Lifecycle of the composables](https://developer.android.com/jetpack/compose/lifecycle)
- [Lifecycle of the Fragment View](https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#getviewlifecycleowner)
- [setViewCompositionStrategy](https://developer.android.com/reference/kotlin/androidx/compose/ui/platform/AbstractComposeView#setViewCompositionStrategy(androidx.compose.ui.platform.ViewCompositionStrategy))
- [ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed](https://developer.android.com/reference/kotlin/androidx/compose/ui/platform/ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
- [ViewCompositionStrategy para ComposeView](https://developer.android.com/jetpack/compose/interop/interop-apis#composition-strategy) - 
it is recommended to always define the strategy when using ComposeView in fragments
- [Migrate existing View-based apps](https://developer.android.com/jetpack/compose/migrate)
- In this Codelab the efforts are focused in migrating the content of the plant detail fragment from the
view xml file to an equivalent jetpack compose code, including its tests. But the entire Migration from
View-based app (Material 2) to Jetpack Compose (Material 3) is available on 
[the following GitHub repository](https://github.com/android/sunflower).

## License

```
Copyright (C) 2020 The Android Open Source Project

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
```

Original license for [image and audio is CC BY 4.0 license](/third-party/codelab-android-compose/MigrationCodelab/ASSETS_LICENSE) and for [code is Apache v2](/third-party/codelab-android-compose/MigrationCodelab/LICENSE)
