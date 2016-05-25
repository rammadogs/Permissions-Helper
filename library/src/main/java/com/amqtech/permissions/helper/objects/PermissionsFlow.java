package com.amqtech.permissions.helper.objects;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.amqtech.permissions.helper.ui.activity.PermissionsFlowActivity;

public class PermissionsFlow {

    public static final String PERMISSIONS = "com.amqtech.permissions.helper.PERMISSIONS";

    //Vars
    private Permission[] permissions;
    private PermissionFlowCallback callback;
    private Context launchContext;

    /**
     * Default Constructor
     */
    public PermissionsFlow(Context context) {
        this.launchContext = context;
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
        void onPermissionGranted();
        void onPermissionDenied();
    }

    /*
     * Launches the permissions flow activity.
     */
    public void launch(){
        if (permissions == null || permissions.length == 0) {
            throw new RuntimeException("You need to supply an array of explanations!");
        } else {

            Intent permissionActivity = new Intent(launchContext, PermissionsFlowActivity.class);
            permissionActivity.putExtra(PERMISSIONS, permissions);
            permissionActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            launchContext.startActivity(permissionActivity);
        }

    }
}
