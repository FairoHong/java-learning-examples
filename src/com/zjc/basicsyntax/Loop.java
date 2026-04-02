package com.zjc.basicsyntax;

//循环案例：简易自动售货机系统

public class Loop {
    public static void main(String[] args) {

        // 商品信息
        String[] goods = {"矿泉水", "可乐", "雪碧", "薯片", "饼干"};
        double[] prices = {2.0, 3.5, 3.0, 5.0, 4.5};
        int[] stocks = {5, 3, 4, 2, 6};     // 库存

        double balance = 20.0;      // 初始余额
        int choice = 0;             // 用户选择


        // ==================== 1. while循环 ====================
        // 语法：while (条件) { 循环体 }
        // 特点：先判断条件，true才执行，可能一次都不执行
        // 作用：显示主菜单，用户不退出就一直循环

        System.out.println("===== 欢迎使用自动售货机 =====");

        while (choice != 9) {       // 9是退出选项，不等于9就继续循环

            System.out.println("\n--- 主菜单（while循环演示）---");
            System.out.println("当前余额：" + balance + "元");

            // 用for循环显示商品列表（下面会讲到）
            System.out.println("商品列表：");
            for (int i = 0; i < goods.length; i++) {
                System.out.println((i+1) + "." + goods[i] + " " + prices[i] + "元 库存:" + stocks[i]);
            }
            System.out.println("9.退出");

            // 模拟用户输入（实际用Scanner，这里直接赋值演示）
            choice = 1;     // 假设用户选择买矿泉水

            // 演示break：如果余额不足，直接结束购物
            if (balance <= 0) {
                System.out.println("【while】余额不足，强制退出！");
                break;      // 立即跳出while循环，不再判断条件
            }

            // 模拟购买过程
            if (choice >= 1 && choice <= 5) {
                int index = choice - 1;

                // 演示continue：如果库存为0，跳过本次购买
                if (stocks[index] <= 0) {
                    System.out.println("【continue】" + goods[index] + "已售罄，跳过本次购买");
                    choice = 9;     // 设为退出，结束演示
                    continue;       // 跳过本次循环剩余代码，回到while条件判断
                }

                // 扣款并减库存
                balance -= prices[index];
                stocks[index]--;
                System.out.println("【while】购买" + goods[index] + "成功，剩余余额：" + balance);
            }

            // 为了演示while，只执行一次就手动退出
            choice = 9;     // 设为9，下次判断时退出循环
        }


        // ==================== 2. do-while循环 ====================
        // 语法：do { 循环体 } while (条件);
        // 特点：先执行一次，再判断条件，至少执行一次
        // 作用：密码输入验证，至少让用户输一次

        System.out.println("\n===== do-while循环演示（密码验证）=====");

        int password = 0;
        int correctPassword = 1234;
        int tryCount = 0;

        do {
            // 先执行这里，不管条件是什么
            tryCount++;
            password = 1234;    // 模拟用户输入正确密码

            if (password != correctPassword) {
                System.out.println("【do-while】第" + tryCount + "次输入错误，请重试");
            }

        } while (password != correctPassword && tryCount < 3);
        // 条件为true就继续循环，false就结束

        if (password == correctPassword) {
            System.out.println("【do-while】验证成功！共尝试了" + tryCount + "次");
        } else {
            System.out.println("【do-while】超过3次，账户锁定");
        }


        // ==================== 3. for循环 ====================
        // 语法：for (初始化; 条件; 迭代) { 循环体 }
        // 初始化：int i = 0  只执行一次
        // 条件：i < 次数  每次循环前判断，true才执行
        // 迭代：i++  每次循环结束后执行

        System.out.println("\n===== for循环演示（计算单日销售额）=====");

        double[] hourlySales = {50.0, 80.0, 120.0, 90.0, 150.0, 200.0, 180.0, 100.0};
        double dailyTotal = 0;

        // 遍历8个小时的销售额
        for (int hour = 0; hour < hourlySales.length; hour++) {
            // hour从0开始，每次加1，直到不小于数组长度

            System.out.println("【for】第" + (hour+1) + "小时销售额：" + hourlySales[hour] + "元");
            dailyTotal += hourlySales[hour];    // 累加

            // 演示continue：如果某小时销售额低于60，标记为淡季但不中断统计
            if (hourlySales[hour] < 60) {
                System.out.println("  【continue】该时段业绩较差，继续统计下一时段");
                continue;       // 跳过后面代码，进入下一次循环
            }
        }

        System.out.println("【for】今日总销售额：" + dailyTotal + "元");


        // ==================== 4. 双重循环（循环嵌套） ====================
        // 语法：外层循环 { 内层循环 { } }
        // 特点：外层执行1次，内层完整执行一轮
        // 作用：打印购物小票表格、计算乘法表

        System.out.println("\n===== 双重循环演示（打印库存盘点表）=====");

        // 模拟3个货架，每个货架5种商品
        // 外层循环：遍历货架（3次）
        // 内层循环：遍历每个货架的商品（5次）

        for (int shelf = 1; shelf <= 3; shelf++) {          // 外层：3个货架

            System.out.println("\n--- 第" + shelf + "号货架 ---");

            for (int item = 1; item <= 5; item++) {         // 内层：每个货架5个位置

                // 内层循环体：打印商品位置信息
                System.out.print("【双重循环】位置" + shelf + "-" + item + " ");

                // 演示break在双重循环中：只跳出内层，外层继续
                if (shelf == 2 && item == 3) {
                    System.out.println("(此处商品缺货，跳过本货架剩余检查)");
                    break;      // 只跳出内层for循环，外层shelf循环继续
                }

                System.out.println("检查完成");
            }
            // 内层循环结束，回到外层循环，shelf加1
        }


        // 双重循环打印矩形（经典案例）
        System.out.println("\n===== 双重循环打印矩形 =====");

        for (int row = 1; row <= 4; row++) {        // 外层：4行

            for (int col = 1; col <= 6; col++) {    // 内层：每行6个星号
                System.out.print("* ");               // 不换行
            }
            System.out.println();                     // 每行结束换行
        }
        // 结果：4行6列的矩形


        // ==================== 5. 终止循环关键字总结 ====================
        System.out.println("\n===== 终止循环关键字总结 =====");

        // break：跳出当前循环
        System.out.println("【break】用于完全退出循环");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("遇到5，break跳出循环");
                break;          // 循环完全结束，i不会再增加到6
            }
            System.out.print(i + " ");
        }
        System.out.println();   // 输出：1 2 3 4 遇到5，break跳出循环

        // continue：跳过本次，继续下次
        System.out.println("\n【continue】用于跳过当前次循环");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.print("(跳过3) ");
                continue;       // 跳过i=3的剩余代码，直接i++
            }
            System.out.print(i + " ");
        }
        System.out.println();   // 输出：1 2 (跳过3) 4 5

        // return：结束整个方法（在main中就是结束程序）
        System.out.println("\n【return】结束main方法");
        // 如果这里写return，后面的代码都不会执行
        // return;


        // ==================== 综合：找零钱计算（while+for结合） ====================
        System.out.println("\n===== 综合案例：找零计算 =====");

        double purchase = 17.5;     // 消费17.5元
        double pay = 50.0;            // 支付50元
        double change = pay - purchase;   // 应找32.5元

        System.out.println("消费：" + purchase + "元，支付：" + pay + "元");
        System.out.println("应找零：" + change + "元");

        // 用while循环确保找零金额大于0
        int coinTypes = 0;          // 统计用了几种面值

        // 面值数组：20元、10元、1元、0.5元
        double[] denominations = {20.0, 10.0, 1.0, 0.5};

        while (change >= 0.5) {     // 还有零钱要找（至少5毛）

            // 用for循环遍历各种面值
            for (int i = 0; i < denominations.length; i++) {

                double denom = denominations[i];

                // 如果当前面值能用（比零钱小或相等）
                if (change >= denom) {
                    int count = (int)(change / denom);  // 几张/几个
                    change = change - count * denom;      // 减去已找金额

                    System.out.println("找" + count + "张" + denom + "元");
                    coinTypes++;

                    // 如果刚好找完，用break跳出for循环
                    if (change < 0.1) {     // 考虑到浮点精度
                        System.out.println("找零完成！");
                        break;              // 跳出for循环，但还在while里
                    }
                }
            }

            // 防止死循环：如果循环超过10次强制退出
            coinTypes++;
            if (coinTypes > 10) {
                System.out.println("安全退出");
                break;          // 跳出while循环
            }
        }

        System.out.println("最终剩余（精度误差）：" + change + "元");
    }
}
