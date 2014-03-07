package learn.morphia;

import com.cl.xcf.model.Cooking;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import learn.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.EntityInterceptor;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.mapping.cache.EntityCache;

import java.net.UnknownHostException;
import java.util.Collection;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午1:42
 */
public class MorphiaTest {

    private Mongo mongo;
    private Morphia morphia;

    @Before
    public void init(){
        try{
            mongo = new MongoClient();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (MongoException e){
            e.printStackTrace();
        }
        morphia = new Morphia();
    }

    @Test
    public void morphia(){
        Datastore ds = morphia.createDatastore(mongo,"test");
        print(ds);
        //model to DBObject
        print("model to DBObject : "+morphia.toDBObject(new User(System.currentTimeMillis(),"vainly",true,25,"beijing")));

        //将已知参数转换成对象
        User user =morphia.fromDBObject(User.class, BasicDBObjectBuilder.start("sex", true).get());
        print(user.toString());

        //返回一个映射对象
        Mapper mapper = morphia.getMapper();
        print("mapper : "+mapper);
        //将model添加到映射对象列表
        morphia.map(User.class);
        morphia.map(Cooking.class);

        //判断次对象是否被映射实例
        print("Is mapper : " + morphia.isMapped(User.class));
        print("Is mapper : " + morphia.isMapped(Cooking.class));

        print("===================================================");
    }

    @Test
    public  void mapper(){
        Mapper mapper = morphia.getMapper();

        //添加映射对象 等价于 morphia.map(Class);
        print("add model mapped ："+mapper.addMappedClass(User.class));

        //创建缓存
        EntityCache ec =  mapper.createEntityCache();

        //String cn = mapper.getCollectionName("myTestDB");
        //print("collection name : " + cn);
        //query primary key
        User user = new User(System.currentTimeMillis(),"vainly",true,18,"shanghai");
        print("user id : "+ mapper.getId(user));

        Collection<EntityInterceptor> eis =  mapper.getInterceptors();
        print("collection size : "+eis.size());
        for(EntityInterceptor ei : eis){
            print("EntityInterceptor : "+ ei);
        }
    }


    public void print(Object o){
        if(o!=null){
            System.out.println(o.toString());
        }
    }
}
