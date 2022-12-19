use s2e_sales_management;
insert into customer (c_name, c_age)
values ('Minh Quan', 10),
		('Ngoc Anh', 20),
		('Hong Ha', 50);
insert into `order` (c_id, o_date)
values (1, '2006-3-21'),
		(2, '2006-3-23'),
        (1, '2006-3-16');
insert into product (p_name, p_price)
values ('May Giat', 3),
		('Tu Lanh', 5),
		('Dieu Hoa', 7),
		('Quat', 1),
		('Bep Dien', 2);
insert into order_product (o_id, p_id, o_amount)
values (1, 1, 3),
		(1, 3, 7),
        (1, 4, 2),
        (2, 1, 1),
        (3, 1, 8),
        (2, 5, 4),
        (2, 3, 3);
select o.o_id, o_date, p_name, o_amount, p_price, p_price*o_amount as cost
from `order` o
inner join order_product op on o.o_id = op.o_id
inner join product p on op.p_id = p.p_id;
select c_name, c_age, `order`.o_id, p_name, o_amount
from customer
inner join `order` on customer.c_id = `order`.c_id
inner join order_product on `order`.o_id = order_product.o_id
inner join product on order_product.p_id = product.p_id;
select c_name, c_age, o_id
from customer
left join `order` on customer.c_id = `order`.c_id
where o_id is null;
select o.o_id, o_date, sum(p.p_price * o_amount) as total_price
from `order` o
inner join order_product op on o.o_id = op.o_id
inner join product p on op.p_id = p.p_id
group by o.o_id;