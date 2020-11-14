CREATE TABLE "public"."post" (
    "id" bigint NOT NULL,
    "title" character varying(255),
    CONSTRAINT "post_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "uk2jm25hjrq6iv4w8y1dhi0d9p4" UNIQUE ("title")
) WITH (oids = false);

CREATE SEQUENCE seq_post START 1001;

CREATE TABLE "public"."post_comment" (
    "id" bigint NOT NULL,
    "review" character varying(255),
    "post_id" bigint,
    CONSTRAINT "post_comment_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fkna4y825fdc5hw8aow65ijexm0" FOREIGN KEY (post_id) REFERENCES post(id) NOT DEFERRABLE
) WITH (oids = false);

CREATE SEQUENCE seq_postcomment START 1001;