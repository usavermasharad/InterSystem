
-- Edge data 


insert into Traffic values(1,'A','B',0.44,'sharad',sysdate());

insert into Traffic values(2,'A','c',1.89,'sharad',sysdate());

insert into Traffic values(3,'A','d',0.44,'sharad',sysdate());

insert into Traffic values(4,'B','H',2.44,'sharad',sysdate());
insert into Traffic values(5,'B','E',0.44,'sharad',sysdate());

insert into Traffic values(6,'C','F',1.89,'sharad',sysdate());
insert into Traffic values(7,'D','L',0.44,'sharad',sysdate());

insert into Traffic values(8,'D','M',2.61,'sharad',sysdate());


insert into Traffic values(9,'H','G',0.44,'sharad',sysdate());

insert into Traffic values(10,'E','I',1.89,'sharad',sysdate());

insert into Traffic values(11,'F','J',0.44,'sharad',sysdate());

insert into Traffic values(12,'F','K',2.44,'sharad',sysdate());
insert into Traffic values(13,'G','Z',0.44,'sharad',sysdate());

insert into Traffic values(14,'I','Z',1.89,'sharad',sysdate());
insert into Traffic values(15,'I','J',0.44,'sharad',sysdate());

insert into Traffic values(16,'L','T',1.89,'sharad',sysdate());


insert into Traffic values(17,'T','G',0.44,'sharad',sysdate());
insert into Traffic values(18,'T','I',1.89,'sharad',sysdate());
insert into Traffic values(19,'S','J',0.44,'sharad',sysdate());
insert into Traffic values(20,'O','K',2.44,'sharad',sysdate());
insert into Traffic values(21,'J','Z',0.44,'sharad',sysdate());
insert into Traffic values(22,'R','Z',1.89,'sharad',sysdate());
insert into Traffic values(23,'R','J',0.44,'sharad',sysdate());
insert into Traffic values(24,'Z','T',1.89,'sharad',sysdate());


insert into Traffic values(25,'Z','Y',0.44,'sharad',sysdate());
insert into Traffic values(26,'Y','Q',1.89,'sharad',sysdate());
insert into Traffic values(27,'Q','X',0.44,'sharad',sysdate());
insert into Traffic values(28,'L+','X+',2.44,'sharad',sysdate());
insert into Traffic values(29,'X','K+',0.44,'sharad',sysdate());
insert into Traffic values(30,'P','U',1.89,'sharad',sysdate());
insert into Traffic values(31,'U','J+',0.44,'sharad',sysdate());
insert into Traffic values(32,'U','K+',1.89,'sharad',sysdate());

insert into Traffic values(33,'k+','V',0.44,'sharad',sysdate());
insert into Traffic values(34,'J+','I+',1.89,'sharad',sysdate());
insert into Traffic values(35,'Y','A+',0.44,'sharad',sysdate());
insert into Traffic values(36,'A+','B+',2.44,'sharad',sysdate());
insert into Traffic values(37,'B+','C+',0.44,'sharad',sysdate());
insert into Traffic values(38,'K+','W',1.89,'sharad',sysdate());
insert into Traffic values(39,'W','C+',0.44,'sharad',sysdate());
insert into Traffic values(40,'W','D+',1.89,'sharad',sysdate());



insert into Traffic values(41,'C+','D+',2.44,'sharad',sysdate());
insert into Traffic values(42,'E+','E+',0.44,'sharad',sysdate());
insert into Traffic values(43,'E+','F+',1.89,'sharad',sysdate());
insert into Traffic values(44,'F+','G+',0.44,'sharad',sysdate());


insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(17,'T','G',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(18,'T','I',1.89,2.44,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(19,'S','J',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(20,'O','K',2.44,3.44,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(21,'J','Z',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(22,'R','Z',1.89,2.44,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(23,'R','J',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(24,'Z','T',1.89,2.44,'',sysdate());


insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(25,'Z','Y',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(26,'Y','Q',1.89,2.44,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(27,'Q','X',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(28,'L+','X+',2.44,3.55,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(29,'X','K+',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(30,'P','U',1.89,2.44,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(31,'U','J+',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(32,'U','K+',1.89,2.44,'',sysdate());

insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(33,'k+','V',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(34,'J+','I+',1.89,2.44,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(35,'Y','A+',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(36,'A+','B+',2.44,4.55,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(37,'B+','C+',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(38,'K+','W',1.89,2.44,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(39,'W','C+',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(40,'W','D+',1.89,2.44,'',sysdate());



insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(41,'C+','D+',2.44,5.66,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(42,'E+','E+',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(43,'E+','F+',1.89,2.44,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(44,'F+','G+',0.44,1.22,'',sysdate());
insert into Edge(edge_id,source,destination,distance,time_delay,update_by,update_timestamp) values(45,'G+','H+',1.89,2.44,'',sysdate());

insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(1,'A','Earth','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(2,'B','Moon','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(3,'C','Jupiter','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(4,'D','Venus','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(5,'E','Mars','sharad',sysdate());

insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(6,'F','Saturn','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(7,'G','Uranus','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(8,'H','Pluto','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(9,'I','Neptune','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(10,'J','Mercury','sharad',sysdate());


insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(11,'K','Alpha Centauri','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(12,'L','Luhman 16','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(13,'M','Epsilon Eridani','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(14,'N','Groombridge 34','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(15,'O','Epsilon Indi','sharad',sysdate());



insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(16,'P','Tau Ceti','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(17,'Q','Kapteyn star','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(18,'R','Gliese 687','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(19,'S','Gliese 674','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(20,'T','Gliese 876#','sharad',sysdate());


insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(21,'U','Gliese 832','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(22,'V','Fomalhaut','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(23,'W','Virginis','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(24,'X','HD 102365','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(25,'Y','Gliese 176','sharad',sysdate());


insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(26,'Z','Gliese 832','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(27,'A+','Pollux','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(28,'B+','Gliese 86','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(29,'C+','HIP 57050','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(30,'D+','Piscium','sharad',sysdate());

insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(31,'E+','GJ 1214','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(32,'F+','Upsilon Andromedae','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(33,'G+','Gamma Cephei','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(34,'H+','HD 176051','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(35,'I+','Gliese 317','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(36,'J+','HD 38858','sharad',sysdate());
insert into Vertice(id,vertice_id,vertice_name,update_by,update_date) values(37,'K+','Ursae Majoris','sharad',sysdate());;