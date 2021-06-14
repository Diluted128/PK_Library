package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.testfx.api.FxAssert;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.TableViewMatchers;

public class ManagerTest extends TestFXBase {



    @Test
    public void shouldAddAndRemoveUser() {

        App.addInitalData();


        //login value
        String manager = "admin";

        //new worker values
        String newWorkerFirstName = "Adam";
        String newWorkerLastName = "Nowak";
        String newWorkerEmail = "adam.nowak@email.com";
        String newWorkerLogin = "anowak";
        String newWorkerPassword = "new123!Password";

        //log in as manager
        clickOn("#LoginEmail").write(manager);
        clickOn("#LoginPassword").write(manager);
        clickOn("#LoginButton");
        sleep(1000);


        //hire worker
        clickOn("#WorkerFirstName").write(newWorkerFirstName);
        clickOn("#WorkerLastName").write(newWorkerLastName);
        clickOn("#WorkerEmail").write(newWorkerEmail);
        clickOn("#WorkerLogin").write(newWorkerLogin);
        clickOn("#WorkerPassword").write(newWorkerPassword);
        clickOn("#hireWorker");

        //log out and log in as worker
        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(newWorkerLogin);
        clickOn("#LoginPassword").write(newWorkerPassword);
        clickOn("#LoginButton");

        //move to my profile and verify values
        clickOn("#changeSceneToMyProfile");
        FxAssert.verifyThat("#firstNameField", NodeMatchers.hasChild(newWorkerFirstName));
        sleep(3000);

        //log in as manager
        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(manager);
        clickOn("#LoginPassword").write(manager);
        clickOn("#LoginButton");

        clickOn("#changeSceneToFireWorker");
        clickOn("#workerToFireID").write("4");
        clickOn("#fireWorkerButton");
        FxAssert.verifyThat("#workersTable", TableViewMatchers.hasNumRows(2));
        sleep(1500);


        //log in as new worker, verify that it fails
        clickOn("#signOutButton");
        clickOn("#LoginEmail").write(newWorkerLogin);
        clickOn("#LoginPassword").write(newWorkerPassword);
        clickOn("#LoginButton");

        FxAssert.verifyThat("#WarnigUserNotExist", NodeMatchers.isVisible());
        sleep(2000);

    }

}
