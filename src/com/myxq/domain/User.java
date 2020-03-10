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

   public User() {
   }
   public User(String user_code,String user_name){
      this.user_code = user_code;
      this.user_name = user_name;
   }

   @Override
   public String toString() {
      return "User{" +
              "user_id=" + user_id +
              ", user_code='" + user_code + '\'' +
              ", user_name='" + user_name + '\'' +
              ", user_password='" + user_password + '\'' +
              ", user_state='" + user_state + '\'' +
              ", roles=" + roles +
              '}';
   }
}
