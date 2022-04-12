--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

-- Started on 2019-12-20 11:30:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12278)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2315 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 200 (class 1259 OID 25164)
-- Name: cidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE cidade (
    codigo_cidade integer NOT NULL,
    nome character varying(100) NOT NULL,
    codigo_estado smallint NOT NULL,
    ativo boolean DEFAULT true
);
ALTER TABLE ONLY cidade ALTER COLUMN codigo_cidade SET STATISTICS 0;
ALTER TABLE ONLY cidade ALTER COLUMN nome SET STATISTICS 0;
ALTER TABLE ONLY cidade ALTER COLUMN codigo_estado SET STATISTICS 0;
ALTER TABLE ONLY cidade ALTER COLUMN ativo SET STATISTICS 0;


ALTER TABLE cidade OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 46826)
-- Name: estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE estado (
    codigo_estado smallint NOT NULL,
    nome character varying(100) NOT NULL,
    sigla character varying(2) NOT NULL,
    ativo boolean DEFAULT true NOT NULL
);
ALTER TABLE ONLY estado ALTER COLUMN codigo_estado SET STATISTICS 0;
ALTER TABLE ONLY estado ALTER COLUMN nome SET STATISTICS 0;
ALTER TABLE ONLY estado ALTER COLUMN sigla SET STATISTICS 0;
ALTER TABLE ONLY estado ALTER COLUMN ativo SET STATISTICS 0;


ALTER TABLE estado OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 55379)
-- Name: formulario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE formulario (
    codigo_formulario smallint NOT NULL,
    nome character varying(100),
    objeto character varying(100) NOT NULL,
    menu boolean DEFAULT true NOT NULL,
    ativo boolean DEFAULT true NOT NULL
);


ALTER TABLE formulario OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 55360)
-- Name: log; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE log (
    codigo_log integer NOT NULL,
    descricao text NOT NULL,
    codigo_log_tipo_acao smallint NOT NULL,
    codigo_formulario smallint NOT NULL,
    codigo_usuario integer NOT NULL,
    data date NOT NULL,
    hora time(0) without time zone NOT NULL
);


ALTER TABLE log OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 55358)
-- Name: log_codigo_log_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE log_codigo_log_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE log_codigo_log_seq OWNER TO postgres;

--
-- TOC entry 2316 (class 0 OID 0)
-- Dependencies: 208
-- Name: log_codigo_log_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE log_codigo_log_seq OWNED BY log.codigo_log;


--
-- TOC entry 207 (class 1259 OID 55342)
-- Name: log_tipo_acao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE log_tipo_acao (
    codigo_log_tipo_acao smallint NOT NULL,
    nome character varying(40) NOT NULL
);


ALTER TABLE log_tipo_acao OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 46841)
-- Name: orgao_emissor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE orgao_emissor (
    codigo_orgao_emissor smallint NOT NULL,
    nome character varying(50) NOT NULL,
    sigla character varying(5) NOT NULL,
    ativo boolean DEFAULT true NOT NULL
);
ALTER TABLE ONLY orgao_emissor ALTER COLUMN codigo_orgao_emissor SET STATISTICS 0;
ALTER TABLE ONLY orgao_emissor ALTER COLUMN nome SET STATISTICS 0;
ALTER TABLE ONLY orgao_emissor ALTER COLUMN sigla SET STATISTICS 0;
ALTER TABLE ONLY orgao_emissor ALTER COLUMN ativo SET STATISTICS 0;


ALTER TABLE orgao_emissor OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 55399)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pessoa (
    codigo_pessoa integer NOT NULL,
    tipo_pessoa character varying(1) NOT NULL,
    nome_razao_social character varying(100) NOT NULL,
    cpf_cnpj character varying(14) NOT NULL,
    identidade character varying(20),
    codigo_orgao_emissor smallint,
    titulo_eleitor character varying(12),
    sexo character varying(1),
    nome_fantasia character varying(100),
    responsavel character varying(100),
    codigo_estado smallint,
    inscricao_estadual character varying(20),
    inscricao_municipal character varying(20),
    codigo_cidade smallint NOT NULL,
    cep character varying(8) NOT NULL,
    endereco character varying(100) NOT NULL,
    numero character varying(5) NOT NULL,
    complemento character varying(50),
    bairro character varying(50) NOT NULL,
    telefone character varying(11) NOT NULL,
    telefone_adicional character varying(11),
    observacao text,
    ativo boolean DEFAULT true NOT NULL
);
ALTER TABLE ONLY pessoa ALTER COLUMN codigo_pessoa SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN tipo_pessoa SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN nome_razao_social SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN cpf_cnpj SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN identidade SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN nome_fantasia SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN inscricao_estadual SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN endereco SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN telefone SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN telefone_adicional SET STATISTICS 0;
ALTER TABLE ONLY pessoa ALTER COLUMN observacao SET STATISTICS 0;


