package com.example.uts1real;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {

    private ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        contactListView = findViewById(R.id.contactListView);

        // Mendapatkan data username dari Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // Contoh data kontak
        ArrayList<String> contactData = new ArrayList<>();
        contactData.add("John Doe - 08234893929 ");
        contactData.add("Alice Smith - 08983721583");
        contactData.add("Andreas - 089892179");
        contactData.add("Paulus - 08674326556");
        contactData.add("Chandra - 08921322443");
        contactData.add("Hendy - 0843431123");
        contactData.add("Nicholas - 081123423");
        contactData.add("Cupli - 08576754331");

        // Buat ArrayAdapter untuk ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactData);

        // Set adapter untuk ListView
        contactListView.setAdapter(adapter);
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Mengambil kontak yang diklik
                Contact clickedContact = contactData.get(position);

                // Mengirim kontak ke aktivitas EditContactActivity untuk diedit
                Intent intent = new Intent(ContactListActivity.this, EditContactActivity.class);
                intent.putExtra("contact", clickedContact); // Mengirim objek Contact
                startActivity(intent);
            }
        });
    }

}
}