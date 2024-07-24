package org.icet.ems.repository;

import org.icet.ems.entity.EmployeeEntity;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {
    Boolean existsByFirstName(String name);

    EmployeeEntity findByFirstName(String name);
}
