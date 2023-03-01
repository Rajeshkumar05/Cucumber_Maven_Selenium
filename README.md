## Table of contents
Requirements
Recommended modules
Installation
Configuration


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
Kept all module wise scenarios in UIScenario.feature and APiScenario.feature file
created Step defination ApiScenarioStepDefination and UIScenarionStepDefination with the help for feature file's skeleton structure

## Page Factory
All locators will be written on CoinMarketCapPage.java


## Object Repository
All data kept in  Configuration.property and taken via Utility for both the scenario
GetPrice class used for Api scenario

## Logs
All captured data will be written in Coinmarketcap.txt file under log folder


## Execution Process
Both the scenario will be executed parallel from the Runner class

