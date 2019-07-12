@InstallationTests
Feature: AV2X Manager Installation
  Scenario: Install Manager with Remotedb
    Given Manager Installer
    And Installation Type is Remotedb
    Then Start Manager installer
    Then Check if Manager installer dialog opened

    Then Click Next in Start Manager Installation dialog
    Then Accept License agreement
    Then Click Next in License dialog

    Then Enter RemoteDb server name
    Then Select Server Authentication Type
    Then Enter RemoteDb Server UserName
    Then Enter RemoteDb Server Password
    Then Click Next in DB selection dialog

    Then Change HttpsPort to 3443
    Then Select Allow connections over HTTP checkbox
    Then Click Next button in Network port dialog

    Then Click Next button Installation Destination selection dialog

    Then Click Install button



#  Scenario: Install Manager with Localdb
#    Given Manager Installer
#    And Installation Type is Default
#    Then  Install Manager using Localdb

#  Scenario: Install Manager with Silent install command
#    Given Manager Installer
#    And Installation Type is Silent
#    Then  Install Manager using SilentInstallCommand