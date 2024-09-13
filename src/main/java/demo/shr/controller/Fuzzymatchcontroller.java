package demo.shr.controller;

import demo.shr.pojo.GatDict;
import demo.shr.pojo.sysdict;
import demo.shr.service.GatDictService;
import demo.shr.service.SysDictService;
import org.simmetrics.StringMetric;
import org.simmetrics.metrics.StringMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Fuzzymatchcontroller {
    @Autowired
    private GatDictService gatDictService;
    @Autowired
    private SysDictService sysDictService;
    @GetMapping("/dict-match/search")
    public String searchByKey(@RequestParam("dicname") String dicname) {
        List<sysdict> sysdicts = sysDictService.select(dicname);
        List<GatDict> gatDicts = gatDictService.selectlike(dicname);
        StringMetric metric = StringMetrics.levenshtein();
        float threshold = 0.8f; // 设置相似度阈值
        for (GatDict dict1 : gatDicts) {
            String bestCode = null;
            String bestValue = null;
            float highestSimilarity = 0;

            for (sysdict dict2 : sysdicts) {
                float similarity = metric.compare(dict1.getGatvalue(), dict2.getItem());

                // 如果相似度高于当前最高相似度且大于阈值，则更新最佳匹配
                if (similarity > highestSimilarity && similarity >= threshold) {
                    highestSimilarity = similarity;
                    bestCode = dict2.getCode();
                    bestValue = dict2.getItem();
                }
            }
            if (bestCode != null) {
                GatDict dictMatch = new GatDict();
                dictMatch.setGatcode(dict1.getGatcode());
                dictMatch.setSqcode(bestCode);
                System.out.println("sqcode"+bestCode);
                System.out.println("sqvalue"+bestValue);
                dictMatch.setSqvalue(bestValue);
                gatDictService.updategatdict(dictMatch);
            }
        }
        return "请求成功";
    }
}
