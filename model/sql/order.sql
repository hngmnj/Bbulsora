create table order_t(
    order_seq integer auto_increment primary key,
	order_cd varchar(20) not null,
    order_qtt integer not null,
    submit_date varchar(20) not null,
    order_date varchar(20) not null,
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd) on delete cascade,
    item_cd varchar(20) not null,
    foreign key (item_cd) references item(item_cd) on delete cascade,
    state_cd varchar(20) not null,
    foreign key (state_cd) references state(state_cd) on delete cascade
);