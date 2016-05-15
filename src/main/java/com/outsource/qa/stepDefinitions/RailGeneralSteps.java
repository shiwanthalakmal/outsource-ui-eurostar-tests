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
 * Created by user on 4/23/2016.
 */
public class RailGeneralSteps extends SuperStep{
    private static final Logger LOGGER = LoggerFactory.getLogger(RailGeneralSteps.class);

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
        railHomePage.check_And_Validate_Staying_Home_page();
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

    @Then("^I should navigate to the \"([^\"]*)\" site and verify the header title as \"([^\"]*)\"$")
    public void I_should_navigate_to_the_site_and_verify_the_header_title_as(String tab, String title){
        railDestinationPage.check_And_Validate_Eurostart_Destination_Page(title);
        LOGGER.info("Step: Verify the "+tab+"  navigation flow");
    }

    @When("^Click on the \"([^\"]*)\" top navigation link$")
    public void Click_on_the_top_navigation_link(String arg) throws Throwable {
        if(arg.equals("manage booking")) {
            railManageBookPage = ((RailManageBookPage) railHomePage.step_Click_Given_Special_Main_Menu_Link("Manage"));
        }else if(arg.equals("my signin")){
            railSignInPage = ((RailSignInPage) railHomePage.step_Click_Given_Special_Main_Menu_Link("Signin"));
        }
        LOGGER.info("Step: Click on the "+arg+" link");
    }

    @Then("^I am on the manage booking page and verify the header title as \"([^\"]*)\"$")
    public void I_am_on_the_manage_booking_page_and_verify_the_header_title_as(String arg){
        if (arg.equals("Agent Area")){
            railSignInPage.check_And_Validate_PageHeader(arg);
        }else if (arg.equals("Manage booking")) {
            railManageBookPage.check_And_Validate_PageHeader(arg);
        }
        LOGGER.info("Step: I am on the manage booking page");
    }

    @When("^I mouse hover top of the \"([^\"]*)\" link and press login with out details$")
    public void I_mouse_hover_top_of_the_link_and_press_login_with_out_details(String arg) throws Throwable {
        if(arg.equals("manage booking")){
            railManageBookPage = ((RailManageBookPage) railHomePage.step_Manage_Booking_link_Mouse_Over_And_Login_Without_Details());
        }else if(arg.equals("my signin")){
            railSignInPage = ((RailSignInPage) railHomePage.step_My_Sign_In_Link_Mouse_Over_And_Login_Without_Details());
        }

        LOGGER.info("Step: Appear country specific age rules overlay");
    }

    @And("^I set sign in user \"([^\"]*)\" text feild$")
    public void  I_set_sign_in_user_text_feild(String arg) throws Throwable {
        if(arg.equals("username")){
            railSignInPage.step_Set_User_SignIn_Username(arg);
        }
        else if(arg.equals("password")){
            railSignInPage.step_Set_User_SignIn_Password(arg);
        }
    }

    @Then("^I press the sign in login button$")
    public void I_press_the_sign_in_login_button() throws Throwable {
        railSignInPage.step_Press_SignIn_Button();
    }

    @And("^Ican see login error message as \"([^\"]*)\"$")
    public void Ican_see_login_error_message_as(String arg) throws Throwable {
        railSignInPage.check_And_Validate_LoginError_Message(arg);
    }

    @And("^I click on the \"([^\"]*)\" link$")
    public void I_click_on_the_link(String arg) throws Throwable {
        if(arg.equals("forgot password")) {
            railSignInPage.step_Click_Forgot_Password_Link();
        }if(arg.equals("new argent")){
            railRegistration = railSignInPage.step_Click_New_Argent_Registration();
        }
    }

    @And("^I navigate to the \"([^\"]*)\" page$")
    public void I_navigate_to_the_page(String arg) throws Throwable {
        if(arg.equals("Forgot Your Password?")) {
            railSignInPage.check_And_Validate_ForgotPass_Title(arg);
        }if(arg.equals("New Travel Agent?")){
            railRegistration.check_And_Validate_Registration_Title(arg);
        }
    }

    @And("^I provide recovery mail as \"([^\"]*)\"$")
    public void I_provide_recovery_mail_as(String arg) throws Throwable {
        railSignInPage.step_Set_Forgot_Password_Recovery_Mail(arg);
    }

    @Then("^I press the recovery submit button$")
    public void I_press_the_recovery_submit_button() throws Throwable {
        railSignInPage.step_Press_Forgot_Recovery_Sent();
    }

    @And("^I can see recovery error msg as \"([^\"]*)\"$")
    public void I_can_see_recovery_error_msg_as(String arg) throws Throwable {
        railSignInPage.check_And_Validate_ForgotPass_Error_Message(arg);
    }

    @And("^I press the registration submit button$")
    public void I_press_the_registration_submit_button() throws Throwable {
        railRegistration.step_Press_Registration_Submission_With_Errors();
    }

    @And("^I  can see compulsory fields validation error message as \"([^\"]*)\"$")
    public void I_can_see_compulsory_fields_validation_error_message_as(String arg) throws Throwable {
        railRegistration.check_And_Validate_RegistrationErrorMsg(arg);
    }

    @And("^I can see \"([^\"]*)\" and \"([^\"]*)\" text boxes and \"([^\"]*)\" button$")
    public void I_can_see_and_text_boxes_and_button(String arg1, String arg2, String arg3) throws Throwable {
        railSignInPage.check_And_Validate_Login_UI_Availability();
    }

    @And("^I can see \"([^\"]*)\" and 'new argent\" links$")
    public void I_can_see_and_new_argent_links(String arg1) throws Throwable {
        railSignInPage.check_And_Validate_Login_Link_Availability();
    }

    @And("^I can see user \"([^\"]*)\" in home page$")
    public void I_can_see_user_in_home_page(String arg) throws Throwable {
        railHomePage.check_And_Validate_Logged_Agency_Code(arg);
    }

    @And("^I set sign in user \"([^\"]*)\" text feild as \"([^\"]*)\"$")
    public void I_set_sign_in_user_text_feild_as(String arg, String info) throws Throwable {
        if(arg.equals("username")){
            railSignInPage.step_Set_User_SignIn_Username(info);
        }
        else if(arg.equals("password")){
            railSignInPage.step_Set_User_SignIn_Password(info);
        }
    }

    @Then("^I click the \"([^\"]*)\" link$")
    public void I_click_the_link(String arg1) throws Throwable {
        railHomePage.step_Site_Logout();
    }

    @When("^I click on the home page \"([^\"]*)\" link$")
    public void I_click_on_the_home_page_link(String arg) throws Throwable {

    }

    @Then("^I should navigate to the particular site as a new window and verify the url as ([^\"]*)$")
    public void I_should_navigate_to_the_particular_site_as_a_new_window_and_verify_the_url_as(String arg) throws Throwable {
        if(arg.equals("Facebook")){
            railHomePage.check_And_Validate_Facebook_Panel(arg);
        }else{
            railHomePage.check_And_Validate_Twitter_Panel(arg);
        }
    }

    @When("^I click on the home page link ([^\"]*) icon$")
    public void I_click_on_the_home_page_link_link_icon(String arg) throws Throwable {
        if(arg.equals("facebook")){
            railHomePage.step_Click_Facebook_Icon();
        }if(arg.equals("twitter")){
            railHomePage.step_Click_Twitter_Icon();
        }
    }

    @And("^I can not see user \"([^\"]*)\" in home page$")
    public void I_can_not_see_user_in_home_page(String arg) throws Throwable {
        railHomePage.check_And_Validate_Logged_Agency_Code_Not_Available(arg);
    }
}
