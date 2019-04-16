package customer.supu.common.po;

import java.io.Serializable;
import java.util.List;

public class PageResponse  implements Serializable {
	   private static final long serialVersionUID = 768549219446295665L;
	    private Integer total;  //总条数
	    private Object records; //当前页显示数据

	    private Integer resultCode;//返回码

	    private String message;//返回信息


		public PageResponse(){

		}

	public PageResponse(Integer resultCode,String message,Object records){
			this.resultCode = resultCode;
			this.message = message;
			this.records = records;
	}

	public PageResponse(Integer resultCode,String message ){
		this.resultCode = resultCode;
		this.message = message;
	}
	    

		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Integer getResultCode() {
			return resultCode;
		}
		public void setResultCode(Integer resultCode) {
			this.resultCode = resultCode;
		}
		public Integer getTotal() {
			return total;
		}
		public void setTotal(Integer total) {
			this.total = total;
		}
		public Object getRecords() {
			return records;
		}
		public void setRecords(Object records) {
			this.records = records;
		}
}
