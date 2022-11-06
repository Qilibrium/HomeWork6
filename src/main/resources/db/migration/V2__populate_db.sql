--ADD WORKERS
INSERT INTO worker (name, birthday, level, salary) VALUES
('Anton Shevshuk', '1986-09-12', 'Trainee', 300),
('Sergiy Nemchinskiy', '1974-01-21', 'Senior', 5000),
('Vasiliy Rogoviy', '2000-01-23', 'Trainee', 500),
('Dmitriy Nevzorov', '1980-01-11', 'Middle', 3000),
('Oleg Vinnik', '1978-12-21', 'Senior', 7000),
('Svitlana Berukova', '1992-09-09', 'Middle', 4000),
('Evgeniy Onegin', '1974-01-09', 'Senior', 6000),
('Anatoliy Bespaliy', '1989-12-02', 'Middle', 3500),
('Ivan Dragunov', '1995-03-23', 'Trainee', 300),
('Sergiy Shevchuk', '1996-06-07', 'Middle', 2500);

--ADD CLIENTS
INSERT INTO client (name) VALUES
('Svitlana Noskova'),
('Dmitro Kovalchuk'),
('Oksana Tkachuk'),
('Pavlo Zibrov'),
('Orest Podolyanskiy'),
('Oleksandr Shapko');

--ADD PROJECT
INSERT INTO project (client_id, start_date, finish_date) VALUES
(1, '2021-08-15', '2022-12-15'),(1, '2022-08-15', '2023-12-15'),
(2, '2021-07-25', '2023-03-25'),(2, '2021-07-25', '2023-12-25'),(2, '2022-08-18', '2023-12-18'),(2, '2022-08-19', '2023-12-19'),
(3, '2021-08-15', '2023-12-15'),(3, '2022-08-11', '2023-12-11'),
(4, '2021-08-01', '2023-12-01'),(4, '2022-08-01', '2023-12-01'),(4, '2022-08-30', '2023-12-30'),
(5, '2022-08-15', '2022-12-15'),(5, '2022-08-25', '2023-12-25'),
(6, '2022-08-29', '2023-12-29'),(6, '2022-08-02', '2022-10-02');

--ADD WORKER_PROJECT
INSERT INTO project_worker(worker_id, project_id) VALUES
(2,1),(2,3),(2,5),(2,9),
(4,1),(4,6),
(6,4),(6,12),
(8,3),(8,14),
(10,4),(10,7),
(1,14),
(3,2),(3,10),(3,12),(3,14),
(5,6),(5,11),(5,14),
(7,7),(7,12),(7,13),(7,14),
(9,5),(9,12),(9,15); 