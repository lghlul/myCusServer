package customer.supu.common.utils.pay.pay.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;
import customer.supu.domain.EmployeeBuyPri;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import customer.supu.jenum.CourseTypeEnum;
import customer.supu.po.Order;
import customer.supu.service.MemberCardService;





public class NotifyServlet extends HttpServlet {


	private Logger logger = Logger.getLogger(NotifyServlet.class);

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberCardService memberCardService;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取ServletContext 再获取 WebApplicationContextUtils
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext context =
                WebApplicationContextUtils.getWebApplicationContext(servletContext);
        memberCardService = (MemberCardService) context.getBean("memberCardService");
    	System.out.println("memberCardService="+memberCardService);

		String postStr=null;
        try{
            postStr=this.readStreamParameter(request.getInputStream());
            postStr = new String(postStr.getBytes("GBK"), "UTF-8"); //add by maming 2013-12-09 ������ת�룬ϵͳ�Ὣ���뵱XMl���н���������ϵͳ����
        }catch(Exception e){
            e.printStackTrace();
        }

        if (null!=postStr&&!postStr.isEmpty()){

            //�Է��ص���Ϣ�Ƚ���XML�ĸ�ʽ��
            Document document=null;
            try{
                document = DocumentHelper.parseText(postStr);
            } catch(Exception e) {
                e.printStackTrace();
            }
            if(null==document){
                this.print(response, "");
                return;
            }
            Element root=document.getRootElement();
            String result_code = String.valueOf(root.elementText("result_code"));
            String return_code = String.valueOf(root.elementText("return_code"));

		if ("SUCCESS".equals(result_code)) {
			if ("SUCCESS".equals(return_code)) {

				//支付成功的回调，在此处处理内部业务逻辑
				// �̻�������
				String out_trade_no = String.valueOf(root.elementText("out_trade_no"));
				System.out.println("out_trade_no="+out_trade_no);
				// �Ƹ�ͨ������
				// ���,�Է�Ϊ��λ

				// �����ʹ���ۿ�ȯ��discount��ֵ��total_fee+discount=ԭ�����total_fee


				// ֧�����ʱ��

				//totalClass；courseId
				// �ж�ǩ����
				if ("SUCCESS".equals(result_code)) {
					System.out.println("订单id="+out_trade_no.split("_")[0]);
					String order_id=out_trade_no.split("_")[0];
					try {
						Order record =new Order();
						record.setOrdernumber(order_id);
						Order order=memberCardService.selectOrder(record);
						System.out.println("order=="+order);

						System.out.println("order_id=="+order_id);
						if(null !=order && null !=order.getType()){
							System.out.println("type=="+order.getType());
							if(order.getType()==0){//购买会员卡
								//HttpSession session = request.getSession(true);
								//System.out.println("notifyservlet中的session="+session.getAttribute("session"));
							//	System.out.println("notifyservlet中的empid="+session.getAttribute("employeeId"));
								memberCardService.employeeBuyCard(order.getUserid(), order_id,order.getCid());

							}else if(order.getType()==1){//1：购买私教课
								logger.info("buypri order=" + JSON.toJSONString(order));
								//课程id
								//memberCardService.employeeBuyCourse(order.getCid(), CourseTypeEnum.PRICOACH.getCode(), order.getTotalclass(), order_id, order.getUserid(),order.getIsexperience(),null,null);
								//memberCardService.employeeBuyCourse(order.getCid(), order.getType(), order.getTotalclass(), out_trade_no, request.getSession());
								EmployeeBuyPri employeeBuyPri = new EmployeeBuyPri();
								employeeBuyPri.setUserId(order.getUserid());
								employeeBuyPri.setCourseId(order.getCid());
								employeeBuyPri.setCoachId(order.getCoachId());
								employeeBuyPri.setTotalClass(order.getTotalclass());
								//只记录第一次购买时间
								//employeeBuyPri.setBuyTime(System.currentTimeMillis());
								//状态 1 未完成 2已完成
								employeeBuyPri.setStatus((byte)1);
								memberCardService.userBuyCourse(employeeBuyPri , order_id);
							}else if(order.getType()==2){//2：购买精品团课
								System.out.println("进入精品团课课="+order.getType());
								memberCardService.employeeBuyCourse(order.getCid(), CourseTypeEnum.COURSEGROUP.getCode(), null, order_id,order.getUserid(),null,order.getStartdate(),order.getEnddate());
							}else if(order.getType()==3){//3：购买工作室
								System.out.println("进入工作室="+order.getType());
								memberCardService.employeeBuyCourse(order.getCid(), CourseTypeEnum.STUDIO.getCode(), order.getTotalclass(), order_id, order.getUserid(),null,null,null);
							}

						}
					} catch (Exception e) {
						System.out.println("getMessage=="+e.getMessage());
						//throw new Exception(e.getMessage());
					}

					// ------------------------------
					// 即时到账处理业务开始
					// ------------------------------
					// 处理数据库逻辑
					// 注意交易单不要重复处理
					// 注意判断返回金额
					// ------------------------------
					// 即时到账处理业务完毕
					// ------------------------------

					System.out.println("success ��̨֪ͨ�ɹ�");
					// ��Ƹ�ͨϵͳ���ͳɹ���Ϣ���Ƹ�ͨϵͳ�յ��˽����ٽ��к���֪ͨ
					this.print(response,"success");
				} else {// sha1ǩ��ʧ��
					System.out.println("fail -SHA1 failed");
					this.print(response,"fail");
				}

			} else {// MD5ǩ��ʧ��
				System.out.println("fail -Md5 failed");
			}
		}
        }

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	//����������ȡpost����
    private String readStreamParameter(ServletInputStream in){
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader=null;
        try{
            reader = new BufferedReader(new InputStreamReader(in));
            String line=null;
            while((line = reader.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(null!=reader){
                try {
                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }


  //������˷��ͷ������
    private void print(HttpServletResponse response, String content){
        try{
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(content);
            response.getWriter().flush();
            response.getWriter().close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
