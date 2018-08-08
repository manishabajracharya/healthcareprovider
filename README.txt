
Test and Execute:
	- search and result page is at: https://healthcareprovider.azurewebsites.net
	- When click on "Search", api is called and result is displayed in same page. API end point is at: https://healthcareprovider.azurewebsites.net/api/providers 

	Run sample API call with parameters using curl in command line:
		curl "https://healthcareprovider.azurewebsites.net/api/providers?max_discharges=40&min_discharges=30&max_average_covered_charges=&min_average_covered_charges=&max_average_medicare_payments=&min_average_medicare_payments=&state=AL&fields=providerCity,providerState,hospitalReferralRegionDescription,totalDischarges"

Deployment using Microsoft Azure and Eclipse:
	- copy the project and put it in your computer.
	- install Azure plugin for Eclipse
	- create Azure database using script and csv file in "sql-scripts" folder
	- update database connection setting in "src/main/resources/persistence-mysql.properties"
	- right click on project and select "Azure -> Publish as Azure Web App"
	- use app url in Azure to open the app.


Architecture:
	- MVC
	
Solution:
	Framework used
		- Spring MVC
		- Hibernate
		- MySQL
		- Microsoft Azure
	Explanations:
		- All configuration are in package "healthcareprovider.config".
		- MySQL properties are inside folder "src/man/resources"
		- All DAO are in package "healthcareprovider.dao".
		- All entity are in package "healthcareprovider.entity".
		- All service layer are in "healthcareprovider.service".
		- All controller are in "healthcareprovider.rest". 	
Assumptions:
	In the front end, 
		By default, all options are selected for "Select Fields For Result".
		At least one value is selected for field "Select State".

