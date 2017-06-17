package com.softserv.todolist.controller;

import com.softserv.todolist.dao.UserDao;
import com.softserv.todolist.dto.UserDto;
import com.softserv.todolist.entity.User;

import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        if (login != "" || password != "") {
            User user = UserDao.INSTANCE.getUserByLoginAndPassword(login, password);

            if (user == null) {
                message = "Data is incorrect";
                req.setAttribute("message", message);
                req.getRequestDispatcher("login.jsp").forward(req, resp);

            } else {
                HttpSession session = req.getSession();
                UserDto userDto = new UserDto();
                userDto.setName(user.getName());
                userDto.setAge(user.getAge());
                userDto.setAddress(user.getAddress());
                userDto.setUserId(user.getUserId());
                session.setAttribute("UserDto", userDto);
                resp.sendRedirect("/user");

            }
        }else {
            message = "Data is incorrect";
            req.setAttribute("message", message);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