ALTER TABLE pessoa OWNER TO postgres;

--
-- TOC entry 2317 (class 0 OID 0)
-- Dependencies: 211
-- Name: COLUMN pessoa.tipo_pessoa; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pessoa.tipo_pessoa IS 'F=FÍSICA
J=JURÍDICA';


--
-- TOC entry 2318 (class 0 OID 0)
-- Dependencies: 211
-- Name: COLUMN pessoa.sexo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pessoa.sexo IS 'F=FEMININO
M=MASCULINO';


--
-- TOC entry 203 (class 1259 OID 25249)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE produto (
    codigo_produto integer NOT NULL,
    nome character varying(100) NOT NULL,
    codigo_tipo_produto smallint NOT NULL,
    cor character varying(50) NOT NULL,
    espessura integer NOT NULL,
    observacao text,
    ativo boolean DEFAULT true
);
ALTER TABLE ONLY produto ALTER COLUMN codigo_produto SET STATISTICS 0;
ALTER TABLE ONLY produto ALTER COLUMN nome SET STATISTICS 0;
ALTER TABLE ONLY produto ALTER COLUMN codigo_tipo_produto SET STATISTICS 0;
ALTER TABLE ONLY produto ALTER COLUMN cor SET STATISTICS 0;
ALTER TABLE ONLY produto ALTER COLUMN espessura SET STATISTICS 0;
ALTER TABLE ONLY produto ALTER COLUMN observacao SET STATISTICS 0;
ALTER TABLE ONLY produto ALTER COLUMN ativo SET STATISTICS 0;


ALTER TABLE produto OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 55585)
-- Name: servico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE servico (
    codigo_servico integer NOT NULL,
    codigo_pessoa integer NOT NULL,
    codigo_usuario smallint,
    codigo_servico_prioridade smallint NOT NULL,
    codigo_servico_status smallint NOT NULL,
    prazo date NOT NULL,
    valor numeric(10,2) NOT NULL,
    descricao text NOT NULL,
    data_abertura date NOT NULL,
    hora_abertura time(6) without time zone NOT NULL,
    data_encerramento date,
    hora_encerramento time(6) without time zone,
    anexo boolean DEFAULT false NOT NULL,
    ativo boolean DEFAULT true NOT NULL
);
ALTER TABLE ONLY servico ALTER COLUMN codigo_servico SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN codigo_pessoa SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN codigo_usuario SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN codigo_servico_prioridade SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN codigo_servico_status SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN descricao SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN data_abertura SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN hora_abertura SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN data_encerramento SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN hora_encerramento SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN anexo SET STATISTICS 0;
ALTER TABLE ONLY servico ALTER COLUMN ativo SET STATISTICS 0;


ALTER TABLE servico OWNER TO postgres;

--
-- TOC entry 2319 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN servico.codigo_usuario; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN servico.codigo_usuario IS 'USUÁRIO RESPONSÁVEL PELO SERVIÇO';


--
-- TOC entry 2320 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN servico.anexo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN servico.anexo IS 'POSSUÍ ANEXO';


--
-- TOC entry 215 (class 1259 OID 55491)
-- Name: servico_arquivo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE servico_arquivo (
    codigo_servico_arquivo integer NOT NULL,
    codigo_servico integer NOT NULL,
    nome character varying(50) NOT NULL,
    extensao character varying(4) NOT NULL,
    diretorio character varying(50) NOT NULL,
    data date NOT NULL,
    hora time(6) without time zone NOT NULL
);
ALTER TABLE ONLY servico_arquivo ALTER COLUMN codigo_servico_arquivo SET STATISTICS 0;
ALTER TABLE ONLY servico_arquivo ALTER COLUMN codigo_servico SET STATISTICS 0;
ALTER TABLE ONLY servico_arquivo ALTER COLUMN nome SET STATISTICS 0;
ALTER TABLE ONLY servico_arquivo ALTER COLUMN hora SET STATISTICS 0;


ALTER TABLE servico_arquivo OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 55489)
-- Name: servico_arquivo_codigo_protocolo_arquivo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE servico_arquivo_codigo_protocolo_arquivo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE servico_arquivo_codigo_protocolo_arquivo_seq OWNER TO postgres;

--
-- TOC entry 2321 (class 0 OID 0)
-- Dependencies: 214
-- Name: servico_arquivo_codigo_protocolo_arquivo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE servico_arquivo_codigo_protocolo_arquivo_seq OWNED BY servico_arquivo.codigo_servico_arquivo;


--
-- TOC entry 213 (class 1259 OID 55444)
-- Name: servico_prioridade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE servico_prioridade (
    codigo_servico_prioridade smallint NOT NULL,
    nome character varying(20) NOT NULL,
    cor_exibicao character varying(15) NOT NULL
);


