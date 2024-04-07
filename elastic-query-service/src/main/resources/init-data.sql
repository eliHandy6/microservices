CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";


INSERT INTO public.users(id, username, firstname, lastname)
VALUES ('2b7bc506-36d5-4eda-8508-0aa357a39732', 'app_user', 'Standard', 'User');
INSERT INTO public.users(id, username, firstname, lastname)
VALUES ('3b2e743e-7cbb-4509-bbee-7469c2bc0905', 'app_admin', 'Admin', 'User');
INSERT INTO public.users(id, username, firstname, lastname)
VALUES ('9a623a1a-c8d3-4ea2-8bcf-26ad32748085', 'app_super_user', 'Super', 'User');


insert into documents(id, document_id)
values ('c1df7d01-4bd7-40b6-86da-7e2ffabf37f7', 4411619070870399151);
insert into documents(id, document_id)
values ('f2b2d644-3a08-4acb-ae07-20569f6f2a01', 4265304351598906185);
insert into documents(id, document_id)
values ('90573d2b-9a5d-409e-bbb6-b94189709a19', 37350943574137785496);

insert into user_permissions(user_permission_id, user_id, document_id, permission_type)
values (uuid_generate_v4(), '2b7bc506-36d5-4eda-8508-0aa357a39732', 'c1df7d01-4bd7-40b6-86da-7e2ffabf37f7', 'READ');

insert into user_permissions(user_permission_id, user_id, document_id, permission_type)
values (uuid_generate_v4(), '3b2e743e-7cbb-4509-bbee-7469c2bc0905', 'c1df7d01-4bd7-40b6-86da-7e2ffabf37f7', 'READ');

insert into user_permissions(user_permission_id, user_id, document_id, permission_type)
values (uuid_generate_v4(), '3b2e743e-7cbb-4509-bbee-7469c2bc0905', 'f2b2d644-3a08-4acb-ae07-20569f6f2a01', 'READ');

insert into user_permissions(user_permission_id, user_id, document_id, permission_type)
values (uuid_generate_v4(), '3b2e743e-7cbb-4509-bbee-7469c2bc0905', '90573d2b-9a5d-409e-bbb6-b94189709a19', 'READ');

insert into user_permissions(user_permission_id, user_id, document_id, permission_type)
values (uuid_generate_v4(), '9a623a1a-c8d3-4ea2-8bcf-26ad32748085', 'c1df7d01-4bd7-40b6-86da-7e2ffabf37f7', 'READ');


