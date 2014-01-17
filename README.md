## Gambit on Android example

This example is based on:

* https://github.com/jlongster/gambit-iphone-example
* https://github.com/seoushi/gambit-android-example

### Building Gambit for Android

There is a script "build_android_lib.sh", which you can run to build Gambit for Android. It needs the variable _$ANDROID\_NDK\_PATH_ Compiling _gsi_ will fail, but you only need the __libgambc.a__ file found in jni/depends. If the script fails to compile this library, you'll probably need to redefine some variables.
 
### Building the App

You have to compile for Android with:

    % ant debug install

Then run telnet to connect to Android's Gambit REPL:

    % telnet <android IP> 7000
