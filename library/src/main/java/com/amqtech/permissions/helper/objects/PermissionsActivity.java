package com.amqtech.permissions.helper.objects;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;

import com.amqtech.permissions.helper.ui.activity.PermissionsFlowActivity;

import java.io.Serializable;

public class PermissionsActivity implements Serializable {

    public static final String PERMISSIONS = "com.amqtech.permissions.helper.PERMISSIONS";
    public static final String BG_COLOR = "background_color";
    public static final String BAR_COLOR = "bar_color";
    public static final String MAIN_TEXT_COLOR = "main_text_color";
    public static final String BAR_TEXT_COLOR = "bar_text_color";
    public static final String STATUS_BAR_COLOR = "status_bar_color";
    public static final String NAVIGATION_BAR_COLOR = "nav_bar_color";
    public static final String LIGHT_STATUS_BAR = "light_status_bar";
    public static final String ICON_COLOR = "icon_color";
    public static String APP_NAME = "";

    public static PermissionsActivity permissionsActivity;

    //Vars
    private Permission[] permissions;
    public PermissionFlowCallback callback;
    private Context launchContext;

    private int bgColor = Color.parseColor("#009688");
    private int barColor = Color.parseColor("#009688");
    private int mainTextColor = Color.parseColor("#ffffff");
    private int barTextColor = Color.parseColor("#ffffff");
    private int statusBarColor = Color.parseColor("#007065");
    private int navBarColor = Color.parseColor("#007065");
    private boolean lightStatusBar = false;
    private int iconColor = Color.parseColor("#ffffff");

    /**
     * Default Constructor
     */
    public PermissionsActivity(Context context) {
        this.launchContext = context;
    }

    /**
     * Stores the app name to be applied in the activity.
     * @param appName the app name.
     */
    public PermissionsActivity withAppName(@NonNull String appName) {
        APP_NAME = appName;
        return this;
    }

    /**
     * Stores list of permissions given by the user.
     *
     * @param permissions an array of the requested permissions.
     */
    public PermissionsActivity withPermissions(@NonNull Permission... permissions) {
        this.permissions = permissions;
        return this;
    }

    /**
     * Callback method for listening to user grants or denials of permissions.
     * @param callback the callback.
     * @return callback.
     */
    public PermissionsActivity withPermissionFlowCallback(PermissionFlowCallback callback) {
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
     * Stores a color resource to change the background color of the permissions activity.
     * @param color the background color.
     */
    public PermissionsActivity setBackgroundColor(int color) {
        bgColor = color;
        return this;
    }

    /**
     * Stores a color resource to change the bar color on the permissions activity.
     * @param color the bar color.
     */
    public PermissionsActivity setBarColor(int color) {
        barColor = color;
        return this;
    }

    /**
     * Stores a color resource to change the bar color on the permissions activity.
     *
     * @param color the bar color.
     */
    public PermissionsActivity setIconColor(int color) {
        iconColor = color;
        return this;
    }

    /**
     * Stores a color resource to change the text color on the permissions activity.
     * @param color the text color.
     */
    public PermissionsActivity setMainTextColor(int color) {
        mainTextColor = color;
        return this;
    }

    /**
     * Stores a color resource to change the bar text color on the permissions activity.
     *
     * @param color the text color.
     */
    public PermissionsActivity setBarTextColor(int color) {
        barTextColor = color;
        return this;
    }

    /**
     * Stores a color resource to change the status bar color on the permissions activity.
     * @param color the status bar color.
     */
    @TargetApi(21)
    public PermissionsActivity setStatusBarColor(int color) {
        statusBarColor = color;
        return this;
    }

    /**
     * Stores a a color resource to change the navigation bar color on the permissions activity.
     * @param color the nav bar color.
     */
    @TargetApi(21)
    public PermissionsActivity setNavBarColor(int color) {
        navBarColor = color;
        return this;
    }

    /**
     * Sets whether or not the statusbar icons are dark. Set to true when using a light status bar color.
     *
     * @param value true or false.
     */
    @TargetApi(23)
    public PermissionsActivity isStatusBarLight(boolean value) {
        lightStatusBar = value;
        return this;
    }

    /*
     * Launches the permissions flow activity.
     */
    public void launch(){
        if (permissions == null || permissions.length == 0) {
            throw new RuntimeException("You need to supply an array of explanations!");
        } else {
            permissionsActivity = this;
            Intent permissionActivity = new Intent(launchContext, PermissionsFlowActivity.class);
            permissionActivity.putExtra(PERMISSIONS, permissions);
            permissionActivity.putExtra(BG_COLOR, bgColor);
            permissionActivity.putExtra(BAR_COLOR, barColor);
            permissionActivity.putExtra(MAIN_TEXT_COLOR, mainTextColor);
            permissionActivity.putExtra(BAR_TEXT_COLOR, barTextColor);
            permissionActivity.putExtra(STATUS_BAR_COLOR, statusBarColor);
            permissionActivity.putExtra(NAVIGATION_BAR_COLOR, navBarColor);
            permissionActivity.putExtra(LIGHT_STATUS_BAR, lightStatusBar);
            permissionActivity.putExtra(ICON_COLOR, iconColor);
            permissionActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            launchContext.startActivity(permissionActivity);
        }

    }
}
