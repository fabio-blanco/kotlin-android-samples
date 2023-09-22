# Activity Lifecycle - DessertPusher 

This is the toy app for lesson 4 of the [Android App Development in Kotlin course on Udacity](https://classroom.udacity.com/courses/ud9012/lessons/e487c600-ed68-4576-a35a-12f211cf032e/concepts/6a155d63-8153-4a56-95cb-1dfdf06aa173).

Original code obtained from the [original github course repository](https://github.com/udacity/andfun-kotlin-dessert-pusher/) and adapted as an exercise. The original license was maintained for this project.

## DessertPusher

DessertPusher is a game about making desserts. Press the button, make a dessert, earn the big bucks.

This app is for exploring the [Activity Lifecycle callback methods](https://developer.android.com/guide/components/activities/activity-lifecycle) and the [Lifecycle](https://developer.android.com/reference/android/arch/lifecycle/Lifecycle) object.


## Screenshots

![Screenshot1](screenshots/screen0.png) ![Screenshot1](screenshots/screen1.png) ![Screenshot1](screenshots/screen2.png)

## How to use this repo while taking the course


Each code repository in this class has a chain of commits that looks like this:

![listofcommits](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58befe2e_listofcommits/listofcommits.png)

These commits show every step you'll take to create the app. Each commit contains instructions for completing the that step.

Each commit also has a **branch** associated with it of the same name as the commit message, seen below:

![branches](https://d17h27t6h515a5.cloudfront.net/topher/2017/April/590390fe_branches-ud855/branches-ud855.png
)
Access all branches from this tab

![listofbranches](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58befe76_listofbranches/listofbranches.png
)


![branchesdropdown](https://d17h27t6h515a5.cloudfront.net/topher/2017/April/590391a3_branches-dropdown-ud855/branches-dropdown-ud855.png
)

The branches are also accessible from the drop-down in the "Code" tab


## Working with the Course Code

Here are the basic steps for working with and completing exercises in the repo.

The basic steps are:

1. Clone the repo
2. Checkout the branch corresponding to the step you want to attempt
3. Find and complete the TODOs
4. Optionally commit your code changes
5. Compare your code with the solution
6. Repeat steps 2-5 until you've gone trough all the steps to complete the toy app


**Step 1: Clone the repo**

As you go through the course, you'll be instructed to clone the different exercise repositories, so you don't need to set these up now. You can clone a repository from github in a folder of your choice with the command:

```bash
git clone https://github.com/udacity/REPOSITORY_NAME.git
```

**Step 2: Checkout the step branch**

As you go through different steps in the code, you'll be told which step you're on, as well as a link to the corresponding branch.

You'll want to check out the branch associated with that step. The command to check out a branch would be:

```bash
git checkout BRANCH_NAME
```

**Step 3: Find and complete the TODOs**

Once you've checked out the branch, you'll have the code in the exact state you need. You'll even have TODOs, which are special comments that tell you all the steps you need to complete the exercise. You can easily navigate to all the TODOs using Android Studio's TODO tool. To open the TODO tool, click the button at the bottom of the screen that says TODO. This will display a list of all comments with TODO in the project. 

We've numbered the TODO steps so you can do them in order:
![todos](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58bf00e7_todos/todos.png
)

**Step 4: Commit your code changes**

After You've completed the TODOs, you can optionally commit your changes. This will allow you to see the code you wrote whenever you return to the branch. The following git code will add and save **all** your changes.

```bash
git add .
git commit -m "Your commit message"
```

**Step 5: Compare with the solution**

Most exercises will have a list of steps for you to check off in the classroom. Once you've checked these off, you'll see a pop up window with a link to the solution code. Note the **Diff** link:

![solutionwindow](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58bf00f9_solutionwindow/solutionwindow.png
)

The **Diff** link will take you to a Github diff as seen below:
![diff](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58bf0108_diffsceenshot/diffsceenshot.png
)

All of the code that was added in the solution is in green, and the removed code (which will usually be the TODO comments) is in red. 

You can also compare your code locally with the branch of the following step.

## Report Issues
Notice any issues with a repository? Please file a [github issue](https://github.com/udacity/andfun-kotlin-dessert-pusher/issues) in this repository.

## Some interesting topics learnt

- Android [Activities Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)
 and [Fragment Lifecycle](https://developer.android.com/guide/fragments/lifecycle)
  - A reference on Android Lifecycle is "The Android Lifecycle cheat sheet" blog posts:
[Part 1: Single Activity](https://medium.com/androiddevelopers/the-android-lifecycle-cheat-sheet-part-i-single-activities-e49fd3d202ab),
[Part 2: Multiple Activities](https://medium.com/androiddevelopers/the-android-lifecycle-cheat-sheet-part-ii-multiple-activities-a411fd139f24)
and [Part 3: Fragments](https://medium.com/androiddevelopers/the-android-lifecycle-cheat-sheet-part-iii-fragments-afc87d4f37fd)
- Using `Log` to investigate during debugging of the application (Probably better to use [Timber](https://medium.com/mindorks/better-logging-in-android-using-timber-72e40cc2293d))
- Using `Timber` to log instead of the default `Log` class
- `Application` class to setup a configuration for the entire app
- [Lifecycle Library introduction](https://developer.android.com/topic/libraries/architecture/lifecycle). For more, see those talks on the subject:
  - [Architecture components - introduction (Google I/O '17)](https://youtu.be/FrteWKKVyzI?si=aQ8XC8D1RkRRxos6)
  - [Architecture components - solving the lifecycle problem (Google I/O '17)](https://youtu.be/bEKNi1JOrNs?si=YGHqj0gsMInJVAlx)
- How to put the Android SDK Platform Tools in the path
- How to use adb to kill the app process.
  - In this case, by running `adb shell am kill com.example.android.dessertpusher` in the terminal
- How to save app state data using `onSaveInstanceState`
- How to recover app state data using `onRestoreInstanceState`