package com.superdzen;

import org.springframework.beans.factory.BeanFactory;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.instantiate("com.superdzen");

        ProductService productService = (ProductService) beanFactory.getBean("productService");
        System.out.println(productService);
    }
}
