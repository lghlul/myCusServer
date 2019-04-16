package customer.supu.common.utils.exception;


	public class ServiceException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7590362629205668190L;

		/**
		 * 正常状态
		 */
		public static final int NORMAL_STATUS = ServiceExceptionConstants.NORMAL_STATUS;
		
		/**
		 * 正常状态，业务处理有报警，需弹出提示框
		 */
		public static final int WARNING_STATUS = ServiceExceptionConstants.WARNING_STATUS;
		
		/**
		 * 未知服务错误
		 */
		public static final int UNKNOWN_SERVICE_ERROR = ServiceExceptionConstants.UNKNOWN_SERVICE_ERROR;
		/**
		 * 信息验证错误
		 */
		public static final int VALIDATION_ERROR = ServiceExceptionConstants.VALIDATION_ERROR;
		/**
		 * 客户端错误
		 */
		public static final int CLIENT_ERROR = ServiceExceptionConstants.CLIENT_ERROR;

		private int errorcode = UNKNOWN_SERVICE_ERROR;
		
		private String msg = "";
		
		public ServiceException() {
			super();
		}

		public ServiceException(int code, String msg) {
			this.msg = msg;
			this.errorcode = code;
		}
		
		public ServiceException(int code, String msg, Throwable e) {
			super(e);
			this.msg = msg;
			this.errorcode = code;
		}

		public int getErrorcode() {
			return errorcode;
		}

		public void setErrorcode(int errorcode) {
			this.errorcode = errorcode;
		}
		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
	}

