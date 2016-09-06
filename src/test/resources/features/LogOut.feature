#private MainPage mainPage;
#
#@BeforeMethod(groups = {"Smoke"})
#public void setUp() {
#mainPage = LoginPage.loginAsPrimaryUser();
#}
#
#@Test(groups = {"Smoke"})
#public void testLogout() {
#TopHeader topHeader = mainPage.gotoTopHeader();
#topHeader.clickUserNameMenu();
#LoginPage loginPage = topHeader.clickLogoutOption();
#assertTrue(loginPage.isLoginButtonPresent());
#}

Feature: Log out for xpress
  Background: login
    Given I login with valid credentials

  @DeleteProjects
  Scenario: Test log out
    Given I log out for the application
    Then The Login button is present