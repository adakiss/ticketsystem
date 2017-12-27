DROP TABLE customer CASCADE;

CREATE TABLE customer (
	customer_id SERIAL NOT NULL,
	customer_name CHARACTER VARYING(100) NOT NULL,
	customer_email CHARACTER VARYING(255) NOT NULL,
	customer_phone CHARACTER VARYING(50),
	CONSTRAINT PK_CUSTOMER_ID PRIMARY KEY (customer_id),
	CONSTRAINT UNI_CUSTOMER_EMAIL UNIQUE (customer_email)
);

CREATE UNIQUE INDEX UI_CUSTOMER_EMAIL ON customer USING btree (customer_email);


DROP TABLE location CASCADE;

CREATE TABLE location (
	location_id SERIAL NOT NULL,
	location_name CHARACTER VARYING(100) NOT NULL,
	location_address CHARACTER VARYING(255) NOT NULL,
	location_capacity REAL NOT NULL,
	CONSTRAINT PK_LOCATION_ID PRIMARY KEY (location_id),
	CONSTRAINT UNI_LOCATION_ADDRESS UNIQUE (location_address)
);

CREATE UNIQUE INDEX UI_LOCATION_ADDRESS ON location USING btree (location_address);


DROP TABLE organiser CASCADE;

CREATE TABLE organiser (
	organiser_id SERIAL NOT NULL,
	organiser_name CHARACTER VARYING(100) NOT NULL,
	organiser_email CHARACTER VARYING(255) NOT NULL,
	organiser_phone CHARACTER VARYING(50),
	organiser_address CHARACTER VARYING(255),
	CONSTRAINT PK_ORGANISER_ID PRIMARY KEY (organiser_id),
	CONSTRAINT UNI_ORGANISER_NAME UNIQUE (organiser_name)
);

CREATE UNIQUE INDEX UI_ORGANISER_NAME ON organiser USING btree (organiser_name);


DROP TABLE event CASCADE;

CREATE TABLE event (
	event_id SERIAL NOT NULL,
    event_name CHARACTER VARYING(100),
    event_location INTEGER NOT NULL,
    event_time DATE NOT NULL,
    event_allticket INTEGER NOT NULL,
    event_soldticket INTEGER NOT NULL,
    event_organiser INTEGER NOT NULL,
    event_price INTEGER NOT NULL,
    CONSTRAINT PK_EVENT_ID PRIMARY KEY (event_id),
    CONSTRAINT FK_EVENT_LOC FOREIGN KEY (event_location)
    	REFERENCES location (location_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
    CONSTRAINT FK_EVENT_ORG FOREIGN KEY (event_organiser)
    	REFERENCES organiser (organiser_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE UNIQUE INDEX UI_EVENT_FIELDS ON event USING btree (event_name, event_location, event_time);


DROP TABLE ticket CASCADE;

CREATE TABLE ticket (
	ticket_id SERIAL NOT NULL,
	ticket_buyer INTEGER NOT NULL,
	ticket_event INTEGER NOT NULL,
	ticket_ordercode CHARACTER VARYING(30) NOT NULL,
	ticket_resell BOOLEAN,
	CONSTRAINT PK_TICKET_ID PRIMARY KEY (ticket_id),
	CONSTRAINT FK_TICKET_BUYER FOREIGN KEY (ticket_buyer)
		REFERENCES customer (customer_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT FK_TICKET_EVENT FOREIGN KEY (ticket_event)
		REFERENCES event (event_id) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT UNI_TICKET_ORDERCODE UNIQUE (ticket_ordercode)
);

CREATE UNIQUE INDEX UI_EVENT_ORDERCODE ON ticket USING btree (ticket_ordercode);