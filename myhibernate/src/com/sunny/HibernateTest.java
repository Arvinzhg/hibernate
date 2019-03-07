package com.sunny;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest {

    @Test
    public void testAdd() {

        Configuration configuration = new Configuration().configure();//默认会加载hibernate.cfg.xml，此文件不要改名
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();//开启事务
        Customer consumer = new Customer();
        consumer.setCust_name("zhangsan");
        consumer.setCust_level("admin");
        consumer.setCust_id(5L);
        session.save(consumer);
        transaction.commit();//提交事务

        session.close();//释放资源

    }
}
