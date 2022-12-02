create table item(
	item_cd varchar(20) primary key,
    item_name varchar(20) not null,
    major varchar(30) not null,
    middle varchar(30) not null,
    minor varchar(30) not null,
    standard varchar(20) not null,
    unit varchar(5) not null,
    img varchar(50),
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd) on delete cascade
);

select * from item;

select * from item
where
item_name like '%바다%';	
