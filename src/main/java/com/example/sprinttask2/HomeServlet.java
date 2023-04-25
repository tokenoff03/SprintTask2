package com.example.sprinttask2;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Items> items = DBManager.getAllItems();
        System.out.println(items);
        request.getSession().setAttribute("items", items);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }
}