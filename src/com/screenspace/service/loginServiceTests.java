package com.screenspace.service;

import com.screenspace.dao.userDao;
import com.screenspace.model.userModel;

import org.junit.Before;
import org.junit.Test;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class loginServiceTests {
    private loginService servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        servlet = new loginService();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void testValidAccount() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        userDao userDao = mock(com.screenspace.dao.userDao.class);
        userModel user = mock(com.screenspace.model.userModel.class);

        when(request.getParameter("uname")).thenReturn("me");
        when(request.getParameter("pass")).thenReturn("secret");

        when(userDao.getUser( "uname", "pass")).thenReturn(user);

        when(user.getUname().equals( "uname" )).thenReturn(true);
        when(user.getPass().equals( "pass" )).thenReturn(true);
        when(user.getPass()).thenReturn("pass");
        when(user.getEmail()).thenReturn("email");
        when(user.getPhone()).thenReturn("phone");

        servlet.setUser(userDao);
        servlet.doPost(request, response);
        verify(response).sendRedirect("wdController");

    }
}