package testdata;

import model.MoviesSetCreateModel;

public class GetMoviesSetCreateModel {

    public static MoviesSetCreateModel getDefaultCategorySetFields() {
        MoviesSetCreateModel movieCategorySetFields = MoviesSetCreateModel
                .builder()
                .setName("!AutoCategorySet")
                .build();
        return movieCategorySetFields;
    }

}
