package com.scuec.utils;

import com.scuec.pojo.Article;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     *
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            System.out.println("注入之前：" + bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    /**
     * 将某个bai日期字符串du转换为java.sql.Date的类型
     *
     * @param dateStr 可为"yyyy-MM-dd HH:mm:ss"和"yyyy-MM-dd"
     * @return
     */
    public static java.sql.Date setStringSQLDate(Object dateStr) {
        String dateInfo = String.valueOf(dateStr);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//此处引号内的是你需要的日期格式
        Date date = null;
        try {
            date = (Date) format.parse(dateInfo);
        } catch ( ParseException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, Integer defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
    /*
     * 导出Excel
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName,
                                               String[] title, String[][] values, HSSFWorkbook wb) {
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }
        // 第二步，在workbook中添加一个sheet，对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        // 第三步，在sheet中添加表头第0行，注意老版本poi对Excel行数列数有限制
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        // 声明列对象
        HSSFCell cell = null;

        // 创建标题
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        // 创建内容
        for (int i = 0; i < values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < values[i].length; j++) {
                // 将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }
    /**
     * 针对Book类进行导入的操作
     *
     * @return
     */
    public static  List<Article> excleImport() {
        List<Article> list = new ArrayList<Article>();
        Article article = null;
        try {
            InputStream is = new FileInputStream("C:/Users/86151/Documents/test.xls");
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            // 获取选项卡对象 第0个选项卡 , 因为我们这里只有一个选项卡，如果你每个选项卡的内容是一样，可以通过循环取出
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            // 循环取出每行的值
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                article = new Article();
                //获取单元格
                HSSFCell cell = hssfRow.getCell(0);
                cell.setCellType(CellType.STRING);
                article.setId(parseInt(hssfRow.getCell(0).getStringCellValue(),0));
                article.setHeader(hssfRow.getCell(1).getStringCellValue());
                article.setAuthor(hssfRow.getCell(2).getStringCellValue());
                list.add(article);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}
