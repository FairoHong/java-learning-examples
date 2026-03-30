package com.zjc.basicsyntax;

//条件语句案例：简易员工工资评定系统
public class ConditionalStatement {
    public static void main(String[] args) {

        // 定义员工基本信息
        String name = "李四";
        int workYears = 3;          // 工作年限
        double monthlyPerformance = 85.5;   // 月业绩（万元）
        int attendanceDays = 22;    // 出勤天数
        int totalDays = 22;           // 应出勤天数
        int jobLevel = 2;             // 职级：1-初级 2-中级 3-高级


        // ==================== 1. 基础if-else结构 ====================
        // 语法：if (条件) { 执行语句 } else { 执行语句 }
        // 作用：判断出勤，满勤有奖，不满勤扣钱

        double attendanceBonus = 0;

        if (attendanceDays == totalDays) {
            // 条件为true时执行这里
            attendanceBonus = 500;      // 满勤奖500元
            System.out.println("【if-else】恭喜" + name + "获得满勤奖500元");
        } else {
            // 条件为false时执行这里
            attendanceBonus = -200;       // 缺勤扣200元
            System.out.println("【if-else】" + name + "未全勤，扣200元");
        }


        // ==================== 2. 多重if结构（else if ladder） ====================
        // 语法：if (条件1) { } else if (条件2) { } else if (条件3) { } else { }
        // 作用：多个条件连续判断，业绩分档定提成比例

        double commissionRate = 0;      // 提成比例
        String performanceLevel = "";   // 业绩等级

        if (monthlyPerformance >= 100) {
            // 第一个条件满足就执行，后面不管
            commissionRate = 0.15;      // 15%提成
            performanceLevel = "优秀";
            System.out.println("【多重if】业绩≥100万，提成比例15%，等级：优秀");
        } else if (monthlyPerformance >= 80) {
            // 上面不满足，判断这个条件
            commissionRate = 0.10;      // 10%提成
            performanceLevel = "良好";
            System.out.println("【多重if】业绩≥80万，提成比例10%，等级：良好");
        } else if (monthlyPerformance >= 60) {
            // 上面都不满足，判断这个条件
            commissionRate = 0.05;      // 5%提成
            performanceLevel = "合格";
            System.out.println("【多重if】业绩≥60万，提成比例5%，等级：合格");
        } else {
            // 所有条件都不满足，执行这里
            commissionRate = 0;         // 无提成
            performanceLevel = "不合格";
            System.out.println("【多重if】业绩<60万，无提成，等级：不合格");
        }


        // ==================== 3. if嵌套结构 ====================
        // 语法：if (条件1) { if (条件2) { 语句 } }
        // 作用：大条件里套小条件，先判断年限，再判断业绩

        double yearsBonus = 0;

        if (workYears >= 2) {
            // 外层条件：工作满2年才有资格拿年限奖
            System.out.println("【if嵌套】工作满2年，进入年限奖评定...");

            if (monthlyPerformance >= 80) {
                // 内层条件：业绩还要≥80万
                yearsBonus = 1000;
                System.out.println("【if嵌套】且业绩≥80万，获得年限奖1000元");
            } else {
                // 内层条件不满足
                yearsBonus = 500;
                System.out.println("【if嵌套】但业绩<80万，获得年限奖500元");
            }

        } else {
            // 外层条件不满足
            System.out.println("【if嵌套】工作未满2年，无年限奖");
        }


        // 再演示一个多层嵌套：判断是否能晋升
        boolean canPromote = false;

        if (jobLevel < 3) {                     // 第1层：职级没到最高
            if (monthlyPerformance >= 90) {       // 第2层：业绩达标
                if (attendanceDays >= 20) {      // 第3层：出勤达标
                    canPromote = true;
                    System.out.println("【if嵌套】满足晋升条件：职级未封顶+业绩≥90万+出勤≥20天");
                }
            }
        }


        // ==================== 4. switch-case结构 ====================
        // 语法：switch(表达式) { case 值1: 语句; break; case 值2: 语句; break; default: 语句; }
        // 作用：根据职级定基本工资，比多重if更清晰

        double baseSalary = 0;

        switch (jobLevel) {
            case 1:                     // 如果jobLevel等于1
                baseSalary = 3000;
                System.out.println("【switch-case】职级1（初级），基本工资3000元");
                break;                  // 跳出switch，必须写，否则会"穿透"

            case 2:                     // 如果jobLevel等于2
                baseSalary = 5000;
                System.out.println("【switch-case】职级2（中级），基本工资5000元");
                break;

            case 3:                     // 如果jobLevel等于3
                baseSalary = 8000;
                System.out.println("【switch-case】职级3（高级），基本工资8000元");
                break;

            default:                    // 如果都不匹配，相当于else
                baseSalary = 2500;
                System.out.println("【switch-case】未知职级，按实习工资2500元");
                break;
        }


        // switch穿透现象演示（故意不写break，展示错误用法）
        System.out.println("\n===== switch穿透演示（错误示范）=====");
        int season = 2;     // 2代表春季

        switch (season) {
            case 1:
                System.out.println("冬季");
            case 2:
                System.out.println("春季");     // 匹配这里，执行
            case 3:
                System.out.println("夏季");     // 没有break，继续执行（穿透）
            case 4:
                System.out.println("秋季");     // 继续穿透执行
            default:
                System.out.println("未知季节");  // 继续穿透执行
        }
        // 结果会输出：春季、夏季、秋季、未知季节（因为case 2后没有break）


        // ==================== 计算最终工资 ====================
        double commission = monthlyPerformance * 10000 * commissionRate;    // 业绩提成
        double totalSalary = baseSalary + commission + attendanceBonus + yearsBonus;


        // ==================== 输出工资条 ====================
        System.out.println("\n========== " + name + "的工资条 ==========");
        System.out.println("基本工资（switch定）：" + baseSalary + "元");
        System.out.println("业绩提成（多重if定）：" + commission + "元");
        System.out.println("考勤奖扣（if-else定）：" + attendanceBonus + "元");
        System.out.println("年限奖金（if嵌套定）：" + yearsBonus + "元");
        System.out.println("----------------------------------");
        System.out.println("实发工资：" + totalSalary + "元");
        System.out.println("业绩等级：" + performanceLevel);
        System.out.println("晋升资格：" + (canPromote ? "有" : "无"));
    }
}
