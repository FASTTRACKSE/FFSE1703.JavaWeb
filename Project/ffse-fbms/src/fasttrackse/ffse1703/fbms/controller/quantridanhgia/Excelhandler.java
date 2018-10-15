package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDataValidationHelper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataValidation.ErrorStyle;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationConstraint.OperatorType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;

public class Excelhandler extends AbstractXlsView {
	private static String[] columns = { "Mã nhân viên", "Họ đệm", "Tên", "Kỷ luật công viêc", "Tinh thần làm việc",
			"Khối lượng công việc", "Kết quả công việc", "Kỹ năng tích lũy", "Định hướng", "Xếp loại (INT)" };

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Create a Workbook
		List<DanhGiaNhanVien> danhGia = (List<DanhGiaNhanVien>) model.get("listDanhGia");

		// Create a Sheet
		HSSFSheet sheet = (HSSFSheet) workbook.createSheet("CheckPoint");
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columns.length-1));

		// create font
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 24);
		font.setBold(true);

		Font fontTh = workbook.createFont();
		fontTh.setFontHeightInPoints((short) 10);
		fontTh.setBold(true);

		Font fontTd = workbook.createFont();
		fontTd.setFontHeightInPoints((short) 10);

		// Set font into style
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);

		CellStyle styleTh = workbook.createCellStyle();
		styleTh.setFont(fontTh);

		CellStyle styleTd = workbook.createCellStyle();
		styleTd.setFont(fontTd);

		// Set borders
		styleTh.setBorderBottom(BorderStyle.THIN);
		styleTh.setBorderTop(BorderStyle.THIN);
		styleTh.setBorderRight(BorderStyle.THIN);
		styleTh.setBorderLeft(BorderStyle.THIN);

		styleTd.setBorderBottom(BorderStyle.THIN);
		styleTd.setBorderTop(BorderStyle.THIN);
		styleTd.setBorderRight(BorderStyle.THIN);
		styleTd.setBorderLeft(BorderStyle.THIN);

		// Create title
		Row title = sheet.createRow(0);
		Cell cellTitle = title.createCell(0);
		cellTitle.setCellValue("Danh sách đánh giá được phân công");
		cellTitle.setCellStyle(style);

		// Create header
		Row header = sheet.createRow(1);
		for (int i = 0; i < columns.length; i++) {
			Cell cellHeader = header.createCell(i);
			cellHeader.setCellValue(columns[i]);
			cellHeader.setCellStyle(styleTh);
		}

		// Create Other rows and cells
		Row row = sheet.createRow(2);
		int rowNum = 3;
		for (DanhGiaNhanVien x : danhGia) {
			row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(x.getNhanVien().getMaNhanVien());
			row.createCell(1).setCellValue(x.getNhanVien().getHoDem());
			row.createCell(2).setCellValue(x.getNhanVien().getTen());
			row.createCell(3).setCellValue(x.getKyLuatCongViec());
			row.createCell(4).setCellValue(x.getTinhThanLamViec());
			row.createCell(5).setCellValue(x.getKhoiLuongCongViec());
			row.createCell(6).setCellValue(x.getKetQuaCongViec());
			row.createCell(7).setCellValue(x.getKyNangTichLuy());
			row.createCell(8).setCellValue(x.getDinhHuong());
			Cell cell = row.createCell(sheet.getRow(1).getLastCellNum()-1);
			cell.setCellValue(x.getXepLoai());
			cell.setCellType(CellType.NUMERIC);

		}
		for (int i = 0; i < sheet.getRow(2).getLastCellNum(); i++) {
			for (int j = 0; j < sheet.getLastRowNum(); j++) {
				Cell cellTd = row.getCell(j);
				cellTd.setCellStyle(styleTd);
			}
		}
		
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

	}

}
