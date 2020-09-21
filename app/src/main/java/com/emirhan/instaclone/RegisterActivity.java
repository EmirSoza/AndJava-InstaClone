package com.emirhan.instaclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity  {
    private FirebaseAuth mAuth;
    EditText emailText, passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null){
            Intent intent = new Intent(RegisterActivity.this, FeedActivity.class);
            startActivity(intent);
            finish();
        }

    }

    public void login(View view){
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(RegisterActivity.this, "SignIn Successful",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, FeedActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this,e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

    public void signUp(View view){
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(RegisterActivity.this, "User Created",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, FeedActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this,e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}