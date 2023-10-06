# Desinging for Everyone - GDG Finder app

This is the toy app for Lesson 10 of the [Android App Development in Kotlin course on Udacity](https://classroom.udacity.com/courses/ud9012/).

Original code obtained from the [original github course repository](https://github.com/udacity/andfun-kotlin-gdg-finder/) and adapted as an exercise.
The [original license](/third-party/andfun-kotlin-gdg-finder/LICENSE.txt) was maintained for this project.

## GDG Finder

GDGs, or Google Developer Groups, are communities of developers that focus on Google technologies - including Android - around the world. They host lots of different events like meetups, conferences, study jams, and more!

GDG Finder helps you locate GDGs around the world or start one of your own. You'll learn the principles of Material Design so you can implement professional looking designs and build Android apps that users love to use!

 
## Screenshots

![Screenshot1](screenshots/gdg-finder-home.png)
![Screenshot2](screenshots/gdg-finder-search.png)
![Screenshot3](screenshots/gdg-finder-apply.png)

## How to use this repo while taking the course


Each code repository in this class has a chain of commits that looks like this:

![listofcommits](https://d17h27t6h515a5.cloudfront.net/topher/2017/March/58befe2e_listofcommits/listofcommits.png)

These commits show every step you'll take to create the app. Each commit contains instructions for completing the that step.

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
2. Check out the branch corresponding to the step you want to attempt.
3. Find and complete the TODOs.
4. Optionally commit your code changes.
5. Compare your code with the solution.
6. Repeat steps 2-5 until you've gone trough all the steps to complete the toy app.


**Step 1: Clone the repo**

As you go through the course, you'll be instructed to clone the different exercise repositories, so you don't need to set these up now. You can clone a repository from github in a folder of your choice with the command:

```bash
git clone https://github.com/udacity/REPOSITORY_NAME.git
```

**Step 2: Check out the step branch**

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
Notice any issues with a repository? Please file a github issue in the repository.

## Some interesting topics learnt

- [TextView XML Attributes](https://developer.android.com/reference/android/widget/TextView#xml-attributes_1)
- [Downloadable Fonts](https://developer.android.com/develop/ui/views/text-and-emoji/downloadable-fonts)
- [Fonts in XML](https://developer.android.com/guide/topics/ui/look-and-feel/fonts-in-xml)
- [Styles and Themes](https://developer.android.com/guide/topics/ui/look-and-feel/themes)
- [Style resource](https://developer.android.com/guide/topics/resources/style-resource)
- [Typography](https://material.io/develop/android/theming/typography/)
- Material Design:
  - [Material Design for Android](https://developer.android.com/guide/topics/ui/look-and-feel)
  - [Material Design - material.io](https://material.io/)
  - [The color system](https://material.io/design/color/the-color-system.html#color-usage-palettes)
  - [Theme Builder - Material 3](https://m3.material.io/theme-builder#/custom)
  - [Color Tool - Material 2](https://m2.material.io/design/color/the-color-system.html#tools-for-picking-colors)
  - [Selecting Colors with the Palette API](https://developer.android.com/training/material/palette-colors)
  - [Color](https://developer.android.com/reference/android/graphics/Color)
- [Design for Android](https://developer.android.com/design)
- Floating Actions Button:
  - [Add a Floating Action Button](https://developer.android.com/guide/topics/ui/floating-action-button)
  - [FloatingActionButton](https://developer.android.com/reference/com/google/android/material/floatingactionbutton/FloatingActionButton)
  - [Floating Action Buttons - Material Design](https://material.io/develop/android/components/floating-action-button/)
  - [Floating Action Buttons - Material Design 3](https://m3.material.io/components/floating-action-button/overview)
  - [Floating Action Buttons - Material Design 3 - Android](https://github.com/material-components/material-components-android/blob/master/docs/components/FloatingActionButton.md)
  - [Buttons: floating action button](https://m2.material.io/components/buttons-floating-action-button)
- [App resources overview](https://developer.android.com/guide/topics/resources/providing-resources)
- [Resource types overview](https://developer.android.com/guide/topics/resources/available-resources)
- [Add app resources](https://developer.android.com/studio/write/add-resources)
- [More resource types](https://developer.android.com/guide/topics/resources/more-resources)
- [Support different languages and cultures](https://developer.android.com/training/basics/supporting-devices/languages)
- [LayoutDirection](https://developer.android.com/reference/android/util/LayoutDirection)
- [Configure on-device developer options](https://developer.android.com/studio/debug/dev-options#drawing)
- Accessibility tools:
  - [Accessibility Scanner](https://play.google.com/store/apps/details?id=com.google.android.apps.accessibility.auditor&hl=en_US)
  - [Test your app's accessibility](https://developer.android.com/guide/topics/ui/accessibility/testing)
  - [Get Started with Accessibility](https://support.google.com/accessibility/android/answer/6376570?hl=en)
  - [Make apps more accessible](https://developer.android.com/guide/topics/ui/accessibility/apps)
  - [Content labels](https://support.google.com/accessibility/android/answer/7158690?hl=en)

## License

[Original license for image and audio is CC BY 4.0 license and for code is Apache v2](/third-party/andfun-kotlin-gdg-finder/LICENSE.txt)