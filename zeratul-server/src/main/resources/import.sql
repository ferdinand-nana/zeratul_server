-- Users
--insert into city(country, name, state, map) values ('Australia', 'Brisbane', 'Queensland', '-27.470933, 153.023502')
-- insert into users(user_nm, passwd, user_typ, user_pos_time, longitude, latitude, address, phone) values ('user1', 'password1', 1, '2015-04-11 18:08:08', 121.05774, 14.58318, 'Some address 1', '+123456789')
--insert into users(user_nm, passwd, user_typ, user_pos_time, longitude, latitude, address, phone) values ('user1', 'password1', 1, TIMESTAMPADD ( SQL_TSI_MINUTE, 30, CURRENT_TIMESTAMP ), 121.05774, 14.58318, 'Some address 1', '+123456789')
insert into users(user_nm, passwd, user_typ, user_pos_time, latitude, longitude, address, phone) values ('megaUser', 'password1', 0, CURRENT_TIMESTAMP, 14.58318, 121.05774, 'Near SM Megamall', '+123456789')
insert into users(user_nm, passwd, user_typ, user_pos_time, latitude, longitude, address, phone) values ('ThePod', 'password2', 0, CURRENT_TIMESTAMP, 14.5856, 121.05977, 'Near The Podium', '+987654321')
insert into users(user_nm, passwd, user_typ, user_pos_time, latitude, longitude, address, phone) values ('shang', 'password3', 0, CURRENT_TIMESTAMP, 14.58036, 121.05485, 'Somewhat close to Shangri-la Plaza', '+12354321')

insert into users(user_nm, passwd, user_typ, user_pos_time, latitude, longitude, address, phone) values ('wilTow', 'password4', 0, CURRENT_TIMESTAMP, 14.6386, 121.03758, 'Beside Wil Tower', '+654789321')
insert into users(user_nm, passwd, user_typ, user_pos_time, latitude, longitude, address, phone) values ('contis', 'password5', 0, CURRENT_TIMESTAMP, 14.6553, 121.03037, 'Close to Contis', '+987654123')
insert into users(user_nm, passwd, user_typ, user_pos_time, latitude, longitude, address, phone) values ('krafts', 'password6', 0, CURRENT_TIMESTAMP, 14.66205, 121.01941, 'Near Kamay Krafts', '+369852147')
insert into users(user_nm, passwd, user_typ, user_pos_time, latitude, longitude, address, phone) values ('palaOne', 'palaOne', 0, CURRENT_TIMESTAMP, 14.66205, 121.01941, 'Building I Technohub, Quezon City', '+741852963')

-- orders
insert into user_order(order_user_id, order_msg, amt, order_time, order_target_time, order_status, address, phone) select id, 'Family Pizza', 500, CURRENT_TIMESTAMP, TIMESTAMPADD ( SQL_TSI_MINUTE, 30, CURRENT_TIMESTAMP ), 0, 'Near SM Megamall', '+123456789' from users where user_nm = 'megaUser'
insert into user_order(order_user_id, order_msg, amt, order_time, order_target_time, order_status, address, phone) select id, '2 Liters of Coke', 50, CURRENT_TIMESTAMP, TIMESTAMPADD ( SQL_TSI_MINUTE, 10, CURRENT_TIMESTAMP ), 1, 'Near SM Megamall', '+123456789' from users where user_nm = 'megaUser'
insert into user_order(order_user_id, order_msg, amt, order_time, order_target_time, order_status, address, phone) select id, 'Jollibee Cheese Burger', 100, TIMESTAMPADD ( SQL_TSI_MINUTE, -30, CURRENT_TIMESTAMP ), CURRENT_TIMESTAMP, 2, 'Near SM Megamall', '+123456789' from users where user_nm = 'megaUser'
insert into user_order(order_user_id, order_msg, amt, order_time, order_target_time, order_status, address, phone) select id, 'Jollibee Kiddie Meal', 150, CURRENT_TIMESTAMP, TIMESTAMPADD ( SQL_TSI_MINUTE, 30, CURRENT_TIMESTAMP ), 0, 'Near The Podium', '+987654321' from users where user_nm = 'ThePod'
insert into user_order(order_user_id, order_msg, amt, order_time, order_target_time, order_status, address, phone) select id, '2 orders of  McHappy Meal', 300, CURRENT_TIMESTAMP, TIMESTAMPADD ( SQL_TSI_MINUTE, 30, CURRENT_TIMESTAMP ), 2, 'Near The Podium', '+987654321' from users where user_nm = 'ThePod'
insert into user_order(order_user_id, order_msg, amt, order_time, order_target_time, order_status, address, phone) select id, 'Fruit Basket for Gift', 1000, CURRENT_TIMESTAMP, TIMESTAMPADD ( SQL_TSI_MINUTE, 120, CURRENT_TIMESTAMP ), 0, 'Near Kamay Krafts', '+369852147' from users where user_nm = 'krafts'

-- bids
insert into bid(order_id, bid_user_id, bid_amt, bid_time, target_time, confirmed, latitude, longitude) select o.id, u.id, 450, CURRENT_TIMESTAMP, TIMESTAMPADD ( SQL_TSI_MINUTE, 25, CURRENT_TIMESTAMP ), false, 14.66205, 121.01941 from user_order o, users u where o.order_msg = 'Family Pizza' and u.user_nm = 'shang'
insert into bid(order_id, bid_user_id, bid_amt, bid_time, target_time, confirmed, latitude, longitude) select o.id, u.id, 800, CURRENT_TIMESTAMP, TIMESTAMPADD ( SQL_TSI_MINUTE, 100, CURRENT_TIMESTAMP ), false, 14.6386, 121.03758 from user_order o, users u where o.order_msg = 'Fruit Basket for Gift' and u.user_nm = 'wilTow'