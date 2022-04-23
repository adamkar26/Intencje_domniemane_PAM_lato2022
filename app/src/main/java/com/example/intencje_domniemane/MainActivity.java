package com.example.intencje_domniemane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void www(View view){
        EditText editText = findViewById(R.id.editTextWWW);
        String adres = editText.getText().toString();
        // tworze URI (rozszerznie URL)
        Uri uri = Uri.parse("http://"+adres);
        // intencja domniemana
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
    public void map(View view){
        EditText editText = findViewById(R.id.editTextCity);
        String city = editText.getText().toString();
        // tworze URI (rozszerznie URL)
        Uri uri = Uri.parse("geo:0,0?q="+city);
        // intencja domniemana
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
    public void cords(View view){
        EditText editText1 = findViewById(R.id.editTextCordsW);
        EditText editText2 = findViewById(R.id.editTextCordsL);
        String lattiude = editText1.getText().toString();
        String longitiude = editText2.getText().toString();
        // tworze URI (rozszerznie URL)
        String s = String.format("geo:%s,%s", lattiude, longitiude);
        Uri uri = Uri.parse(s);
        // intencja domniemana
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
    public void alarm(View view){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Pora wstawać");
        intent.putExtra(AlarmClock.EXTRA_HOUR, 16);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 45);
        startActivity(intent);

    }
    public void timer(View view){
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Odliczanie");
        intent.putExtra(AlarmClock.EXTRA_LENGTH, 15);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI, true);

        startActivity(intent);

    }
}