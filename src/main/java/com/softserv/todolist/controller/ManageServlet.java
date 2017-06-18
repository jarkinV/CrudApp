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
import java.util.List;

/**
 * Created by jarki on 6/18/2017.
 */
@WebServlet("/manage")
public class ManageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto userDto = (UserDto) session.getAttribute("UserDto");
        List<User> users = UserDao.INSTANCE.getAllUsers();
        req.setAttribute("users", users);
        req.setAttribute("user", userDto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/manage.jsp");
        dispatcher.forward(req, resp);

    }
}
