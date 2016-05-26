package com.amqtech.permissions.helper.objects;


import android.Manifest;

import java.io.Serializable;

/**
 * Created by andrew on 5/19/16.
 */

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
    READ_EXTERAL_STORAGE(Manifest.permission.READ_EXTERNAL_STORAGE, 386),
    WRITE_EXTERNAL_STORAGE(Manifest.permission.WRITE_EXTERNAL_STORAGE, 387);

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
