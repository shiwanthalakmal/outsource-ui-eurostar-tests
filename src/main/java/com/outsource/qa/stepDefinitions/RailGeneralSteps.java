package com.outsource.qa.stepDefinitions;

import com.outsource.qa.pages.*;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by user on 4/23/2016.
 */
public class RailGeneralSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(RailGeneralSteps.class);

    RailplusHomePage railHomePage;
    RailAboutPage railAboutPage;
    RailContactPage railContactPage;
    RailMapPage railsMapPage;
    RailTimetablePage railTimetablePage;
    RailSubscribePage railSubscribePage;
    RailSiteMapPage railSiteMappage;
    RailPrivacyPage railPrivacyPage;
    RailDestinationPage railDestination;

    @Given("^I am on the railplus home page$")
    public void I_am_on_the_railplus_home_page(){
        railHomePage = new RailplusHomePage(Hooks.driver);
        LOGGER.info("Step: I am on the railplus home page");
    }

    @Then("^I should see page header title as \"([^\"]*)\"$")
    public void I_should_see_page_header_title_as(String arg){
        railHomePage.check_And_Validate_Eurostar_Home_Page(arg);
        LOGGER.info("Step: I should see page header title as "+arg);
    }

    @And("^I should see home tab as a default selected option$")
    public void I_should_see_home_tab_as_a_default_selected_option(){
        railHomePage.check_And_validate_Staying_Home_page();
        LOGGER.info("Step: I should see home tab as a default selected option");
    }

    @When("^I click on the home page ([^\"]*) link$")
    public void I_click_on_the_home_page_link_link(String link) throws Throwable {
        if (link.equals("About")){railAboutPage = ((RailAboutPage) railHomePage.step_Click_Given_Main_Menu_Link(link));}
        else if (link.equals("Contact")){railContactPage = ((RailContactPage) railHomePage.step_Click_Given_Main_Menu_Link(link));}
        else if (link.equals("Maps")){railsMapPage = ((RailMapPage) railHomePage.step_Click_Given_Main_Menu_Link(link));}
        else if (link.equals("Timetables")){railTimetablePage = ((RailTimetablePage) railHomePage.step_Click_Given_Main_Menu_Link(link));}
        else if (link.equals("Subscribe")){railSubscribePage = ((RailSubscribePage) railHomePage.step_Click_Given_Main_Menu_Link(link));}
        else if (link.equals("Site")){railSiteMappage = ((RailSiteMapPage) railHomePage.step_Click_Given_Main_Menu_Link(link));}
        else if (link.equals("Privacy")){railPrivacyPage = ((RailPrivacyPage) railHomePage.step_Click_Given_Main_Menu_Link(link));}
        LOGGER.info("Step: By clicking main menu "+link+" link and verify the navigation flow");
    }

    @Then("^I should navigate to the ([^\"]*) site and verify the header title as ([^\"]*)$")
    public void I_should_navigate_to_the_link_site_and_verify_the_header_title_as_title(String link,String title) throws Throwable {
        if (link.equals("About")){railAboutPage.check_And_Validate_PageHeader(title);}
        else if (link.equals("Contact")){railContactPage.check_And_Validate_PageHeader(title);}
        else if (link.equals("Maps")){railsMapPage.check_And_Validate_PageHeader(title);}
        else if (link.equals("Timetables")){railTimetablePage.check_And_Validate_PageHeader(title);}
        else if (link.equals("Subscribe")){railSubscribePage.check_And_Validate_PageHeader(title);}
        LOGGER.info("Step: Verify the "+link+" navigation flow");
    }

    @When("^I click on the home page ([^\"]*) modal tab button$")
    public void I_click_on_the_home_page_modal_tab_button(String arg) throws Throwable {
        railHomePage.step_Click_Given_Modal_Tab(arg);
        LOGGER.info("Step: Click on the banner modal "+arg+ "tab");
    }

    @Then("^I should navigate to the particular modal view and verify the header title as ([^\"]*)$")
    public void I_should_navigate_to_the_particular_modal_view_and_verify_the_header_title_as(String arg){
        railHomePage.check_And_Validate_Modal_Title(arg);
        LOGGER.info("Step: Verify the modal panel title");
    }

    @When("^I choose specific banner indexes randomly$")
    public void I_choose_specific_banner_indexes_randomly(){
        railHomePage.step_Click_Banner_Pagination_icon(1);
    }

    @And("^I click info button in that particular slider$")
    public void I_click_info_button_in_that_particular_slider(){
        railHomePage.step_Click_Banner_Quick_Link_Info_Button(1);
        LOGGER.info("Step: Click on the banner quick link info button");
    }

    @Then("^I should navigate to the relevant page and verify page header$")
    public void I_should_navigate_to_the_relevant_page_and_verify_page_header(){
        LOGGER.info("Step: Navigate to the quick link page");
    }

    @When("^I choose left arrow in main banner$")
    public void I_choose_left_arrow_in_main_banner(){

    }

    @And("^I click on the back to top link to move top of the page$")
    public void I_click_on_the_back_to_top_link_to_move_top_of_the_page(){
        railHomePage.step_Click_Back_To_Top_Link();
        LOGGER.info("Step: Click on the back to top link");
    }

    @And("^Click on the \"([^\"]*)\" tab under main menu$")
    public void Click_on_the_tab_under_main_menu(String arg1){
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

    @Then("^I should navigate to the \"([^\"]*)\" site and verify the header title as \"([^\"]*)\"$")
    public void I_should_navigate_to_the_site_and_verify_the_header_title_as(String tab, String title){
        railDestination.check_And_Validate_Eurostart_Destination_Page(title);
        LOGGER.info("Step: Verify the "+tab+"  navigation flow");
    }

    @When("^I click \"([^\"]*)\" link under train ticket modal view$")
    public void I_click_link_under_train_ticket_modal_view(String arg) {
        if (arg.equals("Can I Book")){railDestination = railHomePage.step_Click_On_The_Advance_Book_Link();}
        else{railHomePage.step_Click_On_The_Age_Rule_Link();}
        LOGGER.info("Step: Click on the advance booking or age rule link");
    }

    @Then("^I should see \"([^\"]*)\" overlay with country specific age rules$")
    public void I_should_see_overlay_with_country_specific_age_rules(String arg){
        railHomePage.check_And_Validate_Age_Rule_Overlay_Header(arg);
    }

    @And("^I close \"([^\"]*)\" modal dialog$")
    public void I_close_modal_dialog(String arg){
        railHomePage.step_Close_Age_Rule_overlay();
    }
}
