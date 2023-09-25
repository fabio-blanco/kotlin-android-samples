# Application Architecture - The UI Layer - Guess It!
This is the toy app for lesson 5 of the [Android App Development in Kotlin course on Udacity](https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012).

Original code obtained from the [original github course repository](https://github.com/udacity/andfun-kotlin-guess-it/) and adapted as an exercise. The [original license](/third-party/andfun-kotlin-guess-it/LICENSE.txt) was maintained for this project.

## Guess It!

Guess It is a word guessing app you can play with one or more friends. To play, hold the device in landscape, facing away from you with your thumbs on the **Skip** and **Got It** buttons. Your friends can then give you clues to help you guess the word. 

If you get the word right, press **Got It**. If you're stuck, press **Skip**. The game runs for a minute and then shows you your score.


## Screenshots

![Screenshot 0](screenshots/screen0.png) ![Screenshot 1](screenshots/screen1.png) ![Screenshot 2](screenshots/screen2.png)

## How to use this repo while taking the course

Each code repository in this class has a chain of commits that looks like this:

![listofcommits](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58befe2e_listofcommits/listofcommits.png)

These commits show every step you'll take to create the app. Each commit contains instructions for completing the step.

Each commit also has a **branch** associated with it of the same name as the commit message, as seen below:

![branches](https://d17h27t6h515a5.cloudfront.net/topher/2017/April/590390fe_branches-ud855/branches-ud855.png
)
Access all branches from this tab.

![listofbranches](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58befe76_listofbranches/listofbranches.png
)


![branchesdropdown](https://d17h27t6h515a5.cloudfront.net/topher/2017/April/590391a3_branches-dropdown-ud855/branches-dropdown-ud855.png
)

The branches are also accessible from the drop-down in the "Code" tab.


## Working with the Course Code

Here are the basic steps for working with and completing exercises in the repo.

The basic steps are:

1. Clone the repo.
2. `checkout` the branch corresponding to the step you want to attempt.
3. Find and complete the TODOs.
4. Optionally commit your code changes.
5. Compare your code with the solution.
6. Repeat steps 2-5 until you've gone trough all the steps to complete the toy app.


**Step 1: Clone the repo**

As you go through the course, you'll be instructed to clone the different exercise repositories, so you don't need to set these up now. You can clone a repository from GitHub in a folder of your choice with the command:

```bash
git clone https://github.com/udacity/REPOSITORY_NAME.git
```

**Step 2: Check out the step branch**

As you go through different steps in the code, you'll be told which step you're on, as well as given a link to the corresponding branch.

Check out the branch associated with that step. The command to check out a branch is:

```bash
git checkout BRANCH_NAME
```

**Step 3: Find and complete the TODOs**

Once you've checked out the branch, you'll have the code in the exact state you need. You'll even have TODOs, which are special comments that tell you all the steps you need to complete the exercise. You can navigate to all the TODOs using Android Studio's TODO tool. To open the TODO tool, click the button at the bottom of the screen that says TODO. This will display a list of all comments with TODO in the project. 

We've numbered the TODO steps so you can do them in order:
![todos](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58bf00e7_todos/todos.png
)

**Step 4: Commit your code changes**

After you've completed the TODOs, you can optionally commit your changes. This will allow you to see the code you wrote whenever you return to the branch. The following git code will add and save **all** your changes.

```bash
git add .
git commit -m "Your commit message"
```

**Step 5: Compare with the solution**

Most exercises will have a list of steps for you to check off in the classroom. Once you've checked these off, you'll see a pop up window with a link to the solution code. Note the **Diff** link after the Solution link:

![solutionwindow](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58bf00f9_solutionwindow/solutionwindow.png
)

The **Diff** link will take you to a GitHub diff as seen below:
![diff](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58bf0108_diffsceenshot/diffsceenshot.png
)

All of the code that was added in the solution is in green, and the removed code (which will usually be the TODO comments) is in red. 

You can also diff your local copy of the code with the corresponding branch as you are working on it:

```bash
git diff BRANCH_NAME
```

## Report Issues
Notice any issues with a repository? Please file a GitHub issue in the repository.

## Some interesting topics learnt

- MVVM Introduction
- ViewModel of the Android Lifecycle library:
  - [Documentation - ViewModel documentation](https://developer.android.com/topic/libraries/architecture/viewmodel)
  - [Documentation - ViewModel reference documentation](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel)
  - [Blog Post - ViewModels: A Simple Example](https://medium.com/androiddevelopers/viewmodels-a-simple-example-ed5ac416317e)
  - ViewModel and data binding
- [Android official documentation about ways to save the app state](https://developer.android.com/topic/libraries/architecture/saving-states)
- LiveData:
  - [Documentation - LiveData Overview](https://developer.android.com/topic/libraries/architecture/livedata)
  - [Documentation - LiveData reference documentation](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData)
  - [Talk - Fun with LiveData (Android Dev Summit '18)](https://www.youtube.com/watch?v=2rO4r-JOQtA)
  - LiveData should live inside ViewModel and be protected externally by using encapsulation
  - How to use LiveData to track state changes or events: ([Documentation - Use LiveData to notify the UI about data changes](https://developer.android.com/topic/libraries/data-binding/architecture#livedata))
- Data binding lifecycle aware
- [Documentation - Formatting strings](https://developer.android.com/guide/topics/resources/string-resource#formatting-strings)
- [Documentation - Using resources with data binding](https://developer.android.com/topic/libraries/data-binding/expressions#resources)
- Transformations:
  - [Documentation - Map Reference](https://developer.android.com/reference/androidx/lifecycle/Transformations#(androidx.lifecycle.LiveData).map(kotlin.Function1))
  - [Documentation - SwitchMap Reference](https://developer.android.com/reference/androidx/lifecycle/Transformations#(androidx.lifecycle.LiveData).switchMap(kotlin.Function1))
  - [Documentation - MediatorLiveData Reference](https://developer.android.com/reference/kotlin/androidx/lifecycle/MediatorLiveData)
- [Vibration on Android](https://developer.android.com/reference/android/os/Vibrator)
- [Android Permissions](https://developer.android.com/guide/topics/permissions/overview)
- Recommended resources to study more on Android Architecture:
  - [Code Sample - Android Architecture Blueprints](https://github.com/android/architecture-samples)
  - [Android Jetpack: What's new in Architecture Components (Google I/O '18)](https://www.youtube.com/watch?v=pErTyQpA390)
  - [Droidcon NYC 2016 - A Journey Through MV Wonderland (updated)](https://youtu.be/QrbhPcbZv0I?si=Dw0MSWI6w3xLqzgz)
  - [Blog Post - Android Architecture Patterns Part 2: Model-View-Presenter](https://medium.com/upday-devs/android-architecture-patterns-part-2-model-view-presenter-8a6faaae14a5)
  - [Documentation - Guide to App Architecture](https://developer.android.com/jetpack/docs/guide)
  - [Blog Post - Android and Architecture](https://android-developers.googleblog.com/2017/05/android-and-architecture.html)
  - `ViewModelProviders` deprecation:
    - Old deprecated way: `ViewModelProviders.of(this).get(GameViewModel::class.java)`
    - New way: `viewModel = ViewModelProvider(this)[GameViewModel::class.java]`

## License

[Original license for image and audio is CC BY 4.0 license and for code is Apache v2](/third-party/andfun-kotlin-guess-it/LICENSE.txt)