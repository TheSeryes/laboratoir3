package com.example.lab2;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

import androidx.annotation.NonNull;

interface Constants
{
    String TAG = "Labs";
}

public class MainActivity extends Activity  implements  Constants
{
    String m_NewName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate(" + savedInstanceState + ")");

        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonId);                    // Variable button   sert de reference a l'id du button   dans l interface
        TextView textView = findViewById(R.id.textViewId);              // Variable textView sert de reference a l'id du textView dans l interface
        EditText editText = findViewById(R.id.editTextId);              // Variable editText sert de reference a l'id du editText dans l interface

        button.setOnClickListener(v ->
        {
            textView.setText(editText.getText().toString());            // set le text du field dans le text view
            //m_NewName = textView.getText().toString();                  // set le editText dans une variable string
        });

        SharedPreferences sharedPreferences = getSharedPreferences("savedGame", 0);
        textView.setText(sharedPreferences.getString("editTextId", getString(R.string.helloworld)));

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        EditText editText = findViewById(R.id.editTextId);
        m_NewName = editText.getText().toString();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        TextView textView = findViewById(R.id.textViewId);
        EditText editText = findViewById(R.id.editTextId);
        textView.setText(editText.getText().toString());
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @SuppressLint("ApplySharedPref")
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");

        SharedPreferences sharedPreferences = getSharedPreferences("savedGame", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        TextView textView = findViewById(R.id.textViewId);
        editor.putString("textViewId", textView.getText().toString());

        editor.commit();
    }
}
