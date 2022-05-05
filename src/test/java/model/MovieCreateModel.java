package model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString

public class MovieCreateModel {

    private String movieTitle;
    private String stbLink;

}
