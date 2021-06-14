package org.example;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import org.example.model.item.ItemDTO;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.TableViewMatchers;

public class CustomerTest  extends TextFXBase {

    @Test
    public void shouldReserveABook() {
        //login values
        String customer = "customer";
        String worker = "worker";

        //log in as customer
        clickOn("#LoginEmail").write(customer);
        clickOn("#LoginPassword").write(customer);
        clickOn("#LoginButton");
        sleep(4000);

        //reserve item with id 12
        clickOn("#RentItemButton");
        clickOn("#IdField").write("12");
        clickOn("#rentItemButton");
        sleep(4000);

        //verify, that item is not already rented
        clickOn("#MyItemsButton");
        sleep(4000);


        //log out and log in as worker
        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(worker);
        clickOn("#LoginPassword").write(worker);
        clickOn("#LoginButton");

        //confirm reservation, make item rented
        clickOn("#changeSceneToConfirmRental");
        clickOn("#rentalItemId").write("12");
        clickOn("#confirmRentalButton");
        FxAssert.verifyThat("#items", TableViewMatchers.hasTableCell("true"));
        FxAssert.verifyThat("#items", TableViewMatchers.hasTableCell("false"));
        FxAssert.verifyThat("#items", TableViewMatchers.hasNumRows(1));
        sleep(4000);


        //log out and log in as customer
        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(customer);
        clickOn("#LoginPassword").write(customer);
        clickOn("#LoginButton");


        //verify that item with id 12 is now rented
        FxAssert.verifyThat("#items", TableViewMatchers.hasTableCell("12"));
        FxAssert.verifyThat("#items", TableViewMatchers.hasNumRows(1));
        sleep(4000);


        //log out and log in as worker
        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(worker);
        clickOn("#LoginPassword").write(worker);
        clickOn("#LoginButton");

        //pick up the book, verify it's not longer in rented/reserved list
        clickOn("#changeSceneToConfirmRental");
        clickOn("#pikcupItemId").write("12");
        clickOn("#confirmPickupButton");
        sleep(4000);


        FxAssert.verifyThat("#items", TableViewMatchers.hasNumRows(0));
        sleep(4000);

        //log out and log in as customer, verify he has no items rented
        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(customer);
        clickOn("#LoginPassword").write(customer);
        clickOn("#LoginButton");

        FxAssert.verifyThat("#items", TableViewMatchers.hasNumRows(0));
        sleep(4000);
    }

    @Test
    public void shouldPayPenalty() {

        //login value
        String customer = "customer";

        //log in as customer
        clickOn("#LoginEmail").write(customer);
        clickOn("#LoginPassword").write(customer);
        clickOn("#LoginButton");
        sleep(1000);

        //change scene to my profile and verify penalty is 25.5
        clickOn("#changeSceneToMyProfile");
        FxAssert.verifyThat("#balanceField", NodeMatchers.hasChild("25.5"));
        sleep(3000);

        //verify penalty is 0.0
        clickOn("#payPenalty").write("12");
        FxAssert.verifyThat("#balanceField", NodeMatchers.hasChild("0.0"));
        sleep(3000);
    }
}
