package com.example.examen.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examen.Presentador.Presenter;
import com.example.examen.Presentador.PresenterInt;
import com.example.examen.R;

//Escuela profesional de ingenieria de sistemas - UNSA
// Mayer Augusto Cutipa Condori @2021

public class MainActivity extends AppCompatActivity implements ViewInt {
    private PresenterInt presenter;
    private TextView Name;
    private TextView Travel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
        Name = findViewById(R.id.textView2);
        Travel  = findViewById(R.id.textView3);
    }
    public void goToRegister(View view){
        Intent intent = new Intent(this, register.class);
        startActivityForResult(intent, 1);
    }
    public void goToTravel(View view){
        Intent intent = new Intent(this, travel.class);
        startActivityForResult(intent, 2);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                final String get_name = data.getStringExtra("name");
                final String get_email = data.getStringExtra("email");
                final String get_password = data.getStringExtra("password");
                presenter.register(get_name,get_email,get_password);

            }else{
                Toast.makeText(this, "Error al recibir los datos", Toast.LENGTH_SHORT).show();
            }

        }
        if (requestCode == 2){
            if(resultCode == Activity.RESULT_OK){
                final String myLocation = data.getStringExtra("myLocation");
                final String myDestiny = data.getStringExtra("myDestiny");
                presenter.registerTravel(myLocation,myDestiny);

            }else{
                Toast.makeText(this, "Error al recibir los datos", Toast.LENGTH_SHORT).show();
            }
        }

    }


    @Override
    public void showName(String name) {
        Name.setText("Bienvenido:" + name);
    }

    @Override
    public void showTravels(String travels) {
        Travel.setText(travels);
    }
}