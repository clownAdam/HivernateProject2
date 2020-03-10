package com.myxq.test;

import com.myxq.domain.Role;
import com.myxq.domain.User;
import com.myxq.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.lang.annotation.Target;

/**
 * this is test hibernate many-to many user--user_role--role
 * @author Administrator
 */
public class HibernateTest2 {
    @Test
    public void test(){
        Session currenSession = HibernateUtil.getCurrenSession();
        Transaction transaction = currenSession.beginTransaction();
        //创建用户
        User user1 = new User();
        user1.setUser_name("user1");

        User user2 = new User();
        user2.setUser_name("user2");
        //创建角色
        Role role1 = new Role();
        role1.setRole_name("role1");

        Role role2 = new Role();
        role2.setRole_name("role2");

        Role role3 = new Role();
        role3.setRole_name("role3");
        //配置关系
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role2);
        user2.getRoles().add(role3);
       /* role1.getUsers().add(user1);
        role2.getUsers().add(user1);
        role2.getUsers().add(user2);
        role3.getUsers().add(user2);
*/


        currenSession.save(user1);
        currenSession.save(user2);

        /**
            currenSession.save(role1);
            currenSession.save(role2);
            currenSession.save(role3);*/

        transaction.commit();
    }

    @Test
    public void test2(){
        //关系操作，操作内部集合
        Session currenSession = HibernateUtil.getCurrenSession();
        Transaction transaction = currenSession.beginTransaction();
        User user1 = currenSession.get(User.class, 1L);
        Role role3 = currenSession.get(Role.class, 3L);
        user1.getRoles().add(role3);
//        role3.getUsers().add(user1);

        transaction.commit();
    }
    @Test
    public void test3(){
        Session currenSession = HibernateUtil.getCurrenSession();
        Transaction transaction = currenSession.beginTransaction();
        User user2 = currenSession.get(User.class, 2L);
        Role role3 = currenSession.get(Role.class, 3L);
        Role role1 = currenSession.get(Role.class, 1L);

        user2.getRoles().remove(role3);
        user2.getRoles().add(role1);


        transaction.commit();
    }
}
