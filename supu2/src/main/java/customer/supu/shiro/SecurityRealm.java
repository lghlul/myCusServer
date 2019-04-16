package customer.supu.shiro;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.corba.se.impl.util.Utility;

import customer.supu.dao.EmployeeDao;
import customer.supu.po.Employee;
import customer.supu.po.EmployeeExample;


@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm{

	/*@Autowired
	private FileImgUploadService fileImgUploadService;*/

	@Autowired
	private EmployeeDao employeeDao;

    /**
     * 日志对象
     */
    private final static Logger log = LoggerFactory.getLogger(SecurityRealm.class);

	/**
	 * 权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//
//		//获取凭证
//		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
//
//        try {
//
//        	 // 角色名的集合
//            Set<String> roles = new HashSet<String>();
//            // 权限名的集合
//            Set<String> permissions = new HashSet<String>();
//
//        	//根据loginname (eCode)获取该用户的  所有角色
//        	List<Role>  roleList=roleService.selectAllByList(shiroUser.loginName);
//
//        	for(Role role:roleList){
//        		//角色
//        		roles.add(role.getRolecode());
//        		//根据角色no获取所有权限
//        	 	List<Permission> permissionsList=permissionService.selectAllPermissionByRoleNo(role.getRoleno());
//        	    for (Permission permission : permissionsList) {
//                    // 添加权限
//                	if(StringUtils.hasText(permission.getPermissioncode())){
//                		permissions.add(permission.getPermissioncode());
//                	}
//                }
//        	}
//
//        	authorizationInfo.setStringPermissions(permissions);
//        	authorizationInfo.setRoles(roles);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
////            log.error("获取员工权限错误", e);
//		}
		return authorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//获取员工号
		String eCode = String.valueOf(token.getPrincipal());
		Employee user=null;
		//User user=null;

		try {
			EmployeeExample employeeExample=new EmployeeExample();

			//必须是后台登陆人员
			employeeExample.createCriteria().andEcodeEqualTo(eCode).andFlagEqualTo(1).andIsbackEqualTo(1);
			List<Employee> l_user=employeeDao.selectByExample(employeeExample);
			if (CollectionUtils.isNotEmpty(l_user)) {
		           user= l_user.get(0);
		    }

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		//用户验证
		if (user == null) {
			throw new UnknownAccountException();//用户不存在
		}

		//员工账号已停用
//		if(!EmployeeStatusEnum.OK.getCode().equals(employee.getStatus())) {
//			throw new DisabledAccountException();//账号已经停用
//		}
		//shrio用户
		ShiroUser shiroUser=new ShiroUser(Long.valueOf(user.getEmployeeid()), user.getEcode());
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser, user.getPassword(), getName());

		return authenticationInfo;



	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840022L;
		public Long employeeId;
		public String loginName;

		public ShiroUser(Long employeeId, String loginName) {
			this.employeeId = employeeId;
			this.loginName = loginName;
		}

		public Long getEmployeeId() {
			return employeeId;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ShiroUser other = (ShiroUser) obj;
			if (loginName == null) {
				if (other.loginName != null) {
					return false;
				}
			} else if (!loginName.equals(other.loginName)) {
				return false;
			}
			return true;
		}
	}


}
