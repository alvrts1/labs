package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.AccountPlanDbDao;
import org.example.demo.domain.AccountPlan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "accountPlanServlet", value = "/accountPlan-servlet")
public class AccountPlanServlet extends HttpServlet {

    private final AccountPlanDbDao accountPlanDbDao = new AccountPlanDbDao();

    public AccountPlanServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            List<AccountPlan> accountPlanList = new ArrayList<>(accountPlanDbDao.findAll());
            request.setAttribute("accountPlans", accountPlanList);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        String userPath = request.getServletPath();
        if("/accountPlan-servlet".equals(userPath)){
            request.getRequestDispatcher("/views/accountPlan.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountPlanDbDao accountPlanDbDao1 = new AccountPlanDbDao();
        String name = request.getParameter("inputName");
        String type = request.getParameter("inputType");
        int number = Integer.parseInt(request.getParameter("inputNumber"));
        AccountPlan accountPlan = new AccountPlan(name, type, number);

        try {
            Long index = accountPlanDbDao1.insert(accountPlan);
        } catch (SQLException e){
            e.printStackTrace();
        }

        doGet(request, response);
    }

}
