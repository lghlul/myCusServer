package customer.supu.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.StringUtils;
import customer.supu.dto.CoachDto;
import customer.supu.dto.CoachEditNextDto;
import customer.supu.jenum.AreaLevelEnum;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.Coach;
import customer.supu.po.Zone;
import customer.supu.service.BasicDataService;
import customer.supu.service.CoachService;
import customer.supu.service.StoreService;
import customer.supu.service.ZoneService;

@Controller
@RequestMapping("/user/coach")
public class B_CoachController {
    @Autowired
    private CoachService coachService;


    @Autowired
    private ZoneService zoneService;

    @Autowired
    private BasicDataService basicDataService;

    @Autowired
    private StoreService storeService;


    /**
     * 进入页面
     *
     * @return
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public String listPge(Model model, Coach coach) {
        try {
            Page page = new Page();
            page.setLimit("9");
            page.setOffset("0");
            model.addAttribute("coachlist", coachService.selectCoachDtoByList(page, coach));
            //获取教练擅长
            //	model.addAttribute("coachGoodAt", basicDataService.getBasicDataByType("coachGoodAt"));
            //获取所有已经开业的门店
            model.addAttribute("storelist", storeService.selectAllStore());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/coach/coachlist";

    }

    /**
     * 异步获取列表数据
     */
    @RequestMapping(value = "/getCoachList", method = RequestMethod.GET)
    @ResponseBody
    public List<CoachDto> getStoreList(Page page, Coach coach) {
        try {
            List<CoachDto> coachList = coachService.selectCoachDtoByList(page, coach);

            return coachList;

        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }


    /**
     * 进入添加页面
     *
     * @return
     */
    @RequestMapping(value = "addPage", method = RequestMethod.GET)
    public String addPage(Model model) {
        try {
            List<Zone> city = zoneService.selectZoneList(AreaLevelEnum.CITY.getCode());

            //获取市
            model.addAttribute("city", city);
            if (CollectionUtils.isNotEmpty(city)) {

                //获取区
                model.addAttribute("region", zoneService.selectZoneByParentId(city.get(0).getZonecode(), AreaLevelEnum.REGION.getCode()));
            }


            //获取教练擅长
            //model.addAttribute("coachGoodAt", basicDataService.getBasicDataByType("coachGoodAt"));

            //获取门店区域
            model.addAttribute("area", storeService.selectStoreByArea(null));


        } catch (Exception e) {

            e.printStackTrace();
        }
        return "/coach/add_coach";
    }


    @RequestMapping(value = "addSave", method = RequestMethod.POST)
    public String addSave(Model model, Coach coach) {

        try {
            //添加保存
            coachService.addSave(coach);
            //教练id
            model.addAttribute("coach", coach);


        } catch (Exception e) {

        }

        return "/coach/add_next_coach";

    }


    /**
     * 添加第二步  多图保存
     *
     * @return
     */
    @RequestMapping(value = "addNextSave", method = RequestMethod.POST)
    @ResponseBody
    public PageResponse addNextSave(CoachEditNextDto coachEditNextDto) {
        PageResponse response = new PageResponse();
        try {
            coachService.addNextSave(coachEditNextDto);
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }
        return response;

    }

    /**
     * 进入编辑页面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    public String editPage(@RequestParam(value = "id") Integer id, Model model) {
        try {
            Coach coach = coachService.selectZoneById(id);

            if (coach != null) {

                //获取教练信息
                model.addAttribute("coach", coach);
                //获取市  ，所在地
                if (StringUtils.hasText(coach.getLocation().toString())) {
                    model.addAttribute("city", zoneService.selectZoneChecked(coach.getLocation().toString(), AreaLevelEnum.CITY.getCode(), null));
                } else {
                    model.addAttribute("city", zoneService.selectZoneChecked(null, AreaLevelEnum.CITY.getCode(), null));
                }

                //获取教练擅长
                //model.addAttribute("coachGoodAt", basicDataService.selectBasicChecked("coachGoodAt", coach.getGoodat()));

                //获取该会员选的门店
                model.addAttribute("area", storeService.selectStoreByArea(coach.getStores()));

                //图片个数
                model.addAttribute("coachImgCount", coachService.selectImgCount(coach));

                //获取区，获取服务区域
                model.addAttribute("region", zoneService.selectZoneChecked(coach.getServicearea(), AreaLevelEnum.REGION.getCode(), coach.getLocation().toString()));
            } else {
                return "/error/404";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return "/coach/edit_coach";
    }


    /**
     * 编辑保存
     *
     * @param model
     * @param coach
     * @return
     */
    @RequestMapping(value = "editSave", method = RequestMethod.POST)
    public String editSave(Model model, Coach coach) {
        try {
            //保存编辑
            //memberCardService.editSave(memberCard);
            coachService.editSave(coach);
            Coach resultcoach = coachService.selectCoachById(coach.getId());
            model.addAttribute("coach", resultcoach);

            //证书
            model.addAttribute("coachCertificate", coachService.selectCertificateByCoachId(coach.getId()));
            //获取身份照  数
            model.addAttribute("coachImgCount", coachService.getIdNumberCount(resultcoach));
        } catch (Exception e) {

        }

        return "/coach/edit_next_coach";

    }

    /**
     * 编辑第二步  多图 编辑保存
     *
     * @return
     */
    @RequestMapping(value = "editNextSave", method = RequestMethod.POST)
    @ResponseBody
    public PageResponse editNextSave(CoachEditNextDto coachEditNextDto) {
        PageResponse response = new PageResponse();

        try {
            coachService.editNextSave(coachEditNextDto);
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }
        return response;

    }


    /**
     * 根据市  加载区
     *
     * @param cityCode 市编码
     * @return
     */
    @RequestMapping(value = "selectRegionByCity", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse selectRegionByCity(@RequestParam(value = "cityCode") String cityCode) {
        PageResponse response = new PageResponse();

        try {
            List<Zone> area = zoneService.selectZoneByParentId(cityCode, AreaLevelEnum.REGION.getCode());
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            response.setRecords(area);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }


        return response;

    }


    /**
     * 进入详情页面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "detailPage", method = RequestMethod.GET)
    public String detailPage(@RequestParam(value = "id") Integer id, Model model) {
        try {
            Coach coach = coachService.selectZoneById(id);

            if (coach != null) {

                //获取教练信息
                model.addAttribute("coach", coach);
                //获取市  ，所在地
                model.addAttribute("city", zoneService.selectZoneChecked(coach.getLocation().toString(), AreaLevelEnum.CITY.getCode(), null));

                //获取教练证书
                model.addAttribute("certificateList", coachService.selectCertificateByCoachId(id));
                //获取教练擅长
                //model.addAttribute("coachGoodAt", basicDataService.selectBasicChecked("coachGoodAt", coach.getGoodat()));
                //获取该会员选的门店
                model.addAttribute("area", storeService.selectStoreByArea(coach.getStores()));
                //获取区，获取服务区域
                model.addAttribute("region", zoneService.selectZoneChecked(coach.getServicearea(), AreaLevelEnum.REGION.getCode(), coach.getLocation().toString()));
            } else {
                return "/error/404";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return "/coach/detail_coach";
    }


    /**
     * 更新教练状态
     *
     * @param store
     * @return
     */
    @RequestMapping(value = "updateCoachStatus", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse updateCoachStatus(Model model, @RequestParam(value = "id") Integer id, @RequestParam(value = "status") Integer status) {
        PageResponse response = new PageResponse();
        try {
            //添加保存
            coachService.updateCoachStatus(status, id);
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }

        return response;

    }


}
