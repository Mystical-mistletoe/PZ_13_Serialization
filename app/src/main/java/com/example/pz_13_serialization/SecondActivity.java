package com.example.pz_13_serialization;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(26);
        textView.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();
        User user;
        if(arguments != null){
            user = arguments.getParcelable(User.class.getSimpleName());

            String result = "Имя: " + user.getName() +
                    "\nОрганизация: " + user.getCompany() +
                    "\nВозраст: " + user.getAge();

            if (user.getPhone() != null && !user.getPhone().isEmpty()) {
                result += "\nТелефон: " + user.getPhone();
            }
            if (user.getAddress() != null && !user.getAddress().isEmpty()) {
                result += "\nАдрес: " + user.getAddress();
            }

            textView.setText(result);
        }
        setContentView(textView);
    }
}