package br.com.mnader.rocketseat_desafio1.modules.course.controller.dto;

import br.com.mnader.rocketseat_desafio1.modules.course.models.Course;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateRequest { 

    @NotBlank(message = "O campo [name] é obrigatório.")
    private String name;
    @NotBlank(message = "O campo [category] é obrigatório.")
    private String category;
   
    public Course toEntity() {
        return Course.builder()
                .name(name)
                .category(category)
                .build();
    }
}
