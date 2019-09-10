package com.afour.recruitment.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afour.recruitment.model.Requirement;
import com.afour.recruitment.service.RecruitmentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(produces = "application/hal+json")
@CrossOrigin(value = { "*" }, exposedHeaders = { "Content-Disposition" })
public class RecruitmentController {

	@Autowired
	RecruitmentService recruitmentService;

	@PostMapping("/requirements")
	@ApiOperation(value = "Save Requirement")
	public ResponseEntity<Requirement> saveRequirement(@RequestBody Requirement requirement) {
		return recruitmentService.saveRequirement(requirement);
	}

	@PutMapping("/requirements/{requirementId}")
	@ApiOperation(value = "Update Requirement by Id")
	public ResponseEntity<Requirement> updateRequirement(@PathVariable("requirementId") long requirementId,
			@Valid @RequestBody Requirement requirement) {
		return recruitmentService.updateRequirement(requirementId, requirement);
	}

	@GetMapping(value = "/requirements/{requirementId}")
	@ApiOperation(value = "Get Requirement by Id")
	public ResponseEntity<Requirement> getRequirementById(@PathVariable("requirementId") long requirementId) {
		return recruitmentService.getRequirementById(requirementId);
	}

	@GetMapping("/requirements")
	@ApiOperation(value = "Get All Requirements")
	public ResponseEntity<List<Requirement>> getAllRequirement() {
		return recruitmentService.getAllRequirements();
	}

	@PutMapping("/requirements/{requirementId}/set-status")
	@ApiOperation(value = "Set Requirement Status as 'Open' or 'Closed'")
	public ResponseEntity<Requirement> setRequirementStatus(@PathVariable("requirementId") long requirementId,
			@RequestParam(name = "status", required = true) String requirementStatus) {
		return recruitmentService.setRequirementStatus(requirementId, requirementStatus);
	}

	@GetMapping("/requirements/status/{requirement-status}")
	@ApiOperation(value = "Get Requirement List By Status i.e Open or Closed")
	public ResponseEntity<List<Requirement>> getRequirementsByStatus(
			@PathVariable("requirement-status") String requirementStatus) {
		return recruitmentService.getRequirementsByStatus(requirementStatus);
	}

	@GetMapping("/requirements/filter")
	@ApiOperation(value = "Get Filtered Requirements By Date")
	public ResponseEntity<List<Requirement>> filterRequirementsByDate(
			@RequestParam("startDate") @DateTimeFormat(iso = ISO.DATE) LocalDate openDate1,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate openDate2) {

		if (openDate2 == null) {
			LocalDate todayDate = LocalDate.now();
			DateTimeFormatter.ofPattern("yyyy/MM/dd").format(todayDate);
			openDate2 = todayDate;
		}

		return recruitmentService.filterRequirementsByDate(openDate1, openDate2);

	}

}
