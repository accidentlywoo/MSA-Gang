create table member (
                        id bigint not null auto_increment,
                        created_admin_id bigint,
                        created_time datetime(6),
                        updated_admin_id bigint,
                        updated_time datetime(6),
                        email varchar(255),
                        is_certification bit not null,
                        is_dormant bit not null,
                        member_id varchar(255),
                        member_name varchar(255),
                        password varchar(255),
                        use_marketing bit not null,
                        primary key (id)
) engine=InnoDB


create table order_item (
                            order_item_id bigint not null auto_increment,
                            created_admin_id bigint,
                            created_time datetime(6),
                            updated_admin_id bigint,
                            updated_time datetime(6),
                            number_of_product integer not null,
                            totalprice integer not null,
                            order_id bigint,
                            product_code bigint,
                            primary key (order_item_id)
) engine=InnoDB


create table orders (
                        order_id bigint not null auto_increment,
                        created_admin_id bigint,
                        created_time datetime(6),
                        updated_admin_id bigint,
                        updated_time datetime(6),
                        order_code varchar(255),
                        total_price integer not null,
                        member_id bigint,
                        payment_id bigint,
                        primary key (order_id)
) engine=InnoDB


create table payment (
                         payment_id bigint not null auto_increment,
                         amount_of_payment integer not null,
                         created_admin_id bigint,
                         created_time datetime(6),
                         updated_admin_id bigint,
                         updated_time datetime(6),
                         is_approval bit not null,
                         payment_method varchar(255),
                         primary key (payment_id)
) engine=InnoDB


create table product (
                         id bigint not null auto_increment,
                         created_admin_id bigint,
                         created_time datetime(6),
                         updated_admin_id bigint,
                         updated_time datetime(6),
                         current_stock integer not null,
                         is_sale bit not null,
                         price integer not null,
                         product_code varchar(255),
                         product_name varchar(255),
                         primary key (id)
) engine=InnoDB


alter table order_item
    add constraint FKt4dc2r9nbvbujrljv3e23iibt
        foreign key (order_id)
            references orders (order_id)


alter table order_item
    add constraint FKbykdp3n8proui9ssfjqj1jia9
        foreign key (product_code)
            references product (id)


alter table orders
    add constraint FKpktxwhj3x9m4gth5ff6bkqgeb
        foreign key (member_id)
            references member (id)


alter table orders
    add constraint FKag8ppnkjvx255gj7lm3m18wkj
        foreign key (payment_id)
            references payment (payment_id)