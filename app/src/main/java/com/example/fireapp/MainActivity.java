package com.example.fireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText name,position;
    DAOEmployee dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.Name);
        position = findViewById(R.id.Position);
        dao = new DAOEmployee();
    }
    public  void button(View v){
        Employee emp = new Employee(name.getText().toString(), position.getText().toString());
        dao.add(emp).addOnSuccessListener(suc->
        {
            Toast.makeText(this, "Record instert",Toast.LENGTH_LONG).show();
        }).addOnFailureListener(er->
        {
            Toast.makeText(this, ""+er.getMessage(),Toast.LENGTH_LONG).show();
        });
        /*HashMap<String, Object>hashMap= new HashMap<>();
        hashMap.put("name",name.getText().toString());
        hashMap.put("posiiton",position.getText().toString());
        Employee emp = new Employee(name.getText().toString(), position.getText().toString());
        dao.update("key",hashMap).addOnSuccessListener(suc->
        {
            Toast.makeText(this, "Record updated",Toast.LENGTH_LONG).show();
        }).addOnFailureListener(er->
        {
            Toast.makeText(this, ""+er.getMessage(),Toast.LENGTH_LONG).show();
        });*/
        /*Employee emp = new Employee(name.getText().toString(), position.getText().toString());
        dao.remove("key").addOnSuccessListener(suc->
        {
            Toast.makeText(this, "Record removed",Toast.LENGTH_LONG).show();
        }).addOnFailureListener(er->
        {
            Toast.makeText(this, ""+er.getMessage(),Toast.LENGTH_LONG).show();
        });*/

    }
}