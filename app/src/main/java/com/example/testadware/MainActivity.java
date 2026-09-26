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

        // Ekran düzenini yükle
        // (Eğer bir layout dosyanız varsa setContentView kullanabilirsiniz)
        
        // Uygulamaya girildiğinde mesaj göster
        showToast("⚠️ Adware Aşkarlandı!\nBu, yalnız TEST xəbərdarlığıdır.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        
        // Uygulamadan çıkıldığında (arka plana alındığında) mesajı göster ve 10 saniye ekranda tut
        showToastFor10Seconds("⚠️ Adware Aşkarlandı!\nBu, yalnız TEST xəbərdarlığıdır.");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void showToastFor10Seconds(final String message) {
        final Handler handler = new Handler(Looper.getMainLooper());
        
        // 10 saniye boyunca arka arkaya kısa Toast mesajları tetikleyerek ekranda kalmasını sağlar
        for (int i = 0; i < 5; i++) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            }, i * 2000); // Her 2 saniyede bir tekrarlar (Toplam ~10 saniye)
        }
    }
}
