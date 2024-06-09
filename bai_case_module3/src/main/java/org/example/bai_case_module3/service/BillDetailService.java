package org.example.bai_case_module3.service;

import org.example.bai_case_module3.entity.BillDetails;
import org.example.bai_case_module3.model.bill.BillDAO;
import org.example.bai_case_module3.model.billDetail.BillDetailDAO;
import org.example.bai_case_module3.model.products.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BillDetailService {
    private BillDAO billDAO;
    private BillDetailDAO billDetailDAO;
    private ProductDAO productDAO;

    public BillDetailService() {
        this.billDAO = new BillDAO();
        this.billDetailDAO = new BillDetailDAO();
        this.productDAO = new ProductDAO();
    }

    public void renderPageListBillDetail(HttpServletRequest req, HttpServletResponse resp) {
        List<BillDetails> billDetails = this.billDetailDAO.selectAll();
        req.setAttribute("billDetails", billDetails);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/views/billDetailView/list.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void rederPageAddBillDetail(HttpServletRequest req, HttpServletResponse resp) {
    }

    public void addNewBillDetail(HttpServletRequest req) {
    }

    public void deleteBillDetailById(int id) {
    }
}
