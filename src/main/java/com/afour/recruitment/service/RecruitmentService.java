package com.afour.recruitment.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;

import com.afour.recruitment.model.Requirement;

public interface RecruitmentService {
	public ResponseEntity<Requirement> saveRequirement(Requirement requirement);

	public ResponseEntity<Requirement> updateRequirement(long requirementId, Requirement requirement);

	public ResponseEntity<Requirement> getRequirementById(long requirementId);

	public ResponseEntity<List<Requirement>> getAllRequirements();

	public ResponseEntity<Requirement> setRequirementStatus(long requirementId, String requirementStatus);

	public ResponseEntity<List<Requirement>> getRequirementsByStatus(String requirementStatus);

	public ResponseEntity<List<Requirement>> filterRequirementsByDate(LocalDate openDate1, LocalDate openDate2);

}
