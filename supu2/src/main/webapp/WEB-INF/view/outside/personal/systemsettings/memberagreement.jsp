<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>速扑健身</title>
		<meta content="email=no" name="format-detection">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.c8292720754131608eb0fac6964f4be0.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/weui.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/jquery-weui.min.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/index.css">
		<style>
			.leui-font-size-md{
				font-size: 3.5vw;
			}
			.weui-article .title {
    			font-size: 6vw;
    			font-weight: 400;
			}
			.weui-article h3 {
    			font-weight: 400;
    			font-size: 4vw;
    			line-height: 2.5em;
			}
			.weui-article p {
    			font-weight: 400;
    			font-size: 3.4vw;
    			line-height: 1.5em;
			}
			.leui-right-content {
    			padding: 0 10px;
			}
		</style>
	</head>

<body>
		<div class="leui-head-bar leui-head-top hide">
			<div class="leui-head-left">
				<a href="javascript:history.back();" class="header-back">返回</a>
				<div class="left-arrow"></div>
			</div>
		</div>
		<div class="leui-content leui-container-top weui-row weui-no-gutter">
			<div class="leui-left-nav weui-col-33">
				<div class="weui_cells">
					<div class="weui_cell switch-tab action" data-target="article-card">
						<div class="weui_cell_bd weui_cell_primary">
							<p class="leui-font-size-md">会员卡协议</p>
						</div>
					</div>
					<div class="weui_cell switch-tab" data-target="article-pt">
						<div class="weui_cell_bd weui_cell_primary">
							<p class="leui-font-size-md">私教课程协议</p>
						</div>
					</div>
					<div class="weui_cell switch-tab" data-target="article-camp">
						<div class="weui_cell_bd weui_cell_primary">
							<p class="leui-font-size-md">训练营协议</p>
						</div>
					</div>
					<div class="weui_cell switch-tab" data-target="article-yoga">
						<div class="weui_cell_bd weui_cell_primary">
							<p class="leui-font-size-md">SP瑜伽主题馆课程购买协议</p>
						</div>
					</div>
					<div class="weui_cell switch-tab" data-target="article-bbs">
						<div class="weui_cell_bd weui_cell_primary">
							<p class="leui-font-size-md">SP-Training协议</p>
						</div>
					</div>
					<!-- <div class="weui_cell switch-tab" data-target="article-CrossFit">
						<div class="weui_cell_bd weui_cell_primary">
							<p class="leui-font-size-md">CrossFit协议</p>
						</div>
					</div>
					<div class="weui_cell switch-tab" data-target="article-X-Training">
						<div class="weui_cell_bd weui_cell_primary">
							<p class="leui-font-size-md">X-Training协议</p>
						</div>
					</div> -->
				</div>
			</div>
			<div class="leui-right-content weui-col-66">
				<article class="weui-article" id="article-card" style="display: block;">
					<section>
						<h2 class="title">会员卡协议</h2>
						<section>
							<h3>一、会员卡</h3>
							<p>1、速扑运动采用会员制服务模式，只有取得会员方能享受中心的各项专业健身服务及相关配套服务。</p>
							<p>2、取得会员资格应办理入会手续，并已知晓中心有关健身的规则与警示，承诺遵守中心的相关规定。</p>
							<p>3、因经营管理需要，中心可能会针对不同客户办理不同类别的电子会员卡，但无论您持有何种电子会员卡，都将在享受会员权利的同时，受到本协议的约束。</p>
							<p>4、本协议所称“会员”是指年满16周岁未满60周岁身体健康并向中心缴纳了全部会费，能如实提供和陈述个人信息，取得本中心发放的电子会员卡的人士。因此您有义务对入会时所提供资料的真实性、合法性负责。</p>
						</section>
						<section>
							<h3>二、电子会员卡的取得方式</h3>
							<p>1、原始取得，指的是在速扑运动各分店和加盟店预售期间办理入会手续并缴纳会费后取得会员资格，以及在微信公众账号“Spartner速扑运动”注册、填写真实、有效、全面的个人资料，办理入会手续并缴纳会费后取得会员资格。</p>
							<p>2、继受或转让取得，指在本协议约定的特殊事由出现时，通过办理一定的手续，由非会员的第三方取得会员资格，原会员资格终止。</p>
						</section>
						<section>
							<h3>三、电子会员卡的管理</h3>
							<p>1、会员卡仅供会员本人使用（体验卡除外），一经售出，概不退换。</p>
							<p>2、年卡及以上会员因个人原因确实无法继续使用会员卡，提供双方身份资料证明后经市场营销部同意可将会员资格转让，但每张卡只限转让一次，并且一次性收取原卡价的20%手续费。其他卡种不能转让或变相出售。</p>
							<p>3、任何未经门店同意并办理变更手续的会员私自向非会员转让会籍资格的行为均无效，中心将不予接待，并取消其会籍资格。</p>
							<p>4、严重违反中心规章制度者，中心有权取消其会籍资格并不予退还剩余费用。</p>
							<p>5、速扑运动会员卡原则上不接受停卡（购买年卡及以上用户可享受一次停卡机会，最长一个月时间）特殊情况如：怀孕、受伤请与工作人员联系，需提供医院证明。</p>
						<!-- 	<p>6、速扑健身会员卡原则上不接受停卡（购买年卡用户可享受一次停卡机会）特殊情况如：怀孕、受伤请在微信公众号留言，需提供医院证明。</p>
							<p>7、会员卡生效日期：有效期从购卡付款成功后开始计时。</p> -->
						</section>
						<!-- <section>
							<h3>四、会员权利</h3>
							<p>1、依照所持卡的类别享受相应的中心对该类持卡会员作出的全部服务承诺；私教、训练营、X-Training会员、CrossFit、乐瑜伽主题馆、速扑健身社区等服务的，承诺内容分别参见附件1-6；</p>
							<p>2、针对中心的服务，会员有提出批评、投诉及改进建议的权利；</p>
							<p>3、期满后会员有优先续约的权利；</p>
							<p>4、会员在付款当月可以申请开具全额订单发票，过期不予开具</p>

						</section> -->
						<section>
							<h3>四、会员义务</h3>
							<p>1、如实向速扑运动工作人员提供个人信息资料，并在资料发生变动后及时通知相关人员。</p>
							<p>2、进入健身中心时凭电子会员卡，随时接受工作人员验证和抽查。</p>
							<p>3、严禁未预约课程，强行进入操房上操课。</p>
							<p>4、严禁携带十六岁以下儿童进入健身区域，对于擅自进入健身区域造成伤害或损失的，本中心概不负责。</p>
							<p>5、严禁在健身区内吸烟、进食。</p>
							<p>6、严禁携带宠物进入健身中心。</p>
							<p>7、严禁心肺功能疾病、脊椎病、皮肤病及一切传染病患者进入健身中心，有以上疾病的患者隐瞒病情取得会员资格的，健身中心有权终止其资格，并保留追究其法律责任的权利。</p>
							<p>8、运动前严禁饮酒或饮用含酒精类饮料，因违反本条规定造成的人身伤害等意外情况，本中心概不负责。</p>
							<p>9、禁止会员在中心内销售任何商品，不得参与任何营利性健身指导，违反本条规定的，速扑运动中心有权取消其会员资格。</p>
							<p>10、本中心原则上不接受60岁以上老人入会，能出具真实有效的健康证明者除外，但因隐瞒或错报个人健康信息发生的一切责任都由其本人承担。</p>
							<p>11、会员在健身时必须正确使用各种健身器械，否则出现任何人身伤害中心概不负责。</p>
							<p>12、会员应自觉爱惜合理使用室内各项设施、设备、使用后须归放原位，禁止将室内各项设施、设备擅自带出场馆，如有损坏，丢失须追究相关人员责任，照价赔偿。</p>
							<p>13、严禁在中心内大声喧哗，使用污秽语言以及一切违法活动。</p>
							<p>14、健身中心内禁止吸烟、吐痰、乱扔垃圾，请自觉维护中心的环境卫生。</p>
							<!-- <p>16、严禁在中心内大声喧哗，使用污秽语言以及一切违法活动。</p>
							<p>17、健身中心内禁止吸烟、吐痰、乱扔垃圾，请自觉维护中心的环境卫生。</p> -->
						</section>
					<!-- 	<section>
							<h3>六、权利保留</h3>
							<p>1、健身中心营业时间原则上24小时，营业时间有变动，会在无线公众账号后台以及门店做显著位置公示，会员须遵守该营业时间。</p>
							<p>2、因国家政策或者法律法规的规定，中心有权合理修改营业时间并在店内公示，恕不另行通知会员，该公示即视为通知。</p>
							<p>3、因经营管理需要，中心有权调整、增减部分项目，该行为不视为违约，且在店内公示后即视为通知，无需另行报告给会员个人。</p>
							<p>4、因器械、设备（设施）检修、维护，中心有权在某一时间段对某一项目或某类项目采取停用或限用措施。</p>
							<p>5、其他出于会员安全及集体利益的需要，中心有权采取必要措施以恢复经营秩序。</p>
						</section> -->
						<section>
							<h3>五、免责条款</h3>
							<p>出现下列情形的，中心不予承担任何责任</p>
							<p>1、遇不可抗力（如战争、自然灾害等）造成中心营业终止或会员会籍不能继续，致使会员遭受损失</p>
							<p>2、会员所受损害是因其自身故意或过失造成的；</p>
							<p>3、会员所受损害是中心工作人员以外的任何第三方的故意或过失行为导致的；</p>
							<p>4、非会员不听劝阻，擅自进入或强行进入会员区域造成损害的，由其自身或致害方承担责任；</p>
							<p>5、受害方严重违反中心制定的规章制度所造成损害的；</p>
							<p>6、未由会员或会员随同人员个人保管的贵重物品发生毁损、灭失、遗失的；</p>
							<p>7、因会员资料或个人信息发生变动未及时工作人员，从而造成损失或会员权利受限的；</p>
							<p>8、未听从中心工作人员指导，擅自使用或违反操作规程使用器械、设备造成自身受伤的，由自身负责；造成他人受损或中心财产毁损的，其本人应承担全部赔偿责任，对此本中心不承担任何责任。</p>
							<p>9、因会员自身行为不当或会员之间的争议产生的人身和财产损失，本中心不承担责任。</p>
						</section>
						<!-- <section>
							<h3>八、安全提示</h3>
							<p>1、会员在锻练前，应先做必要的热身练习，以免受伤。</p>
							<p>2、过度锻炼及违规锻炼均有受伤的可能，所以您在运动前对自身身体情况进行判断，并保持运动强度和时间的适当。</p>
							<p>3、对违反本协议约定从而造成物品丢失及人员伤亡的，本中心不承担任何法律责任。</p>
							<p>4、健身馆内任何运动项目及器械设施均有严格的操作方法和程序，请务必在专业人员的指导下或者安全手册下进行操作，如有违背致使人员受损，中心不承担任何责任。</p>
							<p>5、会员进行任何单项或器械的操作均应在知晓操作方法及注意事项后进行，同时充分注意自身的身体状况及承受能力，否则因此发生任何损害，本健身中心均不承担责任。</p>
						</section> -->
						<!-- <section>
							<h3>九、特别声明</h3>
							<p>在法律允许的范围内，为更好地服务会员之需要，中心有权对相关内容进行修改，且修改后的条款自通知会员或在中心网站、APP，微信公众号或其他传播渠道显著位置公示后，即对全体会员产生约束力。</p>
						</section>
						<section>
							<h3>十、会员承诺</h3>
							<p>1、本人保证所提供的入会资料及个人信息真实有效；</p>
							<p>2、本人身体健康且没有本协议约定的不适合进行运动的疾病；</p>
							<p>3、本人已阅读、理解并同意上述条文。</p>
						</section> -->
						<section>
							<h3>六、其他</h3>
							<p>如果会员和中心因协议的履行发生争议，双方首先应当协商解除，如果协商不成的，任何乙方均可以向南京市栖霞区人民法院起诉解决争议。</p>
						</section>
					</section>
				</article>
				<article class="weui-article" id="article-pt" style="display: none;">
					<section>
						<h2 class="title">私教卡协议</h2>
						<section>
							<h3>一、私教课程</h3>
							<p>1、速扑健身采用会员制服务模式，只有购买私教课程方能享受私人教练的各项专业健身服务及速扑健身相关配套服务。</p>
							<p>2、取得私教会员资格应在线完成购买流程，并已知晓速扑健身私教平台有关的规则与系统操作规则，承诺遵平台的相关规定。</p>
							<p>3、因经营管理需要，中心可能会针对不同会员健身需要办理不同类别的私教课程，但无论您购买何种私教课程，都将在享受私教会员权利的同时，受到本协议的约束。</p>
							<p>4、本协议所称“会员”是指年满16周岁未满60周岁身体健康并向中心购买了了私教课程，能如实提供和陈述个人信息，取得本中心发放的电子私教课程的人士。因此您有义务对入会时所提供资料的真实性、合法性负责。</p>
						</section>
						<section>
							<h3>二、电子私教课程的取得方式</h3>
							<p>原始取得，指在微信公众账号“速扑健身健身”或APP注册、填写真实、有效、全面的个人资料，办理课程购买手续并支付费用后取得会员资格。</p>
						</section>
						<section>
							<h3>三、电子私教课程的管理 </h3>
							<p>1、私教课程仅供会员本人使用，一旦售出，非不可抗因素不予退课；在教练及会员双方沟通允许的前提下可以转让。因学员问题要转让课程的情况，将不享受购买时的优惠，将按照课程原价进行课程流转，差价需由学员自行承担；教练或平台因素需要更换教练的情况，课程流转同样享受购买时的优惠价格。</p>
							<p>2、严重违反平台规章制度者，平台有权取消其私教课程资格并不予退还剩余费用。</p>
							<p>3、私教课程结束后，若会员没有继续购买课程，平台系统自动取消该会员的私教会员权限，私教会员资格终止。</p>
						</section>
						<section>
							<h3>四、会员权利</h3>
							<p>1、依照所购买的私教课程类别享受相应的平台对私教会员作出的全部服务承诺； </p>
							<p>2、针对私教的服务，会员有提出批评、投诉及改进建议的权利； </p>
						</section>
						<section>
							<h3>五、会员义务</h3>
							<p>1、如实向速扑健身私教平台提供个人信息资料，并在资料发生变动后及时通知后台。</p>
							<p>2、严禁携带十六岁以下儿童进入健身区域，对于擅自进入健身区域造成伤害或损失的，平台概不负责。</p>
							<p>3、平台不接受怀孕期间/有重大疾病/病愈后没有医生证明的会员购买课程，平台有权无条件退款退课。</p>
							<p>4、严禁在健身区内吸烟、进食、吐痰、乱扔垃圾，请自觉维护健身房的环境卫生。</p>
							<p>5、严禁携带宠物进入场馆。</p>
							<p>6、严禁心肺功能疾病、脊椎病、皮肤病及一切传染病患者在没有医师书面准许的情况下进入健身区域，有以上疾病的患者隐瞒病情取得会员资格的，健身中心有权终止其资格，并保留追究其法律责任的权利。</p>
							<p>7、为了您的健身安全，请穿着运动服饰、运动鞋参加运动，不得赤裸上身或穿着不得体的服饰进行运动。否则工作人员有权劝离并取消当日运动权利。</p>
							<p>8、运动前严禁饮酒或饮用含酒精类饮料，因违反本条规定造成的人身伤害等意外情况，平台概不负责。</p>
							<p>9、禁止会员在运动场馆内销售任何商品，不得参与任何营利性健身指导，违反本条规定的，速扑健身场馆有权取消其私教会员资格。</p>
							<p>10、平台原则上不接受60岁以上老人及怀孕期用户购买私教课程，能出具真实有效的健康证明者除外，但因隐瞒或错报个人健康信息发生的一切责任都由其本人承担。</p>
							<p>11、会员应自觉爱惜合理使用室内各项设施、设备、使用后须归放原位，如有损坏须照价赔偿。</p>
							<p>12、严禁在场馆内大声喧哗，使用污秽语言以及一切违法活动。</p>
						</section>
						<section>
							<h3>六、教练职责</h3>
							<p>1、了解学员的健康状况及训练需求，定制科学的训练计划 </p>
							<p>2、在约定训练时间内为学员提供专业的健身服务。</p>
							<p>3、每次训练前后为学员说明训练规划和目的。 </p>
							<p>4、在约定时间内给私教会员传授健身健康、营养及自我保健知识。</p>
							<p>5、在约定时间内提高私教会员的体质和体格水平。 </p>
							<p>6、和私教会员协定训练时间，准时开课，按时完成教学任务。</p>
						</section>
						<section>
							<h3>七、训练时间变更</h3>
							<p>1、如果私教会员希望变更原定训练时间，须在预约的课程时间开始前2小时前提出；如因学员因素造成旷课，未按时完成课程，系统会自动结算当节课时费用。</p>
							<p>2、训练时间一旦确定，健身教练会按时等候私教会员。如果会员迟到，迟到的时间将不获补偿，训练时间不会延长，将于原定时间结束。</p>
						</section>
						<section>
							<h3>八、教练变更</h3>
							<p>1、如果健身教练休假或离职，平台将为私教会员重新安排健身教练，完成剩余次数。</p>
							<p>2、私教会员不能随意更换健身教练，如需更换健身教练必须向本中心书面提出申请说明原因，如确需更换健身教练，须经此协议三方和新健身教练协商后签署更换健身教练同意书。</p>
						</section>
						<section>
							<h3>九、会员承诺</h3>
							<p>1、本人保证所提供的入会资料及个人信息真实有效；</p>
							<p>2、本人身体健康且没有本协议约定的不适合进行运动的疾病；</p>
							<p>3、本人已阅读、理解并同意上述条文。</p>
							<p>4、未入驻速扑健身私教平台的用户在速扑健身场馆内都不能进行长时间的教学指导。包括朋友、亲人之间的过长时间互相指导，一般超过30分钟，持续性的教学动作平台都默认等同于黑私教学行为。</p>
						</section>
						<section>
							<h3>十、特别声明</h3>
							<p>在法律允许的范围内，平台对该协议约定的内容有最终解释权，同时为更好地服务会员之需要，中心有权对相关内容进行修改，且修改后的条款自通知会员或在中心网站、APP，微信公众号或其他传播渠道显著位置公示后，即对全体会员产生约束力。</p>
						</section>
					</section>
				</article>
				<article class="weui-article" id="article-camp" style="display: none;">
					<section>
						<h2 class="title">训练营协议</h2>
						<section>
							<h3>学员需知：</h3>
							<p>学员在参加训练时要按照健身教练的计划进行训练，如果未按照健身教练的指导进行练习所受的伤害以及负面的效果，学员自行承担责任；客人需完全明了并在健康状况安全问答表上签名，不得有隐瞒，否则发生任何相关安全问题，本公司及健身教练概不负责任。</p>
						</section>
						<section>
							<h3>我们建议有以下病史者不宜报名：</h3>
							<p>1.心脏疾病患者请勿参加该训练营课程；</p>
							<p>2.患有严重膝盖等关节问题请询医，征医生同意后选择性参加训练，并提前告知授课教练；</p>
							<p>3.手术恢复期内请勿参加该训练营课程；</p>
							<p>4.高血压患者请慎重选择该训练营课程；</p>
							<p>5.训练营课程仅供会员本人使用，一经售出，概不退换。</p>
							<p>6.训练过程中有任何身体不适需要立即停止训练，并及时告知教练；</p>
							<p>健身学员确认FIT60健身教练一概不提供任何医疗咨询（只提供健身技巧方面的咨询帮助）。</p>
							<p>如健身学员自认为有必要须在开始训练前自行寻求医学咨询，并根据自身的情况和健身教练协商选择合适的健身计划，健身教练将在授课时对客人提供健身技巧建议，但学员须对自己选择的健身方式负责。</p>
							<p>本人已经完全阅读以上内容，明白相关责任及风险，并遵守相关课程及教练要求参加训练。</p>
						</section>
					</section>
				</article>
				<article class="weui-article" id="article-camp" style="display: none;">
					<section>
						<h2 class="title">训练营协议</h2>
						<section>
							<h3>学员需知：</h3>
							<p>学员在参加训练时要按照健身教练的计划进行训练，如果未按照健身教练的指导进行练习所受的伤害以及负面的效果，学员自行承担责任；客人需完全明了并在健康状况安全问答表上签名，不得有隐瞒，否则发生任何相关安全问题，本公司及健身教练概不负责任。</p>
						</section>
						<section>
							<h3>我们建议有以下病史者不宜报名：</h3>
							<p>1.心脏疾病患者请勿参加该训练营课程；</p>
							<p>2.患有严重膝盖等关节问题请询医，征医生同意后选择性参加训练，并提前告知授课教练；</p>
							<p>3.手术恢复期内请勿参加该训练营课程；</p>
							<p>4.高血压患者请慎重选择该训练营课程；</p>
							<p>5.训练营课程仅供会员本人使用，一经售出，概不退换。</p>
							<p>6.训练过程中有任何身体不适需要立即停止训练，并及时告知教练；</p>
							<p>健身学员确认FIT60健身教练一概不提供任何医疗咨询（只提供健身技巧方面的咨询帮助）。</p>
							<p>如健身学员自认为有必要须在开始训练前自行寻求医学咨询，并根据自身的情况和健身教练协商选择合适的健身计划，健身教练将在授课时对客人提供健身技巧建议，但学员须对自己选择的健身方式负责。</p>
							<p>本人已经完全阅读以上内容，明白相关责任及风险，并遵守相关课程及教练要求参加训练。</p>
						</section>
					</section>
				</article>
				<article class="weui-article" id="article-yoga" style="display: none;">
					<section>
						<h2 class="title">乐瑜伽主题馆课程购买协议</h2>
						<section>
							<h3>一、会员卡</h3>
							<p>1、速扑健身乐瑜伽主题馆所有课程均采用会员制服务模式，只有购买相关课程课时的会员才能享受场馆的各项专业课程及相关配套服务。</p>
							<p>2、通过购买会员卡取得会员资格，应办理入会手续并填写个人健康档案书，并已知晓主题馆有关健身的规则与警示，承诺遵守训练馆的相关规定。</p>
							<p>3、本协议所称“会员”是指年满16周岁未满60周岁身体健康而购买了主题馆课程的人，能如实提供和陈述个人信息，取得本主题馆发放的入场密码和约课权限的人士。因此您有义务对入会时所提供资料的真实性、合法性负责。</p>
						</section>
						<section>
							<h3>二、训练场馆入场电子密码取得方式</h3>
							<p>1、原始取得，指的是在“速扑健身”客户端或是在微信公众账号“速扑健身健身”注册、填写真实、有效、全面的个人资料，办理入会手续和选择会员卡种类并缴纳会费后取得会员资格。</p>
							<p>2、主题馆课程次卡不予转让。</p>
						</section>
						<section>
							<h3>三、电子会员次卡的管理</h3>
							<p>1、会员卡仅供会员本人使用（体验卡除外），一经售出，概不退换。</p>
							<p>2、严重违反训练馆规章制度者，主题馆有权取消其课程资格并不予退还剩余费用。</p>
							<p>3、主题馆课程结束后，若会员不续卡，后台自动取消该会员的各类权限，上课资格终止。</p>
						</section>
						<section>
							<h3>四、会员权利</h3>
							<p>1、依照所持卡的类别享受相应的主题馆对该类持卡会员作出的全部服务承诺；</p>
							<p>2、针对主题馆的服务，会员有提出批评、投诉及改进建议的权利；</p>
							<p>3、期满后会员有优先续课的权利；</p>
							<p>4、女会员在怀孕期间凭县级以上医院证明，可给予办理资格延期手续。</p>
							<p>5、会员在付款当月可以申请开具全额订单发票，过期不予开具。</p>
						</section>
						<section>
							<h3>五、会员义务</h3>
							<p>1、如实向速扑健身健身微信后台提供个人信息资料，并在资料发生变动后及时通知后台。</p>
							<p>2、进入健身训练馆时扫码入场，随时接受工作人员验证和抽查。</p>
							<p>3、严禁未预约课程，强行进入训练馆上小团体课。</p>
							<p>4、严禁携带十六岁以下儿童进入健身区域，对于擅自进入健身区域造成伤害或损失的，本训练馆概不负责。</p>
							<p>5、严禁在健身区内吸烟、进食。</p>
							<p>6、严禁携带宠物进入健身训练馆。</p>
							<p>7、严禁心肺功能疾病、脊椎病、皮肤病及一切传染病患者进入健身训练馆，有以上疾病的患者隐瞒病情取得会员资格的，健身训练馆有权终止其资格，并保留追究其法律责任的权利。</p>
							<p>8、为了您的健身安全，请穿着运动服饰、运动鞋参加运动，不得赤裸上身或穿着不得体的服饰进行运动。否则工作人员有权劝离并取消当日运动权利。</p>
							<p>9、运动前严禁饮酒或饮用含酒精类饮料，因违反本条规定造成的人身伤害等意外情况，本训练馆概不负责。</p>
							<p>10、禁止会员在训练馆内销售任何商品，不得参与任何营利性健身指导，违反本条规定的，速扑健身健身训练馆有权取消其会员资格。</p>
							<p>11、未征得训练馆负责人同意，禁止在训练馆内拍照、摄像或录音。</p>
							<p>12、本训练馆原则上不接受60岁以上老人入会，能出具真实有效的健康证明者除外，但因隐瞒或错报个人健康信息发生的一切责任都由其本人承担。</p>
							<p>13、会员在健身时必须正确使用各种健身器械，否则出现任何人身伤害主题馆概不负责。</p>
							<p>14、会员应自觉爱惜合理使用室内各项设施、设备、使用后须归放原位，如有损坏须照价赔偿。</p>
							<p>15、严禁在训练馆内大声喧哗，使用污秽语言以及一切违法活动。</p>
							<p>16、健身训练馆内禁止吸烟、吐痰、乱扔垃圾，请自觉维护训练馆的环境卫生。</p>
						</section>
						<section>
							<h3>六、权利保留</h3>
							<p>1、健身训练馆营业时间为22：00结束，营业时间有变动，会在无线公众账号后台以及门店做显著位置公示，会员须遵守该营业时间。</p>
							<p>2、因国家政策或者法律法规的规定，训练馆有权合理修改营业时间并在店内公示，恕不另行通知会员，该公示即视为通知。</p>
							<p>3、因经营管理需要，训练馆有权调整、增减部分项目，该行为不视为违约，且在店内公示后即视为通知，无需另行报告给会员个人。</p>
							<p>4、因器械、设备（设施）检修、维护，训练馆有权在某一时间段对某一项目或某类项目采取停用或限用措施。</p>
							<p>5、其他出于会员安全及集体利益的需要，训练馆有权采取必要措施以恢复经营秩序。</p>
						</section>
						<section>
							<h3>七、免责条款</h3>
							<p>出现下列情形的，训练馆不予承担任何责任</p>
							<p>1、遇不可抗力（如战争、自然灾害等）造成训练馆营业终止或会员会籍不能继续，致使会员遭受损失</p>
							<p>2、会员所受损害是因其自身故意或过失造成的；</p>
							<p>3、会员所受损害是训练馆工作人员以外的任何第三方的故意或过失行为导致的；</p>
							<p>4、非会员不听劝阻，擅自进入或强行进入会员区域造成损害的，由其自身或致害方承担责任；</p>
							<p>5、受害方严重违反训练馆制定的规章制度所造成损害的；</p>
							<p>6、未交由训练馆保管而由会员或会员随同人员个人保管的贵重物品发生毁损、灭失、遗失的；</p>
							<p>7、因会员资料或个人信息发生变动未及时通知训练馆，从而造成损失或会员权利受限的；</p>
							<p>8、未听从训练馆工作人员。</p>
						</section>
						<section>
							<h3>七、课程训练时间变更</h3>
							<p>1、如果会员希望变更原预约课程时间，须在6小时前提出此要求。</p>
							<p>2、如果会员未能在6小时前提出取消原定预约课程，或者错过了一次原定预约课程的训练那么，训练馆将要将视为该节课程为消耗。</p>
							<p>3、课程时间一旦确定，教练会按时等候会员。如果会员迟到，迟到的时间将不获补偿，训练时间不会延长，将于原定时间结束。</p>
						</section>
						<section>
							<h3>八、乐瑜伽主题馆会员卡使用期限告知</h3>
							<p>1、训练馆所有会员卡均设有使用时间限制。如果购卡人在开卡之日算起后超过约定用卡有效期的情况，该卡视为过期作废处理。</p>
						</section>
					</section>
				</article>
				<article class="weui-article" id="article-bbs" style="display: none;">
					<section>
						<h2 class="title">速扑健身社区用户协议</h2>
						<section>
							<h3>欢迎您来到速扑健身。</h3>
							<p>请您仔细阅读以下条款，如果您对本协议的任何条款表示异议，您可以选择不进入速扑健身。当您注册成功，无论是进入速扑健身，还是在速扑健身上发布任何内容（即「内容」），均意味着您（即「用户」）完全接受本协议项下的全部条款。</p>
						</section>
						<section>
							<h3>使用规则</h3>
							<p>用户注册成功后，速扑健身将给予每个用户一个用户帐号及相应的密码，该用户帐号和密码由用户负责保管；用户应当对以其用户帐号进行的所有活动和事件负法律责任。</p>
							<p>用户须对在速扑健身的注册信息的真实性、合法性、有效性承担全部责任，用户不得冒充他人；不得利用他人的名义发布任何信息；不得恶意使用注册帐号导致其他用户误认；否则速扑健身有权立即停止提供服务，收回其帐号并由用户独自承担由此而产生的一切法律责任。</p>
							<p>用户直接或通过各类方式（如 RSS 源和站外 API 引用等）间接使用速扑健身服务和数据的行为，都将被视作已无条件接受本协议全部内容；若用户对本协议的任何条款存在异议，请停止使用速扑健身所提供的全部服务。</p>
							<p>速扑健身社区是一个信息分享、传播及获取的平台，用户通过速扑健身发表的信息为公开的信息，其他第三方均可以通过速扑健身获取用户发表的信息，用户对任何信息的发表即认可该信息为公开的信息，并单独对此行为承担法律责任；任何用户不愿被其他第三人获知的信息都不应该在速扑健身上进行发表。</p>
							<p>用户承诺不得以任何方式利用速扑健身直接或间接从事违反中国法律以及社会公德的行为，速扑健身有权对违反上述承诺的内容予以删除。</p>
							<p>用户不得利用速扑健身服务制作、上载、复制、发布、传播或者转载如下内容：</p>
							<p>反对宪法所确定的基本原则的；</p>
							<p>危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；</p>
							<p>损害国家荣誉和利益的；</p>
							<p>煽动民族仇恨、民族歧视，破坏民族团结的；</p>
							<p>破坏国家宗教政策，宣扬邪教和封建迷信的；</p>
							<p>散布谣言，扰乱社会秩序，破坏社会稳定的；</p>
							<p>散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；</p>
							<p>侮辱或者诽谤他人，侵害他人合法权益的；</p>
							<p>含有法律、行政法规禁止的其他内容的信息。</p>
							<p>所有用户同意遵守速扑健身社区管理规定（试行）。</p>
							<p>机构用户同意遵守速扑健身机构帐号服务协议，以及速扑健身机构帐号使用规范（试行）。</p>
							<p>速扑健身有权对用户使用速扑健身的情况进行审查和监督，如用户在使用速扑健身时违反任何上述规定，速扑健身或其授权的人有权要求用户改正或直接采取一切必要的措施（包括但不限于更改或删除用户张贴的内容、暂停或终止用户使用速扑健身的权利）以减轻用户不当行为造成的影响。</p>
						</section>
						<section>
							<h3>个人隐私</h3>
							<p>尊重用户个人隐私信息的私有性是速扑健身的一贯原则，速扑健身将通过技术手段、强化内部管理等办法充分保护用户的个人隐私信息，除法律或有法律赋予权限的政府部门要求或事先得到用户明确授权等原因外，速扑健身保证不对外公开或向第三方透露用户个人隐私信息，或用户在使用服务时存储的非公开内容。同时，为了运营和改善速扑健身的技术与服务，速扑健身将可能会自行收集使用或向第三方提供用户的非个人隐私信息，这将有助于速扑健身向用户提供更好的用户体验和服务质量。</p>
							<p>如果用户不希望被搜索引擎检索，可在「个人设置」中修改「个人信息」部分的设置，对于站外的用户与搜索引擎，你的姓名会显示为「速扑健身用户」，头像图片也将被隐藏。</p>
						</section>
						<section>
							<h3>侵权举报</h3>
							<p>处理原则
							</p>
							<p>速扑健身作为运动讨论社区，高度重视自由表达和个人、企业正当权利的平衡。依照法律规定删除违法信息是速扑健身社区的法定义务，速扑健身社区亦未与任何中介机构合作开展此项业务。</p>
							<p>受理范围</p>
							<p>受理速扑健身社区内侵犯企业或个人合法权益的侵权举报，包括但不限于涉及个人隐私、造谣与诽谤、商业侵权。 涉及个人隐私：发布内容中直接涉及身份信息，如个人姓名、家庭住址、身份证号码、工作单位、私人电话等详细个人隐私； 造谣、诽谤：发布内容中指名道姓（包括自然人和企业）的直接谩骂、侮辱、虚构中伤、恶意诽谤等； 商业侵权：泄露企业商业机密及其他根据保密协议不能公开讨论的内容。
							</p>
							<p>举报条件</p>
							<p>如果个人或单位发现速扑健身上存在侵犯自身合法权益的内容，请与速扑健身取得联系（电话：report@leoao.com）。为了保证问题能够及时有效地处理，请务必提交真实有效、完整清晰的材料，否则不予受理。请使用以下格式（包括各条款的序号）： 权利人对涉嫌侵权内容拥有商标权、著作权和/或其他依法可以行使权利的权属证明；如果举报人非权利人，请举报人提供代表企业进行举报的书面授权证明。
							</p>
							<p>充分、明确地描述侵犯了权利人合法权益的内容，提供涉嫌侵权内容在速扑健身上的具体页面地址，指明涉嫌侵权内容中的哪些内容侵犯了上述列明的权利人的合法权益；</p>
							<p>权利人具体的联络信息，包括姓名、身份证或护照复印件（对自然人）、单位登记证明复印件（对单位）、通信地址、电话号码、传真和电子邮件； 在侵权举报中加入如下关于举报内容真实性的声明：
							</p>
							<p>我本人为所举报内容的合法权利人；</p>
							<p>我举报的发布在速扑健身社区中的内容侵犯了本人相应的合法权益；</p>
							<p>如果本侵权举报内容不完全属实，本人将承担由此产生的一切法律责任。</p>
							<p>处理流程</p>
							<p>出于网络社区的监督属性，并非所有申请都必须受理。速扑健身自收到举报邮件七个工作日内处理完毕并给出回复。处理期间，不提供任何电话、邮件及其他方式的查询服务。</p>
							<p>此为速扑健身社区唯一的官方的侵权投诉渠道，暂不提供其他方式处理此业务。</p>
							<p>用户在速扑健身中的商业行为引发的法律纠纷，由交易双方自行处理，与速扑健身无关。</p>
						</section>
						<section>
							<h3>免责申明</h3>
							<p>速扑健身不能对用户发表的回答或评论的正确性进行保证。</p>
							<p>用户在速扑健身发表的内容仅表明其个人的立场和观点，并不代表速扑健身的立场或观点。作为内容的发表者，需自行对所发表内容负责，因所发表内容引发的一切纠纷，由该内容的发表者承担全部法律及连带责任。速扑健身不承担任何法律及连带责任。</p>
							<p>速扑健身不保证网络服务一定能满足用户的要求，也不保证网络服务不会中断，对网络服务的及时性、安全性、准确性也都不作保证。</p>
							<p>对于因不可抗力或速扑健身不能控制的原因造成的网络服务中断或其它缺陷，速扑健身不承担任何责任，但将尽力减少因此而给用户造成的损失和影响。</p>
						</section>
						<section>
							<h3>协议修改</h3>
							<p>根据互联网的发展和有关法律、法规及规范性文件的变化，或者因业务发展需要，速扑健身有权对本协议的条款作出修改或变更，一旦本协议的内容发生变动，速扑健身将会直接在速扑健身网站上公布修改之后的协议内容，该公布行为视为速扑健身已经通知用户修改内容。速扑健身也可采用电子邮件或私信的传送方式，提示用户协议条款的修改、服务变更、或其它重要事项。</p>
							<p>如果不同意速扑健身对本协议相关条款所做的修改，用户有权并应当停止使用速扑健身。如果用户继续使用速扑健身，则视为用户接受速扑健身对本协议相关条款所做的修改。</p>
						</section>
					</section>
				</article>
				<article class="weui-article" id="article-CrossFit" style="display: none;">
					<section>
						<h2 class="title">CrossFit 会员课程购买协议</h2>
						<section>
							<h3>一、会员卡</h3>
							<p>1、速扑健身CrossFit所有课程采用会员制服务模式，只有购买相关课程课时的会员才能享受CrossFit Xihu场馆的专业团体课程及相关配套服务。</p>
							<p>2、取得会员资格应办理入会手续，并已知晓CrossFit Xihu场馆有关健身的规则与警示，承诺遵守CrossFit Xihu场馆的相关规定。</p>
							<p>3、因经营管理需要，本场馆可能会针对不同客户办理不同类别的电子会员卡，但无论您持有何种电子会员卡，都将在享受会员权利的同时，受到本协议的约束。</p>
							<p>4、本协议所称“会员”是指年满16周岁未满60周岁身体健康而购买了训练馆课程的人，能如实提供和陈述个人信息，取得本场馆发放的电子CrossFit课程卡的人士。因此您有义务对入会时所提供资料的真实性、合法性负责。</p>
						</section>
						<section>
							<h3>二、CrossFit电子会员卡的取得方式</h3>
							<p>1、原始取得，指的是在“速扑健身”客户端或是在微信公众账号“速扑健身健身”注册、填写真实、有效、全面的个人资料，办理入会手续并缴纳CrossFit会费后取得会员资格。</p>
							<p>2、CrossFit课程卡不予停止、转让</p>
						</section>
						<section>
							<h3>三、电子会员卡的管理</h3>
							<p>1、CrossFit会员课程卡仅供会员本人使用，一经售出，概不退换。</p>
							<p>2、严重违反CrossFit场馆规章制度者，场馆有权取消其课程资格并不予退还剩余费用。</p>
							<p>3、团体课程结束后，若会员不续卡，CrossFit Xihu馆后台自动取消该会员的团体会员的各类权限，训练资格终止。</p>
							<p>4、会员卡生效日期：有效期从购卡付款成功后开始计时。</p>
						</section>
						<section>
							<h3>四、会员权利</h3>
							<p>1、依照所持卡的类别享受相应的场馆对该类持卡会员作出的全部服务承诺；</p>
							<p>2、针对场馆的服务，会员有提出批评、投诉及改进建议的权利；</p>
							<p>3、期满后会员有优先续课的权利；</p>
							<p>4、女会员在怀孕期间凭县级以上医院证明，可给予办理资格延期手续。</p>
							<p>5、会员在付款当月可以申请开具全额订单发票，过期不予开具。</p>
						</section>
						<section>
							<h3>五、会员义务</h3>
							<p>1、如实向速扑健身健身微信后台提供个人信息资料，并在资料发生变动后及时通知后台。</p>
							<p>2、进入健身训练馆时凭电子课程预约进入，并接受工作人员验证扫码。</p>
							<p>3、严禁未预约课程，强行进入Box上团体课。</p>
							<p>4、严禁携带十六岁以下儿童进入健身区域，经过工作人员允许除外，对于擅自进入健身区域造成伤害或损失的，本训练馆概不负责。</p>
							<p>5、严禁在健身区内吸烟、进食。</p>
							<p>6、严禁携带宠物进入健身训练馆。</p>
							<p>7、严禁心肺功能疾病、脊椎病、皮肤病及一切传染病患者进入健身训练馆，有以上疾病的患者隐瞒病情取得会员资格的，健身训练馆有权终止其资格，并保留追究其法律责任的权利。</p>
							<p>8、为了您的健身安全，请穿着运动服饰、运动鞋参加运动，不得穿着不得体的服饰进行运动。否则工作人员有权劝离并取消当日运动权利。</p>
							<p>9、运动前严禁饮酒或饮用含酒精类饮料，因违反本条规定造成的人身伤害等意外情况，本训练馆概不负责。</p>
							<p>10、禁止会员在训练馆内销售任何商品，不得参与任何营利性健身指导，违反本条规定的，速扑健身健身训练馆有权取消其会员资格。</p>
							<p>11、未征得训练馆负责人同意，禁止在训练馆内拍照、摄像或录音。</p>
							<p>13、本训练馆原则上不接受60岁以上老人入会，能出具真实有效的健康证明者除外，但因隐瞒或错报个人健康信息发生的一切责任都由其本人承担。</p>
							<p>14、会员在健身时必须有Box教练教授正确使用各种健身器械，否则出现任何人身伤害本场馆概不负责。</p>
							<p>15、会员应自觉爱惜合理使用室内各项设施、设备、使用后须归放原位，禁止将室内各项设施、设备擅自带出场馆，如有损坏，丢失须追究相关人员责任，照价赔偿。</p>
							<p>16、严禁在场馆内大声喧哗，使用污秽语言以及一切违法活动。</p>
							<p>17、场馆内禁止吸烟、吐痰、乱扔垃圾，请自觉维护场馆的环境卫生。</p>
						</section>
						<section>
							<h3>六、权利保留</h3>
							<p>1、场馆营业时间根据“速扑健身”客户端或“速扑健身健身”微信公众账号CrossFit课程编排时间为准，会员须遵守该营业时间。</p>
							<p>2、因国家政策或者法律法规的规定，场馆有权合理修改课程时间并在微信公众号显示，恕不另行通知会员，该公示即视为通知。</p>
							<p>3、因经营管理需要，场馆有权调整、增减部分课程项目，该行为不视为违约，且在客户端或微信公众号显示课程调整内容，无需另行报告给会员个人。</p>
							<p>4、因器械、设备（设施）检修、维护，训练馆有权在某一时间段对某一项目或某类项目采取停用或限用措施。</p>
							<p>5、其他出于会员安全及集体利益的需要，场馆有权采取必要措施以恢复经营秩序。</p>
						</section>
						<section>
							<h3>七、免责条款</h3>
							<p>出现下列情形的，场馆不予承担任何责任</p>
							<p>1、遇不可抗力（如战争、自然灾害等）造成训练馆营业终止或会员会籍不能继续，致使会员遭受损失</p>
							<p>2、会员所受损害是因其自身故意或过失造成的；</p>
							<p>3、会员所受损害是训练馆工作人员以外的任何第三方的故意或过失行为导致的；</p>
							<p>4、非会员不听劝阻，擅自进入或强行进入会员区域造成损害的，由其自身或致害方承担责任；</p>
							<p>5、受害方严重违反训练馆制定的规章制度所造成损害的；</p>
							<p>6、未交由场馆保管而由会员或会员随同人员个人保管的贵重物品发生毁损、灭失、遗失的；</p>
							<p>7、因会员资料或个人信息发生变动未及时通知训练馆，从而造成损失或会员权利受限的；</p>
							<p>8、未听从场馆教练员指导，擅自使用或违反操作规程使用器械、设备造成自身受伤的，由自身负责；造成他人受损或中心财产毁损的，其本人应承担全部赔偿责任，对此本场馆不承担任何责任。</p>
							<p>9、因会员自身行为不当或会员之间的争议产生的人身和财产损失，本场馆不承担任何责任。</p>
							<p>10.学员有以下病史，不建议报名。若隐藏病史，同时在训练过程中，产生身体不适的，概不负责</p>
							<p>
								心脏疾病患者请勿参加该训练营课程；<br>患有严重膝盖等关节问题请询医，征医生同意后选择性参加训练，并提前告知授课教练；<br> 手术恢复期内请勿参加该训练营课程；
								<br> 高血压患者请慎重选择该训练营课程；
								<br>
							</p>
							<p>11、健身教练一概不提供任何医疗咨询（只提供健身技巧方面的咨询帮助），学员须对自己选择的健身方式负责，若因为健身方式而造成损伤，概不负责。</p>
						</section>
						<section>
							<h3>八、课程训练时间变更</h3>
							<p>1、如果会员希望变更原预约课程时间，须在6小时前提出此要求。</p>
							<p>2、如果会员未能在6小时前提出取消原定预约课程，或者错过了一次原定预约课程的训练那么，训练馆将要将视为该节课程为消耗。</p>
							<p>3、课程时间一旦确定，教练会按时等候会员。如果会员迟到，迟到的时间将不获补偿，训练时间不会延长，将于原定时间结束。</p>
						</section>
						<section>
							<h3>CrossFit Xihu馆次卡使用期限告知</h3>
							<p>1、为了提高训练者的时效性，训练馆所有次卡均设有使用时间限制。如果购卡人在开卡之日算起后超过约定用卡有效期的情况，该卡视为过期作废处理。</p>
							<p>2、单次卡使用期限：7天、10次卡使用期限：90天</p>
						</section>
						<section>
							<h3>2、单次卡使用期限：7天、10次卡使用期限：90天</h3>
							<p>在法律允许的范围内，场馆对该协议约定的内容有最终解释权，同时为更好地服务会员之需要，场馆有权对相关内容进行修改，且修改后的条款会在中心网站、APP，微信公众号或其他传播渠道公示，即对全体会员产生约束力。</p>
						</section>
						<section>
							<h3>十一、会员承诺</h3>
							<p>1、本人保证所提供的入会资料及个人信息真实有效；</p>
							<p>2、本人身体健康且没有本协议约定的不适合进行运动的疾病；</p>
							<p>3、本人已阅读、理解并同意上述条文。</p>
						</section>
						<section>
							<h3>十二、其他</h3>
							<p>如果会员和场馆因协议的履行发生争议，双方首先应当协商解除，如果协商不成的，任何乙方均可以向杭州市西湖区人民法院起诉解决争议。</p>
						</section>
					</section>
				</article>
				<article class="weui-article" id="article-X-Training" style="display: none;">
					<section>
						<h2 class="title">X-Training协议</h2>
						<section>
							<h3>一、会员卡</h3>
							<p>1、速扑健身X-training所有课程均采用会员次卡制服务模式，只有购买相关课程课时的会员才能享受训练场馆的各项专业小团体课程及相关配套服务。</p>
							<p>2、通过购买次卡取得会员资格，应办理入会手续并填写个人健康档案书，并已知晓训练馆有关健身的规则与警示，承诺遵守训练馆的相关规定。</p>
							<p>3、本协议所称“会员”是指年满16周岁未满60周岁身体健康而购买了训练馆课程的人，能如实提供和陈述个人信息，取得本训练馆发放的入场密码和约课权限的人士。因此您有义务对入会时所提供资料的真实性、合法性负责。</p>
						</section>
						<section>
							<h3>二、训练场馆入场电子密码取得方式</h3>
							<p>1、原始取得，指的是在“速扑健身”客户端或是在微信公众账号“速扑健身健身”注册、填写真实、有效、全面的个人资料，办理入会手续和选择次卡种类并缴纳会费后取得会员资格。</p>
							<p>2、小团体课程次卡不予转让。</p>
						</section>
						<section>
							<h3>三、电子会员次卡的管理</h3>
							<p>1、会员课程次卡仅供会员本人使用（体验卡除外），一经售出，概不退换。</p>
							<p>2、严重违反训练馆规章制度者，训练馆有权取消其小团体课程资格并不予退还剩余费用。</p>
							<p>3、小团体课程结束后，若会员不续卡，训练馆后台自动取消该会员的小团体会员的各类权限，小团体训练资格终止。</p>
							<p>4、会员卡生效日期：有效期从购卡付款成功后开始计时。</p>
						</section>
						<section>
							<h3>四、会员权利</h3>
							<p>1、依照所持卡的类别享受相应的训练馆对该类持卡会员作出的全部服务承诺；</p>
							<p>2、针对训练馆的服务，会员有提出批评、投诉及改进建议的权利；</p>
							<p>3、期满后会员有优先续课的权利；</p>
							<p>4、女会员在怀孕期间凭县级以上医院证明，可给予办理资格延期手续。</p>
							<p>5、会员在付款当月可以申请开具全额订单发票，过期不予开具。</p>
						</section>
						<section>
							<h3>五、会员义务</h3>
							<p>1、如实向速扑健身健身微信后台提供个人信息资料，并在资料发生变动后及时通知后台。</p>
							<p>2、进入健身训练馆时凭电子入场密码，随时接受工作人员验证和抽查。</p>
							<p>3、严禁未预约课程，强行进入训练馆上小团体课。</p>
							<p>4、严禁携带十六岁以下儿童进入健身区域，对于擅自进入健身区域造成伤害或损失的，本训练馆概不负责。</p>
							<p>5、严禁在健身区内吸烟、进食。</p>
							<p>6、严禁携带宠物进入健身训练馆。</p>
							<p>7、严禁心肺功能疾病、脊椎病、皮肤病及一切传染病患者进入健身训练馆，有以上疾病的患者隐瞒病情取得会员资格的，健身训练馆有权终止其资格，并保留追究其法律责任的权利。</p>
							<p>8、为了您的健身安全，请穿着运动服饰、运动鞋参加运动，不得赤裸上身或穿着不得体的服饰进行运动。否则工作人员有权劝离并取消当日运动权利。</p>
							<p>9、运动前严禁饮酒或饮用含酒精类饮料，因违反本条规定造成的人身伤害等意外情况，本训练馆概不负责。</p>
							<p>10、禁止会员在训练馆内销售任何商品，不得参与任何营利性健身指导，违反本条规定的，速扑健身健身训练馆有权取消其会员资格。</p>
							<p>11、未征得训练馆负责人同意，禁止在训练馆内拍照、摄像或录音。</p>
							<p>12、本训练馆原则上不接受60岁以上老人入会，能出具真实有效的健康证明者除外，但因隐瞒或错报个人健康信息发生的一切责任都由其本人承担。</p>
							<p>13、会员在健身时必须正确使用各种健身器械，否则出现任何人身伤害训练馆概不负责。</p>
							<p>14、会员应自觉爱惜合理使用室内各项设施、设备、使用后须归放原位，如有损坏须照价赔偿。</p>
							<p>15、严禁在训练馆内大声喧哗，使用污秽语言以及一切违法活动。</p>
							<p>16、健身训练馆内禁止吸烟、吐痰、乱扔垃圾，请自觉维护训练馆的环境卫生。</p>
						</section>
						<section>
							<h3>六、权利保留</h3>
							<p>1、健身训练馆营业时间原则上24小时，营业时间有变动，会在无线公众账号后台以及门店做显著位置公示，会员须遵守该营业时间。</p>
							<p>2、因国家政策或者法律法规的规定，训练馆有权合理修改营业时间并在店内公示，恕不另行通知会员，该公示即视为通知。</p>
							<p>3、因经营管理需要，训练馆有权调整、增减部分项目，该行为不视为违约，且在店内公示后即视为通知，无需另行报告给会员个人。</p>
							<p>4、因器械、设备（设施）检修、维护，训练馆有权在某一时间段对某一项目或某类项目采取停用或限用措施。</p>
							<p>5、其他出于会员安全及集体利益的需要，训练馆有权采取必要措施以恢复经营秩序。</p>
						</section>
						<section>
							<h3>七、免责条款</h3>
							<p>出现下列情形的，训练馆不予承担任何责任</p>
							<p>1、遇不可抗力（如战争、自然灾害等）造成训练馆营业终止或会员会籍不能继续，致使会员遭受损失</p>
							<p>2、会员所受损害是因其自身故意或过失造成的；</p>
							<p>3、会员所受损害是训练馆工作人员以外的任何第三方的故意或过失行为导致的；</p>
							<p>4、非会员不听劝阻，擅自进入或强行进入会员区域造成损害的，由其自身或致害方承担责任；</p>
							<p>5、受害方严重违反训练馆制定的规章制度所造成损害的；</p>
							<p>6、未交由训练馆保管而由会员或会员随同人员个人保管的贵重物品发生毁损、灭失、遗失的；</p>
							<p>7、因会员资料或个人信息发生变动未及时通知训练馆，从而造成损失或会员权利受限的；</p>
							<p>8、未听从训练馆工作人员。</p>
						</section>
						<section>
							<h3>七、课程训练时间变更</h3>
							<p>1、如果会员希望变更原预约课程时间，须在6小时前提出此要求。</p>
							<p>2、如果会员未能在6小时前提出取消原定预约课程，或者错过了一次原定预约课程的训练那么，训练馆将要将视为该节课程为消耗。</p>
							<p>3、课程时间一旦确定，教练会按时等候会员。如果会员迟到，迟到的时间将不获补偿，训练时间不会延长，将于原定时间结束。</p>
						</section>
						<section>
							<h3>八、训练馆次卡使用期限告知</h3>
							<p>1、为了提高训练者的时效性，训练馆所有次卡均设有使用时间限制。如果购卡人在开卡之日算起后超过约定用卡有效期的情况，该卡视为过期作废处理。</p>
							<p>2、单次卡使用期限：7天、12次卡使用期限：45天、24次卡使用期限：75天、36次卡使用期限：120天</p>
						</section>
					</section>
				</article>
			</div>
		</div>
		<!-- jquery-weui -->
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
		<script>

			$(function() {
				$('.leui-right-content .weui-article').hide();
				$('.leui-right-content #article-card').show();
			})
			$('.switch-tab').click(function() {
				$('.switch-tab').removeClass('action');
				$('.leui-right-content .weui-article').hide();
				$(this).addClass('action');
				var id = $(this).data('target');
				$('#' + id).scrollTop(0);
				$('#' + id).show();
			})
		</script>

	</body>

</html>