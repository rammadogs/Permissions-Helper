package com.amqtech.permissions.helper.ui.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.amqtech.permissions.helper.R;
import com.amqtech.permissions.helper.objects.Permission;
import com.amqtech.permissions.helper.objects.PermissionsFlow;
import com.amqtech.permissions.helper.ui.adapter.PermissionsFlowAdapter;

public class PermissionsFlowActivity extends AppCompatActivity {

    private static final int PERM_REQUEST_CODE = 42;

    private Permission[] permissions;
    private RecyclerView recyclerView;
    private PermissionsFlowAdapter permissionsFlowAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        permissions = (Permission[]) getIntent().getExtras().getSerializable(PermissionsFlow.PERMISSIONS);
        if(permissions == null || permissions.length == 0) throw new RuntimeException("No permissions!");
        setContentView(R.layout.activity_permissions_flow);
        recyclerView = (RecyclerView) findViewById(R.id.perms_rv);
        recyclerView.setHasFixedSize(true);
        permissionsFlowAdapter = new PermissionsFlowAdapter(permissions);
        layoutManager = new LinearLayoutManager(this);
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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getBaseContext(), "Hi", Toast.LENGTH_SHORT).show();

                String[] permissionNames = new String[permissions.length];

                for(int i = 0; i < permissions.length; i++) {
                    permissionNames[i] = permissions[i].getPermissions().getPermission();
                }

                requestPermissions(permissionNames, PERM_REQUEST_CODE);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        Log.d("Log", "onRequestPermissionsResult()");
        for(int i = 0; i < permissions.length; i++) {
            if(grantResults[i] == PackageManager.PERMISSION_GRANTED) PermissionsFlow.permissionsFlow.callback.onPermissionGranted(getMatchingPermission(permissions[i]));
            else if(grantResults[i] == PackageManager.PERMISSION_DENIED) PermissionsFlow.permissionsFlow.callback.onPermissionDenied(getMatchingPermission(permissions[i]));
        }
    }

    private Permission getMatchingPermission(String permissionName) {
        for(Permission permission : permissions) {
            if(permissionName.equals(permission.getPermissions().getPermission())) return permission;
        }
        //should never happen
        return null;
    }

}
