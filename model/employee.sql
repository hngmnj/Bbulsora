create table employee(
	emp_no integer primary key,
	name varchar(10) not null,
	birth_date datetime not null,
	phone_num varchar(20) not null,
	email varchar(40) not null,
	gender char(1) not null,
	address varchar(50) not null,
	post_num varchar(10) not null,
	regi_num varchar(20) not null,
	deptmt varchar(10) not null,
	position varchar(10) not null,
	start_date datetime not null,
	end_date datetime
)

select * from employee;