ALTER TABLE servico_prioridade OWNER TO postgres;

--
-- TOC entry 2322 (class 0 OID 0)
-- Dependencies: 213
-- Name: COLUMN servico_prioridade.cor_exibicao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN servico_prioridade.cor_exibicao IS 'COR DE EXIBIÇÃO DA PRIORIDADE';


--
-- TOC entry 217 (class 1259 OID 55621)
-- Name: servico_produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE servico_produto (
    codigo_servico smallint NOT NULL,
    codigo_produto smallint NOT NULL
);
ALTER TABLE ONLY servico_produto ALTER COLUMN codigo_servico SET STATISTICS 0;
ALTER TABLE ONLY servico_produto ALTER COLUMN codigo_produto SET STATISTICS 0;


ALTER TABLE servico_produto OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 55437)
-- Name: servico_status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE servico_status (
    codigo_servico_status smallint NOT NULL,
    nome character varying(60) NOT NULL,
    cor_exibicao character varying(15)
);


ALTER TABLE servico_status OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 46322)
-- Name: sq_exemplo; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_exemplo
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 99999
    CACHE 1;


ALTER TABLE sq_exemplo OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 25240)
-- Name: tipo_produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tipo_produto (
    codigo_tipo_produto integer NOT NULL,
    nome character varying(100) NOT NULL,
    descricao text,
    ativo boolean DEFAULT true
);
ALTER TABLE ONLY tipo_produto ALTER COLUMN codigo_tipo_produto SET STATISTICS 0;
ALTER TABLE ONLY tipo_produto ALTER COLUMN nome SET STATISTICS 0;
ALTER TABLE ONLY tipo_produto ALTER COLUMN descricao SET STATISTICS 0;
ALTER TABLE ONLY tipo_produto ALTER COLUMN ativo SET STATISTICS 0;


ALTER TABLE tipo_produto OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 25225)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
    codigo_usuario integer NOT NULL,
    codigo_pessoa smallint NOT NULL,
    email character varying(100) NOT NULL,
    senha character varying(100) NOT NULL,
    ativo boolean DEFAULT true
);
ALTER TABLE ONLY usuario ALTER COLUMN codigo_usuario SET STATISTICS 0;
ALTER TABLE ONLY usuario ALTER COLUMN codigo_pessoa SET STATISTICS 0;
ALTER TABLE ONLY usuario ALTER COLUMN email SET STATISTICS 0;
ALTER TABLE ONLY usuario ALTER COLUMN senha SET STATISTICS 0;
ALTER TABLE ONLY usuario ALTER COLUMN ativo SET STATISTICS 0;


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 2099 (class 2604 OID 55363)
-- Name: log codigo_log; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY log ALTER COLUMN codigo_log SET DEFAULT nextval('log_codigo_log_seq'::regclass);


--
-- TOC entry 2103 (class 2604 OID 55494)
-- Name: servico_arquivo codigo_servico_arquivo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_arquivo ALTER COLUMN codigo_servico_arquivo SET DEFAULT nextval('servico_arquivo_codigo_protocolo_arquivo_seq'::regclass);


--
-- TOC entry 2291 (class 0 OID 25164)
-- Dependencies: 200
-- Data for Name: cidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cidade (codigo_cidade, nome, codigo_estado, ativo) FROM stdin;
1	DOM PEDRITO	21	t
2	BAGÉ	21	t
\.


--
-- TOC entry 2296 (class 0 OID 46826)
-- Dependencies: 205
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY estado (codigo_estado, nome, sigla, ativo) FROM stdin;
1	ACRE	AC	t
2	ALAGOAS	AL	t
3	AMAPÁ	AP	t
4	AMAZONAS	AM	t
5	BAHIA	BA	t
6	CEARÁ	CE	t
7	DISTRITO FEDERAL	DF	t
8	ESPÍRITO SANTO	ES	t
9	GOIÁS	GO	t
10	MARANHÃO	MA	t
11	MATO GROSSO	MT	t
12	MATO GROSSO DO SUL	MS	t
13	MINAS GERAIS	MG	t
14	PARÁ	PA	t
15	PARAÍBA	PB	t
16	PARANÁ	PR	t
17	PERNAMBUCO	PE	t
18	PIAUÍ	PI	t
19	RIO DE JANEIRO	RJ	t
20	RIO GRANDE DO NORTE	RN	t
21	RIO GRANDE DO SUL	RS	t
22	RONDÔNIA	RO	t
23	RORAIMA	RR	t
24	SANTA CATARINA	SC	t
25	SÃO PAULO	SP	t
26	SERGIPE	SE	t
27	TOCANTINS	TO	t
28	TESTE DE SISTEMA	TS	t
\.


