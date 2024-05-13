# KMP Compose Login Screen Template

# Demo

| Android | IOS Mobile | Desktop |
| ------------- | ------------- | ------------- |
| <img width="803" alt="Android" src="https://github.com/waqas028/KMP-Compose-Template/assets/96041723/55fff70c-6194-457b-a0b5-4fc5a47339b3"> | <img width="803" alt="Iphone 15 Pro Max" src="https://github.com/waqas028/KMP-Compose-Template/assets/96041723/b7153f90-a70d-4f73-a298-ff4803962a1d"> | <img alt="Screenshot 2024-05-11 at 7 51 30 PM" src="https://github.com/waqas028/KMP-Compose-Template/assets/96041723/f52657ba-acd2-4071-b44f-03de7b88004a">

| IPad |
| ------------- |
| <img alt="Ipad" src="https://github.com/waqas028/KMP-Compose-Template/assets/96041723/c337d83d-c0fb-4c7a-847b-ebfec63defb4">  |

# Guidline

This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

**Note:** Compose/Web is Experimental and may be changed at any time. Use it only for evaluation purposes.
We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.
