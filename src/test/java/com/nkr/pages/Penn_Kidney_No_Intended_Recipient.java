 package com.nkr.pages;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.Set;
public class Penn_Kidney_No_Intended_Recipient {

	private WebDriver driver;
	// 1. By Locators: OR
				
				
				// 2. Constructor of the page class:
				public Penn_Kidney_No_Intended_Recipient(WebDriver driver) {
					this.driver = driver;
				}

				// 3. page actions: features(behavior) of the page the form of methods:

				
				public String getLoginPageTitle() {
					return driver.getTitle();
				}
				public void RegistrationFormInfo() throws InterruptedException, IOException {
					// void 1
					driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Mohammed");
					driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Test");
					driver.findElement(By.xpath("//input[@id='PreferredName']")).sendKeys("Test");
					//driver.findElement(By.name("Email")).sendKeys("ert@kidneyregistry.org");
					
					WebElement emailText = driver.findElement(By.name("Email"));//pass random value in input text field, Selenium-Java
					Random random = new Random();
					int randomInt = random.nextInt(500);
					emailText.sendKeys("xyz" + randomInt + "@kidneyregistry.fail");
					
					WebElement ddown = driver.findElement(By.name("PreferredLanguage"));
					Select select = new Select(ddown);
					select.selectByIndex(1);
					Thread.sleep(500);
					
					WebElement ddown1 = driver.findElement(By.name("DonationType"));//Kidney
					Select select1 = new Select(ddown1);
					select1.selectByIndex(1);
					Thread.sleep(500);
					
					driver.findElement(By.xpath("//input[@id = 'AgreedToHipaa']")).click();//HIPAA
					Thread.sleep(500);
					driver.findElement(By.xpath("//button[@type = 'submit']")).click();  //CONTINUE
					Thread.sleep(500);
					driver.findElement(By.xpath("//button[@class = 'btn btn-success']")).click();//Yes, that is correct and, go to smtp4dev
				}
				
