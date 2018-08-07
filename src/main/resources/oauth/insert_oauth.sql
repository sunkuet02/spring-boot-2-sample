INSERT INTO oauth_client_details(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
	VALUES ('webapp-rw', 'rest-api',
	/*webapp-rw-1234*/'$2a$08$49JYtw8CmIJ3Bh3cYRgnR.ppsgRK59ZHzLjHI2U9SAejuNYmCqIO.',
	'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 1080000, 2592000);
