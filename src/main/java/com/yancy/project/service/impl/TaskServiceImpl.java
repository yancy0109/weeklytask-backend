package com.yancy.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yancy.project.model.entity.Task;
import com.yancy.project.service.TaskService;
import com.yancy.project.mapper.TaskMapper;
import org.springframework.stereotype.Service;

/**
* @author 11567
* @description 针对表【task(任务)】的数据库操作Service实现
* @createDate 2022-11-24 13:08:01
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

}




