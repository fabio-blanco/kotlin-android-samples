# Modularized Sample

This is a sample App that shows how to create a modularized Android App.

It was heavily inspired by [Now In Android App Sample](https://github.com/android/nowinandroid). But it 
was designed to be simpler and the external dependencies minimized to focus on the modularization aspects.

## Project Structure

| Module             | Description                                                                                                                                               |
|--------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| :app               | Serves as the central peace that glues everything together                                                                                                |
| :core:designsystem | Design system which includes Core UI components (many of which are customized Material 3 components), app theme and icons.                                |
| :core:ui           | Composite UI components and resources used by feature modules. Unlike the designsystem module, it is dependent on the data layer since it renders models. |
| :core:model        | Model classes used throughout the app. Those classes are the base model from the app domain.                                                              |
| :core:data         | Code used to fetch data used by the application.                                                                                                          |
| :feature:note      | Implementation of the functionality that enables note creation, exclusion and update.                                                                     |
| :feature:check     | Implementation of the functionality that enables checking or unchecking todo notes.                                                                       |
| :feature:home      | Implementation of the functionality of the home page that displays the plain notes and the TODOs.                                                         |

The module organization of this project was based on the now in android app as described in its 
[modularization learning journey](https://github.com/android/nowinandroid/blob/main/docs/ModularizationLearningJourney.md?source=post_page-----d89cc8698104--------------------------------)
but, as a didactic effort, unecessary module creation was avoided. It is a good practice to create a new module
only when there is a real need for it. As an example, if I were to implement code to store data on a database
I could create a `core:database` module to keep the database handling logic as in the now in android app.

### The `build-logic` sub-project

The build logic sub-project contains all the logic and the gradle convention plugins used to separate the
different modules and control it's dependencies.
It is included in the main project build with the following instruction on the `settings.gradle.kts` file:

```kotlin
pluginManagement {
    includeBuild("build-logic")
    ...
}
```

## What do I need to previously study in order to understand this sample project?

- Jetpack compose basics
- [Dependency injection with Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- Gradle version catalogs and Convention Plugins (take a look at the useful links section below)
- Although not strictly necessary it is useful to have some comprehension on kotlin coroutine

## Useful links

- [Guide to Android App Modularization](https://developer.android.com/topic/modularization)
- [Video: Building a Modularized App from Scratch](https://youtu.be/qX6zmKY4KP0?si=OI46HXOznAnRJ5P9)
- [About Gradle Convention Plugins](https://medium.com/@yudistirosaputro/gradle-convention-plugins-a-powerful-tool-for-reusing-build-configuration-ba2b250d9063)
- [Squares case on Gradle Convention Plugin utilization](https://developer.squareup.com/blog/herding-elephants/)
- [Understanding Gradle Sample Projects and Information](https://github.com/jjohannes/understanding-gradle/tree/main)
- [Example of how to idiomatically structure a large build with Gradle 7.2+](https://github.com/jjohannes/idiomatic-gradle)
- [Gradle Version Catalogs](https://docs.gradle.org/current/userguide/platforms.html)
- [Now In Android](https://github.com/android/nowinandroid): A modularized Sample App from the Android team.
- [Juliana Santos study of modularization on Now In Android App](https://medium.com/@julia.santos.moura.1201/studying-now-in-android-app-modularization-d89cc8698104)
- [Modularization Patterns](https://developer.android.com/topic/modularization/patterns)
- [Merge multiple Manifest Files](https://developer.android.com/build/manage-manifests#merge-manifests) -
If a project has many modules with Manifest files they will be merged by Android Studio when building the
final APK or Android App Bundle.