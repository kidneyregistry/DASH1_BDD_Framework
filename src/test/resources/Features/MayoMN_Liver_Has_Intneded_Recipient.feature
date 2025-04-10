Feature: Testing MayoMN_Liver_Has_Intneded_Recipiente Registration

  Scenario: Testing MayoMN_Liver_Has_Intneded_Recipiente Registration
   Given User goes to MayoMN_Liver_Has_Intneded_Recipiente url "https://mayomn.donorscreen.fail/register/now"
   And User Enter Required Information for MayoMN_Liver_Has_Intneded_Recipiente registration
   When user goes to MayoMN_Liver_Has_Intneded_Recipiente smtp server
   Then User take the MayoMN_Liver_Has_Intneded_Recipiente questionaire from the email