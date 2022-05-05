package testdata;

import model.SeriesSetCreateModel;

public class GetSeriesSetCreateModel {

    public static SeriesSetCreateModel getDefaultCategorySetFields() {
        SeriesSetCreateModel seriesCategorySetFields = SeriesSetCreateModel
                .builder()
                .setName("!AutoCategorySet")
                .build();
        return seriesCategorySetFields;
    }

}
