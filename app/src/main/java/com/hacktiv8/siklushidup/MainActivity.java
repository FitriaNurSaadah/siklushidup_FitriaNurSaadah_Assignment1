package com.hacktiv8.siklushidup;

import java.util.logging.Logger;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "SIKLUS HIDUP ACT";
    EditText komentarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(TAG + "On Create");

        komentarText =(EditText) findViewById(R.id.komentar_text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "On Stop", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Star");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Resume");

        //Ambil data yang tersimpan
        String dataTersimpan = this.getSharedPreferences("siklus hidup", Context.MODE_PRIVATE).getString("komentar", null);
        komentarText.setText(dataTersimpan);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT);
        System.out.println(TAG + "On Destroy");

        //Simpan data komentar
        SharedPreferences.Editor data = this.getSharedPreferences("siklus hidup", Context.MODE_PRIVATE).edit();
        data.putString("komentar", komentarText.getText().toString());
        data.commit();

    }
}