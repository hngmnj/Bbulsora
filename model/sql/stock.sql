create table stock(
	stock_seq integer auto_increment primary key,
    stock_qtt integer not null,
    loc varchar(20) not null,
    lot varchar(20) not null,
    order_seq integer not null,
    foreign key (order_seq) references order_t(order_seq) on delete cascade,
	state_cd varchar(20),
    foreign key (state_cd) references state(state_cd) on delete cascade
);