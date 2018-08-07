create table oauth_client_details (
  client_id varchar(255) primary key,
  resource_ids varchar(255),
  client_secret varchar(255),
  scope varchar(255),
  authorized_grant_types varchar(255),
  web_server_redirect_uri varchar(255),
  authorities varchar(255),
  access_token_validity integer,
  refresh_token_validity integer,
  additional_information varchar(4096),
  autoapprove varchar(255)
);

create table oauth_client_token (
  token_id varchar(255),
  token blob,
  authentication_id varchar(255) primary key,
  user_name varchar(255),
  client_id varchar(255)
);

create table oauth_access_token (
  token_id varchar(255),
  token blob,
  authentication_id varchar(255) primary key,
  user_name varchar(255),
  client_id varchar(255),
  authentication blob,
  refresh_token varchar(255)
);

create table oauth_refresh_token (
  token_id varchar(255),
  token blob,
  authentication blob
);

create table oauth_code (
  code varchar(255),
  authentication blob
);

create table oauth_approvals (
  userid varchar(255),
  clientid varchar(255),
  scope varchar(255),
  status varchar(10),
  expiresat timestamp,
  lastmodifiedat timestamp null default null
);
