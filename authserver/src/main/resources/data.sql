INSERT INTO app_user(id, username, password, roles)
VALUES (1, 'admin', '$2a$12$T1PCr4SMIHsOHC6ZORBkduUaS0MsY9SAcj9LmW8o/3uCA0Gd7wX3W', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO app_user(id, username, password, roles)
VALUES (2, 'user1', '$2a$12$z7wIBKbCwL16kylIE4sJgOS5nSAS.ixmv9bLpWIoZGlTEohYz5O4u', 'ROLE_USER');

-- Insert a sample registered client with client_id `client` and client_secret
-- bcrypt `secret` value as `$2a$04$pRuurzYmCj1tvCAeQyXNO.yAmsAb0uenJLAwYdq6Giv0CQdf4wwbm`
INSERT INTO oauth2_registered_client (
    id, 
    client_id, 
    client_id_issued_at, 
    client_secret, 
    client_secret_expires_at,
    client_name, 
    client_authentication_methods, 
    authorization_grant_types,
    redirect_uris, 
    post_logout_redirect_uris, 
    scopes, 
    client_settings, 
    token_settings
)
VALUES (
    '1', 
    'client', 
    CURRENT_TIMESTAMP, 
    '$2a$04$pRuurzYmCj1tvCAeQyXNO.yAmsAb0uenJLAwYdq6Giv0CQdf4wwbm', 
    NULL,
    'Messaging Client', 
    'client_secret_basic', 
    'authorization_code,client_credentials,refresh_token',
    'http://127.0.0.1:4200/authorized', 
    '',
    'openid', 
    '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":true,"settings.client.require-authorization-consent":false}', 
    '{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.x509-certificate-bound-access-tokens":false,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000],"settings.token.device-code-time-to-live":["java.time.Duration",300.000000000]}'
);
