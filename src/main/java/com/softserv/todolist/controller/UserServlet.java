package com.softserv.todolist.controller;

import com.softserv.todolist.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jarki on 6/17/2017.
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto userDto = (UserDto) session.getAttribute("UserDto");
        req.setAttribute("user", userDto);
        req.getRequestDispatcher("user.jsp").forward(req, resp);

    }

}
