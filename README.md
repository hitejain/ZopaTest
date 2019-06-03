# Getting Started
To set up this project on your local machine for development and testing purposes. See deployment notes on how to deploy the project on a live system.

Prerequisites
- IntelliJ Version: 2017.2.6 or higher
- Maven 3.3 or higher
- JDK 1.8 or higher


## Download Github Repository to your PC/MAC

1. Open IntelliJ IDEA and close any existing project.
2. From the Welcome screen, click Import Project. The Select File or Directory to Import dialog will open.
3. Navigate to your Maven project and select the top-level folder. For example, with a project named SeleniumPOMFramework
4. Click Open.
5. The Import Project dialog will opens:
6. In the dialog For the Import project from external model value, select Maven and click Next.
7. Select checkbox Import Maven projects automatically and leave the other fields with default values.
8. Click Next.
9. Your Maven project should be selected for import: e.g. zopa:zopa_test:1.0-SNAPSHOT
10. Click Next.
11. The Please select project SDK screen will opens.
12. Make sure the correct SDK is selected and click Next.
13. Change the project name and location if you like, and click Finish.
14. Project should be imported, In left Panel pom.xml should be shown
15. Select pom.xml (right click ) select Maven and then click Reimport
16. All External Libraries will be downloaded

## Running the tests

- Create a run configuration to test your project:
1. From the Run menu, select Run.
2. Click Edit Configurations….
3. Click + (Add New Configuration) and select Maven
4. Give your configuration a name e.g RunTest.
5. Select Working directory of the project to the folder project is located
6. In the Comand line: field, enter maven command = clean test
7. Click OK or (If Run appears instead of OK click Run and leave below step).
8. Click Run icon to Run Test

# Report 
- Html report will get generated at:
Zopa/final/Zopa_Test/target/cucumber-report/cucumber/index.html
- CSV will get generated at:
Zopa/final/Zopa_Test/target/cucumber-report/cucumber/RandomCurrencies.csv

# Author
Hitesh
