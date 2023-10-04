--angel 계정 연습
--전체 시퀀스 조회
select * from seq;
--sequence 생성
create SEQUENCE seq1 start with 1 INCREMENT by 1;
create SEQUENCE seq2 start with 5 increment by 3 nocache;
create SEQUENCE seq3;

--새로운 시퀀스 하나 생성
create SEQUENCE seq_test nocache;

--table 생성
CREATE TABLE test(
    num number(3) primary key,
    name varchar2(20) not null,
    blood char(2) default 'A',
    weight number(5,2),
    birthday date);

--데이타 추가
--일부만 넣을때,
insert into test (num,name) values (seq_test.nextval,'캔디');

--순서대로 모든 컬럼값을 넣는 경우 컬럼명 생략 가능
insert into test values (seq_test.nextval,'캐서린','AB',67.89,sysdate);

--제약조건에 안맞는 경우 오류 확인 
insert into test (num,name,blood) values (2,'Lee','o');

insert into test values (seq_test.nextval,'강호동','B',78.9,'2000-10-10');
insert into test values (seq_test.nextval,'유재석','A',55.9,'1989-10-10');
insert into test values (seq_test.nextval,'이영자','O',100.9,'1978-10-10');

commit; --더이상 rollback 안댐
--rollback; sql문 (DML:insert,delete,update) 모두 취소

insert into test values (seq_test.nextval,'김말동','B',50.9,'1918-08-20');

--수정, 강호동의 혈액형을 'AB'형으로 수정
update test set blood='AB' where name= '강호동';

update test set weight=80.8,birthday=sysdate where num=18;


delete from test where num in (15,16,17);
rollback;

drop table test;

drop sequence seq_test;
--------------------------------------------------------
create table person (
    num number(3) constraint person_pk_num primary key,
    blood char(2));
    
--기존 제약조건 제거
alter table person drop constraint person_pk_num;

alter table person add constraint person_num_pk primary key(num);

--blood 에 대해서 check 제약조건 추가
alter table person add constraint person_ck_blood check (blood in ('A','B','AB','O'));
-- alter table 테이블명 add constraint
-- 변경 테이블 테이블명 더함 제약 제약조건이름 제약타입 (대상)

INSERT into person VALUES (1,'A');
INSERT into person VALUES (1,'B');
INSERT into person VALUES (2,'b');
INSERT into person VALUES (2,'O');

--컬럼을 추가
alter table person add name varchar2(20);
alter table person add score number(5,1) default 30.6;

--컬럼 제거
alter table person drop column num;

alter table person add java number(3) default 0;
alter table person add constraint person_ck_java check (java>=0 and java<=100);

--컬렴명 변경 rename column
alter table person rename column java to spring;

drop table person;

create TABLE student(
    num number(5),
    name varchar(10),
    height number(5,1),
    java number(3) default 10,
    spring number(3) default 10,
    ban varchar (20)
    );
    
create SEQUENCE seq_stu nocache;

alter table student add constraint student_pk_nu primary key (num);

alter table student add constraint student_ck_ja check (java>=0 and java<=100);
alter table student add constraint student_ck_sp check (spring>=0 and spring<=100);
alter table student add constraint student_ck_ban check (ban in ('햇님반','달님반','별님반'));

INSERT into student VALUES (seq_stu.nextval, '강호동', '175.5', 20, 30, '햇님반');
INSERT into student VALUES (seq_stu.nextval, '유재석', '178.9', 20, 30, '달님반');
INSERT into student VALUES (seq_stu.nextval, '이영자', '165.5', 20, 30, '별님반');
INSERT into student VALUES (seq_stu.nextval, '김종국', '174.2', 20, 30, '달님반');
INSERT into student VALUES (seq_stu.nextval, '송지효', '160.1', 20, 30, '햇님반');

commit;

DELETE from student where num>=4;

update student set java=99, ban ='달님반' where num =3;

update student set height=188.9 where num=2;

DELETE from student where num=2;

INSERT into student VALUES(seq_stu.nextval, '이광수', 195.5, 30, 40, '별님반');
INSERT into student VALUES(seq_stu.nextval, '하하', 160.1, 80, 40, '햇님반');
INSERT into student VALUES(seq_stu.nextval, '양세찬', 162.5, 75, 90, '달님반');

select name, ban, java, spring, java+spring 총점, (java+spring)/2 평균 from student order by (총점)desc;
select sum(java) from student;

