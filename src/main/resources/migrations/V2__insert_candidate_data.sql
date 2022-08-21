insert into candidates(id, name, number, political_party, office, description)
values
    (1, 'Juca', 12, 'USP', 'Governador', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ante mauris, fringilla ut finibus ut, laoreet sit amet elit. Aliquam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ante mauris, fringilla ut finibus ut, laoreet sit amet elit. Aliquam.'),
    (2, 'Nelsinho', 1234, 'UNESP', 'Deputado Federal', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ante mauris, fringilla ut finibus ut, laoreet sit amet elit. Aliquam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ante mauris, fringilla ut finibus ut, laoreet sit amet elit. Aliquam.'),
    (3, 'José', 12345, 'UFSCar', 'Deputado Estadual', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ante mauris, fringilla ut finibus ut, laoreet sit amet elit. Aliquam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ante mauris, fringilla ut finibus ut, laoreet sit amet elit. Aliquam.');

insert into career(id, candidate_id, office, start_year, end_year)
values
    (1, 1, 'Deputado Estadual', 2011, 2014),
    (2, 1, 'Deputado Federal', 2015, 2018),
    (3, 1, 'Senador', 2019, null),
    (4, 2, 'Deputado Estadual', 2015, 2018),
    (5, 2, 'Deputado Federal', 2018, null),
    (6, 3, 'Deputado Estadual', 2018, null);

insert into projects(id, candidate_id, title, description)
values
    (1, 1, 'Meio Ambiente', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vel tincidunt dolor.'),
    (2, 1, 'Moradia', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vel tincidunt dolor.'),
    (3, 1, 'Diversidade', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vel tincidunt dolor.'),
    (4, 2, 'Combate ao Desmatamento', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vel tincidunt dolor.'),
    (5, 2, 'Escola Integral', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vel tincidunt dolor.'),
    (6, 3, 'Faculdade Para Todos', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vel tincidunt dolor.'),
    (7, 3, 'Livros Para Quem Precisa', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vel tincidunt dolor.');
