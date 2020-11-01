package ru.petrelevich.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.petrelevich.model.PersistableObject;
import ru.petrelevich.repository.base.BasePersistenceTest;

import static org.assertj.core.api.Assertions.assertThat;

class RepositoryPersistableObjectTest extends BasePersistenceTest {

    @Autowired
    RepositoryPersistableObject repository;

    @Test
    void saveTestWithNullId() {
        var object = new PersistableObject(true, null, "name", "value");

        var savedObject = repository.save(object);
        assertThat(savedObject).isNotNull();
        assertThat(savedObject.getId()).isNotNull();

        var selectedObject = repository.findById(savedObject.getId());
        assertThat(selectedObject).isNotNull();
    }

    @Test
    void saveTestWithNotNullId() {
        var objectId = 10L;
        var object = new PersistableObject(true, objectId, "name", "value");

        var savedObject = repository.save(object);
        assertThat(savedObject).isNotNull();
        assertThat(savedObject.getId()).isNotNull();
        assertThat(savedObject.getId()).isEqualTo(objectId);

        var selectedObject = repository.findById(savedObject.getId());
        assertThat(selectedObject).isNotNull();
    }
}