## Gambit on Android example

This example is based on:

* https://github.com/jlongster/gambit-iphone-example
* https://github.com/seoushi/gambit-android-example

### Building Gambit for Android

There is a script "build\_android\_lib.sh", which you can run to build Gambit for Android. It needs the variable $ANDROID\_NDK\_PATH Compiling _gsi_ will fail, but you only need the __libgambc.a__ file found in jni/depends. If the script fails to compile this library, you'll probably need to redefine some variables.
 
### Building the App

You have to compile for Android with:

    % ant debug install

Then run telnet to connect to Android's Gambit REPL:

    % telnet <android IP> 7000


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/alvatar/gambit-android-project/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

