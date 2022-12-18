CREATE DATABASE `s2p_score_management`;
use `s2p_score_management`;
create table `student` (
	`student_code` varchar(20) not null primary key,
    `student_name` varchar(50),
    `birthdate` datetime,
    `class` varchar(20),
    `GT` varchar(20)
);
create table `module` (
	`module_code` varchar(20) not null primary key,
    `module_name` varchar(50)
);
create table `score_table` (
	`student_code` varchar(20) not null,
    `module_code` varchar(20) not null,
    `score` int,
    `exam_date` datetime,
    primary key (`student_code`, `module_code`),
    foreign key (`student_code`) references `student`(`student_code`),
    foreign key (`module_code`) references `module`(`module_code`)
);
rename table `score_table`
	to `student_module`;
create table `teacher` (
	`teacher_code` varchar(20) not null primary key,
    `teacher_name` varchar(20),
    `phone_number` varchar(10)
);
alter table `module`
	add `teacher_code` varchar(20);
alter table `module`
	add constraint `fk_teacher_code` foreign key (`teacher_code`) references `teacher`(`teacher_code`);
    