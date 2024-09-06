package com.example.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    EditText edusername, edpassword,edcpassword;
    Button signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        edusername=findViewById(R.id.username);
        edpassword=findViewById(R.id.password);
        edcpassword=findViewById(R.id.confirmPassword);
        signupbtn=findViewById(R.id.signupButton);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edusername.getText().toString();
                String password=edpassword.getText().toString();
                String confirmPassword=edcpassword.getText().toString();


                if (credentialsCheck(username,password,confirmPassword)){

                    Toast.makeText(getApplicationContext(),"Sign UP succesfull",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please Enter Valid credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean credentialsCheck(String username, String password ,String confirmPassword){
        if (username.length()==0 || password.length()==0 || confirmPassword.length()==0 || (!password.equals(confirmPassword))){
            return false;
        }
        return true;
    }
}