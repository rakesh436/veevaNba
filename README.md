# NBA Framework
- A framework to automate NBA web Application which follows page object pattern

**Getting Started**
- Install maven
- Install Java version 20
- `run` : mvn clean install

**Defining the browser**
Currently the browser is hardcoded as chrome, can be parameterised in further enhancements

**Writing Tests**

- To write tests create a java file and extend the file to `BaseSetup`
- Create pageObject classes and extend them to `WebElementOperations`

1. Tests should be in the required package
2. Create pageObjects classes for each web pages
3. Put assertions in class level
4. Don't use hardcoded waits

**Executing Test**
- To run any TEST in local right-click on the test and click run/debug.
- To run TEST from terminal execute command `mvn clean test`

**REPORTS**
Reports can be found in `target` folder and screenshots for failed test in `screenshots` directory

`TOOLS USED`
1. Java
2. Maven
3. Selenium
4. TestNG