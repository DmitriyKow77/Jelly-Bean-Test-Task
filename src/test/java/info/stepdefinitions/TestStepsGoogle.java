package info.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.google.GoogleMainPage;
import drivers.google.SearchResult;
import drivers.utils.DriverUtil;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class TestStepsGoogle {
    private WebDriver driver;
    private GoogleMainPage googleMainPage;

    public TestStepsGoogle() {
        driver = DriverUtil.get_driver();
    }

    @Given("^I open page \"([^\"]*)\"$")
    public void iOpenPage(String testUrl) throws Throwable {
        driver.get(testUrl);
    }

    @When("^I search for text \"([^\"]*)\"$")
    public void iSearchForText(String searchText) throws Throwable {
        googleMainPage = new GoogleMainPage(driver);
        googleMainPage.search_input().sendKeys(searchText);
        googleMainPage.search_input().submit();
    }

    @Then("^I print number of search results$")
    public void iPrintNumberOfSearchResults() throws Throwable {
        int resultsNumber = googleMainPage.get_search_results().size();
        assertTrue("Search results were empty" ,resultsNumber > 0);
        System.out.println(String.format("Number of search results is %d", resultsNumber));
    }

    @And("^I click on first search result$")
    public void iClickOnFirstSearchResult() throws Throwable {
       SearchResult firstResult = googleMainPage.get_search_results().get(0);
       String linkValue = firstResult.getLinkValue();
       firstResult.searchTitle().click();

       String redirectUrl = driver.getCurrentUrl();
       assertEquals("Didn't redirect to expected link", redirectUrl, linkValue);
    }
}