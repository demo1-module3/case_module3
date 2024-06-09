package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.Bill;
import org.example.bai_case_module3.model.bill.BillDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BillService {
    private BillDAO billDAO;

    public BillService() {
        this.billDAO = new BillDAO();
    }

    public void renderPageListBill(HttpServletRequest req, HttpServletResponse resp) {
        List<Bill> bills=this.billDAO.selectAll();
        req.setAttribute("bills",bills);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("/views/billView/list.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void renderPageAddBill(HttpServletRequest req, HttpServletResponse resp) {
    }

    public void deleteBill(HttpServletRequest req, HttpServletResponse resp) {
    }
}
