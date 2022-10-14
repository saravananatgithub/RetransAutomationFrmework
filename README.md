# RetransAutomationFrmework

http://10.60.87.254:8080/buildStatus/icon?job=FreshKiteDemoPipeline

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
   5) Update the properties file src\main\resources\env.properties for chromedriver Path and hopst IP as shown below
                hostip=35.92.40.186
		browser=chrome
		context=ReTrans
		driver-path=C:/sarva/selenium/chromedriver.exe
		username=Test_User
		password=Test@123
		      
		      
  Steps to run the Seleniun Tests
  
    From the command line execute the below steps
    1)  git clone https://github.com/saravananatgithub/RetransAutomationFrmework.git
    2) cd RetransAutomationFrmework
    3) mvn test
