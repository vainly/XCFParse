import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 测试url是否有效
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-18 下午5:15
 */
public class UrlConnectionTest {

    @Test
    public void test() {
        String url_str = "http://www.xiachufang.com/category/40076/?page=1";
        try{
            URL url = new URL(url_str);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            int state = con.getResponseCode();
            System.out.println("请求响应码："+state);
        }catch (MalformedURLException e){
            System.out.println("该URL["+url_str+"]格式有误.");
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("网络链接异常，请");
            e.printStackTrace();;
        }
    }
}
