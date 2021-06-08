package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/5/8 9:32
 */
public class CN1723 {
    class Solution {
        Map<Long, Long> mem = new HashMap<>();
        int[] sum = null;

        public int minimumTimeRequired(int[] jobs, int k) {
            //实际上就是将jobs平均分为k份
            sum = new int[1 << jobs.length];
            for (int i = 1; i < sum.length; i++) {
                int x = Integer.numberOfTrailingZeros(i), y = i - (1 << x);
                sum[i] = sum[y] + jobs[x];
            }
            int[][] d = new int[k][1 << jobs.length];
            for (int i = 1; i < k; i++) {
                for (int j = 0; j < d[0].length; j++) {
                    int minn = Integer.MAX_VALUE;
                    for (int x = j; x != 0; x = (x - 1) & j) {
                        minn = Math.min(minn, Math.max(d[i - 1][j - x], sum[x]));
                    }
                    d[i][j] = minn;
                }
            }
            return d[k - 1][(1 << jobs.length) - 1];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[17,20,4,6,2,5,13,5,8]"),8);
        for (int x = 0b1101; x != 0; x = (x - 1) & 0b1101) {
            System.out.println(Integer.toBinaryString(x));
        }

        System.out.println("[{\"title\":\"个人信息\",\"contentList\":[{\"name\":\"姓名\",\"value\":\"詹泽桐\",\"key\":\"appName\"},{\"name\":\"性别\",\"value\":\"男\",\"key\":\"appSex\"},{\"name\":\"年龄\",\"value\":\"33\",\"key\":\"appAge\"},{\"name\":\"工作经历\",\"value\":\"10年及以上\",\"key\":\"appWorkingLifetime\"}]},{\"title\":\"教育经历\",\"contentList\":[{\"name\":\"教育经历\",\"detailList\":[{\"title\":\"本科\",\"contentList\":[{\"name\":\"学历\",\"value\":\"本科\",\"key\":\"edu\"},{\"name\":\"学校\",\"value\":\"华南师范大学\",\"key\":\"school\"},{\"name\":\"学习形式\",\"value\":\"全国普通高等院校全日制\",\"key\":\"learningWay\"},{\"name\":\"专业\",\"value\":\"信息管理与信息系统\",\"key\":\"profession\"}]}]}]},{\"title\":\"应聘信息\",\"contentList\":[{\"name\":\"原单位\",\"value\":\"招商仁和人寿东莞分公司\",\"key\":\"appOrgUnit\"},{\"name\":\"岗位\",\"value\":\"渠道总监\",\"key\":\"appPosition\"},{\"name\":\"应聘部门\",\"value\":\"招商仁和人寿东莞分公司_银行保险部\",\"key\":\"appDept\"},{\"name\":\"应聘职位\",\"value\":\"银行保险部负责人\",\"key\":\"appJob\"}]},{\"title\":\"职位信息\",\"contentList\":[{\"name\":\"职位描述\",\"value\":\"招商仁和人寿东莞分公司银行保险部部门负责人岗\",\"key\":\"entrPosition\"},{\"name\":\"职位\",\"value\":\"1000077\",\"key\":\"entrDept\"},{\"name\":\"公司\",\"value\":\"招商局仁和人寿保险股份有限公司东莞分公司\",\"key\":\"entrCompany\"}]}]");
    }
}
