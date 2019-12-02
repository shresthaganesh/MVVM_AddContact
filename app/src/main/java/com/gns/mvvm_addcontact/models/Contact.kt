package com.gns.mvvm_addcontact.models

public class Contact{
    var contactname:String ="";
    var mobile:String="";
    var profileImage:String = "";
    var contactgender:Gender = Gender.Other;

    constructor(name:String, mobile:String, image:String, gender:Gender){
        this.contactname = name;
        this.mobile =  mobile;
        this.profileImage = image;
        this.contactgender = gender;
    }

    fun getName():String{
        return this.contactname;
    }

    fun getNumber():String{
        return this.mobile;
    }

    fun getImage():String{
        return this.profileImage;
    }

    fun getGender():Gender{
        return contactgender;
    }

    public enum class Gender{
        Male,
        Female,
        Other
    }
}