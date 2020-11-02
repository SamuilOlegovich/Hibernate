--  название базы данных
CREATE DATABASE config_lesson_hibernate ENCODING 'UTF-8';
-- название таблицы в конце
CREATE TABLE IF NOT EXISTS engines(
--  поля в базе данных
  model VARCHAR(25) PRIMARY KEY,
  power INTEGER     NOT NULL
);

INSERT INTO engines (model, power) VALUES ('engine_model_01', 1250);
INSERT INTO engines (model, power) VALUES ('engine_model_02', 2820);