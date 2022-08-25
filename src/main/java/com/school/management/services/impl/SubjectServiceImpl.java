package com.school.management.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.entity.Subject;
import com.school.management.payload.SubjectDto;
import com.school.management.repository.SubjectRepo;
import com.school.management.services.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepo subjectRepo;

	@Override
	public SubjectDto createSubjectDto(SubjectDto subjectDto) {

		Subject subject = this.convertSubjectDtoToSubject(subjectDto);

		Subject savedSubject = this.subjectRepo.save(subject);

		return this.convertSubjectToSubjectDto(savedSubject);
	}

	@Override
	public SubjectDto updateSubjectDto(SubjectDto subjectDto, Long id) {
		Subject subject = this.subjectRepo.findById(id).get();

		if (subject != null) {
			subject.setName(subjectDto.getName());
			Subject updatedSubject = this.subjectRepo.save(subject);
			return this.convertSubjectToSubjectDto(updatedSubject);
		}
		return null;
	}

	@Override
	public void deleteSubjectDto(Long id) {
		this.subjectRepo.deleteById(id);
	}

	@Override
	public SubjectDto getSubjectDto(Long id) {
		Subject subject = this.subjectRepo.findById(id).get();
		return this.convertSubjectToSubjectDto(subject);
	}

	@Override
	public List<SubjectDto> getAllSubjectDto() {
		List<Subject> subjects = this.subjectRepo.findAll();
		
		List<SubjectDto> subjectDtos = subjects.stream().map((sub) -> this.convertSubjectToSubjectDto(sub))
				.collect(Collectors.toList());

		return subjectDtos;
	}

//	----------------------------------------------------------------------------------------------------------------------------------
//	------------------------------------------------------Helper methods--------------------------------------------------------------

	private Subject convertSubjectDtoToSubject(SubjectDto SubjectDto) {

		Subject subject = new Subject();
		subject.setId(SubjectDto.getId());
		subject.setName(SubjectDto.getName());

		return subject;
	}

	private SubjectDto convertSubjectToSubjectDto(Subject subject) {

		SubjectDto subjectDto = new SubjectDto();
		subjectDto.setId(subject.getId());
		subjectDto.setName(subject.getName());

		return subjectDto;
	}

}
