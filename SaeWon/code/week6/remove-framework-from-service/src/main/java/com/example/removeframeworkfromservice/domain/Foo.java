package com.example.removeframeworkfromservice.domain;

import jakarta.persistence.*;

@Entity
public class Foo {

    @Id
    @GeneratedValue
    private Long id;

    private String something;

    public Foo() {
    }

    public Foo(String something) {
        this.something = something;
    }
}
