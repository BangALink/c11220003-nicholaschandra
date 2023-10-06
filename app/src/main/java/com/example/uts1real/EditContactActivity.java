package com.example.uts1real;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditContactActivity extends AppCompatActivity {

    private EditText editNameEditText, editAddressEditText, editEmailEditText, editPhoneEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_contact);


        editNameEditText = findViewById(R.id.NameEditText);
        editAddressEditText = findViewById(R.id.AddressEditText);
        editEmailEditText = findViewById(R.id.EmailEditText);
        editPhoneEditText = findViewById(R.id.PhoneEditText);
        saveButton = findViewById(R.id.saveButton);

        // Dapatkan data kontak yang dipilih (misalnya, dari Intent)
        Contact selectedContact = getIntent().getSerializableExtra("contact");

        // Isi EditText dengan data kontak yang dipilih
        if (selectedContact != null) {
            editNameEditText.setText(selectedContact.getName());
            editAddressEditText.setText(selectedContact.getAddress());
            editEmailEditText.setText(selectedContact.getEmail());
            editPhoneEditText.setText(selectedContact.getPhoneNumber());
        }


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String editedName = editNameEditText.getText().toString();
                String editedAddress = editAddressEditText.getText().toString();
                String editedEmail = editEmailEditText.getText().toString();
                String editedPhone = editPhoneEditText.getText().toString();


            }
        });
    }
}