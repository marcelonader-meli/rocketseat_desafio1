package br.com.mnader.rocketseat_desafio1.modules.course.useCases;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.mnader.rocketseat_desafio1.modules.course.models.Course;
import br.com.mnader.rocketseat_desafio1.modules.course.repository.CourseRepository;
import br.com.mnader.rocketseat_desafio1.modules.course.repository.specification.CourseSpec;

@Service
public class FindAllCoursesUseCase {
    
    @Autowired
    CourseRepository courseRepository;

    public Page<Course> execute(Map<String, String> filterMap, Pageable pageable) {
        Specification<Course> courseSpecification = CourseSpec.filterBy(filterMap);
        return courseRepository.findAll(courseSpecification, pageable);
    }
}
