/*创建学生信息表*/
CREATE TABLE cdms_student_info(
  student_id VARCHAR(16) PRIMARY KEY,
  student_name VARCHAR(16) NOT NULL,
  student_email VARCHAR(32),
  student_phone VARCHAR(16),
  pwd_code VARCHAR(64) NOT NULL);

/*创建教师信息表*/
CREATE TABLE cdms_teacher_info(
  teacher_id VARCHAR(16) PRIMARY KEY,
  teacher_name VARCHAR(16) NOT NULL,
  teacher_email VARCHAR(32),
  teacher_phone VARCHAR(16),
  pwd_code VARCHAR(64) NOT NULL);

