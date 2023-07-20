package com.example.removeframeworkfromservice.application;


import com.example.removeframeworkfromservice.domain.Foo;

// framework 제거 완료.

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