--
-- TOC entry 2301 (class 0 OID 55379)
-- Dependencies: 210
-- Data for Name: formulario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY formulario (codigo_formulario, nome, objeto, menu, ativo) FROM stdin;
1	CADASTRO DE PESSOA	cadastro_pessoa.php	t	t
2	CADASTRO DE ESTADO	cadastro_estado.php	t	t
3	CADASTRO DE CIDADE	cadastro_cidade.php	t	t
4	CADASTRO DE ÓRGÃO EMISSOR	cadastro_orgao_emissor.php	t	t
5	CADASTRO DE TIPO PRODUTO	cadastro_tipo_produto.php	t	t
6	CADASTRO DE USUÁRIO	cadastro_usuario.php	t	t
7	CADASTRO DE PRODUTO	cadastro_produto.php	t	t
8	NOVO SERVICO	novo_servico.php	t	t
9	ATENDE SERVICO	atende_servico.php	f	t
\.


--
-- TOC entry 2300 (class 0 OID 55360)
-- Dependencies: 209
-- Data for Name: log; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY log (codigo_log, descricao, codigo_log_tipo_acao, codigo_formulario, codigo_usuario, data, hora) FROM stdin;
1	CADASTRO DE DADOS DO ESTADO: 28, NOME: TESTE DE SISTEMA	1	2	1	2019-11-24	19:11:17
2	ALTERAÇÃO DE DADOS DO ESTADO: 28, NOME: TESTE SISTEMA	2	2	1	2019-11-24	19:11:51
3	CADASTRO DE DADOS DO CIDADE: 2, NOME: BAGÉ	1	3	1	2019-11-24	19:32:16
4	ALTERAÇÃO DE DADOS DO CIDADE: 2, NOME: BAGÉ	2	3	1	2019-11-24	19:33:10
5	ALTERAÇÃO DE DADOS DO CIDADE: 2, NOME: BAGÉ	2	3	1	2019-11-24	19:33:23
6	CADASTRO DE DADOS DO ESTADO: 21, NOME: TESTE DE SISTEMA	1	2	1	2019-11-24	19:49:18
7	ALTERAÇÃO DE DADOS DO ESTADO: 21, NOME: TESTE SISTEMA	2	2	1	2019-11-24	19:49:32
8	CADASTRO DE DADOS DO TIPO PRODUTO: 1, NOME: TESTE DE SISTEMA	1	5	1	2019-11-24	20:14:01
9	ALTERAÇÃO DE DADOS DO TIPO PRODUTO: 1, NOME: TESTE DE SISTEMA	2	5	1	2019-11-24	20:14:56
10	ALTERAÇÃO DE DADOS DO TIPO PRODUTO: 1, NOME: TESTE SISTEMA	2	5	1	2019-11-24	20:15:06
11	ALTERAÇÃO DE DADOS DA PESSOA: 1, NOME: HARIEL VIANA MORALES DA SILVA	1	1	1	2019-11-24	21:12:16
12	ALTERAÇÃO DE DADOS DO USUÁRIO: 1	2	6	1	2019-11-25	14:21:42
13	ALTERAÇÃO DE DADOS DO USUÁRIO: 1	2	6	1	2019-11-25	14:22:48
14	CADASTRO DE DADOS DO TIPO PRODUTO: 1, NOME: TESTE DE SISTEMA	1	5	1	2019-11-25	14:31:36
15	CADASTRO DE DADOS DO PRODUTO: 1, NOME: TESTE DE SISTEMA	1	7	1	2019-11-25	17:31:39
16	CADASTRO DE DADOS DO PRODUTO: 2, NOME: TESTE DE SISTEMA 2	1	7	1	2019-11-25	18:09:01
17	ALTERAÇÃO DE DADOS DO PRODUTO: 2, NOME: TESTE DE SISTEMA 2	2	7	1	2019-11-25	18:17:13
18	ALTERAÇÃO DE DADOS DO PRODUTO: 1, NOME: TESTE DE SISTEMA	2	7	1	2019-11-25	18:17:58
19	CADASTRO DE DADOS DO TIPO PRODUTO: 1, NOME: TESTE DE SISTEMA	1	5	1	2019-11-25	20:48:40
20	CADASTRO DE DADOS DO SERVICO: 1	1	8	1	2019-11-26	12:44:56
21	CADASTRO DE DADOS DO SERVICO: 2	1	8	1	2019-11-26	21:04:37
22	CADASTRO DE DADOS DA PESSOA: 2, NOME: THIAGO VELEDA IANZER RODRIGUES	1	1	1	2019-11-26	21:26:31
23	ALTERAÇÃO DE DADOS DO TIPO PRODUTO: 1, NOME: VIDRO	2	5	1	2019-11-26	21:27:16
24	CADASTRO DE DADOS DO TIPO PRODUTO: 2, NOME: ESPELHO	1	5	1	2019-11-26	21:27:28
25	CADASTRO DE DADOS DO TIPO PRODUTO: 3, NOME: MOLDURA	1	5	1	2019-11-26	21:27:40
26	CADASTRO DE DADOS DO TIPO PRODUTO: 4, NOME: SUPORTE	1	5	1	2019-11-26	21:28:01
27	CADASTRO DE DADOS DO SERVICO: 3	1	8	1	2019-11-26	21:30:38
28	CADASTRO DE DADOS DO PRODUTO: 1, NOME: TEMPERADO	1	7	1	2019-11-26	22:40:03
29	CADASTRO DE DADOS DO PRODUTO: 2, NOME: MOLDURA	1	7	1	2019-11-26	22:40:49
30	CADASTRO DE DADOS DO PRODUTO: 3, NOME: ESPELHO REDONDO	1	7	1	2019-11-26	22:41:35
35	CADASTRO DE DADOS DO SERVICO: 4	1	8	1	2019-11-27	10:24:49
36	CADASTRO DE DADOS DO SERVICO: 5	1	8	1	2019-11-27	10:27:09
37	ALTERAÇÃO DO STATUS DO SERVICO: 1, STATUS: 3	2	9	1	2019-11-27	16:57:46
38	CADASTRO DE DADOS DO SERVICO: 6	1	8	1	2019-11-27	18:34:21
39	CADASTRO DE DADOS DO SERVICO: 7	1	8	1	2019-11-27	18:37:27
40	CADASTRO DE DADOS DO SERVICO: 8	1	8	1	2019-11-27	18:38:11
41	CADASTRO DE DADOS DO SERVICO: 9	1	8	1	2019-11-27	18:39:23
42	CADASTRO DE DADOS DO ESTADO: 28, NOME: TESTE DE SISTEMA	1	2	1	2019-11-27	21:15:25
43	CADASTRO DE DADOS DO SERVICO: 10	1	8	1	2019-11-27	21:22:26
44	ALTERAÇÃO DO STATUS DO SERVICO: 9, STATUS: 2	2	9	1	2019-11-27	21:23:11
\.


