CREATE DATABASE product( id bigint auto_increment primary key,
    name varchar (255) not null,
    price double not null
    );

CREATE DATABASE purchase( id bigint auto_increment primary key,
    product_id bigint not null,
    amount bigint not null,
    buyer_id bigint not null
    );

CREATE DATABASE buyer(
    id bigint auto_increment primary key,
    name varchar (255) not null,
    );