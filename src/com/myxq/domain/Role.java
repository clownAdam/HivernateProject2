package com.myxq.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 */
@Getter@Setter
public class Role {
    private Long role_id;
    private String role_name;
    private String role_memo;
    /**
     * 角色下面的所有用户
     */
    private Set<User> users = new HashSet<>();
}
