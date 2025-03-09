package io.github.gandhivivek96.tests;

import io.github.gandhivivek96.pages.AddressPage;
import io.github.gandhivivek96.pages.MyAccountPage;
import io.github.gandhivivek96.pojo.AddressPOJO;
import io.github.gandhivivek96.utils.FakeAddressUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ io.github.gandhivivek96.listeners.TestListener.class })
public class AddNewFirstAddressTest extends TestBase{


    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private AddressPOJO address;
    @BeforeMethod(description = "valid first time user logs into application")
    public void setUp()
    {
        myAccountPage= homePage.goToLoginPage().doLoginwith("koyene5739@oziere.com","password");
        address = FakeAddressUtility.getFakeAddress();
    }

    @Test
    public void addAddress()
    {
        String newaddress = myAccountPage.goToAddressPage().saveAddress(address);
        Assert.assertEquals( newaddress, address.getAddressAlias().toUpperCase());
    }

}
