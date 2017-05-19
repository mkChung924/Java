drop trigger SAL_INFO;
create or replace trigger sal_info
after insert on emp03
for each row
begin
	insert into salary(no, empno, sal) values(salary_seq.nextval, :new.empno, :new.sal);
end;
/

create table salary(
no number,
empno number(4),
sal number(7,2));

drop table product;

create table product(
pcode varchar2(10),
pname varchar(20),
company varchar(20),
price number,
inventory number default 0);

drop table warehouse;
create table warehouse(
no number,
pcode varchar2(10),
pdate date,
stock number,
unitprice number,
price number);

select * from product;

insert into product(pcode, pname, company, price) values('a001', 'mouse', 'samsong', 1000);
insert into product(pcode, pname, company, price) values('a002', 'keyboard', 'samsong', 2000);
insert into product(pcode, pname, company, price) values('a003', 'monitor', 'lg', 3000);
insert into product(pcode, pname, company, price) values('a004', 'monitor2', 'lg', 4000);

create sequence inv_seq
start with 1
increment by 1
nocycle
nocache;

--입고테이블 입력시 상품테이블 업데이트 트리거
create or replace trigger product_insert
after insert on warehouse
for each row
begin
	update product set inventory = :new.stock + inventory where pcode = :new.pcode;
end;
/

insert into warehouse values(inv_seq.nextval, 'a001',sysdate, 10, 1000, 10000);
insert into warehouse values(inv_seq.nextval, 'a002',sysdate, 10, 2000, 20000);
insert into warehouse values(inv_seq.nextval, 'a003',sysdate, 10, 3000, 30000);
insert into warehouse values(inv_seq.nextval, 'a004',sysdate, 10, 4000,0);

--상품테이블 업데이트 트리
create or replace trigger product_update
after update on warehouse
for each row
begin
	update product set inventory = inventory - :old.stock + :new.stock where pcode = :old.pcode;
end;
/

select * from warehouse;
select * from product;

update warehouse set stock = 10 where no = 2;

--//삭제트리거
create or replace trigger product_delete
after delete on warehouse
for each row
begin
	update product set inventory = inventory - :old.stock where pcode = :old.pcode;
end;
/

--[warehouse]테이블의 입고수량과 입고단가의 값에 따라 자동으로 입고금액이 변경되게 해주세요.
create or replace trigger warehouse_price
after update on product
for each row
begin
	--update warehouse set price = :new.stock * :new.unitprice where pcode = :new.pcode;
	update warehouse set price = stock * (select unitprice from warehouse where pcode = :new.pcode) where pcode = :new.pcode;
end;
/

