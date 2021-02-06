package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "":
                showList(request, response);
                break;
            case "insert":
                showInsertForm(request,response);
                break;
            case "update":
                showUpdateForm(request,response);
                break;
            case "search":
                findByName(request,response);
                break;

        }

    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Product> productList = productService.findByName(name);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        request.setAttribute("danhSach", productList);
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
        rd.forward(request,response);
    }

    private void showInsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.selectAll();
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        request.setAttribute("danhSach", productList);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "":
                showList(request, response);
                break;
            case "insert":
                InsertForm(request,response);
                break;
            case "update":
                update(request,response);
                break;

        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Product product = new Product(id, name,description);
        productService.insert(product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void InsertForm(HttpServletRequest request, HttpServletResponse response) {
        int id = (int)(Math.random()*100000);
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Product product = new Product(id,name,description);
        productService.insert(product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
