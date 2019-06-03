package util;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class CucumberHook {

    private static Scenario scenario;

    @Before
    public void beforeMethod(Scenario scenario){
        this.scenario =scenario;
    }

    public static Scenario getScenario(){
        return scenario;
    }

}
