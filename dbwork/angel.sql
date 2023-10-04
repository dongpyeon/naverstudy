--angel ���� ����
--��ü ������ ��ȸ
select * from seq;
--sequence ����
create SEQUENCE seq1 start with 1 INCREMENT by 1;
create SEQUENCE seq2 start with 5 increment by 3 nocache;
create SEQUENCE seq3;

--���ο� ������ �ϳ� ����
create SEQUENCE seq_test nocache;

--table ����
CREATE TABLE test(
    num number(3) primary key,
    name varchar2(20) not null,
    blood char(2) default 'A',
    weight number(5,2),
    birthday date);

--����Ÿ �߰�
--�Ϻθ� ������,
insert into test (num,name) values (seq_test.nextval,'ĵ��');

--������� ��� �÷����� �ִ� ��� �÷��� ���� ����
insert into test values (seq_test.nextval,'ĳ����','AB',67.89,sysdate);

--�������ǿ� �ȸ´� ��� ���� Ȯ�� 
insert into test (num,name,blood) values (2,'Lee','o');

insert into test values (seq_test.nextval,'��ȣ��','B',78.9,'2000-10-10');
insert into test values (seq_test.nextval,'���缮','A',55.9,'1989-10-10');
insert into test values (seq_test.nextval,'�̿���','O',100.9,'1978-10-10');

commit; --���̻� rollback �ȴ�
--rollback; sql�� (DML:insert,delete,update) ��� ���

insert into test values (seq_test.nextval,'�踻��','B',50.9,'1918-08-20');

--����, ��ȣ���� �������� 'AB'������ ����
update test set blood='AB' where name= '��ȣ��';

update test set weight=80.8,birthday=sysdate where num=18;


delete from test where num in (15,16,17);
rollback;

drop table test;

drop sequence seq_test;
--------------------------------------------------------
create table person (
    num number(3) constraint person_pk_num primary key,
    blood char(2));
    
--���� �������� ����
alter table person drop constraint person_pk_num;

alter table person add constraint person_num_pk primary key(num);

--blood �� ���ؼ� check �������� �߰�
alter table person add constraint person_ck_blood check (blood in ('A','B','AB','O'));
-- alter table ���̺�� add constraint
-- ���� ���̺� ���̺�� ���� ���� ���������̸� ����Ÿ�� (���)

INSERT into person VALUES (1,'A');
INSERT into person VALUES (1,'B');
INSERT into person VALUES (2,'b');
INSERT into person VALUES (2,'O');

--�÷��� �߰�
alter table person add name varchar2(20);
alter table person add score number(5,1) default 30.6;

--�÷� ����
alter table person drop column num;

alter table person add java number(3) default 0;
alter table person add constraint person_ck_java check (java>=0 and java<=100);

--�÷Ÿ� ���� rename column
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
alter table student add constraint student_ck_ban check (ban in ('�޴Թ�','�޴Թ�','���Թ�'));

INSERT into student VALUES (seq_stu.nextval, '��ȣ��', '175.5', 20, 30, '�޴Թ�');
INSERT into student VALUES (seq_stu.nextval, '���缮', '178.9', 20, 30, '�޴Թ�');
INSERT into student VALUES (seq_stu.nextval, '�̿���', '165.5', 20, 30, '���Թ�');
INSERT into student VALUES (seq_stu.nextval, '������', '174.2', 20, 30, '�޴Թ�');
INSERT into student VALUES (seq_stu.nextval, '����ȿ', '160.1', 20, 30, '�޴Թ�');

commit;

DELETE from student where num>=4;

update student set java=99, ban ='�޴Թ�' where num =3;

update student set height=188.9 where num=2;

DELETE from student where num=2;

INSERT into student VALUES(seq_stu.nextval, '�̱���', 195.5, 30, 40, '���Թ�');
INSERT into student VALUES(seq_stu.nextval, '����', 160.1, 80, 40, '�޴Թ�');
INSERT into student VALUES(seq_stu.nextval, '�缼��', 162.5, 75, 90, '�޴Թ�');

select name, ban, java, spring, java+spring ����, (java+spring)/2 ��� from student order by (����)desc;
select sum(java) from student;

