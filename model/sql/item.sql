create table item(
	item_cd varchar(20) primary key,
    item_name varchar(20) not null,
    major varchar(30) not null,
    middle varchar(30) not null,
    minor varchar(30) not null,
    unit varchar(5) not null,
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd) on delete cascade
);