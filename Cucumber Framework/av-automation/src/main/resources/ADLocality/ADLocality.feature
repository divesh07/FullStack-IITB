@AdCrud
Feature: Ad Locality
  Scenario: Create Domain
    Given manager Installer install AD
    Then verify the AD domain
    And response success