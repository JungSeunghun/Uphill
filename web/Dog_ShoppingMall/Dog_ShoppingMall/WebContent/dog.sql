drop table dog;
/*
 * (예) 비교를 위해 "임초롱초롱빛나라"를 name1, name2로 저장하면
 * 1. name1 varchar2(20) : 길이의 의미가 바이트 개수
 *    ▶한글 8자리 * 3 = 24bytes이므로 길이 초과로 저장할 수 없다.
 * 
 * 2. name2 nvarchar2(20) : 길이의 의미가 "문자 개수"
 *    ▶한글 8자리를 저장하고 추가로 12자리를 더 저장할 수 있다.
 * 
 */
create table dog(
	id number primary key, --상품아이디(Mysql에서는 auto_increment로 자동 1 증가)
	kind nvarchar2(20) not null, --개품종
	price number not null, --개 가격
	image nvarchar2(40) not null, --개 이미지	
	country nvarchar2(20) not null, --원산지
	height number, --평균 개 신장
	weight number, --평균 개 체중
	content nvarchar2(400), --개 설명
	readcount number --조회수
);

--오라클에서는 직접 sequence 생성하여 사용함
create sequence dog_seq; --시작 1, 증가 1

insert into dog values(dog_seq.nextval,'푸들',1000,'pu.jpg','프랑스',1,20,'털많다',0);
insert into dog values(dog_seq.nextval,'불독',2000,'bul.jpg','독일',1,20,'못생겼다',0);
insert into dog values(dog_seq.nextval,'진도개',3000,'jin.jpg','대한민국',1,20,'최고다',0);
insert into dog values(dog_seq.nextval,'허스키',4000,'h.jpg','북극',1,20,'멋지다',0);

---------------------------------------------------------------------------
--MySQL
create table dog(
	id int auto_increment primary_key, /*상품아이디(Mysql에서는 auto_increment로 자동 1 증가)*/
	kind nvarchar2(20) not null, /*개품종*/
	price int not null, /*개 가격*/
	image nvarchar2(40) not null, /*개 이미지*/
	country nvarchar2(20) not null, /*원산지*/
	height int, /*평균 개 신장*/
	weight int, /*평균 개 체중*/
	content nvarchar2(400), /*개 설명*/
	readcount int /*조회수*/
);

/*id는 자동 1증가 됨으로 insert에서 제외*/
insert into dog(kind, country, price, height, weight, content, image, readcount)
values('푸들',1000,'pu.jpg','프랑스',1,20,'털많다',0);
insert into dog(kind, country, price, height, weight, content, image, readcount)
values('불독',2000,'bul.jpg','독일',1,20,'못생겼다',0);
insert into dog(kind, country, price, height, weight, content, image, readcount)
values('진도개',3000,'jin.jpg','대한민국',1,20,'최고다',0);
insert into dog(kind, country, price, height, weight, content, image, readcount)
values('허스키',4000,'h.jpg','북극',1,20,'멋지다',0);




