-- Users
--insert into city(country, name, state, map) values ('Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502')
-- insert into users(user_nm, passwd, user_typ, user_pos_time, longitude, latitude, address, phone) values ('user1', 'password1', 1, '2015-04-11 18:08:08', 121.05774, 14.58318, 'Some address 1', '+123456789')
--insert into users(user_nm, passwd, user_typ, user_pos_time, longitude, latitude, address, phone) values ('user1', 'password1', 1, TIMESTAMPADD ( SQL_TSI_MINUTE, 30, CURRENT_TIMESTAMP ), 121.05774, 14.58318, 'Some address 1', '+123456789')
insert into users(user_nm, passwd, user_typ, user_pos_time, longitude, latitude, address, phone) values ('user1', 'password1', 1, CURRENT_TIMESTAMP, 121.05774, 14.58318, 'Some address 1', '+123456789')
insert into users(user_nm, passwd, user_typ, user_pos_time, longitude, latitude, address, phone) values ('palaOne', 'password2', 1, CURRENT_TIMESTAMP, 121.05774, 14.58318, 'Address of palaOne', '+987654321')
insert into users(user_nm, passwd, user_typ, user_pos_time, longitude, latitude, address, phone) values ('petSoc', 'password3', 1, CURRENT_TIMESTAMP, 121.05774, 14.58318, 'Some random address for petSoc', '+12354321')
