# Compose Animation Codelab

This folder contains the source code for the
[Compose Animation](https://developer.android.com/codelabs/android-compose-animation)
codelab.

In this codelab, you will learn how to use some Animation APIs in Jetpack Compose.

[The original repository with the Codelab source code](https://github.com/android/codelab-android-compose).

This project has a `start` and a `finished` modules. All my implementation of the exercises was made on the `start`
module.

## Useful notes from the Codelab study

- [Compose Animations](https://developer.android.com/jetpack/compose/animation)
- [Documentation about how to customize animations](https://developer.android.com/jetpack/compose/animation#customize-animations)
- [Documentation about gestures of the Compose](https://developer.android.com/jetpack/compose/gestures)
- [pointerInput](https://developer.android.com/reference/kotlin/androidx/compose/ui/input/pointer/package-summary#(androidx.compose.ui.Modifier).pointerInput(kotlin.Any,kotlin.coroutines.SuspendFunction1))
- [awaitPointerEventScope](https://developer.android.com/reference/kotlin/androidx/compose/ui/input/pointer/PointerInputScope#awaitPointerEventScope(kotlin.coroutines.SuspendFunction1))
- Animation Reference Documentation:
  - [AnimatedVisibility](https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#(androidx.compose.animation.core.Transition).AnimatedVisibility(kotlin.Function1,androidx.compose.ui.Modifier,androidx.compose.animation.EnterTransition,androidx.compose.animation.ExitTransition,kotlin.Function1))
  - [animateContentSize](https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#(androidx.compose.ui.Modifier).animateContentSize(androidx.compose.animation.core.FiniteAnimationSpec,kotlin.Function2))
  - [animateColorAsState](https://developer.android.com/reference/kotlin/androidx/compose/animation/package-summary#animateColorAsState(androidx.compose.ui.graphics.Color,androidx.compose.animation.core.AnimationSpec,kotlin.String,kotlin.Function1))
  - [updateTransition](https://developer.android.com/reference/kotlin/androidx/compose/animation/core/package-summary#updateTransition(kotlin.Any,kotlin.String))
  - [rememberInfiniteTransition](https://developer.android.com/reference/kotlin/androidx/compose/animation/core/package-summary#rememberInfiniteTransition())
  - [Animatable](https://developer.android.com/reference/kotlin/androidx/compose/animation/core/Animatable)
- [Video - Reimagine animations system for a delightful development experience with Jetpack Compose](https://youtu.be/Z_T1bVjhMLk?si=0X2-lMPORhy5fmYj)

## Screenshot

![Screenshot](screenshots/app.png)

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

Original license for [image and audio is CC BY 4.0 license](/third-party/codelab-android-compose/AnimationCodelab/ASSETS_LICENSE) and for [code is Apache v2](/third-party/codelab-android-compose/AnimationCodelab/LICENSE)