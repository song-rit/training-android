package th.ac.sut.storage;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InternalStorageBasic extends AppCompatActivity {

    Button buttonReadFile, buttonWriteFile;
    EditText editTextMSG;

    String FILENAME = "mytextfile.txt";
    Context context = InternalStorageBasic.this;

    static final int READ_BLOCK_SIZE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_basic);

        infixView();

        buttonWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WriteFile();
            }
        });

        buttonReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadFile2();
            }
        });
    }

    private void infixView() {
        buttonReadFile = (Button) findViewById(R.id.button_read_file);
        buttonWriteFile = (Button) findViewById(R.id.button_write_file);
        editTextMSG = (EditText) findViewById(R.id.edit_text_msg);
    }

    public File getTempFile(Context context, String url) {
        File file = null;
        try {
            String fileName = Uri.parse(url).getLastPathSegment();
            file = File.createTempFile(fileName, null, context.getCacheDir());
        } catch (IOException e) {
            // Error while creating file
        }
        return file;
    }

    public void ReadFile() {
        try {
            FileInputStream fin = openFileInput(FILENAME);
            InputStreamReader InputRead= new InputStreamReader(fin);
            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String msg = "";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer)) > 0) {

                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                msg +=readstring;
            }
            InputRead.close();
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadFile2() {
        try {
            FileInputStream fin = openFileInput(FILENAME);
            int c;
            String temp="";

            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }

            Toast.makeText(context, temp, Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void WriteFile2() {
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(editTextMSG.getText().toString().getBytes());
            fos.close();

            Toast.makeText(context, "Write File Success", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteFile() {
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fos);
            outputWriter.write(editTextMSG.getText().toString());
            outputWriter.close();

            Toast.makeText(context, "Write File Success", Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
