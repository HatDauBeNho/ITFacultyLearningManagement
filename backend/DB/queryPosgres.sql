-- Tạo ràng buộc khóa ngoại cho bảng classrooms
ALTER TABLE classrooms 
ADD CONSTRAINT "FK_classrooms_majorId"
FOREIGN KEY ("majorId") REFERENCES "majors" ("majorId") ON DELETE CASCADE,
ADD CONSTRAINT "FK_classrooms_teacherId"
FOREIGN KEY ("teacherId") REFERENCES "teachers" ("teacherId") ON DELETE CASCADE;


-- Tạo ràng buộc khóa ngoại cho bảng courseRegistrations
ALTER TABLE "courseRegistrations"
ADD CONSTRAINT "FK_courseRegistrations_studentId" 
FOREIGN KEY ("studentId") REFERENCES "students" ("studentId") ON DELETE CASCADE,
ADD CONSTRAINT "FK_courseRegistrations_moduleSubjectId" 
FOREIGN KEY ("moduleSubjectId") REFERENCES "moduleSubjects" ("moduleSubjectId") ON DELETE CASCADE;

-- Tạo ràng buộc khóa ngoại cho bảng departments
ALTER TABLE "departments"
ADD CONSTRAINT "FK_departments_teacherId" 
FOREIGN KEY ("teacherId") REFERENCES "teachers" ("teacherId") ON DELETE CASCADE;

-- Tạo ràng buộc khóa ngoại cho bảng majors
ALTER TABLE "majors"
ADD CONSTRAINT "FK_majors_departmentId" 
FOREIGN KEY ("departmentId") REFERENCES "departments" ("departmentId") ON DELETE CASCADE,
ADD CONSTRAINT "FK_majors_teacherId" 
FOREIGN KEY ("teacherId") REFERENCES "teachers" ("teacherId") ON DELETE CASCADE;

-- Tạo ràng buộc khóa ngoại cho bảng modulesubjects
ALTER TABLE "moduleSubjects"
ADD CONSTRAINT "FK_modulesubjects_subjectId" 
FOREIGN KEY ("subjectId") REFERENCES "subjects" ("subjectId") ON DELETE CASCADE,
ADD CONSTRAINT "FK_modulesubjects_teacherId" 
FOREIGN KEY ("teacherId") REFERENCES "teachers" ("teacherId") ON DELETE CASCADE;

-- Tạo ràng buộc khóa ngoại cho bảng results
ALTER TABLE "results"
ADD CONSTRAINT "FK_results_courseRegistrationId" 
FOREIGN KEY ("courseRegistrationId") REFERENCES "courseRegistrations" ("courseRegistrationId") ON DELETE CASCADE;

-- Tạo ràng buộc khóa ngoại cho bảng students
ALTER TABLE "students"
ADD CONSTRAINT "FK_students_accountId" 
FOREIGN KEY ("accountId") REFERENCES "accounts" ("accountId") ON DELETE CASCADE,
ADD CONSTRAINT "FK_students_inforId" 
FOREIGN KEY ("inforId") REFERENCES "infors" ("inforId") ON DELETE CASCADE;

-- Tạo ràng buộc khóa ngoại cho bảng subjects
ALTER TABLE "subjects"
ADD CONSTRAINT "FK_subjects_departmentId" 
FOREIGN KEY ("departmentId") REFERENCES "departments" ("departmentId") ON DELETE CASCADE;

-- Tạo ràng buộc khóa ngoại cho bảng teachers
ALTER TABLE "teachers"
ADD CONSTRAINT "FK_teachers_accountId" 
FOREIGN KEY ("accountId") REFERENCES "accounts" ("accountId") ON DELETE CASCADE,
ADD CONSTRAINT "FK_teachers_inforId" 
FOREIGN KEY ("inforId") REFERENCES "infors" ("inforId") ON DELETE CASCADE;

