create table member(
	id varchar(20) primary key,
    pwd varchar(20) not null,
    name varchar(20) not null,
    phone varchar(20) not null,
    email varchar(20) not null,
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd) on delete cascade
);