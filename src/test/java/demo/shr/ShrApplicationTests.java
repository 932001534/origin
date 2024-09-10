package demo.shr;

import demo.shr.Mapper.SysDictMapper;
import demo.shr.pojo.sysdict;
import demo.shr.service.FuzzyMatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShrApplicationTests {

    @Autowired
    SysDictMapper sysDictMapper;
    @Autowired
    FuzzyMatchService fuzzyMatchService;
    @Test
    void contextLoads() {
       List<sysdict> sysdicts= sysDictMapper.select("案件类别");
        System.out.println(sysdicts);
    }

    @Test
    void context() {
        fuzzyMatchService.findAndSaveBestMatches();
    }
}
