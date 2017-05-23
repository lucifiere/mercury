package demo.service;

import demo.dao.DemoDao;
import demo.po.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by XD.Wang on 2017/5/23.
 * 示例服务
 */
@Service
public class DemoService {

    @Resource
    private
    DemoDao demoDAO;

    private static final Logger log = LoggerFactory.getLogger(DemoService.class);

    public List<Demo> getDemoList() {
        log.debug("get demo list execute.");
        return demoDAO.getDemoList();
    }

}
