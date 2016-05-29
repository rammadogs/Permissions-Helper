# Permissions-Helper [ ![Download](https://api.bintray.com/packages/andrew-quebe/maven/Android-Permission-Helper/images/download.svg) ](https://bintray.com/andrew-quebe/maven/Permissions-Helper/_latestVersion)
A library that generates an activity based on the required permissions for your app. It loads the permissions into a list and will request them upon continuing through the activity flow.

# Compile in your Project
The library is on jCenter by default. Add this in your app's build.gradle file:

```
dependencies {
	compile 'com.amqtech:perms-helper:1.0.0'
}
````

# How to Use
To launch the permissions activity, simply write the following code:

``` java
// Sample set up that explains to the user that you need access to device location.
new PermissionsActivity(getBaseContext())
        .withAppName(getResources().getString(R.string.app_name))
        .withPermissions(new Permission(Permissions.ACCESS_FINE_LOCATION, "This app needs access to your location to improve results."))
        .withPermissionFlowCallback(new PermissionsActivity.PermissionFlowCallback() {
            @Override
            public void onPermissionGranted(Permission permission) {
        		// if the permission was granted
                
            }

            @Override
            public void onPermissionDenied(Permission permission) {
                // if the permission was denied
                
            }
        })
        // Optional background color
        .setBackgroundColor(Color.parseColor("#3F51B5"))
        // Optional bar color
        .setBarColor(Color.parseColor("#3F51B5"))
        // Optional text color
        .setTextColor(Color.parseColor("#EEEEEE"))
        // Optional status bar color
        .setStatusBarColor(Color.parseColor("#3F51B5"))
        // Optional navigation bar color
        .setNavBarColor(Color.parseColor("#3F51B5");
        .launch();
```

# Java Documentation
If you would like to view the Javadocs for this library, [click here.](https://cdn.rawgit.com/Andrew-Quebe/Permissions-Helper/master/javadoc/index.html)

# Contributions
If you'd like to contribute to this library, feel free to make a pull request with your changes. 

# Developer Info
Andrew Quebe<br>
[andrewquebe@amqtech.com](mailto:andrewquebe@amqtech.com)

# License

```
Copyright 2016 Andrew Quebe

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

# Apps that use this library
None yet! Check back later.

