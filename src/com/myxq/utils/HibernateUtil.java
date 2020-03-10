package com.myxq.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author clown
 */
public class HibernateUtil {
    public static final Configuration configure;
    public static final SessionFactory sessionFactory;
    static {
//      1、加载配置文件
        configure = new Configuration().configure();
//      2、创建sessionFactory-->jdbc连接池
        sessionFactory = configure.buildSessionFactory();
    }
    public static Session openSession(){
        return sessionFactory.openSession();
    }
    public static Session getCurrenSession(){
        return sessionFactory.getCurrentSession();
    }
}
