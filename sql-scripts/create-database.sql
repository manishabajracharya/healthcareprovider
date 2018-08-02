CREATE DATABASE  IF NOT EXISTS `bain_and_company` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bain_and_company`;

CREATE TABLE IPPS (
    DRG_Definition VARCHAR(255) NOt NULL,
    Provider_Id INT NOT NULL,
    Provider_Name VARCHAR(255) NOt NULL,
    Provider_Street_Address VARCHAR(255) NOt NULL,
    Provider_City VARCHAR(255) NOt NULL,
    Provider_State VARCHAR(255) NOt NULL,
    Provider_Zip_Code VARCHAR(255) NOt NULL,
    Hospital_Referral_Region_Description VARCHAR(255) NOt NULL,
	Total_Discharges INT NOT NULL,
	Average_Covered_Charges DECIMAL(10 , 2 ) NULL,
	Average_Total_Payments DECIMAL(10 , 2 ) NULL,
    Average_Medicare_Payments DECIMAL(10 , 2 ) NULL,
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);