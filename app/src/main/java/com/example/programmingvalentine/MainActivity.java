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
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ImageView imgView = null;
    TextView name, res;
    int[] percentages = new int[9];
    boolean checked[] = new boolean[9];
    Random rand = new Random();

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
        imgView = findViewById(R.id.imageView);


        String lang = parent.getItemAtPosition(position).toString();
        lang = lang.toLowerCase();
        percentages[position] = rand.nextInt(100);
        checked[position] = true;

        if(lang.equals("java")){
            imgView.setImageResource(R.drawable.java);
        }
        else if(lang.equals("javascript")){
            imgView.setImageResource(R.drawable.javascript);
        }
        else if(lang.equals("sql")){
            imgView.setImageResource(R.drawable.sql);
        }
        else if(lang.equals("python")){
            imgView.setImageResource(R.drawable.python);
        }
        else if(lang.equals("ruby")){
            imgView.setImageResource(R.drawable.ruby);
        }
        else if(lang.equals("go")){
            imgView.setImageResource(R.drawable.go);
        }
        else if(lang.equals("php")){
            imgView.setImageResource(R.drawable.php);
        }
        else if(lang.equals("c++")){
            imgView.setImageResource(R.drawable.cplusplus);
        }
        else if(lang.equals("c#")){
            imgView.setImageResource(R.drawable.csharp);
        }
        fillTable(parent, percentages);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
//for nothing
    }

    public void fillTable(AdapterView parent, int[] percentages){
        StringBuilder text = new StringBuilder();
        String lang;
        res = findViewById(R.id.results);

        for(int i = 1; i < 9; i++){
            lang = parent.getItemAtPosition(i).toString();
            if(checked[i] && percentages[i]!= 0) text.append("love result of \t\t"+ lang + "\t\t is: " + percentages[i] + "\n");
        }
        res.setText(text.toString());
    }
}