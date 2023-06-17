package com.ahyar.diramut;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class tambahpenyakit extends AppCompatActivity {
    EditText text2, text3, text4, text5;
    ImageView imageView;
    Button save, cancel;
    DataHelper helper;
    private String userChoosenTask;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahpenyakit);

        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.editText3);
        text4 = findViewById(R.id.editText4);
        text5 = findViewById(R.id.editText5);
        imageView = findViewById(R.id.imageView1);
        save = findViewById(R.id.button1);
        cancel = findViewById(R.id.button2);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String awal     = text2.getText().toString().trim();
                String akhir    = text3.getText().toString().trim();
                String telp     = text4.getText().toString().trim();
                String mail     = text5.getText().toString().trim();

                if (awal.equals("") || akhir.equals("") || telp.equals("") ||mail.equals("") || imageView.getDrawable() == null){
                    Toast.makeText(tambahpenyakit.this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }else {
                    saveData();
                    Toast.makeText(tambahpenyakit.this,"Berhasil",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
        getSupportActionBar().hide();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    //--------------------------------------------------------------------------------------------------------------------------------

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if ((grantResults[0] == PackageManager.PERMISSION_GRANTED) &&
                    (grantResults[1] == PackageManager.PERMISSION_GRANTED) &&
                    (grantResults[2] == PackageManager.PERMISSION_GRANTED)) {
                imageView.setEnabled(true);
                if (userChoosenTask.equals("Take Photo")) {
                    cameraIntent();
                } else if (userChoosenTask.equals("Choose from Library")) {
                    galleryIntent();
                }
            } else {
                imageView.setEnabled(false);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            destination.getAbsolutePath();
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageView.setImageBitmap(thumbnail);
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        imageView.setImageBitmap(bm);
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(tambahpenyakit.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result= Utility.checkPermission(tambahpenyakit.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask ="Take Photo";
                    if(result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask ="Choose from Library";
                    if(result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    //--------------------------------------------------------------------------------------------------------------------------------


    public void saveData(){
        DataHelper helper = new DataHelper(this,DataHelper.DB_NAME,null,DataHelper.DB_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bm=((BitmapDrawable)imageView.getDrawable()).getBitmap();
        bm.compress(Bitmap.CompressFormat.JPEG,100,stream);

        byte[] arr1 = stream.toByteArray();
        String result = Base64.encodeToString(arr1,Base64.DEFAULT);

        ContentValues values = new ContentValues();
        values.put(DataHelper.COLUMN_2,text2.getText().toString());
        values.put(DataHelper.COLUMN_3,text3.getText().toString());
        values.put(DataHelper.COLUMN_4,text4.getText().toString());
        values.put(DataHelper.COLUMN_5,text5.getText().toString());
        values.put(DataHelper.COLUMN_6,result);

        long insertId = db.insert(DataHelper.TABLE_NAME,null,values);
        Log.d("add","Inserted.."+insertId);

        db.close();
        finish();
    }




    public void cancel(View view){
        finish();
    }
}