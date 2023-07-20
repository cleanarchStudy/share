package com.example.removeframeworkfromservice.adapter;

import com.example.removeframeworkfromservice.application.FooRepository;
import com.example.removeframeworkfromservice.application.FooService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

// 직접적으로 PlatformTransactionManager를 사용하니 Transaction이 보장되었음.
// 정확한 이유 확인중.
@Service
public class PlatformTransactionManagerServiceProxy extends FooService {

    private final PlatformTransactionManager manager;

    public PlatformTransactionManagerServiceProxy(FooRepository repository, PlatformTransactionManager manager) {
        super(repository);
        this.manager = manager;
    }

    @Override
    public void foo(String command) {
        TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition());
        try{
            super.foo(command);
            manager.commit(status);
        } catch(Exception e) {
            manager.rollback(status);
        }
    }
}
