package com.flogger.views;

import com.flogger.models.ArticleModel;
import org.supercsv.io.ICsvBeanWriter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ArticlesCSVViewBuilder extends AbstractCsvView{

    @Override
    protected void buildCsvDocument(ICsvBeanWriter csvWriter,
                                    Map<String, Object> model) throws IOException {

        List<ArticleModel> articles = (List<ArticleModel>) model.get("csvData");
        String[] header = (String[]) model.get("csvHeader");

        csvWriter.writeHeader(header);

        for (ArticleModel article : articles) {
            csvWriter.write(article, header);
        }
    }
}
