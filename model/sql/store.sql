create table store(
	store_seq integer auto_increment primary key,
    store_qtt integer not null,
    store_date varchar(20) not null,
    from_date varchar(20),
    to_date varchar(20),
	state_cd varchar(20) not null,
    foreign key (state_cd) references state(state_cd) on delete cascade,
    order_seq integer not null, 
    foreign key (order_seq) references order_t(order_seq) on delete cascade
);