package com.example.anna;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anna.Common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    EditText editPhone, editPassword;
    Button fSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editPassword = (EditText)findViewById(R.id.passwd);
        editPhone = (EditText)findViewById(R.id.phonenum);
        fSignIn = (Button)findViewById(R.id.btnSignIn);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference().child("user");

        fSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDial = new ProgressDialog(SignIn.this);
                mDial.setMessage("Please Wait");
                mDial.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(editPhone.getText().toString()).exists()){
                            mDial.dismiss();

                        User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                        user.setPhone(editPhone.getText().toString());

                        if(user.getPassword().equals(editPassword.getText().toString())){
                            Toast.makeText(SignIn.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(SignIn.this, Home.class);
                            Common.currentUser = user;
                                startActivity(homeIntent);
                                finish();
                        }
                        else{
                            Toast.makeText(SignIn.this, "Sign In Failed", Toast.LENGTH_SHORT).show();

                        }}
                        else
                        { mDial.dismiss();
                            Toast.makeText(SignIn.this, "User does not exist", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
