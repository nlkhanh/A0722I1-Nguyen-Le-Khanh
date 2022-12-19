use s2p_student_management;
select * from student;
select * from student 
where `status` = true;
select * from `subject` 
where credit < 10;
select s.student_id, s.student_name, c.class_name from student s 
join class c on s.class_id = c.class_id 
where c.class_name = 'A1';
select s.student_id, s.student_name, sub.sub_name, m.mark from student s 
join mark m on s.student_id = m.student_id 
join `subject` sub on m.sub_id = sub.sub_id
where sub.sub_name = 'CF';