-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (252,'$2a$10$jQnWOhnJYkhQ0djBdmGu/u/sPeRhH6Js7g1ti.hkdNgJfxExdQp9K','ROLE_USER','hello1',102),(302,'$2a$10$mCTzuRNMVOxJU8dmrZr7vew.EcqYj1NjS7p/.2UyGZSueG8M0sdSq','ROLE_ADMIN','hung',152),(352,'$2a$10$vq0MNyd99fgyO8VpD4oet.5/BwFBP33ORL2zu5w5HP17pGWeAmk6C','ROLE_USER','hello',252),(402,'$2a$10$vkgMgeL/JV0/Fh9Dq4Xd4.L1cN6bps6qCJRrynUWebIj5A0WCyj0m','ROLE_USER','demo',1802),(452,'$2a$10$MIZtvci/cw28wWPZ3BcxQeInHIY5UqaQSBgXX1310GStdFBT0X4e6','ROLE_USER','demo1',2052),(502,'$2a$10$Q5LFeTr9jf89tjQh.C4nreWGkNuJGC/I.QezDfrfY0K0eADvwLhpW','ROLE_USER','user',2202),(552,'$2a$10$1KPoEZcfZoq8O1GkIGl7EOcc/D2k/AoAiqzob/u0OHaQTq6AxKdme','ROLE_USER','demo2',2352),(602,'$2a$10$y9bK9m.MCw7Uhax31Wd3yeM8Vk2n4gkhR/b4VmSssTjoRqUNdzF3G','ROLE_USER','demo3',2502),(652,'$2a$10$nViuHe6ed0d8T3i2GbJH9.4A0HpuBX5za/5y4KA6W/w4Cw8Ilf5rm','ROLE_USER','demo4',2852),(702,'$2a$10$TxwPcKzZxn3Xc6YPIJWivupQtA.LY56LhKmOwGfgNGYvTdAQ13BTO','ROLE_USER','demo5',3102),(752,'$2a$10$eTKFgRrMe8GkmGepKcjhpO51.0HKVPMRV9lBxmLwIak6eUvoIDy7i','ROLE_USER','demo6',3552),(802,'$2a$10$FTtLbvALsSUjrCcsGOsIyeBn8d0NeYPVbufdogwod.NL4kwN76XNK','ROLE_USER','demo7',6202),(852,'$2a$10$TO8jU4K20S6DqrPw8llXEOV4kY5WnWNAu5/5JuPw1eKGa2ye8gIM2','ROLE_USER','demo8',6452),(902,'$2a$10$aDbvR7ZSa/9Zd5UxBnptI.V/vifXpdmAs9PDyaBENXrA90wSfXVte','ROLE_USER','demo10',7402),(952,'$2a$10$5Vq8luLM/3/pofH3V3Q/p.Hr/d4dcr.jrLDupxgFx7VxQgs3wnBwC','ROLE_USER','demo11',7702),(1002,'$2a$10$6jCqoYhO0nnJDXSOuO5GPOd0jUbLqBFlIxBNxuDrN05mWQwYmQbRq','ROLE_USER','demo20',7802),(1052,'$2a$10$qxeRnOF19hN5.hDhyjFrsea4a69cqbiIhrk4W56sizhv9u7FhEugm','ROLE_USER','demo30',8352),(1102,'$2a$10$1SYTIu78y2eHQzBaCdu8HuHKcgHcc3ipaZNcwCP/fDuocmMuFhMBm','ROLE_ADMIN','demo39',8752),(1152,'$2a$10$tsI3cL85CyMefRYDALshK.9nEEt31IMiqrMqcRDnY2rNwaDl9BPE2','ROLE_USER','demo69',8952),(1202,'$2a$10$QonRWLF8MAau0zzPdHOUROdXgLgcsaHOYmgFe9lMmCWvcObvkWFh6','ROLE_USER','demo6969',9052),(1203,'$2a$10$aOpblI/aW5hDYhdMocHKvOmDuWNXoxpdJmTEEmW1vCcaNDbYYeNva','ROLE_USER','demo96',9053),(1204,'$2a$10$/ixd4.6N4Yuv38bazSqa5ONPAOO3hS9su3ltniQ022Ra/6VUKGx4S','ROLE_USER','demo9696',9054),(1205,'$2a$10$PnVEmK3VlnjP7KiBFszFyOToVcjuCr3B8N8t1VbDCsvli6inhuuN2','ROLE_USER','hieuadmin',9055),(1206,'$2a$10$c9rKzA6N6HycZW/jwnUOWORII.awHZxgrVox63gpKzG1cQPWxrbB6','ROLE_USER','dsadasd',9056),(1252,'$2a$10$DI1hgUhx/vl8Qw7TNfFArOPGFo7t9lWbapffUDlUDF7PiTN/MVpNC','ROLE_USER','hieuoc',9152),(1302,'$2a$10$NstJT9dwgP60hAH0gh//be9XbXpRjAoNCAftOZBU5cVkNNqa2jTaK','ROLE_ADMIN','admin69',9252),(1352,'$2a$10$oLnan.zQw75.4AFbcVO1LujcHB47ktFwR1EC5BugY/51xnZWZsTPe','ROLE_USER','hieusida',9352),(1353,'$2a$10$12LC.h0AyR9DXLuwuAAhme0cYR.7.u4Mm.Ku7E.6Ka5gmXhMj/7iK','ROLE_USER','dm',9353),(1402,'$2a$10$6/3tLyRtezvspDxmj2voKuGCHNpbTmelmxmPERe4QYp76QI0Sk2A6','ROLE_USER','nihao',9452),(1403,'$2a$10$nS/zm5Irq5OUf7athblY7emBjxQwoXgS6LvnQ0r8V0ON4Kok7OaG6','ROLE_USER','hello12',9453),(1404,'$2a$10$7R81ZkABEDuIzG.8X7K21.PthBVl6ivgJ69XX2rZMAE0nkcWbXFsy','ROLE_USER','hello123',9454),(1452,'$2a$10$ZCMoI6ZOoDd6GlOSZ9wPreCcxjDyBAXcZPdGaBTgq0e.P9jLPEKmW','ROLE_USER','hihoe',9552),(1502,'$2a$10$HUNtxw4gyDIxL4Z4VOW/uuNaV.6w8.1TDw/J.agFtXhCQaRKIuEB.','ROLE_USER','hieuga',9652),(1552,'$2a$10$gJW2QvPqGidZR9ZUyEf8geVVr6hVLo2S0traMTQ/.5h0U.BSz0.Jm','ROLE_USER','demolala',10702);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (4,'Joshua Bloch','/data/book/4/d748866ea3412a1fb58107f48e7b781b.jpg',119,'1992-10-10','Effective Java',1),(5,'Robert Martin','/data/book/5/11eb252a18738c71703f618c2143c08d.jpg',100,'1875-12-25','Clean Code',1),(6,'Gayle Laakmann McDowell','/data/book/6/105fbad0433a7ef56129c176a5d4ee28.jpg',30,'2009-05-15','Cracking the Coding Interview',1),(7,'Thomas H. Cormen','/data/book/7/ae59717fdd24226216c7254b8cb7ee4d.jpg',169,'2004-10-24','Introduction to Algorithms, 3rd Edition',1),(8,'Giáng Ương','/data/book/8/9846076-1695455703.jpg',123,'2010-02-02','NHÓC CON TU THỰC XUYÊN VỀ RỒI',4),(9,'Y Đái Tuyết','/data/book/9/98fjl0P.png',220,'1999-05-16','TA CÓ BA TRÚC MÃ LÀ LONG NGẠO THIÊN',4),(10,'Fujiko F.Fujio','/data/book/10/doraemon-3368.jpg',85,'2015-06-03','DORAEMON',3),(11,'Trung Ý','/data/book/11/vo-luyen-dinh-phong-9068.jpg',60,'2018-07-12','VÕ LUYỆN ĐỈNH PHONG',4),(12,'Dr. Sigmund Hauck','/data/book/12/tho-san-nha-van.jpg',45,'2019-10-14','THỢ SĂN NHÀ VĂN',4),(13,'Araceli Jaskolski','/data/book/13/kiem-si-thien-tai-cua-hoc-vien.jpg',100,'2020-11-25','KIẾM SĨ THIÊN TÀI CỦA HỌC VIỆN',4),(14,'Dr. Shyanne Hodkiewicz','/data/book/14/5222c1bad7d0fe97659e5cf246ab04ef.jpg',60,'2023-10-15','Conan',5),(15,'Prof. Pat Murphy','/data/book/15/b578c1a5b88c0114add9469ef56ad3b5.jpg',126,'2014-11-26','Shin: Cậu bé bút chì',3),(16,'Fujiko F.Fujio','/data/book/16/b211e4b2a03ca646a4ca76f1067808a7.jpg',104,'2018-10-24','DORAEMON TẬP 38',3),(17,'Hồng Hà','/data/book/17/257c0a116a7a7af935a99197f91f404d.jpg',194,'2019-12-10','Cây Khế',2),(18,'Hồng Hà','/data/book/18/6d8ab121bb398fcf1d2c5961d4908efa.jpg',283,'2017-06-08','Tấm Cám',2),(19,'Hồng Hà','/data/book/19/de5e8142fd7a8215d45324f3048e3723.jpg',312,'2006-06-06','Sọ Dừa',2),(20,'Hiếu Minh','/data/book/20/83d67779f06aa8f95ba10ed74424a682.jpg',412,'2014-11-11','Chiếc Hũ Thần',2),(21,'Hồng Hà','/data/book/21/1da7051a420a142cc347a1b9ca043154.jpg',271,'2019-12-12','Sự Tích Hồ Ba Bể',2),(22,'Prof. Allison Kutch I','/data/book/22/c4e8be033389a37a6c2950a7bbff96d1.jpg',804,'2018-05-29','Kẻ Cô Đơn',52),(23,'Mrs. Britney O\'Connell MD','/data/book/23/0deb60359789c979a20384baeb24a51c.jpg',150,'2017-06-14','Cách làm Leader',52),(24,'Maymie White','/data/book/24/7924455a60b78ffd3f2409ee848dd325.jpg',52,'2018-06-04','Tĩnh Tâm Nơi Công Sở',52),(25,'AIDEN THOMAS','/data/book/25/4792c4819e445b9415fb82a8458b5e08.jpg',534,'2019-08-05','Lost in the never woods',5),(26,'INGRID CHABBERT','/data/book/26/7666840a23cded4a54f7c0c089bce761.jpg',110,'2019-09-24','WAVES',5),(27,'Benton Altenwerth','/data/book/27/13ea7df65697e9ae63176c013c08b98f.jpg',74,'2021-06-27','The woods',5),(28,'Arlo Mante','/data/book/28/d6beb71910b252b8cc7716d70a5ef32e.jpg',285,'2022-04-04','The keeper',5),(29,'Jeanette Bradtke IV','/data/book/29/cefc3e4b2aa04fcd1f25363a6469e791.jpg',84,'2023-05-05','We Could Be Heroes',3),(30,'Shaun Mitchell','/data/book/30/54db2573d0cfd1259d5301451ac7d722.jpg',147,'2023-06-06','LIGHTFALL',5),(31,'Maximilian Jacobi','/data/book/31/193662f00ed6a81c411f7f0d9c3b64bc.jpg',936,'2023-07-07','skeleton man',5),(32,'Jamil Upton','/data/book/32/7a190cdeb9ee68f15589007442e402b6.jpg',308,'2023-07-17','GHOST GIRL',5),(33,'Price Price MD','/data/book/33/73218f5a48683d233894e7ec7f08fe3b.jpg',236,'2023-11-17','BE PREPARED',52),(34,'Mr. Tremayne Yost II','/data/book/34/b54a5e84e1129d317e24afa346c29e83.jpg',344,'2018-11-19','ARTEMIS FOWL',3),(35,'Gussie McDermott','/data/book/35/eeb68d3f21d63c6d9352977a95be6255.jpg',208,'2018-12-19','Phased dynamic securedline',5),(36,'Whitney Schamberger','/data/book/36/66e6049d8782a2ba91b3918a001e3cf5.jpg',244,'2022-12-18','THE WOODS',5),(37,'J.A WHITE','/data/book/37/19e7b21490babaac9fa218d7594f6e90.jpg',514,'2023-10-10','NIGHT BOOKS',5),(38,'Mr. Lindsey Daugherty','/data/book/38/9c490e439ba5ffb68bf06aa23d5ee7be.jpg',151,'2014-10-14','THE LIGHT JAR',5),(39,'Zakary Hane PhD','/data/book/39/131ff9ac054925c8d3f3f1f9d6bcb13f.jpg',258,'2016-12-16','MY JASPER JUNE',1),(40,'Yvette Leannon','/data/book/40/833975049bbfcdab9c65a02cbac011ea.jpg',741,'2017-10-11','Focused dynamic policy',2),(111,'SAGA','/data/book/111/cb43feed35905cc153dd4bb2b2cd6dbf.jpg',102,'2018-12-12','The Wingfeather',3),(118,'Brianne Konopelski','/data/book/118/0a0872e2429e570da784f9dad43adba5.jpg',10,'2023-04-04','Sky Born',4),(119,'Celia Kovacek','/data/book/119/477feb20b6b4dece0b9b1c804e55895b.jpg',150,'2023-05-05','GOLDELINE',52),(120,'Prof. Chandler Ziemann','/data/book/120/8aa48f284619df5d13096c7853c37c00.jpg',123,'2019-10-19','WE ARENT OKAY',52),(123,'pic','/data/book/123/VNNIC_Logo.svg.png',24,'2019-10-20','pic',1),(125,'vnnic','/data/book/125/png-transparent-spider-man-heroes-download-with-transparent-background-free-thumbnail.png',110,'2019-05-08','dns',1),(128,'GAYLE FORMAN','/data/book/128/again.jpg',140,'2023-12-07','Again ',52),(135,'asdad','/data/book/135/again.jpg',123,'2024-02-24','sach abc',5);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Lập Trình'),(2,'Truyện Dân Gian'),(3,'Truyện Cười'),(4,'Tu Tiên'),(5,'Truyện Ma'),(52,'Công sở');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `checkout`
--

