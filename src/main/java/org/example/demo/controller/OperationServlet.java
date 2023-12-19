package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.DealDbDao;
import org.example.demo.dao.OperationDbDao;
import org.example.demo.domain.Deal;
import org.example.demo.domain.Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "operationServlet", value = "/operation-servlet")
public class OperationServlet extends HttpServlet {

    private final OperationDbDao operationDbDao = new OperationDbDao();

    private final DealDbDao dealDbDao = new DealDbDao();

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
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
        String userPath = request.getServletPath();
        if("/operation-servlet".equals(userPath)){
            request.getRequestDispatcher("/views/operation.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}
