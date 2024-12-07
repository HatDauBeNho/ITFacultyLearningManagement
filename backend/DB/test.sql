--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

-- Started on 2024-12-04 01:01:08

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2 (class 3079 OID 16699)
-- Name: unaccent; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS unaccent WITH SCHEMA public;


--
-- TOC entry 4947 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION unaccent; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION unaccent IS 'text search dictionary that removes accents';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 16640)
-- Name: tb_account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_account (
    account_id integer NOT NULL,
    create_time timestamp without time zone,
    password character varying(255),
    role character varying(255),
    status integer,
    update_time timestamp without time zone,
    user_name character varying(255)
);


ALTER TABLE public.tb_account OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16639)
-- Name: tb_account_account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_account_account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_account_account_id_seq OWNER TO postgres;

--
-- TOC entry 4948 (class 0 OID 0)
-- Dependencies: 218
-- Name: tb_account_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_account_account_id_seq OWNED BY public.tb_account.account_id;


--
-- TOC entry 235 (class 1259 OID 16707)
-- Name: tb_classroom; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_classroom (
    class_id integer NOT NULL,
    course_id integer,
    current_student integer,
    maximum_student integer,
    semester_id integer,
    teacher_id integer,
    create_time timestamp without time zone,
    update_time timestamp without time zone,
    status integer
);


ALTER TABLE public.tb_classroom OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 16706)
-- Name: tb_classroom_class_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_classroom_class_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_classroom_class_id_seq OWNER TO postgres;

--
-- TOC entry 4949 (class 0 OID 0)
-- Dependencies: 234
-- Name: tb_classroom_class_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_classroom_class_id_seq OWNED BY public.tb_classroom.class_id;


--
-- TOC entry 221 (class 1259 OID 16649)
-- Name: tb_course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_course (
    course_id integer NOT NULL,
    condition integer,
    course_name character varying(255),
    create_time timestamp without time zone,
    credit integer,
    update_time timestamp without time zone
);


ALTER TABLE public.tb_course OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16648)
-- Name: tb_course_course_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_course_course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_course_course_id_seq OWNER TO postgres;

--
-- TOC entry 4950 (class 0 OID 0)
-- Dependencies: 220
-- Name: tb_course_course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_course_course_id_seq OWNED BY public.tb_course.course_id;


--
-- TOC entry 223 (class 1259 OID 16656)
-- Name: tb_course_registration; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_course_registration (
    course_registration_id integer NOT NULL,
    create_time timestamp without time zone,
    point double precision,
    student_id integer,
    update_time timestamp without time zone,
    class_id integer
);


ALTER TABLE public.tb_course_registration OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16655)
-- Name: tb_course_registration_course_registration_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_course_registration_course_registration_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_course_registration_course_registration_id_seq OWNER TO postgres;

--
-- TOC entry 4951 (class 0 OID 0)
-- Dependencies: 222
-- Name: tb_course_registration_course_registration_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_course_registration_course_registration_id_seq OWNED BY public.tb_course_registration.course_registration_id;


--
-- TOC entry 225 (class 1259 OID 16663)
-- Name: tb_evaluate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_evaluate (
    evaluate_id integer NOT NULL,
    content character varying(255),
    create_time timestamp without time zone,
    rating double precision,
    student_id integer,
    teacher_id integer,
    update_time timestamp without time zone
);


ALTER TABLE public.tb_evaluate OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16662)
-- Name: tb_evaluate_evaluate_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_evaluate_evaluate_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_evaluate_evaluate_id_seq OWNER TO postgres;

--
-- TOC entry 4952 (class 0 OID 0)
-- Dependencies: 224
-- Name: tb_evaluate_evaluate_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_evaluate_evaluate_id_seq OWNED BY public.tb_evaluate.evaluate_id;


--
-- TOC entry 227 (class 1259 OID 16670)
-- Name: tb_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_info (
    info_id integer NOT NULL,
    address character varying(255),
    avatar character varying(255),
    create_time timestamp without time zone,
    date_of_birth date,
    email character varying(255),
    full_name character varying(255),
    gender integer,
    phone_number character varying(255),
    update_time timestamp without time zone
);


