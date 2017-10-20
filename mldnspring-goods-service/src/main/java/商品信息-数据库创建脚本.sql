DROP DATABASE mldn ;
CREATE DATABASE mldn CHARACTER SET UTF8 ;
USE mldn ;
-- 创建数据表
CREATE TABLE item(
	iid			BIGINT AUTO_INCREMENT ,
	title		VARCHAR(50) ,
	CONSTRAINT pk_iid PRIMARY KEY(iid)
) ;
CREATE TABLE tag(
	tid			BIGINT AUTO_INCREMENT ,
	title		VARCHAR(50) ,
	CONSTRAINT pk_tid PRIMARY KEY(tid)
) ;
CREATE TABLE goods (
	gid			BIGINT AUTO_INCREMENT ,
	name		VARCHAR(50) ,
	price		double ,
	photo		VARCHAR(100) ,
	dflag		int ,
	iid			BIGINT ,
	CONSTRAINT pk_gid10 PRIMARY KEY(gid) ,
	CONSTRAINT fk_iid FOREIGN KEY(iid) REFERENCES item(iid)
) ;
CREATE TABLE goods_tag(
	gid			BIGINT ,
	tid			BIGINT ,
	CONSTRAINT fk_gid11 FOREIGN KEY(gid) REFERENCES goods(gid) ON DELETE CASCADE ,
	CONSTRAINT fk_tid11 FOREIGN KEY(tid) REFERENCES tag(tid)
) ;
-- 测试数据
INSERT INTO item(title) VALUES ('图书音像') ;
INSERT INTO item(title) VALUES ('办公用品') ;
INSERT INTO item(title) VALUES ('家居生活') ;
INSERT INTO item(title) VALUES ('厨房家电') ;
INSERT INTO item(title) VALUES ('电子设备') ;

INSERT INTO tag(title) VALUES ('高端') ;
INSERT INTO tag(title) VALUES ('奢华') ;
INSERT INTO tag(title) VALUES ('性价比高') ;
INSERT INTO tag(title) VALUES ('免费') ;
INSERT INTO tag(title) VALUES ('耐用') ;

-- 提交事务
COMMIT ;

