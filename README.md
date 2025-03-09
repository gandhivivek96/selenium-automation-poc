
# Test Automation Framework

This project is a Proof of Concept (POC) for an automated testing framework built with Selenium WebDriver, Java, and TestNG, designed for testing e-commerce websites. It demonstrates best practices for maintainable, scalable, and robust test automation.




## Features

*   **Data-Driven Testing:** Supports reading test data from CSV, JSON, and Excel files using OpenCSV, Gson, and Apache POI, utilizing POJOs for structured data representation.
*   **Cross-Browser Testing:** Supports running tests on multiple browsers (Chrome, Firefox, Edge, etc.) with `ThreadLocal` for safe parallel execution.
*   **Headless Mode:** Option to run tests in headless mode for faster execution and CI/CD integration.
*   **Cloud Testing:** Integrates with LambdaTest for running tests on a scalable cloud grid.
*   **Robust Logging:** Uses Log4j 2 for detailed logging.
*   **Comprehensive Reporting:** Generates detailed HTML reports using the Maven Surefire Report Plugin, including automatic screenshots on failure.
*   **Page Object Model (POM):**  Improves code organization, maintainability, and reusability by separating page elements and interactions from test logic.
*   **POJOs (Plain Old Java Objects):**  Used for structured data representation (test data and configuration).
*   **`ThreadLocal`:** Enables safe and efficient parallel test execution by providing thread-confined WebDriver and Extent Report instances.
*   **Continuous Integration:** Integrates with GitHub Actions for automated test execution on push, pull request, and on a schedule.

## Technologies Used

*   Java (JDK 11+)
*   Selenium WebDriver
*   TestNG
*   Maven
*   OpenCSV, Gson, Apache POI (for data-driven testing)
*   Log4j 2 (for logging)
*   ExtentReports (for reporting)
*   Faker
*   GitHub Actions (for CI/CD)
*   LambdaTest (optional, for cloud testing)


## Prerequisites

Before running this framework, ensure the following software is installed:

*   **Java Development Kit (JDK) 11 or later:** This project is configured to be *compatible* with JDK 11. Ensure the `JAVA_HOME` environment variable is set correctly.
*   **Maven:** Ensure Maven is installed and added to your system's `PATH` environment variable.
    *   [Download Maven](https://maven.apache.org/download.cgi)
    
## Setup

1.  **Clone the Repository:**

    ```bash
    git clone [https://github.com/gandhivivek96/selenium-automation-poc.git](https://github.com/gandhivivek96/selenium-automation-poc.git)
    cd selenium-automation-poc
    ```

2.  **Import into IntelliJ IDEA:**

    *   Open IntelliJ IDEA.
    *   Click "Open" (or "Open Project").
    *   Navigate to the `selenium-automation-poc` directory you just cloned and select it.
    *   IntelliJ should automatically recognize the project as a Maven project and import it.  If prompted, choose "Import as Maven Project".

3.  **Install Dependencies (if needed):**

    IntelliJ *should* automatically download and install the required dependencies (Selenium, TestNG, etc.) defined in your `pom.xml`.  If it doesn't, or if you encounter any errors:

    *   Right-click on the `pom.xml` file in the Project tool window.
    *   Select "Maven" -> "Reload Project".  This forces Maven to re-download and resolve all dependencies.

## Running Tests

### From the Command Line (Maven)

Open a terminal in the project's root directory (`selenium-automation-poc`).

*   **Basic Test Execution (Local, Chrome, Headless):**

    ```bash
    mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X
    ```

    *   `mvn clean test`: Cleans the project and runs the tests.
    *   `-Dbrowser=chrome`:  Specifies the browser. Change to `firefox`, `edge`, etc., as needed.
    *   `-DisLambdaTest=false`:  Runs tests locally.
    *   `-DisHeadless=true`:  Runs in headless mode (no visible browser).  Change to `false` to see the browser.

*   **Running on LambdaTest:**
    
    ```bash
    mvn clean test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
    ```
## Reports & Logs

*   **Reports:** After execution, a detailed HTML report (`report.html`) is generated in the project's root directory. Open `report.html` in your browser to view the results.  The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests (if applicable).

*   **Logs:** Logs are created during test execution and stored in the `logs/` directory.

*   **GitHub Pages:** The reports are automatically deployed to GitHub Pages after each push to the `main` branch. You can view the HTML reports at: [https://gandhivivek96.github.io/selenium-automation-poc/surefire-report.html](https://gandhivivek96.github.io/selenium-automation-poc/surefire-report.html)

## GitHub Actions Integration

This automation framework is integrated with GitHub Actions.  The tests are automatically executed:

*   On every `push` and `pull_request` to the `main` branch.
*   On a schedule (daily at 1:30 PM UTC).
## Authors

- [@gandhivivek96](https://github.com/gandhivivek96)
- Email: vivekgandhi30@gmail.com


## 🚀 About Me
Hi, I'm Vivek Gandhi, a Quality Engineering Specialist with 6+ years of experience building and leading test automation frameworks using Java, Selenium WebDriver, TestNG, BDD (Cucumber), and GitHub Actions.


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/gandhivivek96)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gandhivivek96/)


