/******** guestbook ���� ********/

--���� ������ ����
drop sequence seq_guestbook_no;
--���� ���̺����
drop table guestbook;
--���� ���̺� ����
create table guestbook (
    no number,
    name varchar2(80),
    content varchar2(2000), 
    password varchar2(20),
     reg_date date,
    primary key(no)
);
--���� ������ ����
create sequence seq_guestbook_no
increment by 1 
start with 1
nocache;




--���� �� ���
insert into guestbook
values(seq_guestbook_no.nextval, 'Ȳ�Ͽ�',  'Ȳ�Ͽ��湮�߽��ϴ�.','1234', sysdate);
insert into guestbook
values(seq_guestbook_no.nextval, '���켺', '�ȳ�!', '1234.',sysdate)
;
commit;


--��ü ����Ʈ
select *
from guestbook;

select * from user_sequences;

--delete from guestbook;






