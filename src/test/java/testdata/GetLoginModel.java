package testdata;

import model.LoginModel;

public class GetLoginModel {

    public static LoginModel getLoginWithAllFields() {
        LoginModel login = LoginModel
                .builder()
                .username("")
                .password("")
                .build();
        return login;
    }

}
