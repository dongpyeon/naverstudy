-- 2023 -09 - 22 프로시저
create or replace procedure mytest
is
begin
    DBMS_OUTPUT.PUT_LINE('첫 프로시저를 만들었어요!');
end;
/

--mytest 프로시저 호출
exec mytest;

--예제2 숫자를 인자로 보내면 구구단 출력
create or replace procedure gugu(dan number)
is
begin
    if dan<2 or dan>9 then
        DBMS_OUTPUT.PUT_LINE('잘못된 숫자 입니다 2~9사잇값 요구');
    else
        DBMS_OUTPUT.PUT_LINE('***'||dan||'***');
        for a in 1..9 loop
            DBMS_OUTPUT.PUT_LINE(dan||'X'||a||'='||dan*a);
        end loop;
    end if;
end;
/

exec gugu(8);

insert into shop values (seq_shop.nextval,'레이스블라우스',23000,'white');

--shop의 sang_color 의 타입 길이 변경
alter table shop modify sang_color varchar2(30);
insert into shop values (seq_shop.nextval,'레이스조끼',19000,'red');
insert into shop values (seq_shop.nextval,'체크조끼',39000,'rainbow');
insert into shop values (seq_shop.nextval,'칠부청바지',56000,'blue');
commit;

--예제3: 상품명을 인자로 보내면 그 단어가 포함된 모든 상품들 출력하기
create or replace procedure find(s_name varchar2)
is
    cursor s1
    is
    select * from shop where sang_name like '%'||s_name||'%';
    
    v_cnt number(2);
begin
    select count(*) into v_cnt from shop where sang_name like '%'||s_name||'%';
    if v_cnt=0 then
        DBMS_OUTPUT.PUT_LINE(s_name||'상품은 목록에 없습니다');
    else
        DBMS_OUTPUT.PUT_LINE(s_name||'상품 조회하기');
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('상품번호  상품명   가격    색상');
        for s in s1 loop
            DBMS_OUTPUT.PUT_LINE(s.sang_no||'  '||s.sang_name||'  '||
            s.sang_price||'  '||s.sang_color);
            exit when s1%notfound;    
        end loop;
    end if;
end;
/
exec find('조끼');

--예제 4
/*
    exec addupdate('레이스조끼','black'); :해당 상품이 없으면 추가
                                        :해당 상품이 있으면 색상 수정
*/

create or replace procedure addupdate(s_name varchar2,
s_price number, s_color varchar2)
is
    cnt number(10);
begin
    select count(*) into cnt from shop where sang_name =s_name;
    if cnt = 0 then
        insert into shop values(seq_shop.nextval,s_name, s_price, s_color);
        DBMS_OUTPUT.PUT_LINE(s_name || '상품이 추가되었습니다');
    else
        update shop set sang_price = s_price, sang_color=s_color where sang_name = s_name;
        DBMS_OUTPUT.PUT_LINE(s_name || '상품이 수정되었습니다');
    end if;
end;
/

exec addupdate('블라우스', 10000, 'red'); 
