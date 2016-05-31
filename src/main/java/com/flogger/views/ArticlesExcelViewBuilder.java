package com.flogger.views;

import org.apache.poi.ss.usermodel.*;

/**
 * Created by andrei on 5/31/2016.
 */

import com.flogger.models.ArticleModel;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ArticlesExcelViewBuilder extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response)   throws Exception {

        List<ArticleModel> articles = (List<ArticleModel>) model.get("articles");

        Sheet sheet = workbook.createSheet("Articles");
        sheet.setDefaultColumnWidth(50);

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Article #");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("Header");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Contents");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("Date");
        header.getCell(3).setCellStyle(style);

        header.createCell(4).setCellValue("Number of Likes");
        header.getCell(4).setCellStyle(style);

        header.createCell(5).setCellValue("Wrote by");
        header.getCell(5).setCellStyle(style);

        for (int i = 0; i < articles.size(); i++){

            ArticleModel articleModel = articles.get(i);
            Row currentRow = sheet.createRow(i+1);

            currentRow.createCell(0).setCellValue(articleModel.getId());
            currentRow.createCell(1).setCellValue(articleModel.getHeader());
            currentRow.createCell(2).setCellValue(articleModel.getContents());
            currentRow.createCell(3).setCellValue(articleModel.getTimestamp());
            currentRow.createCell(4).setCellValue(articleModel.getLikesCount());
            currentRow.createCell(5).setCellValue("user #" + articleModel.getOwnerId());
        }
    }
}
