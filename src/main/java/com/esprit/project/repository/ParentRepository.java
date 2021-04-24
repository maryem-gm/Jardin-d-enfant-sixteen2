package com.esprit.project.repository;




//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.project.entity.Parent;





@Repository
public interface ParentRepository extends CrudRepository<Parent, Long> {
	
	
	/*@Query(value = "SELECT COUNT(*) FROM t_events_parents", nativeQuery = true)
	long getEmployeeCountJPQL();
*/
   
	
}
