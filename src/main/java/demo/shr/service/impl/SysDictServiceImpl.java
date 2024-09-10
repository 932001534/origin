package demo.shr.service.impl;

import demo.shr.Mapper.SysDictMapper;
import demo.shr.pojo.sysdict;
import demo.shr.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shr
 * @create 2024--09--05 16:57
 */
@Service
public class SysDictServiceImpl implements SysDictService {
     @Autowired SysDictMapper sysDictMapper;
     public List<sysdict> selectdict(){
         List<sysdict> sysdicts = sysDictMapper.selectajlb();
         return sysdicts;
     }
}
