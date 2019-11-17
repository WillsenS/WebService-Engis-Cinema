--
-- PostgreSQL database dump
--

-- Dumped from database version 12.0
-- Dumped by pg_dump version 12.0

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

--
-- Name: check_sufficient_balance(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.check_sufficient_balance() RETURNS trigger
    LANGUAGE plpgsql
    AS $$DECLARE	current_balance INTEGER := get_balance(NEW.acc_num_src);BEGIN	IF (current_balance < NEW.amount) THEN		RAISE EXCEPTION 'Not enough balance';	END IF;	RETURN NEW;END$$;


ALTER FUNCTION public.check_sufficient_balance() OWNER TO postgres;

--
-- Name: get_balance(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.get_balance(param_acc_num integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
	result INTEGER;
BEGIN
	RETURN coalesce((SELECT balance_last FROM customer WHERE acc_num = param_acc_num), 0);
END
$$;


ALTER FUNCTION public.get_balance(param_acc_num integer) OWNER TO postgres;

--
-- Name: get_credit(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.get_credit(param_acc_num integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
BEGIN
	RETURN coalesce((
	SELECT SUM(txn.amount)
	FROM customer INNER JOIN txn ON (customer.acc_num = txn.acc_num_src)
	WHERE txn.acc_num_src = param_acc_num
	GROUP BY customer.name
	), 0);
END
$$;


ALTER FUNCTION public.get_credit(param_acc_num integer) OWNER TO postgres;

--
-- Name: get_debit(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.get_debit(param_acc_num integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$BEGIN	RETURN coalesce((	SELECT SUM(txn.amount)	FROM customer INNER JOIN txn ON (customer.acc_num = txn.acc_num_dest)	WHERE txn.acc_num_dest = param_acc_num	GROUP BY customer.name	), 0);END$$;


ALTER FUNCTION public.get_debit(param_acc_num integer) OWNER TO postgres;

--
-- Name: update_all_at_once(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_all_at_once() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN	PERFORM update_balance(NEW.acc_num_src);	PERFORM update_balance(NEW.acc_num_dest);	RETURN NEW;END;$$;


ALTER FUNCTION public.update_all_at_once() OWNER TO postgres;

--
-- Name: update_balance(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.update_balance(param_acc_num integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
DECLARE
	credit INTEGER := get_credit(param_acc_num);
	debit INTEGER := get_debit(param_acc_num);
BEGIN
	IF (credit = NULL) THEN
		credit := 0;
	END IF;
	IF (debit = NULL) THEN
		debit := 0;
	END IF;
	UPDATE customer
	SET balance_last = balance_first + debit - credit
	WHERE acc_num = param_acc_num;
END $$;


ALTER FUNCTION public.update_balance(param_acc_num integer) OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    name character varying(20) NOT NULL,
    acc_num integer NOT NULL,
    virt_acc character(9),
    balance_first bigint,
    balance_last bigint
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: customer_acc_num_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_acc_num_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_acc_num_seq OWNER TO postgres;

--
-- Name: customer_acc_num_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_acc_num_seq OWNED BY public.customer.acc_num;


--
-- Name: txn; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.txn (
    id_txn integer NOT NULL,
    acc_num_src integer,
    amount bigint,
    "time" timestamp without time zone DEFAULT now(),
    acc_num_dest integer
);


ALTER TABLE public.txn OWNER TO postgres;

--
-- Name: txn_id_txn_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.txn_id_txn_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.txn_id_txn_seq OWNER TO postgres;

--
-- Name: txn_id_txn_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.txn_id_txn_seq OWNED BY public.txn.id_txn;


--
-- Name: customer acc_num; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer ALTER COLUMN acc_num SET DEFAULT nextval('public.customer_acc_num_seq'::regclass);


--
-- Name: txn id_txn; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.txn ALTER COLUMN id_txn SET DEFAULT nextval('public.txn_id_txn_seq'::regclass);


--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (name, acc_num, virt_acc, balance_first, balance_last) FROM stdin;
Rickie	2	\N	500	385
Cipy	6	\N	50	100
Arvin	5	\N	100	0
Jaskey	3	\N	100	265
\.


--
-- Data for Name: txn; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.txn (id_txn, acc_num_src, amount, "time", acc_num_dest) FROM stdin;
1	2	30	2019-11-15 05:37:35.954336	3
2	2	100	2019-11-15 05:38:01.089311	3
3	3	15	2019-11-15 05:38:15.815733	2
15	5	20	2019-11-17 14:07:45.567238	6
24	5	30	2019-11-17 14:19:57.855234	6
29	5	50	2019-11-17 14:41:16.252694	3
\.


--
-- Name: customer_acc_num_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_acc_num_seq', 6, true);


--
-- Name: txn_id_txn_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.txn_id_txn_seq', 30, true);


--
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (acc_num);


--
-- Name: txn txn_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.txn
    ADD CONSTRAINT txn_pkey PRIMARY KEY (id_txn);


--
-- Name: txn check_sufficient_balances; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER check_sufficient_balances BEFORE INSERT ON public.txn FOR EACH ROW EXECUTE FUNCTION public.check_sufficient_balance();


--
-- Name: txn update_balances; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER update_balances AFTER INSERT ON public.txn FOR EACH ROW EXECUTE FUNCTION public.update_all_at_once();


--
-- Name: txn txn_acc_num_dest_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.txn
    ADD CONSTRAINT txn_acc_num_dest_fkey FOREIGN KEY (acc_num_dest) REFERENCES public.customer(acc_num);


--
-- Name: txn txn_acc_num_src_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.txn
    ADD CONSTRAINT txn_acc_num_src_fkey FOREIGN KEY (acc_num_src) REFERENCES public.customer(acc_num);


--
-- PostgreSQL database dump complete
--

