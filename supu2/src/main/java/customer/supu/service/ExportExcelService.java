package customer.supu.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface ExportExcelService {

	/**
	 * 选中的   数据并导出
	 * @param ids  预约的id
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public Map<String, Object> exportExcel(String ids, HttpServletResponse response) throws IOException;

}
