package com.softserv.todolist.controller;

import com.softserv.todolist.dao.ItemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jarki on 6/18/2017.
 */
@WebServlet("/removeItem")
public class RemoveItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId = req.getParameter("itemId");
        try {
            int id = Integer.parseInt(itemId);
            ItemDao.INSTANCE.removeItemById(id);
            resp.sendRedirect("/items");
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

    }
}
