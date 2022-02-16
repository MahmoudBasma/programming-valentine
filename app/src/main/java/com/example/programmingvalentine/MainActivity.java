package com.example.programmingvalentine;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ImageView imgView = null;
    TextView name, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.dropList);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.langs, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);




    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        name = findViewById(R.id.name);
        res = findViewById(R.id.results);

        if (imgView != null){
            imgView.setImageResource(0);
        }
        String lang = parent.getItemAtPosition(position).toString();
        switch (lang){
            case "Java":
                imgView.setImageResource(R.drawable.java);
            case "Python":
                imgView.setImageResource(R.drawable.python);
            case "PHP":
                imgView.setImageResource(R.drawable.php);
            case "JavaScript":
                imgView.setImageResource(R.drawable.javascript);
            case "GO":
                imgView.setImageResource(R.drawable.go);
            case "Ruby":
                imgView.setImageResource(R.drawable.ruby);
            case "C++":
                imgView.setImageResource(R.drawable.cplusplus);
            case "C#":
                imgView.setImageResource(R.drawable.csharp);
        }

        res.setText("Waiting for love results ...");

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
//for nothing





    }
}