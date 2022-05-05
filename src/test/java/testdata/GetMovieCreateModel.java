package testdata;

import model.MovieCreateModel;

public class GetMovieCreateModel {

    public static MovieCreateModel getDefaultMovieFields() {
        MovieCreateModel movieFields = MovieCreateModel
                .builder()
                .movieTitle("!AutoMovie")
                .stbLink("http://sample.vodobox.com/planete_interdite/planete_interdite_alternate.m3u8")
                .build();
        return movieFields;
    }

}
