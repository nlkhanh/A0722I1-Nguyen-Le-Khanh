drop database m3_case_study_database;
create database m3_case_study_database;
use m3_case_study_database;
create table vi_tri (
	ma_vi_tri int not null primary key,
    ten_vi_tri varchar(45)
);
create table trinh_do (
	ma_trinh_do int not null primary key,
    ten_trinh_do varchar(45)
);
create table bo_phan (
	ma_bo_phan int not null primary key,
    ten_bo_phan varchar(45)
);
create table nhan_vien (
	ma_nhan_vien int not null primary key,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(45),
    luong double,
    so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    ma_vi_tri int,
    ma_trinh_do int,
    ma_bo_phan int,
    foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
    foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
    foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);
create table loai_khach (
	ma_loai_khach int not null primary key,
    ten_loai_khach varchar(45)
);
create table khach_hang (
	ma_khach_hang int not null primary key,
    ho_ten varchar(45),
    ngay_sinh date,
    gioi_tinh bit(1),
	so_cmnd varchar(45),
	so_dien_thoai varchar(45),
    email varchar(45),
    dia_chi varchar(45),
	ma_loai_khach int,
    foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);
create 	table kieu_thue (
	ma_kieu_thue int not null primary key,
    ten_kieu_thue varchar(45)
);
create table loai_dich_vu (
	ma_loai_dich_vu int not null primary key,
    ten_loai_dich_vu varchar(45)
);
create table dich_vu (
	ma_dich_vu int not null primary key,
    ten_dich_vu varchar(45),
    dien_tich int,
    chi_phi_thue double,
    so_nguoi_toi_da int,
    ma_kieu_thue int,
    ma_loai_dich_vu int,
    tieu_chuan_phong varchar(45),
    mo_ta_tien_nghi_khac varchar(45),
    dien_tich_ho_boi double,
    so_tang int,
    foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu),
    foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue)
);
create table hop_dong(
	ma_hop_dong int not null primary key,
    ngay_lam_hop_dong datetime,
    ngay_ket_thuc datetime,
    tien_dat_coc double,
    ma_nhan_vien int,
    ma_khach_hang int,
    ma_dich_vu int,
    foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
    foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
    foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);
create table dich_vu_di_kem (
	ma_dich_vu_di_kem int not null primary key,
    ten_dich_vu_di_kem varchar(45),
    gia double,
    don_vi varchar(10),
    trang_thai varchar(45)
);
create table hop_dong_chi_tiet (
	ma_hop_dong_chi_tiet int not null primary key,
    ma_hop_dong int,
    ma_dich_vu_di_kem int,
    so_luong int,
    foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
    foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);
insert into vi_tri values (1,'Qu???n L??'), (2,'Nh??n Vi??n');
insert into trinh_do values (1,'Trung C???p'), (2,'Cao ?????ng'), (3,'?????i H???c'), (4,'Sau ?????i H???c');
insert into bo_phan values (1,'Sale-Marketing'), (2,'H??nh ch??nh'), (3,'Ph???c v???'), (4,'Qu???n l??');
insert into nhan_vien 
values (1,'Nguy???n V??n An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguy???n T???t Th??nh, ???? N???ng',1,3,1), 
		(2,'L?? V??n B??nh','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Y??n B??i, ???? N???ng',1,2,2),
		(3,'H??? Th??? Y???n','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 ??i???n Bi??n Ph???, Gia Lai',1,3,2),
		(4,'V?? C??ng To???n','1980-04-04','123231365',17000000,'0374443232','toan0404@gmail.com','77 Ho??ng Di???u, Qu???ng Tr???',1,4,4),
		(5,'Nguy???n B???nh Ph??t','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Y??n B??i, ???? N???ng',2,1,1),
		(6,'Kh??c Nguy???n An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguy???n T???t Th??nh, ???? N???ng',2,2,3),
		(7,'Nguy???n H???u H??','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguy???n Ch?? Thanh, Hu???',2,3,2),
		(8,'Nguy???n H?? ????ng','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 H??ng V????ng, H?? N???i',2,4,4),
		(9,'T??ng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 H??m Nghi, ???? N???ng',2,4,4),
		(10,'Nguy???n C??ng ?????o','1994-01-08','755434343',8000000,'0988767111','nguyencongdao12@gmail.com','6 Ho?? Kh??nh, ?????ng Nai',2,3,2);
