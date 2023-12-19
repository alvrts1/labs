package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.AccountPlanDbDao;
import org.example.demo.dao.DealDbDao;
import org.example.demo.dao.OperationDbDao;
import org.example.demo.dao.SubAccountDbDao;
import org.example.demo.domain.Deal;
import org.example.demo.domain.Operation;
import org.example.demo.domain.SubAccount;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "operationServlet", value = "/operation-servlet")
public class OperationServlet extends HttpServlet {

    private final OperationDbDao operationDbDao = new OperationDbDao();

    private final DealDbDao dealDbDao = new DealDbDao();

    private final SubAccountDbDao subAccountDbDao = new SubAccountDbDao();

    private final AccountPlanDbDao accountPlanDbDao = new AccountPlanDbDao();

    public OperationServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            List<Operation> operationList = new ArrayList<>(operationDbDao.findAll());
            request.setAttribute("operations", operationList);
            List<Deal> dealList = new ArrayList<>(dealDbDao.findAll());
            request.setAttribute("deals", dealList);
            List<SubAccount> subAccountList = new ArrayList<>(subAccountDbDao.findAll());
            for(SubAccount s: subAccountList){
                s.setAccountPlan(accountPlanDbDao.findById(s.getAccountId()));
            }
            request.setAttribute("subAccounts", subAccountList);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        String userPath = request.getServletPath();
        if("/operation-servlet".equals(userPath)){
            request.getRequestDispatcher("/views/operation.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        OperationDbDao operationDbDao1 = new OperationDbDao();

        int number = Integer.parseInt(request.getParameter("inputNumber"));
        String date = request.getParameter("inputDate");
        String type = request.getParameter("inputType");
        float sum = Float.parseFloat(request.getParameter("inputSum"));
        float saldoInput = Float.parseFloat(request.getParameter("inputSaldoInput"));
        float saldoOutput = Float.parseFloat(request.getParameter("inputSaldoOutput"));

        String deal = request.getParameter("deal");
        String subAccount = request.getParameter("subAccount");

        int index1 = deal.indexOf('=');
        int index2 = deal.indexOf(",");
        String c1 = deal.substring(index1+1, index2);
        Long dealId = Long.parseLong(c1.trim());

        int index3 = subAccount.indexOf('=');
        int index4 = subAccount.indexOf(",");
        String c2 = subAccount.substring(index1+1, index2);
        Long subAccountId = Long.parseLong(c1.trim());

        try {
            Operation operation = new Operation(number, date, type, sum, saldoInput, saldoOutput, dealDbDao.findById(dealId), subAccountDbDao.findById(subAccountId), dealId, subAccountId);
            Long index = operationDbDao1.insert(operation);
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        doGet(request, response);
    }

}
