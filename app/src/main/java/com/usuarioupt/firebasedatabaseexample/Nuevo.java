package com.usuarioupt.firebasedatabaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;

public class Nuevo extends AppCompatActivity {
    EditText tema;
    EditText llave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_nuevo);
        tema= (EditText)findViewById(R.id.txt_tema) ;
        llave =(EditText)findViewById(R.id.txt_llave);
        String v_tema = getIntent().getStringExtra("tema");
        String v_llave = getIntent().getStringExtra("llave");

        tema.setText(v_tema);






    }
}
