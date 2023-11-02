package com.example.uts1real;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ContactListActivity extends Activity {
    private ArrayList<String > contacts;
    private ContactAdapter adapter;
    private ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        contacts = new ArrayList<>();
        adapter = new ContactAdapter(this, contacts);

        ListView listViewContacts = findViewById(R.id.contactListView);
        listViewContacts.setAdapter(adapter);

        Button buttonAddContact = findViewById(R.id.buttonAddContact);
        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactListActivity.this, AddContactActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                String newContact = data.getStringExtra("newContact");
                if (newContact != null && !newContact.isEmpty()) {
                    contacts.add(newContact);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
}