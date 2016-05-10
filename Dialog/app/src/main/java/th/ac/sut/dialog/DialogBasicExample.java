package th.ac.sut.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogBasicExample extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_basic_example);

        infixView();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        };

        button.setOnClickListener(onClickListener);
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogBasicExample.this);
        builder.setMessage("เอาไข่เจียวไหม");

        builder.setPositiveButton("เอา", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getApplicationContext(), "รอสักครู่", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        builder.setNegativeButton("ไม่เอา", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getApplicationContext(), "ขอบคุณครับ", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        builder.show();
    }

    private void infixView() {
        button = (Button) findViewById(R.id.button);
    }
}
