CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    body       varchar(100),
    post_id    int,
    username   varchar(100),
    updated_at timestamp
);