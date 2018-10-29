package com.rapoo.store.loginAndlogout;

import com.rapoo.store.User;
import com.rapoo.store.dao.IUserDAO;
import com.rapoo.store.dao.daoimpl.UserDAOImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 做登录服务,验证用户名密码是否正确
 */
@WebServlet("/login")
public class login extends HttpServlet {
    IUserDAO userDAO = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDAO = new UserDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String logintype = req.getParameter("logintype");
        User user = userDAO.getUserByUsername(username);
        System.out.println(user);
        if (user == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        if (!password.equals(user.getPassword())) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        req.getSession().setAttribute("USER_IN_SESSION", user);
        req.getSession().setAttribute("cartid", user.getCartid());
        if ("buyer".equals(logintype)) {
            resp.sendRedirect("/buyer");
        }
        if ("seller".equals(logintype)) {
            if("seller".equals(user.getIdentity())){
                resp.sendRedirect("/seller");
            }else{
                req.setAttribute("errType","不好意思,你不是管理员,请用用户登录!");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }


    }


}
