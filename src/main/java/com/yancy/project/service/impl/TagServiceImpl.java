package com.yancy.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yancy.project.model.entity.Tag;
import com.yancy.project.service.TagService;
import com.yancy.project.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author 11567
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2022-11-24 14:01:02
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




