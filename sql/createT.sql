DROP TABLE if exists chain;

CREATE TABLE chain
(
    chainID BIGINT(32) NOT NULL default 0,
    latestBlockNum BIGINT(32) NOT NULL default 0,
    accounts TEXT NULL default NULL,
    gasPrice BIGINT(32) NOT NULL default 100000000,
    coinBase VARCHAR(10) NULL default NULL
);

DROP TABLE if exists block;

CREATE TABLE block
(
    height BIGINT(32) NOT NULL,
    createTime BIGINT(32) NOT NULL default 0,
    hash VARCHAR(32) NULL default NULL,
    blockSize BIGINT(32) NOT NULL default 0,
    txNum INT(10) NOT NULL default 0

)