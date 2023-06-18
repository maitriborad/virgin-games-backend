package com.virgingames.gameinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GameStep {

    @Step("Getting and Verifying data of currency GBP")
    public ValidatableResponse getAllDataGBP(){
        return SerenityRest.given().log().all()
                .queryParam("currency", EndPoints.PARAM_GBP)
                .when()
                .get(EndPoints.GET_BY_CURRENCY_NAME)
                .then();
    }
}
