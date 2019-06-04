# Caspar Health Automation Task

My configuration details : MacOS, Chrome web driver, Eclipse with java, selenium and junit

I have used chrome browser. Generally we test on all the browsers (Web and Mobile) that more than an accepted number of users are using along with various combinations of Operating Systems. Major chunk of tests are executed on headless browser for faster execution of test suites. All these things are configurable and would need one time set up.

Setup:
1. Download eclipse from https://www.eclipse.org/downloads/  
2. Download Chrome driver compatible with your OS from http://chromedriver.chromium.org/downloads
3. Download junit jar files from https://github.com/junit-team/junit4/wiki/Download-and-Install
4. Download selenium jar files from https://www.seleniumhq.org/download/ (java)

I have downloaded all the required files for running the automation on MacOS and saved it in lib folder inside CasperHealth/CasparHealthAutomation/. If you are using any other configuration, please download required jar files and chromedriver compatible with your configuration and place it in lib folder.

CasperHealth folder contains CasparHealthAutomation which is an eclipse project. To set up open eclipse import CasparHealthAutomation project. In project > properties > Java Build Path > Libraries > Add external jars select all the 8 selenium and junit jar files from lib folder inside CasparHealthAutomation. Also in In project > properties > Java Build Path > Libraries > Add Library select the junit library
In CasparHealthAutomation there is a config.properties file, please update path to chromedriver executable

Right click on Project and select "Run as" > "JUnit Test" 

Screencast of execution with eclipse: https://youtu.be/gPIKZCm1kuM
