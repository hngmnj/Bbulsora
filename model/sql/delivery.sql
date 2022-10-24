create table delivery(
	dlvry_seq integer auto_increment primary key,
    dlvry_cd varchar(20) not null, 
    dlvry_qtt integer not null,
    req_date varchar(20) not null,
    dlvry_date varchar(20) not null,
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd) on delete cascade,
    item_cd varchar(20) not null,
    foreign key (item_cd) references item(item_cd) on delete cascade,
    state_cd varchar(20) not null,
    foreign key (state_cd) references state(state_cd) on delete cascade
);