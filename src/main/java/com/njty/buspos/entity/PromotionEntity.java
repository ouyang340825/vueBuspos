package com.njty.buspos.entity;

public class PromotionEntity
{
	//基本信息
	private String carNo;
	private String shortname;
	private String devId;
	private String dayTime;
	private String runNums;
	private String runMoney;
	private String runDis;
	private String tradDis;
	private String YYCS_SUM;
	private String MSUM;
	private String YYJE;
	private String ZLC;
	private String  YYLC;
	private String YYLC_SUM;
	private String vehicleid;
	private String D;
	private String YYCC;
	private String RJSR;

	private String LCLYL;
	private String PJYJ;
	private String BGLYS;
	private String RJXSLC;
	private String PJFWCC;
	private String SMK;
	private String SMKBL;
	private String YLKBL;
	private String SMKNUMS;
	private String YLNUMS;
	private String SKBS;
	private String SKJE;
	private String SKBL;
	private String minontime;
	private String maxontime;
	private String avgyyje;
	private String avgyylc_sum;
	private String avgkslc_sum;
	private String avgyycs_sum;
	private String avgyylc;
	private String avgkslc;
	private String avgyycs;
	private String avgdhsj;
	private String avgzlc;
	private String yysj;
	private String dhsj;
	private String avgyysj;
	private String avgmsum;
	private String groupName;
	private String CARNUMS;
	private String sumTs;
	//空驶里程
	private String kslc;
	//载客率
	private String zkl;
	//天数
	private String ts;
	//日均营运次数
	private String rjyycs;
	//空驶率
	private String ksl;
	
	private String OWNERNAME;
	private String driveName;
	
	
	private String onTime;
	private String offTime;
	private String yyDis;
	private String noneDis;
	private String waitTime;
	private String tradMoney;
	
	/**20150706为满足南通需求新增字段**/
	//日均单车行驶里程(km)
	private String rjdcxslc;
	//日均单车载客里程(km)
	private String rjdczklc;
	//日均单车营运次数
	private String rjdcyycs;
	//单车日均营收（元）
	private String dcrjys;
	//营运车辆数
	private int carNum;
	//企业ID
	private String ownerId;
	//单车日均每公里收入=单车日均总收入/日行驶里程   =单车日均总收入/日单车行驶里程*车辆数
	private String dcrjmglsr;
	//单车营运平均运距
	//单车营运平均运距=单车载客里程/营运次数
	//单车载客里程 = rs.getFloat("TRADDIS")/Integer.parseInt(rs.getString("carNum"))
	private String dcyypjyj;
	//当月电调业务量（次）
	private int ddywl;
	//电调成功量（次）
	private int ddcgl;
	//电调成功率（%
	private String cgl;
	
	
	//分页传入参数
	private int page;
	private int rows;

	//查询总记录数
	private int totalNum;
	//分页
	private long startRecordNum;
	private long endRecordNum;

	public String getAvgmsum() {
		return avgmsum;
	}

	public void setAvgmsum(String avgmsum) {
		this.avgmsum = avgmsum;
	}

	public String getCARNUMS() {
		return CARNUMS;
	}

	public void setCARNUMS(String CARNUMS) {
		this.CARNUMS = CARNUMS;
	}

	public String getMinontime() {
		return minontime;
	}

	public void setMinontime(String minontime) {
		this.minontime = minontime;
	}

	public String getMaxontime() {
		return maxontime;
	}

	public void setMaxontime(String maxontime) {
		this.maxontime = maxontime;
	}

	public String getAvgyyje() {
		return avgyyje;
	}

	public void setAvgyyje(String avgyyje) {
		this.avgyyje = avgyyje;
	}

	public String getAvgyylc_sum() {
		return avgyylc_sum;
	}

	public void setAvgyylc_sum(String avgyylc_sum) {
		this.avgyylc_sum = avgyylc_sum;
	}


	public String getAvgyylc() {
		return avgyylc;
	}

	public void setAvgyylc(String avgyylc) {
		this.avgyylc = avgyylc;
	}

	public String getYysj() {
		return yysj;
	}

	public void setYysj(String yysj) {
		this.yysj = yysj;
	}

	public String getDhsj() {
		return dhsj;
	}

	public void setDhsj(String dhsj) {
		this.dhsj = dhsj;
	}

	public String getSMKNUMS() {
		return SMKNUMS;
	}

	public void setSMKNUMS(String SMKNUMS) {
		this.SMKNUMS = SMKNUMS;
	}

