
CREATE TABLE student
(
    id    INT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)       NULL,
    score DOUBLE             NOT NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);
