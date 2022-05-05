package model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString

public class SubscriberCreateModel {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String number;
    private String address;
    private String city;
    private String zipcode;

}
