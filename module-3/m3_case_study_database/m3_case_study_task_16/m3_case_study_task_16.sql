use m3_case_study_database;
delete from nhan_vien nv
where nv.ma_nhan_vien not in (select hd.ma_nhan_vien from hop_dong hd where year(hd.ngay_lam_hop_dong) between 2019 and 2021);