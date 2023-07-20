package com.example.removeframeworkfromservice.application;


import com.example.removeframeworkfromservice.domain.Foo;

// 흔하게 사용되는 Service객체의 형태지만, springframework가 결합되어있음.
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
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