				public void VerifySMTPEmail() throws InterruptedException, IOException {
					driver.get("http://173.251.53.123:5000/");
					Thread.sleep(500);
					driver.findElement(By.xpath("//div[normalize-space()='registrations@donorscreen.org']")).click();
					Thread.sleep(500);
					
					driver.switchTo().frame(0);
					driver.findElement(By.xpath("//td[@style='font-family: Arial; font-size: 16px; padding: 18px;']")).click(); //Start Questionnaire
					Thread.sleep(500);
					//driver.switchTo().parentFrame();
					Set <String> handles  = driver.getWindowHandles();
					for (String handle : handles) {
						driver.switchTo().window(handle);
					}
					//driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
					
					//driver.switchTo().newWindow(WindowType.TAB);
					Thread.sleep(5000);
				
					String url = driver.getCurrentUrl();
					//TargetLocator url1 = driver.switchTo();
					System.out.println(url);//Printing the URL with ID that was created
					driver.get(url);
				}
				public void QuestionaireInfo() throws InterruptedException, IOException {
					driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();//Continue
					Thread.sleep(1000);
					//Test Case_3: Screening Summary
					driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("2156534567");
					driver.findElement(By.xpath("//input[@id='PostalCode']")).sendKeys("15006");
					
					WebElement radio1 = driver.findElement(By.xpath("//label[normalize-space()='Male']//input[@id='Gender']"));
					radio1.click();
					driver.findElement(By.xpath("//input[@name = 'BirthDate']")).sendKeys("04/22/1987");
					WebElement ddown01 = driver.findElement(By.xpath("//select[@name = 'HeightFeet']"));
					Select select11 = new Select(ddown01);
					select11.selectByIndex(3);
					WebElement dropdown = driver.findElement(By.xpath("//select[@name = 'HeightInches']"));
					Select select2 = new Select(dropdown);
					select2.selectByIndex(8);
					driver.findElement(By.xpath("//input[@id = 'WeightLbs']")).sendKeys("168");
					
					WebElement ele= driver.findElement(By.xpath("//input[@id='IsResidingInUSA' and @value='True']"));//currently in USA
					ele.click();
					
					WebElement ele1 = driver.findElement(By.xpath("//input[@id='IsCurrentlyIncarcerated' and @value='False']")); //currenly in prison
					ele1.click();
					
					WebElement ele29 = driver.findElement(By.xpath("//label[normalize-space()='Not at this time']")); //Would you like...
					ele29.click();
					
					driver.findElement(By.xpath("//button[@class ='btn btn-primary btn-lg']")).click();  //Continue
					Thread.sleep(1000);
					WebElement ele2 = driver.findElement(By.xpath("//label[contains(text(),'Yes, I am willing to accept transfusions in an eme')]")); //transfusionsIn EMER.
					ele2.click();
					
					driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click(); // //Yes, that's correct, continue
					Thread.sleep(1000);
					
					WebElement ele3 = driver.findElement(By.xpath("//label[normalize-space()='No']")); 	//Diagnosed with Kidney disease
					ele3.click();
					
					//WebElement ele32 = driver.findElement(By.xpath("//label[normalize-space()='No']")); 	//Kidney disease
					//ele32.click();
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();	//continue
					
					Thread.sleep(1000);
					WebElement ele4 = driver.findElement(By.xpath("//label[normalize-space()='No']")); 	//heart attack
					ele4.click();
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click(); //continue
					Thread.sleep(1000);
					
					WebElement ele5 = driver.findElement(By.xpath("//input[@id='HasDiabetes' and @value='False']")); 	//diabetes
					ele5.click();
					driver.findElement(By.xpath("//button[@class = 'btn btn-primary btn-lg']")).click(); //continue
					Thread.sleep(1000);
					WebElement ele6 = driver.findElement(By.xpath("//label[normalize-space()='No']"));  //cancer/skin cancer
					ele6.click();
					
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click(); //continue
					Thread.sleep(1000);
					
					WebElement ele28 = driver.findElement(By.xpath("//label[normalize-space()='No']"));//Kidney Stone
					ele28.click();
					
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click(); //continue
					Thread.sleep(1000);
					//Female Extra Questionnaire
					/*WebElement rbn = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasBeenPregnant']"));//ever been preg
					 rbn.click();
					WebElement rbn0 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='IsPlanningOnPregnancy']"));//plan becoming?
					rbn0.click();
					WebElement rbn1 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='IsTakingBirthControl']"));//taking birth control?
					rbn1.click();
					driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();//continue*/
					
					WebElement rad1 = driver.findElement(By.xpath("//input[@id='HasUsedTobacco' and @value='False']"));	//used Tobaco?
					rad1.click();
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();	//continue
					Thread.sleep(1000);
					
					WebElement rad0 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasHiv']"));//HIV
					rad0.click();
					
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();	//Continue
					Thread.sleep(1000);
					WebElement rad3 = driver.findElement(By.xpath("//input[@name = 'HasIntendedRecipient' and @value = 'False']"));	//Donation Details
					rad3.click();
					
					driver.findElement(By.xpath("//button[@class = 'btn btn-primary btn-lg']")).click();	//Continue
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click(); //Family Video
					
					WebElement ele27 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/form/div/div/div[1]/div/label[3]/input"));//Do you want to Participate- I would like to learn
					ele27.click();
					
					driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();//Continue
					
					driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")).click();	//Done
					Thread.sleep(1000);
					
					//Screening Summary
					//TestCase_4: Start Medical Question:
					driver.findElement(By.xpath("//a[contains(text(),'Start the Medical Questionnaire')]")).click();	//Start the Medical Question or
					Thread.sleep(1000);
					
					//Medical History:
					driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();//continue
					Thread.sleep(1000);
					//Demographics/Personal Details
					WebElement drdown = driver.findElement(By.xpath("//select[@id = 'countryOfResidence']"));//Country
					Select select3 = new Select(drdown);
					select3.selectByVisibleText("United States");
					driver.findElement(By.xpath("//input[@id='addressLine1']")).sendKeys("301 Powel St.");
					driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Bairdford");
					
					WebElement droppdown = driver.findElement(By.xpath("//select[@id='state']"));
					Select select4 = new Select(droppdown);
					select4.selectByVisibleText("Pennsylvania");
					
					driver.findElement(By.xpath("//input[@name = 'PostalCode']")).sendKeys("15006");
					
					WebElement dropppdown = driver.findElement(By.xpath("//select[@id='Ethnicity']"));
					Select select5 = new Select(dropppdown);
					select5.selectByIndex(2);
					driver.findElement(By.xpath("//input[@id='Ssn']")).sendKeys("111111111");
					WebElement droppppdown = driver.findElement(By.xpath("//select[@id='ContactBestStartHour']"));	//best time
					Select select6 = new Select(droppppdown);
					select6.selectByIndex(1);	
					WebElement dropppppdown = driver.findElement(By.xpath("//select[@id='ContactBestEndHour']"));
					Select select7 = new Select(dropppppdown);
					select7.selectByIndex(4);
					driver.findElement(By.xpath("//input[@id='EmergencyContact']")).sendKeys("Amina"); //Emergency Contact Name
					driver.findElement(By.xpath("//input[@id='EmergencyContactPhone']")).sendKeys("3478958613");	//Emergency Contact Number
					WebElement element = driver.findElement(By.xpath("//select[@id='EmergencyContactRelationship']"));	//Relationship
					Select sel = new Select(element);
					sel.selectByIndex(1);
					WebElement element1 = driver.findElement(By.xpath("//select[@id = 'MaritalStatus']"));	//marital Status
					Select sel1= new Select(element1);
					sel1.selectByIndex(1);
					
					WebElement element2 = driver.findElement(By.xpath("//select[@name='EmploymentStatus']"));//Work Status
					Select sel2 = new Select(element2);
					sel2.selectByVisibleText("Unemployed");	//Work Status
					
					WebElement element3 = driver.findElement(By.xpath("//select[@id='ExerciseRoutine']"));	//Exercise
					Select sel3 = new Select(element3);
					sel3.selectByIndex(3);
					
					WebElement element4 = driver.findElement(By.xpath("//select[@id='EducationLevel']"));		//Education
					Select sel4 = new Select(element4);
					sel4.selectByIndex(3);
					
					WebElement raad = driver.findElement(By.xpath("//input[@name = 'HasHealthInsurance' and @value = 'True']"));		//Helth Insurance
					raad.click();
					
					driver.findElement(By.xpath("//input[@id = 'PhysicianName']")).sendKeys("Dr. Emanel");	//Physician's Name
					driver.findElement(By.xpath("//input[@name = 'PhysicianCity']")).sendKeys("Bairdford");		//Physician's City
					driver.findElement(By.xpath("//input[@id='PhysicianStateProvince']")).sendKeys("PA");		//Physician State
					//WebElement element5 = driver.findElement(By.xpath("//select[@id='PhysicianState']"));	//Physicians State
					//Select sel5 = new Select(element5);
					//sel5.selectByVisibleText("MN");	
					
					driver.findElement(By.xpath("//textarea[@id='MotivationToDonate']")).sendKeys("Love to save lives!");	//text
					driver.findElement(By.xpath("//button[@id='submitBtn']")).click();		//Continue
					Thread.sleep(1000);
					//pop-up on address. No,this is correct,//Submited Address
					driver.findElement(By.xpath("//button[@id='useSubmittedBtn']")).click();
					
					//TestCase_6: Medical history What's your blood type
					WebElement ele7 = driver.findElement(By.xpath("//label[normalize-space()='O']//input[@id='AboType']"));	//blood O
					ele7.click();
					WebElement ele8 = driver.findElement(By.xpath("//input[@id = 'HasHistoryOfHighBp' and @value = 'No']"));  //blood preassure
					ele8.click();
					WebElement ele9 = driver.findElement(By.xpath("//input[@id = 'HasHadCabg' and @value = 'No']"));			//bypass grafting
					ele9.click();
					WebElement rad7 = driver.findElement(By.xpath("//input[@id = 'HasHistoryOfBloodClots' and @value = 'No']"));//blood clots
					rad7.click();
					WebElement rad8= driver.findElement(By.xpath("//input[@id = 'HasHistoryOfCoronaryDisease' and @value = 'No']"));//artery disease
					rad8.click();
					WebElement rad9 = driver.findElement(By.xpath("//input[@id = 'HasHistoryOfHighCholOrTg' and @value = 'No']"));//high cholesterol
					rad9.click();
					WebElement radi = driver.findElement(By.xpath("//input[@id = 'HasStents' and @value = 'No']"));	//coronary stents implanted
					radi.click();
					WebElement radi1 = driver.findElement(By.xpath("//input[@id = 'HistoryChestPainExercise' and @ value = 'No']"));  // chest pain
					radi1.click();
					WebElement radi2 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HistoryChestPainOther']"));  // chest pain
					radi2.click();
					WebElement Elemet6 = driver.findElement(By.xpath("//select[@id = 'ResultsOfClimbingStairs']"));	//if you walk 2 flights
					Select sel6 = new Select(Elemet6);
					sel6.selectByIndex(1);
					WebElement radi3 = driver.findElement(By.xpath("//input[@id = 'HadStressTestWithinYear' and @value = 'No']"));	//stress test
					radi3.click();
					WebElement radi4 = driver.findElement(By.xpath("//input[@id = 'HasHadStroke' and @value = 'No']"));	//had a stroke?
					radi4.click();
					WebElement radi5 = driver.findElement(By.xpath("//input[@id = 'HasHadLegBypass' and@value = 'No']"));  //surgery on leg
					radi5.click();
					WebElement radi6 = driver.findElement(By.xpath("//input[@name = 'HistoryLungDisease' and @value = 'No']")); //lung disease
					radi6.click();
					WebElement radi7 = driver.findElement(By.xpath("//input [@id = 'HasCopd' and @value = 'No']"));	//COPD
					radi7.click();
					WebElement radi8 = driver.findElement(By.xpath("//input[@id = 'HasTb' and @value = 'No']"));		//Tuberculosis
					radi8.click();
					WebElement radi9 = driver.findElement(By.xpath("//input[@id = 'HistoryPneumonia' and @value = 'No']")); //Pneumonia
					radi9.click();
					WebElement rbtn = driver.findElement(By.xpath("//input[@name = 'HasRespiratoryIssues' and @Value = 'No']"));	//Respiratory Issues
					rbtn.click();
					WebElement rbtn0 = driver.findElement(By.xpath("//input[@id = 'HasGastroIssues' and @value = 'No']"));	//Gastrointestinal
					rbtn0.click();
					WebElement rbtn1 = driver.findElement(By.xpath("//input[@id = 'HistoryGallstones' and @value = 'No']"));	//Gallbladder
					rbtn1.click();
					WebElement rbtn2 = driver.findElement(By.xpath("//input[@name = 'HistoryPancreatitis' and @value = 'No']"));	//Pancreatitis
					rbtn2.click();
					WebElement rbtn3 = driver.findElement(By.xpath("//input[@id = 'HistoryLiverDisease' and @value = 'No']"));	//History of liverDisease
					rbtn3.click();
					WebElement rbtn4 = driver.findElement(By.xpath("//input[@id = 'HasHepB' and @value = 'No']")); 	//Hepatitis B
					rbtn4.click();
					WebElement rbtn5 = driver.findElement(By.xpath("//input[@name = 'HasHepC' and @value = 'No']"));	//Hepatitis C
					rbtn5.click();
					WebElement rbtn6 = driver.findElement(By.xpath("//input[@name = 'HasBleedingProblem' and @value = 'No']"));	//bleeding problem
					rbtn6.click();
					WebElement rbtn7 = driver.findElement(By.xpath("//input[@id = 'HasHadUti' and @value = 'No']"));	//UTI
					rbtn7.click();
					WebElement rbtn8 = driver.findElement(By.xpath("//input[@name = 'HistoryKidneyDamage' and @value = 'No']"));	//injury to kidney
					rbtn8.click();
					WebElement rbtn9 = driver.findElement(By.xpath("//input[@id = 'HistoryProteinuria'and @value = 'No']"));	//portein in urine
					rbtn9.click();
					WebElement rdbtn = driver.findElement(By.xpath("//input[@name = 'HistoryHematuria' and @value = 'No']"));	//blood in Urine
					rdbtn.click();
					WebElement rdbtn0 = driver.findElement(By.xpath("//input[@name = 'HistoryNeuroDisease' and @value = 'No']"));	//Neorological disease
					rdbtn0.click();
					WebElement rdbtn1 = driver.findElement(By.xpath("//input[@name = 'HistorySeizure' and @value ='No']"));	//seizure
					rdbtn1.click();
					WebElement rdbtn2 = driver.findElement(By.xpath("//input[@id = 'HasLupus' and @value = 'No']"));	//Lupus
					rdbtn2.click();
					WebElement rdbtn3 = driver.findElement(By.xpath("//input[@name = 'HistoryParalysis' and @value = 'No']"));	//paralysis
					rdbtn3.click();
					WebElement rdbtn4 = driver.findElement(By.xpath("//input[@id = 'HasArthritis' and @value = 'No']"));	//arthritis
					rdbtn4.click();
					WebElement rdbtn5 = driver.findElement(By.xpath("//input[@id = 'HistoryNeuropathy' and @value = 'No']"));	//neuropathy
					rdbtn5.click();
					WebElement rdbtn6 = driver.findElement(By.xpath("//input[@id = 'HistoryDepression' and @value = 'No']"));	//depression
					rdbtn6.click();
					WebElement rdbtn7 = driver.findElement(By.xpath("//input[@name = 'HistoryAnxiety' and @value = 'No']"));	//Anxiety
					rdbtn7.click();
					WebElement rdbtn8 = driver.findElement(By.xpath("//input[@id = 'HasHistoryOfPsychiatric' and @value='No']"));	//Psychiatric
					rdbtn8.click();
					//WebElement rdbtn08 = driver.findElement(By.xpath("//input[@id='HasHadMiscarriages' and @value='No']"));	//misscarriage
					//rdbtn08.click();
					WebElement rdbtn9 = driver.findElement(By.xpath("//input[@id='HasReceivedTransfusion' and @value='No']"));//tranfusions
					rdbtn9.click();
					WebElement radbtn = driver.findElement(By.xpath("//input[@id='HasHistoryOfObesity' and @value='No']"));//obesity
					radbtn.click();
					WebElement radbtn0 = driver.findElement(By.xpath("//input[@name='HasFabrys' and @value='No']")); //fabry's diseases
					radbtn0.click();
					WebElement radbtn1 = driver.findElement(By.xpath("//input[@id='HasSickleCell' and @value='No']")); //sickle cell diseases
					radbtn1.click();
					WebElement radbtn2 = driver.findElement(By.xpath("//input[@id='HasSickleCellTrait' and@value='No']")); //sickle cell trait
					radbtn2.click();
					WebElement radbtn3 = driver.findElement(By.xpath("//input[@id='HasSarcoidosis' and @value='No']")); //Sarcoidosis
					radbtn3.click();
					WebElement radbtn4 = driver.findElement(By.xpath("//input[@id='HasAutoImmune' and@value='No']"));//auto-immune disease
					radbtn4.click();
					
					WebElement radbtn5 = driver.findElement(By.xpath("//input[@name='HasHadPhysicalExam' and @value='No']"));//Physical Exam
					radbtn5.click();
					WebElement radbtn6 = driver.findElement(By.xpath("//input[@id='HasHadMammogram' and @value='No']"));//Mommogram
					radbtn6.click();
					WebElement radbtn7 = driver.findElement(By.xpath("//input[@id='HasHadPapSmear' and @value='No']"));//PapSmer
					radbtn7.click();
					WebElement radbtn8 = driver.findElement(By.xpath("//input[@id='HasHadPsaTest' and @value='No']"));//PsaTest
					radbtn8.click();
					WebElement radbtn9 = driver.findElement(By.xpath("//input[@name='HasHadColonoscopy' and @value='No']"));//Colonoscopy
					radbtn9.click();
					
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();	//continue
					Thread.sleep(1000);
					
					//TestCase_8:
					//Next Family History
					WebElement rbtn10 = driver.findElement(By.xpath("//input[@id='FamilyHistoryKidneyDisease' and @value='No']"));
					rbtn10.click();
					WebElement rbtn11 = driver.findElement(By.xpath("//input[@id='FamilyHistoryLiverDisease' and @value='No']"));
					rbtn11.click();
					WebElement rbutn = driver.findElement(By.xpath("//input[@id='FamilyHistoryHeartDisease' and @value='No']"));
					rbutn.click();
					WebElement rbutn0 = driver.findElement(By.xpath("//input[@id='FamilyHistoryCad' and @value='No']"));
					rbutn0.click();
					WebElement rbutn1 = driver.findElement(By.xpath("//input[@id='FamilyHistoryBloodPressure' and @value='No']"));
					rbutn1.click();
					WebElement rbutn2 = driver.findElement(By.xpath("//input[@id='FamilyHistoryBloodDisorder' and @value='No']"));
					rbutn2.click();
					WebElement rbutn3 = driver.findElement(By.xpath("//input[@id='FamilyHistoryCancer' and @value='No']"));
					rbutn3.click();
					WebElement rbutn4 = driver.findElement(By.xpath("//input[@id='FamilyHistoryKidneyCancer' and @value='No']"));
					rbutn4.click();
					WebElement rbutn5 = driver.findElement(By.xpath("//input[@id='FamilyHistoryDiabetes' and @value='No']"));
					rbutn5.click();
					WebElement rbtun14 = driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@id='IsMotherAlive']"));
					rbtun14.click();
					driver.findElement(By.xpath("//input[@id='MothersLastAge']")).sendKeys("80");
					