ALTER TABLE public.tb_info OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16669)
-- Name: tb_info_info_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_info_info_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_info_info_id_seq OWNER TO postgres;

--
-- TOC entry 4953 (class 0 OID 0)
-- Dependencies: 226
-- Name: tb_info_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_info_info_id_seq OWNED BY public.tb_info.info_id;


--
-- TOC entry 229 (class 1259 OID 16679)
-- Name: tb_result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_result (
    result_id integer NOT NULL,
    course_registration_id integer,
    create_time timestamp without time zone,
    point double precision,
    update_time timestamp without time zone
);


ALTER TABLE public.tb_result OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16678)
-- Name: tb_result_result_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_result_result_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_result_result_id_seq OWNER TO postgres;

--
-- TOC entry 4954 (class 0 OID 0)
-- Dependencies: 228
-- Name: tb_result_result_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_result_result_id_seq OWNED BY public.tb_result.result_id;


--
-- TOC entry 237 (class 1259 OID 16714)
-- Name: tb_semester; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_semester (
    semester_id integer NOT NULL,
    end_time date,
    name character varying(255),
    start_time date
);


ALTER TABLE public.tb_semester OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 16713)
-- Name: tb_semester_semester_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_semester_semester_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_semester_semester_id_seq OWNER TO postgres;

--
-- TOC entry 4955 (class 0 OID 0)
-- Dependencies: 236
-- Name: tb_semester_semester_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_semester_semester_id_seq OWNED BY public.tb_semester.semester_id;


--
-- TOC entry 231 (class 1259 OID 16686)
-- Name: tb_student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_student (
    student_id integer NOT NULL,
    account_id integer,
    create_time timestamp without time zone,
    gpa double precision,
    info_id integer,
    status integer,
    update_time timestamp without time zone
);


ALTER TABLE public.tb_student OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 16685)
-- Name: tb_student_student_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_student_student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_student_student_id_seq OWNER TO postgres;

--
-- TOC entry 4956 (class 0 OID 0)
-- Dependencies: 230
-- Name: tb_student_student_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_student_student_id_seq OWNED BY public.tb_student.student_id;


--
-- TOC entry 233 (class 1259 OID 16693)
-- Name: tb_teacher; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_teacher (
    teacher_id integer NOT NULL,
    account_id integer,
    info_id integer
);


ALTER TABLE public.tb_teacher OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 16692)
-- Name: tb_teacher_teacher_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tb_teacher_teacher_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tb_teacher_teacher_id_seq OWNER TO postgres;

--
-- TOC entry 4957 (class 0 OID 0)
-- Dependencies: 232
-- Name: tb_teacher_teacher_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_teacher_teacher_id_seq OWNED BY public.tb_teacher.teacher_id;


--
-- TOC entry 4747 (class 2604 OID 16643)
-- Name: tb_account account_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_account ALTER COLUMN account_id SET DEFAULT nextval('public.tb_account_account_id_seq'::regclass);


--
-- TOC entry 4755 (class 2604 OID 16710)
-- Name: tb_classroom class_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_classroom ALTER COLUMN class_id SET DEFAULT nextval('public.tb_classroom_class_id_seq'::regclass);


--
-- TOC entry 4748 (class 2604 OID 16652)
-- Name: tb_course course_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_course ALTER COLUMN course_id SET DEFAULT nextval('public.tb_course_course_id_seq'::regclass);


--
-- TOC entry 4749 (class 2604 OID 16659)
-- Name: tb_course_registration course_registration_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_course_registration ALTER COLUMN course_registration_id SET DEFAULT nextval('public.tb_course_registration_course_registration_id_seq'::regclass);


--
-- TOC entry 4750 (class 2604 OID 16666)
-- Name: tb_evaluate evaluate_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_evaluate ALTER COLUMN evaluate_id SET DEFAULT nextval('public.tb_evaluate_evaluate_id_seq'::regclass);


