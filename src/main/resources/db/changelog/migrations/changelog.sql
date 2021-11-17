-- liquibase formatted sql
CREATE TABLE "transaction_history" (

                                       "transaction_id" serial NOT NULL,
                                       "amount" bigint NOT NULL,
                                       "user_id" bigint NOT NULL,
                                       "project_id" bigint NOT NULL,
                                       "creation_rime" date default CURRENT_TIMESTAMP,
                                       CONSTRAINT "transaction_history_pk" PRIMARY KEY ("transaction_id")
) WITH (
      OIDS=FALSE
    );





