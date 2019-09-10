/**
 * 
 */
package com.afour.recruitment.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.server.ResponseStatusException;

import com.afour.recruitment.model.Requirement;
import com.afour.recruitment.model.RequirementStatus;
import com.afour.recruitment.repository.RequirementRepository;
import com.afour.recruitment.serviceimpl.RecruitmentServiceImpl;

/**
 * @author wasim.s
 *
 */
@RunWith(SpringRunner.class)
public class RecruitmentServiceTest {

	@InjectMocks
	private RecruitmentServiceImpl recruitmentService;

	@MockBean
	private RequirementRepository requirementRepository;

	/**
	 * @throws java.lang.Exception
	 */

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	private String requirementStatusOpen = "OPEN";

	private String requirementStatusClosed = "CLOSED";

	ResponseEntity<Requirement> saveRequiremntTest() {
		Requirement saveRequiremnt = new Requirement();
		saveRequiremnt.setRequirementCode("AFT_SDET");
		saveRequiremnt.setLanguage("Python");
		saveRequiremnt.setExperienceInYears((float) 3.6);
		saveRequiremnt.setJobDescription("Open Stack Developer");
		saveRequiremnt.setLocation("Banglore");
		saveRequiremnt.setRequirementStatus(RequirementStatus.OPEN);
		LocalDate openDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(openDate);
		saveRequiremnt.setOpenDate(openDate);
		return new ResponseEntity<Requirement>(saveRequiremnt, HttpStatus.CREATED);
	}

	Requirement requirement1() {
		Requirement requiremnt = new Requirement();
		requiremnt.setRequirementCode("AFT_SDE");
		requiremnt.setLanguage("Java");
		requiremnt.setExperienceInYears((float) 3.2);
		requiremnt.setJobDescription("Full Stack Developer");
		requiremnt.setLocation("Pune");
		requiremnt.setRequirementStatus(RequirementStatus.OPEN);
		LocalDate openDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(openDate);
		requiremnt.setOpenDate(openDate);
		return requiremnt;
	}

	Requirement requirement2() {
		Requirement requiremnt = new Requirement();
		requiremnt.setRequirementCode("AFT_SDE");
		requiremnt.setLanguage("Java");
		requiremnt.setExperienceInYears((float) 3.2);
		requiremnt.setJobDescription("Full Stack Developer");
		requiremnt.setLocation("Pune");
		requiremnt.setRequirementStatus(RequirementStatus.OPEN);
		LocalDate openDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(openDate);
		requiremnt.setOpenDate(openDate);
		return requiremnt;
	}

	Requirement requirement3() {
		Requirement requiremnt = new Requirement();
		requiremnt.setRequirementCode("AFT_SDE");
		requiremnt.setLanguage("Java");
		requiremnt.setExperienceInYears((float) 3.2);
		requiremnt.setJobDescription("Full Stack Developer");
		requiremnt.setLocation("Pune");
		requiremnt.setRequirementStatus(RequirementStatus.OPEN);
		LocalDate openDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(openDate);
		requiremnt.setOpenDate(openDate);
		return requiremnt;
	}

	Requirement saveRequiremntTest2() {
		Requirement saveRequiremnt = new Requirement();
		saveRequiremnt.setRequirementCode("AFT_SDET");
		saveRequiremnt.setLanguage("Python");
		saveRequiremnt.setExperienceInYears((float) 3.6);
		saveRequiremnt.setJobDescription("Open Stack Developer");
		saveRequiremnt.setLocation("Banglore");
		saveRequiremnt.setRequirementStatus(RequirementStatus.OPEN);
		LocalDate openDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(openDate);
		saveRequiremnt.setOpenDate(openDate);
		return saveRequiremnt;
	}

	Requirement requirement4() {
		Requirement requiremnt = new Requirement();
		requiremnt.setRequirementCode("AFT_SDE");
		requiremnt.setLanguage("Java");
		requiremnt.setExperienceInYears((float) 3.2);
		requiremnt.setJobDescription("Full Stack Developer");
		requiremnt.setLocation("Pune");
		requiremnt.setRequirementStatus(RequirementStatus.OPEN);
		LocalDate openDate1 = LocalDate.of(2019, 04, 6);
		requiremnt.setOpenDate(openDate1);
		return requiremnt;
	}

	Requirement requirement5() {
		Requirement requiremnt = new Requirement();
		requiremnt.setRequirementCode("AFT_SDE");
		requiremnt.setLanguage("Java");
		requiremnt.setExperienceInYears((float) 3.2);
		requiremnt.setJobDescription("Full Stack Developer");
		requiremnt.setLocation("Pune");
		requiremnt.setRequirementStatus(RequirementStatus.OPEN);
		LocalDate openDate2 = LocalDate.of(2019, 05, 6);
		requiremnt.setOpenDate(openDate2);
		return requiremnt;
	}

