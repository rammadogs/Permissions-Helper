package com.amqtech.permissions.helper.ui.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amqtech.permissions.helper.R;
import com.amqtech.permissions.helper.objects.Permission;
import com.amqtech.permissions.helper.objects.PermissionsFlow;
import com.amqtech.permissions.helper.ui.adapter.PermissionsFlowAdapter;

public class PermissionsFlowActivity extends AppCompatActivity {

    private static final int PERM_REQUEST_CODE = 42;

    private Permission[] permissions;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings("ConstantConditions")
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        permissions = (Permission[]) getIntent().getExtras().getSerializable(PermissionsFlow.PERMISSIONS);

        if (permissions == null || permissions.length == 0)
            throw new RuntimeException("No permissions!");

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(darkenColor(getIntent().getExtras().getInt(PermissionsFlow.STATUS_BAR_COLOR), 0.8f));
        window.setNavigationBarColor(darkenColor(getIntent().getExtras().getInt(PermissionsFlow.NAVIGATION_BAR_COLOR), 0.8f));

        if (getIntent().getExtras().getBoolean(PermissionsFlow.LIGHT_STATUS_BAR)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }

        setContentView(R.layout.activity_permissions_flow);

        TextView infoTV = (TextView) findViewById(R.id.perms_flow_info);
        infoTV.setText(PermissionsFlow.APP_NAME
                + " " + getResources().getString(R.string.perms_static_info));
        infoTV.setTextColor(getIntent().getExtras().getInt(PermissionsFlow.TEXT_COLOR));

        RelativeLayout rel = (RelativeLayout) findViewById(R.id.perms_bg);
        rel.setBackgroundColor(getIntent().getExtras().getInt(PermissionsFlow.BG_COLOR));

        LinearLayout ll = (LinearLayout) findViewById(R.id.button_bar);
        ll.setBackgroundColor(getIntent().getExtras().getInt(PermissionsFlow.BAR_COLOR));

        TextView header = (TextView) findViewById(R.id.perms_flow_header);
        header.setTextColor(getIntent().getExtras().getInt(PermissionsFlow.TEXT_COLOR));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.perms_rv);
        recyclerView.setHasFixedSize(true);

        PermissionsFlowAdapter permissionsFlowAdapter = new PermissionsFlowAdapter(permissions,
                getIntent().getExtras().getInt(PermissionsFlow.TEXT_COLOR));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(permissionsFlowAdapter);

        Button cancel = (Button) findViewById(R.id.cancel_btn);
        Button next = (Button) findViewById(R.id.continue_btn);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cancel.setTextColor(getIntent().getExtras().getInt(PermissionsFlow.TEXT_COLOR));

        next.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                String[] permissionNames = new String[permissions.length];
                for(int i = 0; i < permissions.length; i++) {
                    permissionNames[i] = permissions[i].getPermissions().getPermission();
                }
                requestPermissions(permissionNames, PERM_REQUEST_CODE);
            }
        });
        next.setTextColor(getIntent().getExtras().getInt(PermissionsFlow.TEXT_COLOR));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        Log.d("Log", "onRequestPermissionsResult()");
        for(int i = 0; i < permissions.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                PermissionsFlow.permissionsFlow.callback.onPermissionGranted(getMatchingPermission(permissions[i]));
            else if (grantResults[i] == PackageManager.PERMISSION_DENIED)
                PermissionsFlow.permissionsFlow.callback.onPermissionDenied(getMatchingPermission(permissions[i]));
        }
        finish();
    }

    private Permission getMatchingPermission(String permissionName) {
        for(Permission permission : permissions) {
            if(permissionName.equals(permission.getPermissions().getPermission())) return permission;
        }
        //should never happen
        return null;
    }

    /**
     * Darkens a color based on the float value entered.
     *
     * @param color  your color int.
     * @param factor 0.1 = 90% dark; 0.9 = 10% dark.
     * @return Color int.
     */
    public static int darkenColor(int color, float factor) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= factor;
        return Color.HSVToColor(hsv);
    }

}
