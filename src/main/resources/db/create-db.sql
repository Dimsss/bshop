 CREATE TABLE users (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 0, INCREMENT BY 1) PRIMARY KEY NOT NULL,
  name VARCHAR(30) NOT NULL,
  email  VARCHAR(50) NOT NULL
);
