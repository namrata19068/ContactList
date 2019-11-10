package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MT19068_Form extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mt19068_activity_form);
        button=(Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAdd_Contact_onClick(view);
            }
        });
    }
    public void btnAdd_Contact_onClick(View view)
    {
        Intent intent=new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        EditText fname=(EditText)findViewById(R.id.fname);
        EditText lname=(EditText)findViewById(R.id.lname);
        EditText fnumber=(EditText)findViewById(R.id.text2);

        intent
                .putExtra(ContactsContract.Intents.Insert.PHONE,fnumber.getText())
                .putExtra(ContactsContract.Intents.Insert.NAME,fname.getText()+" "+lname.getText());

        startActivity(intent);
    }
}
