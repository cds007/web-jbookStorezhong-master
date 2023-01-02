package org.csu.webJpetStore.domain;

import java.io.Serializable;

//import net.sourceforge.stripes.validation.Validate;

import java.io.Serializable;

//import net.sourceforge.stripes.validation.Validate;

public class Account implements Serializable {

    private static final long serialVersionUID = 8751282105532159742L;

    private String userid;
    private String email;
    private String firstname;
    private String lastname;
    private String status;
    private String addr1;
    private String addr2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private String name;
    private String password;
    private String langpref;
    private String favcategory;
    private boolean mylistopt;
    private boolean banneropt;
    private String bannername;

    public Account(){
    }

    public Account(String userid, String email, String firstname, String lastname, String status, String addr1, String addr2, String city, String state, String zip, String country, String phone, String name, String password, String langpref, String favcategory, boolean mylistopt, boolean banneropt, String bannername) {
        this.userid = userid;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.langpref = langpref;
        this.favcategory = favcategory;
        this.mylistopt = mylistopt;
        this.banneropt = banneropt;
        this.bannername = bannername;
    }

    public String getUserid() {
        return userid;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }
    ///////////////////对用户输入的内容进行实时校验，防止用户填错
    //@Validate(required=true, on={"newAccount", "editAccount"})
    public String getLastname() {
        return lastname;
    }

    public String getStatus() {
        return status;
    }

    public String getAddr1() {
        return addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getLangpref() {
        return langpref;
    }

    public String getFavcategory() {
        return favcategory;
    }

    public boolean isMylistopt() {
        return mylistopt;
    }

    public boolean isBanneropt() {
        return banneropt;
    }

    public String getBannername() {
        return bannername;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLangpref(String langpref) {
        this.langpref = langpref;
    }

    public void setFavcategory(String favcategory) {
        this.favcategory = favcategory;
    }

    public void setMylistopt(boolean mylistopt) {
        this.mylistopt = mylistopt;
    }

    public void setBanneropt(boolean banneropt) {
        this.banneropt = banneropt;
    }

    public void setBannername(String bannername) {
        this.bannername = bannername;
    }
}

