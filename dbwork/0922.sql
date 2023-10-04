-- 2023 -09 - 22 ���ν���
create or replace procedure mytest
is
begin
    DBMS_OUTPUT.PUT_LINE('ù ���ν����� ��������!');
end;
/

--mytest ���ν��� ȣ��
exec mytest;

--����2 ���ڸ� ���ڷ� ������ ������ ���
create or replace procedure gugu(dan number)
is
begin
    if dan<2 or dan>9 then
        DBMS_OUTPUT.PUT_LINE('�߸��� ���� �Դϴ� 2~9���հ� �䱸');
    else
        DBMS_OUTPUT.PUT_LINE('***'||dan||'***');
        for a in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(dan||'X'||a||'='||dan*a);
        end loop;
    end if;
end;
/

exec gugu(8);

insert into shop values (seq_shop.nextval,'���̽����콺',23000,'white');

--shop�� sang_color �� Ÿ�� ���� ����
alter table shop modify sang_color varchar2(30);
insert into shop values (seq_shop.nextval,'���̽�����',19000,'red');
insert into shop values (seq_shop.nextval,'üũ����',39000,'rainbow');
insert into shop values (seq_shop.nextval,'ĥ��û����',56000,'blue');
commit;

--����3: ��ǰ���� ���ڷ� ������ �� �ܾ ���Ե� ��� ��ǰ�� ����ϱ�
create or replace procedure find(s_name varchar2)
is
    cursor s1
    is
    select * from shop where sang_name like '%'||s_name||'%';
    
    v_cnt number(2);
begin
    select count(*) into v_cnt from shop where sang_name like '%'||s_name||'%';
    if v_cnt=0 then
        DBMS_OUTPUT.PUT_LINE(s_name||'��ǰ�� ��Ͽ� �����ϴ�');
    else
        DBMS_OUTPUT.PUT_LINE(s_name||'��ǰ ��ȸ�ϱ�');
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('��ǰ��ȣ  ��ǰ��   ����    ����');
        for s in s1 loop
            DBMS_OUTPUT.PUT_LINE(s.sang_no||'  '||s.sang_name||'  '||
            s.sang_price||'  '||s.sang_color);
            exit when s1%notfound;    
        end loop;
    end if;
end;
/
exec find('����');

--���� 4
/*
    exec addupdate('���̽�����','black'); :�ش� ��ǰ�� ������ �߰�
                                        :�ش� ��ǰ�� ������ ���� ����
*/

create or replace procedure addupdate(s_name varchar2,
s_price number, s_color varchar2)
is
    cnt number(10);
begin
    select count(*) into cnt from shop where sang_name =s_name;
    if cnt = 0 then
        insert into shop values(seq_shop.nextval,s_name, s_price, s_color);
        DBMS_OUTPUT.PUT_LINE(s_name || '��ǰ�� �߰��Ǿ����ϴ�');
    else
        update shop set sang_price = s_price, sang_color=s_color where sang_name = s_name;
        DBMS_OUTPUT.PUT_LINE(s_name || '��ǰ�� �����Ǿ����ϴ�');
    end if;
end;
/

exec addupdate('���콺', 10000, 'red'); 
