/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-27 PM 2:36
 */

package com.example.aop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogArguments {
    //  내용은 없어도 된다.
}