LOCK TABLES `checkout` WRITE;
/*!40000 ALTER TABLE `checkout` DISABLE KEYS */;
INSERT INTO `checkout` VALUES (3302,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',465.00,2852),(3303,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',465.00,2852),(5002,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',144.34,3552),(5003,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',144.34,3552),(5004,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',144.34,3552),(5005,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',15.00,3552),(5202,NULL,_binary '\0','2023-12-05','Cash','Đã hủy',417.00,3552),(5203,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',417.00,3552),(5204,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',417.00,3552),(5352,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',321.00,3552),(5353,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',171.34,3552),(5552,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',475.00,3552),(5553,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',15.00,3552),(5554,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',18.17,3552),(5555,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',15.00,3552),(5752,NULL,_binary '\0','2023-12-05','Cash','Chờ xác nhận',18.17,3552),(6002,'2024-01-31',_binary '','2023-12-05','Cash','Đang giao hàng',17.00,3552),(6302,NULL,_binary '\0','2023-12-06','Cash','Đã hủy',19.00,6202),(6552,NULL,_binary '\0','2023-12-06','Cash','Đã hủy',37.00,6452),(6702,NULL,_binary '\0','2023-12-06','Cash','Đã hủy',353.34,6202),(6902,NULL,_binary '\0','2023-12-06','Cash','Đã hủy',200.00,6202),(7102,NULL,_binary '\0','2023-12-06','Cash','Đã hủy',134.17,6202),(7552,NULL,_binary '\0','2023-12-11','Cash','Đã hủy',285.00,7402),(7553,NULL,_binary '\0','2023-12-11','Cash','Đã hủy',115.00,7402),(7902,NULL,_binary '\0','2023-12-12','Cash','Đã hủy',384.00,7802),(7903,NULL,_binary '\0','2023-12-12','Cash','Đã hủy',145.00,7802),(8152,NULL,_binary '\0','2023-12-14','Cash','Đã hủy',145.00,7802),(8452,NULL,_binary '\0','2024-01-11','Cash','Đã hủy',491.00,8352),(9902,NULL,_binary '\0','2024-01-29','Cash','Đã hủy',673.00,8352),(10102,NULL,_binary '\0','2024-01-29','Cash','Đã hủy',115.00,8352),(10402,NULL,_binary '\0','2024-01-31','Cash','Đã hủy',60.00,8352),(10752,'2024-02-01',_binary '','2024-02-01','Cash','Đang giao hàng',115.00,10702);
/*!40000 ALTER TABLE `checkout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `checkout_detail`
--

LOCK TABLES `checkout_detail` WRITE;
/*!40000 ALTER TABLE `checkout_detail` DISABLE KEYS */;
INSERT INTO `checkout_detail` VALUES (3252,2,120,3302),(3253,2,111,3303),(4952,2,4,5002),(4953,1,120,5003),(5152,2,119,5202),(5153,1,111,5203),(5402,3,111,5352),(5403,2,4,5353),(5404,2,5,5353),(5405,1,119,5353),(5602,3,119,5552),(5603,1,118,5552),(5604,1,4,5554),(5802,1,4,5752),(6052,1,123,6002),(6352,2,123,6302),(6602,11,123,6552),(6752,2,4,6702),(6753,1,5,6702),(6952,1,5,6902),(6953,1,10,6902),(7152,1,4,7102),(7602,2,10,7552),(7603,1,5,7552),(7604,1,5,7553),(7952,1,7,7902),(7953,2,5,7902),(7954,1,12,7903),(7955,1,10,7903),(8202,1,5,8152),(8203,1,6,8152),(8502,4,4,8452),(9952,1,8,9902),(9953,1,4,9902),(9954,4,16,9902),(10152,1,5,10102),(10452,1,12,10402),(10802,1,5,10752);
/*!40000 ALTER TABLE `checkout_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (14,'hay xiu',4,152),(15,'rất hay',4,152),(16,'bìa xấu',123,6202),(17,'sach cui bap',4,6452),(18,'Quyển này hay',5,7402),(23,'hay xiu',4,8752),(25,'hello',NULL,NULL),(37,'cute ',8,8352),(38,'hello',4,8352);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `generator_sequence`
--

LOCK TABLES `generator_sequence` WRITE;
/*!40000 ALTER TABLE `generator_sequence` DISABLE KEYS */;
INSERT INTO `generator_sequence` VALUES (1);
/*!40000 ALTER TABLE `generator_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `oder_detail`
--

LOCK TABLES `oder_detail` WRITE;
/*!40000 ALTER TABLE `oder_detail` DISABLE KEYS */;
INSERT INTO `oder_detail` VALUES (802,0.00,852,1,5),(803,91.39,854,3,6),(1602,0.13,1652,1,17),(1702,49226837.77,1752,1,15),(1852,3.17,1902,1,4),(1952,30.46,1753,2,6),(1953,14835.35,1753,1,8),(2002,0.00,1753,1,5),(2252,6.34,2152,2,4),(2402,6.34,2302,2,4),(2602,6.34,2652,2,4),(2953,102.00,2802,2,111),(3202,369.00,3052,3,120),(3203,0.00,3052,1,5),(3602,6.34,3502,2,4),(3603,123.00,3502,1,120),(5102,102.00,5053,1,111),(5103,150.00,5053,2,119),(5302,306.00,5252,3,111),(5303,150.00,5452,1,119),(5304,6.34,5452,2,4),(5305,0.00,5452,2,5),(5502,450.00,5453,3,119),(5503,10.00,5453,1,118),(5504,3.17,5653,1,4),(5702,3.17,5655,1,4),(5952,2.00,5852,1,123),(6252,2.00,6152,2,123),(6502,10.00,6402,11,123),(6652,238.34,6153,2,4),(6653,100.00,6153,1,5),(6852,100.00,6802,1,5),(6853,85.00,6802,1,10),(7052,119.17,7002,1,4),(7503,170.00,7352,2,10),(7504,100.00,7352,1,5),(7505,100.00,7353,1,5),(7852,200.00,7752,2,5),(7854,169.00,7752,1,7),(7855,85.00,7753,1,10),(7856,45.00,7753,1,12),(8052,NULL,NULL,0,NULL),(8102,100.00,7754,1,5),(8103,30.00,7754,1,6),(8104,123.00,8252,1,8),(8402,238.00,8302,4,4),(9802,416.00,8552,4,16),(9803,123.00,8552,1,8),(9852,119.00,8552,1,4),(10052,100.00,10002,1,5),(10353,45.00,10202,1,12),(10602,119.00,9202,3,4),(10603,100.00,10652,1,5);
/*!40000 ALTER TABLE `oder_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_total`
--

LOCK TABLES `order_total` WRITE;
/*!40000 ALTER TABLE `order_total` DISABLE KEYS */;
INSERT INTO `order_total` VALUES (852,0.00),(853,0.00),(854,0.00),(855,0.00),(1652,0.00),(1653,0.00),(1752,0.00),(1753,14896.28),(1902,0.00),(1903,0.00),(1904,0.00),(2152,0.00),(2302,0.00),(2452,0.00),(2652,0.00),(2653,0.00),(2802,450.00),(3052,369.00),(3502,6.34),(5052,0.00),(5053,252.00),(5252,0.00),(5452,156.34),(5453,450.00),(5652,0.00),(5653,0.00),(5654,0.00),(5655,0.00),(5852,125.00),(6102,0.00),(6152,2.00),(6153,238.34),(6402,10.00),(6403,0.00),(6802,100.00),(7002,0.00),(7202,0.00),(7352,170.00),(7353,0.00),(7354,0.00),(7652,0.00),(7752,200.00),(7753,85.00),(7754,100.00),(8252,0.00),(8302,238.00),(8552,539.00),(8702,0.00),(8902,0.00),(9002,0.00),(9003,0.00),(9004,0.00),(9005,0.00),(9006,0.00),(9102,0.00),(9202,119.00),(9302,0.00),(9303,0.00),(9402,0.00),(9403,0.00),(9404,0.00),(9502,0.00),(9602,0.00),(10002,0.00),(10202,0.00),(10502,0.00),(10652,0.00),(10653,0.00);
/*!40000 ALTER TABLE `order_total` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sequence_generator`
--

LOCK TABLES `sequence_generator` WRITE;
/*!40000 ALTER TABLE `sequence_generator` DISABLE KEYS */;
INSERT INTO `sequence_generator` VALUES (10901);
/*!40000 ALTER TABLE `sequence_generator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sequence_gengerator`
--

LOCK TABLES `sequence_gengerator` WRITE;
/*!40000 ALTER TABLE `sequence_gengerator` DISABLE KEYS */;
INSERT INTO `sequence_gengerator` VALUES (1651);
/*!40000 ALTER TABLE `sequence_gengerator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `spring_session`
--

LOCK TABLES `spring_session` WRITE;
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
INSERT INTO `spring_session` VALUES ('018ff3fb-dab8-469a-b116-3d80145eb905','5c155e2d-29c4-4349-b0c1-ffb984f2d388',1708334860918,1708334860918,1800,1708336660918,'demo30'),('21f16688-2c22-42b7-b1e6-97ea61ff7502','2ffea868-aaed-4909-b929-faaa39f62f1c',1708334870422,1708334870422,1800,1708336670422,'demo30'),('395aaaaa-9e33-4005-9c8b-18ea740e1cb4','bb7fb6a1-2a91-4bb1-897d-119ccd2bdcfb',1708334873048,1708334873048,1800,1708336673048,'demo30'),('42543f44-5a90-4288-acc4-afbe58176ad0','1145e257-a17e-4d97-b435-a58e9da98f8a',1708334860458,1708334860458,1800,1708336660458,'demo30'),('6092dbb3-cde6-41c2-acc3-8655e5a86229','8bfa612b-bbe8-4019-9ff5-e328fa69de51',1708334860598,1708334860598,1800,1708336660598,'demo30'),('6dba1b00-b553-40bf-a087-a3504afd1bfe','294d7e60-5c56-4aa3-8f49-30e5a081438f',1708334872077,1708334872077,1800,1708336672077,'demo30'),('af81d8db-e285-46e9-9dd8-ad3132c02fb4','b7b62bd8-6688-4233-b84f-298807d5d712',1708334860918,1708334860918,1800,1708336660918,'demo30'),('bdc1ee14-9806-465a-98b5-3b6a6da02a10','596757e5-b5c2-4af4-a8dc-6ef7820f1557',1708334873050,1708334873050,1800,1708336673050,'demo30');
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `spring_session_attributes`
--

LOCK TABLES `spring_session_attributes` WRITE;
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
INSERT INTO `spring_session_attributes` VALUES ('018ff3fb-dab8-469a-b116-3d80145eb905','SPRING_SECURITY_CONTEXT',_binary '�\�\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0:\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0:\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0:\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERxq\0~\0\rsr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0:\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1ppsr\0*bookstore.app.book.security.UserDetailImpl\�g\�\�{*U�\0L\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0\0\0\0w\0\0\0q\0~\0xt\0<$2a$10$qxeRnOF19hN5.hDhyjFrsea4a69cqbiIhrk4W56sizhv9u7FhEugmt\0demo30'),('21f16688-2c22-42b7-b1e6-97ea61ff7502','SPRING_SECURITY_CONTEXT',_binary '�\�\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0:\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0:\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0:\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERxq\0~\0\rsr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0:\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1ppsr\0*bookstore.app.book.security.UserDetailImpl\�g\�\�{*U�\0L\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0\0\0\0w\0\0\0q\0~\0xt\0<$2a$10$qxeRnOF19hN5.hDhyjFrsea4a69cqbiIhrk4W56sizhv9u7FhEugmt\0demo30'),('395aaaaa-9e33-4005-9c8b-18ea740e1cb4','SPRING_SECURITY_CONTEXT',_binary '�\�\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0:\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0:\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0:\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERxq\0~\0\rsr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0:\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1ppsr\0*bookstore.app.book.security.UserDetailImpl\�g\�\�{*U�\0L\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0\0\0\0w\0\0\0q\0~\0xt\0<$2a$10$qxeRnOF19hN5.hDhyjFrsea4a69cqbiIhrk4W56sizhv9u7FhEugmt\0demo30'),('42543f44-5a90-4288-acc4-afbe58176ad0','SPRING_SECURITY_CONTEXT',_binary '�\�\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0:\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0:\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0:\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERxq\0~\0\rppsr\0*bookstore.app.book.security.UserDetailImpl\�g\�\�{*U�\0L\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0\0\0\0w\0\0\0q\0~\0xt\0<$2a$10$qxeRnOF19hN5.hDhyjFrsea4a69cqbiIhrk4W56sizhv9u7FhEugmt\0demo30'),('6092dbb3-cde6-41c2-acc3-8655e5a86229','SPRING_SECURITY_CONTEXT',_binary '�\�\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0:\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0:\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0:\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERxq\0~\0\rsr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0:\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1ppsr\0*bookstore.app.book.security.UserDetailImpl\�g\�\�{*U�\0L\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0\0\0\0w\0\0\0q\0~\0xt\0<$2a$10$qxeRnOF19hN5.hDhyjFrsea4a69cqbiIhrk4W56sizhv9u7FhEugmt\0demo30'),('6dba1b00-b553-40bf-a087-a3504afd1bfe','SPRING_SECURITY_CONTEXT',_binary '�\�\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0:\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0:\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0:\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERxq\0~\0\rsr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0:\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1ppsr\0*bookstore.app.book.security.UserDetailImpl\�g\�\�{*U�\0L\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0\0\0\0w\0\0\0q\0~\0xt\0<$2a$10$qxeRnOF19hN5.hDhyjFrsea4a69cqbiIhrk4W56sizhv9u7FhEugmt\0demo30'),('af81d8db-e285-46e9-9dd8-ad3132c02fb4','SPRING_SECURITY_CONTEXT',_binary '�\�\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0:\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0:\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0:\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERxq\0~\0\rsr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0:\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1ppsr\0*bookstore.app.book.security.UserDetailImpl\�g\�\�{*U�\0L\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0\0\0\0w\0\0\0q\0~\0xt\0<$2a$10$qxeRnOF19hN5.hDhyjFrsea4a69cqbiIhrk4W56sizhv9u7FhEugmt\0demo30'),('bdc1ee14-9806-465a-98b5-3b6a6da02a10','SPRING_SECURITY_CONTEXT',_binary '�\�\0sr\0=org.springframework.security.core.context.SecurityContextImpl\0\0\0\0\0\0:\0L\0authenticationt\02Lorg/springframework/security/core/Authentication;xpsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0:\0L\0credentialst\0Ljava/lang/Object;L\0	principalq\0~\0xr\0Gorg.springframework.security.authentication.AbstractAuthenticationTokenӪ(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailsq\0~\0xpsr\0&java.util.Collections$UnmodifiableList�%1�\�\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0�\�^�\0L\0cq\0~\0xpsr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0:\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERxq\0~\0\rsr\0Horg.springframework.security.web.authentication.WebAuthenticationDetails\0\0\0\0\0\0:\0L\0\rremoteAddressq\0~\0L\0	sessionIdq\0~\0xpt\00:0:0:0:0:0:0:1ppsr\0*bookstore.app.book.security.UserDetailImpl\�g\�\�{*U�\0L\0authoritiesq\0~\0L\0passwordq\0~\0L\0usernameq\0~\0xpsq\0~\0\0\0\0w\0\0\0q\0~\0xt\0<$2a$10$qxeRnOF19hN5.hDhyjFrsea4a69cqbiIhrk4W56sizhv9u7FhEugmt\0demo30');
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (102,NULL,NULL,NULL,'guest252',NULL,NULL),(152,'vua8@gmail.com','0123456789','male','admin cute',NULL,NULL),(252,'hello@gmail.com','0977157715','female','dep gai co j sai','/data/user/252//data/user/252//data/user/252//data/user/252/anh9.jpg',1753),(1802,'hunglq2908@gmail.com','0349006227','male','Hung Le',NULL,1904),(2052,NULL,NULL,NULL,'guest000452',NULL,NULL),(2202,NULL,NULL,NULL,'guest000502','/data/user/guest.jpg',2152),(2352,'vua8@gmail.com','0349254842','male','demo2','IMG_0605.jpg',NULL),(2502,'','','male','guest000602','/data/user/2502/355796946_1632435763886984_5915910754660568179_n.jpg',NULL),(2852,'','','male','demo4','/data/user/2852/anh7.jpg',2802),(3102,NULL,NULL,NULL,'guest000702','/data/user/guest.jpg',3052),(3552,NULL,NULL,NULL,'guest000752','/data/user/guest.jpg',6102),(6202,'bbxinhgai@gmail.com','0123456789','female','babi xinh gái ','/data/user/6202/nguoi-mau-runway-15.jpg',7202),(6452,'','','male','long tran oc ','/data/user/6452/anh-den.jpg',6403),(7402,'','','male','hihihaha','/data/user/7402/71ee432e21429e47263cad24e8f4fdf1.jpg',7354),(7702,'hunglq2908@gmail.com','0349006227','male','Hung Le','/data/user/7702/avt user.jpg',7652),(7802,'hunglq2908@gmail.com','0123456781','male','give me a chance','/data/user/7802/avt user.jpg',8252),(8352,'soicao50@gmail.com','0123456','male','soicao72','/data/user/8352/Không có tiêu đề.png',10502),(8752,'','','male','guest0001102','/data/user/8752/images.jpg',8702),(8952,NULL,NULL,NULL,'guest0001152','/data/user/guest.jpg',8902),(9052,NULL,NULL,NULL,'guest0001202','/data/user/guest.jpg',9002),(9053,NULL,NULL,NULL,'guest0001203','/data/user/guest.jpg',9003),(9054,NULL,NULL,NULL,'guest0001204','/data/user/guest.jpg',9004),(9055,NULL,NULL,NULL,'guest0001205','/data/user/guest.jpg',9005),(9056,NULL,NULL,NULL,'guest0001206','/data/user/guest.jpg',9006),(9152,NULL,NULL,NULL,'guest0001252','/data/user/guest.jpg',9102),(9252,NULL,NULL,NULL,'guest0001302','/data/user/guest.jpg',9202),(9352,NULL,NULL,NULL,'guest0001352','/data/user/guest.jpg',9302),(9353,NULL,NULL,NULL,'guest0001353','/data/user/guest.jpg',9303),(9452,NULL,NULL,NULL,'guest0001402','/data/user/guest.jpg',9402),(9453,NULL,NULL,NULL,'guest0001403','/data/user/guest.jpg',9403),(9454,NULL,NULL,NULL,'guest0001404','/data/user/guest.jpg',9404),(9552,NULL,NULL,NULL,'guest0001452','/data/user/guest.jpg',9502),(9652,NULL,NULL,NULL,'guest0001502','/data/user/guest.jpg',9602),(10702,'soicao50@gmail.com','0123456','male','guest0001552','/data/user/10702/db_book_store.png',10653);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-19 17:19:00