	public String getYLNUMS() {
		return YLNUMS;
	}

	public void setYLNUMS(String YLNUMS) {
		this.YLNUMS = YLNUMS;
	}

	public String getYYCC() {
		return YYCC;
	}

	public void setYYCC(String YYCC) {
		this.YYCC = YYCC;
	}

	public String getRJSR() {
		return RJSR;
	}

	public void setRJSR(String RJSR) {
		this.RJSR = RJSR;
	}



	public String getLCLYL() {
		return LCLYL;
	}

	public void setLCLYL(String LCLYL) {
		this.LCLYL = LCLYL;
	}

	public String getPJYJ() {
		return PJYJ;
	}

	public void setPJYJ(String PJYJ) {
		this.PJYJ = PJYJ;
	}

	public String getBGLYS() {
		return BGLYS;
	}

	public void setBGLYS(String BGLYS) {
		this.BGLYS = BGLYS;
	}

	public String getRJXSLC() {
		return RJXSLC;
	}

	public void setRJXSLC(String RJXSLC) {
		this.RJXSLC = RJXSLC;
	}

	public String getPJFWCC() {
		return PJFWCC;
	}

	public void setPJFWCC(String PJFWCC) {
		this.PJFWCC = PJFWCC;
	}

	public String getSMK() {
		return SMK;
	}

	public void setSMK(String SMK) {
		this.SMK = SMK;
	}

	public String getSMKBL() {
		return SMKBL;
	}

	public void setSMKBL(String SMKBL) {
		this.SMKBL = SMKBL;
	}

	public String getYLKBL() {
		return YLKBL;
	}

