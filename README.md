# Appium2.0-Framework-to-Test-React-Native-Apps-in-Android-iOS
This repo demonstrate a fully functional automated test framework for react-native apps using Appium 2.0

## Pre-requisites
1. Install Node.js
2. Install Java JDK 11
3. Install Android Studio
4. Install Xcode
5. Install Appium 2.0
6. Install Appium Inspector
7. Install IntelliJ IDEA
8. Install Android SDK

## How to run the tests
1. Clone the repo
2. Open the project in IntelliJ IDEA
3. Open the terminal and run the following command to install the dependencies
```mvn clean install```
4. Add email and password in the ```src/test/resources/credentials.json``` file
5. Add apps folder in the root directory and add the apk and ipa files
5. Connect the Android device or iOS device from emulator or simulator
6. Run the tests from IntelliJ IDEA or from the terminal using the following command
```mvn clean test```
