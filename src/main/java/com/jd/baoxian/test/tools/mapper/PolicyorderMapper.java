package com.jd.baoxian.test.tools.mapper;


import com.jd.baoxian.test.tools.dao.Policyorder;
import com.jd.baoxian.test.tools.dao.PolicyorderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PolicyorderMapper {
    int countByExample(PolicyorderExample example);

    int deleteByExample(PolicyorderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Policyorder record);

    int insertSelective(Policyorder record);

    List<Policyorder> selectByExample(PolicyorderExample example);

    Policyorder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Policyorder record, @Param("example") PolicyorderExample example);

    int updateByExample(@Param("record") Policyorder record, @Param("example") PolicyorderExample example);

    int updateByPrimaryKeySelective(Policyorder record);

    int updateByPrimaryKey(Policyorder record);
}