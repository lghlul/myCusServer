package customer.supu.appoint;


import java.util.Hashtable;

/**
 * @CLassName AppointManage
 * @Description TODO
 * @Author ll
 * @Date 2018/11/6 10:36
 **/
public class AppointManage {


    private static Hashtable<Integer , AppointThread> threadMap = new Hashtable();


    public static void putThread(int id , AppointThread appointThread){
        threadMap.put(id , appointThread);
        appointThread.start();
    }

    public static AppointThread getThread(int id){
        return threadMap.get(id);
    }

    public static void removeThread(int id){
        AppointThread appointThread = threadMap.get(id);
        if(appointThread != null){
            appointThread.interrupt();
            threadMap.remove(id);
        }

    }
}
