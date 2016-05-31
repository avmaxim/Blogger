package com.flogger.views;

import com.flogger.models.ArticleModel;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Formatter;
import java.util.Map;

/**
 * Created by andrei on 5/30/2016.
 */

public class ArticlePdfViewBuilder extends  AbstractITextPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        ArticleModel article = (ArticleModel) model.get("article");

        // Header
        Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 40.0f, Font.BOLD, BaseColor.BLACK);
        Paragraph title = new Paragraph(article.getHeader(), titleFont);
        title.setSpacingBefore(30);
        doc.add(new Paragraph("FLOGGER"));

        // Body
        titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 40.0f, Font.BOLD, BaseColor.BLACK);
        Paragraph artickeHeader = new Paragraph(article.getHeader(), titleFont);
        artickeHeader.setSpacingBefore(30);
        doc.add(artickeHeader);

        Font mainInfoFont = new Font(Font.FontFamily.TIMES_ROMAN, 20.0f, Font.ITALIC, BaseColor.BLACK);
        Formatter f = new Formatter();
        Paragraph mainInfo = new Paragraph(
                f.format("Date: %s.\n",
                        article.getDate()).toString(),
                mainInfoFont);

        mainInfo.setSpacingBefore(40);
        doc.add(mainInfo);

        Font descriptionFont = new Font(Font.FontFamily.TIMES_ROMAN, 15.0f, Font.NORMAL, BaseColor.BLACK);
        Paragraph description = new Paragraph(article.getContents(), descriptionFont);
        description.setSpacingBefore(50);
        doc.add(description);

        mainInfoFont = new Font(Font.FontFamily.TIMES_ROMAN, 20.0f, Font.NORMAL, BaseColor.BLACK);
        f = new Formatter();
        Paragraph likesCount = new Paragraph(
                f.format("Likes: %s.\n" +
                                "Identifier of article: %s\n" +
                                "Written by User #%s\n",
                        article.getLikesCount(), article.getId(),
                        article.getOwnerId()).toString(),
                mainInfoFont);

        likesCount.setSpacingBefore(60);
        doc.add(likesCount);

        // Footer
        Font footerFont = new Font(Font.FontFamily.TIMES_ROMAN, 15.0f, Font.NORMAL, BaseColor.BLACK);
        Paragraph footer = new Paragraph("All rights reserved 2016 © Flogger", footerFont);
        footer.setSpacingBefore(150);
        footer.setAlignment(Paragraph.ALIGN_RIGHT);
        doc.add(footer);
    }
}
