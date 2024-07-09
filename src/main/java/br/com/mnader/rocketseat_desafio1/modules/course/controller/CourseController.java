package br.com.mnader.rocketseat_desafio1.modules.course.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mnader.rocketseat_desafio1.modules.course.controller.dto.CourseCreateRequest;
import br.com.mnader.rocketseat_desafio1.modules.course.controller.dto.CourseFindResponse;
import br.com.mnader.rocketseat_desafio1.modules.course.controller.dto.CourseResponse;
import br.com.mnader.rocketseat_desafio1.modules.course.controller.dto.CourseUpdateActiveRequest;
import br.com.mnader.rocketseat_desafio1.modules.course.controller.dto.CourseUpdateRequest;
import br.com.mnader.rocketseat_desafio1.modules.course.models.Course;
import br.com.mnader.rocketseat_desafio1.modules.course.useCases.CreateCourseUseCase;
import br.com.mnader.rocketseat_desafio1.modules.course.useCases.DeleteCourseUseCase;
import br.com.mnader.rocketseat_desafio1.modules.course.useCases.FindAllCoursesUseCase;
import br.com.mnader.rocketseat_desafio1.modules.course.useCases.UpdateActiveCourseUseCase;
import br.com.mnader.rocketseat_desafio1.modules.course.useCases.UpdateCourseUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {
    
    @Autowired
    CreateCourseUseCase createCourseUseCase;

    @Autowired
    FindAllCoursesUseCase findAllCoursesUseCase;

    @Autowired
    UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    UpdateActiveCourseUseCase updateActiveCourseUseCase;

    @PostMapping
    public ResponseEntity<CourseResponse> create(
        @Valid @RequestBody CourseCreateRequest courseRequest
    ) {
        Course course = createCourseUseCase.execute(courseRequest.toEntity());
        return new ResponseEntity<>(new CourseResponse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<CourseFindResponse>> findAll(@RequestParam Map<String, String> filterMap, Pageable pageable) {
        Page<Course> courses = findAllCoursesUseCase.execute(filterMap, pageable);
        return new ResponseEntity<>(courses.map(course -> new CourseFindResponse(course)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
        @PathVariable Long id,
        @RequestBody CourseUpdateRequest courseRequest
    ) {
        updateCourseUseCase.execute(courseRequest.toEntity(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteCourseUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/active")
    public ResponseEntity<Void> updateActive(@PathVariable Long id, @RequestBody CourseUpdateActiveRequest courseRequest) {
        updateActiveCourseUseCase.execute(courseRequest.toEntity(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
