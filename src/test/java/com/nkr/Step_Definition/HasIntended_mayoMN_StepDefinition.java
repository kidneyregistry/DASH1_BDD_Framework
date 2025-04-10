package com.nkr.Step_Definition;

import java.io.IOException;

import com.nkr.DriverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.nkr.pages.*;
public class HasIntended_mayoMN_StepDefinition {

	
	private mayoMN_Intend HasIntend = new com.nkr.pages.mayoMN_Intend(DriverFactory.getDriver());

	
	
	@Given("User goes to MayoMN_Liver_Has_Intneded_Recipiente url {string}")
	public void user_goes_to_mayo_mn_liver_has_intneded_recipiente_url(String URL) {
			DriverFactory.getDriver().get(URL);
		}

	@Given("User Enter Required Information for MayoMN_Liver_Has_Intneded_Recipiente registration")
	public void user_enter_required_information_for_mayo_mn_liver_has_intneded_recipiente_registration()  throws InterruptedException, IOException {
			HasIntend.RegistrationFormInfo();
		}
	@When("user goes to MayoMN_Liver_Has_Intneded_Recipiente smtp server")
	public void user_goes_to_mayo_mn_liver_has_intneded_recipiente_smtp_server() throws InterruptedException, IOException {
			HasIntend.VerifySMTPEmail();
		}
	@Then("User take the MayoMN_Liver_Has_Intneded_Recipiente questionaire from the email")
	public void user_take_the_mayo_mn_liver_has_intneded_recipiente_questionaire_from_the_email()throws InterruptedException, IOException {
			HasIntend.QuestionaireInfo();
		}



}
