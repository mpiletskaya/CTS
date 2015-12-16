# --- Create tool_types

# --- !Ups

insert into tool_type (type_name,type_image_url,section,description) values ('Hammer','images/Hammer.png','Hand Tool', 'Hitting Nails');
insert into tool_type (type_name,type_image_url,section,description) values ('Wrench','images/Wrench.png','Hand Tool', 'Tightening Bolts');
insert into tool_type (type_name,type_image_url,section,description) values ('Staple Gun','images/Staple-Gun.png','Hand Tool', 'Stapling');
insert into tool_type (type_name,type_image_url,section,description) values ('Saw','images/Saw.png','Hand Tool', 'Cutting Objects');

# --- !Downs

delete from tool_type;
