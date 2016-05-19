package com.outsource.qa.stepDefinitions;

import com.outsource.qa.pages.RailplusHomePage;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * PuppyHomeSteps.java - PuppyHomePage page related steps definition class
 *
 * @author Shiwantha Lakmal
 * @version 1.0-SNAPSHOT Last modified 11_23_2015
 * @since 12/20/2015.
 */
public class PuppyHomeSteps {

    //private PuppyHomePage homePage;
    //private PuppyViewPage viewPage;
    private RailplusHomePage rph;

    @Given("^I am on the puppy adoption home page$")
    public void I_am_on_the_puppy_adoption_home_page() throws Throwable {
        //homePage = new PuppyHomePage(Hooks.driver);
        rph = new RailplusHomePage(Hooks.driver);
    }

    @Then("^I should see page header title$")
    public void I_should_see_page_header_title() throws Throwable {
        //homePage.validate_Page_Header_Title("Puppy List");
        rph.call_about_page();
    }

    @And("^I should see puppy view page button$")
    public void I_should_see_puppy_view_page_button() throws Throwable {
        //viewPage = homePage.step_Click_Puppy_View();
    }

}
