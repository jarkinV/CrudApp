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
 * Created by jarki on 6/19/2017.
 */
@WebServlet("/changeState")
public class ChangeItemState extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = req.getParameter("id");
        int id = Integer.parseInt(string);

        Item item = ItemDao.INSTANCE.getItemById(id);
        HttpSession session = req.getSession();
        UserDto userDto = (UserDto) session.getAttribute("UserDto");
        if (item.getUserId() == userDto.getUserId()){
            if (item.isState()){
                ItemDao.INSTANCE.changeState(item.getItemId(), true);
                resp.getWriter().print("no");
            }else {
                ItemDao.INSTANCE.changeState(item.getItemId(), false);
                resp.getWriter().print("yes");
            }
        }



    }
}
