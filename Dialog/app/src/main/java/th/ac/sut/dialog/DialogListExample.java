package th.ac.sut.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogListExample extends AppCompatActivity {

    private Button button;

    private static final String[] FAMILY = new String[]{"JAME", "JIB", "JO"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_list_example);

        infixView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DialogListExample.this);
                builder.setTitle("Select One Name:-");

                builder.setItems(FAMILY, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(getApplicationContext(), FAMILY[which], Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                builder.setNegativeButton("ไม่ใช่สามคนนี้", null);

                builder.create();
                builder.show();

            }
        });
    }

    private void infixView() {
        button = (Button) findViewById(R.id.button);
    }
}
