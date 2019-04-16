package customer.supu.common.utils.wx.common;

public interface Constant {
	
	public interface wechatServiceName{
		static String TOKEN = "token";
		
		static String ACCESS_TOKEN = "access_token";
		
		static String GETCALLBACKIP = "getcallbackip";
		
		static String TICKET = "ticket";
		
		/** 临时素材*/
		static String MEDIA = "media";
		/** 永久素材*/
		static String MATERIAL = "material";
		/** 自定义菜单*/
		static String MENU = "menu";
		/** 用户分组*/
		static String GROUPS = "groups";
		/** 消息提送*/
		static String MESSAGE = "message";
		
		static String USER = "user";
		/** 客服接口*/
		static String CUSTOMSERVICE = "customservice";
		
		static String PAY = "pay";
	}
	
	public interface wechatOpName{
		static String GETTICKET = "getticket";
		
		static String UPLOAD = "upload";
		
		/** 上传永久素材*/
		static String ADD_MATERIAL = "add_material";
		
		/** 获取素材总数*/
		static String GET_MATERIALCOUNT = "get_materialcount";
		
		static String BATCHGET_MATERIAL = "batchget_material";
		
		/** 创建*/
		static String CREATE = "create";
		
		/** 查询*/
		static String GET = "get";
		
		/** 修改*/
		static String UPDATE = "update";
		
		/** 删除*/
		static String DELETE = "delete";
		
		/** 获取永久素材*/
		static String GET_MATERIAL = "get_material";
		/** 添加图文消息*/
		static String ADD_NEWS = "add_news";
		
		/** 移动单个用户到指定分组*/
		static String MEMBERS_UPDATE = "/members/update";
		
		/** 移动多个用户到指定分组*/
		static String MEMBERS_BATCHUPDATE = "/members/batchupdate";
		
		/** 查询用户所在分组*/
		static String GETID = "getid";
		
		/** 消息发送*/
		static String MASS_SEND = "/mass/send";
		
		static String MASS_GET = "/mass/get";
		
		static String MASS_DELETE = "/mass/delete";
		/** 分组发送*/
		static String MASS_SENDALL = "/mass/sendall";
		
		static String INFO = "info";
		
		/** 创建客服*/
		static String KFACCOUNT_ADD ="/kfaccount/add";
		
		/** 修改客服*/
		static String KFACCOUNT_UPDATE = "/kfaccount/update";
		
		/** 删除客服*/
		static String KFACCOUNT_DEL = "/kfaccount/del";
		
		/** 获取客服信息*/
		static String GETKFLIST = "getkflist";
		
		/** 客服发送信息*/
		static String CUSTOM_SEND = "/custom/send";
		
		static String UNIFIEDORDER = "unifiedorder";
			
	}
}
