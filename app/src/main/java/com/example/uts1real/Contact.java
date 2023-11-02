package com.example.uts1real;

import android.os.Parcel;

public class Contact {
    private String nama;
    private String phone;

    public Contact(String nama, String alamat, String email, String phone) {
        this.nama = nama;
        this.phone = phone;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

