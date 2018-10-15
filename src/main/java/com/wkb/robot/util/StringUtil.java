package com.wkb.robot.util;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    static Map<String, Integer> numberMap = new HashMap<String, Integer>();

    static {
        numberMap.put("0", 0);
        numberMap.put("零", 0);
        numberMap.put("1", 1);
        numberMap.put("一", 1);
        numberMap.put("壹", 1);
        numberMap.put("2", 2);
        numberMap.put("二", 2);
        numberMap.put("贰", 2);
        numberMap.put("3", 3);
        numberMap.put("三", 3);
        numberMap.put("叁", 3);
        numberMap.put("4", 4);
        numberMap.put("四", 4);
        numberMap.put("肆", 4);
        numberMap.put("5", 5);
        numberMap.put("五", 5);
        numberMap.put("伍", 5);
        numberMap.put("6", 6);
        numberMap.put("六", 6);
        numberMap.put("陆", 6);
        numberMap.put("7", 7);
        numberMap.put("七", 7);
        numberMap.put("柒", 7);
        numberMap.put("8", 8);
        numberMap.put("八", 8);
        numberMap.put("捌", 8);
        numberMap.put("9", 9);
        numberMap.put("九", 9);
        numberMap.put("玖", 9);
        numberMap.put("10", 10);
        numberMap.put("十", 10);
        numberMap.put("拾", 10);
    }

    static Map<String, Character> operatorMap = new HashMap<String, Character>();

    static {
        operatorMap.put("+", '+');
        operatorMap.put("加", '+');
        operatorMap.put("-", '-');
        operatorMap.put("减", '-');
        operatorMap.put("*", '*');
        operatorMap.put("乘", '*');
        operatorMap.put("/", '/');
        operatorMap.put("除", '/');
    }

    public static String file2String(File file) {
        Long size = file.length();
        byte[] buff = new byte[size.intValue()];
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            is.read(buff);
            return new String(buff, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String parseTbCaptchaAnswer(String yzm) {
        String[] strs = yzm.split("请选择：");
        int sum = 0;
        if (strs.length == 2) {
            String problem = strs[0].trim();
            int length = problem.length();
            int number1 = 0;
            int number2 = 0;
            char operator = 0;
            boolean b = false;
            for (int i = 0; i < length; i++) {
                String key = String.valueOf(problem.charAt(i));
                if (numberMap.get(key) == null && operatorMap.get(key) == null) {
                    break;
                }

                if (numberMap.get(key) != null) {
                    int temp = numberMap.get(key);
                    int tempSum = b ? number2 : number1;
                    if (temp == 10) {
                        tempSum = tempSum == 0 ? temp : tempSum * 10;
                    } else {
                        tempSum = tempSum > 9 ? tempSum + temp : tempSum * 10 + temp;
                    }

                    if (b) {
                        number2 = tempSum;
                    } else {
                        number1 = tempSum;
                    }

                } else {
                    operator = operatorMap.get(key);
                    b = true;
                }

            }
            sum = operator(number1, operator, number2);
            String[] answers = strs[1].trim().split(";");
            length = answers.length;
            for (int i = 0; i < length; i++) {
                String answer = answers[i].trim();
                String abs = "+";
                int number = 0;
                for (int j = 1; j < answer.length(); j++) {
                    String temp = String.valueOf(answer.charAt(j));
                    if (" ".equals(temp)) {
                        continue;
                    }
                    if ("-".equals(temp) || "负".equals(temp)) {
                        abs = "-";
                        continue;
                    }
                    int tempNumber = numberMap.get(temp);
                    if (tempNumber == 10) {
                        number = number == 0 ? tempNumber : number * tempNumber;
                    } else {
                        number = number > 9 ? tempNumber + number : number * 10 + tempNumber;
                    }
                }
                if ("-".equals(abs)) {
                    number = number * -1;
                }
                if (sum == number) {
                    return answer.substring(0, 1);
                }
            }
        }
        return "";
    }

    private static int operator(int a, char opeartor, int b) {
        int sum = 0;
        switch (opeartor) {
            case '+':
                sum = a + b;
                break;
            case '-':
                sum = a - b;
                break;
            case '*':
                sum = a * b;
                break;
            case '/':
                sum = a / b;
                break;
        }
        return sum;
    }

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str) || "null".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static boolean isNoEmpty(String str) {
        return !isEmpty(str);
    }

    /*都不为空时返回true*/
    public static boolean areNotEmpty(String... str) {
        for (String val : str) {
            if (isEmpty(val))
                return false;
        }
        return true;
    }

    /**
     * @param str     需要处理的字符串
     * @param formate 自定义的规则 如:formate="indexOf:dfdf;length:5;get:[a-zA-z0-9]"
     * @return
     */
    public static String getStringByFormate(String str, String formate) {
        String[] formates = formate.split(";");
        String billo = str == null ? "" : str;
        for (int i = 0; i < formates.length; i++) {
            int spilt = formates[i].indexOf(":");
            String formate_temp = formates[i].substring(0, spilt);
            String result_temp = formates[i].substring(spilt + 1);
            if ("indexOf".equalsIgnoreCase(formate_temp)) {
                billo = billo.substring(billo.indexOf(result_temp) + result_temp.length());
                continue;
            }
            if ("length".equalsIgnoreCase(formate_temp)) {
                billo = billo.substring(0, Integer.parseInt(result_temp));
                continue;
            }
            if ("get".equalsIgnoreCase(formate_temp)) {
                billo = getString(billo, result_temp, true);
            }
        }
        return billo.toString();
    }

    /**
     * @param str     需要处理的字符串
     * @param matches 通过验证的正则表达式
     * @param isLink  是否获取连续的字符串
     * @return
     */
    public static String getString(String str, String matches, boolean isLink) {
        str = str.trim();
        int length = str.length();
        String result = "";
        boolean isLink_temp = false;
        for (int i = 0; i < length; i++) {
            String temp = str.substring(i, i + 1);
            if (temp.matches(matches)) {
                if (isLink) {
                    if (isLink_temp || "".equals(result)) {
                        result += temp;
                    } else {
                        break;
                    }
                } else {
                    result += temp;
                }
                isLink_temp = true;
            } else {
                isLink_temp = false;
            }
        }
        return result.trim();
    }

    /**
     * 通过指定的规则判断某值在某范围 如>=0.05&&<=8
     *
     * @param str   = >=0.05&&<=8
     * @param value
     * @return
     */
    public static boolean compareByFormate(String str, float value) {
        String[] formates = null;
        int type = 0;
        if (str.indexOf("&&") != -1) {
            formates = str.split("&&");
            type = 1;
        } else if (str.indexOf("||") != -1) {
            formates = str.split("||");
            type = 2;
        } else {
            formates = new String[1];
            formates[0] = str;
        }

        boolean flags[] = new boolean[2];
        for (int i = 0; i < formates.length; i++) {
            String formate = formates[i];
            String number = getString(formate, "[-0-9.]", true);
            String key = formate.substring(0, formate.length() - number.length());
            flags[i] = parseSwitch(value, Float.parseFloat(number), key);
        }
        if (formates.length == 1) {
            return flags[0];
        } else {
            if (type == 1)
                return flags[0] && flags[1];
            else
                return flags[0] || flags[1];
        }
    }

    private static Map<String, Integer> typesMap = new HashMap<String, Integer>();

    static {
        typesMap.put(">", 1);
        typesMap.put("<", 2);
        typesMap.put("=", 3);
        typesMap.put(">=", 4);
        typesMap.put("<=", 5);
    }

    private static boolean parseSwitch(float value, float key, String types) {
        boolean flag = false;
        int type = 0;
        type = typesMap.get(types);
        switch (type) {
            case 1:
                if (value > key) {
                    flag = true;
                }
                break;
            case 2:
                if (value < key) {
                    flag = true;
                }
                break;
            case 3:
                if (value == key) {
                    flag = true;
                }
            case 4:
                if (value >= key) {
                    flag = true;
                }
                break;
            case 5:
                if (value <= key) {
                    flag = true;
                }
                break;
        }
        return flag;
    }

    /**
     * 根据字段名从类获取其值
     *
     * @param obj
     * @param name
     * @return
     */
    public static Object field(Object obj, String name) {
        Object t_obj = null;
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            t_obj = field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t_obj;
    }

    /**
     * 单位倍数转换
     *
     * @param initial 原始值
     * @param mult    转换倍数
     * @return 计算结果字符串返回
     */
    public static String convertUnit(String initial, double mult) {
        try {
            return "" + Double.parseDouble(initial) * mult;
        } catch (NumberFormatException e) {
            return "";
        }
    }

    /**
     * 毫秒数转化为日期格式
     *
     * @param milli 毫秒数
     * @return 日期(yyyy-MM-dd)
     */
    public static String convertMilliseconds(String milli) {
        String dateStr = "";
        if (isNoEmpty(milli)) {
            dateStr = parseDate(new Date(Long.parseLong(milli)), "yyyy-MM-dd");
        }
        return dateStr;
    }

    /**
     * 日期(date)转化为字符串
     *
     * @param date   日期
     * @param format 转化格式
     * @return 转化后日期字符串
     */
    public static String parseDate(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                java.text.DateFormat df = new SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
        }
        return result;
    }

    // 计算加密信息
    public static String calcEncInfo(String preauth, String softKey, String uname, String upwd) {
        // 压缩软件KEY为8字节，用作DES加密的KEY
        byte[] key16 = hexString2ByteArray(softKey);
        byte[] key8 = new byte[8];
        for (int i = 0; i < 8; i++) {
            key8[i] = (byte) ((key16[i] ^ key16[i + 8]) & 0xff);
        }

        try {
            byte[] pwd_data = upwd.getBytes("utf-8");
            java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
            md5.update(pwd_data, 0, pwd_data.length);
            String pwd_md5_str = byteArray2HexString(md5.digest()); // 转为16进制字符串

            String enc_data_str = preauth + "\n" + uname + "\n" + pwd_md5_str;

            SecureRandom sr = new SecureRandom();
            DESKeySpec dks = new DESKeySpec(key8);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
            byte[] resultData = cipher.doFinal(enc_data_str.getBytes());
            return byteArray2HexString(resultData);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 16进制字符串转为BYTE数组
    public static byte[] hexString2ByteArray(String hexStr) throws NumberFormatException {
        int len = hexStr.length();
        if (len % 2 != 0)
            throw new NumberFormatException();

        byte[] result = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            String s = hexStr.substring(i, i + 2);
            int n = Integer.parseInt(s, 16);
            result[i / 2] = (byte) (n & 0xff);
        }

        return result;
    }

    // 转化BYTE数组为16进制字符串
    public static String byteArray2HexString(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            String s = Integer.toHexString(b & 0xff);
            if (s.length() == 1) {
                sb.append("0" + s);
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    /**
     * 将post数据或者get数据的输出流，转成httpClient的form的条件xml
     *
     * @param data ADAPTER_TYPE=JSON_TYPE >>>><input name='ADAPTER_TYPE'
     *             value='JSON_TYPE' />
     * @return
     */
    public List<String> parseUrlParamsToParamsXml(String data) {
        String[] datas = data.split("&");
        for (int i = 0; i < datas.length; i++) {
            String[] tempNameAndValue = datas[i].split("=");
            String result = "";
            if (tempNameAndValue.length > 1) {
                result = "<input name='" + tempNameAndValue[0] + "' value='" + tempNameAndValue[1] + "' />";
                System.out.println(result);
            } else {
                result = "<input name='" + tempNameAndValue[0] + "' value='' />";
                System.out.println(result);
            }

        }
        return null;
    }

    /**
     * 将中文转化为前缀带"%u"的unicode格式
     *
     * @param strText 中文
     * @return
     */
    public static String string2HexString(String strText) {
        char c;
        String strRet = "";
        int intAsc;
        String strHex;
        for (int i = 0; i < strText.length(); i++) {
            c = strText.charAt(i);
            intAsc = (int) c;
            if (intAsc > 128) {
                strHex = Integer.toHexString(intAsc);
                strRet += "%u" + strHex;
            } else {
                strRet = strRet + c;
            }
        }
        return strRet;
    }

    /**
     * 将前缀带"%u"的unicode格式转化为中文
     *
     * @return
     */
    public static String unicodeToString(String str) {
        Pattern pattern = Pattern.compile("(%u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 将前缀"&#"带十进制unicode转换中文
     *
     * @param dataStr
     * @return
     */
    public static String decodeUnicode(final String dataStr) {
        String regExp = "&#\\d*;";
        Matcher m = Pattern.compile(regExp).matcher(dataStr);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String s = m.group(0);
            s = s.replaceAll("(&#)|;", "");
            char c = (char) Integer.parseInt(s);
            m.appendReplacement(sb, Character.toString(c));
        }
        m.appendTail(sb);
        // System.out.println(sb.toString());
        return sb.toString();
    }

    public static String urlDecode(String dataStr, String charset) throws UnsupportedEncodingException {
        return URLDecoder.decode(dataStr, charset);
    }

    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    // 首字母转大写
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    //日期格式转换
    public static String dateFormat (Date date,String formatStr){
        if(formatStr==null || "".equals(formatStr)){
            formatStr="yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);

        return sdf.format(date);
    }

    //true 为空 false 不为空
    public static boolean checkjsonValueEmpty(JSONObject json ,String key){
        boolean result = false;
        if(json==null || json.isEmpty()){
            result = true;
        }

        if(!json.containsKey(key) || json.get(key)==null  || "".equals(json.get(key))){
            result = true;
        }

        return result;
    }

    public static String getCarCode(String carCode){
        StringBuffer code = new StringBuffer("");
        if(StringUtil.isNoEmpty(carCode)){
            char[] codeArr = carCode.toCharArray();
            for(char temp:codeArr){
                int acs = Integer.valueOf(temp);
                if(acs >=65 && acs<=90 || acs>=97 && acs<=122 || acs>=48 && acs<=57){
                    code.append(temp);
                }
            }
        }
        return code.toString() ;
    }

    //产生指定范围内的随机数
    public static int intNum(int start, int end) {
        return (int) (Math.random() * (end - start));
    }

    //随机产生手机号码
    public static String getMobile() {
        String[] tel = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
        String first = tel[intNum(0, tel.length - 1)];
        String second = String.valueOf(intNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(intNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    public static void main(String[] args){
        System.out.println(getMobile());
    }

    /**
     * 获取出生日期
     *
     * @param idcard
     * @return
     */
    public static String getSexcode(String idcard) {

        String birth = idcard.substring(6, 14);

        String sexcode = "";
        String sex = "";
        if (idcard.length() == 15) {
            sex = idcard.substring(14, 15);
        } else {
            sex = idcard.substring(16, 17);
        }

        if (Integer.parseInt(sex) % 2 == 0) {
            sexcode = "F";//女
        } else {
            sexcode = "M";//男

        }
        return sexcode;
    }

    /**
     * 获取出生日期
     *
     * @param idcard
     * @return
     */
    public static String getBithday(String idcard) {

        String birth = idcard.substring(6, 10) + "-" + idcard.substring(10, 12) + "-" + idcard.substring(12, 14);

        return birth;
    }

}
