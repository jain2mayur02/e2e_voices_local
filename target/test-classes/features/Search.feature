Feature: Validate search functionality

  Background: Open Main URL
    Given User Open Home Page

  Scenario: Validate search for packages tab for Non Sign User
    And User validate category packages search function for Non Sign User
      | Tab Name | Category 01 | Category 02   | Category 03 | Category 04 |
      | Packages | Animation   | Documentaries | Telephone   | Radio Ad    |
    And User validate language packages search function for Non Sign User
      | Tab Name | Language 01 | Language 02 | Language 03 | Language 04 |
      | Packages | Arabic      | Dutch       | English     | French      |
    And User validate accent packages search function for Non Sign User
      | Tab Name | Accent 01 | Accent 02 | Accent 03 |
      | Packages | Afghan    | Algerian  | Egyptian  |
    And User validate voice gender packages search function for Non Sign User
      | Tab Name | Gender 01 | Gender 02 |
      | Packages | Male      | Female    |
    And User validate voice age packages search function for Non Sign User
      | Tab Name | Age 01       | Age 02       | Age 03              | Age 04       |
      | Packages | Child (5-12) | Teen (13-17) | Young Adult (18-35) | Senior (55+) |
    And User validate price packages search function for Non Sign User
      | Minimum Price | Maximum Price |
      | 10            | 100           |
    And User validate delivery time packages search function for Non Sign User
      | Delivery Time 01 | Delivery Time 02 | Delivery Time 03 |
      | 24hr             | Up to 3 Days     | Up to 7 Days     |
    And User validate talent tier packages search function for Non Sign User
      | Tab Name | Talent Tier 01 | Talent Tier 02 |
      | Packages | Top Talent     | Up & Coming    |
    And User validate online status packages search function for Non Sign User
      | Tab Name | Online Status 01 |
      | Packages | Recently Online  |
    And User validate location packages search function for Non Sign User
      | Tab Name | Country | State          | City |
      | Packages | India   | Madhya Pradesh | abc  |

  Scenario: Validate search for talent tab for Non Sign User
    And User validate category talent search function for Non Sign User
      | Tab Name | Category 01 | Category 02   | Category 03 | Category 04 |
      | Talent   | Animation   | Documentaries | Telephone   | Radio Ad    |
    And User validate language talent search function for Non Sign User
      | Tab Name | Language 01 | Language 02 | Language 03 | Language 04 |
      | Talent   | Arabic      | Dutch       | English     | French      |
    And User validate accent talent search function for Non Sign User
      | Tab Name | Accent 01 | Accent 02 | Accent 03 |
      | Talent   | Afghan    | Algerian  | Egyptian  |
    And User validate voice gender talent search function for Non Sign User
      | Tab Name | Gender 01 | Gender 02 |
      | Talent   | Male      | Female    |
    And User validate voice age talent search function for Non Sign User
      | Tab Name | Age 01       | Age 02       | Age 03              | Age 04       |
      | Talent   | Child (5-12) | Teen (13-17) | Young Adult (18-35) | Senior (55+) |
    And User validate voice role talent search function for Non Sign User
      | Tab Name | Role 01   | Role 02    | Role 03 | Role 04 |
      | Talent   | Announcer | Aristocrat | Coach   | Cowgirl |
    And User validate style talent search function for Non Sign User
      | Tab Name | Style 01 | Style 02 | Style 03 | Style 04 |
      | Talent   | Amusing  | Animated | Brooding | Burly    |
    And User validate talent tier talent search function for Non Sign User
      | Tab Name | Talent Tier 01 | Talent Tier 02 |
      | Talent   | Top Talent     | Up & Coming    |
    And User validate online status talent search function for Non Sign User
      | Tab Name | Online Status 01 |
      | Talent   | Recently Online  |
    And User validate location talent search function for Non Sign User
      | Tab Name | Country       | State          | City |
      | Talent   | United States | Madhya Pradesh | abc  |
    And User validate live directed session talent search function for Non Sign User
      | Tab Name | Live Dir Session 01 | Live Dir Session 02 | Live Dir Session 03 | Live Dir Session 04 |
      | Talent   | Zoom                | Microsoft Teams     | Phone Call          | Google Meet         |

  Scenario: Validate Play Demo Search For Packages Tab For Non Sign User
    And User validate category packages play demo function for Non Sign User
      | Tab Name | Category 01 | Category 02   |
      | Packages | Animation   | Documentaries |
    And User validate language packages play demo function for Non Sign User
      | Tab Name | Language 01 | Language 02 |
      | Packages | Arabic      | Dutch       |
    And User validate accent packages play demo function for Non Sign User
      | Tab Name | Accent 01 | Accent 02 |
      | Packages | Afghan    | Algerian  |
    And User validate voice gender packages play demo function for Non Sign User
      | Tab Name | Gender 01 | Gender 02 |
      | Packages | Male      | Female    |
    And User validate voice age packages play demo function for Non Sign User
      | Tab Name | Age 01       | Age 02       |
      | Packages | Child (5-12) | Teen (13-17) |
    And User validate price packages play demo function for Non Sign User
      | Minimum Price | Maximum Price |
      | 10            | 100           |
    And User validate delivery time packages play demo function for Non Sign User
      | Delivery Time 01 | Delivery Time 02 |
      | 24hr             | Up to 3 Days     |
    And User validate talent tier packages play demo function for Non Sign User
      | Tab Name | Talent Tier 01 | Talent Tier 02 |
      | Packages | Top Talent     | Up & Coming    |
    And User validate online status packages play demo function for Non Sign User
      | Tab Name | Online Status 01 |
      | Packages | Recently Online  |
    And User validate location packages play demo function for Non Sign User
      | Tab Name | Country | State          | City |
      | Packages | India   | Madhya Pradesh | abc  |

  @Search
  Scenario: Validate Play Demo Search For Talent Tab For Non Sign User
    And User validate category talent play demo function for Non Sign User
      | Tab Name | Category 01 | Category 02   |
      | Talent   | Animation   | Documentaries |
    And User validate language talent play demo function for Non Sign User
      | Tab Name | Language 01 | Language 02 |
      | Talent   | Arabic      | Dutch       |
    And User validate accent talent play demo function for Non Sign User
      | Tab Name | Accent 01 | Accent 02 |
      | Talent   | Afghan    | Algerian  |
    And User validate voice gender talent play demo function for Non Sign User
      | Tab Name | Gender 01 | Gender 02 |
      | Talent   | Male      | Female    |
    And User validate voice age talent play demo function for Non Sign User
      | Tab Name | Age 01       | Age 02       |
      | Talent   | Child (5-12) | Teen (13-17) |
    And User validate voice role talent play demo function for Non Sign User
      | Tab Name | Role 01   |
      | Talent   | Announcer |
    And User validate style talent play demo function for Non Sign User
      | Tab Name | Style 01 |
      | Talent   | Amusing  |
    And User validate talent tier talent play demo function for Non Sign User
      | Tab Name | Talent Tier 01 |
      | Talent   | Top Talent     |
    And User validate online status talent play demo function for Non Sign User
      | Tab Name | Online Status 01 |
      | Talent   | Recently Online  |
    And User validate location talent play demo function for Non Sign User
      | Tab Name | Country       | State          | City |
      | Talent   | United States | Madhya Pradesh | abc  |
    And User validate live directed session talent play demo function for Non Sign User
      | Tab Name | Live Dir Session 01 |
      | Talent   | Zoom                |


  Scenario: Validate search for packages tab for Client User
    And User login with client credentials
    And User validate category packages search function for Client User
      | Tab Name | Category 01 | Category 02   | Category 03 | Category 04 |
      | Packages | Animation   | Documentaries | Telephone   | Radio Ad    |
    And User validate language packages search function for Client User
      | Tab Name | Language 01 | Language 02 | Language 03 | Language 04 |
      | Packages | Arabic      | Dutch       | English     | French      |
    And User validate accent packages search function for Client User
      | Tab Name | Accent 01 | Accent 02 | Accent 03 |
      | Packages | Afghan    | Algerian  | Egyptian  |
    And User validate voice gender packages search function for Client User
      | Tab Name | Gender 01 | Gender 02 |
      | Packages | Male      | Female    |
    And User validate voice age packages search function for Client User
      | Tab Name | Age 01       | Age 02       | Age 03              | Age 04       |
      | Packages | Child (5-12) | Teen (13-17) | Young Adult (18-35) | Senior (55+) |
    And User validate price packages search function for Client User
      | Minimum Price | Maximum Price |
      | 10            | 100           |
    And User validate delivery time packages search function for Client User
      | Delivery Time 01 | Delivery Time 02 | Delivery Time 03 |
      | 24hr             | Up to 3 Days     | Up to 7 Days     |
    And User validate talent tier packages search function for Client User
      | Tab Name | Talent Tier 01 | Talent Tier 02 |
      | Packages | Top Talent     | Up & Coming    |
    And User validate online status packages search function for Client User
      | Tab Name | Online Status 01 |
      | Packages | Recently Online  |
    And User validate location packages search function for Client User
      | Tab Name | Country | State          | City |
      | Packages | India   | Madhya Pradesh | abc  |


  @Working
  Scenario: Validate search for talent tab for Client User
    And User login with client credentials
