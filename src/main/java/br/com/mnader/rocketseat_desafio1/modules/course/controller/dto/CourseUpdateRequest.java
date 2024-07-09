package br.com.mnader.rocketseat_desafio1.modules.course.controller.dto;

import br.com.mnader.rocketseat_desafio1.modules.course.models.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseUpdateRequest { 

    private String name;
    private String category;
   
    public Course toEntity(Long id) {
        return Course.builder()
                .id(id)
                .name(name)
                .category(category)
                .build();
    }
}
