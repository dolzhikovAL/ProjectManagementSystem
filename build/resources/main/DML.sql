INSERT INTO skills (skill_name, skill_level)
VALUES ('Java', 'Junior');
INSERT INTO skills (skill_name, skill_level)
VALUES ('Java', 'Middle');
INSERT INTO skills (skill_name, skill_level)
VALUES ('Java', 'Senior');
INSERT INTO skills (skill_name, skill_level)
VALUES ('C++', 'Junior');
INSERT INTO skills (skill_name, skill_level)
VALUES ('C++', 'Middle');
INSERT INTO skills (skill_name, skill_level)
VALUES ('C++', 'Senior');
INSERT INTO skills (skill_name, skill_level)
VALUES ('C#', 'Junior');
INSERT INTO skills (skill_name, skill_level)
VALUES ('C#', 'Middle');
INSERT INTO skills (skill_name, skill_level)
VALUES ('C#', 'Senior');
INSERT INTO skills (skill_name, skill_level)
VALUES ('JS', 'Junior');
INSERT INTO skills (skill_name, skill_level)
VALUES ('JS', 'Middle');
INSERT INTO skills (skill_name, skill_level)
VALUES ('JS', 'Senior');

INSERT INTO developers(name,salary, sex, age)
VALUES ('Ivan Ivanov','15000', 'Male','33');
INSERT INTO developers(name,salary, sex, age)
VALUES ('Petr Petrov', '25000','Male','29');
INSERT INTO developers(name,salary, sex, age)
VALUES ('Olga Olina', '7000','Female','25');
INSERT INTO developers(name,salary, sex, age)
VALUES ('Svetlana Svetina','16000', 'Female','31');
INSERT INTO developers(name,salary, sex, age)
VALUES ('Nikolay Nikolaev', '35000','Male','50');
INSERT INTO developers(name, salary,sex, age)
VALUES ('Semen Semenov','27000', 'Male','60');
INSERT INTO developers(name, salary,sex, age)
VALUES ('Alexey Alexeev', '18000','Male','19');
INSERT INTO developers(name,salary, sex, age)
VALUES ('Alex Alexandrov', '18000','Male','35');
INSERT INTO developers(name, salary,sex, age)
VALUES ('Victor Victorov','20000', 'Male','80');

INSERT INTO customers(name,email)
VALUES ('Vladimir Klichko', 'Klichko@gmail.com');
INSERT INTO customers(name,email)
VALUES ('Kostya Dzyu', 'Dzyu@gmail.com');
INSERT INTO customers(name,email)
VALUES ('Alexander Usik ', 'Usik@gmail.com');
INSERT INTO customers(name,email)
VALUES ('Dinamo', 'Dinamo@gmail.com');
INSERT INTO customers(name,email)
VALUES ('Dnipro', 'Dnipro@gmail.com');

INSERT INTO companies(name, country)
VALUES ('UMS', 'Ukraine');
INSERT INTO companies(name, country)
VALUES ('BeeLine', 'Russia');
INSERT INTO companies(name, country)
VALUES ('VodaPhone', 'Germany');
INSERT INTO companies(name, country)
VALUES ('KievStar', 'ukraine');

INSERT INTO projects(name,dead_line)
VALUES ('Site_KMDA', '11-11-2020');
INSERT INTO projects(name,dead_line)
VALUES ('Training_Program', '05-10-2020');
INSERT INTO projects(name,dead_line)
VALUES ('Politics_Program', '01-05-2020');
INSERT INTO projects(name,dead_line)
VALUES ('Team_Museum', '21-10-2020');
INSERT INTO projects(name,dead_line)
VALUES ('Where_the_team', '01-01-2030');
INSERT INTO projects(name,dead_line)
VALUES ('Internet_Market', '01-01-2021');

INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('1', '2');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('1', '5');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('2', '3');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('3', '4');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('4', '8');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('4', '10');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('5', '6');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('5', '9');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('6', '12');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('7', '7');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('8', '8');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('9', '10');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('9', '4');
INSERT INTO developers_skills(developer_id, skill_id)
VALUES ('9', '1');

INSERT INTO customer_projects(customer_id, project_id)
VALUES ('1', '1');
INSERT INTO customer_projects(customer_id, project_id)
VALUES ('1', '2');
INSERT INTO customer_projects(customer_id, project_id)
VALUES ('1', '3');
INSERT INTO customer_projects(customer_id, project_id)
VALUES ('2', '2');
INSERT INTO customer_projects(customer_id, project_id)
VALUES ('3', '2');
INSERT INTO customer_projects(customer_id, project_id)
VALUES ('4', '2');
INSERT INTO customer_projects(customer_id, project_id)
VALUES ('4', '4');
INSERT INTO customer_projects(customer_id, project_id)
VALUES ('4', '6');
INSERT INTO customer_projects(customer_id, project_id)
VALUES ('5', '5');

INSERT INTO companies_projects(company_id, project_id)
VALUES ('1', '6');
INSERT INTO companies_projects(company_id, project_id)
VALUES ('1', '2');
INSERT INTO companies_projects(company_id, project_id)
VALUES ('2', '2');
INSERT INTO companies_projects(company_id, project_id)
VALUES ('2', '6');
INSERT INTO companies_projects(company_id, project_id)
VALUES ('3', '5');
INSERT INTO companies_projects(company_id, project_id)
VALUES ('4', '1');
INSERT INTO companies_projects(company_id, project_id)
VALUES ('4', '4');
INSERT INTO companies_projects(company_id, project_id)
VALUES ('4', '3');

INSERT INTO developers_projects(developer_id, project_id)
VALUES ('9', '1');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('4', '1');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('1', '1');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('1', '2');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('5', '2');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('7', '3');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('9', '3');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('1', '4');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('6', '4');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('9', '5');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('8', '5');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('2', '6');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('6', '6');
INSERT INTO developers_projects(developer_id, project_id)
VALUES ('5', '6');