	public void setYLKBL(String YLKBL) {
		this.YLKBL = YLKBL;
	}

	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getDayTime() {
		return dayTime;
	}
	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}
	public String getRunNums() {
		return runNums;
	}
	public void setRunNums(String runNums) {
		this.runNums = runNums;
	}
	public String getRunMoney() {
		return runMoney;
	}
	public void setRunMoney(String runMoney) {
		this.runMoney = runMoney;
	}
	public String getRunDis() {
		return runDis;
	}
	public void setRunDis(String runDis) {
		this.runDis = runDis;
	}
	public String getTradDis() {
		return tradDis;
	}
	public void setTradDis(String tradDis) {
		this.tradDis = tradDis;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public long getStartRecordNum() {
		return startRecordNum;
	}
	public void setStartRecordNum(long startRecordNum) {
		this.startRecordNum = startRecordNum;
	}
	public long getEndRecordNum() {
		return endRecordNum;
	}
	public void setEndRecordNum(long endRecordNum) {
		this.endRecordNum = endRecordNum;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public String getDevId() {
		return devId;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}
	public String getDriveName() {
		return driveName;
	}
	public String getOnTime() {
		return onTime;
	}
	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}
	public String getOffTime() {
		return offTime;
	}
	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}
	public String getYyDis() {
		return yyDis;
	}
	public void setYyDis(String yyDis) {
		this.yyDis = yyDis;
	}
	public String getNoneDis() {
		return noneDis;
	}
	public void setNoneDis(String noneDis) {
		this.noneDis = noneDis;
	}
	public String getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
	public String getTradMoney() {
		return tradMoney;
	}
	public void setTradMoney(String tradMoney) {
		this.tradMoney = tradMoney;
	}
	public String getKslc()
	{
		return kslc;
	}
	public void setKslc(String kslc)
	{
		this.kslc = kslc;
	}
	public String getZkl()
	{
		return zkl;
	}
	public void setZkl(String zkl)
	{
		this.zkl = zkl;
	}
	public String getTs()
	{
		return ts;
	}
	public void setTs(String ts)
	{
		this.ts = ts;
	}
	
	public String getKsl()
	{
		return ksl;
	}
	public void setKsl(String ksl)
	{
		this.ksl = ksl;
	}
	public String getRjyycs()
	{
		return rjyycs;
	}
	public void setRjyycs(String rjyycs)
	{
		this.rjyycs = rjyycs;
	}
	public String getRjdcxslc()
	{
		return rjdcxslc;
	}
	public void setRjdcxslc(String rjdcxslc)
	{
		this.rjdcxslc = rjdcxslc;
	}
	public String getRjdczklc()
	{
		return rjdczklc;
	}
	public void setRjdczklc(String rjdczklc)
	{
		this.rjdczklc = rjdczklc;
	}
	public String getRjdcyycs()
	{
		return rjdcyycs;
	}
	public void setRjdcyycs(String rjdcyycs)
	{
		this.rjdcyycs = rjdcyycs;
	}
	public String getDcrjys()
	{
		return dcrjys;
	}
	public void setDcrjys(String dcrjys)
	{
		this.dcrjys = dcrjys;
	}
	public int getCarNum()
	{
		return carNum;
	}
	public void setCarNum(int carNum)
	{
		this.carNum = carNum;
	}
	public String getOwnerId()
	{
		return ownerId;
	}
	public void setOwnerId(String ownerId)
	{
		this.ownerId = ownerId;
	}
	public String getDcrjmglsr()
	{
		return dcrjmglsr;
	}
	public void setDcrjmglsr(String dcrjmglsr)
	{
		this.dcrjmglsr = dcrjmglsr;
	}
	public String getDcyypjyj()
	{
		return dcyypjyj;
	}
	public void setDcyypjyj(String dcyypjyj)
	{
		this.dcyypjyj = dcyypjyj;
	}
	public int getDdywl()
	{
		return ddywl;
	}
	public void setDdywl(int ddywl)
	{
		this.ddywl = ddywl;
	}
	public int getDdcgl()
	{
		return ddcgl;
	}
	public void setDdcgl(int ddcgl)
	{
		this.ddcgl = ddcgl;
	}
	public String getCgl()
	{
		return cgl;
	}
	public void setCgl(String cgl)
	{
		this.cgl = cgl;
	}

	public String getOWNERNAME() {
		return OWNERNAME;
	}

	public void setOWNERNAME(String OWNERNAME) {
		this.OWNERNAME = OWNERNAME;
	}

	public String getYYLC_SUM() {
		return YYLC_SUM;
	}

	public void setYYLC_SUM(String YYLC_SUM) {
		this.YYLC_SUM = YYLC_SUM;
	}

	public String getYYLC() {
		return YYLC;
	}

	public void setYYLC(String YYLC) {
		this.YYLC = YYLC;
	}

	public String getMSUM() {
		return MSUM;
	}

	public void setMSUM(String MSUM) {
		this.MSUM = MSUM;
	}

	public String getYYCS_SUM() {
		return YYCS_SUM;
	}

	public void setYYCS_SUM(String YYCS_SUM) {
		this.YYCS_SUM = YYCS_SUM;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getAvgkslc_sum() {
		return avgkslc_sum;
	}

	public void setAvgkslc_sum(String avgkslc_sum) {
		this.avgkslc_sum = avgkslc_sum;
	}

	public String getAvgyysj() {
		return avgyysj;
	}

	public void setAvgyysj(String avgyysj) {
		this.avgyysj = avgyysj;
	}

	public String getAvgdhsj() {
		return avgdhsj;
	}

	public void setAvgdhsj(String avgdhsj) {
		this.avgdhsj = avgdhsj;
	}

	public String getAvgyycs_sum() {
		return avgyycs_sum;
	}

	public void setAvgyycs_sum(String avgyycs_sum) {
		this.avgyycs_sum = avgyycs_sum;
	}

	public String getSumTs() {
		return sumTs;
	}

	public void setSumTs(String sumTs) {
		this.sumTs = sumTs;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public String getSKBS() {
		return SKBS;
	}

	public void setSKBS(String SKBS) {
		this.SKBS = SKBS;
	}

	public String getSKJE() {
		return SKJE;
	}

	public void setSKJE(String SKJE) {
		this.SKJE = SKJE;
	}

	public String getSKBL() {
		return SKBL;
	}

	public void setSKBL(String SKBL) {
		this.SKBL = SKBL;
	}

	public String getAvgkslc() {
		return avgkslc;
	}

	public void setAvgkslc(String avgkslc) {
		this.avgkslc = avgkslc;
	}

	public String getAvgyycs() {
		return avgyycs;
	}

	public void setAvgyycs(String avgyycs) {
		this.avgyycs = avgyycs;
	}

	public String getYYJE() {
		return YYJE;
	}

	public void setYYJE(String YYJE) {
		this.YYJE = YYJE;
	}

	public String getZLC() {
		return ZLC;
	}

	public void setZLC(String ZLC) {
		this.ZLC = ZLC;
	}

	public String getAvgzlc() {
		return avgzlc;
	}

	public void setAvgzlc(String avgzlc) {
		this.avgzlc = avgzlc;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
}
