package com.usuarioupt.firebasedatabaseexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by USUARIOUPT on 15/05/2017.
 */

public class AddMovieFragment extends Fragment implements View.OnClickListener{
    private DatabaseReference mDatabaseReference;
    private TextInputEditText movieName;
    private TextInputEditText movieLogo;
    private TextInputEditText hecho;
    private TextInputEditText des;

    private RatingBar mRatingBar;
    private Button bSubmit;


//    private String titulo;
//    private String link;
//
//    @Override
//    public void onCreate(Bundle saveIntanceState){
//            super.onCreate(saveIntanceState);
////        if (getArguments() != null){
////
////            titulo= getArguments().getString("titulo","nohay nada");
////            link = getArguments().getString("link","nohay nada");
////
////        }
//
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.movie_fragment,container,false);
        movieName = (TextInputEditText) v.findViewById(R.id.tiet_movie_name);
        movieLogo = (TextInputEditText) v.findViewById(R.id.tiet_movie_logo);
        hecho = (TextInputEditText) v.findViewById(R.id.txt_hecho);
        des = (TextInputEditText) v.findViewById(R.id.txt_des);

        bSubmit = (Button) v.findViewById(R.id.b_submit);
       // mRatingBar = (RatingBar) v.findViewById(R.id.rating_bar);
        //initializing database reference
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        if (titulo != null){
//
//            movieName.setText(titulo);
//            movieLogo.setText(link);
//        }

        bSubmit.setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.b_submit:
                if(!isEmpty(movieName) && !isEmpty(movieName)){
                    myNewMovie("80", movieName.getText().toString().trim(),movieLogo.getText().toString(),hecho.getText().toString(),des.getText().toString());
                }else{
                    if(isEmpty(movieName)){
                        Toast.makeText(getContext(), "Llene campo!", Toast.LENGTH_SHORT).show();
                    }else if(isEmpty(movieLogo)){
                        Toast.makeText(getContext(), "Llene url", Toast.LENGTH_SHORT).show();
                    }
                }
                //to remove current fragment
                getActivity().onBackPressed();
                break;
        }
    }
    private void myNewMovie(String userId, String movieName, String moviePoster,String hecho,String des) {
        //String key=mDatabaseReference.child("users").child(userId).child("temas").getKey();
       // Toast.makeText(getContext(),key,Toast.LENGTH_SHORT).show();
        //Creating a movie object with user defined variables

        Movie movie = new Movie(movieName,moviePoster,hecho,des);
        //referring to movies node and setting the values from movie object to that location
        mDatabaseReference.child("users").child(userId).child("temas").push().setValue(movie);
    }
    //check if edittext is empty
    private boolean isEmpty(TextInputEditText textInputEditText) {
        if (textInputEditText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }


}
