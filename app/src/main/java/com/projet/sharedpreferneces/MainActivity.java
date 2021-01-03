package com.projet.sharedpreferneces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences Preferences;
    private SharedPreferences.Editor editeurobject;
    private EditText user,password;
    private CheckBox checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.id_name);
        password = findViewById(R.id.id_pass);
        Button btnlogin = findViewById(R.id.button_log);
        checkbox = findViewById(R.id.checkbox);
        Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editeurobject = Preferences.edit();
        CheckSharedPreferences();
        btnlogin.setOnClickListener(v -> {
            if(checkbox.isChecked()){
                editeurobject.putString(getString(R.string.checkbox),"true");
                editeurobject.apply();
                String nom = user.getText().toString();
                editeurobject.putString(getString(R.string.nom),nom);
                editeurobject.commit();
                String pass = password.getText().toString();
                editeurobject.putString(getString(R.string.pass),pass);
                editeurobject.commit();
            }else{
                editeurobject.putString(getString(R.string.checkbox),"false");
                editeurobject.commit();
                editeurobject.putString(getString(R.string.nom),"");
                editeurobject.commit();
                editeurobject.putString(getString(R.string.pass),"");
                editeurobject.commit();
            }
        });
    }
    private void CheckSharedPreferences(){
        String nom = Preferences.getString(getString(R.string.nom),"");
        String pass = Preferences.getString(getString(R.string.pass),"");
        user.setText(nom);
        password.setText(pass);
        checkbox.setChecked(checkbox.equals("true"));

    }
}