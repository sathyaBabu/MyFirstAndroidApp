package com.edu.rd.debug.myfirstandroidapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyLoginActivity extends AppCompatActivity {

    private static final String KEY_USERNAME = "username" ;
    private static final String KEY_PW       = "pw";

    Button   login ;
    EditText userName ;
    EditText pw ;
    TextView textView;

    // Constructor...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.editTextUsername) ;
        pw       = (EditText) findViewById(R.id.editTextpassWord) ;
        textView = (TextView) findViewById(R.id.textView) ;


        login    = (Button) findViewById(R.id.buttonLogin) ;




        Log.d("tag","onCreate");




    }

    @Override
    protected void onStart() {

        // restore the value of your youtube to 1:30
        Log.d("tag","onStart");
        super.onStart();
    }


   // sathyahelp123@gmail.com

    @Override
    protected void onResume() {
        // It plays from the place where we left..
        Log.d("tag","onResume");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Lets pass the data for validation
                // Validation will happen in LoginAuth Activity...

                // Lets call the Activity..

                // it takes the data as KEY, VALUE pair...
                Bundle bundle = new Bundle();

                bundle.putString(KEY_USERNAME,userName.getText().toString());
                bundle.putString(KEY_PW,pw.getText().toString());



                Intent intent = new Intent(MyLoginActivity.this,LoginAuth.class);
                intent.putExtras(bundle);


                // Phase I

              //  startActivity(intent);  // This cannot get results from Another activity..


                // Phase II

                startActivityForResult(intent,201); // Ohh.. are we waiting for the data???
                // YEP..
                // How do we have to receive the data ???

                // we have to override a method : onActivityResult to receive the data.. Down below..

                // I want to send the data to an unknown activity..
                // Broadcast receiver....

                // binder is involved...

                Log.d("tag"," User Name "+userName.getText().toString()+" PW : "+pw.getText().toString());
                Toast.makeText(MyLoginActivity.this, " "+userName.getText().toString()+" PW : "+pw.getText().toString(),
                        Toast.LENGTH_SHORT).show();




            }
        });

        super.onResume();
    }


    // Since orientation is changed we will loose all the tmp values video time 1:30

    @Override
    protected void onPause() {

        // store the video time 1:30
        Log.d("tag","onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("tag","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("tag","onDestroy");
        super.onDestroy();
    }
// Lets receive the data from LoginAuth Activity... Success or Failure..
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if( requestCode == 201){

            String msg = data.getStringExtra("MESSAGE");
            textView.setText(" Result : "+msg);

//            if( msg.equalsIgnoreCase("bangalore")){
//
//                Intent intent1 = new Intent(MyLoginActivity.this,BusinessLogic.class);
            //
//
//            }

        }


    }
}


//  style="@style/text_view_style"