package br.com.mnader.rocketseat_desafio1.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mnader.rocketseat_desafio1.exceptions.CourseNotFoundException;
import br.com.mnader.rocketseat_desafio1.modules.course.repository.CourseRepository;

@Service
public class DeleteCourseUseCase {
    
    @Autowired
    CourseRepository courseRepository;

    public void execute(Long id) {
        courseRepository.findById(id).ifPresentOrElse(
            coursePersisted -> {
                courseRepository.deleteById(id);
            },
            () -> {
                throw new CourseNotFoundException(String.format("Curso de id [%b] não localizado no sistema!", id));
            }
        );
    }
}
