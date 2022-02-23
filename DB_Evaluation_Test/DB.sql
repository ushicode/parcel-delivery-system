CREATE TABLE senders
(
senderid INT NOT NULL
PRIMARY KEY
GENERATED always AS IDENTITY
(START WITH 1, INCREMENT BY 1),
businessname VARCHAR(225) NOT NULL,
email VARCHAR(100) NOT NULL,
address VARCHAR(225) NOT NULL,
postcode VARCHAR(20) NOT NULL,
PASSWORD VARCHAR(225) NOT NULL,
cpassword VARCHAR(225)
)


create TABLE parcels
(
parcelid int NOT NULL
PRIMARY KEY
GENERATED always AS IDENTITY
(START WITH 1, INCREMENT BY 1),
senderid int NOT NULL,
FOREIGN KEY (senderid) REFERENCES senders(senderid),
senderbusinessname varchar(220) NOT NULL,
senderemail varchar(225) NOT NULL,
recipientname varchar(80) NOT NULL,
recipientemail varchar(80) NOT NULL,
description varchar(225),
dimensions varchar(180),
trackingcode varchar(180),
address varchar(225),
postcode varchar(180) NOT NULL,
deliverystatus varchar(80),
deliverydate DATE
)



CREATE TABLE drivers
(
driverid int NOT NULL
PRIMARY KEY
GENERATED always AS IDENTITY
(START WITH 1, INCREMENT BY 1),
name varchar(225) NOT NULL,
email varchar(100) NOT NULL,
address varchar(225) NOT NULL,
postcode varchar(20) NOT NULL,
PASSWORD varchar(225) NOT NULL
)



CREATE TABLE deliveries
(
parcelid int NOT NULL,
FOREIGN KEY (parcelid) REFERENCES parcels(parcelid),
driverid int NOT NULL,
FOREIGN KEY (driverid) REFERENCES drivers(driverid)
)



CREATE TABLE settings
(
settingid int NOT NULL
PRIMARY KEY
GENERATED always AS IDENTITY
(START WITH 1, INCREMENT BY 1),
employeenote varchar(225) NOT NULL,
employeeban CHAR(1) NOT NULL,
modificationdate DATE NOT NULL
)


CREATE TABLE logs
(
logid int NOT NULL
PRIMARY KEY
GENERATED always AS IDENTITY
(START WITH 1, INCREMENT BY 1),
errors varchar(225) NOT NULL,
logdate DATE NOT NULL
)




/*

INSERT INTO SENDERS (BUSINESSNAME, EMAIL, ADDRESS, POSTCODE, PASSWORD, CPassword) VALUES ('Innert Hellium', 'hello@helium.co.uk', 'Abuja, FCT', 'ED3 FDE', 'password', 'password')
INSERT INTO SENDERS (BUSINESSNAME, EMAIL, ADDRESS, POSTCODE, PASSWORD, CPassword) VALUES ('Kingston', 'king@gmail.com', 'South Asia Street', 'BC 2D', 'password', 'password')
INSERT INTO SENDERS (BUSINESSNAME, EMAIL, ADDRESS, POSTCODE, PASSWORD, CPassword) VALUES ('Russ Venture', 'russ@staffs.com', 'Louis Park', 'DD7 4AX', 'password', 'password')
INSERT INTO SENDERS (BUSINESSNAME, EMAIL, ADDRESS, POSTCODE, PASSWORD, CPassword) VALUES ('Druvers', 'druve@ymail.co.uk', 'Mansion Lane', 'SD3 4AX', 'password', 'password')
INSERT INTO SENDERS (BUSINESSNAME, EMAIL, ADDRESS, POSTCODE, PASSWORD, CPassword) VALUES ('MIGHTY Mike', 'mmike@gmail.com', 'Westcoast Flat D', 'ST1 4DE', 'password', 'password')
*/