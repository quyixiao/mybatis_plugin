package com.admin.crawler.service.impl;

import com.admin.crawler.entity.TestUser;
import com.admin.crawler.mapper.TestUserMapper;
import com.admin.crawler.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* <p>
* 项目用户 服务类
* </p>
*
* @author quyixiao
* @since 2021-01-28
*/

@Service
public class TestUserServiceImpl implements TestUserService {


    @Autowired
	private TestUserMapper testUserMapper;



}
