package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.AccountPlanDbDao;
import org.example.demo.dao.DealDbDao;
import org.example.demo.domain.AccountPlan;
import org.example.demo.domain.Deal;
import org.example.demo.domain.SubAccount;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
import java.sql.SQLException;
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
        DealDbDao dealDbDao1 = new DealDbDao();

        String agreement = request.getParameter("inputAgreement");
        String tiker = request.getParameter("inputTiker");
        String order = request.getParameter("inputOrder");
        int number = Integer.parseInt(request.getParameter("inputNumber"));
        String date = request.getParameter("inputDate");
        int quantity = Integer.parseInt(request.getParameter("inputQuantity"));
        float price = Float.parseFloat(request.getParameter("inputPrice"));
        float totalCost = Float.parseFloat(request.getParameter("inputTotalCost"));
        String trader = request.getParameter("inputTrader");
        float commission = Float.parseFloat(request.getParameter("inputCommission"));

        Deal deal = new Deal(agreement, tiker, order, number, date, quantity, price, totalCost, trader, commission);

        try {
            Long index = dealDbDao1.insert(deal);
        } catch (SQLException e){
            e.printStackTrace();
        }

        doGet(request, response);
    }

}
