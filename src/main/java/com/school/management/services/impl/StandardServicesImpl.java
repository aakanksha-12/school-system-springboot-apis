package com.school.management.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.entity.Standard;
import com.school.management.entity.Student;
import com.school.management.entity.Teacher;
import com.school.management.payload.StandardDto;
import com.school.management.repository.StandardRepo;
import com.school.management.repository.StudentRepo;
import com.school.management.repository.TeacherRepo;
import com.school.management.services.StandardService;

@Service
public class StandardServicesImpl implements StandardService {

	@Autowired
	private StandardRepo standardRepo;
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StandardDto createStandardDto(StandardDto standardDto) {

		//Standard standard = this.convertStandardDtoToStandard(standardDto);
		Standard standard = this.modelMapper.map(standardDto, Standard.class);
		Standard savedStandard = this.standardRepo.save(standard);
		return this.modelMapper.map(savedStandard, StandardDto.class);
	}

	@Override
	public StandardDto updateStandardDto(StandardDto standardDto, Long id) {
		Standard standard2 = this.standardRepo.findById(id).get();
		if (standard2 != null) {

			standard2.setName(standardDto.getName());
			standard2.setClassTeacher(standardDto.getClassTeacher());

			Standard updateStandard = this.standardRepo.save(standard2);
			
			return this.modelMapper.map(updateStandard, StandardDto.class);
		}
		return null;
	}

	@Override
	public void deleteStandardDto(Long id) {
		this.standardRepo.deleteById(id);

	}

	@Override
	public StandardDto getStandardDto(Long id) {
		Standard getStandard = this.standardRepo.findById(id).get();
		return this.modelMapper.map(getStandard,StandardDto.class);
	}

	@Override
	public List<StandardDto> getAllStandardDto() {
		List<Standard> standard = this.standardRepo.findAll();
		List<StandardDto> standardDtos = standard.stream().map((stand) -> this.modelMapper.map(stand,StandardDto.class))
				.collect(Collectors.toList());
		return standardDtos;
	}

//	private Standard convertStandardDtoToStandard(StandardDto standardDto) {
//
//		Standard standard = new Standard();
//		
//		standard.setId(standardDto.getId());
//		standard.setName(standardDto.getName());
//		standard.setClassTeacher(standardDto.getClassTeacher());
//
//		return standard;
//	}
//
//	private StandardDto convertStandardToStandardDto(Standard standard) {
//
//		StandardDto standardDto = new StandardDto();
//		
//		standardDto.setId(standard.getId());
//		standardDto.setName(standard.getName());
//		standardDto.setClassTeacher(standard.getClassTeacher());
//
//		return standardDto;
//	}

	@Override
	public StandardDto assignNewClassTeacherForStandardDto(Long stdId, Integer teachId) {
		
		Standard standard = this.standardRepo.findById(stdId).get();
		Teacher teacher = this.teacherRepo.findById(teachId).get();
		
		standard.setClassTeacher(teacher);
		Standard updatedStandard = this.standardRepo.save(standard);
		
		return this.modelMapper.map(updatedStandard, StandardDto.class);
	}

	@Override
	public StandardDto getStandardOfStudent(Integer id) {
		
		Student student = this.studentRepo.findById(id).get();
		
		Standard findByStudents = this.standardRepo.findByStudents(student);
		
		return this.modelMapper.map(findByStudents, StandardDto.class);
	}
}
