package com.example.ad.rock_paper_scissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Final extends AppCompatActivity {

    TextView ul, wi,pl,co;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        ul=(TextView)findViewById(R.id.UW);
        wi=(TextView) findViewById(R.id.WIN);


        String b = getIntent().getStringExtra("result");
        wi.setText(b);

    }
}

















































































































