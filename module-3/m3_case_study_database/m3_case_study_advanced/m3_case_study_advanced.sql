use m3_case_study_database;
delimiter //
create trigger tr_xoa_hop_dong 
after delete on hop_dong
for each row
begin
	declare n int; 
    declare str varchar(45);
    select count(ma_hop_dong) from hop_dong into n;
    set str = concat("Còn lại: ", n, " hợp đồng.");
	signal sqlstate '45000' set message_text = str;
end //
delimiter ;


delete from hop_dong
where ma_hop_dong = 5;

drop trigger tr_xoa_hop_dong;


select ngay_lam_hop_dong, ngay_ket_thuc, timestampdiff(Day, ngay_lam_hop_dong, ngay_ket_thuc) from hop_dong



