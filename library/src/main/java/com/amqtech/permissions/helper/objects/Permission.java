package com.amqtech.permissions.helper.objects;

import java.io.Serializable;

/**
 * Created by andrew on 5/19/16.
 */

public class Permission implements Serializable {

    // Vars
    private final Permissions permissions;
    private final String explanation;

    /**
     * A user defined permission with the permission type and an explanation.
     * @param permission the permission.
     * @param explanation explanation of the permission.
     */
    public Permission(Permissions permission, String explanation){
        this.permissions = permission;
        this.explanation = explanation;
    }

    public Permission(Permissions permission) {
        this.permissions = permission;
        switch (permission.name()) {
            case "READ_CALENDAR":
                this.explanation = Permissions.READ_CALENDAR_EXPLANATION;
                break;
            case "WRITE_CALENDAR":
                this.explanation = Permissions.WRITE_CALENDAR_EXPLANATION;
                break;
            case "CAMERA":
                this.explanation = Permissions.CAMERA_EXPLANATION;
                break;
            case "READ_CONTACTS":
                this.explanation = Permissions.READ_CONTACTS_EXPLANATION;
                break;
            case "WRITE_CONTACTS":
                this.explanation = Permissions.WRITE_CONTACTS_EXPLANATION;
                break;
            case "GET_ACCOUNTS":
                this.explanation = Permissions.GET_ACCOUNTS_EXPLANATION;
                break;
            case "ACCESS_FINE_LOCATION":
                this.explanation = Permissions.ACCESS_FINE_LOCATION_EXPLANATION;
                break;
            case "ACCESS_COARSE_LOCATION":
                this.explanation = Permissions.ACCESS_COARSE_LOCATION_EXPLANATION;
                break;
            case "RECORD_AUDIO":
                this.explanation = Permissions.RECORD_AUDIO_EXPLANATION;
                break;
            case "READ_PHONE_STATE":
                this.explanation = Permissions.READ_PHONE_STATE_EXPLANATION;
                break;
            case "CALL_PHONE":
                this.explanation = Permissions.CALL_PHONE_EXPLANATION;
                break;
            case "READ_CALL_LOG":
                this.explanation = Permissions.READ_CALL_LOG_EXPLANATION;
                break;
            case "WRITE_CALL_LOG":
                this.explanation = Permissions.WRITE_CALL_LOG_EXPLANATION;
                break;
            case "ADD_VOICEMAIL":
                this.explanation = Permissions.ADD_VOICEMAIL_EXPLANATION;
                break;
            case "USE_SIP":
                this.explanation = Permissions.USE_SIP_EXPLANATION;
                break;
            case "PROCESS_OUTGOING_CALLS":
                this.explanation = Permissions.PROCESS_OUTGOING_CALLS_EXPLANATION;
                break;
            case "BODY_SENSORS":
                this.explanation = Permissions.BODY_SENSORS_EXPLANATION;
                break;
            case "SEND_SMS":
                this.explanation = Permissions.SEND_SMS_EXPLANATION;
                break;
            case "RECEIVE_SMS":
                this.explanation = Permissions.RECEIVE_SMS_EXPLANATION;
                break;
            case "READ_SMS":
                this.explanation = Permissions.READ_SMS_EXPLANATION;
                break;
            case "RECEIVE_WAP_PUSH":
                this.explanation = Permissions.RECEIVE_WAP_PUSH_EXPLANATION;
                break;
            case "RECEIVE_MMS":
                this.explanation = Permissions.RECEIVE_MMS_EXPLANATION;
                break;
            case "READ_EXTERNAL_STORAGE":
                this.explanation = Permissions.READ_EXTERNAL_STORAGE_EXPLANATION;
                break;
            case "WRITE_EXTERNAL_STORAGE":
                this.explanation = Permissions.WRITE_EXTERNAL_STORAGE_EXPLANATION;
                break;
            default:
                this.explanation = "";
                break;
        }
    }

    /**
     * Getter for permission object
     * @return permissions.
     */
    public Permissions getPermissions() {
        return permissions;
    }

    /**
     * Getter for permission explanation.
     * @return explanation.
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * Getter for permission name.
     * @return the permission name.
     */
    public String getPermissionName() {
        return permissions.name();
    }

}
