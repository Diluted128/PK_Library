package org.example;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import org.example.model.item.ItemDTO;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.matcher.base.NodeMatchers;

public class CustomerTest  extends TextFXBase {

    @Test
    public void shouldReserveABook() {

        //given
        String customer = "customer";
        String worker = "worker";

        //when
        clickOn("#LoginEmail").write(customer);
        clickOn("#LoginPassword").write(customer);
        clickOn("#LoginButton");

        clickOn("#RentItemButton");
        clickOn("#IdField").write("12");
        clickOn("#rentItemButton");

        clickOn("#MyItemsButton");
        sleep(1000);



        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(worker);
        clickOn("#LoginPassword").write(worker);
        clickOn("#LoginButton");

        clickOn("#changeSceneToConfirmRental");
        clickOn("#rentalItemId").write("12");
        clickOn("#confirmRentalButton");



        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(customer);
        clickOn("#LoginPassword").write(customer);
        clickOn("#LoginButton");


        sleep(1000);

        //then
        FxAssert.verifyThat("#items", NodeMatchers.hasChild("12"));
        sleep(1000);


        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(worker);
        clickOn("#LoginPassword").write(worker);
        clickOn("#LoginButton");

        clickOn("#changeSceneToConfirmRental");
        clickOn("#pikcupItemId").write("12");
        clickOn("#confirmPickupButton");

        sleep(1000);

        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(customer);
        clickOn("#LoginPassword").write(customer);
        clickOn("#LoginButton");

        sleep(1000);



    }
}
