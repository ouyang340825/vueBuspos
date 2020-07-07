package com.njty.carpark.controller;


import com.njty.carpark.bean.MsgBean;
import com.njty.carpark.entity.SysUserEntity;
import com.njty.carpark.service.QueryStatsService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/queryStats")
public class QueryStatsController {

    protected static final Logger logger = LoggerFactory.getLogger(QueryStatsController.class);

    @Autowired
    private QueryStatsService queryStatsService;


    /**
     *POS交易查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getPosTranList")
    public MsgBean getPosTranList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getPosTranList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getPosTranList(params);
    }

    /**
     *获取刷卡交易Echarts数据
     * @param params
     * @return
     */
    @RequestMapping(value = "/getPosTranForEcharts")
    public MsgBean getPosTranForEcharts(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getPosTranForEcharts");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getPosTranForEcharts(params);
    }


    /**
     *POS交易查询--全部导出
     * @param params
     * @return
     */
    @RequestMapping(value = "/getPosTranListForExport")
    public MsgBean getPosTranListForExport(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getPosTranListForExport");
        return queryStatsService.getPosTranListForExport(params);
    }


    /**
     *扫码交易查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getCodeTranList")
    public MsgBean getCodeTranList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getCodeTranList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getCodeTranList(params);
    }

    /**
     *获取扫码交易Echarts数据
     * @param params
     * @return
     */
    @RequestMapping(value = "/getCodeTranForEcharts")
    public MsgBean getCodeTranForEcharts(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getCodeTranForEcharts");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getCodeTranForEcharts(params);
    }


    /**
     *扫码交易查询--全部导出
     * @param params
     * @return
     */
    @RequestMapping(value = "/getCodeTranListForExport")
    public MsgBean getCodeTranListForExport(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getCodeTranListForExport");
        return queryStatsService.getCodeTranListForExport(params);
    }


    /**
     * 按线路统计POS交易
     * @param params
     * @return
     */
    @RequestMapping(value = "/getStatsPosTranList")
    public MsgBean getStatsPosTranList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getStatsPosTranList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getStatsPosTranList(params);
    }


    /**
     *按线路统计POS交易--全部导出
     * @param params
     * @return
     */
    @RequestMapping(value = "/getStatsPosTranListForExport")
    public MsgBean getStatsPosTranListForExport(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getStatsPosTranListForExport");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getStatsPosTranListForExport(params);
    }


    /**
     * 在线率统计
     * @param params
     * @return
     */
    @RequestMapping(value = "/getPosOnlineList")
    public MsgBean getPosOnlineList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getPosOnlineList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getPosOnlineList(params);
    }



    /**
     *POS交易查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getPosInfoList")
    public MsgBean getPosInfoList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getPosInfoList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getPosInfoList(params);
    }


    /**
     *监控管理
     * @param params
     * @return
     */
    @RequestMapping(value = "/getPosregAllList")
    public MsgBean getPosregAllList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getPosregAllList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getPosregAllList(params);
    }


    /**
     *监控管理
     * @param params
     * @return
     */
    @RequestMapping(value = "/getPosregList")
    public MsgBean getPosregList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getPosregList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getPosregList(params);
    }


    /**
     *监控管理--获取子表数据
     * @param params
     * @return
     */
    @RequestMapping(value = "/getPosregForChildTable")
    public MsgBean getPosregForChildTable(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getPosregForChildTable");
        return queryStatsService.getPosregForChildTable(params);
    }


    /**
     *获取闪付交易数据
     * @param params
     * @return
     */
    @RequestMapping(value = "/getQuickPassDataList")
    public MsgBean getQuickPassDataList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getQuickPassDataList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getQuickPassDataList(params);
    }

    /**
     *获取闪付交易Echarts数据
     * @param params
     * @return
     */
    @RequestMapping(value = "/getQuickPassDataForEcharts")
    public MsgBean getQuickPassDataForEcharts(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getQuickPassDataForEcharts");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getQuickPassDataForEcharts(params);
    }


    /**
     *获取终端版本统计数据
     * @param params
     * @return
     */
    @RequestMapping(value = "/getDevVersionCountList")
    public MsgBean getDevVersionCountList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getDevVersionCountList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getDevVersionCountList(params);
    }

    /**
     *POS交易查询
     * @param params
     * @return
     */
    @RequestMapping(value = "/getOfflinePosInfoList")
    public MsgBean getOfflinePosInfoList(@RequestParam Map<String,Object> params){
        logger.info("QueryStatsController =====================> getOfflinePosInfoList");
        SysUserEntity existUser= (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        params.put("USERID",existUser.getId());
        return queryStatsService.getOfflinePosInfoList(params);
    }


    /**
     *车辆管理---删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delPosList")
    public MsgBean delPosList(@RequestBody String[] id){
        logger.info("CarController =====================> delPosList");
        return queryStatsService.delPosList(id);
    }



}
