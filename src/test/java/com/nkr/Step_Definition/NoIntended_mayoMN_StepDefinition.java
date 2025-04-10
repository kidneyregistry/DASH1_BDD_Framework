package com.nkr.Step_Definition;

import java.io.IOException;

import com.nkr.DriverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.nkr.pages.*;
public class NoIntended_mayoMN_StepDefinition {

	
	private mayoMN_NoIntend NoIntend = new com.nkr.pages.mayoMN_NoIntend(DriverFactory.getDriver());

	
	
		@Given("User goes to MayoMN_Liver_No_Intneded_Recipient url {string}")
		public void user_goes_to_mayo_mn_liver_no_intneded_recipient_url(String URL) {
			DriverFactory.getDriver().get(URL);
		}

		@Given("User Enter Required Information for MayoMN_Liver_No_Intneded_Recipient registration")
		public void user_enter_required_information_for_mayo_mn_liver_no_intneded_recipient_registration() throws InterruptedException, IOException {
			NoIntend.RegistrationFormInfo();
		}
		@When("user goes to MayoMN_Liver_No_Intneded_Recipiente smtp server")
		public void user_goes_to_mayo_mn_liver_no_intneded_recipiente_smtp_server() throws InterruptedException, IOException {
			NoIntend.VerifySMTPEmail();
		}
		@Then("User take the MayoMN_Liver_No_Intneded_Recipient questionaire from the email")
		public void user_take_the_mayo_mn_liver_no_intneded_recipient_questionaire_from_the_email() throws InterruptedException, IOException {
			NoIntend.QuestionaireInfo();
		}



}
