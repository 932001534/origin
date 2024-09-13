package demo.shr.service;

import demo.shr.pojo.GatDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shr
 * @create 2024--09--05 18:09
 */
public interface GatDictService {
    public List<GatDict> selectgatajlb();
    public boolean updategatdict(GatDict gatDict);
    List<GatDict> selectlike(String dicname);

}
