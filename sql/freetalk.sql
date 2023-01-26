CREATE TABLE `cm` (
                      `c_key` int NOT null AUTO_INCREMENT,
                      `c_name`    varchar(100)    NOT NULL,
                      `status`    varchar(100)    NOT null default 'created',
                      primary key(c_key)
);
insert into cm (c_name) values('고양이클럽');
select * from cm;
drop table cm;

CREATE TABLE `user` (
                        `u_id`  int NOT null AUTO_INCREMENT,
                        `email` varchar(100) not NULL,
                        `status`    varchar(100) not null default 'activated',
                        primary key(u_id)
);
insert into user (email) values('yigyuseok@gmail.com');
select * from user;
drop table user;

CREATE TABLE `join` (
                        `j_id`  int NOT null AUTO_INCREMENT,
                        `c_key` int NOT NULL,
                        `u_id`  int NOT NULL,
                        `inDate` datetime not null DEFAULT current_timestamp(),
                        primary key(j_id),
                        FOREIGN KEY (c_key) REFERENCES cm (c_key),
                        FOREIGN KEY (u_id) REFERENCES user (u_id)
);
insert into `join` (c_key,u_id) values('1','1');
select * from `join`;
drop table `join`;

CREATE TABLE `wr` (
                      `w_id`  int NOT null AUTO_INCREMENT,
                      `u_id`  int NOT NULL,
                      `c_key` int NOT NULL,
                      `w_title`   varchar(100) not NULL,
                      `w_contents`    varchar(1000) not NULL,
                      `indate`    datetime not null DEFAULT current_timestamp(),
                      `status`    varchar(100)    NOT null default 'created',
                      primary key(w_id),
                      FOREIGN KEY (u_id) REFERENCES user (u_id),
                      FOREIGN KEY (c_key) REFERENCES cm (c_key)
);
insert into `wr` (u_id,c_key,w_title,w_contents) values('1','1','제목 테스트','테스트 내용 입니다. 어디까지 가능할까요?');
insert into `wr` (u_id,c_key,w_title,w_contents) values('1','1','제목 테스트2','테스트2 내용 입니다. 어디까지 가능할까요?');
select * from `wr`;
drop table `wr`;

CREATE TABLE `com` (
                       `com_id`    int NOT null AUTO_INCREMENT,
                       `w_id`  int NOT NULL,
                       `com_u_id`  int NOT NULL,
                       `com_contents`  varchar(500) NOT NULL,
                       `indate`    datetime not null DEFAULT current_timestamp(),
                       `status`    varchar(100)    NOT null default 'created',
                       primary key(com_id),
                       FOREIGN KEY (w_id) REFERENCES wr (w_id),
                       FOREIGN KEY (com_u_id) REFERENCES user (u_id)
);
insert into `com` (w_id,com_u_id,com_contents) values('1','1','댓글 테스트 입니다.');
select * from `com`;
drop table `com`;

CREATE TABLE `com2` (
                        `com2_id`   int NOT null AUTO_INCREMENT,
                        `com_id`    int NOT NULL,
                        `w_id`  int NOT NULL,
                        `com2_u_id` int NOT NULL,
                        `com2_contents` varchar(500) not NULL,
                        `indate`    datetime not null DEFAULT current_timestamp(),
                        `status`    varchar(100) not null default 'created',
                        primary key(com2_id),
                        FOREIGN KEY (com_id) REFERENCES com (com_id),
                        FOREIGN KEY (com2_u_id) REFERENCES user (u_id),
                        FOREIGN KEY (w_id) REFERENCES wr (w_id)
);
insert into `com2` (com_id,w_id,com2_u_id,com2_contents) values('1','1','1','대댓글 테스트 입니다.');
select * from `com2`;
drop table `com2`;

CREATE TABLE `like` (
                        `u_id`  int NOT NULL,
                        `tableType` varchar(50) NOT NULL,
                        `type_id`   int NOT null,
                        FOREIGN KEY (u_id) REFERENCES user (u_id)
);
insert into `like` (u_id,tableType,type_id) values('1','wr','1');
select * from `like`;
drop table `like`;

CREATE TABLE `dislike` (
                           `u_id`  int NOT NULL,
                           `tableType` varchar(50) NOT NULL,
                           `type_id`   int NOT null,
                           FOREIGN KEY (u_id) REFERENCES user (u_id)
);
insert into `dislike` (u_id,tableType,type_id) values('1','wr','1');
select * from `dislike`;
drop table `dislike`;

CREATE TABLE `ht` (
                      `ht_id` int NOT null AUTO_INCREMENT,
                      `ht_name`   varchar(100) not null,
                      primary key(ht_id)
);
insert into `ht` (ht_name) values('고양이');
select * from `ht`;
drop table `ht`;

CREATE TABLE `tr` (
                      `ht_id` int NOT NULL,
                      `c_key` int NOT null,
                      FOREIGN KEY (ht_id) REFERENCES ht (ht_id),
                      FOREIGN KEY (c_key) REFERENCES cm (c_key)
);
insert into `tr` (ht_id,c_key) values('1','1');
select * from `tr`;
drop table `tr`;

CREATE TABLE `views` (
                         `w_id`  int NOT NULL,
                         `cnt`   int NOT null default '0',
                         FOREIGN KEY (w_id) REFERENCES wr (w_id)
);
insert into `views` (w_id,cnt) values('1','1');
select * from `views`;
drop table `views`;

CREATE TABLE `unknown` (
                           `w_id`  int NOT NULL,
                           `u_id`  int NOT null,
                           `tn` int not null,
                           FOREIGN KEY (w_id) REFERENCES wr (w_id),
                           FOREIGN KEY (u_id) REFERENCES user (u_id)
);
insert into `unknown` (w_id,u_id,tn) values('1','1','1');
select * from `unknown`;
drop table `unknown`;