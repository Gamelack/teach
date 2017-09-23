prompt Creating HT_DEPT...
create table HT_DEPT
(
  id      NUMBER(9) not null,
  name    VARCHAR2(100),
  address VARCHAR2(500)
)
;
alter table HT_DEPT
  add constraint PK_DEPT_ID primary key (ID);

prompt Creating HT_RIGHT...
create table HT_RIGHT
(
  id   NUMBER(9) not null,
  name VARCHAR2(50)
)
;
alter table HT_RIGHT
  add constraint PK_RIGHT_ID primary key (ID);

prompt Creating HT_ROLE...
create table HT_ROLE
(
  id       NUMBER(9) not null,
  name     VARCHAR2(20),
  rightids VARCHAR2(100)
)
;
alter table HT_ROLE
  add constraint PK_ROLE_ID primary key (ID);

prompt Creating HT_USER...
create table HT_USER
(
  id         NUMBER(9) not null,
  username   VARCHAR2(100),
  password   VARCHAR2(100),
  registdate DATE,
  deptno     NUMBER(9),
  roleid     NUMBER(9)
)
;
alter table HT_USER
  add constraint PK_USER_ID primary key (ID);
alter table HT_USER
  add constraint FK_USER_DEPT_ID foreign key (DEPTNO)
  references HT_DEPT (ID);
alter table HT_USER
  add constraint FK_USER_ROLE_ID foreign key (ROLEID)
  references HT_ROLE (ID);

prompt Loading HT_DEPT...
prompt Table is empty
prompt Loading HT_RIGHT...
prompt Table is empty
prompt Loading HT_ROLE...
prompt Table is empty
prompt Loading HT_USER...
prompt Table is empty
--序列
CREATE OR REPLACE TRIGGER "HT_OA"."HT_USER_TRIGGER" 
  before insert
  on ht_user 
  for each row
declare
  -- local variables here
begin
  select ht_user_id_seq.nextval into:new.id from dual;
end ht_user_trigger;

CREATE OR REPLACE TRIGGER "HT_OA"."HT_ROLE_TRIGGER" 
  before insert
  on ht_role
  for each row
declare
  -- local variables here
begin
  select ht_role_id_seq.nextval into:new.id from dual;
end ht_role_trigger;


CREATE OR REPLACE TRIGGER "HT_OA"."HT_RIGHT_TRIGGER" 
  before insert
  on ht_right 
  for each row
declare
  -- local variables here
begin
  select ht_right_id_seq.nextval into:new.id from dual;
end ht_right_trigger;



--触发器
create or replace trigger ht_user_trigger
  before insert
  on ht_user 
  for each row
declare
  -- local variables here
begin
  select ht_user_id_seq.nextval into:new.id from dual;
end ht_user_trigger;

create or replace trigger ht_role_trigger
  before insert
  on ht_role 
  for each row
declare
  -- local variables here
begin
  select ht_role_id_seq.nextval into:new.id from dual;
end ht_role_trigger;

create or replace trigger ht_right_trigger
  before insert
  on ht_right 
  for each row
declare
  -- local variables here
begin
  select ht_right_id_seq.nextval into:new.id from dual;
end ht_right_trigger;
