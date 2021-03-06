package com.ryungna.actiprac;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.ryungna.actiprac.model.UserModel;

public class login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    Button join;
    Button login;
    EditText email;
    EditText passwd;


    String TAG ="Login Activity:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        join = (Button)findViewById(R.id.signUp);
        login = (Button)findViewById(R.id.signIn);
        email = (EditText) findViewById(R.id.email);
        passwd = (EditText) findViewById(R.id.passwd);
        //String stemail = email.getText().toString();


        mAuth = FirebaseAuth.getInstance();

        join.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(email.getText().toString()==null || passwd.getText().toString()==null)
                    return;
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), passwd.getText().toString())
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                UserModel userModel = new UserModel();
                                userModel.userName = email.getText().toString();

                                String uid = task.getResult().getUser().getUid();
                                FirebaseDatabase.getInstance().getReference().child("user").child(uid).setValue(userModel);

                                if (!task.isSuccessful()) {
                                    Toast.makeText(login.this, "가입 오류",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else{//성공적으로 가입이 되면
                                    Toast.makeText(login.this, "가입성공 \n HELLO dear",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });

            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                Intent in = new Intent(login.this, navigation.class);
                if (user != null) {
                    // 유저가 로그인할시에
                    startActivity(in);
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // 로그아웃일때
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInWithEmailAndPassword(email.getText().toString(), passwd.getText().toString())
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Intent toMain = new Intent(login.this,navigation.class);

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(login.this, "로그인 오류",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(login.this, "로그인 성공",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(toMain);
                                }

                                // ...
                            }
                        });



            }
        });

    }


    //언제든지 유저 정보를 가져올 수 있음 //사용자의 프로필을 가져옴
    //If a user has signed in successfully you can get their account data at any point with the getCurrentUser method.
    public void getCurrentUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


}

