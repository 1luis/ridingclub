INSERT INTO MEMBERTYPE (NAME, AMOUNT) VALUES ('Vollmitglied', 25);
INSERT INTO MEMBERTYPE (NAME, AMOUNT) VALUES ('Ermaessigt', 23);
INSERT INTO MEMBERTYPE (NAME, AMOUNT) VALUES ('Jugendmitglied', 15);
INSERT INTO MEMBERTYPE (NAME, AMOUNT) VALUES ('Foerdermitglied', 10);

INSERT INTO MEMBER (NAME, SURNAME, BIRTHDAY, ADDRESS, CITY, ZIPCODE, IBAN, ENTRYDATE, NOTICEDATE, EXITDATE, MEMBERTYPE) VALUES ('Alex', 'Perez', '31.12.2015','Dorfstrasse 2', 'Hamburg', 'D-22299', 'DE12345', '01.01.2011', '2015-10-11', '2015-10-11', 'Vollmitglied');
INSERT INTO MEMBER (NAME, SURNAME, BIRTHDAY, ADDRESS, CITY, ZIPCODE, IBAN, ENTRYDATE, NOTICEDATE, EXITDATE, MEMBERTYPE) VALUES ('Luis', 'Iglesias','31.12.2016','Stresemannstr. 22', 'Hamburg', '20781', 'DE12345', '01.01.2012', '2015-10-11', '2015-10-11', 'Foerdermitglied');
INSERT INTO MEMBER (NAME, SURNAME, BIRTHDAY, ADDRESS, CITY, ZIPCODE, IBAN, ENTRYDATE, NOTICEDATE, EXITDATE, MEMBERTYPE) VALUES ('Marc', 'Reineking','09.07.1991','Margarethenstr. 27', 'Elmshorn', '25337', 'ES9160', '01.01.2013', '2015-10-11', '2015-10-11', 'Ermaessigt');
INSERT INTO MEMBER (MEMBER_ID, NAME, SURNAME, BIRTHDAY, ADDRESS, CITY, ZIPCODE, IBAN, ENTRYDATE, NOTICEDATE, EXITDATE, MEMBERTYPE) VALUES (5, 'Marc', 'Reineking','09.07.1991','Margarethenstr. 27', 'Elmshorn', '25337', 'ES9160', '01.01.2013', '2015-10-11', '2015-10-11', 'Ermaessigt');
--
-- TODO: welche Referenz wird hier f�r MEMBER in PAYMENTS erwartet? die Mitglieds-ID als Nummer?
--
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2015, 'VOLLMITGLIED', 25, 'offen', 1);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2015, 'FOERDERMITGLIED', 10, 'bezahlt', 2);
--INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_ID) VALUES (2015, 'JUGENDMITGLIED', 15, 'offen', 3);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2015, 'Vollmitglied', (SELECT amount FROM membertype WHERE name = 'Vollmitglied'), 'offen', 3);


