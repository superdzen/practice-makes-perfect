package com.superdzen.aopdemo;

import com.superdzen.aopdemo.config.DemoConfig;
import com.superdzen.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) throws InterruptedException {
        //read Spring config Java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from Spring context
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business method
        accountDAO.addAccount();
        System.out.println("\n let's call it again");
        accountDAO.addAccount();

        Thread.sleep(100);
        // close the context
        context.close();

    }
}
