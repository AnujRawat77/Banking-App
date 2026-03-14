package com.project.BankingApp.basictests.ApiTests.annotations;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Method;

public class AnnotationRetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          java.lang.reflect.Constructor testConstructor,
                          Method testMethod) {

        annotation.setRetryAnalyzer(AnnotationRetryAnalyzer.class);
    }
}
