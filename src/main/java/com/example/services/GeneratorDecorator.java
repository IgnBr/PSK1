package com.example.services;

import com.example.entities.University;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class GeneratorDecorator implements Generator {

    @Inject
    @Delegate
    @Any
    Generator generator;

    public String generate() {
        String name = generator.generate();
        name = name + "_PSK";

        return name;
    }
}