package th.ac.sut.storage;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalStorageBasic extends AppCompatActivity {

    Button buttonReadFile, buttonWriteFile;
    EditText editTextMSG;

    private String filename = "SampleExternalFile.txt";
    private String filepath = "MyFileStorage";

    private File myExternalFile;
    private Context context = ExternalStorageBasic.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage_basic);

        infixView();

        buttonWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile();
            }
        });

        buttonReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();
            }
        });


        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            buttonReadFile.setEnabled(false);
            buttonWriteFile.setEnabled(false);
        } else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }

    }

    private void infixView() {
        buttonReadFile = (Button) findViewById(R.id.button_read_file);
        buttonWriteFile = (Button) findViewById(R.id.button_write_file);
        editTextMSG = (EditText) findViewById(R.id.edit_text_msg);
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream(myExternalFile);
            fos.write(editTextMSG.getText().toString().getBytes());
            fos.close();

            Toast.makeText(context, "Save file Success", Toast.LENGTH_SHORT).show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(){
        FileInputStream fis = null;
        String myData= "";
        try {
            fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();

            Toast.makeText(context, myData, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
