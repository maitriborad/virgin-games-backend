package com.virgingames.steps;

import com.virgingames.constants.EndPoints;
import com.virgingames.gameinfo.GameStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

public class GameStepsTest {
    static ValidatableResponse response;
    static List<String> currency;
    @Steps
    GameStep gameStep;

    @When("^I Get data of Bingo's currency$")
    public void iGetDataOfBingoSCurrency() {
        response= gameStep.getAllDataGBP();
        response.log().all();
    }
    @Then("^I Verify that data=GBP$")
    public void iVerifyThatDataGBP() {
        response.statusCode(200);
        currency = response.extract().jsonPath().get("data.pots*.currency");
        for (String currencyR:currency) {
            Assert.assertEquals(currencyR, EndPoints.PARAM_GBP);
        }
    }
    @Then("^I verify that pot id=\"([^\"]*)\" has name=\"([^\"]*)\"$")
    public void iVerifyThatPotIdHasName(String id, String name) {
        String s1 = "data.pots.find{it.id == '";
        String s2 = "'}.name";
        response.statusCode(200);
        String nameR=response.extract().path(s1+id+s2);
        Assert.assertEquals(nameR,name);
    }
}
