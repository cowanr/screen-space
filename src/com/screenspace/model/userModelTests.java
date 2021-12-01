package com.screenspace.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class userModelTests {

    private String uname = "testuname";
    private String pass = "testpass";
    private String phone = "testphone";
    private String email = "testemail";
    private userModel user;

    @Before
    public void before() {
        this.user = new userModel(this.uname, this.pass, this.phone, this.email);
    }

    @Test
    public void testImageFourArgumentConstructor() {
        String expected = "userModel [uname=" + this.uname + ", pass=" + this.pass + ", phone=" + this.phone + ", email=" + this.email + "]";

        assertEquals(expected, this.user.toString());
    }

    @Test
    public void testImageNoArgumentConstructor() {
        userModel usr = new userModel();
        String expected = "userModel [uname=null, pass=null, phone=null, email=null]";

        assertEquals(expected, usr.toString());
    }

    @Test
    public void testGetUname() {
        assertEquals(this.uname, this.user.getUname());
    }

    @Test
    public void testGetPass() {
        assertEquals(this.pass, this.user.getPass());
    }

    @Test
    public void testGetEmail() {
        assertEquals(this.email, this.user.getEmail());
    }

    @Test
    public void testGetPhone() {
        assertEquals(this.phone, this.user.getPhone());
    }

    @Test
    public void testSetUname() {
        userModel usr = new userModel();
        usr.setUname(this.uname);

        assertEquals(this.uname, usr.getUname());
    }

    @Test
    public void testSetPass() {
        userModel usr = new userModel();
        usr.setPass(this.pass);

        assertEquals(this.pass, usr.getPass());
    }

    @Test
    public void testSetEmail() {
        userModel usr = new userModel();
        usr.setEmail(this.email);

        assertEquals(this.email, usr.getEmail());
    }

    @Test
    public void testSetPhone() {
        userModel usr = new userModel();
        usr.setPhone(this.phone);

        assertEquals(this.phone, usr.getPhone());
    }
}
