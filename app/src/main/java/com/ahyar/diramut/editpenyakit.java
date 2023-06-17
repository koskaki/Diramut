package com.ahyar.diramut;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import java.util.ArrayList;

public class editpenyakit extends AppCompatActivity {
    EditText text2, text3, text4, text5;
    ImageView imageButton;
    Button save, cancel;
    private String userChoosenTask;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpenyakit);

        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.editText3);
        text4 = findViewById(R.id.editText4);
        text5 = findViewById(R.id.editText5);
        imageButton =(ImageView) findViewById(R.id.imageView1);
        save = findViewById(R.id.button1);
        cancel = findViewById(R.id.button2);

        getData();

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        getSupportActionBar().hide();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String awal = text2.getText().toString().trim();
                String akhir = text3.getText().toString().trim();
                String telp = text4.getText().toString().trim();
                String mail = text5.getText().toString().trim();

                if (awal.equals("") || akhir.equals("") || telp.equals("") ||mail.equals("")){
                    Toast.makeText(editpenyakit.this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }else {
                    addData();
                    Toast.makeText(editpenyakit.this, "Updated successfully...!!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if ((grantResults[0] == PackageManager.PERMISSION_GRANTED) &&
                    (grantResults[1] == PackageManager.PERMISSION_GRANTED) &&
                    (grantResults[2] == PackageManager.PERMISSION_GRANTED)) {
                imageButton.setEnabled(true);
                if (userChoosenTask.equals("Take Photo")) {
                    cameraIntent();
                } else if (userChoosenTask.equals("Choose from Library")) {
                    galleryIntent();
                }
            } else {
                imageButton.setEnabled(false);
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
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

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

        imageButton.setImageBitmap(thumbnail);
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

        imageButton.setImageBitmap(bm);
    }

    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Library",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(editpenyakit.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result= Utility.checkPermission(editpenyakit.this);

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



    //--------------------------------------------------------------------------------------------------------------------------

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void getData(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("updateContact",0);
        DataHelper helper = new DataHelper(this, DataHelper.DB_NAME, null, DataHelper.DB_VERSION);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<Contact> contacts = new ArrayList<>();

        String query = "SELECT * FROM " + DataHelper.TABLE_NAME + " WHERE ID=" + id;
        Cursor cursor = db.rawQuery(query, null);
        Contact contact = null;
        if (cursor.moveToFirst()) {
            do {
                contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setNmpenyakit(cursor.getString(1));
                contact.setDeskripsi(cursor.getString(2));
                contact.setGejala(cursor.getString(3));
                contact.setSolusi(cursor.getString(4));
                contact.setImage(cursor.getString(5));

                contacts.add(contact);

            } while (cursor.moveToNext());
        }

        text2.setText(contact.getNmpenyakit());
        text3.setText(contact.getDeskripsi());
        text4.setText(contact.getGejala());
        text5.setText(contact.getSolusi());
        if (contact.getImage() == null) {
            imageButton.setImageResource(R.drawable.vet);
        } else {
            byte[] arr = Base64.decode(contact.getImage(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(arr, 0, arr.length);
            imageButton.setImageBitmap(bitmap);
        }
    }

    public void addData(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("updateContact",0);
        DataHelper helper = new DataHelper(this,DataHelper.DB_NAME,null,DataHelper.DB_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
        Log.v("TAG","Updated row no "+id);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bm=((BitmapDrawable)imageButton.getDrawable()).getBitmap();
        bm.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] arr1 = stream.toByteArray();
        String result = Base64.encodeToString(arr1,Base64.DEFAULT);

        ContentValues values = new ContentValues();
        values.put(DataHelper.COLUMN_2,text2.getText().toString());
        values.put(DataHelper.COLUMN_3,text3.getText().toString());
        values.put(DataHelper.COLUMN_4,text4.getText().toString());
        values.put(DataHelper.COLUMN_5,text5.getText().toString());
        values.put(DataHelper.COLUMN_6,result);

        db.update(DataHelper.TABLE_NAME,values,"ID="+id,null);
        db.close();
    }
}