package com.example.testadware;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Tətbiq açılanda 20 saniyəlik bildirim dövrünü başladır
        start20SecondToast();
    }

    @Override
    protected void onStop() {
        super.onStop();
        
        // Tətbiqdən çıxanda (arka plana keçəndə) də 20 saniyəlik bildirimi başladır
        start20SecondToast();
    }

    private void start20SecondToast() {
        final String message = "⚠️ Adware Aşkarlandı!\nBu, yalnız TEST xəbərdarlığıdır.";
        final Handler handler = new Handler(Looper.getMainLooper());
        
        // 20 saniyə boyunca hər 2 saniyədən bir təkrar olunur (cəmi 10 dəfə)
        for (int i = 0; i < 10; i++) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            }, i * 2000);
        }
    }
}
