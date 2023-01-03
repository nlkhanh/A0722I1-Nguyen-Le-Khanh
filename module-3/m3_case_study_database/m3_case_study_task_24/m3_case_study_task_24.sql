use m3_case_study_database;
delimiter //
create procedure sp_kiem_tra_ma_hop_dong  
(
	in ma_hd int,
    out ma_hd_hop_le boolean
)
begin
	declare n int;
	select count(ma_hop_dong) from hop_dong where ma_hop_dong = ma_hd into n;
    set ma_hd_hop_le = true;
    if (n > 0) then
		set ma_hd_hop_le = false;
	end if;
end //
delimiter ;
delimiter //
create procedure sp_kiem_tra_ma_khach_hang  
(
	in ma_kh int,
    out ma_kh_hop_le boolean
)
begin
	declare n int;
	select count(ma_khach_hang) from khach_hang where ma_khach_hang = ma_kh into n;
    set ma_kh_hop_le = false;
    if (n > 0) then
		set ma_kh_hop_le = true;
	end if;
end //
delimiter ;
delimiter //
create procedure sp_kiem_tra_ma_nhan_vien  
(
	in ma_nv int,
    out ma_nv_hop_le boolean
)
begin
	declare n int;
	select count(ma_nhan_vien) from nhan_vien where ma_nhan_vien = ma_nv into n;
    set ma_nv_hop_le = false;
    if (n > 0) then
		set ma_nv_hop_le = true;
	end if;
end //
delimiter ;
delimiter //
create procedure sp_kiem_tra_ma_dich_vu  
(
	in ma_dv int,
    out ma_dv_hop_le boolean
)
begin
	declare n int;
	select count(ma_dich_vu) from dich_vu where ma_dich_vu = ma_dv into n;
    set ma_dv_hop_le = false;
    if (n > 0) then
		set ma_dv_hop_le = true;
	end if;
end //
delimiter ;
delimiter //
create procedure sp_them_moi_hop_dong  
(
	in ma_hd int, ngay_lam_hd datetime, ngay_kt datetime, tien_dc double, ma_nv int, ma_kh int, ma_dv int,
    out da_them boolean
)
begin
	set da_them = false;
	call sp_kiem_tra_ma_hop_dong(ma_hd, @ma_hd_hop_le);
	call sp_kiem_tra_ma_nhan_vien(ma_nv, @ma_nv_hop_le);
	call sp_kiem_tra_ma_khach_hang(ma_kh, @ma_kh_hop_le);
	call sp_kiem_tra_ma_dich_vu(ma_dv, @ma_dv_hop_le);
    if (
		(select(@ma_hd_hop_le) = 1) and
		(select(@ma_nv_hop_le) = 1) and
		(select(@ma_kh_hop_le) = 1) and
		(select(@ma_dv_hop_le) = 1)
    ) then
		insert into hop_dong values(ma_hd, ngay_lam_hd, ngay_kt, tien_dc, ma_nv, ma_kh, ma_dv);
        set da_them = true;
    end if;
end //
delimiter ;
call sp_them_moi_hop_dong(1,'2020-12-08','2020-12-08',0,3,2,3,@da_them);
select @da_them;