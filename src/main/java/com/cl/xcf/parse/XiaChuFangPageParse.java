package com.cl.xcf.parse;

import com.cl.xcf.model.Cooking;
import com.cl.xcf.model.Ingredient;
import com.cl.xcf.model.Step;
import com.cl.xcf.service.CookingService;
import com.cl.xcf.service.IngredientService;
import com.cl.xcf.service.StepService;
import com.cl.xcf.service.impl.CookingServiceImpl;
import com.cl.xcf.service.impl.IngredientServiceImpl;
import com.cl.xcf.service.impl.StepServiceImpl;
import com.cl.xcf.util.IDCreater;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-13 下午4:21
 */
public class XiaChuFangPageParse {

    public void parse(String url){
        try{
            Document doc = Jsoup.connect(url).get();
//            this.parse(doc);
        }catch(IOException e){
            System.out.println("com.cl.xcf.parse.XiaChuFangPageParse.parse 网络通讯异常！");
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        String url = "http://www.xiachufang.com/recipe/1064357/";

        XiaChuFangPageParse pageParse = new XiaChuFangPageParse();
        pageParse.parse(url);
    }
}