--
-- TOC entry 4751 (class 2604 OID 16673)
-- Name: tb_info info_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_info ALTER COLUMN info_id SET DEFAULT nextval('public.tb_info_info_id_seq'::regclass);


--
-- TOC entry 4752 (class 2604 OID 16682)
-- Name: tb_result result_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_result ALTER COLUMN result_id SET DEFAULT nextval('public.tb_result_result_id_seq'::regclass);


--
-- TOC entry 4756 (class 2604 OID 16717)
-- Name: tb_semester semester_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_semester ALTER COLUMN semester_id SET DEFAULT nextval('public.tb_semester_semester_id_seq'::regclass);


--
-- TOC entry 4753 (class 2604 OID 16689)
-- Name: tb_student student_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_student ALTER COLUMN student_id SET DEFAULT nextval('public.tb_student_student_id_seq'::regclass);


--
-- TOC entry 4754 (class 2604 OID 16696)
-- Name: tb_teacher teacher_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_teacher ALTER COLUMN teacher_id SET DEFAULT nextval('public.tb_teacher_teacher_id_seq'::regclass);


--
-- TOC entry 4923 (class 0 OID 16640)
-- Dependencies: 219
-- Data for Name: tb_account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_account (account_id, create_time, password, role, status, update_time, user_name) VALUES (2, '2023-09-04 06:28:52', '$2a$10$k0GD6khRK0naL1tTxHNu6eG.WYBXPATL5c.p4dEBLPYYaf8rHM0o6', '2', 1, '2023-09-04 06:28:52', 'nguyenthongtien@gmail.com');
INSERT INTO public.tb_account (account_id, create_time, password, role, status, update_time, user_name) VALUES (1, '2023-09-04 06:28:52', '$2a$10$k0GD6khRK0naL1tTxHNu6eG.WYBXPATL5c.p4dEBLPYYaf8rHM0o6', '1', 1, '2023-09-04 06:28:52', 'admin');
INSERT INTO public.tb_account (account_id, create_time, password, role, status, update_time, user_name) VALUES (4, '2023-09-04 06:28:52', '$2a$10$k0GD6khRK0naL1tTxHNu6eG.WYBXPATL5c.p4dEBLPYYaf8rHM0o6', '3', 1, '2023-09-04 06:28:52', 'phamthanhdao@gmail.com');


--
-- TOC entry 4939 (class 0 OID 16707)
-- Dependencies: 235
-- Data for Name: tb_classroom; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_classroom (class_id, course_id, current_student, maximum_student, semester_id, teacher_id, create_time, update_time, status) VALUES (1, 1, 1, 60, 1, 1, '2024-12-03 22:43:46.582381', '2024-12-04 00:40:06.41238', 1);


--
-- TOC entry 4925 (class 0 OID 16649)
-- Dependencies: 221
-- Data for Name: tb_course; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_course (course_id, condition, course_name, create_time, credit, update_time) VALUES (3, 0, 'Cơ sở dữ liệu', '2024-11-24 20:06:36.194058', 3, '2024-11-24 20:06:36.194058');
INSERT INTO public.tb_course (course_id, condition, course_name, create_time, credit, update_time) VALUES (4, 3, 'Hệ quản trị cơ sở dữ liệu', '2024-11-24 20:07:17.68722', 3, '2024-11-24 20:07:17.68722');
INSERT INTO public.tb_course (course_id, condition, course_name, create_time, credit, update_time) VALUES (5, 0, 'Nguyên lý hệ điều hành', '2024-11-24 20:07:42.314725', 3, '2024-11-24 20:07:42.314725');
INSERT INTO public.tb_course (course_id, condition, course_name, create_time, credit, update_time) VALUES (6, 5, 'Lập trình hướng đối tượng', '2024-11-24 20:15:06.701923', 3, '2024-11-24 20:15:06.701923');
INSERT INTO public.tb_course (course_id, condition, course_name, create_time, credit, update_time) VALUES (1, 2, 'Tiếng anh công nghệ thông tin 2', '2024-11-24 20:02:47.688238', 5, '2024-12-01 00:56:11.251375');
INSERT INTO public.tb_course (course_id, condition, course_name, create_time, credit, update_time) VALUES (2, 0, 'Tiếng anh công nghệ thông tin 1', '2024-11-24 20:04:27.035014', 5, '2024-12-02 18:56:22.261082');
INSERT INTO public.tb_course (course_id, condition, course_name, create_time, credit, update_time) VALUES (8, 5, 'Lập trình .net', '2024-12-03 21:38:52.884872', 3, '2024-12-03 21:38:52.884872');
INSERT INTO public.tb_course (course_id, condition, course_name, create_time, credit, update_time) VALUES (7, 6, 'Lập trình java', '2024-11-24 20:15:23.733631', 4, '2024-12-03 21:57:09.385382');


