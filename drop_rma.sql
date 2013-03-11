drop schema `rma`;
USE mysql;
DELETE FROM user WHERE User= 'rma_user';
delete from db where user='rma_user';
FLUSH PRIVILEGES;