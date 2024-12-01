toc.dat                                                                                             0000600 0004000 0002000 00000035701 14723326604 0014454 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       4                |            IT_FLM    17.2    17.2 .    <           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false         =           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false         >           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false         ?           1262    16638    IT_FLM    DATABASE     �   CREATE DATABASE "IT_FLM" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Vietnamese_Vietnam.1252';
    DROP DATABASE "IT_FLM";
                     postgres    false                     3079    16699    unaccent 	   EXTENSION     <   CREATE EXTENSION IF NOT EXISTS unaccent WITH SCHEMA public;
    DROP EXTENSION unaccent;
                        false         @           0    0    EXTENSION unaccent    COMMENT     P   COMMENT ON EXTENSION unaccent IS 'text search dictionary that removes accents';
                             false    2         �            1259    16640 
   tb_account    TABLE       CREATE TABLE public.tb_account (
    account_id integer NOT NULL,
    create_time timestamp without time zone,
    password character varying(255),
    role character varying(255),
    status integer,
    update_time timestamp without time zone,
    user_name character varying(255)
);
    DROP TABLE public.tb_account;
       public         heap r       postgres    false         �            1259    16639    tb_account_account_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_account_account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.tb_account_account_id_seq;
       public               postgres    false    219         A           0    0    tb_account_account_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.tb_account_account_id_seq OWNED BY public.tb_account.account_id;
          public               postgres    false    218         �            1259    16649 	   tb_course    TABLE     �  CREATE TABLE public.tb_course (
    course_id integer NOT NULL,
    condition integer,
    course_name character varying(255),
    create_time timestamp without time zone,
    credit integer,
    current_student integer,
    end_time date,
    maximum_student integer,
    start_time date,
    subject_id integer,
    teacher_id integer,
    update_time timestamp without time zone
);
    DROP TABLE public.tb_course;
       public         heap r       postgres    false         �            1259    16648    tb_course_course_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_course_course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.tb_course_course_id_seq;
       public               postgres    false    221         B           0    0    tb_course_course_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.tb_course_course_id_seq OWNED BY public.tb_course.course_id;
          public               postgres    false    220         �            1259    16656    tb_course_registration    TABLE       CREATE TABLE public.tb_course_registration (
    course_registration_id integer NOT NULL,
    course_id integer,
    create_time timestamp without time zone,
    point double precision,
    student_id integer,
    update_time timestamp without time zone
);
 *   DROP TABLE public.tb_course_registration;
       public         heap r       postgres    false         �            1259    16655 1   tb_course_registration_course_registration_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_course_registration_course_registration_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 H   DROP SEQUENCE public.tb_course_registration_course_registration_id_seq;
       public               postgres    false    223         C           0    0 1   tb_course_registration_course_registration_id_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE public.tb_course_registration_course_registration_id_seq OWNED BY public.tb_course_registration.course_registration_id;
          public               postgres    false    222         �            1259    16663    tb_evaluate    TABLE       CREATE TABLE public.tb_evaluate (
    evaluate_id integer NOT NULL,
    content character varying(255),
    create_time timestamp without time zone,
    rating double precision,
    student_id integer,
    teacher_id integer,
    update_time timestamp without time zone
);
    DROP TABLE public.tb_evaluate;
       public         heap r       postgres    false         �            1259    16662    tb_evaluate_evaluate_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_evaluate_evaluate_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.tb_evaluate_evaluate_id_seq;
       public               postgres    false    225         D           0    0    tb_evaluate_evaluate_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.tb_evaluate_evaluate_id_seq OWNED BY public.tb_evaluate.evaluate_id;
          public               postgres    false    224         �            1259    16670    tb_info    TABLE     |  CREATE TABLE public.tb_info (
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
    DROP TABLE public.tb_info;
       public         heap r       postgres    false         �            1259    16669    tb_info_info_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_info_info_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.tb_info_info_id_seq;
       public               postgres    false    227         E           0    0    tb_info_info_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.tb_info_info_id_seq OWNED BY public.tb_info.info_id;
          public               postgres    false    226         �            1259    16679 	   tb_result    TABLE     �   CREATE TABLE public.tb_result (
    result_id integer NOT NULL,
    course_registration_id integer,
    create_time timestamp without time zone,
    point double precision,
    update_time timestamp without time zone
);
    DROP TABLE public.tb_result;
       public         heap r       postgres    false         �            1259    16678    tb_result_result_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_result_result_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.tb_result_result_id_seq;
       public               postgres    false    229         F           0    0    tb_result_result_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.tb_result_result_id_seq OWNED BY public.tb_result.result_id;
          public               postgres    false    228         �            1259    16686 
   tb_student    TABLE     �   CREATE TABLE public.tb_student (
    student_id integer NOT NULL,
    account_id integer,
    create_time timestamp without time zone,
    gpa double precision,
    info_id integer,
    status integer,
    update_time timestamp without time zone
);
    DROP TABLE public.tb_student;
       public         heap r       postgres    false         �            1259    16685    tb_student_student_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_student_student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.tb_student_student_id_seq;
       public               postgres    false    231         G           0    0    tb_student_student_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.tb_student_student_id_seq OWNED BY public.tb_student.student_id;
          public               postgres    false    230         �            1259    16693 
   tb_teacher    TABLE     q   CREATE TABLE public.tb_teacher (
    teacher_id integer NOT NULL,
    account_id integer,
    info_id integer
);
    DROP TABLE public.tb_teacher;
       public         heap r       postgres    false         �            1259    16692    tb_teacher_teacher_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tb_teacher_teacher_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.tb_teacher_teacher_id_seq;
       public               postgres    false    233         H           0    0    tb_teacher_teacher_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.tb_teacher_teacher_id_seq OWNED BY public.tb_teacher.teacher_id;
          public               postgres    false    232         �           2604    16643    tb_account account_id    DEFAULT     ~   ALTER TABLE ONLY public.tb_account ALTER COLUMN account_id SET DEFAULT nextval('public.tb_account_account_id_seq'::regclass);
 D   ALTER TABLE public.tb_account ALTER COLUMN account_id DROP DEFAULT;
       public               postgres    false    218    219    219         �           2604    16652    tb_course course_id    DEFAULT     z   ALTER TABLE ONLY public.tb_course ALTER COLUMN course_id SET DEFAULT nextval('public.tb_course_course_id_seq'::regclass);
 B   ALTER TABLE public.tb_course ALTER COLUMN course_id DROP DEFAULT;
       public               postgres    false    220    221    221         �           2604    16659 -   tb_course_registration course_registration_id    DEFAULT     �   ALTER TABLE ONLY public.tb_course_registration ALTER COLUMN course_registration_id SET DEFAULT nextval('public.tb_course_registration_course_registration_id_seq'::regclass);
 \   ALTER TABLE public.tb_course_registration ALTER COLUMN course_registration_id DROP DEFAULT;
       public               postgres    false    222    223    223         �           2604    16666    tb_evaluate evaluate_id    DEFAULT     �   ALTER TABLE ONLY public.tb_evaluate ALTER COLUMN evaluate_id SET DEFAULT nextval('public.tb_evaluate_evaluate_id_seq'::regclass);
 F   ALTER TABLE public.tb_evaluate ALTER COLUMN evaluate_id DROP DEFAULT;
       public               postgres    false    224    225    225         �           2604    16673    tb_info info_id    DEFAULT     r   ALTER TABLE ONLY public.tb_info ALTER COLUMN info_id SET DEFAULT nextval('public.tb_info_info_id_seq'::regclass);
 >   ALTER TABLE public.tb_info ALTER COLUMN info_id DROP DEFAULT;
       public               postgres    false    226    227    227         �           2604    16682    tb_result result_id    DEFAULT     z   ALTER TABLE ONLY public.tb_result ALTER COLUMN result_id SET DEFAULT nextval('public.tb_result_result_id_seq'::regclass);
 B   ALTER TABLE public.tb_result ALTER COLUMN result_id DROP DEFAULT;
       public               postgres    false    228    229    229         �           2604    16689    tb_student student_id    DEFAULT     ~   ALTER TABLE ONLY public.tb_student ALTER COLUMN student_id SET DEFAULT nextval('public.tb_student_student_id_seq'::regclass);
 D   ALTER TABLE public.tb_student ALTER COLUMN student_id DROP DEFAULT;
       public               postgres    false    230    231    231         �           2604    16696    tb_teacher teacher_id    DEFAULT     ~   ALTER TABLE ONLY public.tb_teacher ALTER COLUMN teacher_id SET DEFAULT nextval('public.tb_teacher_teacher_id_seq'::regclass);
 D   ALTER TABLE public.tb_teacher ALTER COLUMN teacher_id DROP DEFAULT;
       public               postgres    false    233    232    233         �           2606    16647    tb_account tb_account_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tb_account
    ADD CONSTRAINT tb_account_pkey PRIMARY KEY (account_id);
 D   ALTER TABLE ONLY public.tb_account DROP CONSTRAINT tb_account_pkey;
       public                 postgres    false    219         �           2606    16654    tb_course tb_course_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.tb_course
    ADD CONSTRAINT tb_course_pkey PRIMARY KEY (course_id);
 B   ALTER TABLE ONLY public.tb_course DROP CONSTRAINT tb_course_pkey;
       public                 postgres    false    221         �           2606    16661 2   tb_course_registration tb_course_registration_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.tb_course_registration
    ADD CONSTRAINT tb_course_registration_pkey PRIMARY KEY (course_registration_id);
 \   ALTER TABLE ONLY public.tb_course_registration DROP CONSTRAINT tb_course_registration_pkey;
       public                 postgres    false    223         �           2606    16668    tb_evaluate tb_evaluate_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.tb_evaluate
    ADD CONSTRAINT tb_evaluate_pkey PRIMARY KEY (evaluate_id);
 F   ALTER TABLE ONLY public.tb_evaluate DROP CONSTRAINT tb_evaluate_pkey;
       public                 postgres    false    225         �           2606    16677    tb_info tb_info_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.tb_info
    ADD CONSTRAINT tb_info_pkey PRIMARY KEY (info_id);
 >   ALTER TABLE ONLY public.tb_info DROP CONSTRAINT tb_info_pkey;
       public                 postgres    false    227         �           2606    16684    tb_result tb_result_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.tb_result
    ADD CONSTRAINT tb_result_pkey PRIMARY KEY (result_id);
 B   ALTER TABLE ONLY public.tb_result DROP CONSTRAINT tb_result_pkey;
       public                 postgres    false    229         �           2606    16691    tb_student tb_student_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tb_student
    ADD CONSTRAINT tb_student_pkey PRIMARY KEY (student_id);
 D   ALTER TABLE ONLY public.tb_student DROP CONSTRAINT tb_student_pkey;
       public                 postgres    false    231         �           2606    16698    tb_teacher tb_teacher_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tb_teacher
    ADD CONSTRAINT tb_teacher_pkey PRIMARY KEY (teacher_id);
 D   ALTER TABLE ONLY public.tb_teacher DROP CONSTRAINT tb_teacher_pkey;
       public                 postgres    false    233                                                                       restore.sql                                                                                         0000600 0004000 0002000 00000027730 14723326604 0015404 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

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

DROP DATABASE "IT_FLM";
--
-- Name: IT_FLM; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "IT_FLM" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Vietnamese_Vietnam.1252';


ALTER DATABASE "IT_FLM" OWNER TO postgres;

\connect "IT_FLM"

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
-- Name: unaccent; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS unaccent WITH SCHEMA public;


--
-- Name: EXTENSION unaccent; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION unaccent IS 'text search dictionary that removes accents';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
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
-- Name: tb_account_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_account_account_id_seq OWNED BY public.tb_account.account_id;


--
-- Name: tb_course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_course (
    course_id integer NOT NULL,
    condition integer,
    course_name character varying(255),
    create_time timestamp without time zone,
    credit integer,
    current_student integer,
    end_time date,
    maximum_student integer,
    start_time date,
    subject_id integer,
    teacher_id integer,
    update_time timestamp without time zone
);


ALTER TABLE public.tb_course OWNER TO postgres;

--
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
-- Name: tb_course_course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_course_course_id_seq OWNED BY public.tb_course.course_id;


--
-- Name: tb_course_registration; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_course_registration (
    course_registration_id integer NOT NULL,
    course_id integer,
    create_time timestamp without time zone,
    point double precision,
    student_id integer,
    update_time timestamp without time zone
);


ALTER TABLE public.tb_course_registration OWNER TO postgres;

--
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
-- Name: tb_course_registration_course_registration_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_course_registration_course_registration_id_seq OWNED BY public.tb_course_registration.course_registration_id;


--
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
-- Name: tb_evaluate_evaluate_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_evaluate_evaluate_id_seq OWNED BY public.tb_evaluate.evaluate_id;


--
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
-- Name: tb_info_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_info_info_id_seq OWNED BY public.tb_info.info_id;


--
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
-- Name: tb_result_result_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_result_result_id_seq OWNED BY public.tb_result.result_id;


--
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
-- Name: tb_student_student_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_student_student_id_seq OWNED BY public.tb_student.student_id;


--
-- Name: tb_teacher; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_teacher (
    teacher_id integer NOT NULL,
    account_id integer,
    info_id integer
);


ALTER TABLE public.tb_teacher OWNER TO postgres;

--
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
-- Name: tb_teacher_teacher_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tb_teacher_teacher_id_seq OWNED BY public.tb_teacher.teacher_id;


--
-- Name: tb_account account_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_account ALTER COLUMN account_id SET DEFAULT nextval('public.tb_account_account_id_seq'::regclass);


--
-- Name: tb_course course_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_course ALTER COLUMN course_id SET DEFAULT nextval('public.tb_course_course_id_seq'::regclass);


--
-- Name: tb_course_registration course_registration_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_course_registration ALTER COLUMN course_registration_id SET DEFAULT nextval('public.tb_course_registration_course_registration_id_seq'::regclass);


--
-- Name: tb_evaluate evaluate_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_evaluate ALTER COLUMN evaluate_id SET DEFAULT nextval('public.tb_evaluate_evaluate_id_seq'::regclass);


--
-- Name: tb_info info_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_info ALTER COLUMN info_id SET DEFAULT nextval('public.tb_info_info_id_seq'::regclass);


--
-- Name: tb_result result_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_result ALTER COLUMN result_id SET DEFAULT nextval('public.tb_result_result_id_seq'::regclass);


--
-- Name: tb_student student_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_student ALTER COLUMN student_id SET DEFAULT nextval('public.tb_student_student_id_seq'::regclass);


--
-- Name: tb_teacher teacher_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_teacher ALTER COLUMN teacher_id SET DEFAULT nextval('public.tb_teacher_teacher_id_seq'::regclass);


--
-- Name: tb_account tb_account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_account
    ADD CONSTRAINT tb_account_pkey PRIMARY KEY (account_id);


--
-- Name: tb_course tb_course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_course
    ADD CONSTRAINT tb_course_pkey PRIMARY KEY (course_id);


--
-- Name: tb_course_registration tb_course_registration_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_course_registration
    ADD CONSTRAINT tb_course_registration_pkey PRIMARY KEY (course_registration_id);


--
-- Name: tb_evaluate tb_evaluate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_evaluate
    ADD CONSTRAINT tb_evaluate_pkey PRIMARY KEY (evaluate_id);


--
-- Name: tb_info tb_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_info
    ADD CONSTRAINT tb_info_pkey PRIMARY KEY (info_id);


--
-- Name: tb_result tb_result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_result
    ADD CONSTRAINT tb_result_pkey PRIMARY KEY (result_id);


--
-- Name: tb_student tb_student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_student
    ADD CONSTRAINT tb_student_pkey PRIMARY KEY (student_id);


--
-- Name: tb_teacher tb_teacher_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_teacher
    ADD CONSTRAINT tb_teacher_pkey PRIMARY KEY (teacher_id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        