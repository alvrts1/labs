package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.DealDbDao;
import org.example.demo.domain.Deal;
import org.example.demo.domain.SubAccount;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "dealServlet", value = "/deal-servlet")
public class DealServlet extends HttpServlet {

    private final DealDbDao dealDbDao = new DealDbDao();
    public DealServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            List<Deal> dealList = new ArrayList<>(dealDbDao.findAll());
            request.setAttribute("deals", dealList);

        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        String userPath = request.getServletPath();
        if("/deal-servlet".equals(userPath)){
            request.getRequestDispatcher("/views/deal.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
