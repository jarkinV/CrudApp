package com.softserv.todolist.controller;

import com.softserv.todolist.dao.UserDao;
import com.softserv.todolist.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jarki on 6/17/2017.
 */
@WebServlet(urlPatterns = "/signup")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signup.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String message;
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String address = req.getParameter("address");
            String password = req.getParameter("password");
            String login = req.getParameter("login");
            if ((name != "" || address != "" || password != "" || login != "")
                    && !UserDao.INSTANCE.userValidate(login, password)) {
                User user = new User(name, age, address, password, login);
                UserDao.INSTANCE.saveUser(user);
                message = "Success!";
            } else {
                message = "Data is incorrect";
            }
            req.setAttribute("message", message);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/signup.jsp");
            dispatcher.forward(req, resp);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendError(400, "Data is incorrect");
        }

    }
}
