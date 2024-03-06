package com.example.rownaniekwadratowe;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button oblicz = findViewById(R.id.oblicz);
        EditText aField = findViewById(R.id.aField);
        EditText bField = findViewById(R.id.bField);
        EditText cField = findViewById(R.id.cField);
        EditText result = findViewById(R.id.result);


        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int parseb = Integer.parseInt(String.valueOf(bField));
                int parsea = Integer.parseInt(String.valueOf(aField));
                int parsec = Integer.parseInt(String.valueOf(cField));

                double delta = Math.pow(parseb, 2) - 4 * parsea * parsec;
                double sqrtdelta = Math.sqrt(delta);

                if(sqrtdelta < 0){
                    Toast.makeText(MainActivity.this, "brak rozwiązań", Toast.LENGTH_SHORT).show();
                }
                else if(sqrtdelta == 0){
                    int x = -parseb/2*parsea;
                    result.setText(String.valueOf(x));
                }
                else {
                    int x1 = (int) ((-parseb + sqrtdelta) / 2 * parsea);
                    int x2 = (int) ((-parseb - sqrtdelta) / 2 * parsea);
                    result.setText(String.valueOf(x1));
                }







            }
        });

    }
}