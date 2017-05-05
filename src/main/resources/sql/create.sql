/*创建学生信息表*/
CREATE TABLE cdms_student_info(
  student_id VARCHAR(16) PRIMARY KEY,
  student_name VARCHAR(16) NOT NULL,
  student_class VARCHAR(16) NOT NULL,
  student_email VARCHAR(32),
  student_phone VARCHAR(16),
  student_picture VARCHAR(100),
  pwd_code VARCHAR(64) NOT NULL);

/*创建教师信息表*/
CREATE TABLE cdms_teacher_info(
  teacher_id VARCHAR(16) PRIMARY KEY,
  teacher_name VARCHAR(16) NOT NULL,
  teacher_email VARCHAR(32),
  teacher_phone VARCHAR(16),
  teacher_picture VARCHAR(100),
  pwd_code VARCHAR(64) NOT NULL);

/*创建管理员信息表*/
CREATE TABLE cdms_admin_info(
  admin_id VARCHAR(16) PRIMARY KEY ,
  pwd_code VARCHAR(64) NOT NULL);

/*创建课程信息表*/
CREATE TABLE cdms_courses_info(
	course_id VARCHAR(16) PRIMARY KEY,
	course_name VARCHAR(64) NOT NULL);

/*创建成绩信息表*/
CREATE TABLE cdms_scores_info(
  student_id VARCHAR(16) PRIMARY KEY,
  student_name VARCHAR(16) NOT NULL,
  student_class VARCHAR(16) NOT NULL,
  course_name VARCHAR(64) NOT NULL,
  score_usual int,
  score_middle int,
  score_last int,
  score_summary int);