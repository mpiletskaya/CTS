# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table review (
  id                        bigserial not null,
  body                      varchar(255),
  time_created              varchar(255),
  user_id                   bigint,
  tool_id                   bigint,
  constraint pk_review primary key (id))
;

create table tool (
  id                        bigserial not null,
  name                      varchar(255),
  description               varchar(255),
  status                    varchar(255),
  ttype_fk                  bigint,
  owner_fk                  bigint,
  borrower_fk               bigint,
  constraint pk_tool primary key (id))
;

create table tool_type (
  id                        bigserial not null,
  type_name                 varchar(255),
  type_image_url            varchar(255),
  section                   varchar(255),
  description               varchar(255),
  constraint pk_tool_type primary key (id))
;

create table users (
  id                        bigserial not null,
  username                  varchar(255),
  password_hash             varchar(255),
  zipcode                   varchar(255),
  lname                     varchar(255),
  fname                     varchar(255),
  email                     varchar(255),
  role                      varchar(255),
  constraint uq_users_email unique (email),
  constraint pk_users primary key (id))
;

alter table review add constraint fk_review_user_1 foreign key (user_id) references users (id);
create index ix_review_user_1 on review (user_id);
alter table review add constraint fk_review_tool_2 foreign key (tool_id) references tool (id);
create index ix_review_tool_2 on review (tool_id);
alter table tool add constraint fk_tool_tType_3 foreign key (ttype_fk) references tool_type (id);
create index ix_tool_tType_3 on tool (ttype_fk);
alter table tool add constraint fk_tool_owner_4 foreign key (owner_fk) references users (id);
create index ix_tool_owner_4 on tool (owner_fk);
alter table tool add constraint fk_tool_borrower_5 foreign key (borrower_fk) references users (id);
create index ix_tool_borrower_5 on tool (borrower_fk);



# --- !Downs

drop table if exists review cascade;

drop table if exists tool cascade;

drop table if exists tool_type cascade;

drop table if exists users cascade;

