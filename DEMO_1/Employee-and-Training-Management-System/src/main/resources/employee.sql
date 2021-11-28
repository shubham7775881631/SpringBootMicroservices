#2.For Microservice->Employee-Training-Management-System
SELECT * FROM employeetrainingmanagementsystem.employee;

create table employee(
emp_id int  primary key, 
name varchar(45) ,
course_name varchar(45) ,
course_code varchar(3) ,
score int ,
hours_spent int );

insert into employee values(102,'cary','Information Technology',	IT,	88,	57);
insert into employee values(103	,'hary',	'Computer Science'	,'CSE'	,87,	65);
insert into employee values(105	,'jerry',	'Computer Science'	,CSE	,86,	85);
insert into employee values(106	,'laty'	,'Computer Science'	,'CSE',	77,	65);
insert into employee values(107,	'cramy',	'Computer Science',	'CSE'	,77,	78);
insert into employee values(108,	'sandy',	'Information Technology'	,'IT',	44,	95);
insert into employee values(109	,'pity'	,'Information Technology',	'IT',	66,	45);
insert into employee values(110,	'lomt',	'Information Technology'	,'IT',	92,	75);
insert into employee values(111,	'gary',	'Information Technology'	,'IT'	,58,	92);
insert into employee values(112,	'jimmy',	'Information Technology'	,'IT',	75,	47);
insert into employee values(113,	'lotun',	'Information Technology'	,'IT',	81,	85);
insert into employee values(114,	'marry',	'Computer Science'	,'CSE',	79,	59);
insert into employee values(115,	'jatty',	'Computer Science'	,'CSE',	65,	77);
insert into employee values(116,	'irony',	'Computer Science'	,'CSE',	72	,85);
insert into employee values(117,	'pitty',	'Information Technology',	'IT',	74,	54);
insert into employee values(118	,'lucy',	'Computer Science',	'CSE'	,57	,85);
insert into employee values(119,	'parker',	'Information Technology'	,'IT'	,71	,87);
insert into employee values(120,	'gimmy',	'Computer Science',	'CSE',	79,	83);
insert into employee values(121	,'quliy'	,'Information Technology'	,'IT'	,73	,86);
insert into employee values(122	,'Iron Man',	'Computer Technology',	'CT',	82,	177);
insert into employee values(123	,'Thor',	'Electronics'	,'BT'	,77,	187);
insert into employee values(124	,'Charls',	'CDC',	'CSE',	85,	162);
insert into employee values(125	,'Charls'	,'CDC',	'CSE',	85	,162);
insert into employee values(127	,'Charls'	,'CDC',	'CSE',	85,	162);
insert into employee values(187	,'Charls'	,'CDC',	'CSE',	85,	162);
insert into employee values(197	,'Charls'	,'CDC',	'CSE'	,85	,162);
insert into employee values(777	,'Charls','MVC',	'CSE',	85	,162);
