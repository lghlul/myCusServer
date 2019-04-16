package customer.supu.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import customer.supu.common.utils.ThreadDemo1.CarBigHouse.Car;

public class ThreadDemo1 {
    /**
     * 姑且卖车的当做是生产者线程
     */
    public static class CarSeller implements Runnable {

        private CarBigHouse bigHouse;

        public CarSeller(CarBigHouse bigHouse) {
            this.bigHouse = bigHouse;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {// 当做生产者线程，往仓库里边增加汽车，其实是触发增加汽车
                int count = bigHouse.put();
                System.out.println("生产汽车-->count = " + count);
            }
        }
    }

    /**
     * 姑且买车的人当做是消费者线程
     */
    public static class Consumer implements Runnable {

        private CarBigHouse bigHouse;

        public Consumer(CarBigHouse bigHouse) {
            this.bigHouse = bigHouse;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {// 当做消费者线程，从仓库里边提取汽车，其实是触发，从仓库里边提取一辆汽车出来
                int count = bigHouse.get();
                System.out.println("消费汽车-->count = " + count);
            }
        }
    }

    /**
     * 这边姑且当做是车子big house放车子的仓库房
     */
/*    public static class CarBigHouse {

        public int carNums = 0;// 这边是仓库房子中车子的数量总数
        public List<Car> carList = new ArrayList<Car>();// 这边模拟用来放汽车的list

        public int put() {// 提供给生产者放汽车到仓库的接口
            Car car = CarFactory.makeNewCar();
            carList.add(car);// 加到仓库中去
            carNums++;// 总数增加1
            return carNums;
        }

        public int get() {// 提供给消费者从这边取汽车接口
            Car car = null;
            if (carList.size() != 0) {// size不为空才去取车
                car = carList.get(carList.size() - 1);// 提取最后一个car
                carList.remove(car);// 从车库list中移除掉
                carNums--;// 总数减少1
            }
            return carNums;
        }*/


    public static class CarBigHouse {

        public int carNums = 0;// 这边是仓库房子中车子的数量总数
        public List<Car> carList = new ArrayList<Car>();// 这边模拟用来放汽车的list

        // 直接增加上synchronized关键字方式，成员方法，锁的是当前bigHouse对象
        // 这种锁是互斥锁，方法在同一个时刻，只有一个线程可以访问到里边的代码
        /*public synchronized int put() {// 提供给生产者放汽车到仓库的接口
            Car car = CarFactory.makeNewCar();
            carList.add(car);// 加到仓库中去
            carNums++;// 总数增加1
            return carNums;
            return carNums;
        }

        public synchronized int get() {// 提供给消费者从这边取汽车接口
            Car car = null;
            if (carList.size() != 0) {// size不为空才去取车
                car = carList.get(carList.size() - 1);// 提取最后一个car
                carList.remove(car);// 从从库list中移除掉
                carNums--;// 总数减少1
            }
            return carNums;
        }*/

        //Lock提供了比synchronized方法和synchronized代码块更广泛的锁定操作，Lock更灵活的结构，有很大的差别，并且可以支持多个Condition对象 Lock是控制多个线程对共享资源进行访问的工具。通常，锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁， 线程开始访问共享资源之前应先获得Lock对象。不过某些锁支持共享资源的并发访问，如：ReadWriteLock（读写锁），在线程安全控制中， 通常使用ReentrantLock（可重入锁）。使用该Lock对象可以显示加锁、释放锁。
        final ReentrantLock lock=new ReentrantLock();

        public int put() {// 提供给生产者放汽车到仓库的接口
            //上锁
            lock.lock();
            try{
                Car car = CarFactory.makeNewCar();
                carList.add(car);// 加到仓库中去
                carNums++;// 总数增加1
            }finally{
                //释放锁
                lock.unlock();
            }
            return carNums;

        }

        public int get() {// 提供给消费者从这边取汽车接口
            //上锁
            lock.lock();
            try{
                Car car = null;
                if (carList.size() != 0) {// size不为空才去取车
                    car = carList.get(carList.size() - 1);// 提取最后一个car
                    carList.remove(car);// 从车库list中移除掉
                    carNums--;// 总数减少1
                }
            }finally{
                //释放锁
                lock.unlock();
            }
            return carNums;
        }

        public static class Car {

            public String carName;// 汽车名称

            public double carPrice;// 汽车价格

            public Car() {
            }

            public Car(String carName, double carPrice) {
                this.carName = carName;
                this.carPrice = carPrice;
            }
        }
    }

    /**
     * 采用静态工厂方式创建car对象，这个只是简单模拟，不做设计模式上的过多考究
     */
    public static class CarFactory {

        private CarFactory() {
        }

        public static Car makeNewCar(String carName, double carPrice) {
            return new Car(carName, carPrice);
        }

        public static Car makeNewCar() {
            return new Car();
        }
    }


    public static void main(String[] args) {
        CarBigHouse bigHouse = new CarBigHouse();
        new Thread(new CarSeller(bigHouse)).start();
        new Thread(new Consumer(bigHouse)).start();
	}
}
