package com.gym.controlls;

import com.gym.dao.DaoFactory;
import com.gym.dao.DaoUser;
import com.gym.dao.exceptions.PersistException;
import com.gym.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nout on 11/05/2015.
 */
public class LogInController extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(LogInController.class);

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        DaoFactory df = (DaoFactory) getServletContext().getAttribute("DaoFactory");
        try {
            DaoUser du = df.getDaoUser();
            User user = du.find(email);
            if(user == null)
                req.getRequestDispatcher("").forward(req, resp);
            if(user.getPass().equals(pass)){
                req.getSession().setAttribute("user", email);
                req.getSession().setAttribute("role", user.getRole());
                req.getRequestDispatcher("").forward(req, resp);
            } else {
                req.getRequestDispatcher("").forward(req, resp);
            }


        } catch (PersistException e) {
           logger.error(e.getMessage());
        }
    }
}
