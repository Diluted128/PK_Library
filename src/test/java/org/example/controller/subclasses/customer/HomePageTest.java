package org.example.controller.subclasses.customer;


import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import org.example.App;
import org.example.model.item.Item;
import org.example.model.user.User;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.osgi.service.TestFx;

import java.util.List;



public class HomePageTest extends TextFXBase {


    @Test
    public void reserveItem() throws Exception {

        String login = "TestUser";
        String password = "sdfir323SDF!@$";

        clickOn("#SignupButton");

        clickOn("#FirstNameTextField").write("TestFirstName");
        clickOn("#LastNameTextField").write("TestLastName");
        clickOn("#EmailAddressTextField").write("test@gmail.com");
        clickOn("#UsernameTextField").write(login);
        clickOn("#PasswordTextField").write(password);
        clickOn("#CheckBox");

        clickOn("#CreateAccountButton");

        sleep(2000);

        clickOn("#ReturnButton");



        clickOn("#LoginEmail").write(login);
        clickOn("#LoginPassword").write(password);
        clickOn("#LoginButton");

        sleep(1000);


    }
}