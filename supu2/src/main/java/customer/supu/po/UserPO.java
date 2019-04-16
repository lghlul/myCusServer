package customer.supu.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserPO {
    private String name;//用户姓名
    private String phone;//用户手机号
    private String org;//分组的编号-查询的时候加上去，在不在实体表中--区分是会员还是普通注册用户--1是会员2是普通用户
    private String id;//主键ID
    
    
    
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPO(String name, String phone, String org, String id) {
		super();
		this.name = name;
		this.phone = phone;
		this.org = org;
		this.id = id;
	}

    
    
    
}