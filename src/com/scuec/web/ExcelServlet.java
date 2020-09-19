package com.scuec.web;

import com.scuec.pojo.Article;
import com.scuec.service.ArticleService;
import com.scuec.service.impl.ArticleServiceImpl;
import com.scuec.utils.WebUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ExcelServlet extends BaseServlet {

    private ArticleService articleService = new ArticleServiceImpl();
    public void export(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 获取数据
        List<Article> articles = articleService.queryArticals();
        System.out.println(articles);

        //Excel标题
        String[] title = {"标题","作者","id"};

        //Excel文件名
        String fileName = "文章表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "第一页";
        String[][] content = new String[articles.size()][];
        for(int i=0; i<articles.size(); i++){
            content[i] = new String[title.length];
            Article a = articles.get(i);
            content[i][2] = String.valueOf(a.getId());
            content[i][0] = a.getHeader();
            content[i][1] = a.getAuthor();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = WebUtils.getHSSFWorkbook(sheetName, title, content, null);
        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("Content-disposition", "attachment;filename=file.xls");
        OutputStream ouputStream = resp.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();


    }
    public void importExcle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Article> articles = WebUtils.excleImport();
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/pages/manager/article_manager.jsp").forward(req,resp);
    }
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
