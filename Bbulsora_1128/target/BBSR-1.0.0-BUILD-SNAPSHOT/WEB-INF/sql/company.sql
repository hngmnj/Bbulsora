create table company(
	comp_cd varchar(20) primary key,
    comp_name varchar(20) not null,
    eng_name varchar(50) not null,
    rep_name varchar(20) not null,
    address varchar(40) not null,
    comp_call varchar(20) not null,
    sort varchar(20) not null
);

select * from company;

insert into company 
values('admin', '뿔소라', 'Bbulsora', '관리자', '창원 경남테크노파크 502호', '01000000000', 'admin');