--
-- TOC entry 4927 (class 0 OID 16656)
-- Dependencies: 223
-- Data for Name: tb_course_registration; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_course_registration (course_registration_id, create_time, point, student_id, update_time, class_id) VALUES (18, '2024-12-04 00:40:06.442819', 9.1, 4, '2024-12-04 00:58:08.743169', 1);


--
-- TOC entry 4929 (class 0 OID 16663)
-- Dependencies: 225
-- Data for Name: tb_evaluate; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4931 (class 0 OID 16670)
-- Dependencies: 227
-- Data for Name: tb_info; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_info (info_id, address, avatar, create_time, date_of_birth, email, full_name, gender, phone_number, update_time) VALUES (1, 'Số 19, ngõ 132, phường Minh Khai, thành phố Hà Nội', NULL, '2023-09-04 06:28:52', '2002-09-04', 'phamhongnguyen@gmail.com', 'Phạm Hồng Nguyên', 1, '0982800770', '2023-09-04 06:28:52');
INSERT INTO public.tb_info (info_id, address, avatar, create_time, date_of_birth, email, full_name, gender, phone_number, update_time) VALUES (2, 'Số 19, ngõ 132, phường Minh Khai, thành phố Hà Nội', NULL, '2023-09-04 06:28:52', '2002-09-04', 'nguyenthongtien@gmail.com', 'Nguyễn Thông Tiến', 1, '0982518972', '2023-09-04 06:28:52');
INSERT INTO public.tb_info (info_id, address, avatar, create_time, date_of_birth, email, full_name, gender, phone_number, update_time) VALUES (3, 'Số 19, ngõ 132, phường Minh Khai, thành phố Hà Nội', NULL, '2023-09-04 06:28:52', '2002-09-04', 'levantung@gmail.com
', 'Lê Văn Tùng', 1, '0973175891', '2023-09-04 06:28:52');
INSERT INTO public.tb_info (info_id, address, avatar, create_time, date_of_birth, email, full_name, gender, phone_number, update_time) VALUES (4, 'Số 11, ngõ 178, phố Quan Nhân, quận Thanh Xuân, thành phố  Hà Nội', NULL, '2023-09-04 06:28:52', '2002-09-04', 'phamthanhdao@gmail.com', 'Phạm Thành Đạo', 1, '0973148566', '2023-09-04 06:28:52');


--
-- TOC entry 4933 (class 0 OID 16679)
-- Dependencies: 229
-- Data for Name: tb_result; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4941 (class 0 OID 16714)
-- Dependencies: 237
-- Data for Name: tb_semester; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_semester (semester_id, end_time, name, start_time) VALUES (1, '2025-06-01', 'Học kì 1 / 2025', '2025-02-01');
INSERT INTO public.tb_semester (semester_id, end_time, name, start_time) VALUES (2, '2026-01-01', 'Học kì 2 / 2025', '2025-09-01');


--
-- TOC entry 4935 (class 0 OID 16686)
-- Dependencies: 231
-- Data for Name: tb_student; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_student (student_id, account_id, create_time, gpa, info_id, status, update_time) VALUES (1, 4, NULL, NULL, 4, 1, NULL);


--
-- TOC entry 4937 (class 0 OID 16693)
-- Dependencies: 233
-- Data for Name: tb_teacher; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_teacher (teacher_id, account_id, info_id) VALUES (1, 1, 1);
INSERT INTO public.tb_teacher (teacher_id, account_id, info_id) VALUES (2, 2, 2);
INSERT INTO public.tb_teacher (teacher_id, account_id, info_id) VALUES (3, 3, 3);


--
-- TOC entry 4958 (class 0 OID 0)
-- Dependencies: 218
-- Name: tb_account_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_account_account_id_seq', 1, true);


--
-- TOC entry 4959 (class 0 OID 0)
-- Dependencies: 234
-- Name: tb_classroom_class_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_classroom_class_id_seq', 1, true);


--
-- TOC entry 4960 (class 0 OID 0)
-- Dependencies: 220
-- Name: tb_course_course_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_course_course_id_seq', 8, true);


--
-- TOC entry 4961 (class 0 OID 0)
-- Dependencies: 222
-- Name: tb_course_registration_course_registration_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_course_registration_course_registration_id_seq', 18, true);


--
-- TOC entry 4962 (class 0 OID 0)
-- Dependencies: 224
-- Name: tb_evaluate_evaluate_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_evaluate_evaluate_id_seq', 1, false);


--
-- TOC entry 4963 (class 0 OID 0)
-- Dependencies: 226
-- Name: tb_info_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_info_info_id_seq', 1, false);


--
-- TOC entry 4964 (class 0 OID 0)
-- Dependencies: 228
-- Name: tb_result_result_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_result_result_id_seq', 1, false);


--
-- TOC entry 4965 (class 0 OID 0)
-- Dependencies: 236
-- Name: tb_semester_semester_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_semester_semester_id_seq', 1, false);


--
-- TOC entry 4966 (class 0 OID 0)
-- Dependencies: 230
-- Name: tb_student_student_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_student_student_id_seq', 1, false);


--
-- TOC entry 4967 (class 0 OID 0)
-- Dependencies: 232
-- Name: tb_teacher_teacher_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_teacher_teacher_id_seq', 1, false);


--
-- TOC entry 4758 (class 2606 OID 16647)
-- Name: tb_account tb_account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_account
    ADD CONSTRAINT tb_account_pkey PRIMARY KEY (account_id);


--
-- TOC entry 4774 (class 2606 OID 16712)
-- Name: tb_classroom tb_classroom_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_classroom
    ADD CONSTRAINT tb_classroom_pkey PRIMARY KEY (class_id);


--
-- TOC entry 4760 (class 2606 OID 16654)
-- Name: tb_course tb_course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_course
    ADD CONSTRAINT tb_course_pkey PRIMARY KEY (course_id);


--
-- TOC entry 4762 (class 2606 OID 16661)
-- Name: tb_course_registration tb_course_registration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_course_registration
    ADD CONSTRAINT tb_course_registration_pkey PRIMARY KEY (course_registration_id);


--
-- TOC entry 4764 (class 2606 OID 16668)
-- Name: tb_evaluate tb_evaluate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_evaluate
    ADD CONSTRAINT tb_evaluate_pkey PRIMARY KEY (evaluate_id);


--
-- TOC entry 4766 (class 2606 OID 16677)
-- Name: tb_info tb_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_info
    ADD CONSTRAINT tb_info_pkey PRIMARY KEY (info_id);


--
-- TOC entry 4768 (class 2606 OID 16684)
-- Name: tb_result tb_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_result
    ADD CONSTRAINT tb_result_pkey PRIMARY KEY (result_id);


--
-- TOC entry 4776 (class 2606 OID 16719)
-- Name: tb_semester tb_semester_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_semester
    ADD CONSTRAINT tb_semester_pkey PRIMARY KEY (semester_id);


--
-- TOC entry 4770 (class 2606 OID 16691)
-- Name: tb_student tb_student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_student
    ADD CONSTRAINT tb_student_pkey PRIMARY KEY (student_id);


--
-- TOC entry 4772 (class 2606 OID 16698)
-- Name: tb_teacher tb_teacher_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_teacher
    ADD CONSTRAINT tb_teacher_pkey PRIMARY KEY (teacher_id);


-- Completed on 2024-12-04 01:01:08

--
-- PostgreSQL database dump complete
--

