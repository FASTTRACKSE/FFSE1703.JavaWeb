package hibernate.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import hibernate.entity.SinhVien;

public class SinhVienListExcel extends AbstractXlsView    {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<SinhVien> sinhVienList = (List<SinhVien>) model.get("listSinhVien");
		Sheet sheet = workbook.createSheet("Student Data");
		
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Mã Sinh Viên");
		header.createCell(1).setCellValue("Họ Tên");
		header.createCell(2).setCellValue("Năm Sinh");
		header.createCell(3).setCellValue("Quê Quán");
		header.createCell(4).setCellValue("Email");
		header.createCell(5).setCellValue("Điện Thoại");
		header.createCell(6).setCellValue("Mã Lớp");
		header.createCell(7).setCellValue("Hình Ảnh");
		
		
		int rowNum = 1;
		for(SinhVien sv : sinhVienList){
			Row row = sheet.createRow(rowNum++);
			 row.createCell(0).setCellValue(sv.getMaSv());
			 row.createCell(1).setCellValue(sv.getHoTen());
			 row.createCell(2).setCellValue(sv.getNamSinh());
			 row.createCell(3).setCellValue(sv.getQueQuan());
			 row.createCell(4).setCellValue(sv.getEmail());
			 row.createCell(5).setCellValue(sv.getDienThoai());
			 row.createCell(6).setCellValue(sv.getMaLop());
			 row.createCell(7).setCellValue(sv.getHinhAnh());
			
		}
		
	}

}
