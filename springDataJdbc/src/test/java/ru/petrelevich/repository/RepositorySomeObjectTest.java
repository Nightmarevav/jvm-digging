package ru.petrelevich.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import ru.petrelevich.model.SomeObject;
import ru.petrelevich.repository.base.BasePersistenceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RepositorySomeObjectTest extends BasePersistenceTest {

    @Autowired
    RepositorySomeObject repository;

    @Test
    void saveTestWithNullOrZeroId() {
        var object = new SomeObject(null, "name", "value");

        var savedObject = repository.save(object);
        assertThat(savedObject).isNotNull();
        assertThat(savedObject.getId()).isNotNull();
    }

    @Test
    void saveTestWithNotNullId() {
        var objectId = 1L;
        var object = new SomeObject(objectId, "name", "value");

        assertThatThrownBy(() -> repository.save(object))
                .isInstanceOf(DbActionExecutionException.class)
                .hasMessageContaining("Failed to execute DbAction.UpdateRoot");
    }
}