DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(250) NOT NULL,
  title VARCHAR(250) NOT NULL,
  content VARCHAR(250) DEFAULT NULL
);
INSERT INTO posts (category, title, content) VALUES
  ('Java', 'How to use anyMatch in Streams', 'anyMatch returns a boolean if it matches criteria'),
  ('Emacs', 'How to bring up help', 'Hit Ctrl-h i which will bring up the help section');

INSERT INTO users (firstName) VALUES
  ('Bill'),
  ('Chelsea');
