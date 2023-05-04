package com.smart.water.conifg;

/**
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/04/21 09:58
 * @Version 0.1
 **/
public class Ds {

    public void reply(Callback callback){
        System.out.println("正在思考问题");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        callback.callback("想出答案");
    }
}
