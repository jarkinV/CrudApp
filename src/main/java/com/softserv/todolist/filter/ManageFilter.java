package com.softserv.todolist.filter;

import com.softserv.todolist.dao.UserDao;
import com.softserv.todolist.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jarki on 6/18/2017.
 */
@WebFilter("/manage")
public class ManageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession(false);

        UserDto userDto = (UserDto) session.getAttribute("UserDto");
        if(userDto.getRole().equals("Role_admin")){
            filterChain.doFilter(req, resp);
        }else {
            resp.sendError(404);
        }

    }

    @Override
    public void destroy() {

    }
}
