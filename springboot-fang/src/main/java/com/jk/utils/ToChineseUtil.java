package com.jk.utils;

/**
 * 数字转换汉字工具类
 */
public class ToChineseUtil {

    /**
     * 数字转换为汉字
     * @param getMoney
     * @return
     */
    public static String toChinese(Double getMoney){
        String[] cnChar={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        double shuzi=getMoney;
        long a=(int)shuzi;
        String[] cnUtuis={"","十","百","千","万","十","百","千","亿"};
        String [] cnDecianls={"角","分","毫"};
        String str=a+" ";//数字转换成字符串的最简单方法
        String result=" ";	//直接加一个空字符
        //str.length返回的是字符的个数
        //循环从0~str的字符个数减1
        //System.out.println(str);
        byte zeroNum=0;//连续零的个数
        int q=0;
        for (int i=str.length()-2,j=0,e=1;i>=0;i-- ) {
            char NumChar=str.charAt(i);//返回字符串的第i个位置的字符。
            //System.out.println(NumChar);
            //如果当前的位置是零的话无需添加单
            //if(j==4*e+1){
            //	result=cnchar[NumChar-48]+cnUtuis[j]+cnDanwei[e-1]+result;
            //}
            if(NumChar=='0') {
                zeroNum++;
                if(zeroNum<2){
                    //如果有两个以上的连续零时将当做一个零
                    if(j==4){
                        result=cnUtuis[j]+result;
                    }else{
                        result=cnChar[NumChar-48]+result;
                    }
                }else{
                    q++;//省略的0个数；
                }
            }else{
                result=cnChar[NumChar-48]+cnUtuis[j]+result;
                zeroNum=0;
            }
            j++;
        }
        if(result.length()>str.length()-q-1){
            result=result.substring(0, result.length()-2);
        }else if(result.length()>str.length()-q-1){
            result=result.substring(0,result.length()-2);
        }
        //小数部分
        String result1=" ";
        float decimalsPlace=(float)(shuzi-a);
        String decianlsChar=decimalsPlace+" ";
        decianlsChar =decianlsChar.substring(2,decianlsChar.length()-1);
        for(int i=0;i<decianlsChar.length();i++){
            char NumChar=decianlsChar.charAt(i);
            if(NumChar!='0'){
                result1+=cnChar[NumChar-48]+cnDecianls[i];
            }
        }
        result=result+result1;
        return result;
    }
}
