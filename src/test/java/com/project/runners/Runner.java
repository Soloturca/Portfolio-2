package com.project.runners;


import api.base.BaseTest;
import com.project.listener.MyLocalVariables;
import gherkin.pickles.PickleTag;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apiguardian.api.API;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;

@CucumberOptions(
        features = "src/test/features/",
        tags = "@web",
        plugin = {"pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports"},
        glue = {"com.project.stepdefs"})

public class Runner extends BaseTest {

    @API(
            status = API.Status.STABLE
    )
    private TestNGCucumberRunner testNGCucumberRunner;


    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
    }

    @DataProvider
    public Object[][] features() {   Object[][] scenariosTemp = testNGCucumberRunner.provideScenarios();
        Object[][] scenarios = new Object[scenariosTemp.length][2];
        int count=0;
        for (int i = 0; i < scenariosTemp.length; i++) {

            ArrayList<PickleTag> myList = getTags((PickleEventWrapper) scenariosTemp[i][0]);
            if (checkTags("@"+MyLocalVariables.getTestTagFromList(MyLocalVariables.getActiveTestNumber()), myList)) {
                scenarios[count][0] = scenariosTemp[i][0];
                scenarios[count][1] = scenariosTemp[i][1];
                count++;
                System.out.println("tagname:"+ MyLocalVariables.getTestTagFromList(MyLocalVariables.getActiveTestNumber()));
                System.out.println(count+": count");
            }
        }

        Object[][] finalScenarios = new Object[count][2];

        for (int j=0;j<count;j++)
        {
            finalScenarios[j][0] = scenarios[j][0];
            finalScenarios[j][1] = scenarios[j][1];
        }

        return finalScenarios;
    }


    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
        MyLocalVariables.setActiveTestNumber(MyLocalVariables.getActiveTestNumber()+1);
    }

    public ArrayList<PickleTag> getTags(PickleEventWrapper o) {

        return (ArrayList<PickleTag>) o.getPickleEvent().pickle.getTags();
    }

    public boolean checkTags(String tagName, ArrayList<PickleTag> tags) {
        for (PickleTag pickleTagtag : tags) {
            if (pickleTagtag.getName().equalsIgnoreCase(tagName)) {
                return true;
            }
        }
        return false;
    }
}