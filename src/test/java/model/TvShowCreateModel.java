package model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString

public class TvShowCreateModel {

    private String filePath;
    private String tvShowTitle;
    private String description;
    private String directors;
    private String stars;

}
