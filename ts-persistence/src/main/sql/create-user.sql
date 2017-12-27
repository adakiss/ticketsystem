CREATE USER ticketsystem_user;
ALTER USER ticketsystem_user PASSWORD
'123456';
GRANT ticketsystem_role TO ticketsystem_user;