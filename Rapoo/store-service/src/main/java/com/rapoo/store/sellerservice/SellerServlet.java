package com.rapoo.store.sellerservice;

import com.rapoo.store.PageResult;
import com.rapoo.store.Product;
import com.rapoo.store.ProductDir;
import com.rapoo.store.ProductQuery;
import com.rapoo.store.dao.IProductDAO;
import com.rapoo.store.dao.IProductDirDAO;
import com.rapoo.store.dao.daoimpl.ProductDAOImpl;
import com.rapoo.store.dao.daoimpl.ProductDirDAOImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/seller")
public class SellerServlet extends HttpServlet {
    IProductDAO productDAO = null;
    IProductDirDAO productDirDAO = null;
    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAOImpl();
        productDirDAO = new ProductDirDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if("delete".equals(req.getParameter("cmd"))){
            delete(req,resp);
        }else if("save".equals(req.getParameter("cmd"))){
            saveOrUpdate(req,resp);
        }else if("edit".equals(req.getParameter("cmd"))){
            edit(req,resp);
        }else if("dirlist".equals(req.getParameter("cmd"))){
            dirlist(req,resp);
        }else{
            list(req,resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户的查询条件
        //创建查询对象
        ProductQuery pq = new ProductQuery();
        //将查询条件封装到查询对象
        request2Object(pq, req);
        //返回结果给用户
        //创建页面结果对象
        //接收查询结果
        PageResult pageResult = productDAO.query(pq);
        //将查询条件回显
        req.setAttribute("pq", pq);
        //将页面结果返回
        req.setAttribute("pageResult", pageResult);
        //将商品分类信息返回
        req.setAttribute("dirs",productDirDAO.query());
        //跳转到原页面
        req.getRequestDispatcher("/seller.jsp").forward(req,resp);
    }

    private void request2Object(ProductQuery pq, HttpServletRequest req) {
        String productName = req.getParameter("productName");
        String minSalePrice = req.getParameter("minSalePrice");
        String maxSalePrice = req.getParameter("maxSalePrice");
        String dir_id = req.getParameter("dir_id");
        String keyword = req.getParameter("keyword");
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        if(StringUtils.isNotBlank(productName)){
            pq.setProductName(productName);
        }
        if(StringUtils.isNotBlank(minSalePrice)){
            pq.setMinSalePrice(new BigDecimal(minSalePrice));
        }
        if(StringUtils.isNotBlank(maxSalePrice)){
            pq.setMaxSalePrice(new BigDecimal(maxSalePrice));
        }
        if(StringUtils.isNotBlank(dir_id)){
            pq.setDir_id(new Long(dir_id));
        }
        if(StringUtils.isNotBlank(keyword)){
            pq.setKeyword(keyword);
        }
        if(StringUtils.isNotBlank(currentPage)){
            pq.setCurrentPage(Integer.valueOf(currentPage));
        }
        if(StringUtils.isNotBlank(pageSize)){
            pq.setPageSize(Integer.valueOf(pageSize));
        }
    }

    private void dirlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<ProductDir> dirs = productDirDAO.query();
        req.setAttribute("dirs",dirs);
        req.getRequestDispatcher("/productdir.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String sid = req.getParameter("id");
        if(StringUtils.isNotBlank(sid)){
            Long id = new Long(sid);
            Product product =  productDAO.get(id);
            req.setAttribute("product", product);
        }
        req.setAttribute("dirs", productDirDAO.query());
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    private void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String sid = req.getParameter("id");
        Product product = new Product();
        product.setProductName(req.getParameter("productName"));
        product.setBrand(req.getParameter("brand"));
        product.setSupplier(req.getParameter("supplier"));
        product.setDir_id(Long.valueOf(req.getParameter("dir_id")));
        product.setSalePrice(new BigDecimal(req.getParameter("salePrice")));
        product.setCostPrice(new BigDecimal(req.getParameter("costPrice")));
        product.setCutoff(new Double(req.getParameter("cutoff")));
        if(StringUtils.isNotBlank(sid)){
            product.setId(Long.valueOf(sid));
            productDAO.update(product);
        }else{
            productDAO.add(product);
        }
        resp.sendRedirect("/seller");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Long id = Long.valueOf(req.getParameter("id"));
        productDAO.delete(id);
        resp.sendRedirect("/seller");
    }
}
