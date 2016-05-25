package com.amqtech.permissions.helper.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amqtech.permissions.helper.R;
import com.amqtech.permissions.helper.objects.Permission;

/**
 * Created by andrew on 5/20/16.
 */

public class PermissionsFlowAdapter extends RecyclerView.Adapter<PermissionsFlowAdapter.ViewHolder> {

    private final Permission[] permissions;

    public PermissionsFlowAdapter(Permission[] permissions) {
        this.permissions = permissions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_permission, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Permission permission = permissions[position];
        holder.permissionName.setText(permission.getPermissionName());
        holder.permissionDesc.setText(permission.getExplanation());
    }

    @Override
    public int getItemCount() {
        return permissions.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView permissionName;
        TextView permissionDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            permissionName = (TextView) itemView.findViewById(R.id.permission_name);
            permissionDesc = (TextView) itemView.findViewById(R.id.permission_desc);
        }

    }

}
