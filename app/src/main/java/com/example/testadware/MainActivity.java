package com.example.testadware;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

@Override  
protected void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  

    LinearLayout layout = new LinearLayout(this);  
    layout.setOrientation(LinearLayout.VERTICAL);  
    layout.setGravity(Gravity.CENTER);  
    layout.setPadding(30, 30, 30, 30);  
    layout.setBackgroundColor(Color.WHITE);  

    TextView title = new TextView(this);  
    title.setText("⚠️ Adware aşkarlandı");  
    title.setTextSize(28);  
    title.setTypeface(null, Typeface.BOLD);  
    title.setTextColor(Color.RED);  
    title.setGravity(Gravity.CENTER);  

    TextView message = new TextView(this);  
    message.setText(  
        "\nBu, yalnız TEST xəbərdarlığıdır.\n\n" +  
        "Həqiqi virus və ya adware yoxdur."  
    );  
    message.setTextSize(18);  
    message.setTextColor(Color.DKGRAY);  
    message.setGravity(Gravity.CENTER);  

    layout.addView(title);  
    layout.addView(message);  

    setContentView(layout);  
}

}
