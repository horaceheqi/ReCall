package com.cyou.bi.ms.ds.recall.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.CharEncoding;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyou.bi.ms.ds.recall.bean.RecallSystemData;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController(value = "recall数据导出Excel接口")
@RequestMapping(value = "/ds")
public class ExcelController {
	private static final Logger logger = LoggerFactory
			.getLogger(ExcelController.class);
	//	private static final String logFormat = "Processing with  body:{} ";
	@Autowired
	private ExcelService excelService;

	@ApiOperation(value = "reCallExcel", notes = "请求内容在body", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "body", name = "body", dataType = "String", required = false, value = "请求体") })

	@RequestMapping(value = "/dumpexcel", method = RequestMethod.POST)
	public void getExcel(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//request.setCharacterEncoding("iso-8859-1");
		String cnmaster = null;
		String serverid = null;
		String startLossDays = null;
		String endLossDays = null;
		String gamename = null;
		String followerNumber = null;
		String status = null;
		String startRecallDate = null;
		String endRecallDate = null;
		String startLossDate = null;
		String endLossDate = null;
		String startInterposeDate = null;
		String endInterposeDate = null;
		String level = null;
		String interposeStatus = null;
		String hasManualSendGift = null;
		if (request.getParameter("cnmaster") != null
				&& request.getParameter("cnmaster") != ""
				&& !request.getParameter("cnmaster").equals("")) {
			cnmaster = request.getParameter("cnmaster");
		}
		if (request.getParameter("serverid") != null
				&& request.getParameter("serverid") != ""
				&& !request.getParameter("serverid").equals("")) {
			serverid = request.getParameter("serverid");
		}
		if (request.getParameter("startLossDays") != null
				&& request.getParameter("startLossDays") != ""
				&& !request.getParameter("startLossDays").equals("")) {
			startLossDays = request.getParameter("startLossDays");
		}

		if (request.getParameter("endLossDays") != null
				&& request.getParameter("endLossDays") != ""
				&& !request.getParameter("endLossDays").equals("")) {
			endLossDays = URLDecoder.decode(request.getParameter("endLossDays"),
					"UTF-8");
		}
		if (request.getParameter("gamename") != null
				&& request.getParameter("gamename") != ""
				&& !request.getParameter("gamename").equals("")) {
			gamename = new String(
					request.getParameter("gamename").getBytes("ISO-8859-1"),
					"UTF-8");
		}
		if (request.getParameter("followerNumber") != null
				&& request.getParameter("followerNumber") != ""
				&& !request.getParameter("followerNumber").equals("")) {
			followerNumber = new String(request.getParameter("followerNumber")
					.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (request.getParameter("status") != null
				&& request.getParameter("status") != ""
				&& !request.getParameter("status").equals("")) {
			status = new String(
					request.getParameter("status").getBytes("ISO-8859-1"),
					"UTF-8");
		}

		if (request.getParameter("startRecallDate") != null
				&& request.getParameter("startRecallDate") != ""
				&& !request.getParameter("startRecallDate").equals("")) {
			startRecallDate = request.getParameter("startRecallDate");
		}
		if (request.getParameter("endRecallDate") != null
				&& request.getParameter("endRecallDate") != ""
				&& !request.getParameter("endRecallDate").equals("")) {
			endRecallDate = request.getParameter("endRecallDate");
		}
		if (request.getParameter("startLossDate") != null
				&& request.getParameter("startLossDate") != ""
				&& !request.getParameter("startLossDate").equals("")) {
			startLossDate = request.getParameter("startLossDate");
		}
		if (request.getParameter("endLossDate") != null
				&& request.getParameter("endLossDate") != ""
				&& !request.getParameter("endLossDate").equals("")) {
			endLossDate = request.getParameter("endLossDate");
		}
		if (request.getParameter("startInterposeDate") != null
				&& request.getParameter("startInterposeDate") != ""
				&& !request.getParameter("startInterposeDate").equals("")) {
			startInterposeDate = request.getParameter("startInterposeDate");
		}
		if (request.getParameter("endInterposeDate") != null
				&& request.getParameter("endInterposeDate") != ""
				&& !request.getParameter("endInterposeDate").equals("")) {
			endInterposeDate = request.getParameter("endInterposeDate");
		}
		if (request.getParameter("level") != null
				&& request.getParameter("level") != ""
				&& !request.getParameter("level").equals("")) {
			level = request.getParameter("level");
		}
		if (request.getParameter("interposeStatus") != null
				&& request.getParameter("interposeStatus") != ""
				&& !request.getParameter("interposeStatus").equals("")) {
			interposeStatus = request.getParameter("interposeStatus");
		}
		if (request.getParameter("hasManualSendGift") != null
				&& request.getParameter("hasManualSendGift") != ""
				&& !request.getParameter("hasManualSendGift").equals("")) {
			hasManualSendGift = request.getParameter("hasManualSendGift");
		}
		RecallSystemData param = new RecallSystemData();
		if (cnmaster != null)
			param.setCnmaster(cnmaster.trim().toString());
		if (serverid != null)
			param.setServerid(Integer.parseInt(serverid));
		if (startLossDays != null)
			param.setStartLossDays(Integer.parseInt(startLossDays));
		if (endLossDays != null)
			param.setEndLossDays(Integer.parseInt(endLossDays));
		if (gamename != null)
			param.setGamename(gamename.trim().toString());
		if (followerNumber != null)
			param.setFollowerNumber(followerNumber.trim().toString());
		if (status != null)
			param.setStatus(status.trim().toString());
		if (startRecallDate != null)
			param.setStartRecallDate(startRecallDate.trim().toString());
		if (endRecallDate != null)
			param.setEndRecallDate(endRecallDate.trim().toString());
		if (startLossDate != null)
			param.setStartLossDate(startLossDate.trim().toString());
		if (endLossDate != null)
			param.setEndLossDate(endLossDate.trim().toString());
		if (startInterposeDate != null)
			param.setStartInterposeDate(startInterposeDate.trim().toString());
		if (endInterposeDate != null)
			param.setEndInterposeDate(endInterposeDate.trim().toString());
		if (level != null)
			param.setLevel(Integer.parseInt(level));
		if (interposeStatus != null)
			param.setInterposeStatus(Integer.parseInt(interposeStatus));
		if (hasManualSendGift != null)
			param.setHasManualSendGift(Integer.parseInt(hasManualSendGift));
		logger.info("data:" + "cnmaster:" + cnmaster + "serverid:" + serverid
				+ "startLossDays:" + startLossDays + "endLossDays:"
				+ endLossDays + "gamename:" + gamename + "followerNumber:"
				+ followerNumber + "status:" + status + "startRecallDate:"
				+ startRecallDate + "endRecallDate:" + endRecallDate
				+ "startLossDate:" + startLossDate + "endLossDate:"
				+ endLossDate + "startInterposeDate:" + startInterposeDate
				+ "endInterposeDate:" + endInterposeDate + "level:" + level
				+ "interposeStatus:" + interposeStatus + "hasManualSendGift:"
				+ hasManualSendGift);
		List<RecallSystemData> getData = excelService.getDataExcel(param);
		//设置
		logger.info("getData:" + getData.size());
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("统计表");
		createTitle(workbook, sheet);
		//设置日期格式  
		HSSFCellStyle style = workbook.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("yy-m-d"));

		//新增数据行，并且设置单元格数据  干预状态	干预后付费	状态	发送礼包	跟进员工
		int rowNum = 1;
		for (RecallSystemData exceldata : getData) {
			HSSFRow row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(exceldata.getGamename());
			row.createCell(1).setCellValue(exceldata.getLossDays());
			HSSFCell cell1 = row.createCell(2);
			cell1.setCellValue(exceldata.getLossDate());
			cell1.setCellStyle(style);
			HSSFCell cell2 = row.createCell(3);
			cell2.setCellValue(exceldata.getRecallDate());
			cell2.setCellStyle(style);
			row.createCell(4).setCellValue(exceldata.getCnmaster());
			row.createCell(5).setCellValue(exceldata.getLevel());
			row.createCell(6).setCellValue(exceldata.getServerid());
			HSSFCell cell3 = row.createCell(7);
			cell3.setCellValue(exceldata.getInterposeDate());
			cell3.setCellStyle(style);
			row.createCell(8).setCellValue(exceldata.getInterposeStatus());
			row.createCell(9).setCellValue(exceldata.getRecallMoney());
			row.createCell(10).setCellValue(exceldata.getStatus());
			row.createCell(11).setCellValue(exceldata.getHasManualSendGift());
			row.createCell(12).setCellValue(exceldata.getFollowerNumber());
			rowNum++;
		}
		//	        //拼装excelName 
		// 对文件名进行处理。防止文件名乱码
		String fileName = CharEncoding.UTF_8;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateTime = dateFormat.format(new Date());
		fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".xls";
		String excelName = dateTime + fileName;
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// Content-disposition属性设置成以附件方式进行下载
		response.setHeader("Content-disposition",
				"attachment;filename=" + excelName);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		workbook.write(byteArrayOutputStream);
		InputStream excelStream = new ByteArrayInputStream(
				byteArrayOutputStream.toByteArray());
		int len = 0;
		byte[] buffer = new byte[1024];
		OutputStream out = response.getOutputStream();
		while ((len = excelStream.read(buffer)) > 0) {
			out.write(buffer, 0, len);//将缓冲区的数据输出到客户端浏览器  
		}
		excelStream.close();
	}

	/*** 
	 * 创建表头 
	 * @param workbook 
	 * @param sheet 
	 */
	private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		//设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度  
		sheet.setColumnWidth(2, 12 * 256);
		sheet.setColumnWidth(3, 17 * 256);
		//设置为居中加粗  
		//		HSSFCellStyle style = workbook.createCellStyle();
		//		HSSFFont font = workbook.createFont();
		//		font.setBoldweight(true);
		//		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//		style.setFont(font);干预状态	干预后付费	状态	发送礼包	跟进员工
		HSSFCell cell;
		cell = row.createCell(0);
		cell.setCellValue("游戏名称");
		cell = row.createCell(1);
		cell.setCellValue("流失天数");
		cell = row.createCell(2);
		cell.setCellValue("流失日期");
		cell = row.createCell(3);
		cell.setCellValue("回流日期");
		cell = row.createCell(4);
		cell.setCellValue("天龙账号");
		cell = row.createCell(5);
		cell.setCellValue("vip等级");
		cell = row.createCell(6);
		cell.setCellValue("serverID");
		cell = row.createCell(7);
		cell.setCellValue("干预日期");
		cell = row.createCell(8);
		cell.setCellValue("干预状态");
		cell = row.createCell(9);
		cell.setCellValue("干预后付费");
		cell = row.createCell(10);
		cell.setCellValue("状态");
		cell = row.createCell(11);
		cell.setCellValue("发送礼包");
		cell = row.createCell(12);
		cell.setCellValue("跟进员工");
	}

}
