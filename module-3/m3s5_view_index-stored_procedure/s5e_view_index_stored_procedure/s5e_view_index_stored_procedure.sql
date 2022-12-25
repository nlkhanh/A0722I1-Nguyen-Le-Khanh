create database m5e_view_idex_stored_procedure;
use m5e_view_idex_stored_procedure;
create table products (
	id int not null auto_increment primary key,
    product_code varchar(45),
    product_name varchar(45),
    product_price double,
    product_amount int,
    product_description varchar(100),
    product_status varchar(100)
);
insert into products (product_code, product_name, product_price, product_amount, product_description, product_status) values 
('SP01', 'Sản phẩm 01', 120000, 5, 'Mô tả 01', 'Trình trạng 01'),
('SP02', 'Sản phẩm 02', 130000, 1, 'Mô tả 02', 'Trình trạng 02'),
('SP03', 'Sản phẩm 03', 140000, 6, 'Mô tả 03', 'Trình trạng 03'),
('SP04', 'Sản phẩm 04', 150000, 2, 'Mô tả 04', 'Trình trạng 04'),
('SP05', 'Sản phẩm 05', 160000, 8, 'Mô tả 05', 'Trình trạng 05');
select * from products where product_code like 'SP01';
explain select * from products where product_code like 'SP01';
alter table products add unique index idx_code (product_code);
create view product_view as
select product_code, product_name, product_price, product_status from products;
select * from product_view;
create or replace view product_view as
select product_code, product_name, product_price, product_status from products where product_code like 'SP05';
drop view product_view;
delimiter //
create procedure get_all ()
begin
	select * from products;
end //
delimiter ;
call get_all;
delimiter //
create procedure insert_new (in p_code varchar(45), in p_name varchar(45), in p_price double, in p_amount int, in p_description varchar(100), in p_status varchar(100))
begin
	insert into products (product_code, product_name, product_price, product_amount, product_description, product_status) 
    values (p_code, p_name, p_price, p_amount, p_description, p_status);
end //
delimiter ;
call insert_new('SP06', 'Sản phẩm 06', 80000, 3, 'Mô tả 06', 'Trình trạng 06');
delimiter //
create procedure update_record (
	in update_id int
)
begin
	update products set product_price = 245000 where id = update_id;
end //
delimiter ;
call update_record (2);
delimiter //
create procedure delete_record (
	in delete_id int
)
begin
	delete from products where id = delete_id;
end //
delimiter ;
call delete_record(6);

