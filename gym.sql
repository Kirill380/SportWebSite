create database gym;
use gym;
CREATE TABLE exercise (
	num                  int  NOT NULL  ,
	exer_type            varchar(255)  NOT NULL  ,
	count                int    ,
	weight               int    ,
	workout_id           int  NOT NULL  ,
	CONSTRAINT pk_exercise PRIMARY KEY ( num )
 ) engine=InnoDB;

CREATE INDEX idx_exercise ON exercise ( workout_id );

CREATE TABLE news (
	id                   int  NOT NULL  ,
	title                varchar(255)  NOT NULL  ,
	description          text  NOT NULL  ,
	publish_date         date  NOT NULL DEFAULT '0000-00-00',
	admin_id             int    ,
	CONSTRAINT pk_news PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_news ON news ( admin_id );

CREATE TABLE users (
	id                   int  NOT NULL  ,
	email                varchar(255)  NOT NULL  ,
	password             varchar(255)  NOT NULL  ,
	first_name           varchar(255)  NOT NULL  ,
	last_name            varchar(255)  NOT NULL  ,
	role                 char(2)  NOT NULL  ,
	coach_id             int    ,
	CONSTRAINT pk_user PRIMARY KEY ( id ),
	CONSTRAINT idx_users UNIQUE ( email )
 ) engine=InnoDB;

CREATE INDEX idx_users_0 ON users ( coach_id );

CREATE TABLE workout (
	id                   int  NOT NULL  ,
	user_id              int  NOT NULL  ,
	training_date        date  NOT NULL DEFAULT '0000-00-00',
	duration             time    ,
	CONSTRAINT pk_workout PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_workout ON workout ( user_id );

ALTER TABLE exercise ADD CONSTRAINT fk_exercise_workout FOREIGN KEY ( workout_id ) REFERENCES workout( id ) ON DELETE CASCADE ON UPDATE NO ACTION;

ALTER TABLE news ADD CONSTRAINT fk_news_users FOREIGN KEY ( admin_id ) REFERENCES users( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE users ADD CONSTRAINT fk_users_users FOREIGN KEY ( coach_id ) REFERENCES users( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE workout ADD CONSTRAINT fk_workout_users FOREIGN KEY ( user_id ) REFERENCES users( id ) ON DELETE CASCADE ON UPDATE NO ACTION;


insert into news(order_date, header, content)
values('2015-03-16','new news', 'ect ect ect ect ect ect :)');

insert into news(order_date, header, content)
values('2015-03-10','test news', 'ect ect ect ect ect ect :)');

insert into news(order_date, header, content)
values('2015-03-01','Gym news', 'ect ect ect ect ect ect :)');

insert into news(order_date, header, content)
values('2015-02-01','Gym interesting', 'some interesting text must be written here :)');

insert into news(order_date, header, content)
values('2015-03-17','Gym Newest', 'This is the newest news in table)');
