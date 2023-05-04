package com.smart.water.conifg;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * 用户上下文对象
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/04/06 11:03
 * @Version 0.1
 **/
public class UserContext {
    private static final ThreadLocal<SecurityUser> SESSION_USER = new ThreadLocal<>();

    public static SecurityUser currentUser(){
        return SESSION_USER.get();
    }

    public static SecurityUser setCurrentUser(SecurityUser userDto){
        if(SESSION_USER.get()== null) {
            SESSION_USER.set(userDto);
        }
        return userDto;
    }

    public static void clear(){
        if(SESSION_USER.get()!=null) {
            SESSION_USER.remove();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Ds ds = new Ds();
//        Person person = new Person(ds);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                person.ask();
//            }
//        }).start();
//
//        System.out.println("主程序继续执行");

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//            try {
//                System.out.println("子线程:"+Thread.currentThread().getName());
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "success";
//        });
//        completableFuture.thenAccept(r-> System.out.println(r));
//        System.out.println(completableFuture.get());
//        System.out.println("主线程:"+Thread.currentThread().getName());
        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(100);
        Integer sum =  list.stream().mapToInt(Integer::intValue).sum() * 10000;
        System.out.println(new BigDecimal(sum).divide(new BigDecimal(100000000)).setScale(3,BigDecimal.ROUND_HALF_UP));
    }
}
