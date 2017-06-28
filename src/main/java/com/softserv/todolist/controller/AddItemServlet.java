package com.softserv.todolist.controller;

import com.softserv.todolist.dao.ItemDao;
import com.softserv.todolist.dto.UserDto;
import com.softserv.todolist.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jarki on 6/18/2017.
 */
@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String state = req.getParameter("check");
        HttpSession session = req.getSession();

        UserDto userDto = (UserDto) session.getAttribute("UserDto");

        Item item = new Item(text, state == null ? false : true, userDto.getUserId());
        ItemDao.INSTANCE.saveItem(item);
        resp.sendRedirect("/items");
    }
}
