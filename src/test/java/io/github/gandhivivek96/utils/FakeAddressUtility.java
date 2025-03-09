package io.github.gandhivivek96.utils;

import com.github.javafaker.Faker;
import io.github.gandhivivek96.pages.AddressPage;
import io.github.gandhivivek96.pojo.AddressPOJO;

import java.util.Locale;

public class FakeAddressUtility {

    public static AddressPOJO getFakeAddress()
    {
        Faker faker = new Faker(Locale.US);
        AddressPOJO addressPOJO = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
                faker.address().streetAddress(), faker.address().city(), faker.numerify("#####"),
                faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "other", "office address",
                faker.address().state());
        return addressPOJO;
    }
}
