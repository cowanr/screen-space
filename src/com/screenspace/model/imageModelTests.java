package com.screenspace.model;

import com.screenspace.model.imageModel;
import org.junit.Before;
import org.junit.Test;

import java.util.Base64;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class imageModelTests {

    private byte[] imageBytes = new byte[20];
    private String uname = "uname";
    private long size = 100;
    private String contentType = "contentType";
    private String name = "name";
    private imageModel image;

    @Before
    public void before() {
        this.image = new imageModel(this.imageBytes, this.uname, this.size, this.contentType, this.name);
    }

    @Test
    public void testGetImageId() {
        int x = this.image.getImageId();

        assertTrue(x == (int)x);
    }

    @Test
    public void testSetImageId() {
        int newId = 55;
        this.image.setImageId(newId);

        assertTrue(newId == this.image.getImageId());
    }

    @Test
    public void testImageFourArgumentConstructor() {
        int x = this.image.getImageId();

        assertTrue(x == (int)x);
    }

    @Test
    public void testImageTwoArgumentConstructor() {
        imageModel img = new imageModel(this.imageBytes, "test");
        int x = img.getImageId();

        assertTrue(x == (int)x);
    }

    @Test
    public void testImageNoArgumentConstructor() {
        imageModel img = new imageModel();
        int x = img.getImageId();

        assertTrue(x == (int)x);
    }

    @Test
    public void testGetImage() {
        assertEquals(this.imageBytes, this.image.getImage());
    }

    @Test
    public void testSetImage() {
        byte[] newImageBytes = new byte[30];
        imageModel img = new imageModel(this.imageBytes, "test");
        img.setImage(newImageBytes);

        assertEquals(newImageBytes, img.getImage());
    }

    @Test
    public void testGetBase64Image() {
        String x = this.image.getBase64Image();
        String expected = Base64.getEncoder().encodeToString(this.image.getImage());

        assertEquals(expected, x);
    }
}
