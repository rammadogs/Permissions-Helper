package com.amqtech.permissions.helper.objects;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;

import com.amqtech.permissions.helper.R;
import com.amqtech.permissions.helper.ui.activity.PermissionsFlowActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PermissionsActivity implements Serializable {

    public static final String APP_NAME = "app_name";
    public static final String PERMISSIONS = "com.amqtech.permissions.helper.PERMISSIONS";
    public static final String BG_COLOR = "background_color";
    public static final String BAR_COLOR = "bar_color";
    public static final String MAIN_TEXT_COLOR = "main_text_color";
    public static final String MAIN_TEXT_COLOR_SECONDARY = "main_text_color_secondary";
    public static final String BAR_TEXT_COLOR = "bar_text_color";
    public static final String STATUS_BAR_COLOR = "status_bar_color";
    public static final String NAVIGATION_BAR_COLOR = "nav_bar_color";
    public static final String LIGHT_STATUS_BAR = "light_status_bar";
    public static final String ICON_COLOR = "icon_color";

    public static PermissionsActivity permissionsActivity;

    //Vars
    private List<Permission> permissions = new ArrayList<>();
    public PermissionFlowCallback callback;
    private Context launchContext;

    public String appName = null;
    private int bgColor;
    private int barColor;
    private int mainTextColor;
    private int mainTextColorSecondary;
    private int barTextColor;
    private int statusBarColor;
    private int navBarColor;
    private boolean lightStatusBar = false;
    private int iconColor;

    /**
     * Default Constructor
     */
    public PermissionsActivity(@NonNull Context context) {
        this.launchContext = context;

        bgColor = ContextCompat.getColor(launchContext, R.color.default_background_color);
        barColor = ContextCompat.getColor(launchContext, R.color.default_background_color);
        mainTextColor = ContextCompat.getColor(launchContext, R.color.default_text_color_primary);
        mainTextColorSecondary = ContextCompat.getColor(launchContext, R.color.default_text_color_secondary);
        barTextColor = ContextCompat.getColor(launchContext, R.color.default_text_color_primary);
        statusBarColor = ContextCompat.getColor(launchContext, R.color.default_background_dark_color);
        navBarColor = ContextCompat.getColor(launchContext, R.color.default_nav_bar_background_color);
        iconColor = ContextCompat.getColor(launchContext, R.color.default_icon_color);
    }

    /**
     * Stores the app name to be applied in the activity.
     * @param appName the app name.
     */
    public PermissionsActivity withAppName(@NonNull String appName) {
        this.appName = appName;
        return this;
    }

    /**
     * Stores the app name to be applied in the activity.
     * @param appName the app name resource ID.
     */
    public PermissionsActivity withAppNameRes(@StringRes int appName) {
        this.appName = launchContext.getString(appName);
        return this;
    }

    /**
     * Stores list of permissions given by the user.
     *
     * @param permissions an array of the requested permissions.
     */
    public PermissionsActivity withPermissions(@NonNull Permission... permissions) {
        Collections.addAll(this.permissions, permissions);
        return this;
    }

    /**
     * Stores list of permissions given by the user.
     *
     * @param permissions a collection of the requested permissions.
     */
    public PermissionsActivity withPermissions(@NonNull Collection<Permission> permissions) {
        this.permissions.addAll(permissions);
        return this;
    }

    /**
     * Stores a permission given by the user.
     *
     * @param permission the requested permissions.
     */
    public PermissionsActivity withPermission(@NonNull Permission permission) {
        this.permissions.add(permission);
        return this;
    }

    /**
     * Stores a permission given by the user.
     *
     * @param permission  the requested permission.
     * @param explanation explanation of the permission.
     */
    public PermissionsActivity withPermission(@NonNull Permissions permission, String explanation) {
        this.permissions.add(new Permission(permission, explanation));
        return this;
    }

    /**
     * Stores a permission given by the user.
     *
     * @param permission  the requested permission.
     * @param explanation explanation resource ID of the permission.
     */
    public PermissionsActivity withPermission(@NonNull Permissions permission, @StringRes int explanation) {
        this.permissions.add(new Permission(permission, launchContext.getString(explanation)));
        return this;
    }

    /**
     * Stores a permission given by the user.
     *
     * @param permission the requested permission.
     */
    public PermissionsActivity withPermission(@NonNull Permissions permission) {
        this.permissions.add(new Permission(permission));
        return this;
    }

    /**
     * Callback method for listening to user grants or denials of permissions.
     * @param callback the callback.
     * @return callback.
     */
    public PermissionsActivity withPermissionFlowCallback(@Nullable PermissionFlowCallback callback) {
        this.callback = callback;
        return this;
    }

    /**
     * Permissions Callback interface.
     */
    public interface PermissionFlowCallback {
        void onPermissionGranted(Permission permission);
        void onPermissionDenied(Permission permission);
    }

    /**
     * Stores a color to change the background color of the permissions activity.
     * @param color the background color.
     */
    public PermissionsActivity setBackgroundColor(@ColorInt int color) {
        bgColor = color;
        return this;
    }

    /**
     * Stores a color to change the background color of the permissions activity.
     *
     * @param color the background color resource ID.
     */
    public PermissionsActivity setBackgroundColorRes(@ColorRes int color) {
        bgColor = ContextCompat.getColor(launchContext, color);
        return this;
    }

    /**
     * Stores a color to change the bar color on the permissions activity.
     * @param color the bar color.
     */
    public PermissionsActivity setBarColor(@ColorInt int color) {
        barColor = color;
        return this;
    }

    /**
     * Stores a color to change the bar color on the permissions activity.
     *
     * @param color the bar color resource ID.
     */
    public PermissionsActivity setBarColorRes(@ColorRes int color) {
        barColor = ContextCompat.getColor(launchContext, color);
        return this;
    }

    /**
     * Stores a color to change the bar color on the permissions activity.
     *
     * @param color the bar color.
     */
    public PermissionsActivity setIconColor(@ColorInt int color) {
        iconColor = color;
        return this;
    }

    /**
     * Stores a color to change the bar color on the permissions activity.
     *
     * @param color the bar color resource ID.
     */
    public PermissionsActivity setIconColorRes(@ColorRes int color) {
        iconColor = ContextCompat.getColor(launchContext, color);
        return this;
    }

    /**
     * Stores a color to change the text color on the permissions activity.
     * @param color the text color.
     */
    public PermissionsActivity setMainTextColor(@ColorInt int color) {
        mainTextColor = color;
        return this;
    }

    /**
     * Stores a color to change the text color on the permissions activity.
     *
     * @param color the text color resource ID.
     */
    public PermissionsActivity setMainTextColorRes(@ColorRes int color) {
        mainTextColor = ContextCompat.getColor(launchContext, color);
        return this;
    }

    /**
     * Stores a color to change the secondary text color on the permissions activity.
     * @param color the text color.
     */
    public PermissionsActivity setMainTextColorSecondary(@ColorInt int color) {
        mainTextColorSecondary = color;
        return this;
    }

    /**
     * Stores a color to change the secondary text color on the permissions activity.
     *
     * @param color the text color resource ID.
     */
    public PermissionsActivity setMainTextColorSecondaryRes(@ColorRes int color) {
        mainTextColorSecondary = ContextCompat.getColor(launchContext, color);
        return this;
    }

    /**
     * Stores a color to change the bar text color on the permissions activity.
     *
     * @param color the text color.
     */
    public PermissionsActivity setBarTextColor(@ColorInt int color) {
        barTextColor = color;
        return this;
    }

    /**
     * Stores a color to change the bar text color on the permissions activity.
     *
     * @param color the text color resource ID.
     */
    public PermissionsActivity setBarTextColorRes(@ColorRes int color) {
        barTextColor = ContextCompat.getColor(launchContext, color);
        return this;
    }

    /**
     * Stores a color to change the status bar color on the permissions activity.
     * @param color the status bar color.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PermissionsActivity setStatusBarColor(@ColorInt int color) {
        statusBarColor = color;
        return this;
    }

    /**
     * Stores a color to change the status bar color on the permissions activity.
     *
     * @param color the status bar color resource ID.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PermissionsActivity setStatusBarColorRes(@ColorRes int color) {
        statusBarColor = ContextCompat.getColor(launchContext, color);
        return this;
    }

    /**
     * Stores a color to change the navigation bar color on the permissions activity.
     * @param color the nav bar color.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PermissionsActivity setNavBarColor(@ColorInt int color) {
        navBarColor = color;
        return this;
    }

    /**
     * Stores a color to change the navigation bar color on the permissions activity.
     *
     * @param color the nav bar color resource ID.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PermissionsActivity setNavBarColorRes(@ColorRes int color) {
        navBarColor = ContextCompat.getColor(launchContext, color);
        return this;
    }

    /**
     * Sets whether or not the status bar icons are dark. Set to true when using a light status bar color.
     *
     * @param light true or false.
     */
    @Deprecated
    @TargetApi(Build.VERSION_CODES.M)
    public PermissionsActivity isStatusBarLight(boolean light) {
        return setStatusBarLight(light);
    }

    /**
     * Sets whether or not the status bar icons are dark. Set to true when using a light status bar color.
     *
     * @param light true or false.
     */
    @TargetApi(Build.VERSION_CODES.M)
    public PermissionsActivity setStatusBarLight(boolean light) {
        lightStatusBar = light;
        return this;
    }

    /**
     * Sets whether or not the status bar icons are dark depending on the status bar color luminance set before.
     */
    @TargetApi(Build.VERSION_CODES.M)
    public PermissionsActivity setStatusBarLightAuto() {
        lightStatusBar = ColorUtils.calculateLuminance(statusBarColor) > 0.6;
        return this;
    }

    /**
     * Launches the permissions flow activity.
     */
    public void launch() {
        if (TextUtils.isEmpty(appName)) {
            throw new RuntimeException("You need to define an app name!");
        }
        if (permissions.isEmpty()) {
            throw new RuntimeException("You need to supply at least one permission!");
        }

        List<Permission> permissionList = permissionsDenied(permissions);

        if (permissionList == null || permissionList.isEmpty()){
            return;
        }

        permissionsActivity = this;
        Intent permissionActivity = new Intent(launchContext, PermissionsFlowActivity.class);
        permissionActivity.putExtra(APP_NAME, appName);
        permissionActivity.putExtra(PERMISSIONS, permissionList.toArray(new Permission[permissionList.size()]));
        permissionActivity.putExtra(BG_COLOR, bgColor);
        permissionActivity.putExtra(BAR_COLOR, barColor);
        permissionActivity.putExtra(MAIN_TEXT_COLOR, mainTextColor);
        permissionActivity.putExtra(MAIN_TEXT_COLOR_SECONDARY, mainTextColorSecondary);
        permissionActivity.putExtra(BAR_TEXT_COLOR, barTextColor);
        permissionActivity.putExtra(STATUS_BAR_COLOR, statusBarColor);
        permissionActivity.putExtra(NAVIGATION_BAR_COLOR, navBarColor);
        permissionActivity.putExtra(LIGHT_STATUS_BAR, lightStatusBar);
        permissionActivity.putExtra(ICON_COLOR, iconColor);
        permissionActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        launchContext.startActivity(permissionActivity);
    }

    private List<Permission> permissionsDenied(List<Permission> permissions){

        List<Permission> permissionList = new ArrayList<>();
        PackageManager pm = launchContext.getPackageManager();

        for (Permission p : permissions){
            int hasPerm = pm.checkPermission(p.getPermissions().getPermission(),launchContext.getPackageName());
            if (hasPerm != PackageManager.PERMISSION_GRANTED) {

                permissionList.add(p);
            }
        }

        return permissionList;
    }
}
