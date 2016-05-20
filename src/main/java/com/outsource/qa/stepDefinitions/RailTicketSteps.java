package com.outsource.qa.stepDefinitions;

import com.outsource.qa.pages.*;
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
    RailSearchResultPage railSearchResultPage;
    RailSignInPage railSignInPage;
    RailPassengerDetailsPage railPassengerPage;
    RailConfirmItineraryPage railConfirmationPage;
    RailDeliveryInfoPage railDeliveryPage;

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
        if (arg.equals("Can I Book")){railDestinationPage = railHomePage.step_Click_On_The_Advance_Book_Link();}
        else if(arg.equals("Rail Pass")){railHomePage.step_Click_RailPass_Link();}
        else{railHomePage.step_Click_On_The_Age_Rule_Link();}
        LOGGER.info("Step: Click on the advance booking or age rule link");
    }

    @Then("^I should see \"([^\"]*)\" overlay with country specific age rules$")
    public void I_should_see_overlay_with_country_specific_age_rules(String arg){
        if(arg.equals("Age Rules")){railHomePage.check_And_Validate_Age_Rule_Overlay_Header(arg);}
        else{railHomePage.check_And_Validate_RailPass_Overlay(arg);}

        LOGGER.info("Step: Appear country specific age rules overlay");
    }

    @And("^I close \"([^\"]*)\" modal dialog$")
    public void I_close_modal_dialog(String arg){
        if(arg.equals("Age Rule")){railHomePage.step_Close_Age_Rule_overlay();}
        else{railHomePage.step_Close_RailPass_Overlay();}
    }

    @And("^I should see page header title as \"([^\"]*)\" for search$")
    public void I_should_see_page_header_title_as_for_search(String arg) throws Throwable {
        railHomePage.check_And_Validate_Eurostar_Home_Page(arg);
        LOGGER.info("Step: I should see page header title as " + arg);
    }

    @Then("^I should navigate to the \"([^\"]*)\" site and verify the header title as \"([^\"]*)\" for search$")
    public void I_should_navigate_to_the_site_and_verify_the_header_title_as_for_search(String title, String tab) throws Throwable {
        railDestinationPage.check_And_Validate_Eurostart_Destination_Page(title);
        LOGGER.info("Step: Verify the " + tab + "  navigation flow");
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

    @When("^I click on the select the ([^\"]*) search option$")
    public void I_click_on_the_select_the_type_search_option(String type) throws Throwable {
        if(type.equals("return")){
            railHomePage.click_Return_Search_Option("ON");
        }if(type.equals("oneway")){
            railHomePage.click_OneWay_Search_Option("ON");
        }
    }

    @And("^i set ([^\"]*) as departure station and ([^\"]*) as arrival station$")
    public void i_set_departure_as_departure_station_and_arrival_as_arrival_station(String dep, String arr) throws Throwable {
        railHomePage.step_Set_Arrival_Station(arr);
        railHomePage.step_Set_Departure_Station(dep);
    }

    @And("^I press the \"([^\"]*)\" for train button$")
    public void I_press_the_for_train_button(String arg) throws Throwable {
        railSearchResultPage = railHomePage.step_Perform_Search_Train();

    }

    @Then("^I can see train availability details page with title as ([^\"]*) to ([^\"]*)$")
    public void I_can_see_train_availability_details_page_with_title_as_departure_to_arrival(String dep, String arr) throws Throwable {
        railSearchResultPage.check_And_Validate_Location_Result_Title(dep, arr);
    }

    @And("^I select \"([^\"]*)\" class traveling plan and verify the condition overlay$")
    public void I_select_class_traveling_plan_and_verify_the_condition_overlay(String arg1) throws Throwable {
        railSearchResultPage.step_Select_First_Class_Travel_Option("2");
        railSearchResultPage.check_And_Validate_Condition_Overlay();
    }

    @And("^I select \"([^\"]*)\" class traveling plan and verify the journey details overlay$")
    public void I_select_class_traveling_plan_and_verify_the_journey_details_overlay(String arg) throws Throwable {
        railSearchResultPage.step_Click_Journey_Details_Link();
        railSearchResultPage.check_And_Verify_Journey_Details_Title();
    }

    @And("^I verify the ([^\"]*) sort functionality$")
    public void I_verify_the_earlier_sort_functionality(String sort) throws Throwable {
        if(sort.equals("earlier")){
            railSearchResultPage.check_And_Validate_Earlier_Sort_Functionality();
        }if(sort.equals("later")){
            railSearchResultPage.check_And_Validate_Later_Sort_Functionality();
        }
    }

    @And("^I click on the modify search button$")
    public void I_click_on_the_modify_search_button() throws Throwable {
        railSearchResultPage.step_Click_Modify_Search_Button();
    }

    @And("^And i set ([^\"]*) as departure station and ([^\"]*) as arrival station in modify search$")
    public void And_i_set_modi_departure_as_departure_station_and_modi_arrival_as_arrival_station_in_modify_search(String dep,String arr) throws Throwable {
        railSearchResultPage.step_Set_Departure_Station_Details(dep);
        railSearchResultPage.step_Set_Arrival_Station_Details(arr);
    }

    @And("^I press the \"([^\"]*)\" for train button in modify search$")
    public void I_press_the_for_train_button_in_modify_search(String arg1) throws Throwable {
        railSearchResultPage.step_Click_Search_For_Train_Button();
    }

    @And("^I can see error message like ([^\"]*)$")
    public void I_can_see_error_message_like_error(String msg) throws Throwable {
        railSearchResultPage.check_And_Validate_Search_Not_Found_Error_Message(msg);
    }

    @Given("^I am successfully login railplus site$")
    public void I_am_successfully_login_railplus_site() throws Throwable {
        railHomePage = new RailplusHomePage(Hooks.driver);
        LOGGER.info("Step: I am on the railplus home page");
        railSignInPage = ((RailSignInPage) railHomePage.step_Click_Given_Special_Main_Menu_Link("Signin"));
        railSignInPage.step_Set_User_SignIn_Username("nivanthakarajapakse2016@gmail.com");
        railSignInPage.step_Set_User_SignIn_Password("Test!234");
        railSignInPage.step_Press_SignIn_Button();
        LOGGER.info("Step: I login successfully");
    }

    @And("^I perform shopping cart function$")
    public void I_perform_shopping_cart_function() throws Throwable {
        railPassengerPage = railSearchResultPage.step_Perform_Shopping_Cart_Button();
        LOGGER.info("Step: I Perform shopping cart button");
    }

    @And("^I set passenger details title as ([^\"]*), name as ([^\"]*) and age as ([^\"]*)$")
    public void I_set_passenger_details_title_as_title_name_as_fname_lname_and_age_as_age(String title,String fullName,String age) throws Throwable {
        String[] name = fullName.split(" ");
        railPassengerPage.step_Set_MrTitle(title);
        railPassengerPage.step_Set_Passenger_FName(name[0]);
        railPassengerPage.step_Set_Passenger_LName(name[1]);
        railPassengerPage.step_Set_Passenger_Age(age);
    }

    @And("^I am on the passenger details page$")
    public void I_am_on_the_passenger_details_page() throws Throwable {
        railPassengerPage.check_And_Validate_Passenger_Title("Enter Passenger Details");
    }

    @And("^I continue passenger details flow by checking apply conditions$")
    public void I_continue_passenger_detals_flow_by_checking_apply_conditions() throws Throwable {
        railPassengerPage.step_Check_Accept_Condition();
        railConfirmationPage = railPassengerPage.step_Continue_Passenger_Details_Flow();
    }

    @And("^I verify the alert message \"([^\"]*)\" and accept it$")
    public void I_verify_the_alert_message_and_accept_it(String arg) throws Throwable {
        railPassengerPage.check_And_Validate_Waning_Alert_Msg_And_Accept(arg);
    }

    @And("^I continue passenger details flow without apply conditions$")
    public void I_continue_passenger_details_flow_without_apply_conditions() throws Throwable {
        railPassengerPage.step_Continue_Passenger_Details_Flow();
    }

    @And("^I am on the confirm itinerary page$")
    public void I_am_on_the_confirm_itinerary_page() throws Throwable {
        railConfirmationPage.check_And_Validate_Confirmation_Page("Shopping basket summary");
    }

    @And("^I can see shopping basket items as \"([^\"]*)\"$")
    public void I_can_see_shopping_basket_items_as(String arg) throws Throwable {
        railConfirmationPage.check_And_Validate_Shopping_bag(arg);
    }

    @And("^I clear default allocated country$")
    public void I_clear_default_allocated_country() throws Throwable {
        railPassengerPage.step_Clear_Existing_Country_Record();
    }

    @And("^I can see inline validation error message as  \"([^\"]*)\"$")
    public void I_can_see_inline_validation_error_message_as(String arg) throws Throwable {
        railPassengerPage.check_And_Validate_Validation_Error_Msg(arg);
    }

    @And("^I continue shopping again by clicking continue button$")
    public void I_continue_shopping_again_by_clicking_continue_button() throws Throwable {
        railHomePage = railConfirmationPage.step_Back_To_Continue_Shopping();
    }

    @Then("^I should see \"([^\"]*)\" reservation option as the un-selected option and \"([^\"]*)\" option will set as \"([^\"]*)\" Fares$")
    public void I_should_see_reservation_option_as_the_un_selected_option_and_option_will_set_as_Fares(String arg1, String arg2, String arg3) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I check \"([^\"]*)\" reservation option$")
    public void I_check_reservation_option(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I verify the current availability of the seat reservation$")
    public void I_verify_the_current_availability_of_the_seat_reservation() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I should see page header title as \"([^\"]*)\".$")
    public void I_should_see_page_header_title_as_(String arg) throws Throwable {
        if(arg.equals("Payment and delivery details")){
            railDeliveryPage.check_And_Validate_Payment_DeliveryInfo_Page(arg);
        }else if(arg.equals("Agent Area")){
            railSignInPage.check_And_Validate_PageHeader(arg);
        }else {
            railHomePage.check_And_Validate_Eurostar_Home_Page(arg);
        }
        LOGGER.info("Step: I should see page header title as "+arg);
    }

    @And("^I can see train search in-progress state$")
    public void I_can_see_train_search_in_progress_state() throws Throwable {
        LOGGER.info("Step: I wait until item search");
    }

    @And("^I remove existing shopping cart item and accept confirmation$")
    public void I_remove_existing_shopping_cart_item_and_accept_confirmation() throws Throwable {
        railConfirmationPage.step_Remove_ShoppingCart_Item();
        railConfirmationPage.step_Remove_CartItem_Acceptance_Overlay();
        LOGGER.info("Step: I remove existing shopping cart item");
    }

    @And("^I perform checkout upto delivery page$")
    public void I_perform_checkout_upto_delivery_page() throws Throwable {
        railDeliveryPage = railConfirmationPage.step_Initial_Checkout().step_Final_Checkout();
    }

    @And("^I click on the \"([^\"]*)\" link.$")
    public void I_click_on_the_link(String arg1) throws Throwable {
        railSignInPage = railDeliveryPage.step_Click_On_The_LoingNow_Link();
    }

    @Then("^I set traveling fares as ([^\"]*)$")
    public void I_set_traveling_fares_as_cost(String cost) throws Throwable {
        railHomePage.step_Choose_Travel_Fares(cost);
    }

    @And("^I set scheduled time as \"([^\"]*)\"$")
    public void I_set_scheduled_time_as(String arg) throws Throwable {
        railHomePage.step_Set_Return_Scheduled_Date(arg);
    }
}
