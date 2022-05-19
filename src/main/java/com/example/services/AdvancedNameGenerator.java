package com.example.services;

import org.apache.commons.lang3.RandomStringUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class AdvancedNameGenerator extends NameGenerator {
    public String generate() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        return RandomStringUtils.randomAlphabetic(10);
    }
}