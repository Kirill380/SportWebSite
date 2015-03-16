package com.gym;

import com.gym.dao.DaoFactory;
import com.gym.dao.DaoNews;
import com.gym.dao.exceptions.PersistException;
import com.gym.entity.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;


@WebServlet(name = "NewsController", value ="/NewsController")
public class NewsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = "The new news was added";
        String head = request.getParameter("head");
        String content = request.getParameter("content");
        DaoFactory df = (DaoFactory) getServletContext().getAttribute("DaoFactory");
        try {
            DaoNews daoN = df.getDaoNews();
            News temp = new News();
            temp.setContent(content);
            temp.setHeader(head);
            temp.setOrderDate(new Timestamp(new Date().getTime()));
            daoN.persist(temp);
        } catch (PersistException e) {
            status = "Cannot add the new news due to " + e.getMessage();
        }

//        request.setAttribute("result", status);
//        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
//        view.forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
