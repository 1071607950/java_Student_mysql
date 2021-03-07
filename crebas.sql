/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/10/9 10:39:34                           */
/*==============================================================*/


drop table if exists admin;

drop table if exists students;

drop table if exists stuscore;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   accounts             varchar(20) not null,
   password             varchar(20),
   primary key (accounts)
);

/*==============================================================*/
/* Table: students                                              */
/*==============================================================*/
create table students
(
   number               int not null,
   name                 varchar(20),
   gender               varchar(20),
   nation               varchar(20),
   bloodtype            varchar(20),
   birthday             date,
   yxname               varchar(20),
   zyname               varchar(20),
   bjname               varchar(20),
   primary key (number)
);

/*==============================================================*/
/* Table: stuscore                                              */
/*==============================================================*/
create table stuscore
(
   number               int,
   kcname               varchar(20),
   term                 varchar(20),
   score                int,
   credit               int
);

alter table stuscore add constraint FK_Relationship_1 foreign key (number)
      references students (number) on delete restrict on update restrict;

