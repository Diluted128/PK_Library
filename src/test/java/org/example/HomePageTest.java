package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.testfx.api.FxAssert;
import org.testfx.matcher.base.NodeMatchers;

public class HomePageTest extends TestFXBase {


    @Test
    public void shouldCreateNewAccount() throws Exception {

        App.addInitalData();


        //given
        String login = "TestUser";
        String password = "sdfir323SDF!@$";

        //when
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

        //then
        FxAssert.verifyThat("#rentedBooks", NodeMatchers.hasChild("0"));
        FxAssert.verifyThat("#rentedArticles", NodeMatchers.hasChild("0"));
        FxAssert.verifyThat("#rentedNewspapers", NodeMatchers.hasChild("0"));

    }

    @Test
    public void shouldLogInAsCustomer() throws Exception {

        App.addInitalData();


        //given
        String login = "customer";
        String password = "customer";

        //when
        clickOn("#LoginEmail").write(login);
        clickOn("#LoginPassword").write(password);
        clickOn("#LoginButton");

        sleep(1000);

        //then
        FxAssert.verifyThat("#rentedBooks", NodeMatchers.hasChild("0"));
        FxAssert.verifyThat("#rentedArticles", NodeMatchers.hasChild("0"));
        FxAssert.verifyThat("#rentedNewspapers", NodeMatchers.hasChild("0"));
    }

    @Test
    public void shouldLogInAsWorker() throws Exception {

        App.addInitalData();


        //given
        String login = "worker";
        String password = "worker";

        //when
        clickOn("#LoginEmail").write(login);
        clickOn("#LoginPassword").write(password);
        clickOn("#LoginButton");

        sleep(1000);

        //then
        FxAssert.verifyThat("#addItemSceneAnchorPane", NodeMatchers.isNotNull());

    }

    @Test
    public void shouldLogInAsManger() throws Exception {

        App.addInitalData();


        //given
        String login = "admin";
        String password = "admin";

        //when
        clickOn("#LoginEmail").write(login);
        clickOn("#LoginPassword").write(password);
        clickOn("#LoginButton");

        sleep(1000);

        //then
        FxAssert.verifyThat("#hireWorkerAnchorPane", NodeMatchers.isNotNull());

    }
}