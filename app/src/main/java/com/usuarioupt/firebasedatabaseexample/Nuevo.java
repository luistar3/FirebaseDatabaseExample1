package com.usuarioupt.firebasedatabaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Nuevo extends AppCompatActivity {
    EditText tema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        tema= (EditText)findViewById(R.id.txt_tema) ;
        String nombre = getIntent().getStringExtra("tema");

        tema.setText(nombre);

    }
}
