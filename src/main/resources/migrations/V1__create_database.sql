create table candidates(
    id integer primary key,
    candidate_name varchar(30) not null,
    candidate_number numeric(5) not null,
    political_party varchar(30) not null,
    description text
);

create table career(
    id integer primary key,
    candidate_id integer not null,
    title varchar(30) not null,
    start_year numeric(4) NOT NULL,
    end_year numeric(4),
    constraint fk_candidate_career foreign key (candidate_id) references candidates (id)
);

create table projects(
    id integer primary key,
    candidate_id integer not null,
    title varchar(30) not null,
    description text,
    constraint fk_candidate_projects foreign key (candidate_id) references candidates (id)
);
