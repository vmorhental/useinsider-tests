# useinsider-tests
Test exercise for useinsiders:

Visit https://useinsider.com/ and check Insider home page is opened or not

Select “More” menu in navigation bar, select “Careers” and check Career
page, its Locations, Teams and Life at Insider blocks are opened or not

Click “See All Teams”, select Quality Assurance, click “See all QA jobs”, filter
jobs by Location - Istanbul, Turkey and department - Quality Assurance,
check presence of jobs list

Check that all jobs’ Position contains “Quality Assurance”, Department
contains “Quality Assurance”, Location contains “Istanbul, Turkey” and “Apply
Now” button

Click “Apply Now” button and check that this action redirects us to Lever
Application form page

Test case should be written using any programming language and framework (Python or Java + Selenium would be preferable)

No BDD(Cucumber, Quantum, Codeception, etc.) frameworks are allowed

Test case should fully meet POM requirements

Buttons, dropdowns and other elements should have optimized Xpath and
CSS selectors

Assertions should be used in test case

Code should be clean and readable

## Action items
* to add data-test-id attributes
* to switch off cookies pop up
## Getting started
install JDK
* download jdk (corretto-17.0.5)
* set jdk path to 'JAVA_HOME' environment variable
* add %JAVA_HOME%\bin to 'Path' environment variable
install Apache Maven
* download maven (3.6.3)
* unzip
* set maven path to 'M2_HOME' environment variable
* add %M2_HOME%\bin to 'Path' environment variable
## How to run tests:
- locally - mvn clean test(Report - target/surefire-reports/index.html/)
## How to get report:
- target/surefire-reports/index.html
