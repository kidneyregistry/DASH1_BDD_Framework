package com.nkr.Step_Definition;

import java.io.IOException;

import com.nkr.DriverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.nkr.pages.*;
public class Penn_Kidney_No_Intended_Recipient_Steps {

	private Penn_Kidney_No_Intended_Recipient noIntend = new Penn_Kidney_No_Intended_Recipient(DriverFactory.getDriver());

	@Given("User goes to Penn_Kidney_No_Intneded_Recipient  url {string}")
	public void user_goes_to_penn_kidney_no_intneded_recipient_url(String URL) {
	    DriverFactory.getDriver().get(URL);
	}

	@Given("User Enter Required Information for Penn_Kidney_No_Intneded_Recipient  registration")
	public void user_enter_required_information_for_penn_kidney_no_intneded_recipient_registration() throws InterruptedException, IOException {
	    noIntend.RegistrationFormInfo();
	}

	@When("user goes to Penn_Kidney_No_Intneded_Recipient  smtp server")
	public void user_goes_to_penn_kidney_no_intneded_recipient_smtp_server() throws InterruptedException, IOException {
	    noIntend.VerifySMTPEmail();
	}

	@Then("User take the Penn_Kidney_No_Intneded_Recipient  questionaire from the email")
	public void user_take_the_penn_kidney_no_intneded_recipient_questionaire_from_the_email() throws InterruptedException, IOException {
	    noIntend.QuestionaireInfo();
	}
}





