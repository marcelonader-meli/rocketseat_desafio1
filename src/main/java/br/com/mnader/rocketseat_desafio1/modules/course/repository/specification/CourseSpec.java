package br.com.mnader.rocketseat_desafio1.modules.course.repository.specification;

import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import br.com.mnader.rocketseat_desafio1.modules.course.models.Course;

public class CourseSpec {

    public static final String NAME = "name";
    public static final String CATEGORY = "category";

    private CourseSpec() {}
    
    public static Specification<Course> filterBy(Map<String, String> filterMap) {
        return Specification
                .where(hasName(filterMap.get(NAME)))
                .and(hasCategory(filterMap.get(CATEGORY)));
    }

    private static Specification<Course> hasName(String name) {
        return (
            (root, query, criteriaBuilder) ->
                name == null || name.isEmpty() 
                    ? criteriaBuilder.conjunction()
                    : criteriaBuilder.like(
                        criteriaBuilder.upper(root.get(NAME)),
                        "%"+name.toUpperCase()+"%"
                    )
            );
    }

    private static Specification<Course> hasCategory(String category) {
        return (
            (root, query, criteriaBuilder) ->
                category == null || category.isEmpty() 
                    ? criteriaBuilder.conjunction()
                    : criteriaBuilder.like(
                        criteriaBuilder.upper(
                            root.get(CATEGORY)),
                            "%"+category.toUpperCase()+"%"
                    )
            );
    } 
}
