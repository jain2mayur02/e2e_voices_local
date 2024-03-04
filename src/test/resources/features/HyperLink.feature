@HyperLink
Feature: HyperLink Validation

  Background: Open Main URL
    Given User Open Home Page

  Scenario: Validate All Hyperlink On Main Navigation Panel For Non SignIn User
    And User click on How it works link and validate url
    And User click on log in link and validate url
    And User click on sign up link and validate url

  Scenario: Validate All Hyperlink On Sub Navigation Panel For Non SignIn User
    Then Validate all sub module hyperlink

  Scenario: Validate Sub Footer For Non SignIn User
    And User validate all by language links for non login user
    And User validate all by category links for non login user
    And User validate all by style links for non login user
    And User validate all by location links for non login user

  Scenario: Validate All Footer Links For Non SignIn User
    And User validate all company links under footer for Non Sign user
    And User validate all for client links under footer for Non Sign user
    And User validate all for talent links under footer for Non Sign user
    And User validate all social media links under footer for Non Sign user
    And User validate all footer links under footer for Non Sign user

  Scenario: Validate All HyerLink On Main Navigation Panel For Client SingIn User
    And User login with client credentials
    And User Click on post job and Validate url open successfully
    And User Click on jobs and Validate all hyperlinks
    And User Click on Messages and Notifications hyperlinks
    And User Click on user icon and Validate all hyperlinks

  Scenario: Validate All Hyperlink On Sub Navigation Panel For Client SignIn User
    And User login with client credentials
    Then Validate all sub module hyperlink

  Scenario: Validate All Hyperlink On Footer For Client SignIn User
    And User login with client credentials
    Then User validate all company link under footer of page
    Then User validate all resources link under footer of page
    Then User validate all social media link under footer of page
    Then User validate all footer link under footer of page

  Scenario: Validate All HyerLink On Main Navigation Panel For Talent Guest SingIn User
    And User login with Talent Guest credentials
    And User over on jobs and Validate all hyperlinks
    And User Click on payments and Validate all hyperlinks
    And User Click on Messages and validate hyperlinks
    And User Click on helps and Validate all hyperlinks
    And User click on user icon and validate all hyperlink

  Scenario: Validate All Hyperlink On Footer For Talent Guest SignIn User
    And User login with Talent Guest credentials
    Then User validate all company link under footer of page
    Then User validate all resources link under footer of page for talent user
    Then User validate all social media link under footer of page
    Then User validate all footer link under footer of page










#  Scenario: Validate All HyerLink on Main Navigation Panel For Non SingIn User
#    And  User Click on Find Talent Talent Profile and Validate all hyperlinks
#    And  User Click on Find Talent Talent Package and Validate all hyperlinks
