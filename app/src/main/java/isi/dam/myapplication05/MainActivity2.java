package isi.dam.myapplication05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String dato = getIntent().getExtras().getString("datox");
        Log.d("MAIN_ACTIVITY_2", "onCreate: "+dato);
    }
}