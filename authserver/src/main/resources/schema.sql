-- App users

CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(512) NOT NULL,
    roles VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- OAuth2 registered client

CREATE TABLE oauth2_registered_client (
    id VARCHAR(100) PRIMARY KEY,
    client_id VARCHAR(100) NOT NULL,
    client_id_issued_at TIMESTAMP NOT NULL,
    client_secret VARCHAR(200) NOT NULL,
    client_secret_expires_at TIMESTAMP NULL,
    client_name VARCHAR(200) NOT NULL,
    client_authentication_methods VARCHAR(1000) NOT NULL,
    authorization_grant_types VARCHAR(1000) NOT NULL,
    redirect_uris VARCHAR(1000),
    post_logout_redirect_uris VARCHAR(1000) NULL,
    scopes VARCHAR(1000),
    client_settings BYTEA NULL,
    token_settings BYTEA NULL,
    PRIMARY KEY (id)
);

-- CREATE TABLE oauth2_authorization (
--     id VARCHAR(100) PRIMARY KEY,
--     registered_client_id VARCHAR(100) NOT NULL,
--     principal_name VARCHAR(200) NOT NULL,
--     authorization_grant_type VARCHAR(100) NOT NULL,
--     attributes BYTEA NULL,
--     state VARCHAR(100) NULL,
--     authorization_code_value BYTEA NULL,
--     authorization_code_issued_at TIMESTAMP NULL,
--     authorization_code_expires_at TIMESTAMP NULL,
--     authorization_code_metadata BYTEA NULL,
--     access_token_value BYTEA NULL,
--     access_token_issued_at TIMESTAMP NULL,
--     access_token_expires_at TIMESTAMP NULL,
--     access_token_metadata BYTEA NULL,
--     access_token_type VARCHAR(100) NULL,
--     access_token_scopes VARCHAR(1000) NULL,
--     refresh_token_value BYTEA NULL,
--     refresh_token_issued_at TIMESTAMP NULL,
--     refresh_token_expires_at TIMESTAMP NULL,
--     refresh_token_metadata BYTEA NULL
-- );

-- CREATE TABLE oauth2_authorization_consent (
--     registered_client_id VARCHAR(100) NOT NULL,
--     principal_name VARCHAR(200) NOT NULL,
--     authorities VARCHAR(1000) NOT NULL,
--     PRIMARY KEY (registered_client_id, principal_name)
-- );