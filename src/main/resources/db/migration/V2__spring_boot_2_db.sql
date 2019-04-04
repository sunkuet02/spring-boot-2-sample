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


INSERT INTO oauth_client_details(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
	VALUES ('webapp-rw', 'rest-api',
	/*webapp-rw-1234*/'$2a$08$49JYtw8CmIJ3Bh3cYRgnR.ppsgRK59ZHzLjHI2U9SAejuNYmCqIO.',
	'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 1080000, 2592000);


INSERT INTO oauth_user(ID, username, PASSWORD, ACCOUNT_EXPIRED, ACCOUNT_LOCKED, CREDENTIALS_EXPIRED, ENABLED)
  VALUES (1, 'admin', /*admin1234*/'$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', FALSE, FALSE, FALSE, TRUE);
INSERT INTO oauth_user(ID, username, PASSWORD, ACCOUNT_EXPIRED, ACCOUNT_LOCKED, CREDENTIALS_EXPIRED, ENABLED)
  VALUES (2, 'reader', /*reader1234*/'$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe', FALSE, FALSE, FALSE, TRUE);


INSERT INTO oauth_authority(ID, NAME) VALUES (1, 'ADMIN');
INSERT INTO oauth_authority(ID, NAME) VALUES (2, 'USER');

INSERT INTO oauth_user_authorities(user_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO oauth_user_authorities(user_ID, AUTHORITY_ID) VALUES (2, 2);
