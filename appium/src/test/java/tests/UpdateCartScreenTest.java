package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AddToCartScreen;
import screens.UpdateCartScreen;

public class UpdateCartScreenTest extends TestBase{
    AddToCartScreen add;
    UpdateCartScreen update;

    @Test
    public void addProductToCart(){
        add = new AddToCartScreen(driver);
        add.addToCart();
        add.navigateToCartDetails();
        Assert.assertEquals(add.getAssertionMessage(),"Sauce Labs Bolt T-Shirt");
    }

    @Test(priority = 1)
    public void addOneMoreProduct(){
        update = new UpdateCartScreen(driver);
        update.addOneMoreProduct();
        Assert.assertEquals(update.getAddAssertionMessage(),"2 items");
    }

    @Test(priority = 2)
    public void removeItems(){
        update = new UpdateCartScreen(driver);
        update.removeItems();
        Assert.assertEquals(update.getRemoveItemAssertion(),"No Items");
    }
}
