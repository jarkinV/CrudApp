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
import java.util.List;

/**
 * Created by jarki on 6/18/2017.
 */
@WebServlet("/removeItem")
public class RemoveItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String itemId = req.getParameter("itemId");
        try {
            int id = Integer.parseInt(itemId);


            UserDto userDto = (UserDto) session.getAttribute("UserDto");
            List<Item> items = ItemDao.INSTANCE.getItemsByUserID(userDto.getUserId());
            items.forEach(item -> {
                if (item.getItemId() == id){
                    ItemDao.INSTANCE.removeItemById(id);

                }
            });
            resp.sendRedirect("/items");


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
