# --- Create tool_types

# --- !Ups

insert into tool_type (type_name,type_image_url,section,description) values ('Hammer','url','Hand Tool', 'Hitting Nails');
insert into tool_type (type_name,type_image_url,section,description) values ('Wrench','url','Hand Tool', 'Tightening Bolts');
insert into tool_type (type_name,type_image_url,section,description) values ('Staple Gun','url','Hand Tool', 'Stapling');
insert into tool_type (type_name,type_image_url,section,description) values ('Screwdriver','url','Hand Tool', 'Screwing in screws');

# --- !Downs

delete from tool_type;
