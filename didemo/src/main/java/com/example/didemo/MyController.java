package com.example.didemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    // to get an instance of the class singleton, typically we write
    // SingleTOnBean sone = new SingleTonBean();
    // SingleTOnBean stwo = new SingleTonBean();
    // to get an instance of the class ProtoTypeBean, typically we write
    // ProtoTypeBean pone = new ProtoTypeBean();
    // ProtoTypeBean ptwo = new ProtoTypeBean();

    // Spring framework allows the automatic injection of instances by using
    // @AutoWired annotation
    // initiating a instance of SingleTonBean class
    @Autowired
    private SingleTonBean singleTonBeanOne;
    @Autowired
    private SingleTonBean singleTonBeanTwo;

    // @AutoWired annotation
    // initiating a instance of ProtoTypeBean class
    @Autowired
    private ProtoTypeBean protoTypeBeanOne;
    @Autowired
    private ProtoTypeBean protoTypeBeanTwo;

    @GetMapping("/singletest")
    public void testSingle() {
        singleTonBeanOne.incrementCounter(); // both the instances (beanone and beantwo) are incremented
        System.out.println(singleTonBeanOne.getCounter());
        System.out.println(singleTonBeanTwo.getCounter());
        singleTonBeanTwo.incrementCounter(); // both the instances (beanone and beantwo) are incremented
        System.out.println(singleTonBeanOne.getCounter());
        System.out.println(singleTonBeanTwo.getCounter());
    }

    @GetMapping("/prototest")
    public void testProto() {
        protoTypeBeanOne.incrementCounter();
        System.out.println(protoTypeBeanOne.getCounter());
        System.out.println(protoTypeBeanTwo.getCounter());
        protoTypeBeanTwo.incrementCounter();
        System.out.println(protoTypeBeanOne.getCounter());
        System.out.println(protoTypeBeanTwo.getCounter());
    }

    @GetMapping("compare")
    public void compareInstances() {
        System.out.println("hashcode of first Singleton Bean is " + singleTonBeanOne.hashCode());
        System.out.println("hashcode of second Singleton Bean is " + singleTonBeanTwo.hashCode());

        System.out.println("hashcode of first Prototype Bean is " + protoTypeBeanOne.hashCode());
        System.out.println("hashcode of second Prototype Bean is " + protoTypeBeanTwo.hashCode());
    }
}
