create table log(
	log_seq integer auto_increment primary key,
    log_content varchar(200) not null,
	item_cd varchar(20) not null,
    foreign key (item_cd) references item(item_cd) on delete cascade,
    state_cd varchar(20) not null,
    foreign key (state_cd) references state(state_cd) on delete cascade,
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd) on delete cascade,
    store_seq integer,
    foreign key (store_seq) references store(store_seq) on delete cascade,
    stock_seq integer,
    foreign key (stock_seq) references stock(stock_seq) on delete cascade,
    dlvry_seq integer,
    foreign key (dlvry_seq) references delivery(dlvry_seq) on delete cascade
);