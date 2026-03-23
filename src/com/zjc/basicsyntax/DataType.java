package com.zjc.basicsyntax;

public class DataType {
    public static void main(String[] args) {
        // ========== 1. 定义学生信息（基本类型） ==========
        String name = "张三";           // 姓名
        int age = 18;                   // 年龄
        char gender = '男';             // 性别
        boolean isPass = true;          // 是否及格

        // ========== 2. 定义各科成绩（小数用double） ==========
        double chinese = 85.5;          // 语文
        double math = 92.0;             // 数学
        double english = 78.5;          // 英语

        // ========== 3. 计算总分和平均分 ==========
        double total = chinese + math + english;
        double average = total / 3;

        // ========== 4. 类型转换演示 ==========
        int intAverage = (int) average;     // 强制转换：double转int，小数部分丢弃

        // ========== 5. 输出所有信息 ==========
        System.out.println("===== 学生成绩单 =====");
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("性别：" + gender);
        System.out.println("语文：" + chinese);
        System.out.println("数学：" + math);
        System.out.println("英语：" + english);
        System.out.println("总分：" + total);
        System.out.println("平均分（精确）：" + average);
        System.out.println("平均分（取整）：" + intAverage);
        System.out.println("是否及格：" + isPass);

        // ========== 6. 简单运算演示 ==========
        System.out.println("\n===== 额外计算 =====");
        System.out.println("数学比语文高：" + (math - chinese) + "分");
        System.out.println("三科总分是：" + (chinese + math + english));
    }
}
