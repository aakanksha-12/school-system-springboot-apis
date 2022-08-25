package com.school.management.services;

import java.util.List;

import com.school.management.payload.SubjectDto;

public interface SubjectService {
	
	SubjectDto createSubjectDto(SubjectDto SubjectDto);

	SubjectDto updateSubjectDto(SubjectDto SubjectDto, Long id);

	void deleteSubjectDto(Long id);

	SubjectDto getSubjectDto(Long id);

	List<SubjectDto> getAllSubjectDto();

}
