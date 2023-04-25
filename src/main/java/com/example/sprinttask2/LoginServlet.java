package com.example.sprinttask2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Users> users = DBManager.getAllUsers();

        request.getSession().setAttribute("users", users);
        request.getRequestDispatcher("/signIn.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ArrayList<Users> users = (ArrayList<Users>) request.getSession().getAttribute("users");

        boolean checkUser = false;

        for(Users u: users){

            if(u.getEmail().equals(email)&&u.getPassword().equals(password)){
                checkUser=true;
                break;
            }

        }


        if(checkUser) request.getRequestDispatcher("/profile.jsp").forward(request,response);
        else response.sendRedirect("/LoginServlet?error");

    }
}
