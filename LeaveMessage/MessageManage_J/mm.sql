----------------------------------查询不同类型用户
select * from user
select * from user where user.type=0
select * from user where user.type=1


----------------------------------登录界面
-------------登录时检索密码
select password from user
where user.user_id=1725121025

-----------------------------------查看个人信息
select user_id,name,password from user
where user.user_id=1725121025

-----------------------------------修改个人信息
update user
set password=''
where user_id=

-----------------------------------首页留言
select * from 留言
where messageType=1

-----------------------------------主页留言
select * from 留言
where messageType=1

----------------------------------添加留言
insert into 留言

-----------------------------------留言审核
update * from 留言
where messageType=0











