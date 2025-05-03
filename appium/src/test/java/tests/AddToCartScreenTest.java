package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AddToCartScreen;

public class AddToCartScreenTest extends TestBase{
    AddToCartScreen add;

    @Test
    public void addProductToCart(){
        add = new AddToCartScreen(driver);
        add.addToCart();
        add.navigateToCartDetails();
        Assert.assertEquals(add.getAssertionMessage(),"Sauce Labs Bolt T-Shirt");
    }
}
