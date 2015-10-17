package me.gacl.test;

import java.util.Date;                                                                        
import java.util.UUID;                                                                        
import me.gacl.domain.User;                                                                   
import me.gacl.service.UserServiceI;                                                          
import org.junit.Test;                                                                        
import org.junit.runner.RunWith;                                                              
import org.springframework.beans.factory.annotation.Autowired;                                
import org.springframework.test.context.ContextConfiguration;                                 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;                       
import org.springframework.test.context.transaction.TransactionConfiguration;
    
//在使用所有注释前必须使用@RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)           

//配置事务管理器， 以免单元测试造成脏数据
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  

//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，        
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml" })  
public class MyBatisTestBySpringTestFramework {                                               
                                                                                              
    //注入userService                                                                         
    @Autowired                                                                                
    private UserServiceI userService;                                                         
                                                                                              
    @Test                                                                                     
    public void testAddUser(){                                                                
        User user = new User();                                                               
        user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));                     
        user.setUserName("xdp_gacl_白虎神皇");                                                
        user.setUserBirthday(new Date());                                                     
        user.setUserSalary(10000D);                                                           
        userService.addUser(user);                                                            
    }                                                                                         
                                                                                              
    @Test                                                                                     
    public void testGetUserById(){                                                            
        String userId = "500d75039a394dc49c2425e31e73dbcd";                                   
        User user = userService.getUserById(userId);                                          
        System.out.println(user.getUserName());                                               
    }                                                                                         
}                                                                                             
