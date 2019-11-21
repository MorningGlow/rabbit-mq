package com.luxshare.rabbit.mq.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * person pojo
 * 用于消息实体
 *
 * @author lion hua
 * @since 2019-11-20
 */
@Getter
@Setter
@AllArgsConstructor
public class Person implements Serializable {

    private String name;

    private Integer age;
}
