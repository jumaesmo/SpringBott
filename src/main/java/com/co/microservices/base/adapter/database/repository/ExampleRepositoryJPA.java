package com.co.microservices.base.adapter.database.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.co.microservices.base.adapter.database.model.TestEntity;

public interface ExampleRepositoryJPA extends JpaRepository<TestEntity, Integer> {

}