	Requirement requirement6() {
		Requirement requiremnt = new Requirement();
		requiremnt.setRequirementCode("AFT_SDE");
		requiremnt.setLanguage("Java");
		requiremnt.setExperienceInYears((float) 3.2);
		requiremnt.setJobDescription("Full Stack Developer");
		requiremnt.setLocation("Pune");
		requiremnt.setRequirementStatus(RequirementStatus.OPEN);
		LocalDate openDate2 = LocalDate.of(2019, 06, 6);
		requiremnt.setOpenDate(openDate2);
		return requiremnt;
	}

	Requirement requirement7() {
		Requirement requiremnt = new Requirement();
		requiremnt.setRequirementCode("AFT_SDE");
		requiremnt.setLanguage("Java");
		requiremnt.setExperienceInYears((float) 3.2);
		requiremnt.setJobDescription("Full Stack Developer");
		requiremnt.setLocation("Pune");
		requiremnt.setRequirementStatus(RequirementStatus.CLOSED);
		LocalDate openDate2 = LocalDate.of(2019, 07, 6);
		requiremnt.setOpenDate(openDate2);
		LocalDate closedDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(closedDate);
		requiremnt.setClosedDate(closedDate);
		return requiremnt;
	}
	

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#saveRequirement(com.afour.recruitment.model.Requirement)}.
	 */
	@Test
	public void testSaveRequirement() {

		Mockito.when(requirementRepository.save(Mockito.any(Requirement.class))).thenReturn(saveRequiremntTest2());

		ResponseEntity<Requirement> actualRequirement = recruitmentService.saveRequirement(saveRequiremntTest2());

		assertThat(actualRequirement, notNullValue());
		assertThat(actualRequirement, equalTo(saveRequiremntTest()));
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#getAllRequirements()}.
	 */
	@Test
	public void testGetAllRequirements() {

		Mockito.when(requirementRepository.findAll())
				.thenReturn(Arrays.asList(requirement1(), requirement2(), requirement3()));

		ResponseEntity<List<Requirement>> actualRequirement = recruitmentService.getAllRequirements();

		assertThat(actualRequirement, notNullValue());
		assertThat(actualRequirement.getBody().get(0), is(requirement1()));
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#getAllRequirements()}.
	 */
	@Test(expected = ResponseStatusException.class)
	public void testGetAllRequirements_forEmptyList() {

		List<Requirement> emptyRequirementList = new ArrayList<Requirement>();

		Mockito.when(requirementRepository.findAll()).thenReturn(emptyRequirementList);

		recruitmentService.getAllRequirements();

	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#updateRequirement(long, com.afour.recruitment.model.Requirement)}.
	 */
	@Test
	public void testUpdateRequirement() {

		Mockito.when(requirementRepository.findById((Mockito.anyLong()))).thenReturn(Optional.of(requirement1()));
		Mockito.when(requirementRepository.save(Mockito.any(Requirement.class))).thenReturn(requirement1());

		ResponseEntity<Requirement> requirement = recruitmentService.updateRequirement(1L, requirement1());
		assertNotNull(requirement);
		assertEquals(requirement.getBody(), requirement1());
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#updateRequirement(long, com.afour.recruitment.model.Requirement)}.
	 */
	@Test(expected = EntityNotFoundException.class)
	public void testUpdateRequirement_forNullId() {

		Mockito.when(requirementRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(null));
		recruitmentService.updateRequirement(1l, Mockito.any(Requirement.class));
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#getRequirementById(long)}.
	 */
	@Test
	public void testGetRequirementById() {
		Mockito.when(requirementRepository.findById((Mockito.anyLong()))).thenReturn(Optional.of(requirement1()));
		Mockito.when(requirementRepository.save(Mockito.any(Requirement.class))).thenReturn(requirement1());

		ResponseEntity<Requirement> actualRequirement = recruitmentService.getRequirementById(Mockito.anyLong());

		assertThat(actualRequirement.getBody(), notNullValue());
		assertThat(actualRequirement.getBody(), is(requirement1()));
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#getRequirementById(long)}.
	 */
	@Test(expected = EntityNotFoundException.class)
	public void testGetRequirementById_WhenNotFound() {
		Mockito.when(requirementRepository.findById((Mockito.anyLong()))).thenReturn(Optional.ofNullable(null));
		recruitmentService.getRequirementById(1l);
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#setRequirementStatus(long, java.lang.String)}.
	 * @throws MissingServletRequestPartException 
	 */
	@Test
	public void testSetRequirementStatusForOpen() throws MissingServletRequestPartException {
		Mockito.when(requirementRepository.findById((Mockito.anyLong()))).thenReturn(Optional.of(requirement1()));
		Mockito.when(requirementRepository.save(Mockito.any(Requirement.class))).thenReturn(requirement1());

		ResponseEntity<Requirement> actualRequirement = recruitmentService.setRequirementStatus(1l,
				requirementStatusOpen);

		assertThat(actualRequirement.getBody(), notNullValue());
		assertThat(actualRequirement.getBody(), is(requirement1()));
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#setRequirementStatus(long, java.lang.String)}.
	 * @throws MissingServletRequestPartException 
	 */
	@Test
	public void testSetRequirementStatusForClosed() throws MissingServletRequestPartException {
		Mockito.when(requirementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(requirement7()));
		Mockito.when(requirementRepository.save(Mockito.any(Requirement.class))).thenReturn(requirement7());

		ResponseEntity<Requirement> actualRequirement = recruitmentService.setRequirementStatus(1l,
				requirementStatusClosed);

		assertThat(actualRequirement.getBody(), notNullValue());
		assertThat(actualRequirement.getBody(), is(requirement7()));
		
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#setRequirementStatus(long, java.lang.String)}.
	 * @throws MissingServletRequestPartException 
	 */
	@Test(expected = EntityNotFoundException.class)
	public void testSetRequirementStatus_InvalidStauts() throws MissingServletRequestPartException {
		Mockito.when(requirementRepository.findById((Mockito.anyLong()))).thenReturn(Optional.ofNullable(null));
		Mockito.when(requirementRepository.save(Mockito.any(Requirement.class))).thenReturn(requirement1());

		recruitmentService.setRequirementStatus(1l, "InvalidStatus");

	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#getRequirementByStatus(java.lang.String)}.
	 */
	@Test
	public void testGetRequirementByStatus() {
		List<Requirement> requirements = new ArrayList<Requirement>();
		requirements.add(requirement1());
		requirements.add(requirement2());

		Mockito.when(requirementRepository.findByRequirementStatus(RequirementStatus.valueOf(requirementStatusOpen)))
				.thenReturn(requirements);
		Mockito.when(requirementRepository.save(Mockito.any(Requirement.class))).thenReturn(requirement1());

		ResponseEntity<List<Requirement>> actualRequirement = recruitmentService
				.getRequirementsByStatus(requirementStatusOpen);
		assertThat(actualRequirement, notNullValue());
		assertThat(actualRequirement.getBody().get(0), is(requirement1()));
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#getRequirementByStatus(java.lang.String)}.
	 */
	@Test(expected = EntityNotFoundException.class)
	public void testGetRequirementByStatus_EmptyList() {
		List<Requirement> emptyRequirementList = new ArrayList<Requirement>();

		Mockito.when(requirementRepository.findByRequirementStatus(RequirementStatus.valueOf(requirementStatusOpen)))
				.thenReturn(emptyRequirementList);

		recruitmentService.getRequirementsByStatus(requirementStatusOpen);
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#filterRequirementByDate(java.time.LocalDate, java.time.LocalDate)}.
	 */
	@Test
	public void testFilterRequirementByDate() {
		LocalDate openDate1 = LocalDate.of(2019, 04, 6);

		LocalDate openDate2 = LocalDate.of(2019, 06, 6);
		List<Requirement> requirements = new ArrayList<Requirement>();

		if ((requirement4().getOpenDate().compareTo(openDate1) > 0
				|| requirement4().getOpenDate().compareTo(openDate1) == 0)
				&& (requirement4().getOpenDate().compareTo(openDate2) < 0
						|| requirement4().getOpenDate().compareTo(openDate2) == 0)) {
			requirements.add(requirement4());
		}

		if ((requirement5().getOpenDate().compareTo(openDate1) > 0
				|| requirement5().getOpenDate().compareTo(openDate1) == 0)
				&& (requirement5().getOpenDate().compareTo(openDate2) < 0
						|| requirement5().getOpenDate().compareTo(openDate2) == 0)) {
			requirements.add(requirement5());
		}

		if ((requirement6().getOpenDate().compareTo(openDate1) > 0
				|| requirement6().getOpenDate().compareTo(openDate1) == 0)
				&& (requirement6().getOpenDate().compareTo(openDate2) < 0
						|| requirement6().getOpenDate().compareTo(openDate2) == 0)) {
			requirements.add(requirement6());
		}

		if ((requirement7().getOpenDate().compareTo(openDate1) > 0
				|| requirement7().getOpenDate().compareTo(openDate1) == 0)
				&& (requirement7().getOpenDate().compareTo(openDate2) < 0
						|| requirement7().getOpenDate().compareTo(openDate2) == 0)) {
			requirements.add(requirement7());
		}

		int size = requirements.size();

		Mockito.when(requirementRepository.findRequirementByDates(openDate1, openDate2)).thenReturn(requirements);

		ResponseEntity<List<Requirement>> actualRequirement = recruitmentService.filterRequirementsByDate(openDate1,
				openDate2);
		assertThat(actualRequirement, notNullValue());
		assertEquals(3, size);

	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.serviceimpl.RecruitmentServiceImpl#filterRequirementByDate(java.time.LocalDate, java.time.LocalDate)}.
	 */
	@Test(expected = EntityNotFoundException.class)
	public void testFilterRequirementByDate_forEmptyList() {
		LocalDate openDate1 = LocalDate.of(2019, 04, 6);

		LocalDate openDate2 = LocalDate.of(2019, 06, 6);
		List<Requirement> emptyrequirementList = new ArrayList<Requirement>();

		Mockito.when(requirementRepository.findRequirementByDates(openDate1, openDate2))
				.thenReturn(emptyrequirementList);

		recruitmentService.filterRequirementsByDate(openDate1, openDate2);

	}

}
