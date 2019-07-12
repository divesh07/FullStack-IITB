@ConfigurationTests

Feature: AV2X Manager Configuration
  Scenario: Configure Manager using defaults
    Given Manager Service is running
    And  Manager listening at IP

    Then In GetStarted - Click GetStarted button

    Then In License Tab - Check License Tab Loaded
    Then In License Tab - Click Next button in License Tab

    Then In ADDomains Tab - Check ADDomains Tab loaded
    Then In ADDomains Tab - Enter Domain name
    Then In ADDomains Tab - Enter Domain UserName
    Then In ADDomains Tab - Enter Domain Password
    Then In ADDomains Tab - Set Security type as LDAP
    Then In ADDomains Tab - Click Register button in ADDomain Tab
    Then In ADDomains Tab - Check Domain bind is successful
    Then In ADDomains Tab - Click Next button in ADDomain Tab

    Then In AdminRoles Tab - Check Admin Roles Tab loaded
    Then In AdminRoles Tab - Search for Admin Group
    Then In AdminRoles Tab - Click Search button
    Then In AdminRoles Tab - Click Assign button
    Then In AdminRoles Tab - Click Next button in AdminRole

    Then In MachineManager Tab - Check MachineManagers Tab loaded
    Then In MachineManager Tab - Select Machine Manager Type as VCenter
    Then In MachineManager Tab - Enter VCenter Hostname
    Then In MachineManager Tab - Enter VCenter Username
    Then In MachineManager Tab - Enter VCenter Password
    Then In MachineManager Tab - Click Save button in Machine Managers Tab
    Then In MachineManager Tab - Click Accept button on VCenter certificate dialog
    Then In MachineManager Tab - Click Next button in Machine Managers Tab

    Then In Storage Tab - Check Storage Tab loaded
    Then In Storage Tab - Select default storage for Appstacks
    Then In Storage Tab - Select default storage for Writables
    Then In Storage Tab - Click Next button in Storage Tab
    Then In Storage Tab - Click Set Defaults button on Confirm storage settings dialog

    Then In Storage Tab - Select ESX Host to upload volumes
    Then In Storage Tab - Enter ESX Username
    Then In Storage Tab - Enter ESX Password
    Then In Storage Tab - Select all template check boxes to upload
    Then In Storage Tab - Click Upload button in UploadPrepackageVolumes Tab
    Then In Storage Tab - Click Upload button in Confirm Upload Prepackaged Volumes

    Then In Settings Tab - Click Save button in Settings Tab





#  Scenario: Configure Manager with LDAP insecure
#    Given Manager Service is running
#    And Manager  listening at IP
#    Then  Configure Manager AD with LDAP insecure
#
#  Scenario: Configure Manager with LDAPS
#    Given Manager Service is running
#    And Manager  listening at IP
#    Then  Configure Manager AD with LDAPS


