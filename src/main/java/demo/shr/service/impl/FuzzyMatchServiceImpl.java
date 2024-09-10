package demo.shr.service.impl;

import demo.shr.pojo.GatDict;
import demo.shr.pojo.sysdict;
import demo.shr.service.FuzzyMatchService;
import demo.shr.service.GatDictService;
import demo.shr.service.SysDictService;
import org.simmetrics.StringMetric;
import org.simmetrics.metrics.StringMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shr
 * @create 2024--09--05 18:28
 */
@Service
public class FuzzyMatchServiceImpl implements FuzzyMatchService {
    @Autowired
    private GatDictService gatDictService;
    @Autowired
    private SysDictService sysDictService;


    @Override
    public void findAndSaveBestMatches() {
        List<sysdict> sysdicts = sysDictService.selectdict();
        List<GatDict> gatDicts = gatDictService.selectgatajlb();
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
    }
}