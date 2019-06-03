package StepDef;

import client.CurrencyMarketsTestClient;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import util.PropertyLoader;

import static util.CommonHelper.convertJsonToCsv;
import static util.CommonHelper.getRandomNumberInRange;
import static util.CucumberHook.getScenario;

public class CurrencyMarketsStepDef {

    private PropertyLoader propertyLoader;
    private Scenario scenario;
    private CurrencyMarketsTestClient currencyMarketsTestClient;
    private Response response;
    private JSONObject responseJson;
    private String siteUrl;

    public CurrencyMarketsStepDef(){
        propertyLoader = new PropertyLoader();
        scenario = getScenario();
        currencyMarketsTestClient = new CurrencyMarketsTestClient();
    }
    @Given("fixer site url and API key is available")
    public void fixer_site_url_and_API_key_is_available() {
        siteUrl=propertyLoader.getProperty("siteUrl")+propertyLoader.getProperty("apiKey");
        scenario.write("site Url with API key: "+siteUrl);
    }

    @When("make a GET call to fixer api")
    public void make_a_GET_call_to_fixer_api() {
        response= currencyMarketsTestClient.getCurrencyDetails(siteUrl);

    }

    @Then("success code (.*) is returned")
    public void success_code_is_returned(Integer responseCode) {
        Assert.assertTrue(responseCode==response.statusCode());
        responseJson=convertResponseToJson(response);
        Assert.assertTrue(responseJson.getBoolean("success"));

        scenario.write("response: "+responseJson);
    }
    @And("(.*) random currencies are stored from the result")
    public void random_currencies_are_stored_from_the_result(Integer currencyCount) throws Exception {

        final int totalCurrenciesReturned=responseJson.getJSONObject("rates").length();
        scenario.write("total currencies returned: "+totalCurrenciesReturned);
        // storing the name of random currencies
        String[] currencyName=new String[10];
        for(int i=0;i<10;i++){
            currencyName[i]= (responseJson.getJSONObject("rates").names().get(getRandomNumberInRange(1, totalCurrenciesReturned)).toString());
        }
        // writing the name & value of each currencies
        JSONObject currenciesJson= new JSONObject();
        for(int i=0;i<currencyName.length;i++){
           currenciesJson.put(currencyName[i],responseJson.getJSONObject("rates").get(currencyName[i]));
        }
        scenario.write("Random currencies: "+currenciesJson.toString());
        // writing currencies to csv file
        Assert.assertTrue(convertJsonToCsv(currenciesJson));
    }



    public JSONObject convertResponseToJson(Response response){
        return new JSONObject(response.asString());
    }
}
