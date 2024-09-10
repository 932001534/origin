package demo.shr.Mapper;

import demo.shr.pojo.sysdict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shr
 * @create 2024--09--03 16:25
 */
@Mapper
public interface SysDictMapper {
    List<sysdict> select(String dicname);
    List<sysdict> selectajlb();
}
