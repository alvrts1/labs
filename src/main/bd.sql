CREATE DATABASE dealsDB;

DROP TABLE IF EXISTS accountPlan, subAccount, operation, deal

CREATE TABLE IF NOT EXISTS accountPlan(
    id serial NOT NULL,
    name_ character varying(30),
    type_ character varying(30),
    number_ integer,
    CONSTRAINT accountPlan_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS subAccount(
    id serial NOT NULL,
    name_ character varying(30),
    number_ character varying(30),
    accountPlanId integer NOT NULL,
    CONSTRAINT subAccount_pkey PRIMARY KEY (id),
    CONSTRAINT subAccount_accountplanid_fkey FOREIGN KEY (accountPlanId) REFERENCES public.accountPlan (id)
);

CREATE TABLE IF NOT EXISTS deal(
    id serial NOT NULL,
    agreement integer,
    tiker character varying(30),
    order_ character varying(30),
    number_ character varying(30),
    date_ character varying(30),
    quantity integer,
    price float,
    totalCost float,
    trader character varying(30),
    commission float,
    accountPlanId integer NOT NULL,
    CONSTRAINT deal_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS operation(
    id serial NOT NULL,
    number_ character varying(30),
    data_ character varying(30),
    type_ character varying(30),
    sum_ float,
    saldoInput float,
    saldoOutput float,
    dealId integer NOT NULL,
    subAccountID integer NOT NULL,
    CONSTRAINT operation_pkey PRIMARY KEY (id),
    CONSTRAINT operation_dealId_fkey FOREIGN KEY (dealId) REFERENCES public.deal (id),
    CONSTRAINT operation_subAccountid_fkey FOREIGN KEY (subAccountId) REFERENCES public.subAccount (id)
);