insert into loai_khach values (1,'Diamond'), (2,'Platinium'), (3,'Gold'), (4,'Silver'), (5,'Member');
insert into khach_hang 
values (1,'Nguy???n Th??? H??o','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguy???n Ho??ng, ???? N???ng',5), 
		(2,'Ph???m Xu??n Di???u','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Th??i Phi??n, Qu???ng Tr???',3), 
		(3,'Tr????ng ????nh Ngh???','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 ??ng ??ch Khi??m, Vinh',1), 
		(4,'D????ng V??n Quan','1981-07-08',0,'543432111','0490039241','duongquan@gmail.com','K453/12 L?? L???i, ???? N???ng',1), 
		(5,'Ho??ng Tr???n Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 L?? Th??i T???, Gia Lai',4), 
		(6,'T??n N??? M???c Ch??u','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.comm','37 Y??n Th???, ???? N???ng',4), 
		(7,'Nguy???n M??? Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 L?? L???i, H??? Ch?? Minh',1), 
		(8,'Nguy???n Th??? H??o','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguy???n V??n Linh, Kon Tum',3), 
		(9,'Tr???n ?????i Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 L?? Th?????ng Ki???t, Qu???ng Ng??i',1), 
		(10,'Nguy???n T??m ?????c','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ng?? Quy???n, ???? N???ng',2); 
insert into kieu_thue values (1,'year'), (2,'month'), (3,'day'), (4,'hour');
insert into loai_dich_vu values (1,'Villa'), (2,'House'), (3,'Room');
insert into dich_vu 
values (1,'Villa Beach Front',25000,10000000,10,3,1,'vip','C?? h??? b??i',500,4),
		(2,'House Princess 01',14000,5000000,7,2,2,'vip','C?? th??m b???p n?????ng',null,3),
		(3,'Room Twin 01',5000,1000000,2,4,3,'normal','C?? tivi',null,null),
		(4,'Villa No Beach Front',22000,9000000,8,3,1,'normal','C?? h??? b??i',300,3),
		(5,'House Princess 02',10000,4000000,5,3,2,'normal','C?? th??m b???p n?????ng',null,2),
		(6,'Room Twin 02',3000,900000,2,4,3,'normal','C?? tivi',null,null);
insert into dich_vu_di_kem
values (1,'Karaoke',10000,'gi???','ti???n nghi, hi???n t???i'),
		(2,'Thu?? xe m??y',10000,'chi???c','h???ng 1 xe'),
		(3,'Thu?? xe ?????p',20000,'chi???c','t???t'),
		(4,'Buffet bu???i s??ng',15000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
		(5,'Buffet bu???i tr??a',90000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
		(6,'Buffet bu???i t???i',16000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng');
insert into hop_dong
values (1,'2020-12-08','2020-12-08',0,3,1,3),
		(2,'2020-07-14','2020-07-21',200000,7,3,1),
		(3,'2021-03-15','2021-03-17',50000,3,4,2),
		(4,'2021-01-14','2021-01-18',100000,7,5,5),
		(5,'2021-07-14','2021-07-15',0,7,2,6),
		(6,'2021-06-01','2021-06-03',0,7,7,6),
		(7,'2021-09-02','2021-09-05',100000,7,4,4),
		(8,'2021-06-17','2021-06-18',150000,3,4,1),
		(9,'2020-11-19','2020-11-19',0,3,4,3),
		(10,'2021-04-12','2021-04-14',0,10,3,5),
		(11,'2021-04-25','2021-04-25',0,2,2,1),
		(12,'2021-05-25','2021-05-27',0,7,10,1);
insert into hop_dong_chi_tiet
values (1,2,4,5),
		(2,2,5,8),
		(3,2,6,15),
		(4,3,1,1),
		(5,3,2,11),
		(6,1,3,1),
		(7,1,2,2),
		(8,12,2,2);
update khach_hang 
set ma_loai_khach = (select ma_loai_khach from loai_khach where ten_loai_khach like 'Diamond')
where 
	ma_loai_khach = (select ma_loai_khach from loai_khach where ten_loai_khach like 'Platinium') and 
    ma_khach_hang in (select tong_tien_theo_hop_dong.ma_khach_hang from
							(select ma_khach_hang, if (hop_dong_chi_tiet.ma_hop_dong is null, dich_vu.chi_phi_thue, dich_vu.chi_phi_thue + sum(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia)) as tong_tien_hop_dong
							from khach_hang 
							inner join loai_khach using(ma_loai_khach) 
							inner join hop_dong using(ma_khach_hang) 
							inner join dich_vu using (ma_dich_vu)
							left join hop_dong_chi_tiet using (ma_hop_dong)
							left join dich_vu_di_kem using (ma_dich_vu_di_kem)
							where year(hop_dong.ngay_lam_hop_dong) = 2021
							group by khach_hang.ma_khach_hang, hop_dong.ma_hop_dong) as tong_tien_theo_hop_dong
						group by tong_tien_theo_hop_dong.ma_khach_hang
						having sum(tong_tien_theo_hop_dong.tong_tien_hop_dong) > 10000000);
update 
dich_vu_di_kem, 
(select ma_dich_vu_di_kem, sum(so_luong) 
from hop_dong_chi_tiet 
inner join hop_dong using(ma_hop_dong) 
where year(ngay_lam_hop_dong) = 2020 
group by ma_dich_vu_di_kem 
having sum(so_luong) > 10) as temp 
set dich_vu_di_kem.gia = dich_vu_di_kem.gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem = temp.ma_dich_vu_di_kem;