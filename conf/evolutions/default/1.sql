# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tool (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_tool primary key (id))
;

create sequence tool_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tool;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tool_seq;

