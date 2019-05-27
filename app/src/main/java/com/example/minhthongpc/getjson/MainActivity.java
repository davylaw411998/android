package com.example.minhthongpc.getjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button btnget;
    private String url;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getJson(View view)
    {
        editText = findViewById(R.id.edittext);
        btnget=findViewById(R.id.btnget);
        url=String.valueOf(editText.getText());

        intent = new Intent(this,Activity2.class);
        intent.putExtra("Url", url);
        startActivity(intent);
    }
}
