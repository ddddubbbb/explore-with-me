CREATE TABLE IF NOT EXISTS statistics (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  app VARCHAR(255) NOT NULL,
  uri VARCHAR(255) NOT NULL,
  ip VARCHAR(40) NOT NULL,
  timestamp TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT pk_stat PRIMARY KEY (id)
);