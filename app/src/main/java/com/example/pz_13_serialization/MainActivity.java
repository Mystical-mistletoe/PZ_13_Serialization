package com.example.pz_13_serialization;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v) {
        EditText nameText = findViewById(R.id.name);
        EditText companyText = findViewById(R.id.company);
        EditText ageText = findViewById(R.id.age);
        EditText phoneText = findViewById(R.id.phone);
        EditText addressText = findViewById(R.id.address);

        String name = nameText.getText().toString().trim();
        String company = companyText.getText().toString().trim();
        String ageStr = ageText.getText().toString().trim();
        String phone = phoneText.getText().toString().trim();
        String address = addressText.getText().toString().trim();

        if (name.isEmpty() || company.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(this, "Заполните обязательные поля (Имя, организация, возраст)!", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);

        User user = new User(name, company, age, phone, address);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(User.class.getSimpleName(), user);
        startActivity(intent);
    }
}