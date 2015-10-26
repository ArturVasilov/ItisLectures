package itis.homework.simpleservicesample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent restartIntent = new Intent(this, AppRestartService.class);
        startService(restartIntent);

        Intent toastIntent = new Intent(this, ToastService.class);
        startService(toastIntent);
    }

}


