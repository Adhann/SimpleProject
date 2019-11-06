package com.example.simpleproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button btn_signUp;
    EditText etEmail, etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_signup);

        btn_signUp = findViewById(R.id.SignUp);
        etEmail = findViewById(R.id.tvEmail);
        etPassword = findViewById(R.id.tvPassword);

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputEmail = etEmail.getText().toString();
                String inputPassword = etPassword.getText().toString();

               try {
                   mAuth.createUserWithEmailAndPassword(inputEmail, inputPassword)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()) {
                                       // Sign in success, update UI with the signed-in user's information
                                       Log.d("ContentValues", "createUserWithEmail:success");
                                       FirebaseUser user = mAuth.getCurrentUser();
                                   } else {
                                       // If sign in fails, display a message to the user.
                                       Log.w("ContentValues", "createUserWithEmail:failure", task.getException());
                                       Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                               Toast.LENGTH_SHORT).show();
                                   }
                               }
                           });
               }catch (Exception e) {
                   Toast.makeText(getApplicationContext(), "Authentication gagal. " + e.getMessage(),
                           Toast.LENGTH_SHORT).show();
               }
            }
        });


    }

}
