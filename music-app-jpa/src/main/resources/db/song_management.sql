create database `song-app`;

create table `song-app`.songs
(
    id      int primary key auto_increment,
    `name`    varchar(45) default null,
    singer   varchar(45) default null,
    category    varchar(45) default null,
    access    varchar(45) default null

);

insert into `song-app`.songs(`name`, singer,category,access)
values ('Dong Que', 'Luong Bich Huu', 'Tru tinh','http://')

;