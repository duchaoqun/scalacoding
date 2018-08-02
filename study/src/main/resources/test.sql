drop table gaode_weatherinfo;
CREATE TABLE
    gaode_weatherinfo
    (
        id INT NOT NULL auto_increment COMMENT 'ID',
        province CHAR(20),
        city CHAR(20),
        adcode CHAR(10),
        weather CHAR(20),
        temperature CHAR(10),
        winddirection CHAR(10),
        windpower CHAR(5),
        humidity CHAR(5),
        reporttime CHAR(20),
        PRIMARY KEY(id)
    ) DEFAULT CHARSET=utf8;


CREATE TABLE
    region
(
    REGION_ID DOUBLE NOT NULL,
    REGION_CODE VARCHAR(100) NOT NULL,
    REGION_NAME VARCHAR(100) NOT NULL,
    PARENT_ID DOUBLE NOT NULL,
    REGION_LEVEL DOUBLE NOT NULL,
    REGION_ORDER DOUBLE NOT NULL,
    REGION_NAME_EN VARCHAR(100) NOT NULL,
    REGION_SHORTNAME_EN VARCHAR(10) NOT NULL,
    PRIMARY KEY (REGION_ID)
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;