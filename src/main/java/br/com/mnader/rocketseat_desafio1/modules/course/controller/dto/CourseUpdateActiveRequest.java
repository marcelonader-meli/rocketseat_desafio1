package br.com.mnader.rocketseat_desafio1.modules.course.controller.dto;

import br.com.mnader.rocketseat_desafio1.modules.course.enums.Status;
import br.com.mnader.rocketseat_desafio1.modules.course.models.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseUpdateActiveRequest { 

    private Status active;
   
    public Course toEntity(Long id) {
        return Course.builder()
                .id(id)
                .active(active)
                .build();
    }
}
