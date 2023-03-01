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


## Installation
Add all the required dependencies in POM.xml file


##  Configuration
Keep all module wise scenarios in simple english language in UIScenario.feature file
Keep all required configuration data in TestDataProperties file and get it from Utility class


## Object Repository
All locators will be written on CoinMarketCapPage.java 


## Logs
All captured data will be written in Coinmarketcap.txt file under log folder


## Execution Process
Execution will be initiate from the RunnerClass

