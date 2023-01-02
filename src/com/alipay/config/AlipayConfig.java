package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000121689074";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDLcYZhzoYRFZKo5DMgOzV9aJ9afG1XqsI1KAvdiEyX1mIC7DfJlDqAFWjhRDgIPHRYFMUjF7a3dS1GwpVTYGQHJKltjA5rZgwjSJo8S08sJjSq5tx1OIIK63UbUllRmuV09YdMoNR4hXw1VCGUiIb7R4nGo5HMqrA9+APs3OWGgRtsaAD0sASFI/+R7WtWSSTQyt2eK03ZJZ8JCsc8oZHbrvu7YopNtHdN8WDfl0IQwkXXSN4ceFoMa4S40zSq6j3KQWvfJIePqRiGgch2ure3o/vXLVw+Xo5nrXf9vvLJeyVK5mhSCMYgvABIi9CguhZ7fgYqFv6bYMq1nRG92/qpAgMBAAECggEAAjgz2h9RsSAGIJeUwzZCKCMbEfanjrxLMB9Gud0B0OpC2XtQRH+8f6c8JLEE13opXsijOfXJRYkevFXlISq9DKLmwk4z3hIX8c6Z+CxuKbIlAvRP1WuPZ6UX+vtUBCLne/YtyrU6fDIgn8hSMXen2Vf3ddZVAeGe2J47FLt4OZZsBl1WS+qZL+jXdTFsqtpWOjQplQv9FtlUBqZuNpyvFdfLY6l5LTT7g11bXSyMcpJgyL7styP9roQt4iWDddUAxInSdH6clkzEwR+wq2FuxKqM3AWjqOs+x5L7kSMbGZsWc14SZ1FdUWrJ37mMWPB4y3j0Kl7IUehBge6Q+ePXbQKBgQDlcdnttGZcj6kY8g+6zG+TaLn4+sU2ks9pihLd9wBSgBMytUZ+bcKlr4Db0cBHBRj1ETsNM0h9QypzT3f7KjylzZS+UqS1R6ELO7sRXZNn685nw1aPvaX7gFM3+SLrtgn9IxHBDQKMVXA6k7bnSxZUSbwQHLMJB/XzTpznCDf0cwKBgQDi/UorJjAysoQUFViMRuT/IcANYVCPRudCwFOebQ0gYKoGFemeyVS9FhJzrY7KqrHH9Q/Ml0ztbrgnIq4StdxITtAgXe4Rr7x8UtofnwZRjRAb7bVBvZ9CxFl7xKMag3Ei+uNqQ1Ev2N0IefYu+mdYO99zQEBEGR5uEh5GeTJpcwKBgFp9f3yfVGuXARLkjM2YSTzy5b3LcTInzoOKQAyomMjw2CF8mvPL6COeRwzq+ZFI8mHczNRU8HbuoXRe2CwHqWme3dX+FBWmzV33zbx4kmU+++WyhZYlLqw1HR0LNfmOjvv188+WiPW90IhZr54i4AiYGAKmvvmF2Tt/OqRnemH/AoGAKzUhuCL1y8C1aYlCqLkaAAKxpxpeFlfdz5QClsaVWBNuaegj50jVq4SXEJP5+VQSsUhRsJUgXJXV0gVE82TQwKbX8UFP/uffzh6LTLedoUpjxZ0zAoeQ2Em96tRcY8CfeZQeU+zqeFwkfueQWBLsNxx2hV62nP/XDga+4pVRZkcCgYEAsjeQwB4dzuoA1rffrMoYM+ON4fgERszYJODeQkUM7jGpLykDSd6/oUZ6/QBXvFSlAUaApt1YN9noV3L05FikMyWNzKwOn937iGgQK079P7N8PrajJWz9vspopSeWMOwOROVbwhyb4WJzd8kfUuMCj2IalBuE/iGnpbj2CJhM8mM=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAleXK8f7hOfFETO6MUTiclTChuNhJoMHS2Wrw6MzF4dHipLMgWFQX6BQISCdIkJyETnD69QnYgZWLXXNfZC99gPAA/N7JRpJLSVYuZBu+aFTJR8FWkupJngbGCZmh2V+59uq8d6gF+PD4qz62t9WhjdI3x83m8mKRFuuGTkiD5+xkAwj75PbhN0oY7lSy2I6IpbQMU5Px6HUzbaBhUOLVsaJE8xpYrHh/EdozckAB81lCg+JO1pgmympkBEXivbAUTgZUe4Bpn22xVJcarwzLXfSRrNqcV+WDmAOiTd7H/FXeYQgzhrtWBaTHYBI8BG6dVcw5Co4qE2flhRB4aTMALwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://localhost:8080/demo1_war_exploded/notify_url.jsp";
    public static String notify_url = "http://localhost:8080/web_jpetStore_war_exploded/notifyUrl";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/web_jpetStore_war_exploded/returnUrl";
    //    public static String return_url = "https://blog.csdn.net/weixin_42425970/article/details/88980622";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




