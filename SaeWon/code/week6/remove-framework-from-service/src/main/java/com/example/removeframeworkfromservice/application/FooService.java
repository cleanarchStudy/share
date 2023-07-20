package com.example.removeframeworkfromservice.application;


import com.example.removeframeworkfromservice.domain.Foo;

// Trasactional annotation을 프록시에 적용하더라도, 참조하고있는 부모객체에 Transactional이 없으면 트랜잭션이 전파되지 않아 Transaction제거가 불가능
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class FooService {

    private final FooRepository repository;

    public FooService(FooRepository repository) {
        this.repository = repository;
    }

    public void foo(String command){
        Foo test1 = new Foo("test1");
        Foo test2 = new Foo("test2");

        repository.save(test1);

        if(command.equals("throw")) throw new RuntimeException();

        repository.save(test2);

    }
}
