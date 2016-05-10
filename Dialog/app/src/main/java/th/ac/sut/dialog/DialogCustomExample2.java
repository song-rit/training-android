package th.ac.sut.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DialogCustomExample2 extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button buttonCancel;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_custom_example2);

        final Dialog dialog = new Dialog(DialogCustomExample2.this);
        dialog.setTitle("Custom Dialog");
        dialog.setContentView(R.layout.dialog_custom2);


        infixView();



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void infixView() {


        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        buttonCancel = (Button) findViewById(R.id.button_cancel);
        buttonLogin = (Button) findViewById(R.id.button_login);
    }
}
