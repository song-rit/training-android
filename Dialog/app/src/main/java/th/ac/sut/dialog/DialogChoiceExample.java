package th.ac.sut.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DialogChoiceExample extends AppCompatActivity {

    private Button button;

    private List<Integer> multiSelected;

    private static final String[] FAMILY = new String[]{"JAME", "JIB", "JO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_choice_example);

        infixView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              dialogShow();
            }
        });
    }

    private void dialogShow() {

        multiSelected = new ArrayList();

        AlertDialog.Builder builder = new AlertDialog.Builder(DialogChoiceExample.this);
        builder.setTitle("Select One Name:-");
        builder.setMultiChoiceItems(FAMILY, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    multiSelected.add(which);
                    Log.d("selected", String.valueOf(multiSelected));
                } else if (multiSelected.contains(which)){
                    multiSelected.remove(new Integer(which));
                    Log.d("Index", String.valueOf(which));
                }
            }
        });

        builder.setPositiveButton("ยีนยัน", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast toast = Toast.makeText(getApplicationContext(), multiSelected.toString(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast toast = Toast.makeText(getApplicationContext(), "Not me", Toast.LENGTH_SHORT);
            }
        });

        builder.setCancelable(false);
        builder.create();
        builder.show();
    }

    private void infixView() {
        button = (Button) findViewById(R.id.buttonDialogChoice);
    }
}
