-- Drop old tables
DROP TABLE IF EXISTS cidade CASCADE;

DROP TABLE IF EXISTS estado CASCADE;

CREATE TABLE estado (
  id BIGINT NOT NULL AUTO_INCREMENT,
  code VARCHAR(255) DEFAULT NULL,
  flag_url VARCHAR(255) DEFAULT NULL,
  name VARCHAR(255) DEFAULT NULL,
  created_at DATETIME NOT NULL,
  updated_at DATETIME DEFAULT NULL,
PRIMARY KEY (id)
) CHARSET=utf8mb4;

-- Create DB
CREATE TABLE cidade (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) DEFAULT NULL,
  population BIGINT DEFAULT NULL,
  state_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  created_at DATETIME NOT NULL,
  updated_at DATETIME DEFAULT NULL,
  KEY cidade_estado_fk (state_id),
  CONSTRAINT cidade_estado_fk FOREIGN KEY (state_id) REFERENCES estado (id)
) CHARSET=utf8mb4;
