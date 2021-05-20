package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText input;
    Button btn;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input =(EditText)findViewById(R.id.input);
        btn=(Button)findViewById(R.id.submit);
        btn.setOnClickListener(this);
        tts=new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                    Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_LONG).show();
            }
        });
        tts.setLanguage(Locale.ENGLISH);

    }

    @Override
    public void onClick(View view) {
        String text=input.getText().toString();
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}