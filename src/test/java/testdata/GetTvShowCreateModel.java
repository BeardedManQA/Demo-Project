package testdata;

import model.TvShowCreateModel;
import utilities.GenerateFakeMessage;

public class GetTvShowCreateModel {

    public static TvShowCreateModel getDefaultTvShowFields() {
        TvShowCreateModel tvShowFields = TvShowCreateModel
                .builder()
                .filePath("C:/Users/Angry Beard/Git_repo/FinalQualificationProject/src/test/resources/upload_poster.jpg")
                .tvShowTitle("!AutoTvShow")
                .description(GenerateFakeMessage.getFakeName())
                .directors(GenerateFakeMessage.getFakeName())
                .stars(GenerateFakeMessage.getFakeName())
                .build();
        return tvShowFields;
    }

}
