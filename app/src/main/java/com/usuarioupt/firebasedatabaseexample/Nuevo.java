package com.usuarioupt.firebasedatabaseexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_LONG;

public class Nuevo extends AppCompatActivity {
    EditText tema;
    EditText llave;
    Button actualizar;
    EditText hecho_edit;
    String taskId;
    TextView h_importante;
    private Firebase mref;
    private DatabaseReference mDatabase;
    private static Context mContext;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mData = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_nuevo);
        tema= (EditText)findViewById(R.id.txt_tema) ;
        llave =(EditText)findViewById(R.id.txt_llave);
        actualizar = (Button) findViewById(R.id.btn_actualizar);
        hecho_edit = (EditText) findViewById(R.id.txt_hecho_edit);
        h_importante = (TextView) findViewById(R.id.lbl_h_importante);

        String v_tema = getIntent().getStringExtra("tema");
        final String v_llave = getIntent().getStringExtra("llave");
        final String v_echo = getIntent().getStringExtra("echo");

        tema.setText(v_tema);
        llave.setText(v_llave);
        String[] parte = v_echo.split("=");


        int en= parte.length;
        String mostrar="";

        if (en <=2){

            if (en==0){

                mostrar=mostrar+"HECHE RELEVANTE 1: \n";
                mostrar=mostrar+parte[1];
            }
            else {

                mostrar="HECHE RELEVANTE 2: \n";
                mostrar=mostrar+parte[0];
                mostrar=mostrar+"HECHE RELEVANTE 1: \n";
                mostrar=mostrar+parte[1];
            }

        }

        else{

            en = en-2;
            mostrar="HECHE RELEVANTE 1: \n";
            mostrar=mostrar+(parte[en]+"\n");
            mostrar=mostrar+"HECHE RELEVANTE 2: \n";
            mostrar=mostrar+(parte[en+1]);

        }

        h_importante.setText(mostrar);
        tema.setEnabled(false);
        llave.setEnabled(false);

         taskId = llave.getText().toString();

        String aRemplazar="hola como estas";
        String remplazado=aRemplazar.replace("a", "");

        mDatabase = FirebaseDatabase.getInstance().getReference();


        mContext=this;


        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String k = llave.getText().toString();
                mData
                        .child("users")
                        .child("80")
                        .child("temas")
                        .child(k)
                        .child("hecho").setValue(v_echo.toString()+"="+hecho_edit.getText().toString());
//
//                String Id = "-KlCX0J4DW4J_TkYefv2";
//                mref = new Firebase("https://fir-d77bf.firebaseio.com");
//
//
//
//                mDatabase.child("users").child("80").child("temas").child(Id).child("des").setValue("1111111111111111");

//
//                Firebase ref = Firebase(mref."https://<YOUR-FIREBASE-APP>.firebaseio.com");
//                Firebase userRef = ref.child("user");
//                Map newUserData = new HashMap();
//                newUserData.put("age", 30);
//                newUserData.put("city", "Provo, UT");
//                userRef.updateChildren(newUserData);

//                HashMap<String, Object> result = new HashMap<>();
//                result.put("des", "234");
//
//                FirebaseDatabase.getInstance().getReference().child("temas").child("-KlCX0J4DW4J_TkYefv2").updateChildren(result);
                Toast.makeText(view.getContext(),"aasdasdasd",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(mContext, MainActivity.class);


                mContext.startActivity(intent);
            }
        });



    }
}
