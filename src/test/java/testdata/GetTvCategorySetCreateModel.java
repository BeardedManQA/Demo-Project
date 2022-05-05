package testdata;

import model.TvCategorySetCreateModel;

public class GetTvCategorySetCreateModel {

    public static TvCategorySetCreateModel getDefaultCategorySetFields() {
        TvCategorySetCreateModel categorySetFields = TvCategorySetCreateModel
                .builder()
                .setName("!AutoCategorySet")
                .build();
        return categorySetFields;
    }

}
