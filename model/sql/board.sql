create table board(
	brd_seq integer auto_increment primary key,
    brd_writer varchar(20) not null,
	category varchar(20) not null,
    title varchar(40) not null,
    brd_content varchar(400) not null,
    brd_date varchar(20) default (curdate()) not null,
    filepath varchar(50)
);