package com.example.pz_13_serialization;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    private String company;
    private int age;
    private String phone;
    private String address;
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            String name = source.readString();
            String company = source.readString();
            int age = source.readInt();
            String phone = source.readString();
            String address = source.readString();
            return new User(name, company, age, phone, address);
        }
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    public User(String name, String company, int age, String phone, String address){
        this.name = name;
        this.company = company;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(company);
        dest.writeInt(age);
        dest.writeString(phone);
        dest.writeString(address);
    }
}
