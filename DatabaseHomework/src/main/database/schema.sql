DROP TABLE IF EXISTS accommodation;

DROP TABLE IF EXISTS room_fare;

DROP TABLE IF EXISTS accommodation_room_fare_relation;

create table accommodation(
id SERIAL not null,
acc_type varchar(32),
bed_type varchar(32) check(bed_type='single_bed'or bed_type='double_bed'or bed_type='twin_bed'or bed_type='triple_bed'or bed_type='quad' ),
max_guests integer,
description varchar(512),
constraint accommodation_id_pk primary key(id)
);
create table room_fare(
id SERIAL not null,
value decimal,
season varchar(32)check(season='peak_season'or season='off_peak_season'or season='special_events'or season='day_of_the_week'or season='advance_booking'),
constraint room_fare_id_pk primary key(id)
);
create table accommodation_room_fare_relation(
id SERIAL not null,
accommodation_id integer references accommodation(id),
room_fare_id integer references room_fare(id),
constraint accommodation_room_fare_relation_id_pk primary key(id)
);