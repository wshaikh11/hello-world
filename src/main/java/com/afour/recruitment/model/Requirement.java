package com.afour.recruitment.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@ApiModel(description = "All details about the Requirement.")
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Requirement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "This is Database Auto-Generated RequirementID")
	@Column(name = "_id")
	private long requirementId;

	@ApiModelProperty(notes = "This is Requirement Code", required = true)
	@NotNull(message = "Requirement Code must not be empty")
	private String requirementCode;

	@ApiModelProperty(notes = "This is Language/Skills of candidate", required = true)
	@NotNull(message = "Language must not be empty")
	private String language;

	@ApiModelProperty(notes = "This is Location for Requirement", required = true)
	@NotNull(message = "Location must not be empty")
	private String location;

	@ApiModelProperty(notes = "This is Job-Experience of candidate", required = true)
	@NotNull(message = "Experience must not be empty")
	private float experienceInYears;

	@ApiModelProperty(notes = "This is Job-Description of candidate", required = true)
	@Column(columnDefinition = "TEXT")
	@NotNull(message = "Job Description must not be empty")
	private String jobDescription;

	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes = "This is Status of Requirement", required = true)
	// @NotNull(message = "Requirement Status must not be empty")
	private RequirementStatus requirementStatus;

	private LocalDate openDate;

	private LocalDate closedDate;

}
