--
-- PostgreSQL database dump
--

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

SET default_tablespace = '';

SET default_table_access_method = heap;


CREATE TABLE public.employee (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    email character varying(255) NOT NULL
);


ALTER TABLE public.employee OWNER TO postgres;

CREATE SEQUENCE public.employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_id_seq OWNER TO postgres;

ALTER SEQUENCE public.employee_id_seq OWNED BY public.employee.id;

ALTER TABLE ONLY public.employee ALTER COLUMN id SET DEFAULT nextval('public.employee_id_seq'::regclass);

INSERT INTO public.employee VALUES (1, 'Le', 'Nguyen', 'LeNguyen@gmail.com');
INSERT INTO public.employee VALUES (2, 'Nguyen', 'Le', 'NguyenLe@gmail.com');
INSERT INTO public.employee VALUES (3, 'Huynh', 'Vu', 'HuynhVu@gmail.com');
INSERT INTO public.employee VALUES (4, 'Vu', 'Huynh', 'VuHuynh@gmail.com');
INSERT INTO public.employee VALUES (5, 'Tran', 'Pham', 'TranPham@gmail.com');
INSERT INTO public.employee VALUES (6, 'Pham', 'Tran', 'PhamTran@gmail.com');
INSERT INTO public.employee VALUES (7, 'Ly', 'Duong', 'LyDuong@gmail.com');
INSERT INTO public.employee VALUES (8, 'Duong', 'Bui', 'DuongBui@gmail.com');
INSERT INTO public.employee VALUES (9, 'Bui', 'Ly', 'BuiLy@gmail.com');


SELECT pg_catalog.setval('public.employee_id_seq', 9, true);
: employee employee_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres


ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_email_key UNIQUE (email);


ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_first_name_key UNIQUE (first_name);


ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);

--
-- PostgreSQL database dump complete
--