--
-- TOC entry 2298 (class 0 OID 55342)
-- Dependencies: 207
-- Data for Name: log_tipo_acao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY log_tipo_acao (codigo_log_tipo_acao, nome) FROM stdin;
1	INSERT
2	UPDATE
\.


--
-- TOC entry 2297 (class 0 OID 46841)
-- Dependencies: 206
-- Data for Name: orgao_emissor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY orgao_emissor (codigo_orgao_emissor, nome, sigla, ativo) FROM stdin;
1	CARTEIRA DE ESTRANGEIRO	SES	t
2	CARTEIRA DE TRABAHO E PREVIDÊNCIA SOCIAL	CTPS	t
3	CARTEIRA NACIONAL DE HABILITAÇÃO	CNT	t
4	DIRETORIA DE IDENTIFICAÇÃO CIVIL	DIC	t
5	FUNDO DE GARANTIA DO TEMPO DE SERVIÇO	FGTS	t
6	INSTITUTO FÉLIX PACHECO	IFP	t
7	INSTITUTO MÉDICO-LEGAL	IML	t
8	INSTITUTO PEREIRA FAUSTINO	IPF	t
9	MINISTÉRIO DA AERONÁUTICA	MAE	t
10	MINISTÉRIO DA MARINHA	MMA	t
11	MINISTÉRIO DO EXÉRCITO	MEX	t
12	MINISTÉRIO DO TRABALHO E EMPREGO	MTE	t
13	OUTROS (INCLUSIVE EXTERIOR)	ZZZ	t
14	POLICIA CIVIL	PC	t
15	POLÍCIA FEDERAL	POF	t
16	POLÍCIA MILITAR	PM	t
17	POLÍCIA MILITAR	POM	t
18	SECRETARIA DA JUSTIÇA DO TRABALHO E SEGURANÇA	SJTS	t
19	SECRETARIA DA JUSTIÇA E SEGURANÇA	SJS	t
20	SECRETARIA DE SEGURANÇA PÚBLICA	SSP	t
\.


--
-- TOC entry 2302 (class 0 OID 55399)
-- Dependencies: 211
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pessoa (codigo_pessoa, tipo_pessoa, nome_razao_social, cpf_cnpj, identidade, codigo_orgao_emissor, titulo_eleitor, sexo, nome_fantasia, responsavel, codigo_estado, inscricao_estadual, inscricao_municipal, codigo_cidade, cep, endereco, numero, complemento, bairro, telefone, telefone_adicional, observacao, ativo) FROM stdin;
1	F	HARIEL VIANA MORALES DA SILVA	03946553036	2100735477	19		M			\N			1	96450000	RUA SEVERO DOS SANTOS PACIELO	264	CASA 02	CENTRO	53999960295	53999960295	TESTE DE SISTEMA	t
2	F	THIAGO VELEDA IANZER RODRIGUES	03887161009	5109059815	20		M			\N			2	96400320	RUA DR. SANTOS SOUZA	242	OFICINA AMINCAR	CENTRO	53999335215		TESTE DE SISTEMA	t
\.


