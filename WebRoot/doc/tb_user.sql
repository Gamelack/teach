prompt Creating USER_RIGHT...
create table USER_RIGHT
(
  id   NUMBER,
  name VARCHAR2(20)
)
;
alter table USER_RIGHT
  add constraint USER_RIGHT_ID unique (ID);

prompt Creating USER_INFO...
create table USER_INFO
(
  id         NUMBER not null,
  username   VARCHAR2(20),
  password   VARCHAR2(20),
  sex        VARCHAR2(20),
  registdate DATE,
  right_id   NUMBER
)
;
alter table USER_INFO
  add constraint PK_USERINFO_ID primary key (ID);
alter table USER_INFO
  add constraint FK_USERRIGHT_ID foreign key (RIGHT_ID)
  references USER_RIGHT (ID);

prompt Loading USER_RIGHT...
insert into USER_RIGHT (id, name)
values (1, '管理员');
insert into USER_RIGHT (id, name)
values (2, '游客');
insert into USER_RIGHT (id, name)
values (3, '青铜会员');
insert into USER_RIGHT (id, name)
values (4, '白银会员');
insert into USER_RIGHT (id, name)
values (5, '黄金会员');
insert into USER_RIGHT (id, name)
values (6, '砖石会员');
insert into USER_RIGHT (id, name)
values (7, '白金');
insert into USER_RIGHT (id, name)
values (8, '王者');
insert into USER_RIGHT (id, name)
values (9, '主宰');
commit;
prompt 9 records loaded
prompt Loading USER_INFO...
insert into USER_INFO (id, username, password, sex, registdate, right_id)
values (22, 'admin', 'admin', 'boy', to_date('05-09-2017', 'dd-mm-yyyy'), 1);
commit;
prompt 1 records loaded
CREATE SEQUENCE  "LIBAI3"."USERINFO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

CREATE OR REPLACE TRIGGER "LIBAI3"."USERINFO_TRI" 
  before insert
  on user_info 
  for each row
declare
  -- local variables here
begin
  select userinfo_seq.nextval into:new.id from dual;
end userinfo_tri;