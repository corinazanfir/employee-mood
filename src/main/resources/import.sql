--Initial data for the application

--add projects
insert into PROJECTS values(1,10000,'2021-02-15','Project A',null);
insert into PROJECTS values(2,70000,'2021-03-20','Project B',null);
insert into PROJECTS values(3,55000,'2021-09-30','Project C',null);

--add users
insert into USERS values(1,'1988-01-16','2018-04-01','Catalin','Gheorghe' ,'9999-01-01',1);
insert into USERS values(2,'1988-01-16','2018-04-01','Catalin','Popescu','9999-01-01',1);
insert into USERS values(8,'1988-01-01','2019-04-01','Iustin','Tarachiu','9999-01-01',1);


insert into USERS values(3,'1988-01-01','2018-04-01','Liviu','Iliescu','9999-01-01',2);
insert into USERS values(4,'1988-01-01','2018-04-10','Andreea','Badila','9999-01-01',2);
insert into USERS values(7,'1988-01-01','2019-04-01','Alexandra','Preda','9999-01-01',2);

insert into USERS values(5,'1988-01-01','2018-04-01','Corina','Zanfir','9999-01-01',3);
insert into USERS values(6,'1988-01-01','2019-04-01','Radu','Mihartescu','9999-01-01',3);

--assign project managers
UPDATE PROJECTS SET PROJECT_MANAGER_ID = 1 WHERE ID = 1;
UPDATE PROJECTS SET PROJECT_MANAGER_ID = 4 WHERE ID = 2;
UPDATE PROJECTS SET PROJECT_MANAGER_ID = 3 WHERE ID = 3;


--add mood data
--(moodId, submissionDate, rating, improvement idea, previous day description, userId)
insert into MOODS values (1,'dbRas issue','2021-01-04',1,'New support number','Everything ok',1)
insert into MOODS values (2,'Good day','2021-01-05',5,'No issues','dbRas issue',1)
insert into MOODS values (3,'Ok','2021-01-06',5,'More coffee','Good day',1)
insert into MOODS values (4,'Skype problem','2021-01-07',4,'New tool','Ok',1)
insert into MOODS values (5,'Skype problem persist','2021-01-08',4,'New tool','Skype problem',1)
insert into MOODS values (6,'New desk','2021-01-09',3,'Keep the old one','Skype problem persist',1)
insert into MOODS values (7,'Old desk','2021-01-10',5,'Nothing','New desk',1)
insert into MOODS values (8,'Feeling sick','2021-01-11',1,'Going to the doctor','Old desk',1)
insert into MOODS values (9,'Feeling better','2021-01-12',2,'Nothing','Feeling sick',1)
insert into MOODS values (10,'Returning to office','2021-01-13',2,'More days of leave','Feeling better',1)
insert into MOODS values (11,'Feeling good','2021-01-14',4,'Everything ok','Returning to office',1)
insert into MOODS values (12,'Server down','2021-01-15',1,'New one','Feeling good',1)
insert into MOODS values (13,'Good day','2021-01-16',5,'Ok','Server down',1)
insert into MOODS values (14,'New tool to accommodate','2021-01-17',1,'Training','Good day',1)
insert into MOODS values (15,'Everything ok','2021-01-18',4,'Nothing','New tool to accommodate',1)
insert into MOODS values (16,'New day','2021-01-19',3,'More coffee','Everything ok',1)
insert into MOODS values (17,'New colleague','2021-01-20',5,'Ok','New day',1)
insert into MOODS values (18,'Missing phone','2021-01-21',1,'New one','New colleague',1)
insert into MOODS values (19,'Very busy','2021-01-22',2,'Less tasks','Missing phone',1)
insert into MOODS values (20,'One defect solved','2021-01-23',4,'New testing','Very busy',1)

