package br.com.mnader.rocketseat_desafio1.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mnader.rocketseat_desafio1.exceptions.CourseAlreadyExistsException;
import br.com.mnader.rocketseat_desafio1.modules.course.enums.Status;
import br.com.mnader.rocketseat_desafio1.modules.course.models.Course;
import br.com.mnader.rocketseat_desafio1.modules.course.repository.CourseRepository;

@Service
public class CreateCourseUseCase {
    
    @Autowired
    CourseRepository courseRepository;

    public Course execute(Course course) {
        courseRepository.findByName(course.getName()).ifPresent(
            coursePersisted -> {
                throw new CourseAlreadyExistsException(String.format("Curso [%s] já cadastrado no sistema!", course.getName()));
            }
        ); 
        course.setActive(Status.ACTIVE);
        return courseRepository.save(course);
    }
}
