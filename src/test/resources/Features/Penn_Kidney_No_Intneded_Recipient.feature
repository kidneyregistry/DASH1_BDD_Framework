Feature: Testing Penn_Kidney_No_Intneded_Recipient Registration

  Scenario: Testing Penn_Kidney_No_Intneded_Recipient  Registration
   Given User goes to Penn_Kidney_No_Intneded_Recipient  url "http://penntransplant.donorscreen.fail/register/now"
   And User Enter Required Information for Penn_Kidney_No_Intneded_Recipient  registration
   When user goes to Penn_Kidney_No_Intneded_Recipient  smtp server
   Then User take the Penn_Kidney_No_Intneded_Recipient  questionaire from the email