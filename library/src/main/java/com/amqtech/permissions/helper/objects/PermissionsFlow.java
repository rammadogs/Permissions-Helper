package com.amqtech.permissions.helper.objects;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;

import com.amqtech.permissions.helper.ui.activity.PermissionsFlowActivity;

import java.io.Serializable;

public class PermissionsFlow implements Serializable {

    public static final String PERMISSIONS = "com.amqtech.permissions.helper.PERMISSIONS";
    public static final String BG_COLOR = "background_color";
    public static final String BAR_COLOR = "bar_color";
    public static final String TEXT_COLOR = "text_color";
    public static final String STATUS_BAR_COLOR = "status_bar_color";
    public static final String NAVIGATION_BAR_COLOR = "nav_bar_color";
    public static final String LIGHT_STATUS_BAR = "light_status_bar";
    public static String APP_NAME = "";

    public static PermissionsFlow permissionsFlow;

    //Vars
    private Permission[] permissions;
    public PermissionFlowCallback callback;
    private Context launchContext;

    private int bgColor = Color.parseColor("#009688");
    private int barColor = Color.parseColor("#009688");
    private int textColor = Color.parseColor("#ffffff");
    private int statusBarColor = Color.parseColor("#007065");
    private int navBarColor = Color.parseColor("#007065");
    private boolean lightStatusBar = false;

    /**
     * Default Constructor
     */
    public PermissionsFlow(Context context) {
        this.launchContext = context;
    }

    /**
     * Stores the app name to be applied in the activity.
     * @param appName the app name.
     */
    public PermissionsFlow withAppName(@NonNull String appName) {
        APP_NAME = appName;
        return this;
    }

    /**
     * Stores list of permissions given by the user.
     *
     * @param permissions an array of the requested permissions.
     */
    public PermissionsFlow withPermissions(@NonNull Permission... permissions){
        this.permissions = permissions;
        return this;
    }

    /**
     * Callback method for listening to user grants or denials of permissions.
     * @param callback the callback.
     * @return callback.
     */
    public PermissionsFlow withPermissionFlowCallback(PermissionFlowCallback callback){
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
     *
     * @param color the background color.
     */
    public PermissionsFlow setBackgroundColor(int color) {
        bgColor = color;
        return this;
    }

    /**
     * Stores a color resource to change the bar color on the permissions activity.
     *
     * @param color the bar color.
     */
    public PermissionsFlow setBarColor(int color) {
        barColor = color;
        return this;
    }

    /**
     * Stores a color resource to change the text color on the permissions activity.
     *
     * @param color the text color.
     */
    public PermissionsFlow setTextColor(int color) {
        textColor = color;
        return this;
    }

    /**
     * Stores a color resource to change the status bar color on the permissions activity.
     *
     * @param color the status bar color.
     */
    @TargetApi(21)
    public PermissionsFlow setStatusBarColor(int color) {
        statusBarColor = color;
        return this;
    }

    /**
     * Stores a a color resource to change the navigation bar color on the permissions activity.
     *
     * @param color the nav bar color.
     */
    @TargetApi(21)
    public PermissionsFlow setNavBarColor(int color) {
        navBarColor = color;
        return this;
    }

    @TargetApi(23)
    public PermissionsFlow isStatusBarLight(boolean value) {
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
            permissionsFlow = this;
            Intent permissionActivity = new Intent(launchContext, PermissionsFlowActivity.class);
            permissionActivity.putExtra(PERMISSIONS, permissions);
            permissionActivity.putExtra(BG_COLOR, bgColor);
            permissionActivity.putExtra(BAR_COLOR, barColor);
            permissionActivity.putExtra(TEXT_COLOR, textColor);
            permissionActivity.putExtra(STATUS_BAR_COLOR, statusBarColor);
            permissionActivity.putExtra(NAVIGATION_BAR_COLOR, navBarColor);
            permissionActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            launchContext.startActivity(permissionActivity);
        }

    }
}
