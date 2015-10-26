package itis.homework.patternaimpl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import itis.homework.patternaimpl.network.MessagesService;
import itis.homework.patternaimpl.network.Processor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MessagesService.start(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Processor.get(this).executeRequest();
    }
}


