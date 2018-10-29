package com.rapoo.store.buyerservice;

import com.rapoo.store.*;
import com.rapoo.store.dao.ICartDAO;
import com.rapoo.store.dao.IProductDAO;
import com.rapoo.store.dao.IProductDirDAO;
import com.rapoo.store.dao.daoimpl.CartDAOImpl;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 买家的服务程序,可对买家提供对商品的查询,添加商品到购物车,查看购物车,从购车中删除等功能
 */
@WebServlet("/buyer")
public class BuyerServlet extends HttpServlet {

    IProductDAO productDAO = null;
    IProductDirDAO dirDAO = null;
    ICartDAO cartDAO = null;
    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAOImpl();
        dirDAO = new ProductDirDAOImpl();
        cartDAO = new CartDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if("cartList".equals(cmd)){
            cartList(req, resp);
            return;
        }else if("add2Cart".equals(cmd)){
            add2Cart(req, resp);
        }else if("deleteFromCart".equals(cmd)){
            deleteFromCart(req, resp);
            cartList(req, resp);
            return;
        }
        commodityList(req, resp);
    }

    protected void commodityList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductQuery pq = new ProductQuery();
        //接收来自用户的查询信息封装到查询对象
        request2Object(req,pq);
        System.out.println(1);
        //得到结果页面
        PageResult pageResult = productDAO.query(pq);
        //将查询条件和结果返还给用户
        //将查询条件回显
        req.setAttribute("pq",pq);
        //将查询结果回显
        req.setAttribute("pageResult",pageResult);
        //将商品分类列表回显,以便用户看到商品分类名
        req.setAttribute("dirs",dirDAO.query());
        //请求转发到buyer页面
        req.getRequestDispatcher("/buyer.jsp").forward(req,resp);
    }

    private void request2Object(HttpServletRequest req, ProductQuery pq) {
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

    protected void cartList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cartid = (Long) req.getSession().getAttribute("cartid");
        List<Cart> carts = cartDAO.query(cartid);
        req.setAttribute("carts",carts);
        req.getRequestDispatcher("/cartlist.jsp").forward(req, resp);
    }

    protected void add2Cart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cartid = (Long) req.getSession().getAttribute("cartid");
        System.out.println(req.getParameter("id"));
        Long cid = Long.valueOf(req.getParameter("id"));
        String scount = req.getParameter("count");
        Integer count;
        if(StringUtils.isNotBlank(scount)){
            count = Integer.valueOf(scount);
        }else{
            count = 1;
        }
        Cart cart = cartDAO.get(cartid, cid);
        System.out.println(cart);
        if(cart.getcName() == null){
            Commodity commodity = new Commodity();
            Product product = productDAO.get(cid);
            commodity.setCid(product.getId());
            commodity.setCName(product.getProductName());
            commodity.setCPrice(product.getSalePrice());
            commodity.setCount(count);
            cartDAO.add(cartid, commodity);
        }else{
            count = count + cart.getCount();
            cartDAO.update(cartid, cid, count);
        }
    }

    protected void deleteFromCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cartid = (Long) req.getSession().getAttribute("cartid");
        Long cid = Long.valueOf(req.getParameter("cid"));
        cartDAO.delete(cartid,cid);
    }

}
