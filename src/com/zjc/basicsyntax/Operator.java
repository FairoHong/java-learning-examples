package com.zjc.basicsyntax;

public class Operator {
    public static void main(String[] args) {

        // ==================== 1. 赋值运算符 = ====================
        // = 把右边的值存到左边变量里
        double applePrice = 5.5;        // 苹果单价5.5元
        int appleCount = 3;             // 买了3个苹果
        double bananaPrice = 3.0;       // 香蕉单价3元
        int bananaCount = 2;            // 买了2斤香蕉


        // ==================== 2. 基本算术运算符 + - * / % ====================
        // + 加法：计算苹果总价
        double appleTotal = applePrice * appleCount;    // 5.5 * 3 = 16.5

        // * 乘法：计算香蕉总价
        double bananaTotal = bananaPrice * bananaCount; // 3.0 * 2 = 6.0

        // + 加法：计算所有商品总金额
        double totalMoney = appleTotal + bananaTotal;   // 16.5 + 6.0 = 22.5

        // / 除法：计算平均每种水果花多少钱
        double average = totalMoney / 2;                // 22.5 / 2 = 11.25

        // % 取模（求余数）：凑整找零用，看22.5元里有几个10元，余多少
        int tenYuanCount = (int)(totalMoney / 10);      // 22.5 / 10 = 2（取整）
        double remainder = totalMoney % 10;             // 22.5 % 10 = 2.5（余数）


        // ==================== 3. ++ -- 自增自减运算符 ====================
        // ++ 自增：商品数量加1（顾客又拿了一个苹果）
        appleCount++;           // 原来是3，现在变成4（后置++，先使用原值再+1）

        // -- 自减：商品数量减1（顾客放下了一个香蕉）
        bananaCount--;          // 原来是2，现在变成1（后置--，先使用原值再-1）

        // 重新计算（演示++和--后的结果）
        int giftCount = 0;
        giftCount = ++appleCount; // 前置++，先+1再赋值：appleCount变成5，giftCount也是5


        // ==================== 4. 复合算术运算符 += -= *= /= %= ====================
        // += 加后赋值：满20元减5元优惠
        double payMoney = totalMoney;   // 应付金额先等于总金额22.5
        payMoney -= 5;                  // 等价于 payMoney = payMoney - 5;  22.5 - 5 = 17.5

        // *= 乘后赋值：VIP会员再享9折
        payMoney *= 0.9;                // 等价于 payMoney = payMoney * 0.9;  17.5 * 0.9 = 15.75


        // ==================== 5. 关系运算符 == != > < >= <= ====================
        // 结果都是true或false（布尔值）
        boolean isFree = (payMoney == 0);           // == 等于：15.75 == 0？ false（不免单）
        boolean hasDiscount = (totalMoney > 20);    // > 大于：22.5 > 20？ true（满足优惠条件）
        boolean isVip = (appleCount >= 5);          // >= 大于等于：5 >= 5？ true（买够5个算VIP）
        boolean needPay = (payMoney != 0);          // != 不等于：15.75 != 0？ true（需要付钱）


        // ==================== 6. 逻辑运算符 && || ! ====================
        // && 逻辑与：两边都要满足才为true
        boolean canGetGift = (totalMoney > 20) && (bananaCount > 0);
        // true && true = true（满20元且买了香蕉，可以送礼品）

        // || 逻辑或：满足一边就为true
        boolean hasQualification = (appleCount >= 5) || (totalMoney > 30);
        // true || false = true（买够5个苹果 或 消费超30元，满足抽奖资格）

        // ! 逻辑非：取反
        boolean notFree = !isFree;      // !false = true（不是免单）


        // ==================== 7. 条件运算符 ? : ====================
        // 条件 ? 值1 : 值2    条件true取值1，false取值2
        // 判断：满20元就免运费，否则运费5元
        double freight = (totalMoney > 20) ? 0 : 5;     // 22.5 > 20为true，所以freight = 0

        // 判断：应付金额大于15就显示"较贵"，否则显示"便宜"
        String priceLevel = (payMoney > 15) ? "较贵" : "便宜";  // 15.75 > 15为true，显示"较贵"


        // ==================== 8. 位运算符（了解） ====================
        // & 按位与、| 按位或（对二进制位操作，实际开发较少直接用）
        int a = 5;      // 二进制：101
        int b = 3;      // 二进制：011
        int c = a & b;  // 按位与：001 = 1（同为1才为1）
        int d = a | b;  // 按位或：111 = 7（有1就为1）


        // ==================== 输出所有结果 ====================
        System.out.println("========== 超市收银小票 ==========");
        System.out.println("苹果：" + applePrice + "元 × " + appleCount + "个 = " + (applePrice * appleCount) + "元");
        System.out.println("香蕉：" + bananaPrice + "元 × " + bananaCount + "斤 = " + (bananaPrice * bananaCount) + "元");
        System.out.println("----------------------------------");
        System.out.println("商品总金额：" + totalMoney + "元");
        System.out.println("优惠后应付：" + payMoney + "元");
        System.out.println("运费：" + freight + "元");
        System.out.println("----------------------------------");
        System.out.println("是否满足优惠条件：" + hasDiscount);
        System.out.println("是否VIP客户：" + isVip);
        System.out.println("能否获得礼品：" + canGetGift);
        System.out.println("是否有抽奖资格：" + hasQualification);
        System.out.println("价格档位：" + priceLevel);
        System.out.println("位运算演示（5&3=" + c + "，5|3=" + d + "）");
    }
}
