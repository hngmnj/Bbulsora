create table employee(
	emp_no integer primary key,
	name varchar(10) not null,
	birth_date varchar(10) not null,
	phone_num varchar(20) not null,
	email varchar(40) not null,
	gender char(1) not null,
	address varchar(50) not null,
	post_num varchar(10) not null,
	regi_num varchar(20) not null,
	deptmt varchar(10) not null,
	position varchar(10) not null,
	start_date varchar(10) not null,
	end_date varchar(10)
);

drop table employee;
select * from employee;


insert into employee values(1234, 'hmj', '2022-10-05', '01012341234',
'hmj@naver.com', 'F', 'gntp', '12345', '221005123456', 'it',
'idk', '2022-10-05', '2022-10-05');  

insert into employee(emp_no, name, birth_date, phone_num, email, gender, address, 
post_num, regi_num, deptmt, position, start_date) values(5678, 'hmj', '2022-10-05', '01012341234',
'hmj@naver.com', 'F', 'gntp', '12345', '221005123456', 'it',
'idk', '2022-10-05');  

insert into employee(emp_no, name, birth_date, phone_num, email, gender, address, 
post_num, regi_num, deptmt, position, start_date) values(91011, 'bang', '2022-10-05', '0109101112',
'bang@naver.com', 'M', 'changwon-si gntp', '55555', '22100578910', '회계',
'사장', '2022-10-05'); 

insert into employee(emp_no, name, birth_date, phone_num, email, gender, address, 
post_num, regi_num, deptmt, position, start_date) values(121314, 'popo', '2022-10-05', '0109101112',
'bang@naver.com', 'F', 'changwon-si gntp', '55555', '22100578910', '문서관리',
'과장', '2022-10-05'); 