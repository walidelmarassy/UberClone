package com.example.waleed.uberclone;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {
    Button btnsignup,btnsignin;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    RelativeLayout rootlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        db=FirebaseDatabase.getInstance();
        users=db.getReference("Users");
        btnsignup=(Button)findViewById(R.id.signup);
        btnsignin=(Button)findViewById(R.id.signin);
        rootlayout=(RelativeLayout)findViewById(R.id.rootlayout);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showsignupDialog();
            }
        });
    }

    private void showsignupDialog() {
        final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("REGISTER");
        dialog.setMessage("PLEASE USE EMAIL TO REGISTER");
        LayoutInflater inflater=LayoutInflater.from(this);
        View register_layout=inflater.inflate(R.layout.layout_register,null);
        final MaterialEditText edtEmail=register_layout.findViewById(R.id.edtEmail);
        MaterialEditText edtName=register_layout.findViewById(R.id.edtName);
        MaterialEditText edtpassword=register_layout.findViewById(R.id.edtpassword);
        MaterialEditText edtphone=register_layout.findViewById(R.id.edtphone);
        dialog.setView(register_layout);
        //set button
        dialog.setPositiveButton("REGISTER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (TextUtils.isEmpty(edtEmail.getText().toString()))
                {


                }

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });



    }
}
