package th.ac.sut.thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ThreadBasic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_basic);

//        handlerThread();
//        basicThread();
        basicThread2();
    }

    public void handlerThread() {

        Handler handler = new Handler();

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ThreadBasic.this, "Basic Thread", Toast.LENGTH_SHORT).show();
            }
        };

//        runnable.run();
        handler.postDelayed(runnable, 3000);
    }
    
    public void basicThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ThreadBasic.this, "Basic Thread", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        thread.start();
    }

    public void basicThread2() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ThreadBasic.this, "Basic Thread", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };

        thread.start();
    }
}
