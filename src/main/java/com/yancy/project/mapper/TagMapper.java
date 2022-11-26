package com.yancy.project.mapper;

import com.yancy.project.model.dto.tag.TagAddRequest;
import com.yancy.project.model.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 11567
* @description 针对表【tag(标签)】的数据库操作Mapper
* @createDate 2022-11-24 14:01:02
* @Entity com.yancy.project.model.entity.Tag
*/
public interface TagMapper extends BaseMapper<Tag> {

    int addUserTag(@Param("tagName") String tagName,@Param("userId") Long userId);
}




