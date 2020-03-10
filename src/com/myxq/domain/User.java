package com.myxq.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 */
@Getter@Setter
public class User {
   private Long user_id;
   private String user_code;
   private String user_name;
   private String user_password;
   private String user_state;
   /**
    *一个用户选择多个角色
    */
    private Set<Role> roles = new HashSet<>();
}
