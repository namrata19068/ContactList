package com.example.contactlist;

public class MT19068_Contact {
    private String Name;
    private String Phone;
    private int photo;

    public MT19068_Contact() {
    }

    public MT19068_Contact(String name, String phone, int photo) {
        Name = name;
        Phone = phone;
        this.photo = photo;
    }
    //Getter


    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public int getPhoto() {
        return photo;
    }

    //Setter

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
