Feature: Testing MayoMN_Liver_No_Intneded_Recipient Registration

  Scenario: Testing MayoMN_Liver_No_Intneded_Recipient Registration
   Given User goes to MayoMN_Liver_No_Intneded_Recipient url "https://mayomn.donorscreen.fail/register/now"
   And User Enter Required Information for MayoMN_Liver_No_Intneded_Recipient registration
   When user goes to MayoMN_Liver_No_Intneded_Recipiente smtp server
   Then User take the MayoMN_Liver_No_Intneded_Recipient questionaire from the email