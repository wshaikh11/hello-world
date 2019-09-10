/**
 * 
 */
package com.afour.recruitment.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import com.afour.recruitment.RecruitmentApplication;
import com.afour.recruitment.controller.RecruitmentController;
import com.afour.recruitment.model.Requirement;
import com.afour.recruitment.model.RequirementStatus;
import com.afour.recruitment.serviceimpl.RecruitmentServiceImpl;

/**
 * @author wasim.s
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RecruitmentController.class, secure = false)
@ContextConfiguration(classes = RecruitmentApplication.class)
public class RecruitmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RecruitmentServiceImpl recruitmentService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	String requirementStatus = "OPEN";

	String reqStatus = "OPEN";

	private String REQ_BODY = "{\"requirementCode\":\"AFT_SDE\",\"experienceInYears\":3.2,\"language\":\"Java\",\"location\":\"Pune\",\"jobDescription\":\"Demo Job Desc\",\"requirementStatus\":\"OPEN\", \"openDate\":\"2019-04-09\"}";

	ResponseEntity<Requirement> saveRequiremntTest() {
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
		return new ResponseEntity<Requirement>(requiremnt, HttpStatus.CREATED);
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

	ResponseEntity<Requirement> openRequirement() {
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
		return new ResponseEntity<Requirement>(requiremnt, HttpStatus.CREATED);
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#saveRequirement(com.afour.recruitment.model.Requirement)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSaveRequirement() throws Exception {
		Mockito.when(recruitmentService.saveRequirement(Mockito.any(Requirement.class)))
				.thenReturn(saveRequiremntTest());

		mockMvc.perform(post("/requirements").contentType(MediaType.APPLICATION_JSON).content(REQ_BODY))
				.andExpect(status().isCreated());

	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#updateRequirement(long, com.afour.recruitment.model.Requirement)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateRequirement() throws Exception {

		Mockito.when(recruitmentService.updateRequirement(Mockito.anyLong(), Mockito.any(Requirement.class)))
				.thenReturn(saveRequiremntTest());

		mockMvc.perform(put("/requirements/1").contentType(MediaType.APPLICATION_JSON_UTF8).content(REQ_BODY))
				.andExpect(status().isCreated());
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#getRequirementById(long)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetRequirementById() throws Exception {
		LocalDate verifyOpenDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(verifyOpenDate);

		Mockito.when(recruitmentService.getRequirementById(1)).thenReturn(saveRequiremntTest());

		mockMvc.perform(get("/requirements/" + 1).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentType(MediaType.valueOf("application/hal+json;charset=UTF-8")))
				.andExpect(jsonPath("$.requirementCode", is("AFT_SDE"))).andExpect(jsonPath("$.language", is("Java")))
				.andExpect(jsonPath("$.location", is("Pune"))).andExpect(jsonPath("$.experienceInYears", is(3.2)))
				.andExpect(jsonPath("$.jobDescription", is("Full Stack Developer")))
				.andExpect(jsonPath("$.requirementStatus", is(requirementStatus)))
				.andExpect(jsonPath("$.openDate", is(verifyOpenDate.toString()))).andExpect(status().isCreated());

	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#getRequirementById(long)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetRequirementById_EntityNotFoundException() throws Exception {

		Mockito.when(recruitmentService.getRequirementById(Mockito.anyLong()))
				.thenThrow(new EntityNotFoundException("Invalid Requirement id"));

		mockMvc.perform(get("/requirements/1").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isNotFound());
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#getAllRequirement()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetAllRequirement() throws Exception {
		LocalDate verifyOpenDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(verifyOpenDate);

		List<Requirement> allRequirements = Arrays.asList(requirement1(), requirement2());
		Mockito.when(recruitmentService.getAllRequirements()).thenReturn(ResponseEntity.ok(allRequirements));

		mockMvc.perform(get("/requirements").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentType(MediaType.valueOf("application/hal+json;charset=UTF-8")))
				.andExpect(jsonPath("$.[0].requirementCode", is("AFT_SDE")))
				.andExpect(jsonPath("$.[0].language", is("Java"))).andExpect(jsonPath("$.[0].location", is("Pune")))
				.andExpect(jsonPath("$.[0].experienceInYears", is(3.2)))
				.andExpect(jsonPath("$.[0].jobDescription", is("Full Stack Developer")))
				.andExpect(jsonPath("$.[0].requirementStatus", is(requirementStatus)))
				.andExpect(jsonPath("$.[0].openDate", is(verifyOpenDate.toString()))).andExpect(status().isOk());
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#getAllRequirement()}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetAllRequirement_ResponseStatusException() throws Exception {
		Mockito.when(recruitmentService.getAllRequirements())
				.thenThrow(new ResponseStatusException(HttpStatus.NO_CONTENT, "No Requirement List exist in Record."));

		mockMvc.perform(get("/requirements").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isNoContent());
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#setRequirementStatus(long, java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetRequirementStatus() throws Exception {
		LocalDate verifyOpenDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(verifyOpenDate);

		Mockito.when(recruitmentService.setRequirementStatus(1l, reqStatus)).thenReturn(openRequirement());

		mockMvc.perform(put("/requirements/1/set-status?status=" + reqStatus))
				// .andExpect(content().contentType(MediaType.valueOf("application/hal+json;charset=UTF-8")))
				.andExpect(jsonPath("$.requirementCode", is("AFT_SDE"))).andExpect(jsonPath("$.language", is("Java")))
				.andExpect(jsonPath("$.location", is("Pune"))).andExpect(jsonPath("$.experienceInYears", is(3.2)))
				.andExpect(jsonPath("$.jobDescription", is("Full Stack Developer")))
				.andExpect(jsonPath("$.requirementStatus", is(requirementStatus)))
				.andExpect(jsonPath("$.openDate", is(verifyOpenDate.toString()))).andExpect(status().isCreated());
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#getRequirementsByStatus(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetRequirementsByStatus() throws Exception {
		LocalDate verifyOpenDate = LocalDate.now();
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(verifyOpenDate);

		List<Requirement> allRequirements = Arrays.asList(requirement1(), requirement2());
		Mockito.when(recruitmentService.getRequirementsByStatus(requirementStatus))
				.thenReturn(ResponseEntity.ok(allRequirements));

		mockMvc.perform(get("/requirements/status/" + "OPEN").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(content().contentType(MediaType.valueOf("application/hal+json;charset=UTF-8")))
				.andExpect(jsonPath("$.[0].requirementCode", is("AFT_SDE")))
				.andExpect(jsonPath("$.[0].language", is("Java"))).andExpect(jsonPath("$.[0].location", is("Pune")))
				.andExpect(jsonPath("$.[0].experienceInYears", is(3.2)))
				.andExpect(jsonPath("$.[0].jobDescription", is("Full Stack Developer")))
				.andExpect(jsonPath("$.[0].requirementStatus", is(requirementStatus)))
				.andExpect(jsonPath("$.[0].openDate", is(verifyOpenDate.toString()))).andExpect(status().isOk());
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#filterByDate(java.time.LocalDate, java.time.LocalDate)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFilterByDate() throws Exception {
		LocalDate verifyOpenDate = LocalDate.now();
		LocalDate startDate = LocalDate.of(2019, 4, 5);
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(verifyOpenDate);

		List<Requirement> allRequirements = Arrays.asList(requirement1(), requirement2());

		Mockito.when(
				recruitmentService.filterRequirementsByDate(Mockito.any(LocalDate.class), Mockito.any(LocalDate.class)))
				.thenReturn(ResponseEntity.ok(allRequirements));

		mockMvc.perform(get("/requirements/filter").contentType(MediaType.APPLICATION_JSON_UTF8).param("startDate",
				startDate.toString()))
				.andExpect(content().contentType(MediaType.valueOf("application/hal+json;charset=UTF-8")))
				.andExpect(jsonPath("$.[0].requirementCode", is("AFT_SDE")))
				.andExpect(jsonPath("$.[0].language", is("Java"))).andExpect(jsonPath("$.[0].location", is("Pune")))
				.andExpect(jsonPath("$.[0].experienceInYears", is(3.2)))
				.andExpect(jsonPath("$.[0].jobDescription", is("Full Stack Developer")))
				.andExpect(jsonPath("$.[0].requirementStatus", is(requirementStatus)))
				.andExpect(jsonPath("$.[0].openDate", is(verifyOpenDate.toString()))).andExpect(status().isOk());
	}

	/**
	 * Test method for
	 * {@link com.afour.recruitment.controller.RecruitmentController#filterByDate(java.time.LocalDate, java.time.LocalDate)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFilterByDate2Values() throws Exception {
		LocalDate verifyOpenDate = LocalDate.now();
		LocalDate startDate = LocalDate.of(2019, 4, 1);
		LocalDate endDate = LocalDate.of(2019, 4, 11);
		DateTimeFormatter.ofPattern("yyyy/MM/dd").format(verifyOpenDate);

		List<Requirement> allRequirements = Arrays.asList(requirement1(), requirement2());

		Mockito.when(
				recruitmentService.filterRequirementsByDate(Mockito.any(LocalDate.class), Mockito.any(LocalDate.class)))
				.thenReturn(ResponseEntity.ok(allRequirements));

		mockMvc.perform(get("/requirements/filter").contentType(MediaType.APPLICATION_JSON_UTF8)
				.param("startDate", startDate.toString()).param("endDate", endDate.toString()))
				.andExpect(content().contentType(MediaType.valueOf("application/hal+json;charset=UTF-8")))
				.andExpect(jsonPath("$.[0].requirementCode", is("AFT_SDE")))
				.andExpect(jsonPath("$.[0].language", is("Java"))).andExpect(jsonPath("$.[0].location", is("Pune")))
				.andExpect(jsonPath("$.[0].experienceInYears", is(3.2)))
				.andExpect(jsonPath("$.[0].jobDescription", is("Full Stack Developer")))
				.andExpect(jsonPath("$.[0].requirementStatus", is(requirementStatus)))
				.andExpect(jsonPath("$.[0].openDate", is(verifyOpenDate.toString()))).andExpect(status().isOk());
	}

	@Test
	public void testGetRequirementById_InvalidId() throws Exception {
		mockMvc.perform(get("/requirements/foo")).andExpect(status().isInternalServerError())
				.andExpect(jsonPath("$.type", is("500 INTERNAL_SERVER_ERROR")))
				.andExpect(jsonPath("$.message", containsString("Failed to convert value of type")));
	}

	@Test
	public void testMethodNotAllowed() throws Exception {
		mockMvc.perform(post("/requirements/foo")).andExpect(status().isMethodNotAllowed())
				.andExpect(jsonPath("$.type", is("405 METHOD_NOT_ALLOWED")))
				.andExpect(jsonPath("$.message", containsString("Request method 'POST' not supported")));
	}

	@Test
	public void testConflict() throws Exception {
		mockMvc.perform(post("/requirements").param("req", "req")).andExpect(status().isConflict())
				.andExpect(jsonPath("$.type", is("409 CONFLICT")))
				.andExpect(jsonPath("$.message", containsString("Required request body is missing")));
	}

	@Test
	public void testJsonException() throws Exception {

		String REQUIREMENT = "{\r\n" + "	\"requirementCode\": \"AFT_SDET\",\r\n" + "    \"requirement,\r\n"
				+ "    \"experience\": \"45\",\r\n" + "    \"\": \"Expert in Java and Angular\",\r\n"
				+ "    \"location\": Pune,\r\n" + "    \"openDate\": \"2019-04-05\",\r\n"
				+ "    \"closedDate\": \"2019-04-06\"\r\n" + "}";

		Mockito.when(recruitmentService.updateRequirement(Mockito.anyLong(), Mockito.any(Requirement.class)))
				.thenThrow(new JsonParseException());

		mockMvc.perform(put("/requirements/1").contentType(MediaType.APPLICATION_JSON_UTF8).content(REQUIREMENT))
				.andExpect(status().isConflict());
	}

	@Test
	public void jsonMappingException() throws Exception {
		mockMvc.perform(get("requirements/status/Opennn").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isNotFound());
	}

}
