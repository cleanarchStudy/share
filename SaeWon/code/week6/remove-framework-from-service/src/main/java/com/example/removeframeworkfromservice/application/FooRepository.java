package com.example.removeframeworkfromservice.application;

import com.example.removeframeworkfromservice.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepository extends JpaRepository<Foo, Long> {
}
