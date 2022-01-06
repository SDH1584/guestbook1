/******** guestbook 쿼리 ********/

--방명록 시퀀스 삭제
drop sequence seq_guestbook_no;
--방명록 테이블삭제
drop table guestbook;
--방명록 테이블 생성
create table guestbook (
    no number,
    name varchar2(80),
    content varchar2(2000), 
    password varchar2(20),
     reg_date date,
    primary key(no)
);
--방명록 시퀀스 생성
create sequence seq_guestbook_no
increment by 1 
start with 1
nocache;




--방명록 글 등록
insert into guestbook
values(seq_guestbook_no.nextval, '황일영',  '황일영방문했습니다.','1234', sysdate);
insert into guestbook
values(seq_guestbook_no.nextval, '정우성', '안녕!', '1234.',sysdate)
;
commit;


--전체 리스트
select *
from guestbook;

select * from user_sequences;

--delete from guestbook;






