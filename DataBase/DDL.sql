create table if not exists member
(
	id bigint auto_increment
		primary key,
	created_admin_id bigint null,
	created_time datetime(6) null,
	updated_admin_id bigint null,
	updated_time datetime(6) null,
	email varchar(255) null,
	is_certification bit not null,
	is_dormant bit not null,
	member_id varchar(255) null,
	member_name varchar(255) null,
	password varchar(255) null,
	use_marketing bit not null,
	constraint member_member_id_uindex
		unique (member_id)
) engine=InnoDB
;


create table if not exists order_item
(
	order_item_id bigint auto_increment
		primary key,
	created_admin_id bigint null,
	created_time datetime null,
	updated_admin_id bigint null,
	updated_time datetime null,
	number_of_product int not null,
	totalprice int not null,
	order_code varchar(30) null,
	product_code varchar(30) null
)
engine=InnoDB
;

create index idx_order_item_product_code
	on order_item (product_code);

create index fk_order_code
	on order_item (order_code);


create table if not exists orders
(
	order_id bigint auto_increment
		primary key,
	created_admin_id bigint null,
	created_time datetime(6) null,
	updated_admin_id bigint null,
	updated_time datetime(6) null,
	order_code varchar(30) null,
	status varchar(255) null,
	total_price int not null,
	member_id varchar(255) null,
	payment_id bigint null,
	constraint FKag8ppnkjvx255gj7lm3m18wkj
		foreign key (payment_id) references payment (payment_id),
	constraint fk_member_id
		foreign key (member_id) references member (member_id)
) engine=InnoDB
;


create table if not exists payment
(
	payment_id bigint auto_increment
		primary key,
	amount_of_payment int not null,
	created_admin_id bigint null,
	created_time datetime(6) null,
	updated_admin_id bigint null,
	updated_time datetime(6) null,
	is_approval bit not null,
	payment_method varchar(255) null
)engine=InnoDB
;

create table if not exists product
(
	id bigint auto_increment
		primary key,
	created_admin_id bigint null,
	created_time datetime null,
	updated_admin_id bigint null,
	updated_time datetime null,
	current_stock int not null,
	is_sale bit not null,
	price int not null,
	product_code varchar(30) null,
	product_name varchar(255) null
) engine=InnoDB
;