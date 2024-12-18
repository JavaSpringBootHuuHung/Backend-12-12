CREATE TABLE user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    username   VARCHAR(255)          NULL,
    password   VARCHAR(255)          NULL,
    profile_id BIGINT                NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_profile
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    email VARCHAR(255)          NULL,
    phone VARCHAR(255)          NULL,
    CONSTRAINT pk_userprofile PRIMARY KEY (id)
);

ALTER TABLE user
    ADD CONSTRAINT uc_user_profile UNIQUE (profile_id);

ALTER TABLE user
    ADD CONSTRAINT uc_user_username UNIQUE (username);

ALTER TABLE user_profile
    ADD CONSTRAINT uc_userprofile_email UNIQUE (email);

ALTER TABLE user_profile
    ADD CONSTRAINT uc_userprofile_phone UNIQUE (phone);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_PROFILE FOREIGN KEY (profile_id) REFERENCES user_profile (id);

;