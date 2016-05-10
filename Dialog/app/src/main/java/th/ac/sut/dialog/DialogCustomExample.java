package th.ac.sut.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DialogCustomExample extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private View view;
    private LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_custom_example);

        infixView();

        AlertDialog.Builder builder = new AlertDialog.Builder(DialogCustomExample.this);
        builder.setView(view);

        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);
        builder.show();

    }

    private void infixView() {

        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.dialog_custom, null);

        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
    }


}
