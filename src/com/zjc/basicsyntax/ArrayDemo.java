
package com.zjc.basicsyntax;

/***
 * 综合案例：学生成绩管理系统
 */
import java.util.Arrays;    // 导入排序工具
public class ArrayDemo {
        public static void main(String[] args) {

            // ==================== 1. 一维数组声明与初始化 ====================
            // 语法：数据类型[] 数组名 = new 数据类型[长度];
            // 或：数据类型[] 数组名 = {值1, 值2, 值3};

            System.out.println("===== 1. 数组基础操作 =====");

            // 静态初始化：直接给值
            int[] scores = {85, 92, 78, 90, 88, 76, 95, 89};
            // 索引：          0   1   2   3   4   5   6   7
            // 长度是8，索引从0到7

            System.out.println("班级人数：" + scores.length + "人");    // .length获取长度
            System.out.println("第1个学生成绩：" + scores[0]);      // 访问第1个（索引0）
            System.out.println("第3个学生成绩：" + scores[2]);      // 访问第3个（索引2）
            System.out.println("最后一个学生成绩：" + scores[scores.length - 1]);  // 最后一个索引是length-1


            // ==================== 2. 数组遍历（for循环） ====================
            // 语法：for (int i = 0; i < 数组.length; i++)

            System.out.println("\n===== 2. 遍历输出所有成绩 =====");

            for (int i = 0; i < scores.length; i++) {
                System.out.println("第" + (i+1) + "位学生：" + scores[i] + "分");
            }


            // ==================== 3. 数组常用操作：求和与平均 ====================

            System.out.println("\n===== 3. 求和与平均分 =====");

            int sum = 0;                    // 累加器

            for (int i = 0; i < scores.length; i++) {
                sum = sum + scores[i];      // 累加每个成绩
            }

            double average = (double) sum / scores.length;   // 强制转double求平均

            System.out.println("总分：" + sum);
            System.out.println("平均分：" + average);


            // ==================== 4. 数组常用操作：求最大值和最小值 ====================

            System.out.println("\n===== 4. 求最高分和最低分 =====");

            int max = scores[0];              // 假设第一个是最大
            int min = scores[0];              // 假设第一个是最小

            for (int i = 1; i < scores.length; i++) {    // 从第2个开始比较
                if (scores[i] > max) {          // 发现更大的
                    max = scores[i];             // 更新最大值
                }
                if (scores[i] < min) {          // 发现更小的
                    min = scores[i];             // 更新最小值
                }
            }

            System.out.println("最高分：" + max);
            System.out.println("最低分：" + min);


            // ==================== 5. 数组常用操作：查找指定元素 ====================

            System.out.println("\n===== 5. 查找90分以上的学生 =====");

            int target = 90;                // 查找目标
            boolean found = false;         // 是否找到

            for (int i = 0; i < scores.length; i++) {
                if (scores[i] >= target) {
                    System.out.println("找到" + scores[i] + "分，第" + (i+1) + "位学生");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("没有" + target + "分以上的学生");
            }


            // ==================== 6. 数组常用操作：排序 ====================
            // 使用Arrays.sort()方法，需导入java.util.Arrays

            System.out.println("\n===== 6. 成绩排序 =====");

            // 先复制一个数组，保留原数据
            int[] sortedScores = scores.clone();    // 克隆数组

            Arrays.sort(sortedScores);           // 升序排序

            System.out.print("升序排列：");
            for (int score : sortedScores) {       // for-each遍历
                System.out.print(score + " ");
            }
            System.out.println();   // 换行


            // ==================== 7. 二维数组（表格数据） ====================
            // 语法：数据类型[][] 数组名 = new 数据类型[行数][列数];
            // 访问：数组名[行索引][列索引]

            System.out.println("\n===== 7. 二维数组：3个学生3门课成绩表 =====");

            // 3行（3个学生），3列（3门课：语文、数学、英语）
            int[][] gradeTable = {
                    {85, 92, 78},      // 第1个学生
                    {90, 88, 76},      // 第2个学生
                    {95, 89, 91}       // 第3个学生
            };

            System.out.println("学生\t语文\t数学\t英语");
            System.out.println("--------------------------------");

            // 遍历二维数组：外层控制行（学生），内层控制列（科目）
            for (int i = 0; i < gradeTable.length; i++) {           // 行数：gradeTable.length

                System.out.print("学生" + (i+1) + "\t");              // 打印学生编号

                for (int j = 0; j < gradeTable[i].length; j++) {    // 列数：gradeTable[i].length
                    System.out.print(gradeTable[i][j] + "\t");         // 打印每科成绩
                }
                System.out.println();   // 换行
            }

            // 访问特定元素：第2个学生的第3门课（数学）
            System.out.println("\n第2个学生数学成绩：" + gradeTable[1][1]);   // 行1列1（从0开始）
        }
    }
