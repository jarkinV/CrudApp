package com.softserv.todolist.controller;

import com.softserv.todolist.dao.ItemDao;
import com.softserv.todolist.dto.UserDto;
import com.softserv.todolist.entity.Item;

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
 * Created by jarki on 6/17/2017.
 */
@WebServlet("/items")
public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        UserDto userDto = (UserDto) session.getAttribute("UserDto");
        List<Item> items = ItemDao.INSTANCE.getItemsByUserID(userDto.getUserId());
        req.setAttribute("user", userDto);
        req.setAttribute("list", items);



        RequestDispatcher dispatcher = req.getRequestDispatcher("items.jsp");
        dispatcher.forward(req, resp);
    }
}
