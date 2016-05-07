package th.ac.sut.logcat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


//        Verbose (V) ใช้แสดงข้อความที่ไม่ค่อยสำคัญมากนัก
//        Debug (D) ใช้แสดงข้อความสำหรับการ Debug
//        Info (I) ใช้แสดงข้อความสำหรับแสดงข้อมูลการทำงานบางอย่าง
//        Warning (W) ใช้แสดงข้อผิดพลาดในการทำงานของโค๊ดที่ไม่ร้ายแรง (แค่เตือน)
//        Error (E) ใช้แสดงข้อผิดพลาดในการทำงานของโค๊ด
//        Assert (A) ใช้แสดงข้อผิดพลาดที่ไม่ควรจะเกิดขึ้นในโค๊ด
//        ***** References: http://www.akexorcist.com/ *****

//        เปลี่ยนสี LogCat http://www.akexorcist.com/2014/12/android-dev-tips-logcat-android-studio.html

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart");

    }

    private void allLogCat() {
        Log.v("Verbose TAG", "Message");
        Log.d("Debug TAG", "Message");
        Log.i("Info TAG", "Message");
        Log.w("Warning TAG", "Message");
        Log.e("Error TAG", "Message");
        Log.wtf("Assert TAG", "Message");
    }
}
