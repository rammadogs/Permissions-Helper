package com.amqtech.permissions.helper.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amqtech.permissions.helper.R;
import com.amqtech.permissions.helper.objects.Permission;

/**
 * Created by andrew on 5/20/16.
 */

public class PermissionsFlowAdapter extends RecyclerView.Adapter<PermissionsFlowAdapter.ViewHolder> {

    private final Permission[] permissions;

    private int textColor;
    private int textColorSecondary;
    private int tintColor;

    public PermissionsFlowAdapter(Permission[] permissions, int textColor, int textColorSecondary, int tintColor) {
        this.permissions = permissions;
        this.textColor = textColor;
        this.textColorSecondary = textColorSecondary;
        this.tintColor = tintColor;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_permission, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Permission permission = permissions[position];

        switch (permission.getPermissionName()) {
            case "READ_CALENDAR":
                holder.permissionIcon.setImageResource(R.drawable.ic_calendar);
                holder.permissionName.setText(R.string.read_cal);
                break;
            case "WRITE_CALENDAR":
                holder.permissionIcon.setImageResource(R.drawable.ic_calendar);
                holder.permissionName.setText(R.string.write_cal);
                break;
            case "CAMERA":
                holder.permissionIcon.setImageResource(R.drawable.ic_camera);
                holder.permissionName.setText(R.string.cam);
                break;
            case "READ_CONTACTS":
                holder.permissionIcon.setImageResource(R.drawable.ic_contacts);
                holder.permissionName.setText(R.string.read_contacts);
                break;
            case "WRITE_CONTACTS":
                holder.permissionIcon.setImageResource(R.drawable.ic_contacts);
                holder.permissionName.setText(R.string.write_contacts);
                break;
            case "GET_ACCOUNTS":
                holder.permissionIcon.setImageResource(R.drawable.ic_contacts);
                holder.permissionName.setText(R.string.accounts);
                break;
            case "ACCESS_FINE_LOCATION":
                holder.permissionIcon.setImageResource(R.drawable.ic_location);
                holder.permissionName.setText(R.string.fine_loc);
                break;
            case "ACCESS_COARSE_LOCATION":
                holder.permissionIcon.setImageResource(R.drawable.ic_location);
                holder.permissionName.setText(R.string.coarse_loc);
                break;
            case "RECORD_AUDIO":
                holder.permissionIcon.setImageResource(R.drawable.ic_mic);
                holder.permissionName.setText(R.string.rec_audio);
                break;
            case "READ_PHONE_STATE":
                holder.permissionIcon.setImageResource(R.drawable.ic_phone);
                holder.permissionName.setText(R.string.phone_state);
                break;
            case "CALL_PHONE":
                holder.permissionIcon.setImageResource(R.drawable.ic_phone);
                holder.permissionName.setText(R.string.place_calls);
                break;
            case "READ_CALL_LOG":
                holder.permissionIcon.setImageResource(R.drawable.ic_phone);
                holder.permissionName.setText(R.string.read_call_log);
                break;
            case "WRITE_CALL_LOG":
                holder.permissionIcon.setImageResource(R.drawable.ic_phone);
                holder.permissionName.setText(R.string.write_call_log);
                break;
            case "ADD_VOICEMAIL":
                holder.permissionIcon.setImageResource(R.drawable.ic_phone);
                holder.permissionName.setText(R.string.voicemail);
                break;
            case "USE_SIP":
                holder.permissionIcon.setImageResource(R.drawable.ic_phone);
                holder.permissionName.setText(R.string.sip);
                break;
            case "PROCESS_OUTGOING_CALLS":
                holder.permissionIcon.setImageResource(R.drawable.ic_phone);
                holder.permissionName.setText(R.string.outgoing_calls);
                break;
            case "BODY_SENSORS":
                holder.permissionIcon.setImageResource(R.drawable.ic_body);
                holder.permissionName.setText(R.string.sensors);
                break;
            case "SEND_SMS":
                holder.permissionIcon.setImageResource(R.drawable.ic_sms);
                holder.permissionName.setText(R.string.send_sms);
                break;
            case "RECEIVE_SMS":
                holder.permissionIcon.setImageResource(R.drawable.ic_sms);
                holder.permissionName.setText(R.string.receive_sms);
                break;
            case "READ_SMS":
                holder.permissionIcon.setImageResource(R.drawable.ic_sms);
                holder.permissionName.setText(R.string.read_sms);
                break;
            case "RECEIVE_WAP_PUSH":
                holder.permissionIcon.setImageResource(R.drawable.ic_sms);
                holder.permissionName.setText(R.string.wap);
                break;
            case "RECEIVE_MMS":
                holder.permissionIcon.setImageResource(R.drawable.ic_sms);
                holder.permissionName.setText(R.string.receive_mms);
                break;
            case "READ_EXTERNAL_STORAGE":
                holder.permissionIcon.setImageResource(R.drawable.ic_storage);
                holder.permissionName.setText(R.string.r_ext_storage);
                break;
            case "WRITE_EXTERNAL_STORAGE":
                holder.permissionIcon.setImageResource(R.drawable.ic_storage);
                holder.permissionName.setText(R.string.w_ext_storage);
                break;
        }
        if (!TextUtils.isEmpty(permission.getExplanation())) {
            holder.permissionDesc.setText(permission.getExplanation());
            holder.permissionDesc.setVisibility(View.VISIBLE);
        } else {
            holder.permissionDesc.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return permissions.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView permissionIcon;
        TextView permissionName;
        TextView permissionDesc;

        public ViewHolder(View itemView) {
            super(itemView);

            permissionIcon = (ImageView) itemView.findViewById(R.id.permission_icon);
            permissionName = (TextView) itemView.findViewById(R.id.permission_name);
            permissionDesc = (TextView) itemView.findViewById(R.id.permission_desc);

            permissionIcon.setColorFilter(tintColor);
            permissionName.setTextColor(textColor);
            permissionDesc.setTextColor(textColorSecondary);
        }

    }

}