--
-- TOC entry 2294 (class 0 OID 25249)
-- Dependencies: 203
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY produto (codigo_produto, nome, codigo_tipo_produto, cor, espessura, observacao, ativo) FROM stdin;
1	TEMPERADO	1	FUME	5	TESTE DE SISTEMA	t
2	MOLDURA	3	BRANCA	5	TESTE DE SISTEMA	t
3	ESPELHO REDONDO	2	BRANCA	5	TESTE DE SISTEMA	t
\.


--
-- TOC entry 2307 (class 0 OID 55585)
-- Dependencies: 216
-- Data for Name: servico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY servico (codigo_servico, codigo_pessoa, codigo_usuario, codigo_servico_prioridade, codigo_servico_status, prazo, valor, descricao, data_abertura, hora_abertura, data_encerramento, hora_encerramento, anexo, ativo) FROM stdin;
2	1	1	2	1	2019-12-05	250.00	TESTE DE SISTEMA	2019-11-26	21:04:37	\N	\N	f	t
3	2	1	2	1	2019-12-06	25.12	PRECISO DA TROCA DO ESPELHO MINHA CASA	2019-11-26	21:30:38	\N	\N	f	t
4	1	1	3	1	2019-11-30	250.00	TESTE DE SISTEMA	2019-11-27	10:24:49	\N	\N	f	t
5	2	1	3	1	2019-11-30	250.00	TESTE DE SISTEMA	2019-11-27	10:27:09	\N	\N	f	t
1	1	1	3	3	2019-11-30	251.54	TESTE DE SISTEMA	2019-11-26	12:44:56	\N	\N	f	t
6	2	1	3	1	2019-11-30	230.00	TESTE DE SISTEMA	2019-11-27	18:34:21	\N	\N	t	t
7	1	1	3	1	2019-11-29	230.00	TESTE DE SISTEMA	2019-11-27	18:37:27	\N	\N	t	t
8	2	1	3	1	2019-11-30	230.00	TESTE DE SISTEMA	2019-11-27	18:38:11	\N	\N	t	t
10	2	1	2	1	2019-11-29	251.45	TESTE DE SISTEMA	2019-11-27	21:22:26	\N	\N	f	t
9	1	1	2	2	2019-11-30	230.00	TESTE DE SISTEMA	2019-11-27	18:39:23	\N	\N	t	t
\.


--
-- TOC entry 2306 (class 0 OID 55491)
-- Dependencies: 215
-- Data for Name: servico_arquivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY servico_arquivo (codigo_servico_arquivo, codigo_servico, nome, extensao, diretorio, data, hora) FROM stdin;
1	7	2f2e0b2b8c7991ff5c2fd5d55df5e95e	.txt	/	2019-11-27	18:37:27
2	8	6489d108557947a4e4d4489edfb0ebfa	.txt	/	2019-11-27	18:38:11
3	9	41f367f0f2c9879d510b835000515f36	.txt	9/	2019-11-27	18:39:23
4	10	c1f206444570df5dd6b045de1bb7518e	.	10/	2019-11-27	21:22:27
\.


--
-- TOC entry 2304 (class 0 OID 55444)
-- Dependencies: 213
-- Data for Name: servico_prioridade; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY servico_prioridade (codigo_servico_prioridade, nome, cor_exibicao) FROM stdin;
1	ALTA	#FF0000
3	BAIXA	#00008B
2	MÉDIA	#008000
\.


--
-- TOC entry 2308 (class 0 OID 55621)
-- Dependencies: 217
-- Data for Name: servico_produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY servico_produto (codigo_servico, codigo_produto) FROM stdin;
4	3
4	2
5	2
5	3
5	1
6	2
6	3
7	2
7	1
8	2
8	3
9	2
9	3
10	3
10	2
\.


--
-- TOC entry 2303 (class 0 OID 55437)
-- Dependencies: 212
-- Data for Name: servico_status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY servico_status (codigo_servico_status, nome, cor_exibicao) FROM stdin;
1	PENDENTE	#AAAAAA
2	EM ATENDIMENTO	#FFD700
3	CONCLUÍDO	#008000
4	ATRASADO	#FF0000
5	CANCELADO	#FFA500
\.


