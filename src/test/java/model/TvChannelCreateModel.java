package model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString

public class TvChannelCreateModel {

    private String channelName;
    private String stbLink;

}
