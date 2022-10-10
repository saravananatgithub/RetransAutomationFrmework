# RetransAutomationFrmework

What is there in the Repo?

 Automated test cases 
     1) Logs in
     2) Filters Literature Items by Business Unit, Classification, Activity.
     3) View Literature Items 
     4) Edit and Claim a Literatuire Item , adds Notes and Actions.

How to run these Testcases?
   1) Need to have Java 8 or above in your PC
   2) Install git software
   3) Download and install Maven 
   4) Downlaod chromedriver.exe file (It is also there is this repo as zip file this driver works with latest version of chrome browser)
   5) Update the framework\src\main\java\com\retrans\test\TestBase.java for chromedriver Path and hopst IP as shown below
                public static String hostIP = "35.161.37.156";
	              public static String chromeDriverPath = "C:/sarva/selenium/chromedriver.exe";
		      
		      
  Steps to run the Seleniun Tests
  
    From the command line execute the below steps
    1)  git clone https://github.com/saravananatgithub/RetransAutomationFrmework.git
    2) cd RetransAutomationFrmework
    3) mvn test
