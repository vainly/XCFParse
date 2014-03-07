package com.cl.xcf.parse;

import com.cl.xcf.model.Recipe;
import com.cl.xcf.util.IDCreater;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对该（http://www.xiachufang.com/category/40076/?page=1）链接进行
 * 数据抓取，并封装成对象存入数据库
 *
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-18 下午2:58
 */
public class CategoryParse {

    public boolean parse(String url) throws IOException {
        boolean ret = true;

        Document doc = Jsoup.connect(url).get();

        Element ul = doc.select("ul[class=list]").first();
        List<Recipe> recipeList = new ArrayList<Recipe>();

        Elements lis = ul.children();
        if(lis.size()==0){
            System.out.println("已对当前链接["+url+"]解析完毕,解析下一个链接");
            return false;
        }
        for(Element li : lis ){
            Element category = li.select("div[class=info pure-u]").first();
            recipeList.add(createNewRecipe(category));
        }

        System.out.println(recipeList.size());


        return true;
    }

    /**
     * 对指定的节点进行数据提取，并分装成Recipe对象返回
     * @param e  指定节点对象
     * @return   返回封装完成的 recipe对象
     */
    public Recipe createNewRecipe(Element e){

        //名称、链接
        Element info = e.select("p[class=name]").first().children().first();
        String name = info.text();
        String url = info.attr("href");

        //得分
        Element stats = e.select("p[class=stats]").first().children().first();
        Double score = Double.parseDouble(stats.text());

        //作者
        Element author = e.select("p[class=author]").first();
        String author_name = author.text();

        Recipe recipe = new Recipe();

        recipe.setId(new IDCreater().getAutoIncID("recipe"));
        recipe.setName(name);
        recipe.setUrl(url);
        recipe.setScore(score);
        recipe.setAuthor(author_name);

        return recipe;
    }

    public static void main(String[] args) throws IOException {
        String url = "http://www.xiachufang.com/category/40076/?page=100";
        new CategoryParse().parse(url);
    }
}
