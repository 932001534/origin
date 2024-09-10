package demo.shr.service.impl;

import demo.shr.Mapper.GatDictMapper;
import demo.shr.pojo.GatDict;
import demo.shr.service.GatDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shr
 * @create 2024--09--05 18:19
 */
@Service
public class GatDictServiceImpl implements GatDictService {
    @Autowired
    GatDictMapper gatDictMapper;
    @Override
    public List<GatDict> selectgatajlb() {
        List<GatDict> gatDicts = gatDictMapper.selectgatajlb();
        return gatDicts;
    }
    public boolean updategatdict(GatDict gatDict){
        return gatDictMapper.updategatdict(gatDict) > 0;
    };
}
