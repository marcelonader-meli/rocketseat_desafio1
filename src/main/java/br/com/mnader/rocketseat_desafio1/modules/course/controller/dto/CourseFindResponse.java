package br.com.mnader.rocketseat_desafio1.modules.course.controller.dto;

import java.time.LocalDateTime;

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
public class CourseFindResponse {
    private Long id;
    private String name;
    private String category;
    private Status active;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public CourseFindResponse(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.category = course.getCategory();
        this.active = course.getActive();
        this.created_at = course.getCreated_at();
        this.updated_at = course.getUpdated_at();
    }
}