CREATE TABLE if not exists "PermissionAction"  (
    "id" varchar(255) PRIMARY KEY,
    "code" varchar(255) UNIQUE NOT NULL,
    "name" varchar(255),
    "user_type" varchar(255) NOT NULL,
    "service_id" varchar(255) DEFAULT 'TAP',
    created_ts timestamp not null default current_timestamp,
    created_by varchar(255),
    last_modified_ts timestamp not null default current_timestamp,
    last_modified_by varchar(255),
    deleted_ts timestamp,
    deleted_by varchar(255),
    version int not null default 1
);

CREATE TABLE if not exists "PermissionComponent" (
   "id" varchar(255) PRIMARY KEY,
   "code" varchar(255) UNIQUE NOT NULL,
   "name" varchar(255),
   "user_type" varchar(255) NOT NULL,
   "order" integer DEFAULT 1,
   "group_id" varchar(255),
   "service_id" varchar(255) DEFAULT 'TAP',
    created_ts timestamp not null default current_timestamp,
    created_by varchar(255),
    last_modified_ts timestamp not null default current_timestamp,
    last_modified_by varchar(255),
    deleted_ts timestamp,
    deleted_by varchar(255),
    version int not null default 1
);

CREATE TABLE if not exists "PermissionComponentAction" (
     "id" varchar(255) PRIMARY KEY,
     "action_id" varchar(255),
     "component_id" varchar(255)
);

CREATE TABLE if not exists "PermissionComponentGroup" (
    "id" varchar(255) PRIMARY KEY,
    "code" varchar(255) UNIQUE NOT NULL,
    "name" varchar(255),
    "order" integer DEFAULT 1,
    "parent_id" varchar(255),
    "user_type" varchar(255) NOT NULL,
    created_ts timestamp not null default current_timestamp,
    created_by varchar(255),
    last_modified_ts timestamp not null default current_timestamp,
    last_modified_by varchar(255),
    deleted_ts timestamp,
    deleted_by varchar(255),
    version int not null default 1
);

CREATE TABLE if not exists "RolePermissionComponent" (
   "id" varchar(255) PRIMARY KEY,
   "role_id" varchar(255),
   "component_id" varchar(255)
);

CREATE TABLE if not exists "Role" (
    "id" varchar(255) PRIMARY KEY,
    "code" varchar(255),
    "name" varchar(255),
    "active" boolean DEFAULT true,
    created_ts timestamp not null default current_timestamp,
    created_by varchar(255),
    last_modified_ts timestamp not null default current_timestamp,
    last_modified_by varchar(255),
    deleted_ts timestamp,
    deleted_by varchar(255),
    version int not null default 1
);

CREATE TABLE if not exists "User" (
    "id" varchar(255) PRIMARY KEY,
    "username" varchar(255) UNIQUE NOT NULL,
    "email" varchar(255) NOT NULL UNIQUE NOT NULL,
    "password" varchar(255) NOT NULL,
    "time_zone_id" varchar(255) NOT NULL,
    "office_id" varchar(255) NOT NULL,
    "active" boolean DEFAULT true,
    "user_type" varchar(255),
    agent_user_id varchar(255),
    ca_user_id varchar(255),
    created_ts timestamp not null default current_timestamp,
    created_by varchar(255),
    last_modified_ts timestamp not null default current_timestamp,
    last_modified_by varchar(255),
    deleted_ts timestamp,
    deleted_by varchar(255),
    version int not null default 1
);

CREATE TABLE if not exists "RoleUser" (
    "id" varchar(255) PRIMARY KEY,
    "role_id" varchar(255),
    "user_id" varchar(255)
);


CREATE TABLE if not exists "oauth_access_token" (
    "authentication_id" varchar(255) PRIMARY KEY,
    "token_id" varchar(255) not null,
    "token" bytea,
    "user_name" varchar(255),
    "client_id" varchar(255),
    "authentication" bytea,
    "refresh_token" varchar(255)
);

CREATE TABLE if not exists "oauth_refresh_token" (
    "token_id" varchar(255) PRIMARY KEY,
    "token" bytea,
    "authentication" bytea
);

ALTER TABLE "PermissionComponent" ADD FOREIGN KEY ("group_id") REFERENCES "PermissionComponentGroup" ("id");

ALTER TABLE "PermissionComponentAction" ADD FOREIGN KEY ("action_id") REFERENCES "PermissionAction" ("id");

ALTER TABLE "PermissionComponentAction" ADD FOREIGN KEY ("component_id") REFERENCES "PermissionComponent" ("id");

ALTER TABLE "RolePermissionComponent" ADD FOREIGN KEY ("role_id") REFERENCES "Role" ("id");

ALTER TABLE "RolePermissionComponent" ADD FOREIGN KEY ("component_id") REFERENCES "PermissionAction" ("id");

ALTER TABLE "RoleUser" ADD FOREIGN KEY ("role_id") REFERENCES "Role" ("id");

ALTER TABLE "RoleUser" ADD FOREIGN KEY ("user_id") REFERENCES "User" ("id");
ALTER TABLE "User" ADD FOREIGN KEY ("agent_user_id") REFERENCES "User" ("id");
ALTER TABLE "User" ADD FOREIGN KEY ("ca_user_id") REFERENCES "User" ("id");



