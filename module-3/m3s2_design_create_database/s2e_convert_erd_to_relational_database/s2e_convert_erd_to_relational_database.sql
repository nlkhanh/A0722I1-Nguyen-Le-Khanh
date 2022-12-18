create database s2e_product_management;
use s2e_product_management;
create table supplier (
	sup_id int not null auto_increment primary key,
    sup_name varchar(50) not null,
    sup_address varchar(100)
);
create table phone (
	phone_number varchar(10),
    sup_id int not null,
    foreign key (sup_id) references supplier(sup_id)
);
create table `order` (
	order_id int not null auto_increment primary key,
    order_date datetime not null,
    sup_id int not null,
    foreign key(sup_id) references supplier(sup_id)
);
create table supply(
	supply_id int not null auto_increment primary key,
    supply_name varchar(50) not null
);
create table enter_coupon (
	enter_coupon_id int not null auto_increment primary key,
    enter_coupon_date datetime not null
);
create table bill (
	bill_id int not null auto_increment primary key,
    bill_date datetime not null
);
create table bill_detail (
	bill_id int not null,
    supply_id int not null,
    export_unit_price int not null,
    export_number int not null,
    primary key (bill_id, supply_id),
    foreign key (bill_id) references bill(bill_id),
    foreign key (supply_id) references supply(supply_id)
);
create table enter_coupon_detail (
	enter_coupon_id int not null,
    supply_id int not null,
    enter_unit_price int not null,
    enter_number int not null,
    primary key (enter_coupon_id, supply_id),
    foreign key (enter_coupon_id) references enter_coupon(enter_coupon_id),
    foreign key (supply_id) references supply(supply_id)
);
create table order_detail(
	order_id int not null,
    supply_id int not null,
    primary key (order_id, supply_id),
    foreign key (order_id) references `order`(order_id),
    foreign key (supply_id) references supply(supply_id)
);
