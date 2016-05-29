package com.amqtech.permissions.helper.objects;


import android.Manifest;
import android.annotation.TargetApi;
import android.os.Build;

import java.io.Serializable;

/**
 * Created by andrew on 5/19/16.
 */

@TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
public enum Permissions implements Serializable {

    /** List of dangerous permissions as specified here:
     *  https://developer.android.com/guide/topics/security/permissions.html#normal-dangerous
     */
    READ_CALENDAR(Manifest.permission.READ_CALENDAR, 364),
    WRITE_CALENDAR(Manifest.permission.WRITE_CALENDAR, 365),
    CAMERA(Manifest.permission.CAMERA, 366),
    READ_CONTACTS(Manifest.permission.READ_CONTACTS, 367),
    WRITE_CONTACTS(Manifest.permission.WRITE_CONTACTS, 368),
    GET_ACCOUNTS(Manifest.permission.GET_ACCOUNTS, 369),
    ACCESS_FINE_LOCATION(Manifest.permission.ACCESS_FINE_LOCATION, 370),
    ACCESS_COARSE_LOCATION(Manifest.permission.ACCESS_COARSE_LOCATION, 371),
    RECORD_AUDIO(Manifest.permission.RECORD_AUDIO, 372),
    READ_PHONE_STATE(Manifest.permission.READ_PHONE_STATE, 373),
    CALL_PHONE(Manifest.permission.CALL_PHONE, 374),
    READ_CALL_LOG(Manifest.permission.READ_CALL_LOG, 375),
    WRITE_CALL_LOG(Manifest.permission.WRITE_CALL_LOG, 376),
    ADD_VOICEMAIL(Manifest.permission.ADD_VOICEMAIL, 377),
    USE_SIP(Manifest.permission.USE_SIP, 378),
    PROCESS_OUTGOING_CALLS(Manifest.permission.PROCESS_OUTGOING_CALLS, 379),
    BODY_SENSORS(Manifest.permission.BODY_SENSORS, 380),
    SEND_SMS(Manifest.permission.SEND_SMS, 381),
    RECEIVE_SMS(Manifest.permission.RECEIVE_SMS, 382),
    READ_SMS(Manifest.permission.READ_SMS, 383),
    RECEIVE_WAP_PUSH(Manifest.permission.RECEIVE_WAP_PUSH, 384),
    RECEIVE_MMS(Manifest.permission.RECEIVE_MMS, 385),
    READ_EXTERNAL_STORAGE(Manifest.permission.READ_EXTERNAL_STORAGE, 386),
    WRITE_EXTERNAL_STORAGE(Manifest.permission.WRITE_EXTERNAL_STORAGE, 387);

    public static final String READ_CALENDAR_EXPLANATION = "Allows this app to read your calendar events.";
    public static final String WRITE_CALENDAR_EXPLANATION = "Allows this app to write events to your calendar.";
    public static final String CAMERA_EXPLANATION = "Allows this app to use your camera and LED light.";
    public static final String READ_CONTACTS_EXPLANATION = "Allows this app to read your contact info.";
    public static final String WRITE_CONTACTS_EXPLANATION = "Allows this app to edit your contacts or make new ones.";
    public static final String GET_ACCOUNTS_EXPLANATION = "Allows this app to get a list of device accounts.";
    public static final String ACCESS_FINE_LOCATION_EXPLANATION = "Allows this app to access your fine location.";
    public static final String ACCESS_COARSE_LOCATION_EXPLANATION = "Allows this app to access your approximate location.";
    public static final String RECORD_AUDIO_EXPLANATION = "Allows this app to record audio using the device microphone.";
    public static final String READ_PHONE_STATE_EXPLANATION = "Allows this app to read call information.";
    public static final String CALL_PHONE_EXPLANATION = "Allows this app to make phone calls.";
    public static final String READ_CALL_LOG_EXPLANATION = "Allows this app to access your call logs.";
    public static final String WRITE_CALL_LOG_EXPLANATION = "Allows this app to edit your call logs.";
    public static final String ADD_VOICEMAIL_EXPLANATION = "Allows this app to add voicemails.";
    public static final String USE_SIP_EXPLANATION = "Allows this app to use SIP service.";
    public static final String PROCESS_OUTGOING_CALLS_EXPLANATION = "Allows this app to see the number being dialed during an outgoing call with the option to redirect the call to a different number or abort the call altogether";
    public static final String BODY_SENSORS_EXPLANATION = "Allows this app to access data from sensors that you use to measure what is happening inside your body, such as heart rate.";
    public static final String SEND_SMS_EXPLANATION = "Allows this app to send SMS messages.";
    public static final String RECEIVE_SMS_EXPLANATION = "Allows this app to read incoming SMS messages.";
    public static final String READ_SMS_EXPLANATION = "Allows this app to read SMS messages.";
    public static final String RECEIVE_WAP_PUSH_EXPLANATION = "Allows this app to broadcast a WAP PUSH receipt notification.";
    public static final String RECEIVE_MMS_EXPLANATION = "Allows this app to read MMS messages.";
    public static final String READ_EXTERNAL_STORAGE_EXPLANATION = "Allows this app to read the contents of your device storage.";
    public static final String WRITE_EXTERNAL_STORAGE_EXPLANATION = "Allows this app to write data to your device storage.";

    private String permission;
    private int requestCode;

    /**
     * Permissions object that binds a numerical int to a dangerous permission.
     * @param permission the permission.
     * @param requestCode the special ID.
     */
    Permissions(String permission, int requestCode) {
        this.permission = permission;
        this.requestCode = requestCode;
    }

    /**
     * Getter for permission object.
     * @return the permission.
     */
    public String getPermission() {
        return permission;
    }

    /**
     * Getter for request code int.
     * @return permission request code.
     */
    public int getRequestCode() {
        return requestCode;
    }
}