--
-- TOC entry 2293 (class 0 OID 25240)
-- Dependencies: 202
-- Data for Name: tipo_produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_produto (codigo_tipo_produto, nome, descricao, ativo) FROM stdin;
1	VIDRO	TESTE DE SISTEMA	t
2	ESPELHO	TESTE DE SISTEMA	t
3	MOLDURA	TESTE DE SISTEMA	t
4	SUPORTE	TESTE DE SISTEMA	t
\.


--
-- TOC entry 2292 (class 0 OID 25225)
-- Dependencies: 201
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (codigo_usuario, codigo_pessoa, email, senha, ativo) FROM stdin;
1	1	hariel.0371@gmail.com	b5c24ab1ddc1aecd658a6cd39eb2362d	t
\.


--
-- TOC entry 2323 (class 0 OID 0)
-- Dependencies: 208
-- Name: log_codigo_log_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('log_codigo_log_seq', 44, true);


--
-- TOC entry 2324 (class 0 OID 0)
-- Dependencies: 214
-- Name: servico_arquivo_codigo_protocolo_arquivo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('servico_arquivo_codigo_protocolo_arquivo_seq', 4, true);


--
-- TOC entry 2325 (class 0 OID 0)
-- Dependencies: 204
-- Name: sq_exemplo; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_exemplo', 6, true);


--
-- TOC entry 2107 (class 2606 OID 25169)
-- Name: cidade cidade_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (codigo_cidade);


--
-- TOC entry 2119 (class 2606 OID 46833)
-- Name: estado estado_nome_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado
    ADD CONSTRAINT estado_nome_key UNIQUE (nome);


--
-- TOC entry 2121 (class 2606 OID 46831)
-- Name: estado estado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (codigo_estado);


--
-- TOC entry 2123 (class 2606 OID 46835)
-- Name: estado estado_sigla_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado
    ADD CONSTRAINT estado_sigla_key UNIQUE (sigla);


--
-- TOC entry 2133 (class 2606 OID 55387)
-- Name: formulario formulario_objeto_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY formulario
    ADD CONSTRAINT formulario_objeto_key UNIQUE (objeto);


--
-- TOC entry 2135 (class 2606 OID 55385)
-- Name: formulario formulario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY formulario
    ADD CONSTRAINT formulario_pkey PRIMARY KEY (codigo_formulario);


--
-- TOC entry 2131 (class 2606 OID 55368)
-- Name: log log_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY log
    ADD CONSTRAINT log_pkey PRIMARY KEY (codigo_log);


--
-- TOC entry 2129 (class 2606 OID 55346)
-- Name: log_tipo_acao log_tipo_acao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY log_tipo_acao
    ADD CONSTRAINT log_tipo_acao_pkey PRIMARY KEY (codigo_log_tipo_acao);


--
-- TOC entry 2125 (class 2606 OID 46846)
-- Name: orgao_emissor orgao_emissor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orgao_emissor
    ADD CONSTRAINT orgao_emissor_pkey PRIMARY KEY (codigo_orgao_emissor);


--
-- TOC entry 2127 (class 2606 OID 46848)
-- Name: orgao_emissor orgao_emissor_sigla_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orgao_emissor
    ADD CONSTRAINT orgao_emissor_sigla_key UNIQUE (sigla);


--
-- TOC entry 2137 (class 2606 OID 55409)
-- Name: pessoa pessoa_cpf_cnpj_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_cpf_cnpj_key UNIQUE (cpf_cnpj);


--
-- TOC entry 2139 (class 2606 OID 55407)
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (codigo_pessoa);


--
-- TOC entry 2117 (class 2606 OID 25257)
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (codigo_produto);


--
-- TOC entry 2145 (class 2606 OID 55450)
-- Name: servico_prioridade protocolo_prioridade_cor_exibicao_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_prioridade
    ADD CONSTRAINT protocolo_prioridade_cor_exibicao_key UNIQUE (cor_exibicao);


--
-- TOC entry 2147 (class 2606 OID 55452)
-- Name: servico_prioridade protocolo_prioridade_nome_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_prioridade
    ADD CONSTRAINT protocolo_prioridade_nome_key UNIQUE (nome);


--
-- TOC entry 2149 (class 2606 OID 55448)
-- Name: servico_prioridade protocolo_prioridade_pk_solicitacao_prioridade; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_prioridade
    ADD CONSTRAINT protocolo_prioridade_pk_solicitacao_prioridade PRIMARY KEY (codigo_servico_prioridade);


--
-- TOC entry 2141 (class 2606 OID 55443)
-- Name: servico_status protocolo_status_Nome_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_status
    ADD CONSTRAINT "protocolo_status_Nome_key" UNIQUE (nome);


