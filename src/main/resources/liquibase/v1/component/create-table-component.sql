CREATE TABLE component (
    id              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    brand           VARCHAR(255) NOT NULL,
    model           VARCHAR(255) NOT NULL,
    category        VARCHAR(255) NOT NULL,
    price           DECIMAL(24, 2) NOT NULL,
    compatibility   VARCHAR(255) NOT NULL,
    PRIMARY KEY ( id )
);