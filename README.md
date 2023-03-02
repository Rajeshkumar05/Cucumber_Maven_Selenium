## Table of contents
Requirements
Recommended modules
Installation
Configuration
Page Object
Utils
Property
Logs
Execution Process

## Requirements
cucumber(Version 7.11.1)
Java(Version 1.11)
junit(Version 4.11)
log4j(Version 1.2.17)

## Recommended module
https://coinmarketcap.com/
https://pro-api.coinmarketcap.com/

## Installation
Add all the required dependencies in POM.xml file

##  Configuration
Kept all module wise scenarios in src/test/resources/Features/UIScenario.feature and APiScenario.feature file
created Step defination on src/test/java/StepDefination/ApiScenarioStepDefination.java and UIScenarionStepDefination.java with the help for feature file's skeleton structure

## Page Object
All locators will be written on src/test/java/PageObject/CoinMarketCapPage.java

## Utils
src/test/java/Utils/Utility.java used as common methods for both Scenarios
src/test/java/Utils/GetPrice.java used only for Api Scenario

## Property
All the data kept as key and value format in src/test/resources/Property/Configuration.property file

## Logs
All captured data will be written in src/test/resources/Log/Coinmarketcap.txt file under Log folder

## Execution Process
Both the scenarios will be executed parallel from the Runner class

