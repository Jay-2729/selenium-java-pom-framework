# Enterprise Selenium Java Automation Framework

## Overview

This project is an enterprise-style Selenium Web Automation Framework built using Java, Selenium WebDriver, TestNG, Maven, Page Object Model (POM), Apache POI, Log4j, and Extent Reports.

The framework follows industry best practices and design patterns to ensure maintainability, scalability, reusability, and reliability.

---

## Technology Stack

| Technology         | Version | Purpose                       |
| ------------------ | ------- | ----------------------------- |
| Java               | 11      | Programming Language          |
| Selenium WebDriver | 4.22.0  | Browser Automation            |
| TestNG             | 7.10.2  | Test Execution Framework      |
| WebDriverManager   | 5.8.0   | Driver Management             |
| Apache POI         | 5.2.5   | Data Driven Testing           |
| Commons IO         | 2.16.1  | File Handling & Screenshots   |
| Log4j              | 2.23.1  | Logging                       |
| Extent Reports     | 5.1.1   | Reporting                     |
| Maven              | Latest  | Build & Dependency Management |

---

## Framework Architecture

```text
src
├── main
│   └── java
│       ├── base
│       │   └── BasePage.java
│       │
│       ├── exceptions
│       │   └── FrameworkException.java
│       │
│       ├── pages
│       │   ├── LoginPage.java
│       │   ├── ProductsPage.java
│       │   └── CartPage.java
│       │
│       └── utils
│           ├── ConfigReader.java
│           ├── DriverFactory.java
│           ├── ExcelUtil.java
│           ├── ExtentManager.java
│           ├── ExtentTestManager.java
│           ├── ReportManager.java
│           ├── ScreenshotUtil.java
│           └── Log.java
│
├── test
│   └── java
│       ├── base
│       │   └── BaseTest.java
│       │
│       ├── dataProviders
│       │   └── TestDataProvider.java
│       │
│       ├── listeners
│       │   └── TestListener.java
│       │
│       └── tests
│           └── AddToCartTest.java
│
├── resources
│   ├── config.properties
│   └── testng.xml
│
├── reports
│
├── pom.xml
└── README.md
```

---

## Framework Execution Flow

```text
testng.xml
     ↓
Test Class
     ↓
BaseTest
     ↓
DriverFactory
     ↓
Browser Launch
```

### Page Object Flow

```text
Test Class
     ↓
Page Object
     ↓
BasePage
     ↓
Reusable Selenium Methods
```

### Data Driven Flow

```text
Excel File
     ↓
ExcelUtil
     ↓
TestDataProvider
     ↓
TestNG DataProvider
     ↓
Test Execution
```

### Reporting Flow

```text
Test Execution
     ↓
TestListener
     ↓
Extent Report
     ↓
Screenshot Utility
     ↓
reports Folder
```

---

## Design Patterns Implemented

### Page Object Model (POM)

Each page in the application is represented by a dedicated Java class.

Examples:

* LoginPage
* ProductsPage
* CartPage

Benefits:

* Better maintainability
* Improved readability
* Reusable page actions
* Reduced code duplication

---

### Driver Factory Pattern

The DriverFactory centralizes browser creation and management.

Responsibilities:

* Browser initialization
* Browser configuration
* Browser shutdown
* Driver lifecycle management

Benefits:

* Single source of driver management
* Easier browser configuration
* Cross-browser scalability

---

## Key Components

### BaseTest

Responsible for:

* Browser initialization
* Application launch
* Test setup
* Test teardown

Annotations used:

```java
@BeforeMethod
@AfterMethod
```

---

### BasePage

Provides reusable Selenium actions:

```java
click()
type()
getText()
isDisplayed()
```

Benefits:

* Centralized actions
* Reduced code duplication
* Easier maintenance

---

### DriverFactory

Responsible for:

* Browser creation
* ChromeOptions configuration
* Driver reuse
* Browser cleanup

Configured ChromeOptions:

* Incognito Mode
* Disable Notifications
* Disable Password Manager
* Disable Password Leak Detection

---

### Data Driven Layer

#### ExcelUtil

Responsible for:

* Reading test data from Excel

#### TestDataProvider

Responsible for:

* Providing data to TestNG tests

Example:

```java
@DataProvider
public Object[][] loginData()
```

Benefits:

* Separation of test data and test logic
* Increased test coverage
* Easier maintenance

---

### Reporting Layer

#### ExtentManager

Creates and initializes Extent Reports.

#### ExtentTestManager

Maintains test-level report instances.

#### ReportManager

Manages report generation and configuration.

#### ScreenshotUtil

Captures screenshots during failures.

Benefits:

* Improved debugging
* Rich HTML reports
* Execution visibility

---

### Listener Layer

#### TestListener

Implements:

```java
ITestListener
```

Handles:

* onTestStart()
* onTestSuccess()
* onTestFailure()
* onTestSkipped()

Responsibilities:

* Reporting
* Logging
* Screenshot capture

---

### Logging Layer

#### Log Utility

Uses Log4j to provide:

* Execution logging
* Debugging support
* Traceability

Example:

```java
Log.info("Launching Browser");
```

---

### Exception Layer

#### FrameworkException

Custom exception class used for:

* Framework-specific errors
* Cleaner exception handling
* Improved debugging

---

## Maven Dependencies

### Selenium WebDriver

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.22.0</version>
</dependency>
```

### TestNG

```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
</dependency>
```

### WebDriverManager

```xml
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.8.0</version>
</dependency>
```

### Apache POI

```xml
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.5</version>
</dependency>
```

### Extent Reports

```xml
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.1</version>
</dependency>
```

---

## Test Execution

### Execute from IntelliJ

Right-click test class and select:

```text
Run Test
```

### Execute using TestNG XML

```text
testng.xml
```

### Execute using Maven

```bash
mvn clean test
```

---

## Reports

Generated reports can be found in:

```text
/reports
```

Artifacts generated:

* Extent Reports
* Screenshots
* Execution Logs

---

## Future Enhancements

* Parallel Execution using ThreadLocal<WebDriver>
* Cross Browser Execution
* Jenkins CI/CD Integration
* REST Assured API Automation
* Allure Reporting
* Docker Execution
* Selenium Grid Integration
* Cloud Execution (BrowserStack / Sauce Labs)

---

## Author

**Jabulile Masilela**

QA Automation Engineer