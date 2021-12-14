package com.project.stepdefs;

import api.methods.CharacterMethods;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;


public class MyStepdefs {

    @Before
    public void setReportName(Scenario scenario) {
        System.out.println(scenario.getName());
    }

    @Given("Bring all the characters from the Rick & Morty cartoon through the {string}.")
    public void bringAllTheCharactersFromTheRickMortyCartoonThroughThe(String desiredURL) {
        CharacterMethods obj = new CharacterMethods();
        Assert.assertTrue(obj.getAllCharacter(desiredURL));
    }

    @Then("It is checked that there is {string} on the incoming data.")
    public void itIsCheckedThatThereIsOnTheIncomingData(String desiredData) {
        CharacterMethods obj = new CharacterMethods();
        Assert.assertTrue(obj.controlAllCharacterForName(desiredData));
    }
}

