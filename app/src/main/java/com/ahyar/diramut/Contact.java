package com.ahyar.diramut;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {
    private int id;
    private String nmpenyakit, deskripsi, gejala, solusi, image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNmpenyakit() {
        return nmpenyakit;
    }

    public void setNmpenyakit(String nmpenyakit) {
        this.nmpenyakit = nmpenyakit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGejala() {
        return gejala;
    }

    public void setGejala(String gejala) {
        this.gejala = gejala;
    }

    public String getSolusi() {
        return solusi;
    }

    public void setSolusi(String solusi) {
        this.solusi = solusi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Contact() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nmpenyakit);
        dest.writeString(this.deskripsi);
        dest.writeString(this.gejala);
        dest.writeString(this.solusi);
        dest.writeString(this.image);
    }

    protected Contact(Parcel in) {
        this.id = in.readInt();
        this.nmpenyakit = in.readString();
        this.deskripsi = in.readString();
        this.gejala = in.readString();
        this.solusi = in.readString();
        this.image = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
