USE `bain_and_company`;

LOAD DATA LOCAL INFILE  'C:/Users/Manisha/Downloads/Inpatient_Prospective_Payment_System__IPPS__Provider_Summary_for_the_Top_100_Diagnosis-Related_Groups__DRG__-_FY2011.csv'
INTO TABLE ipps
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;