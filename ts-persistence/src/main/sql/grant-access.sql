GRANT SELECT, INSERT, UPDATE, DELETE ON
customer, location, organiser, event, ticket TO ticketsystem_role;

GRANT USAGE, SELECT, UPDATE ON
location_location_id_seq, organiser_organiser_id_seq, customer_customer_id_seq, event_event_id_seq, ticket_ticket_id_seq TO ticketsystem_role;