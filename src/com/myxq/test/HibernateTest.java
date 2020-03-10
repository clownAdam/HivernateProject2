package com.myxq.test;

import com.myxq.domain.Customer;
import com.myxq.domain.Linkman;
import com.myxq.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 用于一对多的测试 customer-->linkman
 * @author Administrator
 */
public class HibernateTest {
    @Test
    public void test(){
        Session currenSession = HibernateUtil.getCurrenSession();
        Transaction transaction = currenSession.beginTransaction();

        Customer customer1 = new Customer();
        customer1.setCust_name("customer1");

        Customer customer2 = new Customer();
        customer2.setCust_name("customer2");

        Customer customer3 = new Customer();
        customer3.setCust_name("customer3");

        Linkman linkman1 = new Linkman();
        linkman1.setLink_name("linkman1");
        Linkman linkman2 = new Linkman();
        linkman2.setLink_name("linkman2");
        Linkman linkman3 = new Linkman();
        linkman3.setLink_name("linkman3");

        /*配置关系*/
        customer1.getLinkmens().add(linkman1);
        customer1.getLinkmens().add(linkman2);
        customer2.getLinkmens().add(linkman3);

        /*linkman1.setCustomer(customer1);
        linkman2.setCustomer(customer1);
        linkman3.setCustomer(customer2);*/
/*级联保存或更新*/
        currenSession.save(customer1);
        currenSession.save(customer2);
        currenSession.save(customer3);

        /*currenSession.save(linkman1);
        currenSession.save(linkman2);
        currenSession.save(linkman3);*/

        transaction.commit();
    }

    @Test
    public void test2(){
        Session currenSession = HibernateUtil.getCurrenSession();
        Transaction transaction = currenSession.beginTransaction();
        Linkman linkman = currenSession.get(Linkman.class, 3L);
        transaction.commit();
        System.out.println(linkman);
    }

    @Test
    public void test3(){
        Session currenSession = HibernateUtil.getCurrenSession();
        Transaction transaction = currenSession.beginTransaction();
        Customer customer = currenSession.get(Customer.class, 1L);
        currenSession.delete(customer);

        transaction.commit();
    }

    @Test
    public void test4(){
        Session currenSession = HibernateUtil.getCurrenSession();
        Transaction transaction = currenSession.beginTransaction();
        Linkman linkman1 = currenSession.get(Linkman.class, 1L);
        Customer customer2 = currenSession.get(Customer.class, 2L);
        //双向维护
        customer2.getLinkmens().add(linkman1);
        //单向维护
        linkman1.setCustomer(customer2);

        transaction.commit();
    }
}
