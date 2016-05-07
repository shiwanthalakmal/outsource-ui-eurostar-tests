package com.outsource.qa.stepDefinitions;

import com.outsource.qa.pages.RailDestinationPage;
import com.outsource.qa.pages.RailplusHomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 5/3/2016.
 */
public class RailTicketSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(RailTicketSteps.class);
    RailplusHomePage railHomePage;
    RailDestinationPage railDestinationPage;

    @Given("^I am on the railplus home page for search$")
    public void I_am_on_the_railplus_home_page_for_search() throws Throwable {
        railHomePage = new RailplusHomePage(Hooks.driver);
        LOGGER.info("Step: I am on the railplus home page");
    }

    @And("^Click on the \"([^\"]*)\" tab under main menu for search$")
    public void Click_on_the_tab_under_main_menu_for_search(String arg1) throws Throwable {
        LOGGER.info("Step: Click on the home tab under submenu");
    }

    @Then("^I should see \"([^\"]*)\" option as the default enabled traveling type option and \"([^\"]*)\" option will set as disable$")
    public void I_should_see_option_as_the_default_enabled_traveling_type_option_and_option_will_set_as_disable(String arg1, String arg2){
        railHomePage.check_And_Validate_Ticket_Type_Default_Selection();
        LOGGER.info("Step: Verify the ticket types default section");
    }

    @And("^I should see \"([^\"]*)\" option as default fares type option$")
    public void I_should_see_option_as_default_fares_type_option(String arg1){
        railHomePage.check_And_Validate_Fare_Type_Default_Selection();
        LOGGER.info("Step: Verify the fares types default section");
    }

    @And("^I should see seat reservation check box as by default unchecked$")
    public void I_should_see_seat_reservation_check_box_as_by_default_unchecked() throws Throwable {
        railHomePage.check_And_Validate_Seat_Reservation_Default_Selection();
        LOGGER.info("Step: Verify the seat reservation default section");
    }

    @When("^I click \"([^\"]*)\" link under train ticket modal view$")
    public void I_click_link_under_train_ticket_modal_view(String arg) {
        if (arg.equals("Can I Book")){
            railDestinationPage = railHomePage.step_Click_On_The_Advance_Book_Link();}
        else{railHomePage.step_Click_On_The_Age_Rule_Link();}
        LOGGER.info("Step: Click on the advance booking or age rule link");
    }

    @Then("^I should see \"([^\"]*)\" overlay with country specific age rules$")
    public void I_should_see_overlay_with_country_specific_age_rules(String arg){
        railHomePage.check_And_Validate_Age_Rule_Overlay_Header(arg);
        LOGGER.info("Step: Appear country specific age rules overlay");
    }

    @And("^I close \"([^\"]*)\" modal dialog$")
    public void I_close_modal_dialog(String arg){
        railHomePage.step_Close_Age_Rule_overlay();
    }

    @And("^I should see page header title as \"([^\"]*)\" for search$")
    public void I_should_see_page_header_title_as_for_search(String arg) throws Throwable {
        railHomePage.check_And_Validate_Eurostar_Home_Page(arg);
        LOGGER.info("Step: I should see page header title as " + arg);
    }

    @Then("^I should navigate to the \"([^\"]*)\" site and verify the header title as \"([^\"]*)\" for search$")
    public void I_should_navigate_to_the_site_and_verify_the_header_title_as_for_search(String title, String tab) throws Throwable {
        railDestinationPage.check_And_Validate_Eurostart_Destination_Page(title);
        LOGGER.info("Step: Verify the "+tab+"  navigation flow");
    }

    @When("^I click on the select the \"([^\"]*)\" search option$")
    public void I_click_on_the_select_the_search_option(String arg1) throws Throwable {
        railHomePage.click_Return_Search_Option("ON");
    }

    @Then("^Appear return date and time dynamically$")
    public void Appear_return_date_and_time_dynamically() throws Throwable {
        railHomePage.check_And_Validate_Return_Date("2016");
        railHomePage.check_And_Validate_Return_Time("PM");
    }
}
