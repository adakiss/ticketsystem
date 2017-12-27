INSERT INTO customer (customer_name, customer_email, customer_phone)
VALUES ('Connor Cooke', 'ConnorCooke@dayrep.com', null);

INSERT INTO customer (customer_name, customer_email, customer_phone)
VALUES ('Aimee Wheeler', 'AimeeWheeler@armyspy.com', null);

INSERT INTO customer (customer_name, customer_email, customer_phone)
VALUES ('Sienna Warren', 'SiennaWarren@rhyta.com', '0036744356742');

INSERT INTO customer (customer_name, customer_email, customer_phone)
VALUES ('Morgan Jones', 'MorganJones@jourrapide.com', '+36436667777');


INSERT INTO location (location_name, location_address, location_capacity)
VALUES ('Z44', '1599 Candlelight Drive', 800);

INSERT INTO location (location_name, location_address, location_capacity)
VALUES ('Aquarium Club', '1220 Stratford Drive', 700);

INSERT INTO location (location_name, location_address, location_capacity)
VALUES ('GentleManS Club', '62 Eagles Nest Drive', 100);


INSERT INTO organiser (organiser_name, organiser_email, organiser_phone, organiser_address)
VALUES ('Merry Makers Inc', 'merrymakers@mmi.org', '00244131111', '2290 Strother Street');

INSERT INTO organiser (organiser_name, organiser_email, organiser_phone, organiser_address)
VALUES ('Midnight Productions', 'midnightprod@midnightprod.org', null, '2660 Huntz Lane');

INSERT INTO organiser (organiser_name, organiser_email, organiser_phone, organiser_address)
VALUES ('Chapanoke Entertainment', 'chapent@chapent.org', null, '1849 Ripple Street');


INSERT INTO event (event_name, event_location, event_time, event_allticket, event_soldticket, event_organiser, event_price)
VALUES ('Charade Of Pending', 1, CURRENT_DATE, 500, 0, 1, 300);

INSERT INTO event (event_name, event_location, event_time, event_allticket, event_soldticket, event_organiser, event_price)
VALUES ('Under-age Tissue', 2, CURRENT_DATE, 400, 0, 2, 1000);

INSERT INTO event (event_name, event_location, event_time, event_allticket, event_soldticket, event_organiser, event_price)
VALUES ('Sex Semester', 3, CURRENT_DATE, 100, 0, 3, 1000);


INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T0', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T1', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T2', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T3', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T4', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T5', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T6', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T7', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T8', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T9', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T10', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (1, 1, 'T11', false);

INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (2, 3, 'S0', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (2, 3, 'S1', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (2, 3, 'S2', true);

INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (4, 2, 'D0', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (4, 2, 'D1', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (3, 2, 'D2', false);
INSERT INTO ticket (ticket_buyer, ticket_event, ticket_ordercode, ticket_resell)
VALUES (3, 2, 'D3', false);

UPDATE public.event
SET event_soldticket=3
WHERE event_id=3;
	
UPDATE public.event
SET event_soldticket=4
WHERE event_id=2;
	
UPDATE public.event
SET event_soldticket=12
WHERE event_id=1;