package com.admin.crawler.mapper;

import com.admin.crawler.annotations.*;
import com.admin.crawler.entity.TestUser;
import com.admin.crawler.entity.UserInfo;
import org.apache.catalina.User;

import java.util.List;

/**
 * <p>
 * 项目用户 服务类
 * </p>
 *
 * @author quyixiao
 * @since 2021-01-28
 */

public interface TestUserMapper extends MyBaseMapper<TestUser> {

    //所有的查询条件，默认是 AND 和 = 关系，如果想在其他的关系，可以写相关的注解@OR ，或@Like
    TestUser selectTestUserById(Long id);

    @OrderBy({
            @By(value = {"id"}, type = OrderType.DESC),
    })
    TestUser selectUserByCondition(Long branchId, @GT int type, @LIKE String realName, UserInfo userInfo);

    @LIMIT(10)
    List<TestUser> selectUserByRealName(@LIKE String realName , @LLIKE String mobile);

    //对于这种情况 taskId 和 staffId 传入的值可以是 null
    List<TestUser> selectByTaskId(@IsNull  Long taskId ,@IsNotNull Long staffId);

    List<TestUser> selectByTaskRealNameMobile(@IsNotEmpty String mobile ,@IsEmpty String realName);

    int countUser(@LIKE String realName);

    Long insertTestUser(TestUser testUser);

    Long insertBatchTestUser(List<TestUser> testUsers);

    Long insertTestUserBatch(TestUser[] testUsers);

    //目前不支持批量更新
    int updateTestUserById(TestUser testUser);

    //默认使用最后一个作为更新条件
    int updateRealNameById(String realName, Long id);

    //如果想写多个更新条件，在字段前面加 @by注解，值得注意的是，所有的方法参数名称都应该和数据库中的字段对应，在自动生成 sql时，会将驼峰参数名转化为数据库字段
    void updateTestUserUserNamePassword(String username, String mobile, @By Long id, @By Long taskId);

    int deleteTestUserById(Long id);

    // @In注解中的值，对应数据库列字段
    int deleteTestUserByIds(@IN("id") List<Long> ids);

    //【注意】千万不能这样写，这样写的话，是删除所有的数据
    void deleteBatch();


}