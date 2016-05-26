package com.amqtech.permissions.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amqtech.androidhelper.AndroidHelper;
import com.amqtech.permissions.helper.objects.Permission;
import com.amqtech.permissions.helper.objects.Permissions;
import com.amqtech.permissions.helper.objects.PermissionsFlow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchLocationPermsFlow(View view) {
        new PermissionsFlow(getBaseContext())
                .withPermissions(new Permission(Permissions.ACCESS_FINE_LOCATION, "This app needs access to your location to improve results."))
                .withPermissionFlowCallback(new PermissionsFlow.PermissionFlowCallback() {
                    @Override
                    public void onPermissionGranted(Permission permission) {
                        // I want to show a toast here
                        // if the permission was granted
                        AndroidHelper.shortToast(getBaseContext(), "Permission "+ permission.getPermissionName() + " granted!");
                    }

                    @Override
                    public void onPermissionDenied(Permission permission) {
                        // I want to show a toast here
                        // if the permission was denied
                        AndroidHelper.shortToast(getBaseContext(), "Permission" + permission.getPermissionName() + "denied!");
                    }
                })
                .launch();
    }

    public void launchContactsPermsFlow(View view) {
        new PermissionsFlow(getBaseContext())
                .withPermissions(new Permission(Permissions.READ_CONTACTS, "This app needs access to your contacts to improve results."))
                .withPermissionFlowCallback(new PermissionsFlow.PermissionFlowCallback() {
                    @Override
                    public void onPermissionGranted(Permission permission) {
                        // I want to show a toast here
                        // if the permission was granted
                        AndroidHelper.shortToast(getBaseContext(), "Permission "+ permission.getPermissionName() + " granted!");
                    }

                    @Override
                    public void onPermissionDenied(Permission permission) {
                        // I want to show a toast here
                        // if the permission was denied
                        AndroidHelper.shortToast(getBaseContext(), "Permission" + permission.getPermissionName() + "denied!");
                    }
                })
                .launch();
    }

    public void launchMultiplePermsFlow(View view) {
        Permission readCalendar = new Permission(Permissions.READ_CALENDAR, "This app needs to read your calendar.");
        Permission writeCalendar = new Permission(Permissions.WRITE_CALENDAR, "This app needs to write to your calendar to make new events.");
        Permission camera = new Permission(Permissions.CAMERA, "This app needs access to your camera so it can take pictures.");

        new PermissionsFlow(getBaseContext())
                .withPermissions(readCalendar, writeCalendar, camera)
                .withPermissionFlowCallback(new PermissionsFlow.PermissionFlowCallback() {
                    @Override
                    public void onPermissionGranted(Permission permission) {
                        // I want to show a toast here
                        // if the permission was granted
                        AndroidHelper.shortToast(getBaseContext(), "Permission "+ permission.getPermissionName() + " granted!");
                    }

                    @Override
                    public void onPermissionDenied(Permission permission) {
                        // I want to show a toast here
                        // if the permission was denied
                        AndroidHelper.shortToast(getBaseContext(), "Permission" + permission.getPermissionName() + "denied!");
                    }
                })
                .launch();
    }
}
