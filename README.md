This is a simple example of a bug in Kotlin where internal classes cannot be accessed by tests. The example application has 3 gradle projects:
* foo - The main module that contains an internal class (FooImpl) and a test (FooImplTest).
* bar - A module that simply depends on foo
* root - The root application project that generates the APK. It pulls in foo indirectly through bar.

The foo test depends on bar using `testImplementation project(":bar")`. Bar in turn depends on foo using: `api project(":foo")`.

The above causes a bug in Kotlin where FooImplTest no longer compiles. The following error message is generated:
* `./gradlew :foo:assembleDebugUnitTest`
* `> Task :foo:compileDebugUnitTestKotlin FAILED`
* `e: /Users/snepal/Desktop/kotlin-internal-class/foo/src/test/java/com/example/foo/FooImplTest.kt: (15, 9): Cannot access 'FooImpl': it is internal in 'com.example.foo'`

Changing `bar/build.gradle` from `api project(":foo")` to `implementation project(":foo")` fixes the compile error.

A real life example where using "api" is important is when using multiple modules with dagger. In this case "bar" would be a gradle project with a dagger module. The dagger module must expose it dependencies as "api" so that transitive dependencies are resolved when compiling the root application. Finally, "foo" would be the concrete class provided by the module.

