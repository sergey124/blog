CREATE TABLE post(
    id UUID,
    title varchar,
    content varchar,
    PRIMARY KEY(id)
);

CREATE TABLE comment(
    post_id UUID,
    id TIMEUUID,
    created_date timestamp,
    comment varchar,
    PRIMARY KEY(post_id, id)
);

INSERT INTO post(id, title, content) values(e8546746-6b83-42cf-9386-0ce602f16d7a, 'First post', 'Some content');
INSERT INTO post(id, title, content) values(e8546746-6b83-42cf-9386-0ce602f16d7b, 'Second post', 'Some more content');
INSERT INTO post(id, title, content) values(uuid(), 'Third post', 'And one more thing');

INSERT INTO comment(post_id, id, created_date, comment) values(e8546746-6b83-42cf-9386-0ce602f16d7a, e899e620-e1ab-11ec-83ed-e318e1b81e6d, '2022-05-31T11:32:02.909', 'Cool beans!');
INSERT INTO comment(post_id, id, created_date, comment) values(e8546746-6b83-42cf-9386-0ce602f16d7a, now(), '2021-01-01T05:00:00.000', 'No there not');
