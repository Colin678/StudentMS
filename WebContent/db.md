创建一个user表用来登录用
create table user(
	uid varchar(20) primary key , 
	upwd varchar(20),
	utype varchar(20)
)
根据utype在servlet里面跳转管理员 教师 学生页面


创建学生表
create table student(
	stuid char(8) primary key , 
	stupwd varchar(20) default '123456',
	sname varchar(20),
	state int,
	utype varchar(20) default 'student'
)
学号唯一
密码默认为123456在数据库中需加密显示


创建成绩表 只有学生有这个
create table achievement(
	id char(8), 
	name varchar(20),
	chinese int,
	math int,
	english int,
	sum int,
	avg float(5,2)
)
通过学号查找各科的成绩


创建老师表
create table teacher(
	teaid char(4) primary key ,
	teapwd varchar(20) default '123456',
	tname varchar(20),
	state int,
	utype varchar(20) default 'teacher'
)
教师号唯一
密码默认为123456在数据库中需加密显示

创建管理员表
create table manager(
	mid char(5) primary key,
	mpwd varchar(20),
	mname varchar(20),
	utype varchar(20) default 'manager'
)