#    And User validate category talent search function for Client User
#      | Tab Name | Category 01 | Category 02   | Category 03 | Category 04 |
#      | Talent   | Animation   | Documentaries | Telephone   | Radio Ad    |
#    And User validate language talent search function for Client User
#      | Tab Name | Language 01 | Language 02 | Language 03 | Language 04 |
#      | Talent   | Arabic      | Dutch       | English     | French      |
    And User validate accent talent search function for Client User
      | Tab Name | Accent 01 | Accent 02 | Accent 03 |
      | Talent   | Afghan    | Algerian  | Egyptian  |
#    And User validate voice gender talent search function for Client User
#      | Tab Name | Gender 01 | Gender 02 |
#      | Talent   | Male      | Female    |
#    And User validate voice age talent search function for Client User
#      | Tab Name | Age 01       | Age 02       | Age 03              | Age 04       |
#      | Talent   | Child (5-12) | Teen (13-17) | Young Adult (18-35) | Senior (55+) |
#    And User validate voice role talent search function for Client User
#      | Tab Name | Role 01   | Role 02    | Role 03 | Role 04 |
#      | Talent   | Announcer | Aristocrat | Coach   | Cowgirl |
#    And User validate style talent search function for Client User
#      | Tab Name | Style 01 | Style 02 | Style 03 | Style 04 |
#      | Talent   | Amusing  | Animated | Brooding | Burly    |
#    And User validate talent tier talent search function for Client User
#      | Tab Name | Talent Tier 01 | Talent Tier 02 |
#      | Talent   | Top Talent     | Up & Coming    |
#    And User validate online status talent search function for Client User
#      | Tab Name | Online Status 01 |
#      | Talent   | Recently Online  |
#    And User validate location talent search function for Client User
#      | Tab Name | Country       | State          | City |
#      | Talent   | United States | Madhya Pradesh | abc  |
#    And User validate live directed session talent search function for Client User
#      | Tab Name | Live Dir Session 01 | Live Dir Session 02 | Live Dir Session 03 | Live Dir Session 04 |
#      | Talent   | Zoom                | Microsoft Teams     | Phone Call          | Google Meet         |

