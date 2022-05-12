
INSERT INTO ADDRESS VALUES (10, '164/1 Maniktala Main Road', 'EM Bypass', 'Kolkata', 'WB', '700135', 'India', '0333456788');
INSERT INTO ADDRESS VALUES (7, 'Harish kumar Road', '', 'Chennai', 'Tamil Nadu',  '700111', 'India', '');
INSERT INTO ADDRESS VALUES (2, 'New Market Road', 'PVR Sqaure', 'Morabad', '11111', 'UP', 'India', '');
INSERT INTO ADDRESS VALUES (4, '678 Manhattan Square', '', 'New York City', 'NY', '98004', 'USA', '');
INSERT INTO ADDRESS VALUES (1, '3200 Grand Ave', '', 'Oakland', 'CA', '24452', 'USA', '');
INSERT INTO ADDRESS VALUES (3, '6001 Beach Rd', '05-00 GOLDEN MILE TOWER', 'Singapore','Singapore',  'S12345', 'Singapore', '');
INSERT INTO ADDRESS VALUES (11, 'Rajarhat Main Raod', 'New Town ', 'Kolkata', 'WB', '700105', 'India', '0333456788');
INSERT INTO ADDRESS VALUES (12, 'Garia Metropolitan', 'Bullygunje', 'Kolkata', 'WB', '700100', 'India', '0333456788');
INSERT INTO ADDRESS VALUES (13, 'ABC Road', '', 'Chennai', 'Tamil Nadu',  '700101', 'India', '');
INSERT INTO ADDRESS VALUES (14, 'Kualalmapur Road', '', 'Chennai', 'Tamil Nadu',  '700121', 'India', '');

INSERT INTO THEATRE VALUES (1, 'IMAX Manisquare', 10, 1, 2, 3);
INSERT INTO THEATRE VALUES (2, 'Sathyam Cinema', 11, 1,2,0);
INSERT INTO THEATRE VALUES (3, 'PVR Cinemas', 2, 2,3,1);
INSERT INTO THEATRE VALUES (4, 'Paris Theatre', 4, 1,0,3);
INSERT INTO THEATRE VALUES (5, 'Grand Lake Theatre', 7,3,1,4);
INSERT INTO THEATRE VALUES (6, 'The Projector', 3,4,0,2);
INSERT INTO THEATRE VALUES (7, 'IMAX Mega', 13, 1, 4, 3);
INSERT INTO THEATRE VALUES (8, 'Grand Lake Theatre', 14, 4, 2, 3);

INSERT INTO MOVIE VALUES(1, 'Bhool Bhulaiyaa 2', 'Hindi', 'ROM_COMEDY', 105, DATE '2022-05-06');
INSERT INTO MOVIE VALUES(2, 'Dybbuk', 'Hindi', 'DRAMA', 100, DATE '2022-05-03');
INSERT INTO MOVIE VALUES(3, 'Dictionary', 'Bengali', 'COMEDY', 95, DATE '2022-05-01');
INSERT INTO MOVIE VALUES(4, 'Moana2', 'English', 'FANTASY', 90, DATE '2022-01-01');

INSERT INTO SHOW VALUES(1, 1, DATE '2022-05-06', TIME '12:00:00', TIME '14:00:00');
INSERT INTO SHOW VALUES(2, 3, DATE '2022-06-06', TIME '14:00:00', TIME '16:00:00');
INSERT INTO SHOW VALUES(3, 4, DATE '2022-05-06', TIME '16:00:00', TIME '18:00:00');
INSERT INTO SHOW VALUES(4, 2, DATE '2022-07-06', TIME '18:30:00', TIME '19:30:00');
commit;
