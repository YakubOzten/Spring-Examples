CREATE  SEQUENCE seq_users start 1 increment 1;

CREATE  TABLE users(
    id bigint Not NULL default nextval('seq_users'),
    username varchar(100) Not Null,
    firstname varchar(50) Not Null,
    lastname varchar(50) Not Null,
    primary key(id)
)