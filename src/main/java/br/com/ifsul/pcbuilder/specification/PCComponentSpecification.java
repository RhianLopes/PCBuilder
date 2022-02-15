package br.com.ifsul.pcbuilder.specification;

import br.com.ifsul.pcbuilder.model.Category;
import br.com.ifsul.pcbuilder.model.PCComponent;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class PCComponentSpecification {

    private static final String PERCENTAGE_OPERATOR = "%";

    public static Specification<PCComponent> getPCComponentsBySpecification(String brand, String model, String category) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(brand)) {
                predicates.add(criteriaBuilder.like(root.get("brand"), concatOperator(brand)));
            }
            if (StringUtils.isNotBlank(model)) {
                predicates.add(criteriaBuilder.like(root.get("model"), concatOperator(model)));
            }
            if (StringUtils.isNotBlank(category)) {
                predicates.add(criteriaBuilder.equal(root.get("category"), Category.valueOf(category)));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private static String concatOperator(String value) {
        return PERCENTAGE_OPERATOR + value + PERCENTAGE_OPERATOR;
    }
}
