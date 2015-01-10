# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cart (
  customer                  varchar(255) not null,
  total                     float,
  date                      timestamp,
  constraint pk_cart primary key (customer))
;

create table cart_item (
  id                        integer not null,
  cart_customer             varchar(255) not null,
  item_id                   integer,
  quantity                  integer,
  constraint pk_cart_item primary key (id))
;

create table category (
  id                        integer not null,
  name                      varchar(255),
  parent_id                 integer,
  constraint pk_category primary key (id))
;

create table item (
  id                        integer not null,
  name                      varchar(255),
  description               varchar(255),
  price                     float,
  constraint pk_item primary key (id))
;


create table item_category (
  item_id                        integer not null,
  category_id                    integer not null,
  constraint pk_item_category primary key (item_id, category_id))
;
create sequence cart_seq;

create sequence cart_item_seq;

create sequence category_seq;

create sequence item_seq;

alter table cart_item add constraint fk_cart_item_cart_1 foreign key (cart_customer) references cart (customer);
create index ix_cart_item_cart_1 on cart_item (cart_customer);
alter table cart_item add constraint fk_cart_item_item_2 foreign key (item_id) references item (id);
create index ix_cart_item_item_2 on cart_item (item_id);
alter table category add constraint fk_category_parent_3 foreign key (parent_id) references category (id);
create index ix_category_parent_3 on category (parent_id);



alter table item_category add constraint fk_item_category_item_01 foreign key (item_id) references item (id);

alter table item_category add constraint fk_item_category_category_02 foreign key (category_id) references category (id);

# --- !Downs

drop table if exists cart cascade;

drop table if exists cart_item cascade;

drop table if exists category cascade;

drop table if exists item cascade;

drop table if exists item_category cascade;

drop sequence if exists cart_seq;

drop sequence if exists cart_item_seq;

drop sequence if exists category_seq;

drop sequence if exists item_seq;

