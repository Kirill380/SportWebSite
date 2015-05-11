package com.gym.controlls;

import com.gym.dao.DaoFactory;
import com.gym.dao.DaoNews;
import com.gym.dao.exceptions.PersistException;
import com.gym.entity.News;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@WebServlet(name = "NewsController", value ="/NewsController")
public class NewsController extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(NewsController.class);

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
            logger.error("Cannot add the new news due to " + e.getMessage());
            status = "Cannot add the new news due to " + e.getMessage();
        }


//        request.setAttribute("result", status);
//        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
//        view.forward(request, response);

    }


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        DaoFactory df = (DaoFactory) getServletContext().getAttribute("DaoFactory");
        try {
            DaoNews daoN = df.getDaoNews();
            List<News> actual = daoN.getActual();
            JSONArray list = new JSONArray();
            for (News n : actual) {
                JSONObject temp = new JSONObject();
                temp.put("title", n.getHeader());
                temp.put("content", n.getContent());
                list.add(temp);
            }
            response.getWriter().write(list.toJSONString());
        } catch (PersistException e) {
            logger.error("Error in doGet:" + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
