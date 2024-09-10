package demo.shr.service;

import demo.shr.pojo.GatDict;

import java.util.List;

/**
 * @author shr
 * @create 2024--09--05 18:09
 */
public interface GatDictService {
    public List<GatDict> selectgatajlb();
    public boolean updategatdict(GatDict gatDict);
}
