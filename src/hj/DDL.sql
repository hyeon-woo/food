-- 유저 테이블 생성
Create table users(
  userno VARCHAR2(13) Constraint pk_muser PRIMARY KEY,
  username VARCHAR2(20) CONSTRAINT nn_username NOT NULL,
  useremail VARCHAR2(60) CONSTRAINT nn_useremail NOT NULL,
  usernum VARCHAR2(13) CONSTRAINT nn_usernum NOT NULL,
  useraddr VARCHAR2(60) CONSTRAINT nn_useraddr NOT NULL,
  userpw VARCHAR2(20) CONSTRAINT nn_userpw NOT NULL
);

-- 메뉴 테이블 생성
Create table menu(
  menuno VARCHAR2(13) CONSTRAINT pk_menu PRIMARY KEY,
  menulist VARCHAR2(2000) CONSTRAINT nn_menulist NOT NULL,
  menuinfo VARCHAR2(2000) CONSTRAINT nn_menuinfo NOT NULL,
  menuname VARCHAR2(40) CONSTRAINT nn_menuname NOT NULL
);


-- 관리자 테이블 생성
Create table admin(
  adminno VARCHAR2(13) CONSTRAINT pk_admin PRIMARY KEY ,
  adminname VARCHAR2(20) CONSTRAINT nn_adminname NOT NULL ,
  adminemail VARCHAR2(60) CONSTRAINT nn_adminemail NOT NULL ,
  adminnum VARCHAR2(13) CONSTRAINT nn_adminnum NOT NULL ,
  adminaddr VARCHAR2(60) CONSTRAINT nn_adminaddr NOT NULL,
  adminpw VARCHAR2(20) CONSTRAINT nn_adminpw NOT NULL
);

-- 업체 테이블 생성
create table company(
  comno VARCHAR2(13) CONSTRAINT pk_company PRIMARY KEY ,
  comnum VARCHAR2(13) CONSTRAINT nn_comnum NOT NULL ,
  comname VARCHAR2(40) CONSTRAINT nn_comname NOT NULL ,
  comemail VARCHAR2(60) CONSTRAINT nn_comemail NOT NULL,
  compw VARCHAR2(20) CONSTRAINT nn_compw NOT NULL
);




-- 주문 테이블 생성
CREATE table orders(
  orderno VARCHAR2(13) CONSTRAINT pk_order PRIMARY KEY,
  menuno varchar2(13) CONSTRAINT fk_menu_To_order REFERENCES menu(menuno) NOT NULL ,
  delinfo VARCHAR2(100) CONSTRAINT nn_delinfo NOT NULL,
  billinfo VARCHAR2(100) CONSTRAINT nn_billinfo NOT NULL,
  comno VARCHAR2(13) CONSTRAINT fk_company_To_order REFERENCES company(comno) NOT NULL,
  ordervalue NUMBER(10) CONSTRAINT nn_ordervalue NOT NULL,
  adminno VARCHAR2(13) CONSTRAINT fk_admin_To_order REFERENCES admin(adminno),
  userno VARCHAR2(13) CONSTRAINT fk_users_To_order REFERENCES users(userno)
);




-- 관련 시퀀스 생성
create SEQUENCE sq_users nocache;
create SEQUENCE sq_admin NOCACHE;
create SEQUENCE sq_company NOCACHE;
create SEQUENCE sq_orders NOCACHE;








create view UOA as select * from orders join users using (userno) join admin using (adminno) with READ ONLY;
create view UOM as select * from orders join users using (userno) join menu using (menuno) with READ ONLY;
create view UOC as select * from orders join users using (userno) join company using (comno) with READ ONLY;
create view AOC as select * from orders join admin using (adminno) join company using (comno) with READ ONLY;
create view MOA as select * from orders join menu using (menuno) join admin using (adminno) with READ ONLY;
create view MOC as select * from orders join menu using (menuno) join company using (comno) with READ ONLY;



commit;



SELECT  * from users;
