create table big_member(
	id varchar2(500) primary key, 
	pw varchar2(500) not null,
	nick varchar2(500) not null,
	phone varchar2(500) not null
)

insert into BIG_MEMBER values('admin', '1234', '°ü¸®ÀÚ', '010-0000-0000');


select * from BIG_MEMBER;



update BIG_MEMBER
set phone = '010-1111-1234'
where id = 'admin'



delete from BIG_MEMBER
where id = 'admin';