--insert into MOODS values (21,'Comments','2021-01-24',3,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (22,'Comments','2021-01-25',5,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (23,'Comments','2021-01-26',4,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (24,'Comments','2021-01-27',4,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (25,'Comments','2021-01-28',1,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (26,'Comments','2021-01-29',3,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (27,'Comments','2021-01-30',3,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (28,'Comments','2021-01-31',5,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (29,'Comments','2021-02-01',5,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (30,'Comments','2021-02-02',2,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (31,'Comments','2021-02-03',2,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (32,'Comments','2021-02-04',2,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (33,'Comments','2021-02-05',4,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (34,'Comments','2021-02-06',1,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (35,'Comments','2021-02-07',2,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (36,'Comments','2021-02-08',4,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (37,'Comments','2021-02-09',5,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (38,'Comments','2021-02-10',4,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (39,'Comments','2021-02-11',3,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (40,'Comments','2021-02-12',5,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (41,'Comments','2021-02-13',3,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (42,'Comments','2021-02-14',5,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (43,'Comments','2021-02-15',3,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (44,'Comments','2021-02-16',2,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (45,'Comments','2021-02-17',4,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (46,'Comments','2021-02-18',2,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (47,'Comments','2021-02-19',1,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (48,'Comments','2021-02-20',1,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (49,'Comments','2021-02-21',5,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (50,'Comments','2021-02-22',3,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (51,'Comments','2021-02-23',3,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (52,'Comments','2021-02-24',2,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (53,'Comments','2021-02-25',2,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (54,'Comments','2021-02-26',1,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (55,'Comments','2021-02-27',1,'Improvement Idea','Previous day comments',1)
--insert into MOODS values (56,'Comments','2021-02-28',5,'Improvement Idea','Previous day comments',1)

insert into MOODS values (57,'dbRas issue','2021-01-04',1,'New support number','Everything ok',2)
insert into MOODS values (58,'Good day','2021-01-05',5,'No issues','dbRas issue',2)
insert into MOODS values (59,'Ok','2021-01-06',5,'More coffee','Good day',2)
insert into MOODS values (60,'Skype problem','2021-01-07',4,'New tool','Ok',2)
insert into MOODS values (61,'Skype problem persist','2021-01-08',4,'New tool','Skype problem',2)
insert into MOODS values (62,'New desk','2021-01-09',3,'Keep the old one','Skype problem persist',2)
insert into MOODS values (63,'Old desk','2021-01-10',5,'Nothing','New desk',2)
insert into MOODS values (64,'Feeling sick','2021-01-11',1,'Going to the doctor','Old desk',2)
insert into MOODS values (65,'Feeling better','2021-01-12',2,'Nothing','Feeling sick',2)
insert into MOODS values (66,'Returning to office','2021-01-13',2,'More days of leave','Feeling better',2)
insert into MOODS values (67,'Feeling good','2021-01-14',4,'Everything ok','Returning to office',2)
insert into MOODS values (68,'Server down','2021-01-15',1,'New one','Feeling good',2)
insert into MOODS values (69,'Good day','2021-01-16',5,'Ok','Server down',2)
insert into MOODS values (70,'New tool to accommodate','2021-01-17',1,'Training','Good day',2)
insert into MOODS values (71,'Everything ok','2021-01-18',4,'Nothing','New tool to accommodate',2)

--insert into MOODS values (72,'Comments','2021-01-19',3,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (73,'Comments','2021-01-20',1,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (74,'Comments','2021-01-21',3,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (75,'Comments','2021-01-22',1,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (76,'Comments','2021-01-23',5,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (77,'Comments','2021-01-24',1,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (78,'Comments','2021-01-25',1,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (79,'Comments','2021-01-26',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (80,'Comments','2021-01-27',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (81,'Comments','2021-01-28',5,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (82,'Comments','2021-01-29',3,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (83,'Comments','2021-01-30',1,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (84,'Comments','2021-01-31',5,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (85,'Comments','2021-02-01',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (86,'Comments','2021-02-02',3,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (87,'Comments','2021-02-03',3,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (88,'Comments','2021-02-04',2,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (89,'Comments','2021-02-05',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (90,'Comments','2021-02-06',2,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (91,'Comments','2021-02-07',5,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (92,'Comments','2021-02-08',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (93,'Comments','2021-02-09',2,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (94,'Comments','2021-02-10',2,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (95,'Comments','2021-02-11',3,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (96,'Comments','2021-02-12',2,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (97,'Comments','2021-02-13',3,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (98,'Comments','2021-02-14',3,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (99,'Comments','2021-02-15',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (100,'Comments','2021-02-16',2,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (101,'Comments','2021-02-17',1,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (102,'Comments','2021-02-18',1,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (103,'Comments','2021-02-19',5,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (104,'Comments','2021-02-20',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (105,'Comments','2021-02-21',2,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (106,'Comments','2021-02-22',3,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (107,'Comments','2021-02-23',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (108,'Comments','2021-02-24',2,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (109,'Comments','2021-02-25',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (110,'Comments','2021-02-26',4,'Improvement Idea','Previous day comments',2)
--insert into MOODS values (111,'Comments','2021-02-27',2,'Improvement Idea','Previous day comments',2)
----insert into MOODS values (112,'Comments','2021-02-28',5,'Improvement Idea','Previous day comments',2)

insert into MOODS values (113,'dbRas issue','2021-01-04',1,'New support number','Everything ok',3)
insert into MOODS values (114,'Good day','2021-01-05',5,'No issues','dbRas issue',3)
insert into MOODS values (115,'Ok','2021-01-06',5,'More coffee','Good day',3)
insert into MOODS values (116,'Skype problem','2021-01-07',4,'New tool','Ok',3)
insert into MOODS values (117,'Skype problem persist','2021-01-08',4,'New tool','Skype problem',3)
insert into MOODS values (118,'New desk','2021-01-09',3,'Keep the old one','Skype problem persist',3)
insert into MOODS values (119,'Old desk','2021-01-10',5,'Nothing','New desk',3)
insert into MOODS values (120,'Feeling sick','2021-01-11',1,'Going to the doctor','Old desk',3)
insert into MOODS values (121,'Feeling better','2021-01-12',2,'Nothing','Feeling sick',3)
insert into MOODS values (122,'Returning to office','2021-01-13',2,'More days of leave','Feeling better',3)
insert into MOODS values (123,'Feeling good','2021-01-14',4,'Everything ok','Returning to office',3)
insert into MOODS values (124,'Server down','2021-01-15',1,'New one','Feeling good',3)
insert into MOODS values (125,'Good day','2021-01-16',5,'Ok','Server down',3)
insert into MOODS values (126,'New tool to accommodate','2021-01-17',1,'Training','Good day',3)
insert into MOODS values (127,'Everything ok','2021-01-18',4,'Nothing','New tool to accommodate',3)


--insert into MOODS values (128,'Comments','2021-01-19',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (129,'Comments','2021-01-20',4,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (130,'Comments','2021-01-21',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (131,'Comments','2021-01-22',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (132,'Comments','2021-01-23',4,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (133,'Comments','2021-01-24',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (134,'Comments','2021-01-25',4,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (135,'Comments','2021-01-26',4,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (136,'Comments','2021-01-27',5,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (137,'Comments','2021-01-28',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (138,'Comments','2021-01-29',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (139,'Comments','2021-01-30',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (140,'Comments','2021-01-31',5,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (141,'Comments','2021-02-01',4,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (142,'Comments','2021-02-02',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (143,'Comments','2021-02-03',4,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (144,'Comments','2021-02-04',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (145,'Comments','2021-02-05',4,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (146,'Comments','2021-02-06',3,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (147,'Comments','2021-02-07',3,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (148,'Comments','2021-02-08',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (149,'Comments','2021-02-09',5,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (150,'Comments','2021-02-10',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (151,'Comments','2021-02-11',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (152,'Comments','2021-02-12',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (153,'Comments','2021-02-13',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (154,'Comments','2021-02-14',5,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (155,'Comments','2021-02-15',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (156,'Comments','2021-02-16',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (157,'Comments','2021-02-17',3,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (158,'Comments','2021-02-18',1,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (159,'Comments','2021-02-19',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (160,'Comments','2021-02-20',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (161,'Comments','2021-02-21',3,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (162,'Comments','2021-02-22',4,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (163,'Comments','2021-02-23',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (164,'Comments','2021-02-24',3,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (165,'Comments','2021-02-25',5,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (166,'Comments','2021-02-26',2,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (167,'Comments','2021-02-27',3,'Improvement Idea','Previous day comments',3)
--insert into MOODS values (168,'Comments','2021-02-28',3,'Improvement Idea','Previous day comments',3)

insert into MOODS values (169,'dbRas issue','2021-01-04',1,'New support number','Everything ok',4)
insert into MOODS values (170,'Good day','2021-01-05',5,'No issues','dbRas issue',4)
insert into MOODS values (171,'Ok','2021-01-06',5,'More coffee','Good day',4)
insert into MOODS values (172,'Skype problem','2021-01-07',4,'New tool','Ok',4)
insert into MOODS values (173,'Skype problem persist','2021-01-08',4,'New tool','Skype problem',4)
insert into MOODS values (174,'New desk','2021-01-09',3,'Keep the old one','Skype problem persist',4)
insert into MOODS values (175,'Old desk','2021-01-10',5,'Nothing','New desk',4)
insert into MOODS values (176,'Feeling sick','2021-01-11',1,'Going to the doctor','Old desk',4)
insert into MOODS values (177,'Feeling better','2021-01-12',2,'Nothing','Feeling sick',4)
insert into MOODS values (178,'Returning to office','2021-01-13',2,'More days of leave','Feeling better',4)
insert into MOODS values (179,'Feeling good','2021-01-14',4,'Everything ok','Returning to office',4)
insert into MOODS values (180,'Server down','2021-01-15',1,'New one','Feeling good',4)
insert into MOODS values (181,'Good day','2021-01-16',5,'Ok','Server down',4)
insert into MOODS values (182,'New tool to accommodate','2021-01-17',1,'Training','Good day',4)
insert into MOODS values (183,'Everything ok','2021-01-18',4,'Nothing','New tool to accommodate',4)

--insert into MOODS values (184,'Comments','2021-01-19',4,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (185,'Comments','2021-01-20',3,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (186,'Comments','2021-01-21',2,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (187,'Comments','2021-01-22',1,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (188,'Comments','2021-01-23',2,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (189,'Comments','2021-01-24',4,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (190,'Comments','2021-01-25',5,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (191,'Comments','2021-01-26',1,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (192,'Comments','2021-01-27',2,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (193,'Comments','2021-01-28',4,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (194,'Comments','2021-01-29',2,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (195,'Comments','2021-01-30',4,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (196,'Comments','2021-01-31',1,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (197,'Comments','2021-02-01',5,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (198,'Comments','2021-02-02',2,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (199,'Comments','2021-02-03',2,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (200,'Comments','2021-02-04',3,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (201,'Comments','2021-02-05',1,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (202,'Comments','2021-02-06',3,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (203,'Comments','2021-02-07',1,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (204,'Comments','2021-02-08',1,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (205,'Comments','2021-02-09',2,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (206,'Comments','2021-02-10',3,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (207,'Comments','2021-02-11',4,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (208,'Comments','2021-02-12',4,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (209,'Comments','2021-02-13',5,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (210,'Comments','2021-02-14',5,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (211,'Comments','2021-02-15',1,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (212,'Comments','2021-02-16',4,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (213,'Comments','2021-02-17',5,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (214,'Comments','2021-02-18',3,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (215,'Comments','2021-02-19',2,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (216,'Comments','2021-02-20',5,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (217,'Comments','2021-02-21',5,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (218,'Comments','2021-02-22',1,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (219,'Comments','2021-02-23',5,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (220,'Comments','2021-02-24',5,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (221,'Comments','2021-02-25',3,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (222,'Comments','2021-02-26',1,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (223,'Comments','2021-02-27',4,'Improvement Idea','Previous day comments',4)
--insert into MOODS values (224,'Comments','2021-02-28',4,'Improvement Idea','Previous day comments',4)

--insert into MOODS values (225,'Comments','2021-01-04',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (226,'Comments','2021-01-05',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (227,'Comments','2021-01-06',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (228,'Comments','2021-01-07',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (229,'Comments','2021-01-08',3,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (230,'Comments','2021-01-09',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (231,'Comments','2021-01-10',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (232,'Comments','2021-01-11',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (233,'Comments','2021-01-12',3,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (234,'Comments','2021-01-13',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (235,'Comments','2021-01-14',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (236,'Comments','2021-01-15',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (237,'Comments','2021-01-16',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (238,'Comments','2021-01-17',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (239,'Comments','2021-01-18',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (240,'Comments','2021-01-19',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (241,'Comments','2021-01-20',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (242,'Comments','2021-01-21',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (243,'Comments','2021-01-22',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (244,'Comments','2021-01-23',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (245,'Comments','2021-01-24',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (246,'Comments','2021-01-25',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (247,'Comments','2021-01-26',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (248,'Comments','2021-01-27',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (249,'Comments','2021-01-28',3,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (250,'Comments','2021-01-29',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (251,'Comments','2021-01-30',3,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (252,'Comments','2021-01-31',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (253,'Comments','2021-02-01',3,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (254,'Comments','2021-02-02',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (255,'Comments','2021-02-03',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (256,'Comments','2021-02-04',3,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (257,'Comments','2021-02-05',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (258,'Comments','2021-02-06',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (259,'Comments','2021-02-07',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (260,'Comments','2021-02-08',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (261,'Comments','2021-02-09',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (262,'Comments','2021-02-10',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (263,'Comments','2021-02-11',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (264,'Comments','2021-02-12',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (265,'Comments','2021-02-13',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (266,'Comments','2021-02-14',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (267,'Comments','2021-02-15',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (268,'Comments','2021-02-16',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (269,'Comments','2021-02-17',3,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (270,'Comments','2021-02-18',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (271,'Comments','2021-02-19',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (272,'Comments','2021-02-20',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (273,'Comments','2021-02-21',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (274,'Comments','2021-02-22',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (275,'Comments','2021-02-23',1,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (276,'Comments','2021-02-24',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (277,'Comments','2021-02-25',5,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (278,'Comments','2021-02-26',4,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (279,'Comments','2021-02-27',2,'Improvement Idea','Previous day comments',5)
--insert into MOODS values (280,'Comments','2021-02-28',4,'Improvement Idea','Previous day comments',5)

--insert into MOODS values (281,'Comments','2021-01-04',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (282,'Comments','2021-01-05',5,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (283,'Comments','2021-01-06',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (284,'Comments','2021-01-07',5,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (285,'Comments','2021-01-08',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (286,'Comments','2021-01-09',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (287,'Comments','2021-01-10',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (288,'Comments','2021-01-11',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (289,'Comments','2021-01-12',5,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (290,'Comments','2021-01-13',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (291,'Comments','2021-01-14',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (292,'Comments','2021-01-15',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (293,'Comments','2021-01-16',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (294,'Comments','2021-01-17',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (295,'Comments','2021-01-18',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (296,'Comments','2021-01-19',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (297,'Comments','2021-01-20',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (298,'Comments','2021-01-21',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (299,'Comments','2021-01-22',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (300,'Comments','2021-01-23',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (301,'Comments','2021-01-24',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (302,'Comments','2021-01-25',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (303,'Comments','2021-01-26',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (304,'Comments','2021-01-27',5,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (305,'Comments','2021-01-28',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (306,'Comments','2021-01-29',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (307,'Comments','2021-01-30',5,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (308,'Comments','2021-01-31',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (309,'Comments','2021-02-01',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (310,'Comments','2021-02-02',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (311,'Comments','2021-02-03',5,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (312,'Comments','2021-02-04',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (313,'Comments','2021-02-05',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (314,'Comments','2021-02-06',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (315,'Comments','2021-02-07',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (316,'Comments','2021-02-08',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (317,'Comments','2021-02-09',5,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (318,'Comments','2021-02-10',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (319,'Comments','2021-02-11',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (320,'Comments','2021-02-12',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (321,'Comments','2021-02-13',5,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (322,'Comments','2021-02-14',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (323,'Comments','2021-02-15',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (324,'Comments','2021-02-16',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (325,'Comments','2021-02-17',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (326,'Comments','2021-02-18',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (327,'Comments','2021-02-19',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (328,'Comments','2021-02-20',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (329,'Comments','2021-02-21',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (330,'Comments','2021-02-22',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (331,'Comments','2021-02-23',4,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (332,'Comments','2021-02-24',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (333,'Comments','2021-02-25',3,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (334,'Comments','2021-02-26',1,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (335,'Comments','2021-02-27',2,'Improvement Idea','Previous day comments',6)
--insert into MOODS values (336,'Comments','2021-02-28',2,'Improvement Idea','Previous day comments',6)
