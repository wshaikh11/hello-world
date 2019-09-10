package com.afour.recruitment.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afour.recruitment.model.Requirement;
import com.afour.recruitment.model.RequirementStatus;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Long> {
	// This query is used to get list of requirement according to status i.e Open or
	// Closed
	List<Requirement> findByRequirementStatus(RequirementStatus requirementStatus);

	// This query is used to filter Requirement list according to dates
	@Query(value = "Select * from requirement status where status.open_date >= ?1 and status.open_date <= ?2", nativeQuery = true)
	List<Requirement> findRequirementByDates(LocalDate openDate1, LocalDate openDate2);

}
