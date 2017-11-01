package com.example.amira.note;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.HashSet;

import static com.example.amira.note.MainActivity.mylist;
import static com.example.amira.note.MainActivity.set;


public class EditUrNote extends AppCompatActivity {
    int Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ur_note);
        Intent I = getIntent();
         Id = I.getIntExtra("NoteId", -1);
        EditText editText = (EditText) findViewById(R.id.editText);
        if (Id != -1) {

            editText.setText(mylist.get(Id));
        }
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    MainActivity.mylist.set(Id, String.valueOf(charSequence));
                    MainActivity.arrayAdapter.notifyDataSetChanged();
                }



                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
    }

}
