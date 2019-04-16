package customer.supu.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

//
public class CustomDateConverter implements Converter<String,Date>{

	 private static final SimpleDateFormat[] sdf = new SimpleDateFormat[]
			    {new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), new SimpleDateFormat("yyyy-MM-dd HH:MM"),
			            new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat("HH:mm:ss"), new SimpleDateFormat("HH:mm")};

	public Date convert(String source) {

        if (StringUtils.isEmpty(source))
            return null;
        Date value = null;
        for (SimpleDateFormat s : sdf)
        {
            try
            {
                value = s.parse(source);
            }
            catch (ParseException e)
            {
                // ignore
            }
            if (value != null)
                break;
        }
        return value;
	}

	/*@Override
	public Date convert(String source) {

		if(StringUtils.isNotEmpty(source)){
			//实现 将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			try {
				//转成直接返回
				return simpleDateFormat.parse(source);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//如果参数绑定失败返回null
		return null;
	}*/

}
