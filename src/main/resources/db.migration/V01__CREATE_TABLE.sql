CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS person (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE  IF NOT EXISTS task (
    id uuid PRIMARY KEY,
    title VARCHAR(255) ,
    description VARCHAR(255),
    priorityLevel VARCHAR(255),
    endDate DATE,
    isDeleted Boolean,
    person_id UUID REFERENCES "person" (id)
    );
