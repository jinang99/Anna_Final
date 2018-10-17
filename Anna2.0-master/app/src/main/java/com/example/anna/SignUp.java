package com.example.anna;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
        EditText siname, sipassword, siphone;
        Button sisignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sipassword= (EditText)findViewById(R.id.epasswd);
        siname = (EditText)findViewById(R.id.eName);
        siphone = (EditText)findViewById(R.id.ephonenum);
        sisignup = (Button)findViewById(R.id.eSignUp);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user =database.getReference().child("user");// reference variable declared for table_user
        sisignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDial = new ProgressDialog(SignUp.this);
                mDial.setMessage("Please Wait");
                mDial.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(siphone.getText().toString()).exists()){
                            mDial.dismiss();
                            Toast.makeText(SignUp.this, "User already Registered", Toast.LENGTH_SHORT ).show();
                        }
                        else{
                            mDial.dismiss();
                            User user = new User(sipassword.getText().toString(), siname.getText().toString());
                            table_user.child(siphone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                            finish();
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
