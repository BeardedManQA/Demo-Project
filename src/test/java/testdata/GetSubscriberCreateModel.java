package testdata;

import model.SubscriberCreateModel;
import utilities.GenerateFakeMessage;

public class GetSubscriberCreateModel {

    public static SubscriberCreateModel getDefaultSubscriberFields() {
        SubscriberCreateModel subscriberFields = SubscriberCreateModel
                .builder()
                .userName("!AutoUser")
                .firstName(GenerateFakeMessage.getFakeName())
                .lastName(GenerateFakeMessage.getFakeName())
                .email(GenerateFakeMessage.getFakeEmail())
                .number(GenerateFakeMessage.getFakeNumber())
                .address(GenerateFakeMessage.getFakeAddress())
                .city(GenerateFakeMessage.getFakeCity())
                .zipcode(GenerateFakeMessage.getFakeZipcode())
                .build();
        return subscriberFields;
    }

}
