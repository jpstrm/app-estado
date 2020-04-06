-- Insert initial data

INSERT INTO estado
  (id, name, code, created_at, flag_url)
  VALUES(1, 'Rio Grande do Sul', 'RS', '2020-04-05 10:00:00.320000000',
  'https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Bandeira_do_Rio_Grande_do_Sul.svg/2000px-Bandeira_do_Rio_Grande_do_Sul.svg.png'),
  (2, 'Santa Catarina', 'SC', '2020-04-05 10:00:00.320000000',
  'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Bandeira_de_Santa_Catarina.svg/1200px-Bandeira_de_Santa_Catarina.svg.png'),
  (3, 'Paraná', 'PR', '2020-04-05 10:00:00.320000000',
  'https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Bandeira_do_Paran%C3%A1.svg/1200px-Bandeira_do_Paran%C3%A1.svg.png');

INSERT INTO cidade
  (id, name, population, state_id, created_at)
  VALUES(1, 'Porto Alegre', '1409000', 1, '2020-04-05 10:00:00.320000000'),
  (2, 'Florianópolis', '477798', 2, '2020-04-05 10:00:00.320000000'),
  (3, 'Curitiba', '1765000', 3, '2020-04-05 10:00:00.320000000');
