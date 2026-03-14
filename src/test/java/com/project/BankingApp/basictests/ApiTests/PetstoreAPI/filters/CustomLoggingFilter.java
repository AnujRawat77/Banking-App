package com.project.BankingApp.basictests.ApiTests.PetstoreAPI.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class CustomLoggingFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext filterContext) {

        // ✅ Execute the request and capture response
        Response response = filterContext.next(requestSpec, responseSpec);

        // ✅ Log Request Details
        System.out.println("========== REQUEST ==========");
        System.out.println("Method  : " + requestSpec.getMethod());
        System.out.println("URI     : " + requestSpec.getURI());
        System.out.println("Headers : " + requestSpec.getHeaders());
        System.out.println("Body    : " + requestSpec.getBody());

        // ✅ Log Response Details
        System.out.println("========== RESPONSE ==========");
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Headers     : " + response.getHeaders());
        System.out.println("Body        : " + response.getBody().asPrettyString());
        System.out.println("==============================\n");

        return response;
    }
}