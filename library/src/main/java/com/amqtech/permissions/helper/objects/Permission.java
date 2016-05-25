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
     * A user defined permission with the permission and an explanation.
     * @param permission the permission.
     * @param explanation explanation of the permission.
     */
    public Permission(Permissions permission, String explanation){
        this.permissions = permission;
        this.explanation = explanation;
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
