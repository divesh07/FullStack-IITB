package ADLocality.cucumber.tests.api;

import common.actions.InsecureClient;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;

public class ApiAction {

    private static final Logger LOG = Logger.getLogger(ApiAction.class);

    @Given("^manager Installer install AD$")
    public void create() throws Throwable {
        LOG.info("Create");
    }

    @Then("^verify the AD domain$")
    public void verify() throws Throwable {
        LOG.info("Verify");
    }

    @And("^response success$")
    public void success() throws Throwable {
        LOG.info("Respond");
    }

}
