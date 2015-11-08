

INSERT INTO MEMBER (NAME, SURNAME, BIRTHDAY, ADDRESS, CITY, ZIPCODE, IBAN, ENTRYDATE,
                    NOTICEDATE, EXITDATE, MEMBERTYPE, familyMember)
VALUES ('Fernando', 'Rudolfo', 1995-12-22,'Schulstr. 2','Elmshorn', 'D-25335', 'DE15 1234 5678 9101 1213 15',
                                                      2013-05-18, 2015-07-20, 2015-12-31, 'Vollmitglied', true);
/*

INSERT INTO MEMBER (NAME, SURNAME, BIRTHDAY, ADDRESS, CITY, ZIPCODE, IBAN, ENTRYDATE,
                    NOTICEDATE, EXITDATE, MEMBERTYPE, familyMember)
VALUES ('Alberto', 'Rudolfo', '','Schulstr. 2', 'Elmshorn', 'D-25335', 'DE12 3456 7890 1234 5678 90',
        '', '', '', 'Vollmitglied', true);

INSERT INTO MEMBER (NAME, SURNAME, BIRTHDAY, ADDRESS, CITY, ZIPCODE, IBAN, ENTRYDATE,
                    NOTICEDATE, EXITDATE, MEMBERTYPE, familyMember)
VALUES ('Rudolf', 'Schrader','1974-06-13','Koellner Chaussee 136', 'Koelln-Reisiek', '25337', 'DE11 2345 6789 0123 4567 89',
        '2011-05-01', '', '', 'Foerdermitglied', false);

INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2013, 'Ermaessigt', 23, 'bezahlt', 1);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2014, 'Vollmitglied', 25, 'bezahlt', 1);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2015, 'Foerdermitglied', 10, 'offen', 1);

INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2013, 'Vollmitglied', 25, 'bezahlt', 2);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2014, 'Vollmitglied', 25, 'bezahlt', 2);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2015, 'Vollmitglied', 25, 'offen', 2);

INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2011, 'Vollmitglied', (SELECT amount FROM membertype WHERE name = 'Vollmitglied'), 'bezahlt', 3);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2012, 'Vollmitglied', (SELECT amount FROM membertype WHERE name = 'Vollmitglied'), 'bezahlt', 3);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2013, 'Vollmitglied', (SELECT amount FROM membertype WHERE name = 'Vollmitglied'), 'bezahlt', 3);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2014, 'Vollmitglied', (SELECT amount FROM membertype WHERE name = 'Vollmitglied'), 'bezahlt', 3);
INSERT INTO PAYMENTS (YEAR, MEMBERTYPE, AMOUNT, STATUS, MEMBER_FK) VALUES (2015, 'Foerdermitglied', (SELECT amount FROM membertype WHERE name = 'Foerdermitglied'), 'bezahlt', 3);

*/
