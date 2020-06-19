package com.hp.bmi_kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.xw.repo.BubbleSeekBar;

public class Test extends AppCompatActivity {

    BubbleSeekBar bubbleSeekBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         bubbleSeekBar = findViewById(R.id.seek_height);
         textView = (TextView) textView.findViewById(R.id.height_value);

         bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListenerAdapter() {
             @Override
             public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                 super.onProgressChanged(bubbleSeekBar, progress, progressFloat, fromUser);


             }

             @Override
             public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
                 super.getProgressOnActionUp(bubbleSeekBar, progress, progressFloat);
             }

             @Override
             public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                 super.getProgressOnFinally(bubbleSeekBar, progress, progressFloat, fromUser);
             }
         });

    }
}