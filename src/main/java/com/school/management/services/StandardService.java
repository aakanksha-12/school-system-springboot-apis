package com.school.management.services;

import java.util.List;

import com.school.management.payload.StandardDto;

public interface StandardService {
	
	StandardDto createStandardDto(StandardDto StandardDto);
	
	StandardDto updateStandardDto(StandardDto StandardDto,Long id);
	
	void deleteStandardDto(Long id);
	
	StandardDto getStandardDto(Long id);
	
	List<StandardDto> getAllStandardDto();
	
	StandardDto assignNewClassTeacherForStandardDto(Long stdId, Integer teachId);
	
	StandardDto getStandardOfStudent(Integer id);
	
}
