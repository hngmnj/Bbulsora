create table company(
	comp_cd varchar(20) primary key,
    comp_name varchar(20) not null,
    eng_name varchar(50) not null,
    rep_name varchar(20) not null,
    address varchar(40) not null,
    comp_call varchar(20) not null,
    sort varchar(20) not null
);

create table member(
	id varchar(20) primary key,
    pwd varchar(20) not null,
    name varchar(20) not null,
    phone varchar(20) not null,
    email varchar(20) not null,
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd)
);

create table item(
	item_cd varchar(20) primary key,
    item_name varchar(20) not null,
    major varchar(30) not null,
    middle varchar(30) not null,
    minor varchar(30) not null,
    unit varchar(5) not null,
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd)
);

create table state(
	state_cd varchar(20) primary key,
    state_content varchar(20) not null
);

create table order_t(
    order_seq integer auto_increment primary key,
	order_cd varchar(20) not null,
    order_qtt integer not null,
    submit_date varchar(20) not null,
    order_date varchar(20) not null,
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd),
    item_cd varchar(20) not null,
    foreign key (item_cd) references item(item_cd),
    state_cd varchar(20) not null,
    foreign key (state_cd) references state(state_cd)
);

create table store(
	store_seq integer auto_increment primary key,
    store_qtt integer not null,
    store_date varchar(20) not null,
	state_cd varchar(20) not null,
    foreign key (state_cd) references state(state_cd),
    order_seq integer not null, 
    foreign key (order_seq) references order_t(order_seq)
);

create table delivery(
	dlvry_seq integer auto_increment primary key,
    dlvry_cd varchar(20) not null, 
    dlvry_qtt integer not null,
    req_date varchar(20) not null,
    dlvry_date varchar(20) not null,
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd),
    item_cd varchar(20) not null,
    foreign key (item_cd) references item(item_cd),
    state_cd varchar(20) not null,
    foreign key (state_cd) references state(state_cd)
);
    
create table stock(
	stock_seq integer auto_increment primary key,
    stock_qtt integer not null,
    loc varchar(20) not null,
    lot varchar(20) not null,
    order_seq integer not null,
    foreign key (order_seq) references order_t(order_seq),
	state_cd varchar(20),
    foreign key (state_cd) references state(state_cd)
);

create table board(
	brd_seq integer auto_increment primary key,
    brd_writer varchar(20) not null,
	ctgry varchar(20) not null,
    title varchar(40) not null,
    brd_content varchar(400) not null,
    brd_date varchar(20) default (curdate()) not null,
    filepath varchar(50)
);


create table comment(
	cmnt_seq integer auto_increment primary key,
	cmnt_writer varchar(20) not null,
    cmnt_content varchar(400) not null,
	cmnt_date varchar(20) default (curdate()) not null,
	brd_seq integer not null,
	foreign key (brd_seq) references board(brd_seq)
);

create table log(
	log_seq integer auto_increment primary key,
    log_content varchar(200) not null,
	item_cd varchar(20) not null,
    foreign key (item_cd) references item(item_cd),
    state_cd varchar(20) not null,
    foreign key (state_cd) references state(state_cd),
    comp_cd varchar(20) not null,
    foreign key (comp_cd) references company(comp_cd),
    store_seq integer,
    foreign key (store_seq) references store(store_seq),
    stock_seq integer,
    foreign key (stock_seq) references stock(stock_seq),
    dlvry_seq integer,
    foreign key (dlvry_seq) references delivery(dlvry_seq)
);
