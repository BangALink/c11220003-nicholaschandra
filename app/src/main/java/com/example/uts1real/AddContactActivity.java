package com.example.uts1real;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contactlist);

        final EditText editTextNama = findViewById(R.id.editTextNama);
        final EditText editTextPhone = findViewById(R.id.editTextPhone);
        final EditText editTextEmail = findViewById(R.id.editTextEmail);
        final EditText editTextAlamat = findViewById(R.id.editTextAlamat);
        Button buttonSaveContact = findViewById(R.id.buttonSaveContact);
        Button buttonCancel = findViewById(R.id.buttonCancel);

        buttonSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = editTextNama.getText().toString();
                String phone = editTextPhone.getText().toString();
                String email = editTextEmail.getText().toString();
                String alamat = editTextAlamat.getText().toString();

                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("newContact", "");
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    }
                });
                if (!nama.isEmpty() && !phone.isEmpty()) {
                    Contact newContact = new Contact(nama, phone, email, alamat);
                    Intent intent = new Intent(AddContactActivity.this,ContactListActivity.class);
                    intent.putExtra("newContact", nama + " - " + phone);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(AddContactActivity.this, "Nama dan Nomor Telepon diperlukan", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
