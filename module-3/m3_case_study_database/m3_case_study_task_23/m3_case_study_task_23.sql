use m3_case_study_database;
delimiter //
create procedure sp_xoa_khach_hang 
(
	in ma_kh int
)
begin
	set foreign_key_checks = 0;
	delete from hop_dong_chi_tiet
    where hop_dong_chi_tiet.ma_hop_dong in (select hop_dong.ma_hop_dong from hop_dong inner join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang where khach_hang.ma_khach_hang = ma_kh);
    
	delete khach_hang, hop_dong from khach_hang inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
    where khach_hang.ma_khach_hang = ma_kh;
    set foreign_key_checks = 1;
end //
delimiter ;
call sp_xoa_khach_hang(10);