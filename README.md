# Permissions-Helper [ ![Download](https://api.bintray.com/packages/andrew-quebe/maven/Android-Permission-Helper/images/download.svg) ](https://bintray.com/andrew-quebe/maven/Android-Permission-Helper/_latestVersion)
A library that generates an activity based on the required permissions for your app. It loads the permissions into a list and will request them upon continuing through the activity flow.

# Compile in your Project
The library is on jCenter by default. Add this in your app's build.gradle file:

```
dependencies {
	compile 'com.amqtech:perms-helper:1.0.2'
}
````

## Download the Sample (Optional)

<a href='https://play.google.com/store/apps/details?id=com.amqtech.permissions.sample&utm_source=global_co&utm_medium=prtnr&utm_content=Mar2515&utm_campaign=PartBadge&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img width="200" alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png'/></a>

# How to Use
To launch the permissions activity, simply write the following code:

``` java
// Sample set up that explains to the user that you need access to device location.
new PermissionsActivity(getBaseContext())
	// Your app name. You MUST set this, otherwise bad things will happen!
    .withAppName(getResources().getString(R.string.app_name))
    // The permissions you need
    .withPermissions(new Permission(Permissions.ACCESS_FINE_LOCATION, Permissions.ACCESS_FINE_LOCATION))
    // Callback
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
    // Set status bar color
    .setStatusBarColor(Color.parseColor("#ffffff"))
    // Set status bar icon color - true = dark icons; false (default) = light icons
    .isStatusBarLight(true)
    // Set background color
    .setBackgroundColor(Color.parseColor("#ffffff"))
    // Set background color behind the buttons
    .setBarColor(Color.parseColor("#ffffff"))
    // Set main text color 
    .setMainTextColor(Color.parseColor("#444444"))
    // Set bar button text color
    .setBarTextColor(Color.parseColor("#444444"))
    // Set navigation bar color
    .setNavBarColor(Color.parseColor("#ffffff"))
    // Change color of icons - it is advised that this be the same color as your text
    .setIconColor(Color.parseColor("#444444"))
    // Launch the permissions activity
    .launch();
```

The color methods are optional, and have defaults already set. The `withAppName()`, `withPermissions()`, `withPermissionsFlowCallback()`, and `launch()` methods are required for the library to work properly. Also, these methods are called only once. You don't need to call `withPermissions()` for each permission you are requesting, but rather pass all of them in one method call. [Refer to the sample app](https://github.com/Andrew-Quebe/Permissions-Helper/blob/master/sample/src/main/java/com/amqtech/permissions/sample/MainActivity.java#L76) to see how this is done.

## Default Explanations
The library comes preloaded with default permission explanations if you wish to use them.

``` java
// Example - you don't need a second parameter for using the default explanations.
new Permission(Permissions.ACCESS_FINE_LOCATION)
```

# Java Documentation
If you would like to view the Javadocs for this library, [click here.](https://cdn.rawgit.com/Andrew-Quebe/Permissions-Helper/master/javadoc/index.html)

# Developer Info
Andrew Quebe<br>
[andrewquebe@amqtech.com](mailto:andrewquebe@amqtech.com)

# Contributions
If you'd like to contribute to this library, feel free to make a pull request with your changes. 

## Contributors
Patrick J - [Google+](https://plus.google.com/+PatrickJung42/about) | [Github](https://github.com/pddstudio)

Heinrich Reimer - [Google+](https://plus.google.com/+HeinrichReimer) | [Github](https://github.com/HeinrichReimer)

Rodrigo Martins

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
None yet! If you would like your app listed here, please make a new issue with your app's name, Play Store link, and screenshots proving your usage. Please do not post alpha/beta opt-in links.

# My Inspiration

I was exploring the Android Auto app when I noticed the way they present required permissions to the user. That got me thinking that I could create a library that does exactly that. 

| (Google's Version) | (My Version) |
|:------------------:|:----------:|
|<img width="640" src="https://github.com/Andrew-Quebe/Permissions-Helper/blob/master/artwork/google.png"/>|<img width="640" src="https://github.com/Andrew-Quebe/Permissions-Helper/blob/master/artwork/mine.png"/>|
