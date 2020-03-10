package com.myxq.test;

import com.myxq.domain.User;
import com.myxq.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * HQL
 *
 * @author Administrator
 */
public class HibernateTest4 {
    private Session session;
    @Before
    public void before(){
        session = HibernateUtil.openSession();
    }

    @Test
    public void test() {
        //简单查询hql
        Session session = HibernateUtil.openSession();
//        Query query = session.createQuery("from User ");
//        Query query = session.createQuery("select  c from User c");
        Query query = session.createQuery("select  c from User c order by user_id desc");
        List<User> list = query.list();
        System.out.println(list);
    }

    @Test
    public void test2() {
        //条件查询
        Session session = HibernateUtil.openSession();
       /* Query query = session.createQuery("from User where user_code=?0 and user_name=?1");
        query.setParameter(0,"xxx");
        query.setParameter(1,"user1");
        List list = query.list();
        System.out.println(list);*/
        //起别名的条件查询
        Query query = session.createQuery("from User where user_code=:user_code and user_name=:username");
        query.setParameter("user_code", "xxx");
        query.setParameter("username", "user1");
        List list = query.list();
        System.out.println(list);
    }

    @Test
    public void test3() {
        /**
         * 投影查询 case
         */
        Session session = HibernateUtil.openSession();
        List list = session.createQuery("select c.user_name from User c").list();
        System.out.println(list);

        List<Object[]> list1 = session.createQuery("select c.user_code,c.user_name from User c").list();
        for (Object[] ge : list1) {
            System.out.println(Arrays.toString(ge));
        }

        Query query = session.createQuery("select new User(user_code,user_name) from User c");
        List<User> list2 = query.list();
        System.out.println(list2);
    }

    @Test
    public void test4() {
        //分页查询
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery("from User ");
        //角标的起始位置
        query.setFirstResult(0);
        //条数
        query.setMaxResults(3);
        List list = query.list();
        System.out.println(list);
    }
    @Test
    public void test5(){
        //查询所有
        Object o = session.createQuery("select count(*) from User ").uniqueResult();
        System.out.println(o);
    }
    @Test
    public void test6(){
        //分组
        Query query = session.createQuery("select user_name,count(*) from User u group by user_name");
        List<Object[]> list = query.list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }
    @Test
    public void test7(){
        //连接查询
        List<User> list = session.createQuery("from User u inner join fetch u.roles").list();
        for (User objects : list) {
            System.out.println(objects);
        }
    }

}
