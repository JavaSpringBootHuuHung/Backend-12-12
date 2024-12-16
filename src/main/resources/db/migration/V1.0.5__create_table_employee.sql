CREATE TABLE employee
(
    id            INT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)       NULL,
    birth_date    date               NULL,
    salary        DOUBLE             NOT NULL,
    gender        SMALLINT           NULL,
    phone         VARCHAR(255)       NULL,
    department_id INT                NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES department (id);