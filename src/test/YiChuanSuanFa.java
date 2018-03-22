package test;

public class YiChuanSuanFa {
    /**
     * 将染色体转换成x,y变量的值
     */
    private double[] calculatefitnessvalue(String str) {

        //二进制数前23位为x的二进制字符串，后23位为y的二进制字符串
        int a = Integer.parseInt(str.substring(0, 23), 2);      
        int b = Integer.parseInt(str.substring(23, 46), 2);

        double x =  a * (6.0 - 0) / (Math.pow(2, 23) - 1);    //x的基因
        double y =  b * (6.0 - 0) / (Math.pow(2, 23) - 1);    //y的基因

        //需优化的函数
        double fitness = 3 - Math.sin(2 * x) * Math.sin(2 * x) 
                - Math.sin(2 * y) * Math.sin(2 * y);

        double[] returns = { x, y, fitness };
        return returns;

    }
    
    /**
     * 轮盘选择
     * 计算群体上每个个体的适应度值; 
     * 按由个体适应度值所决定的某个规则选择将进入下一代的个体;
     */
    private void select() {
        double evals[] = new double[ChrNum]; // 所有染色体适应值
        double p[] = new double[ChrNum]; // 各染色体选择概率
        double q[] = new double[ChrNum]; // 累计概率
        double F = 0; // 累计适应值总和
        for (int i = 0; i < ChrNum; i++) {
            evals[i] = calculatefitnessvalue(ipop[i])[2];
            if (evals[i] < bestfitness){  // 记录下种群中的最小值，即最优解
                bestfitness = evals[i];
                bestgenerations = generation;
                beststr = ipop[i];
            }

            F = F + evals[i]; // 所有染色体适应值总和
        }
        //划分区间，打造选择所用的轮盘
        for (int i = 0; i < ChrNum; i++) {
            p[i] = evals[i] / F;
            if (i == 0)
                q[i] = p[i];
            else {
                q[i] = q[i - 1] + p[i];
            }
        }
        for (int i = 0; i < ChrNum; i++) {
            double r = Math.random();
            if (r <= q[0]) {
                ipop[i] = ipop[0];
            } else {
                for (int j = 1; j < ChrNum; j++) {
                    if (r < q[j]) {
                        ipop[i] = ipop[j];
                        break; //确定区间后跳出循环
                    }
                }
            }
        }
    }
}
