package demo.shr.Mapper;

import demo.shr.pojo.GatDict;

import demo.shr.pojo.sysdict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

/**
 * @author shr
 * @create 2024--09--05 17:30
 */
@Mapper
public interface GatDictMapper {
    List<GatDict> selectgatajlb();
    public int updategatdict(GatDict gatDict);
    List<GatDict> selectlike(@Param("name") String dicname);
}
