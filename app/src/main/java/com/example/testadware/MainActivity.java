package com.example.testadware;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Tətbiq açılanda 15 saniyəlik xəbərdarlıq dövrünü başlat
        start15SecondToast();
    }

    @Override
    protected void onPause() {
        super.onPause();
        
        // Tətbiq arxa fona keçəndə (ev düyməsi sıxılanda) xəbərdarlıq dövrünü başlat
        start15SecondToast();
    }

    private void start15SecondToast() {
        // Tətbiqdən çıxıldıqda fərqli mətn və xəbərdarlıq mesajları
        final String[] messages = {
            "⚠️ Adware Aşkarlandı! (Nöqtə 1)",
            "⚠️ Sistem Xəbərdarlığı: Yoxlanılır... (Nöqtə 2)",
            "⚠️ Diqqət: Test Xəbərdarlığı! (Nöqtə 3)",
            "⚠️ Adware Aşkarlandı! (Nöqtə 4)",
            "⚠️ Təhlükəsizlik Testi Tamamlanır... (Nöqtə 5)"
        };

        // 15 saniyə ərzində (hər 1.5 saniyədən bir, cəmi 10 dəfə) mesaj göstərilir
        for (int i = 0; i < 10; i++) {
            final int index = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    String currentMsg = messages[index % messages.length];
                    Toast.makeText(getApplicationContext(), currentMsg, Toast.LENGTH_SHORT).show();
                }
            }, i * 1500); // 1.5 saniyəlik intervallar (ümumi ~15 saniyə)
        }
    }
}
