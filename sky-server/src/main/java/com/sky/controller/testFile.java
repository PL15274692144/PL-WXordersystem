package com.sky.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class testFile {
    public static void write() throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = xssfWorkbook.createSheet("info");
        XSSFRow row = sheet.createRow(1);
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("爱好");

        row = sheet.createRow(2);
        row.createCell(1).setCellValue("小明");
        row.createCell(2).setCellValue("篮球");

        row = sheet.createRow(3);
        row.createCell(1).setCellValue("李白");
        row.createCell(2).setCellValue("书法");

        row = sheet.createRow(4);
        row.createCell(1).setCellValue("煜神");
        row.createCell(2).setCellValue("唱跳");

        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\PPLL\\Desktop\\苍穹外卖\\资料\\day01\\后端初始工程\\sky-take-out\\sky-server\\src\\main\\resources\\template\\PL.xlsx"));

        xssfWorkbook.write(out);

        out.close();
        xssfWorkbook.close();

    }

    public void read() throws IOException {

        File file = new File("/template/PL.xlsx");
        if (file == null){
            System.out.println("文件为空！");
        }
        InputStream in = this.getClass().getResourceAsStream("/template/PL.xlsx");
//        FileInputStream in = new FileInputStream(new File("sky-server/src/main/resources/template/PL.xlsx"));
        XSSFWorkbook excel = new XSSFWorkbook(in);



        Map map = new HashMap<>();

        XSSFSheet sheet = excel.getSheet("info");
        for (int i = 0; i < 3; i++) {
            XSSFRow row = sheet.getRow(2+i);
            String xm = row.getCell(1).getStringCellValue();
            String ah = row.getCell(2).getStringCellValue();
            System.out.println("姓名："+xm+",爱好："+ah);

        }

//        System.out.println(map);
        excel.close();
        in.close();

    }

    public static void main(String[] args) throws IOException {
//        write();
//        read();
        new testFile().read();
        for(int i=1;i<=9;i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+i*j+" ");
            }
            System.out.println();
        }
    }

}
