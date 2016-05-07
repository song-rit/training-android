package th.ac.sut.basic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nirvana on 13/3/2559.
 */
public class Main extends Activity {

    private Button buttonSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        infixView();

        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Second.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Exit");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setCancelable(true);
        dialog.setMessage("Do you want exit?");

        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    private void infixView() {
        buttonSecond = (Button) findViewById(R.id.buttonSecond);
    }
}
