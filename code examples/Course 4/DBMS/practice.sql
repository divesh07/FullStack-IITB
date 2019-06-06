-- Comments here
select * from employee;

select fname as "First Name", lname as "Last Name" from employee;

select * from employee where sex='M' and salary >= 30000;

select * from employee where sex='M' or salary >= 30000;

select * from employee where sex='F' or salary <= 25000;

select * from dependent where essn = '333445555';

select dname,mgr_start_date from department;

-- extract is a built in function
select dname, extract ( year from mgr_start_date) from department;

-- name begins with J , followed by any character represented by %
select fname from employee where fname like 'J%';

select * from dept_locations;

select * from dept_locations where dlocation in ('Houston','Stafford');

select * from dept_locations where dlocation not in ('Houston','Stafford');

select concat(fname , ' ', minit, ' ', lname) from employee;

-- cannout use = for comparing with NULL  , use 'is'
select * from employee where super_ssn is null;

-- invalid , would return blank line
select * from employee where super_ssn = null;

select * from employee where super_ssn is not null;

-- start with anything followed by ee and ends with anything
select * from employee where fname like '%ee%';

select * from employee where fname like '%oh%';

select extract(year from bdate) as Year from employee;

select * from employee where extract(year from bdate) = 1941;

-- order by for sorting ( Default sort order is Ascending - asc)
select ssn,salary,dno 
from employee
where dno = 5
order by salary desc;

-- Ascending order of salary
select ssn,salary,dno 
from employee
order by salary asc;

-- sort based on multiple fields ( primary and secondary sorting fields)
select * from works_on
order by pno, hours desc;

select * from employee
order by fname desc;

select * from works_on
order by pno asc, hours desc;

-- Aggregate functions
select hours from works_on;
select avg(hours) from works_on;
select min(hours) from works_on;
select max(hours) from works_on;
select sum(hours) from works_on;
select count(hours) from works_on;

-- Count(*) also includes NULL
select count(*) from employee;

-- NUll would be ignored
select count(super_ssn) from employee;

select count(*) from employee where super_ssn is NULL;
select count(*) from employee where super_ssn is not NULL;

select avg(salary) from employee where super_ssn is NULL;

select max(salary) from employee where dno = 5;

select avg(salary) from employee where sex='M';

select dno , count(*) as "No of Employees" 
from employee 
group by dno
order by dno asc;

select * from employee;

-- multiple group by
select dno, sex, avg(salary) from employee where super_ssn = '333445555' group by dno, sex;

select dno, sex, fname , min(salary) from employee where super_ssn = '333445555' group by dno, sex, fname;

select sex,dno, count(*) from employee group by sex, dno order by count(*) desc;

select sex, count(*) from employee group by sex;

select dno, sum(salary) from employee group by dno;

select sex, avg(salary) from employee group by sex;

-- Having clause  , to put filter on the aggregate functions

select dno, count(*) from employee group by dno having count(*) >=3;

select dno, avg(salary) from employee where salary >= 30000 group by dno;

select dno, avg(salary) from employee group by dno having avg(salary) > 30000;

select * from department;
select fname , dno from employee where dno = ( select dnumber from department where dname='Research');

select avg(salary) from employee;

select fname, salary from employee where salary >= (select avg(salary) from employee);

select e.fname, d.dname from employee e inner join department d on e.dno = d.dnumber;

select * from employee e inner join department d on e.dno = d.dnumber; 

select * from employee;
select * from dept_locations;
-- Inner Join
select e.fname, d.dlocation from employee e inner join dept_locations d on e.dno = d.dnumber;
select * from employee e inner join dept_locations d on e.dno = d.dnumber;
-- Left Join or left outer join
select e.fname, d.dlocation from employee e left outer join dept_locations d on e.dno = d.dnumber;
select e.fname, d.dlocation from employee e left join dept_locations d on e.dno = d.dnumber;
-- Right Join or right outer join
select e.fname, d.dlocation from employee e right join dept_locations d on e.dno = d.dnumber;
select e.fname, d.dlocation from employee e right outer join dept_locations d on e.dno = d.dnumber;
-- Full Join or Full outer join
select e.fname, d.dlocation from employee e full join dept_locations d on e.dno = d.dnumber;
select e.fname, d.dlocation from employee e full outer join dept_locations d on e.dno = d.dnumber;
-- Cross Join / Cartesian Join
select e.fname, d.dlocation from employee e cross join dept_locations d;