package learn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-3-3 上午11:46
 */
public class ZuiTest {
    public static void main(String[] args){
        String url = "http://tieba.baidu.com/p/1785168609?see_lz=1";
        try{
            Document doc = Jsoup.connect(url).get();
//            System.out.println(doc);
            Element element = doc.getElementsByAttributeValue("id","post_content_22962144151").first();
            Element content = doc.select("div[class=p_postlist]").first();
            System.out.println("["+element.attr("class")+"]");

            Elements list = content.select("div[class=p_content]");
            System.out.println(list.size());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