--
-- TOC entry 2143 (class 2606 OID 55441)
-- Name: servico_status protocolo_status_pk_solicitacao_status; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_status
    ADD CONSTRAINT protocolo_status_pk_solicitacao_status PRIMARY KEY (codigo_servico_status);


--
-- TOC entry 2151 (class 2606 OID 55496)
-- Name: servico_arquivo servico_arquivo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_arquivo
    ADD CONSTRAINT servico_arquivo_pkey PRIMARY KEY (codigo_servico_arquivo);


--
-- TOC entry 2153 (class 2606 OID 55594)
-- Name: servico servico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico
    ADD CONSTRAINT servico_pkey PRIMARY KEY (codigo_servico);


--
-- TOC entry 2115 (class 2606 OID 25248)
-- Name: tipo_produto tipo_produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_produto
    ADD CONSTRAINT tipo_produto_pkey PRIMARY KEY (codigo_tipo_produto);


--
-- TOC entry 2109 (class 2606 OID 25232)
-- Name: usuario usuario_codigo_pessoa_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_codigo_pessoa_key UNIQUE (codigo_pessoa);


--
-- TOC entry 2111 (class 2606 OID 25230)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (codigo_usuario);


--
-- TOC entry 2113 (class 2606 OID 46415)
-- Name: usuario usuario_usuario_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_usuario_key UNIQUE (email);


--
-- TOC entry 2154 (class 2606 OID 46836)
-- Name: cidade cidade_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT cidade_fk FOREIGN KEY (codigo_estado) REFERENCES estado(codigo_estado);


--
-- TOC entry 2157 (class 2606 OID 55369)
-- Name: log log_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY log
    ADD CONSTRAINT log_fk FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo_usuario);


--
-- TOC entry 2158 (class 2606 OID 55374)
-- Name: log log_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY log
    ADD CONSTRAINT log_fk1 FOREIGN KEY (codigo_log_tipo_acao) REFERENCES log_tipo_acao(codigo_log_tipo_acao);


--
-- TOC entry 2159 (class 2606 OID 55388)
-- Name: log log_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY log
    ADD CONSTRAINT log_fk2 FOREIGN KEY (codigo_formulario) REFERENCES formulario(codigo_formulario);


--
-- TOC entry 2162 (class 2606 OID 55420)
-- Name: pessoa pessoa_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (codigo_estado) REFERENCES estado(codigo_estado);


--
-- TOC entry 2160 (class 2606 OID 55410)
-- Name: pessoa pessoa_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_fk1 FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo_cidade);


--
-- TOC entry 2161 (class 2606 OID 55415)
-- Name: pessoa pessoa_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_fk2 FOREIGN KEY (codigo_orgao_emissor) REFERENCES orgao_emissor(codigo_orgao_emissor);


--
-- TOC entry 2156 (class 2606 OID 25258)
-- Name: produto produto_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_fk FOREIGN KEY (codigo_tipo_produto) REFERENCES tipo_produto(codigo_tipo_produto);


--
-- TOC entry 2163 (class 2606 OID 55616)
-- Name: servico_arquivo servico_arquivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_arquivo
    ADD CONSTRAINT servico_arquivo_fk FOREIGN KEY (codigo_servico) REFERENCES servico(codigo_servico);


--
-- TOC entry 2164 (class 2606 OID 55595)
-- Name: servico servico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico
    ADD CONSTRAINT servico_fk FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo_pessoa);


--
-- TOC entry 2165 (class 2606 OID 55600)
-- Name: servico servico_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico
    ADD CONSTRAINT servico_fk1 FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo_usuario);


--
-- TOC entry 2166 (class 2606 OID 55605)
-- Name: servico servico_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico
    ADD CONSTRAINT servico_fk2 FOREIGN KEY (codigo_servico_prioridade) REFERENCES servico_prioridade(codigo_servico_prioridade);


--
-- TOC entry 2167 (class 2606 OID 55610)
-- Name: servico servico_fk3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico
    ADD CONSTRAINT servico_fk3 FOREIGN KEY (codigo_servico_status) REFERENCES servico_status(codigo_servico_status);


--
-- TOC entry 2168 (class 2606 OID 55624)
-- Name: servico_produto servico_produto_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_produto
    ADD CONSTRAINT servico_produto_fk FOREIGN KEY (codigo_servico) REFERENCES servico(codigo_servico);


--
-- TOC entry 2169 (class 2606 OID 55629)
-- Name: servico_produto servico_produto_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servico_produto
    ADD CONSTRAINT servico_produto_fk1 FOREIGN KEY (codigo_produto) REFERENCES produto(codigo_produto);


--
-- TOC entry 2155 (class 2606 OID 55425)
-- Name: usuario usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_fk FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo_pessoa);


-- Completed on 2019-12-20 11:30:55

--
-- PostgreSQL database dump complete
--

