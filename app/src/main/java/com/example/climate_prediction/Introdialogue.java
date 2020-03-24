package com.example.climate_prediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Introdialogue extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button button;
    int clickcount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introdialogue);

        imageView = (ImageView) findViewById(R.id.intro_dialogue_displayed_image);
        textView = (TextView) findViewById(R.id.intro_dialogue_displayed_Text);
        button = (Button) findViewById(R.id.intro_dialogue_next_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeUIElemnts();
            }
        });

    }
    //This is for the different Elements that shall be displayed during the Introduction
    private void changeUIElemnts() {
        switch(clickcount){
            case 1:
                System.out.println("We´re in case 1");
                textView.setText(R.string.intro_dialogue_1_text);
                imageView.setImageURI(MyGlobals.resourceToUri(this, R.drawable.img45754828));
                break;
            case 2:
                System.out.println("We´re in case 2");
                textView.setText(R.string.intro_dialogue_2_text);
                imageView.setImageURI(MyGlobals.resourceToUri(this, R.drawable.kernkonzepte_wg2_ar5));
                break;
            case 3:
                System.out.println("Last Page before going to the Main Page");
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        clickcount++;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    public void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
