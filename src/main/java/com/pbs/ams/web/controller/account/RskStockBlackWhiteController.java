package com.pbs.ams.web.controller.account;

import com.google.common.collect.Maps;
import com.pbs.ams.common.annotation.Log;
import com.pbs.ams.common.constant.ResultSet;
import com.pbs.ams.common.constant.StatusCode;
import com.pbs.ams.common.constant.UpmsConstant;
import com.pbs.ams.common.util.IdGeneratorUtil;
import com.pbs.ams.web.controller.BaseController;
import com.pbs.ams.web.model.RskBlackwhiteList;
import com.pbs.ams.web.model.SysGlobalConstData;
import com.pbs.ams.web.service.RskBlackwhiteListService;
import com.pbs.ams.web.service.SysGlobalConstDataService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/26.
 */
@Controller
@Api(value = "黑白名单", description = "黑白名单")
@RequestMapping("/blackWhite")
public class RskStockBlackWhiteController extends BaseController{
    @Autowired
    private RskBlackwhiteListService rskBlackwhiteListService;

    @Autowired
    private SysGlobalConstDataService sysGlobalConstDataService;

    @Log(value = "黑名单首页")
    @RequiresPermissions("upms:blackWhite:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        //查询金融工具类型（平台）
        Map<String, Object> params = Maps.newHashMap();
        params.put("globalConstCode", UpmsConstant.FIN_INSTR_TYPE);
        List<SysGlobalConstData> amsPlatforms = sysGlobalConstDataService.selectDataByCode(params);
        request.setAttribute("amsPlatforms", amsPlatforms);
        return "/account/blackWhite/blackWhiteList.jsp";
    }

    @Log(value = "黑名单列表")
    @RequiresPermissions("upms:blackWhite:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit, HttpServletRequest request) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("offset", offset);
        params.put("limit", limit);
        String isBlack = request.getParameter("isBlack");//区分黑白名单
        if (isBlack != null) {//不为空就是白
            params.put("isBlack", 0);
        }
        List<Map<String, Object>> rows = rskBlackwhiteListService.selectBlackWhite(params);
        int total = rskBlackwhiteListService.selectBlackWhiteCount(params);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @Log(value = "新增黑名单")
    @ResponseBody
    @RequiresPermissions("upms:blackWhite:read")
    @RequestMapping(value = "/createBlack", method = RequestMethod.POST)
    public Object create(RskBlackwhiteList rskBlackwhiteList,String isBlack,String globalConstDataValue,String globalConstDataValue1) {
        Long blackwhiteId = IdGeneratorUtil.getKey("rsk_blackwhite_list");
        rskBlackwhiteList.setBlackwhiteId(blackwhiteId);
        if (isBlack != null){
            rskBlackwhiteList.setIsBlack(true);
        }else{
            rskBlackwhiteList.setIsBlack(false);
        }
        rskBlackwhiteList.setCreateTime(System.currentTimeMillis());
        rskBlackwhiteList.setUpdateTime(System.currentTimeMillis());
        rskBlackwhiteList.setCompanyId(getCurrentUser().getCompanyId());
        rskBlackwhiteList.setOperatorId(getCurrentUser().getUserId());
        rskBlackwhiteList.setBlackwhiteListType(1);
        if (globalConstDataValue != null) {
            rskBlackwhiteList.setFinInstrType(Integer.parseInt(globalConstDataValue));
        }else {
            rskBlackwhiteList.setFinInstrType(Integer.parseInt(globalConstDataValue1));
        }
        int result = rskBlackwhiteListService.insertSelective(rskBlackwhiteList);
        if (result > 0) {
            return new ResultSet(StatusCode.ERROR_NONE, result);
        }
        return new ResultSet(StatusCode.INVALID_INSERT);
    }

    @Log(value = "删除黑白名单记录")
    @ResponseBody
    @RequiresPermissions("upms:blackWhite:read")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(HttpServletRequest request) {
        String isBlack = request.getParameter("isBlack");//区分黑白名单
        if (isBlack != null) {//不为空就是白
            rskBlackwhiteListService.deleteByIsBlack(Integer.parseInt(isBlack));
            return new ResultSet(StatusCode.ERROR_NONE);
        } else {
            rskBlackwhiteListService.deleteByIsBlack(0);
            return new ResultSet(StatusCode.INVALID_DELETE);
        }
    }
}