					WebElement rbutn15 = driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@id='IsFatherAlive']"));
					rbutn15.click();
					driver.findElement(By.xpath("//input[@id='FathersLastAge']")).sendKeys("87");
					driver.findElement(By.xpath("//input[@id='HowManySiblings']")).sendKeys("4");
					driver.findElement(By.xpath("//input[@id='HowManyAdultChildren']")).sendKeys("2");
					driver.findElement(By.xpath("//input[@id='HowManyUnderAgeChildren']")).sendKeys("1");
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();
					Thread.sleep(1000);
					
					//TestCase_9: Allergies,Surgery, and Meds
					WebElement rbutn6 = driver.findElement(By.xpath("//input[@id='HasAllergies' and @value='False']"));
					rbutn6.click();
					WebElement rbutn7 = driver.findElement(By.xpath("//input[@id='HasHadSurgeries' and @value='False']"));
					rbutn7.click();
					WebElement rbutn8 = driver.findElement(By.xpath("//input[@id='TakesMedication' and @value='False']"));
					rbutn8.click();
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();	//Continue
					Thread.sleep(1000);
					
					//Test Case_10: Social History
					WebElement rbutn9 = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/label[2]/input[1]"));//Consumed alcohol
					rbutn9.click();
					WebElement rbutn10 = driver.findElement(By.xpath("//input[@id='HasUsedDrugs' and @value='False']"));//
					rbutn10.click();
					WebElement rbutn11 = driver.findElement(By.xpath("//input[@id='HasHadLegalIssues' and @value='False']"));
					rbutn11.click();
					WebElement rbutn12 = driver.findElement(By.xpath("//input[@id='HasTraveledLastYear' and @value='False']"));
					rbutn12.click();
					
					WebElement rbutn121 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasHadHighRiskSex']"));//Last 30 B,C
					rbutn121.click();
					WebElement rbutn1211 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasHadMmSex']"));//Another Male
					rbutn1211.click();
					WebElement rbutn12111 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasHadSexWithProstitute']"));//30 day, Payment for Se
					rbutn12111.click();
					WebElement rbutn121111 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasProstituted']"));//30 day Money/Drug
					rbutn121111.click();
					WebElement rbutn1211111 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasHadSexWithNeedleDrugUser']"));//30 Day...Prescribed by Dr.
					rbutn1211111.click();
					WebElement rbutn12111111 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasUsedNeedleDrugs']"));//30,,, days by your Doctor
					rbutn12111111.click();
					WebElement rbutn121111111 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasBeenInJailOver72']"));//72 hours
					rbutn121111111.click();
					
					WebElement rbutn13 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasHadStd']"));//30 days genital warts
					rbutn13.click();
					WebElement rbutn131 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasBeenOnHemodialysis']"));//30 days hemodialysis
					rbutn131.click();
					WebElement rbutn1311 = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@id='HasHadSuicidalThoughtsAttempts']"));//Suicidical
					rbutn1311.click();
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();	//continue
					Thread.sleep(1000);
					
					//I'm almost done
					driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();//I'm done with Medical History
					Thread.sleep(5);
					driver.findElement(By.xpath("//a[@class='btn btn-success dash-step-btn']")).click();
					
					/*WebElement footer = driver.findElement(By.xpath("//body/footer[1]"));//by MySchool! tutorial
				    List<WebElement> links = footer.findElements(By.tagName("a"));
				    links.size();
				    int count = links.size();
				    System.out.println("The number of links in the footer section is "+count);*/
				    
				    String title = driver.getTitle();
					System.out.println(title);
					
				
					//Assert.assertEquals(my_title, expected_title);
					
					System.out.println("Penn Kidney, No Intended Recipient Testing is Complete.");
					
					//driver.quit();
				}
}
