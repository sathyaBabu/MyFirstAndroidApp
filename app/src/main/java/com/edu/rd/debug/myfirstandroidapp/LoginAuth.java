package com.edu.rd.debug.myfirstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class LoginAuth extends AppCompatActivity {


    private static final String KEY_USERNAME = "username" ;
    private static final String KEY_PW       = "pw";

    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_auth);

        textView = (TextView) findViewById(R.id.textView) ;

        Bundle bundle = getIntent().getExtras();


        String userName = bundle.getString(KEY_USERNAME);
        String pw       = bundle.getString(KEY_PW);


        textView.setText("User Name "+userName+" \n Pass Word "+pw);
       // textView.setTextColor(Color.RED);

//
//      Intent intent = new Intent(LoginAuth.this,MyLoginActivity.class);
//        startActivity(intent);

        // Not a right way to deal with since it creates yet another coppy of MyLoginActivity
        // Then How ???



        Intent intent = new Intent();




        if(pw.equalsIgnoreCase("bangalore")){
           intent.putExtra("MESSAGE","Success......");
           // call your business logic right from here...
            finish();

        }else {

            intent.putExtra("MESSAGE","Failure......");
        }

        setResult(201,intent);// via this method we will send the data back to the main Activity
        finish();  /// kills the current activity..
    }
}
