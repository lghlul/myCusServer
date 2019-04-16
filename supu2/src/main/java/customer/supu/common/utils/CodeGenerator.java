package customer.supu.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Code生成工具类<br>
 *
 * @author 赵卉华
 * @version C01 2014-7-2
 * @since JESHING EBV001R001C01L01
 */
public class CodeGenerator
{
    /**
     * 随机数位数
     */
    private static final int NUMBER_LENGTH = 3;

    /**
     * 一小时的毫秒数
     */
    private static final int HOUR = 60 * 60 * 1000;

    /**
     * 随机数生成器
     */
    private static final Random RANDOM = new Random();

    /**
     * 上次的毫秒数
     */
    private static long last = 0;

    /**
     * 缓存一段时间的随机数, 以防止重复
     */
    private static Map<Integer, Boolean> cache = new HashMap<Integer, Boolean>();

    /**
     * 构造函数
     */
    private CodeGenerator()
    {

    }

    /**
     * 根据内容类型生成编号 2位类型+13位日期毫秒数+3位随机数
     *
     * @param codeType 内容类型, 见codeType
     * @return 内容编号
     */
    public static synchronized String geneCode(String codeType)
    {

        long millis = System.currentTimeMillis() / HOUR * HOUR;

        int n = (int)Math.pow(10, NUMBER_LENGTH);
        int random = 0;
        int number = 0;
        do
        {
            random = RANDOM.nextInt(HOUR); // 时间随机数
            number = RANDOM.nextInt(n); // 三数随机数

            // 缓存1小时内的随机数, 以防止重复
            if (last == millis)
            {
                int key = random * n + number;
                if (!cache.containsKey(key))
                {
                    cache.put(key, true);
                    break;
                }
            }
            else
            {
                last = millis;
                cache.clear();
            }
        }
        while (true);

        return String.format("%s%013d%03d", codeType, millis + random, number);
    }

    public static void main(String[] args)
    {
        for(int i = 0; i < 20; i ++)
        {
          //  System.out.println(geneCode(CodeType.ROLE));
        }
    }
}
