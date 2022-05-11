package com.example.projectsmanagement.repository;

import com.example.projectsmanagement.entities.Employee;
import com.example.projectsmanagement.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Custom query
    @Query(value = "select e from employee e where e.name like %:keyword%")
    Page<Employee> findAllByName(@Param("keyword") String keyword, Pageable pageable);

    @Query(value = "select * from employee order by update_at desc", nativeQuery = true)
    List<Employee> findAllSortByUpdateAtDesc();

//    @Query(value = "SELECT e.* FROM employee e inner join employees_languages el\n" +
//            "on e.id = el.employee_id inner join projects_languages pl\n" +
//            "on el.language_id = pl.language_id\n" +
//            "where pl.project_id = :id", nativeQuery = true)
//    List<Employee> findAllBySameLanguageWithProject(@Param("id") Integer id);
//    @Query(value = "SELECT e.* FROM employee e inner join employees_languages el\n" +
//            "on e.id = el.employee_id\n" +
//            "where el.language_id = :id", nativeQuery = true)
//    List<Employee> findAllEmployeeByLanguage(@Param("id") Integer id);
    @Query(value = "select distinct e.* from employee e\n" +
            "join employees_languages el on e.id = el.employee_id\n" +
            "join language l on el.language_id = l.id\n" +
            "join projects_languages pl on l.id = pl.language_id\n" +
            "where pl.project_id = :project_id and e.status = 1", nativeQuery = true)
    List<Employee> findAllEmployeeByProjectLanguage(@Param("project_id") Integer project_id);

    @Query(value = "select * from employee e\n" +
            "join projects_employees pe on e.id = pe.employee_id\n" +
            "group by e.id\n" +
            "having count(pe.employee_id) < 3 and e.status = 1", nativeQuery = true)
    List<Employee> findAllEmployeeLessThan3Projects();
}
