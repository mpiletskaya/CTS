# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tool (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_tool primary key (id))
;

create table tool_type (
  id                        bigint not null,
  type_name                 varchar(255),
  constraint pk_tool_type primary key (id))
;

create sequence tool_seq;

create sequence tool_type_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tool;

drop table if exists tool_type;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tool_seq;

drop sequence if exists tool_type_seq;

