-- Copyright 2018-2019, https://beingtechie.io

-- Script: db-setup.sql
-- Description: Setup database and users
-- Version: 1.0
-- Author: Thribhuvan Krishnamurthy

-- # Step 1 - Drop the existing schema and reassign permissions

DROP SCHEMA IF EXISTS proman CASCADE;
CREATE SCHEMA proman AUTHORIZATION postgres;
GRANT ALL PRIVILEGES ON SCHEMA proman TO postgres;
COMMIT;

-- ********** End of setup **********
