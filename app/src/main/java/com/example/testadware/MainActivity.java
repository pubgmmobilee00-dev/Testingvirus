package com.example.testadware;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Tətbiq açılanda xəbərdarlıq göstər
        showToastFor20Seconds("⚠️ Adware Aşkarlandı!\nBu, yalnız TEST xəbərdarlığıdır.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        
        // Tətbiqdən çıxanda da 20 saniyəlik xəbərdarlığı işə sal
        showToastFor20Seconds("⚠️ Adware Aşkarlandı!\nBu, yalnız TEST xəbərdarlığıdır.");
    }

    private void showToastFor20Seconds(final String message) {
        final Handler handler = new Handler(Looper.getMainLooper());
        
        // Toplam 20 saniyə üçün (hər 2 saniyədən bir, cəmi 10 dəfə təkrar olunur)
        for (int i = 0; i < 10; i++) {
            final int index = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                    
                    // Ekranın müxtəlif yerlərində göstərmək üçün:
                    if (index % 3 == 0) {
                        // Yuxarıda görünür
                        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 150);
                    } else if (index % 3 == 1) {
                        // Təmiz ortada görünür
                        toast.setGravity(Gravity.CENTER, 0, 0);
                    } else {
                        // Aşağıda görünür
                        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 150);
                    }
                    
                    toast.show();
                }
            }, i * 2000); // Hər 2 saniyədən bir yenilənir
        }
    }
}
