package com.github.abrasha.depgrep.persistence;

import com.github.abrasha.depgrep.core.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Andrii Abramov on 3/11/17.
 */
@NoRepositoryBean
public interface EntityRepository<T extends BaseEntity> extends CrudRepository<T, Long> {
}
