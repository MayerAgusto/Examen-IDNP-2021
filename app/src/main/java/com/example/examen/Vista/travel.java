package com.example.examen.Vista;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;

import com.example.examen.R;
import com.example.examen.Vista.MainActivity;


public class travel extends AppCompatActivity {
    private EditText myLocation, myDestiny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        myLocation = findViewById(R.id.editTextTextPersonName2);
        myDestiny = findViewById(R.id.editTextTextPersonName3);

    }
    public void seeMap(View view){
        String myDestinytxt = myDestiny.getText().toString();
        String urldestino="";

        for(int i = 1; i<myDestinytxt.length() ; i++){
            if (myDestinytxt.substring(i-1,i) ==" "){
                urldestino +="+";
            }else{
                urldestino+= myDestinytxt.substring(i-1,i);
            }
        }
        Uri uri = Uri.parse("google.navigation:q=" + myDestinytxt);
        Intent mapa = new Intent(Intent.ACTION_VIEW,uri );
        mapa.setPackage("com.google.android.apps.maps");
        startActivity(mapa);

    }
    public void save(View view){
        Intent intent = new Intent();
        intent.putExtra("myLocation", myLocation.getText().toString());
        intent.putExtra("myDestiny", myDestiny.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
    public void  cancelButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}