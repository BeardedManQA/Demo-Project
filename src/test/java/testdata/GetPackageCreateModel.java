package testdata;

import model.PackageCreateModel;

public class GetPackageCreateModel {

    public static PackageCreateModel getDefaultPackageField() {
        PackageCreateModel packageName = PackageCreateModel
                .builder()
                .packageName("!AutoPackage")
                .build();
        return packageName;
    }

}
