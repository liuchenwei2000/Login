CREATE
    TABLE web_user
    (
        pk_user CHAR(36) NOT NULL,
        username VARCHAR(50) NOT NULL,
        password VARCHAR(20) NOT NULL,
        email VARCHAR(50),
        mobile VARCHAR(20),
        PRIMARY KEY (pk_user)
    )