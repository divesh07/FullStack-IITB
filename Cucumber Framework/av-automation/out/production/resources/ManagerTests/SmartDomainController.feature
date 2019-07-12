@SmartDomainControllerDiscoveryTests
  Feature: Smart Domain Controller Discovery
    Scenario: Shift from smart mode to Manual mode
      Given Firefox Browser
      And In Login Page - Open AppVolumes Login Page
      Then In Login Page - Enter Login and Password
      Then In Login Page - Click Login
      Then  Navigate to ADDomains Tab
      Then In ADDomains Tab - Expand Domain details
      Then In ADDomains Tab - Click Edit button
      Then In ADDomains Tab - Enter Domain Controller Hosts details
      Then In ADDomains Tab - Enter Domain Password
      Then In ADDomains Tab - Click Update button
      Then In ADDomains Tab - Check all the DomainControllers are connected

#    Scenario: Shift from manual mode to smart mode
#      Given Firefox Browser
#      And  In Login Page - Open AppVolumes Login Page
#      Then In Login Page - Enter Login and Password
#      Then In Login Page - Click Login
#      Then Navigate to ADDomains Tab
#      Then In ADDomains Tab - Expand Domain details
#      Then In ADDomains Tab - Click Edit button
#      Then In ADDomains Tab - Clear Domain Controller Hosts list
#      Then In ADDomains Tab - Enter Domain Password
#      Then In ADDomains Tab - Click Update button
#      Then In ADDomains Tab - Check all the DomainControllers are connected