package com.example.llw.demo_storage_data;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;
    private static final String TAG = "MainActivity";

    private void assignViews() {
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                fun();
                break;
        }
    }


    public void fun() {

       /* String name = "SS";
        //根据姓名求id
        //  Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
        //  long contentid = ContentUris.parseId(ContactsContract.Contacts.CONTENT_URI);
        Uri uri = ContactsContract.RawContacts.CONTENT_URI;

        ContentResolver resolver = getContentResolver();
        //这里通过query方法返回的cursor的目的，以及各个参数的意义
        Cursor cursor = resolver.query(uri, new String[]{ContactsContract.RawContacts._ID}, "display_name=?", new String[]{name}, null);
        *//*第一个：uri：表示要查询的地址 第二个：返回的是*//*
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(0);
            //根据id删除data中的相应数据
            resolver.delete(uri, "display_name=?", new String[]{name});
            uri = Uri.parse("content://com.android.contacts/data");//????????????????????????????这里的uri和上面的uri可以一样吗
            resolver.delete(uri, "raw_contact_id=?", new String[]{id + ""});
        }*/

        String name = "CVGCV";
        Uri uri = ContactsContract.RawContacts.CONTENT_URI;
        ContentResolver contentResolver = getContentResolver();
        Cursor c1 = contentResolver.query(uri, new String[]{ContactsContract.RawContacts._ID}, "display_name=?", new String[]{name}, null);
        if (c1.moveToFirst()) {
            int id = c1.getInt(c1.getColumnIndex(ContactsContract.RawContacts._ID));//这里获取的id是为了什么？？
            Log.i(TAG, "fun:id: " + id);

            int rows_delete = contentResolver.delete(uri, "contact_id=?", new String[]{id + ""});//根据什么删除了什么 怎么看不到效果


            Log.i(TAG, "fun: " + rows_delete);
            int row_name = contentResolver.delete(uri, "display_name=?", new String[]{name});
            Log.i(TAG, "fun:第 " + row_name);

            // c1.getInt(c1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
          /*  int row_number = contentResolver.delete(uri, "number=?", new String[]{"12424524522"});
            Log.i(TAG, "fun: " + row_number);*/
        }

    }
}
