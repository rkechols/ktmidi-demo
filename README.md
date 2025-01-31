# ktmidi demo

This is a demo project for using [ktmidi](https://github.com/atsushieno/ktmidi) in a Kotlin Multiplatform project.
The sole goal is to set up gradle, libraries, etc. such that ktmidi can be used on macOS, Windows, and Linux.

One essential note is that the Java standard library is not correctly implemented for macOS, so a different backend
MUST be used for macOS.


## Kotlin Multiplatform

This is a Kotlin Multiplatform project targeting Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
