CREATE TABLE blogpost(
    id UUID,
    title varchar,
    content varchar,
    PRIMARY KEY(title, id)
);

INSERT INTO blogpost(id, title, content) values(uuid(),'First post','Some content');
INSERT INTO blogpost(id, title, content) values(uuid(),'Second post','Some more content');
