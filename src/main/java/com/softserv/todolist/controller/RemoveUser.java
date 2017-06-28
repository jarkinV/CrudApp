package com.softserv.todolist.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jarki on 6/20/2017.
 */
@WebServlet("/removeUser")
public class RemoveUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = req.getParameter("id");
        int id = Integer.parseInt(string);

    }
}
