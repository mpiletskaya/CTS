# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tool (
  id                        bigserial not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_tool primary key (id))
;

create table tool_type (
  id                        bigserial not null,
  type_name                 varchar(255),
  constraint pk_tool_type primary key (id))
;

create table users (
  id                        bigserial not null,
  username                  varchar(255),
  password_hash             varchar(255),
  email                     varchar(255),
  constraint uq_users_email unique (email),
  constraint pk_users primary key (id))
;




# --- !Downs

drop table if exists tool cascade;

drop table if exists tool_type cascade;

drop table if exists users cascade;

