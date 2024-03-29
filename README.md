# Kotlin Android Samples

This is a collection of Android projects that I maintain mainly for personal use for remembering some technique or code usage guideline. It is basically a collection of samples.

Some of the sample projects in this repository were obtained from third parties and
adjusted to my needs. For those projects the original license was maintained and mentioned in the proper project README.

## Android app Modularization

Modularization is an architectural strategy utilized to improve the maintainability of a software project, specially when a project starts to grow larger or if there are
more than one team involved in parts of its development.

- [Modularized Sample App](/ModularizedSample/) - A sample on how to create a modularized project for an Android app using the Version Catalog and Convention Plugins features
of the Gradle build automation tool

## Build variants - Flavors

Flavors are used to provide different "flavors" of the same app. A good example is a "free" and a "pro" version of the same app.

- [Buy Me a Drink App](/BuyMeADrink/) - A Sample on how to create an App with "free" and "pro" versions by using the flavors configurations.
The free versions has adds banners while the pro version is adds free and also has a premium functionality that is not available on the free version.

## Dependency Injection

- [Using Hilt in your Android app Codelab - LoggingApp](/third-party/codelab-android-hilt/) - [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) is 
a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection on an Android project. It is built on top of the popular DI 
library [Dagger](https://developer.android.com/training/dependency-injection/dagger-basics). This app is the result of my implementation of this Codelab.

## Jetpack Compose

- [Compose Tutorial App](/ComposeTutorial/)

### Jetpack Compose Pathways study

Projects developed by following the [Jetpack Compose Pathways Course](https://developer.android.com/courses/pathways/compose) and its Codelabs

- [Basics Codelab](/jetpack-compose-pathways/BasicsCodelab/)
- [Migration Codelab](/third-party/codelab-android-compose/MigrationCodelab/)
- [Basic Layouts on Compose Codelab - MySoothe App](/third-party/codelab-android-compose/BasicLayoutsCodelab/)
- [Theming in Compose with Material 3 Codelab - Reply](/third-party/codelab-android-compose/ThemingCodelab/)
- [Jetpack Compose Animations Codelab](/third-party/codelab-android-compose/AnimationCodelab/)
- [State on Jetpack Compose Codelab](/jetpack-compose-pathways/ComposeBasicStateCodelab/)
- [Advanced State and Collateral Effects on Jetpack Compose Codelab - Crane Material Study App](/third-party/codelab-android-compose/AdvancedStateAndSideEffectsCodelab/)
- [Jetpack Compose Navigation Codelab - Rally App](/third-party/codelab-android-compose/NavigationCodelab/)
- [Testing in Jetpack Compose Codelab - Rally App](/third-party/codelab-android-compose/TestingCodelab/)
- [Accessibility in Jetpack Compose Codelab - JetNews App](/third-party/codelab-android-compose/AccessibilityCodelab/)

### Multiple Floating Action Button

- [MultipleFab App](/MultipleFab/) - a Sample on how to create a Multiple Floating Action Button, a Fab that cam be expanded to display multiple inner Fabs. Each one with its
own Action.

## Udacity Course - Developing Android Apps With Kotlin

Projects developed by following the [Udacity course](https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012)

- **Module 1 - Build your First App**
  - [Dice Roller](/DiceRollerXml/)
- **Module 2 - Layouts**
  - [About Me](/AboutMe/)
  - [Color My Views](/ColorMyViews/)
- **Module 3 - App Navigation**
  - [Android Trivia](/third-party/andfun-kotlin-android-trivia/)
- **Module 4 - Activity & Fragment Lifecycle** - Activities and Fragment Lifecycle, Log and Timber, Using adb, basic on saving and recovering app state
  - [Dessert Pusher](/third-party/andfun-kotlin-dessert-pusher/)
- **Module 5 - App Architecture (UI Layer)** - MVVM, ViewModel, Ways to save app state, LiveData, Data binding, Formatting Strings, Transformations, Vibration on Android, Android Permissions, Android Apps Architecture
  - [Guess it](/third-party/andfun-kotlin-guess-it/)
- **Module 6 - App Architecture (Persistence)** - Room, Companion Objects, Testing Apps on Android, Reusing Layouts (Tags Merge and Include), Coroutines, Back and up navigation, Bind layout views to Architecture Components
  - [Sleep Tracker](/third-party/andfun-kotlin-sleep-tracker/)
- **Module 7 - RecyclerView**
  - [Sleep Tracker W](/third-party/andfun-kotlin-sleep-tracker-recyclerview)
  - Branches of the exercises evolution:
    - Step 1 - [An Introductory simple RecyclerView implementation](https://github.com/fabio-blanco/kotlin-android-samples/tree/feat/sleep-tracker-recyclerview-simple)
    - Step 2 - [Changed the RecyclerView to use a ListAdapter](https://github.com/fabio-blanco/kotlin-android-samples/tree/feat/sleep-tracker-recyclerview-listadapter)
    - Step 3 - [Implemented databinding in the RecyclerView](https://github.com/fabio-blanco/kotlin-android-samples/tree/feat/sleep-tracker-recyclerview-databinding)
    - Step 4 - [Changed the RecyclerView to a GridLayout](https://github.com/fabio-blanco/kotlin-android-samples/tree/feat/sleep-tracker-recyclerview-gridlayout)
    - Step 5 - [Implemented item navigation on the RecyclerView](https://github.com/fabio-blanco/kotlin-android-samples/tree/feat/sleep-tracker-recyclerview-item-navigation)
    - Step 6 - [Added a header to the RecyclerView](https://github.com/fabio-blanco/kotlin-android-samples/tree/feat/sleep-tracker-recyclerview-header)
- **Module 8 - Connect to the Internet** - Retrofit library (http client), Glide library (Image loading), Connect to the Network, Android Permissions, Parcelable objects in bundles
  - [Mars Real Estate](/third-party/andfun-kotlin-mars-real-estate/)
- **Module 9 - Behind the Scenes** - How to implement an offline cache and how to implement background tasks with WorManager
  - [DevByte Viewer](/third-party/andfun-kotlin-dev-bytes/)
- **Module 10 - Designing for Everyone** - Themes, Styles, View Attributes, Design, Supporting different languages and cultures, RTL Support, Accessibility, Drawables, Dark Mode Support
  - [GDG Finder App](/third-party/andfun-kotlin-gdg-finder/)

## License

All my code produced for this repository is released under [MIT License](/LICENSE). 

Some of the projects are based on code obtained from third party. In this case, I respect the original license as mentioned on each project own README if appropriate. The original license will also be kept in the project directory for reference.