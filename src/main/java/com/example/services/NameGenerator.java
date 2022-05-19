package com.example.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import org.apache.commons.lang3.RandomStringUtils;

@ApplicationScoped
@Alternative
public class NameGenerator implements Generator {
        public String generate() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return RandomStringUtils.random(10);
        }
}
