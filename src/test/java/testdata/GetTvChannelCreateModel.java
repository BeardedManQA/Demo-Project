package testdata;

import model.TvChannelCreateModel;

public class GetTvChannelCreateModel {

    public static TvChannelCreateModel getDefaultChannelFields() {
        TvChannelCreateModel tvChannelFields = TvChannelCreateModel
                .builder()
                .channelName("!AutoChannel")
                .stbLink("http://sample.vodobox.com/planete_interdite/planete_interdite_alternate.m3u8")
                .build();
        return tvChannelFields;
    }

}
