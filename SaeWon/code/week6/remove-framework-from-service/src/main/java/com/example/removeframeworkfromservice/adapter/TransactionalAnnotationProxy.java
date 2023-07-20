package com.example.removeframeworkfromservice.adapter;

import com.example.removeframeworkfromservice.application.FooRepository;
import com.example.removeframeworkfromservice.application.FooService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TransactionalAnnotationProxy extends FooService {
    public TransactionalAnnotationProxy(FooRepository repository) {
        super(repository);
    }
}
