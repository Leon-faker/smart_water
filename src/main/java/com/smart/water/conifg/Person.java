package com.smart.water.conifg;

/**
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/04/21 09:56
 * @Version 0.1
 **/
public class Person implements Callback{
    private Ds ds;

    public Person(Ds ds){
        this.ds = ds;
    }
    @Override
    public void callback(String answer) {
        System.out.println("答案:"+answer);
    }

    public void ask(){
        System.out.println("提出问题");
        ds.reply(this);
    }
}
