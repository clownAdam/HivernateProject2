package com.myxq.test;

import com.myxq.domain.User;
import com.myxq.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @author Administrator
 */
public class HibernateTest3 {
    /**
     * get（）test
     */
    @Test
    public void test() {

        Session currenSession = HibernateUtil.getCurrenSession();
        Transaction transaction = currenSession.beginTransaction();
        User user1 = currenSession.get(User.class, 1L);
        System.out.println(user1);
        transaction.commit();
    }

    /**
     * load() case
     */
    @Test
    public void test2() {
        Session currenSession = HibernateUtil.getCurrenSession();
        Transaction transaction = currenSession.beginTransaction();
        User user1 = currenSession.load(User.class, 1L);
        System.out.println(user1.getUser_name());
        transaction.commit();
    }
}
