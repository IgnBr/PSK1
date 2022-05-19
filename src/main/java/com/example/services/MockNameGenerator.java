package com.example.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class MockNameGenerator implements Generator {
    public String generate() {
        return "NAME";
    }
}
