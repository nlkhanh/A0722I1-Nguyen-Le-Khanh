USE s2p_student_management;
select address, count(student_id)
from student
group by address;
select s.student_id, student_name, avg(mark)
from student s
inner join mark m on s.student_id = m.student_id
group by s.student_id, s.student_name;
select s.student_id, student_name, avg(mark)
from student s
inner join mark m on s.student_id = m.student_id
group by s.student_id, s.student_name
having avg(mark) > 15;
select s.student_id, student_name, avg(mark)
from student s
inner join mark m on s.student_id = m.student_id
group by s.student_id, s.student_name
having avg(mark) >= all (select avg(mark) from mark group by mark.student_id);