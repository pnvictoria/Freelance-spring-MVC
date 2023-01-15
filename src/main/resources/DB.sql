SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

CREATE SCHEMA public;

ALTER SCHEMA public OWNER TO postgres;

COMMENT ON SCHEMA public IS 'standard public schema';

CREATE SEQUENCE public.account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.account_id_seq OWNER TO postgres;

SET default_tablespace = '';

CREATE TABLE public.account (
                                account_id integer DEFAULT nextval('public.account_id_seq'::regclass) NOT NULL,
                                email character varying(50) NOT NULL,
                                password character varying(30) NOT NULL,
                                phone character varying(15),
                                description text,
                                country_fk integer,
                                role_fk integer NOT NULL,
                                name character varying(50) NOT NULL,
                                surname character varying(50) NOT NULL,
                                sex boolean
);

ALTER TABLE public.account OWNER TO freelance_dev;

CREATE TABLE public.country (
                                country_id integer NOT NULL,
                                country_name character varying(100) NOT NULL
);

ALTER TABLE public.country OWNER TO freelance_dev;

CREATE TABLE public.order_account (
                                      order_customer_fk integer NOT NULL,
                                      account_executor_fk integer NOT NULL
);

ALTER TABLE public.order_account OWNER TO freelance_dev;

CREATE TABLE public.orders (
                               order_id integer NOT NULL,
                               title_order character varying(200) NOT NULL,
                               description_order text,
                               registration_date date,
                               price integer NOT NULL,
                               account_fk integer NOT NULL
);

ALTER TABLE public.orders OWNER TO freelance_dev;

CREATE TABLE public.request (
                                request_id integer NOT NULL,
                                account_fk integer NOT NULL,
                                order_fk integer NOT NULL,
                                request_description character varying(250) NOT NULL
);

ALTER TABLE public.request OWNER TO freelance_dev;

CREATE TABLE public.skills (
                               skills_id integer NOT NULL,
                               skills_title character varying(50) NOT NULL,
                               specialization_fk integer NOT NULL
);

ALTER TABLE public.skills OWNER TO freelance_dev;

CREATE TABLE public.specialization (
                                       specialization_id integer NOT NULL,
                                       specialization_title character varying(50) NOT NULL
);

ALTER TABLE public.specialization OWNER TO freelance_dev;

SELECT pg_catalog.setval('public.account_id_seq', 48, true);

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (account_id);

ALTER TABLE ONLY public.country
    ADD CONSTRAINT country_pkey PRIMARY KEY (country_id);

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT order_pkey PRIMARY KEY (order_id);

ALTER TABLE ONLY public.request
    ADD CONSTRAINT request_pkey PRIMARY KEY (request_id);

ALTER TABLE ONLY public.skills
    ADD CONSTRAINT skills_pkey PRIMARY KEY (skills_id);

ALTER TABLE ONLY public.specialization
    ADD CONSTRAINT specialization_pkey PRIMARY KEY (specialization_id);


ALTER TABLE ONLY public.order_account
    ADD CONSTRAINT account_executor_fk FOREIGN KEY (account_executor_fk) REFERENCES public.account(account_id);

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT account_fk FOREIGN KEY (account_fk) REFERENCES public.account(account_id) NOT VALID;

ALTER TABLE ONLY public.request
    ADD CONSTRAINT account_fk FOREIGN KEY (account_fk) REFERENCES public.account(account_id);

ALTER TABLE ONLY public.account
    ADD CONSTRAINT country_fk FOREIGN KEY (country_fk) REFERENCES public.country(country_id) NOT VALID;

ALTER TABLE ONLY public.order_account
    ADD CONSTRAINT order_customer_fk FOREIGN KEY (order_customer_fk) REFERENCES public.orders(order_id);

ALTER TABLE ONLY public.request
    ADD CONSTRAINT order_fk FOREIGN KEY (order_fk) REFERENCES public.orders(order_id);

ALTER TABLE ONLY public.skills
    ADD CONSTRAINT specialization_fk FOREIGN KEY (specialization_fk) REFERENCES public.specialization(specialization_id);

