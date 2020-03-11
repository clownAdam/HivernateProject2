package com.myxq.test;

import com.myxq.domain.User;
import com.myxq.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Administrator
 */
public class HibernateTest5 {
    Session session = null;

    @Before
    public void before() {
        session = HibernateUtil.openSession();
    }

    @Test
    public void test() {
        Session session = HibernateUtil.openSession();
        Criteria criteria = session.createCriteria(User.class);
        //add sorted
        criteria.addOrder(Order.desc("user_id"));
        criteria.setFirstResult(5);
        criteria.setMaxResults(2);
        List<User> list = criteria.list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void test2() {
        Criteria criteria = session.createCriteria(User.class);
//        criteria.add(Restrictions.eq("user_name","user1"));
        criteria.add(Restrictions.like("user_name", "u%"));
        List<User> list = criteria.list();

        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void test3(){
        //统计查询
        Criteria criteria = session.createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());
        Object o = criteria.uniqueResult();
        System.out.println(o);
    }
    @Test
    public void test4(){
        //离线条件查询
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.like("user_name","u%"));
        Criteria executableCriteria = detachedCriteria.getExecutableCriteria(session);
        List<User> list = executableCriteria.list();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
