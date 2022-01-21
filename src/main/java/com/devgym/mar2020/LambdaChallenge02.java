package com.devgym.mar2020;

public class LambdaChallenge02 {
	
	public static void main(String... doYourBest) {
        String vitoCorleoneShoot = useRevolver(() -> "BAMM!!");

        String michaelCorleoneShoot = useShotgun(() -> {
            return "POHHHH!!!"; // Line 7
        });

        System.out.println(vitoCorleoneShoot + michaelCorleoneShoot);
    }

    private static String useRevolver(Revolver revolver) {
        return revolver.shoot();
    }

    static String useShotgun(Shotgun shotgun) {
        return shotgun.shoot();
    }

    private interface Revolver {
        String shoot(); // Line 23
    }

    public interface Shotgun {
        String shoot();

        default String reload() { // Line 29
            return "Reloading...";
        }
    }
}

/*
 * What will be displayed on the screen after the main method is executed as follows?
 * 
 * 

Choice 1

It won't compile at "// Line 23"

Choice 2

It won't compile at "// Line 7"

Choice 3

It won't compile at "// Line 29"

Choice 4

BAMM!!POHHHH!!!  <-------- Correct Answer




Suppose we have the following table in our schema:

create table plch_employees ( 
   employee_id number (4) NOT NULL
 , employee_name varchar2 (10) NOT NULL 
 , employee_salary number (7,2) NOT NULL 
 , employee_comm number (7,2) ); 

And we populate it with the following data:

insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7369, 'SMITH' , 800 , NULL);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7499, 'ALLEN' , 1600, 300 );
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7521, 'WARD'  , 1250, 500 );
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7566, 'JONES' , 2975, NULL);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7654, 'MARTIN', 1250, 1400);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7698, 'BLAKE' , 2850, NULL);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7782, 'CLARK' , 2450, NULL);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7788, 'SCOTT' , 3000, NULL);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7839, 'KING'  , 5000, NULL);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7844, 'TURNER', 1500, 0   );
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7876, 'ADAMS' , 1100, NULL);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7900, 'JAMES' , 950 , NULL);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7902, 'FORD'  , 3000, NULL);
insert into plch_employees(employee_id, employee_name, employee_salary, employee_comm)
                   values ( 7934, 'MILLER', 1300, NULL);

commit;

We want to retrieve the total earnings (i.e. salary + commission) of an employee. Which queries give us the correct result?
Choices - Select all that apply.
Choice 1

select e.employee_name, e.employee_salary + nvl(e.employee_comm, 0)
from plch_employees e
/

Choice 2

select e.employee_name
     , coalesce(e.employee_comm + e.employee_salary, e.employee_salary)
  from plch_employees e
/

Choice 3

select e.employee_name
     , coalesce(e.employee_salary, e.employee_comm + e.employee_salary)
  from plch_employees e
/

Choice 4

select e.employee_name
     , e.employee_salary + coalesce(e.employee_comm, 0)
  from plch_employees e
/

Choice 5

select e.employee_name, e.employee_salary + case
                          when e.employee_comm is null then 0
                          else e.employee_comm
                        end
  from plch_employees e
/

Choice 6

select e.employee_name, e.employee_salary + e.employee_comm
  from plch_employees e
/

No choice is correct.


 */
