create database  project_manager with owner postgres;

create schema if not exists public;

comment on schema public is 'Experience_WithSQL';

alter schema public owner to postgres;

create table skills
(
    skills_id   SERIAL,
    skill_name  VARCHAR(30) NOT NULL,
    skill_level VARCHAR(30),
    PRIMARY KEY (skills_id)

);

alter table skills
    owner to postgres;


create table customers
(
    customer_id SERIAL,
    name        VARCHAR(25) NOT NULL,
    email       VARCHAR(25) NOT NULL,
    PRIMARY KEY (customer_id),
    UNIQUE (name),
    UNIQUE (email)

);

alter table customers
    owner to postgres;

create table companies
(
    company_id SERIAL,
    name       VARCHAR(25) NOT NULL,
    country    VARCHAR(25) NOT NULL,
    PRIMARY KEY (company_id),
    UNIQUE (name)
);

alter table companies
    owner to postgres;


create table projects
(
    project_id SERIAL,
    name       VARCHAR(25) NOT NULL,
    dead_line  date,
    PRIMARY KEY (project_id),
    UNIQUE (name)
);

alter table projects
    owner to postgres;

create table developers
(
    developer_id SERIAL,
    name         VARCHAR(25) NOT NULL,
    salary       INT,
    sex          VARCHAR(10),
    age          INT,
    PRIMARY KEY (developer_id),
    UNIQUE (name)
);

alter table developers
    owner to postgres;


create table companies_projects
(
    company_id INT,
    project_id INT,
    PRIMARY KEY (company_id,project_id),
    FOREIGN KEY (company_id) REFERENCES companies(company_id),
    FOREIGN KEY (project_id) REFERENCES projects(project_id)
);
alter table companies_projects
    owner to postgres;

create table customer_projects
(
    customer_id INT,
    project_id INT,
    PRIMARY KEY (customer_id,project_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (project_id) REFERENCES projects(project_id)
);
alter table customer_projects
    owner to postgres;

create table developers_skills
(
    developer_id INT,
    skill_id INT,
    PRIMARY KEY (developer_id,skill_id),
    FOREIGN KEY (developer_id) REFERENCES developers(developer_id),
    FOREIGN KEY (skill_id) REFERENCES skills(skills_id)
);

alter table companies_projects
    owner to postgres;


create table developers_projects
(
    developer_id INT,
    project_id INT,
    PRIMARY KEY (developer_id,project_id),
    FOREIGN KEY (developer_id) REFERENCES developers(developer_id),
    FOREIGN KEY (project_id) REFERENCES projects(project_id)
);
alter table companies_projects
    owner to postgres;


