create database gym;
use gym;
create table news (
 id int(7) AUTO_INCREMENT,
 order_date date DEFAULT '0000-00-00',
 header VARCHAR(255),
 content  VARCHAR(255),
 CONSTRAINT news_pk PRIMARY Key (id)
);

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
