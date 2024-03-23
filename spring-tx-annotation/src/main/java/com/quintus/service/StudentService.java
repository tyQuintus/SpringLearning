package com.quintus.service;

import com.quintus.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     *  添加事务：
     *      @Transactional
     *      位置：  方法 | 类上
     *       方法：  表示当前方法有事务
     *       类上：  表示该类下的所有方法都有事务
     *
     *  1.只读模式  @Transactional(readOnly = true)  readOnly默认为false
     *    只读模式可以提升查询事物的效率。事务中只有查询代码，推荐使用只读模式
     *
     *  2.超时时间  @Transactional(timeout = 秒数)  默认不会超时
     *    超时就会回滚事务并释放异常
     *
     *  3.指定异常回滚 & 指定异常不回滚   默认只有RuntimeError & RuntimeException会回滚
     *    rollbackFor & noRollbackFor
     *    通常做法 rollbackFor = Exception.class 令所有类型异常都回滚
     *
     *  4.隔离级别设置
     *    推荐设置第二个隔离级别：读已提交
     *    isolation = Isolation.READ_COMMITTED
     * */
    @Transactional
    public void changeInfo(){
        studentDao.updateAgeById(100,1);

        int i = 1 / 0;   // 设一个错误语句测试出现异常时事务是否会回滚

        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
}
