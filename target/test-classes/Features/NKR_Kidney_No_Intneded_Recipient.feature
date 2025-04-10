Feature: Testing NKR_Kidney_No_Intneded_Recipient Registration

  Scenario: Testing NKR_Kidney_No_Intneded_Recipient Registration
   Given User goes to NKR_Kidney_No_Intneded_Recipient url "https://nkr.donorscreen.fail/register/now"
   And User Enter Required Information for NKR_Kidney_No_Intneded_Recipient registration
   When user goes to NKR_Kidney_No_Intneded_Recipient smtp server
   Then User take the NKR_Kidney_No_Intneded_Recipient questionaire from the email