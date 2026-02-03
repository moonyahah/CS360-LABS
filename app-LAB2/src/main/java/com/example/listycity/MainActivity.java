package com.example.listycity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    Button addCityBtn, removeCityBtn, confirmBtn;
    EditText cityInput;
    LinearLayout addCityLayout;

    int selectedPosition = -1;

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        String []cities = {"Edmonton", "Lahore", "Athens", "Chicago", "Ibiza", "Stockholm", "Mumbai", "Tokyo", "Sydney"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        cityList.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition = position;
        });

        addCityBtn = findViewById(R.id.button);        // Add City
        removeCityBtn = findViewById(R.id.button2);   // Remove City
        confirmBtn = findViewById(R.id.confirm_btn);
        cityInput = findViewById(R.id.city_input);
        addCityLayout = findViewById(R.id.add_city_layout);

        addCityBtn.setOnClickListener(v -> {
            addCityLayout.setVisibility(View.VISIBLE);
            cityInput.requestFocus();
        });

        confirmBtn.setOnClickListener(v -> {
            String city = cityInput.getText().toString().trim();

            if (!city.isEmpty()) {
                dataList.add(city);
                cityAdapter.notifyDataSetChanged();
            }

            cityInput.setText("");
            addCityLayout.setVisibility(View.GONE);
            selectedPosition = -1;
        });

        removeCityBtn.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                dataList.remove(selectedPosition);
                cityAdapter.notifyDataSetChanged();
                selectedPosition = -1;
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}