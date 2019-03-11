package com.jd.baoxian.test.tools.mapper;

import com.jd.baoxian.test.tools.dao.Tradetask;
import com.jd.baoxian.test.tools.dao.TradetaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradetaskMapper {
    int countByExample(TradetaskExample example);

    int deleteByExample(TradetaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tradetask record);

    int insertSelective(Tradetask record);

    List<Tradetask> selectByExample(TradetaskExample example);

    Tradetask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tradetask record, @Param("example") TradetaskExample example);

    int updateByExample(@Param("record") Tradetask record, @Param("example") TradetaskExample example);

    int updateByPrimaryKeySelective(Tradetask record);

    int updateByPrimaryKey(Tradetask record);
}