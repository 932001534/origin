package demo.shr;

import demo.shr.Mapper.GatDictMapper;
import demo.shr.Mapper.SysDictMapper;
import demo.shr.pojo.GatDict;
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
    GatDictMapper gatDictMapper;
    @Autowired
    FuzzyMatchService fuzzyMatchService;
    @Test
    void contextLoads() {
       List<sysdict> sysdicts= sysDictMapper.select("文化程度");
        System.out.println(sysdicts);
    }
    @Test
    void context2() {
        List<GatDict> gatDicts= gatDictMapper.selectlike("案件类别");
        System.out.println(gatDicts);
    }
    @Test
    void context() {
        fuzzyMatchService.findAndSaveBestMatches();
    }
}
