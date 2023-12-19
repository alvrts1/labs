package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.AccountPlanDbDao;
import org.example.demo.dao.SubAccountDbDao;
import org.example.demo.domain.AccountPlan;
import org.example.demo.domain.SubAccount;

import java.io.IOException;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "subAccountServlet", value = "/subAccount-servlet")
public class SubAccountServlet extends HttpServlet {

    private final SubAccountDbDao subAccountDbDao = new SubAccountDbDao();

    private final AccountPlanDbDao accountPlanDbDao = new AccountPlanDbDao();
    public SubAccountServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            List<SubAccount> subAccountList = new ArrayList<>(subAccountDbDao.findAll());
            request.setAttribute("subAccounts", subAccountList);
            for(SubAccount s: subAccountList){
                s.setAccountPlan(accountPlanDbDao.findById(s.getAccountId()));
            }
            List<AccountPlan> accountPlanList = new ArrayList<>(accountPlanDbDao.findAll());
            request.setAttribute("accountPlans", accountPlanList);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        String userPath = request.getServletPath();
        if("/subAccount-servlet".equals(userPath)){
            request.getRequestDispatcher("/views/subAccount.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
