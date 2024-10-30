
insert into accounts (accountId,userName,`password`,`role`,`status`,createdAt,updatedAt) values 
	(1, 'admin', '$2a$10$k0GD6khRK0naL1tTxHNu6eG.WYBXPATL5c.p4dEBLPYYaf8rHM0o6', '1',1, '2023-09-03 05:23:59', '2023-09-03 05:23:59'),
	(2, 'giaovien', '$2a$10$k0GD6khRK0naL1tTxHNu6eG.WYBXPATL5c.p4dEBLPYYaf8rHM0o6', '2',1, '2023-09-03 05:23:59', '2023-09-03 09:08:23'),
	(3, 'sinhvien', '$2a$10$k0GD6khRK0naL1tTxHNu6eG.WYBXPATL5c.p4dEBLPYYaf8rHM0o6', '3',1, '2023-09-03 05:23:59', '2023-09-03 11:36:05');

INSERT INTO classrooms (classId, className, quantity, majorId, teacherId,createdAt, updatedAt) VALUES
	(1, 'Kĩ thuật phần mềm 4', 70, 1, 1, '2023-09-03 10:32:38', '2023-09-03 11:57:01'),
	(2, 'Kĩ thuật phần mềm 3', 65, 1, 1, '2023-09-03 12:32:46', '2023-09-03 12:38:21'),
	(3, 'Kĩ thuật phần mềm 2', 65, 1, 2, '2023-09-03 12:38:28', '2023-09-03 12:38:28'),
	(4, 'Kĩ thuật phần mềm 1', 65, 1, 2, '2023-09-03 12:38:32', '2023-09-03 12:38:32'),
	(5, 'Quản trị khách sạn 1', 65, 11, 2, '2023-09-04 08:28:07', '2023-09-04 08:28:07');

INSERT INTO course_registrations (courseRegistrationId, studentId, moduleSubjectId,`point`, createdAt, updatedAt) VALUES
	(1, 1, 1,9.6, '2023-09-04 08:55:08', '2023-09-04 08:55:08'),
	(2, 1, 2,8.5, '2023-09-04 09:05:29', '2023-09-04 09:05:29');

INSERT INTO departments(departmentId, departmentName,teacherId, createdAt, updatedAt) VALUES
	(1, 'Công nghệ thông tin', 1, '2023-09-03 08:14:29', '2023-09-03 11:34:41'),
	(2, 'Cơ khí', 2, '2023-09-04 05:04:00', '2023-09-04 05:04:00'),
	(3, 'Công nghệ hóa', 2, '2023-09-04 05:04:12', '2023-09-04 05:04:12'),
	(4, 'Công nghệ oto', 2, '2023-09-04 05:04:24', '2023-09-04 05:04:24'),
	(5, 'Điện', 1, '2023-09-04 05:04:32', '2023-09-04 05:04:32'),
	(6, 'Điện tử', 1, '2023-09-04 05:04:37', '2023-09-04 05:04:37'),
	(7, 'Kế toán - kiểm toán', 2, '2023-09-04 05:05:01', '2023-09-04 05:05:01'),
	(8, 'Quản lý kinh doanh', 2, '2023-09-04 05:05:21', '2023-09-04 05:05:21'),
    (9, 'Du lịch', 2, '2023-09-04 05:05:21', '2023-09-04 05:05:21');   

INSERT INTO infors (inforId, fullName, address, phoneNumber, email, dateOfBirth, gender, createdAt, updatedAt) VALUES
	(1, 'Phạm Hồng Nguyên', 'Hà nội', '0372238783', 'phamhongnguyen@Haui', '2002-07-01 ', 1, '2023-09-03 05:23:59', '2023-09-05 02:06:55'),
	(2, 'Trịnh Xuân Sơn', 'Hà nội', '0372238783', 'trinhxuanson@Haui', '2002-07-07 ', 1, '2023-09-03 05:23:59', '2023-09-03 11:36:05'),
	(3, 'Trần Ngọc Mai', 'Hà nội', '0356938783', 'tranngocmai@Haui', '2000-01-07', 0, '2023-09-03 05:23:59', '2023-09-03 09:08:23');

INSERT INTO majors (majorId, majorName, departmentId, teacherId, createdAt, updatedAt) VALUES
	(1, 'Kĩ thuật phần mềm', 1, 1, '2023-09-03 08:14:56', '2023-09-03 08:14:56'),
	(2, 'Hệ thống thông tin', 1, 1, '2023-09-03 09:36:26', '2023-09-03 09:36:35'),
	(4, 'Công nghệ thông tin', 1, 1, '2023-09-04 05:08:52', '2023-09-04 05:08:52'),
	(5, 'Công nghệ kỹ thuật cơ điện tử', 2, 2, '2023-09-04 05:09:14', '2023-09-04 05:09:14'),
	(6, 'Công nghệ kỹ thuật ô tô', 4, 2, '2023-09-04 05:09:23', '2023-09-04 05:09:23'),
	(7, 'Robot và trí tuệ nhân tạo', 1, 2, '2023-09-04 05:09:34', '2023-09-04 05:09:34'),
	(8, 'Công nghệ kỹ thuật điện', 5, 2, '2023-09-04 05:09:45', '2023-09-04 05:09:45'),
	(9, 'Công nghệ kỹ thuật hoá học', 3, 2, '2023-09-04 05:10:04', '2023-09-04 05:10:04'),
	(10, 'Công nghệ kỹ thuật cơ điện tử ô tô', 2, 2, '2023-09-04 05:10:20', '2023-09-04 05:10:20'),
	(11, 'Quản trị khách sạn', 9, 2, '2023-09-04 05:10:32', '2023-09-04 05:10:32'),
	(12, 'Quản trị nhà hàng và dịch vụ ăn uống', 9, 2, '2023-09-04 05:10:40', '2023-09-04 05:10:40'),
	(13, 'Công nghệ kỹ thuật điều khiển và TĐH', 2, 2, '2023-09-04 05:11:00', '2023-09-04 05:11:00');

INSERT INTO module_subjects (moduleSubjectId, subjectId, currentStudent, maximumStudent, teacherId, startAt, endAt, createdAt, updatedAt) VALUES
	(1, 1, 1, 60, 1, '2023-09-04 ', '2023-09-10 ', '2023-09-04 06:28:52', '2023-09-07 07:30:16'),
	(2, 2, 1, 60, 2, '2023-09-06 ', '2023-09-10 ', '2023-09-04 06:44:00', '2023-09-05 02:54:05');

INSERT INTO students (studentId, accountId, inforId, classId, gpa, createdAt, updatedAt) VALUES
	(1, 3, 3, 1, 0, '2023-09-03 12:13:14', '2023-09-03 12:13:14');	

INSERT INTO subjects (subjectId, subjectName, credit, departmentId, createdAt, updatedAt) VALUES
	(1, 'Chủ nghĩa xã hội khoa học', 2, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02'),
	(2, 'Kinh tế chính trị Mác-Lênin', 2, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02'),
	(3, 'Lịch sử Đảng Cộng sản Việt Nam', 2, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02'),
	(4, 'Triết học Mác-Lênin', 3, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02'),
	(5, 'Tư tưởng Hồ Chí Minh', 2, 1, '2023-09-03 11:31:02', '2023-09-03 11:31:02');

INSERT INTO teachers (teacherId, accountId, inforId, createdAt, updatedAt) VALUES
	(1, 1, 1, '2023-09-03 05:23:59', '2023-09-03 05:23:59'),
	(2, 2, 2, '2023-09-03 05:23:59', '2023-09-03 05:23:59');    








    
    




    
