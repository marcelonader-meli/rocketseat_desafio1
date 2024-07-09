package br.com.mnader.rocketseat_desafio1.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mnader.rocketseat_desafio1.exceptions.CourseNotFoundException;
import br.com.mnader.rocketseat_desafio1.modules.course.models.Course;
import br.com.mnader.rocketseat_desafio1.modules.course.repository.CourseRepository;

@Service
public class UpdateCourseUseCase {
    
    @Autowired
    CourseRepository courseRepository;

    public void execute(Course course) {
        courseRepository.findById(course.getId()).ifPresentOrElse(
            coursePersisted -> {
                if (course.getName() != null || course.getName().isEmpty()) {
                    coursePersisted.setName(course.getName());
                }
                if (course.getCategory() != null || course.getCategory().isEmpty()) {
                    coursePersisted.setCategory(course.getCategory());
                }
                courseRepository.save(coursePersisted);
            },
            () -> {
                throw new CourseNotFoundException(String.format("Curso de id [%o] não localizado no sistema!", course.getId()));
            }
        );
    };
}
