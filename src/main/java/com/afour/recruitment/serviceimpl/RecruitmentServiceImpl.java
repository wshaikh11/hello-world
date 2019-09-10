package com.afour.recruitment.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.afour.recruitment.model.Requirement;
import com.afour.recruitment.model.RequirementStatus;
import com.afour.recruitment.repository.RequirementRepository;
import com.afour.recruitment.service.RecruitmentService;
import com.afour.recruitment.utils.Constants;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

	@Autowired
	RequirementRepository requirementRepository;

	// Method to save Requirement
	@Override
	public ResponseEntity<Requirement> saveRequirement(Requirement requirement) {
		Requirement saveRequirement = new Requirement();
		saveRequirement.setRequirementCode(requirement.getRequirementCode());
		saveRequirement.setLanguage(requirement.getLanguage());
		saveRequirement.setExperienceInYears(requirement.getExperienceInYears());
		saveRequirement.setJobDescription(requirement.getJobDescription());
		saveRequirement.setLocation(requirement.getLocation());
		saveRequirement.setRequirementStatus(RequirementStatus.OPEN);

		// Will get Current Date when Requirement is in Open State in "yyyy-mm-dd"
		// format
		LocalDate openDate = LocalDate.now();
		DateTimeFormatter.ofPattern(Constants.DATEPATTERN).format(openDate);

		saveRequirement.setOpenDate(openDate);

		// Save Requirement in Database
		requirementRepository.save(saveRequirement);
		return new ResponseEntity<>(saveRequirement, HttpStatus.CREATED);
	}

	// Method to get list of Add Requirements

	@Override
	public ResponseEntity<List<Requirement>> getAllRequirements() {

		// Will get All Requirement that is present in Database
		List<Requirement> requirements = requirementRepository.findAll();

		if (requirements.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Requirement List exist in Record.");
		}
		return new ResponseEntity<>(requirements, HttpStatus.OK);
	}

	// Method to update Requirement by ID
	@Override
	public ResponseEntity<Requirement> updateRequirement(long requirementId, Requirement requirement) {

		// Will get the requirement from database according to ID
		Optional<Requirement> optionalRequirementId = requirementRepository.findById(requirementId);

		if (!optionalRequirementId.isPresent()) {
			throw new EntityNotFoundException("Invalid Requirement id : " + requirementId);
		}

		Requirement updateRequirement = optionalRequirementId.get();
		updateRequirement.setRequirementCode(requirement.getRequirementCode());
		updateRequirement.setLanguage(requirement.getLanguage());
		updateRequirement.setExperienceInYears(requirement.getExperienceInYears());
		updateRequirement.setJobDescription(requirement.getJobDescription());
		updateRequirement.setLocation(requirement.getLocation());
		requirementRepository.save(updateRequirement);
		return new ResponseEntity<>(updateRequirement, HttpStatus.OK);
	}

	// Method to get Requirement by ID
	@Override
	public ResponseEntity<Requirement> getRequirementById(long requirementId) {

		
		// Will get the requirement from database according to ID
		Optional<Requirement> requirementById = requirementRepository.findById(requirementId);

		if (!requirementById.isPresent()) {
			throw new EntityNotFoundException("Requirement not found for : " + requirementId);
		}
		
		return new ResponseEntity<>(requirementById.get(), HttpStatus.OK);

	}

	// Method to set Requirement Status i.e Open or Closed
	@Override
	public ResponseEntity<Requirement> setRequirementStatus(long requirementId, String requirementStatus) {

		// Will get the requirement from database according to ID
		Optional<Requirement> optionalRequirement = requirementRepository.findById(requirementId);

		if (!optionalRequirement.isPresent()) {
			throw new EntityNotFoundException("Invalid Requirement id : " + requirementId);
		}

		Requirement setStatusForRequirement = optionalRequirement.get();

		// Will set the Requirement Status to Open or Closed
		if (RequirementStatus.OPEN.toString().equalsIgnoreCase(requirementStatus)) {
			setStatusForRequirement.setRequirementStatus(RequirementStatus.OPEN);

			// When Requirement Status is Set to Open State then Open Date will be set to
			// Current Date
			LocalDate openDate = LocalDate.now();
			DateTimeFormatter.ofPattern(Constants.DATEPATTERN).format(openDate);
			setStatusForRequirement.setOpenDate(openDate);
		} else if (RequirementStatus.CLOSED.toString().equalsIgnoreCase(requirementStatus)) {
			setStatusForRequirement.setRequirementStatus(RequirementStatus.CLOSED);

			// When Requirement Status is Set to Closed State then Closed Date will be set
			// to Current Date
			LocalDate closedDate = LocalDate.now();
			DateTimeFormatter.ofPattern(Constants.DATEPATTERN).format(closedDate);
			setStatusForRequirement.setClosedDate(closedDate);
		}

		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong parameter 'status' in request");
		}
		requirementRepository.save(setStatusForRequirement);

		return new ResponseEntity<>(setStatusForRequirement, HttpStatus.OK);

	}

	// Method to get Requirement by Status(Open or Closed)
	@Override
	public ResponseEntity<List<Requirement>> getRequirementsByStatus(String requirementStatus) {

		// Will get List of requirement according to Requirement Status i.e Open or
		// Closed
		List<Requirement> requirements = requirementRepository
				.findByRequirementStatus(RequirementStatus.valueOf(requirementStatus));

		if (requirements.isEmpty()) {
			throw new EntityNotFoundException("Requirement List empty");
		}

		return new ResponseEntity<>(requirements, HttpStatus.OK);
	}

	// Filter Requirement according to date,if Open Date2 is null, it will take
	// Current Date
	@Override
	public ResponseEntity<List<Requirement>> filterRequirementsByDate(LocalDate openDate1, LocalDate openDate2) {

		// Will filter the Requirement List according to Dates provided
		List<Requirement> requirementListByFilter = requirementRepository.findRequirementByDates(openDate1, openDate2);
		if (requirementListByFilter.isEmpty()) {
			throw new EntityNotFoundException("Requirement List for Date filter empty");
		}

		return new ResponseEntity<>(requirementListByFilter, HttpStatus.OK);
	}

}
