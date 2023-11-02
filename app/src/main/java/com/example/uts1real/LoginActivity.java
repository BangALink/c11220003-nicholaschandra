package com.example.uts1real;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEdit, passwordEdit;
    private Button loginButton;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DBHelper(this);

        usernameEdit = findViewById(R.id.usernameEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEdit.getText().toString().trim();
                String password = passwordEdit.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Username and password are required", Toast.LENGTH_SHORT).show();
                } else {
                    String usernameEdit = "NCLOL";
                    String passwordEdit = "00099";
                    // Add the user to the database
                    addUserToDatabase(username, password);

                    // Show a success message
                    Toast.makeText(LoginActivity.this, "User successfully registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, ContactListActivity.class);
                    intent.putExtra("NCLOL", username); // Gantilah "username" dengan data yang ingin Anda kirim
                    startActivity(intent);
                }
            }
        });
    }

    private void addUserToDatabase(String username, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_USERNAME, username);
        values.put(DBHelper.COLUMN_PASSWORD, password);

        long newRowId = db.insert(DBHelper.TABLE_USERS, null, values);

        if (newRowId != -1) {
            // Data pengguna berhasil ditambahkan ke database
            Toast.makeText(this, "User successfully registered", Toast.LENGTH_SHORT).show();
        } else {
            // Ada kesalahan saat menambahkan pengguna
            Toast.makeText(this, "Error registering user", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
}
