create table comment(
	cmnt_seq integer auto_increment primary key,
	cmnt_writer varchar(20) not null,
    cmnt_content varchar(400) not null,
	cmnt_date varchar(20) default (curdate()) not null,
	brd_seq integer not null,
	foreign key (brd_seq) references board(brd_seq) on delete cascade
);
