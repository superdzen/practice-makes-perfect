package com.superdzen;

import org.springframework.beans.factory.BeanFactory;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.instantiate("com.superdzen");
        beanFactory.populateProperties();
        ProductService productService = (ProductService) beanFactory.getBean("productService");
        if (productService.getPromotionService() != null) {
            System.out.println("Bean promotionService autowired: " + productService.getPromotionService());
        }
        System.out.println(productService);
    }
}
