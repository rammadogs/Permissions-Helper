package com.amqtech.permissions.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amqtech.androidhelper.AndroidHelper;
import com.amqtech.permissions.helper.objects.Permission;
import com.amqtech.permissions.helper.objects.Permissions;
import com.amqtech.permissions.helper.objects.PermissionsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchLocationPermsFlow(View view) {
        new PermissionsActivity(getBaseContext())
                .withAppName(getResources().getString(R.string.app_name))
                .withPermissions(new Permission(Permissions.ACCESS_FINE_LOCATION, "This app needs access to your location to improve results."))
                .withPermissionFlowCallback(new PermissionsActivity.PermissionFlowCallback() {
                    @Override
                    public void onPermissionGranted(Permission permission) {
                        // if the permission was granted
                        AndroidHelper.shortToast(getBaseContext(), "Permission " + permission.getPermissionName() + " granted!");
                    }

                    @Override
                    public void onPermissionDenied(Permission permission) {
                        // if the permission was denied
                        AndroidHelper.shortToast(getBaseContext(), "Permission " + permission.getPermissionName() + " denied!");
                    }
                })
                .setBackgroundColor(Color.parseColor("#3F51B5"))
                .setBarColor(Color.parseColor("#3F51B5"))
                .setMainTextColor(Color.parseColor("#EEEEEE"))
                .setStatusBarColor(Color.parseColor("#3F51B5"))
                .setNavBarColor(Color.parseColor("#3F51B5"))
                .launch();
    }

    public void launchContactsPermsFlow(View view) {
        new PermissionsActivity(getBaseContext())
                .withAppName(getResources().getString(R.string.app_name))
                .withPermissions(new Permission(Permissions.READ_CONTACTS, Permissions.READ_CONTACTS_EXPLANATION))
                .withPermissionFlowCallback(new PermissionsActivity.PermissionFlowCallback() {
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
                        AndroidHelper.shortToast(getBaseContext(), "Permission " + permission.getPermissionName() + " denied!");
                    }
                })
                .setStatusBarColor(Color.parseColor("#ffffff"))
                .isStatusBarLight(true)
                .setBackgroundColor(Color.parseColor("#ffffff"))
                .setBarColor(Color.parseColor("#ffffff"))
                .setMainTextColor(Color.parseColor("#444444"))
                .setBarTextColor(Color.parseColor("#444444"))
                .setNavBarColor(Color.parseColor("#ffffff"))
                .setIconColor(Color.parseColor("#444444"))
                .launch();
    }

    public void launchMultiplePermsFlow(View view) {
        Permission readCalendar = new Permission(Permissions.READ_CALENDAR,
                Permissions.READ_CALENDAR_EXPLANATION);
        Permission writeCalendar = new Permission(Permissions.WRITE_CALENDAR,
                Permissions.WRITE_CALENDAR_EXPLANATION);
        Permission camera = new Permission(Permissions.CAMERA,
                Permissions.CAMERA_EXPLANATION);
        Permission writeContacts = new Permission(Permissions.WRITE_CONTACTS,
                Permissions.WRITE_CONTACTS_EXPLANATION);
        Permission location = new Permission(Permissions.ACCESS_FINE_LOCATION,
                Permissions.ACCESS_FINE_LOCATION_EXPLANATION);
        Permission audio = new Permission(Permissions.RECORD_AUDIO,
                Permissions.RECORD_AUDIO_EXPLANATION);
        Permission phone = new Permission(Permissions.READ_PHONE_STATE,
                Permissions.READ_PHONE_STATE_EXPLANATION);
        Permission sensors = new Permission(Permissions.BODY_SENSORS,
                Permissions.BODY_SENSORS_EXPLANATION);
        Permission sms = new Permission(Permissions.SEND_SMS,
                Permissions.SEND_SMS_EXPLANATION);
        Permission storage = new Permission(Permissions.READ_EXTERNAL_STORAGE,
                Permissions.WRITE_EXTERNAL_STORAGE_EXPLANATION);

        new PermissionsActivity(getBaseContext())
                .withAppName(getResources().getString(R.string.app_name))
                .withPermissions(readCalendar, writeCalendar, writeContacts, location, camera, audio, phone, sensors, sms, storage)
                .withPermissionFlowCallback(new PermissionsActivity.PermissionFlowCallback() {
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
                        AndroidHelper.shortToast(getBaseContext(), "Permission " + permission.getPermissionName() + " denied!");
                    }
                })
                .launch();
    }
}
