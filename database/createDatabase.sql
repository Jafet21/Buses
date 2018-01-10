drop user buses cascade;

create user buses identified by buses;
grant connect to buses;
grant create session to buses;
grant resource to buses;
grant unlimited tablespace to buses;

connect buses/buses;

CREATE SEQUENCE seq START WITH 1 INCREMENT BY 1;

create table users(
    id number primary key,
    email varchar2(50) unique not null,
    name varchar2(50) not null,
    password varchar2(256) not null
);

create table companies(
    id number primary key,
    name varchar2(50) not null
);

create table routes(
    id number primary key,
    companyId number not null,
    description varchar2(100),
    startLatitude float not null,
    startLongitude float not null,
    endLatitude float not null,
    endLongitude float not null,
    estimatedTime number,
    CONSTRAINT fk_routes_company FOREIGN KEY (companyId) REFERENCES companies(id)
);

create table schedules(
    id number primary key,
    routeId number not null,
    hour timestamp not null,
    CONSTRAINT fk_schedules_routes FOREIGN KEY (routeId) REFERENCES routes(id)
);

create table comments(
    id number primary key,
    userId number not nulL,
    routeId number not null,
    content varchar2(250),
    time timestamp not null,
    CONSTRAINT fk_comments_user FOREIGN KEY (userId) REFERENCES users(id),
    CONSTRAINT fk_comments_routes FOREIGN KEY (routeId) REFERENCES routes(id)
);

