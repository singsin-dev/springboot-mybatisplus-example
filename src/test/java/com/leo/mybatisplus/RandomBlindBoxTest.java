package com.leo.mybatisplus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author leo thomas
 * @date 2023/7/30 下午 07:18
 */


public class RandomBlindBoxTest {

    private List<String> items;
    private List<Integer> weights;
    private int totalWeight;
    private Random random;

    @Test
    public void blindBoxTest() {
        BlindBox();
        // 重复运行多次，验证不同的随机结果
        for (int i = 0; i < 10; i++) {
            String item = getRandomItem();
            System.out.println("抽中的物品是：" + item);
        }
    }
    
    public void BlindBox() {
        // 初始化物品列表和权重列表
        items = new ArrayList<>();
        weights = new ArrayList<>();
        random = new Random();

        // 添加物品和权重
        items.add("Iphone15");
        items.add("吹风机");
        items.add("海蓝之迷套装");
        items.add("婴儿手口湿巾");
        items.add("生物巨能维生素C");

        weights.add(9);
        weights.add(1);
        weights.add(1);
        weights.add(4);
        weights.add(2);

        // 计算总权重
        totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
        }
    }

    public String getRandomItem() {
        // 生成随机数，范围在0到总权重之间
        int randomValue = random.nextInt(totalWeight) + 1; // +1是为了避免randomValue为0的情况

        // 使用概率累加算法选择物品
        int cumulativeWeight = 0;
        for (int i = 0; i < items.size(); i++) {
            cumulativeWeight += weights.get(i);
            if (randomValue <= cumulativeWeight) {
                return items.get(i);
            }
        }

        // 如果发生异常，返回null
        return null;
    }
    
}
