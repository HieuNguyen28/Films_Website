package com.fpoly.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.Model.User;
import com.fpoly.ModelDAO.UserDAO;
import org.apache.commons.beanutils.BeanUtils;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            BeanUtils.populate(user, req.getParameterMap());
            UserDAO dao = new UserDAO(User.class);
            dao.insert(user);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
            //req.getRequestDispatcher("/LoginServlet").forward(req, resp);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", e.getMessage());
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
    }

}
