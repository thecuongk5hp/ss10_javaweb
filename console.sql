create database ss10;

use ss10;

create table Account
(
    username varchar(50) not null,
    password text,
    email    varchar(255)
);

create table Document
(
    title       varchar(255) not null,
    description varchar(255) not null,
    file        longblob     not null
);

create table UploadFile
(
    file_url    text         not null,
    description varchar(255) not null
);

delimiter //
create procedure create_account(
    username_in varchar(50),
    password_in text,
    email_in varchar(255)
)
begin
    insert into Account(username, password, email)
    values (username_in, password_in, email_in);
end;

create procedure create_doccument(
    title_in varchar(255),
    description_in varchar(255),
    file_in longblob
)
begin
    insert into Document(title, description, file)
    values (title_in, description_in, file_in);
end;

create procedure create_UploadFile(
    file_url_in    text,
    description_in varchar(255)
)
begin
    insert into UploadFile(file_url, description)
        values (file_url_in, description_in);
end;
delimiter //