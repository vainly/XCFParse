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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-18 下午3:00
 */
public class RecipeParse {

    public void parse(Document doc){

        Element cook = doc.select("div[itemtype=http://schema.org/Recipe]").first();

        //标题
        Element title = cook.getElementsByAttributeValue("itemprop","name").first();
        String titleName = title.text();

        //img
        Element img = cook.select("div[class=cover image expandable block-negative-margin]").first().children().first();
        String imgUrl = img.attr("src");

        //简介
        Element desc = cook.select("div[class=desc]").first();
        String descStr = desc.text();

        //作者
        Element author = cook.select("div[class=author]").first().children().first();
        String authorUrl = author.attr("href");
        String authorName = author.attr("title");

        //用料
        Elements ings = cook.select("table[itemprop=ingredients]").first().children().first().children();
        List<Ingredient> ingList = this.parseIngredients(ings);


        //步骤
        Elements steps = cook.select("ol[itemprop=instructions]").first().children();
        List<Step> stepList = this.parseSteps(steps);

        //小贴士
        Element tip = cook.select("div[class=tip]").first();
        if(tip!=null){
            String tipStr = tip.text();
        }

        //cooking 对象信息
        Cooking ckg = new Cooking();
        String id = new IDCreater().getAutoIncID("cooking");

        ckg.setId(id);
        ckg.setName(titleName);
        ckg.setImgUrl(imgUrl);
        ckg.setAuthor(authorName);
        ckg.setAuthorUrl(authorUrl);
        ckg.setDescription(descStr);

        //存储cooking
        CookingService cookingService = new CookingServiceImpl();
        cookingService.save(ckg);

        //存储 ingredient
        IngredientService ingredientService = new IngredientServiceImpl();
        for(Ingredient ing : ingList){
            ing.setCookId(id);
            ingredientService.save(ing);
        }

        //存储step
        StepService stepService = new StepServiceImpl();
        for(Step step : stepList){
            step.setCookId(id);
            stepService.save(step);
        }
    }

    /**
     * 根据所给节点获取材料信息列表
     * @param ings
     * @return
     */
    public List<Ingredient> parseIngredients(Elements ings){
        List<Ingredient> list = new ArrayList<Ingredient>();
        for(Element ing : ings){
            //获取用料信息
            String ingName="",ingUrl="",unit="";

            Elements tds = ing.children();
            for(Element td : tds){
                if(td.className().equals("name has-border")){
                    Element a = td.children().first();
                    if(a!=null && a.tagName().equals("a")){
                        //材料名称、材料详情地址
                        ingName = a.text();
                        ingUrl = a.attr("href");
                    }else{
                        ingName = td.text();
                    }
                }
                if(td.className().equals("unit has-border")){
                    unit = td.text();
                }
            }

            Ingredient ingredient = new Ingredient();

            ingredient.setId(new IDCreater().getAutoIncID("ingredient"));
            ingredient.setName(ingName);
            ingredient.setUrl(ingUrl);
            ingredient.setUnit(unit);

            list.add(ingredient);
//            System.out.println("ing_name："+ingName+"  ingUrl："+ingUrl+"  unit："+unit);
        }

        return list;
    }


    /**
     * 根据所给节点获取步骤列表
     * @param steps
     * @return
     */
    public List<Step> parseSteps(Elements steps){

        List<Step> list = new ArrayList<Step>();
        int count = 1;
        for(Element step : steps){
            //com.cl.xcf.model.Step 属性
            String step_desc = "",step_url = "";

            Elements tds = step.children();
            for(Element td : tds){
                if(td.tagName().equals("p")){
                    step_desc = td.text();
                }
                if(td.tagName().equals("img")){
                    step_url = td.attr("src");
                }
            }

            Step s = new Step();
            s.setId(new IDCreater().getAutoIncID("step"));
            s.setSeq(count++);
            s.setText(step_desc);
            s.setImgUrl(step_url);

            list.add(s);
//            System.out.println("step_desc："+step_desc+"  step_url："+step_url);
        }
        return list;
    }
}
