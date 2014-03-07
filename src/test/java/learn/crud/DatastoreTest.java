package learn.crud;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import learn.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;
import java.util.List;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午2:45
 */
public class DatastoreTest {

    private Mongo mongo;
    private Morphia morphia;
    private Datastore ds;

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
        morphia.map(User.class);
        ds = morphia.createDatastore(mongo,"temp");
    }

    private void query(){
        Iterable<User> it = ds.createQuery(User.class).fetch();
        while (it.iterator().hasNext()){
            System.out.println("fetch:"+it.iterator().next());
        }
    }

    public void testAdd(){
        User user = new User(System.currentTimeMillis(),"vainly",true,18,"shanghai");
        ds.save(user);
        this.query();
    }

    @Test
    public void testQuery(){
        List<User> userList = ds.find(User.class).field("name").contains("vainly").asList();
        for(User user : userList){
            System.out.println(user.toString());
        }
        System.out.println(userList.size());
    }

    public void getUserByKey(String id){
    }

    @After
    public void destory(){
        mongo = null;
        morphia = null;
        ds = null;
        System.gc();
    }
}
