--create worker
CREATE TABLE worker (
   id IDENTITY PRIMARY KEY,
   name VARCHAR (1000) NOT NULL,
   birthday DATE,
   level VARCHAR NOT NULL,
   salary INT
);

ALTER TABLE worker
    ADD CONSTRAINT min_salary CHECK ((salary) >= 100);
ALTER TABLE worker
    ADD CONSTRAINT max_salary CHECK ((salary) <= 100000);
ALTER TABLE worker
    ADD CONSTRAINT worker_birthday CHECK ((birthday) >= '1900-01-01');
ALTER TABLE worker
   ADD CONSTRAINT level_enum_values
   CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior'));

--create client
CREATE TABLE client (
   id IDENTITY PRIMARY KEY,
   name VARCHAR (1000) NOT NULL
);

--create project
CREATE TABLE project (
   id IDENTITY PRIMARY KEY,
   client_id INTEGER,
   start_date DATE,
   finish_date DATE
);
--UPDATE PROJECT
ALTER TABLE project
ADD CONSTRAINT client_id_fk
FOREIGN KEY(client_id) REFERENCES client(id) ON DELETE CASCADE;


--ADD project_worker
CREATE TABLE project_worker (
   worker_id BIGINT NOT NULL,
   project_id BIGINT NOT NULL,
   PRIMARY KEY (worker_id, project_id),
   FOREIGN KEY(worker_id) REFERENCES worker(id) ON DELETE CASCADE ,
   FOREIGN KEY(project_id) REFERENCES project(id) ON DELETE CASCADE
);



