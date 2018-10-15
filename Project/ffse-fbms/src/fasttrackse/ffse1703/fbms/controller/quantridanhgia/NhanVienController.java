package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.NhanVienService;
import fasttrackse.ffse1703.fbms.service.security.UserAccountService;

@Controller
@RequestMapping("/quantridanhgia/nhanvien")
public class NhanVienController {

	private static final String UPLOAD_DIRECTORY = "/upload";

	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB

	public NhanVienService nhanVienService;

	public UserAccountService accountService;

	@Autowired
	@Qualifier(value = "userAccountServiceImpl")
	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	@Autowired
	@Qualifier(value = "nhanVienServiceImpl")
	public void setNhanVienService(NhanVienService nhanVienService) {
		this.nhanVienService = nhanVienService;
	}

	public HoSoNhanVien getInfo() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserAccount user = accountService.loadUserByUsername(auth.getName());
		return user.getNhanVien();
	}

	@RequestMapping(value = { "", "/" })
	public String redirectPage(Model model, HttpSession session) {

		return "redirect:/quantridanhgia/nhanvien/danhgiabanthan";
	}

	@RequestMapping(value = { "/danhgiabanthan" })
	public String getDanhGiaBanThan(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = getInfo();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(nhanVien.getPhongBan().getMaPhongBan());
		if (lich != null) {
			if (nhanVienService.getDanhGiaBanThan(nhanVien, lich.getKyDanhGia()) != null) {
				model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(nhanVien, lich.getKyDanhGia()));
			}
		}
		return "QuanTriDanhGia/nhanvien/danhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/add")
	public String createDanhGiaBanThan(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = getInfo();
		PhongBan phongBan = nhanVien.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		DanhGiaBanThan danhGia = new DanhGiaBanThan();
		danhGia.setKyDanhGia(lich.getKyDanhGia());
		danhGia.setPhongBan(phongBan);
		danhGia.setNhanVien(nhanVien);
		model.addAttribute("command", danhGia);
		return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/edit")
	public String editDanhGiaBanThan(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = getInfo();
		PhongBan phongBan = nhanVien.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		DanhGiaBanThan danhGia = new DanhGiaBanThan();
		danhGia = nhanVienService.getDanhGiaBanThan(nhanVien, lich.getKyDanhGia());
		model.addAttribute("command", danhGia);
		return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
	}

	@RequestMapping(value = "/danhgiabanthan/submit", method = RequestMethod.POST)
	public String submitDanhGiaBanThan(Model model, @ModelAttribute("command") @Valid DanhGiaBanThan danhGia,
			BindingResult result) {
		if (result.hasErrors()) {
			return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
		}
		if (danhGia.getId() == 0) {
			nhanVienService.insertDanhGiaBanThan(danhGia);
		} else {
			nhanVienService.updateDanhGiaBanThan(danhGia);
		}
		return "redirect:/quantridanhgia/nhanvien";
	}

	@RequestMapping(value = { "/danhgianhanvien" })
	public String getListDanhGiaNhanVien(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = getInfo();
		PhongBan phongBan = nhanVien.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		List<DanhGiaNhanVien> list = nhanVienService.getListDanhGiaNhanVien(nhanVien, lich.getKyDanhGia());
		model.addAttribute("listDanhGiaNhanVien", list);
		return "QuanTriDanhGia/nhanvien/danhgianhanvien";
	}

	@RequestMapping(value = { "/danhgianhanvien/create" })
	public String createListDanhGiaNhanVien(Model model, HttpSession session) throws IOException {
		HoSoNhanVien nhanVien = getInfo();
		PhongBan phongBan = nhanVien.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		List<HoSoNhanVien> listNhanVien = nhanVienService.getListNhanVienPhongBan(phongBan.getMaPhongBan());
		List<DanhGiaNhanVien> list = new ArrayList<>();
		for (int i = 0; i < listNhanVien.size(); i++) {
			if (listNhanVien.get(i).getMaNhanVien() == nhanVien.getMaNhanVien()) {
				List<HoSoNhanVien> listNhanVienLimit = nhanVienService.getListNhanVienLimit(listNhanVien.get(i),
						phongBan);
				for (HoSoNhanVien x : listNhanVienLimit) {
					DanhGiaNhanVien danhGia = new DanhGiaNhanVien();
					danhGia.setKyDanhGia(lich.getKyDanhGia());
					danhGia.setPhongBan(phongBan);
					danhGia.setNhanVienDanhGia(nhanVien.getMaNhanVien());
					danhGia.setNhanVien(x);
					list.add(danhGia);
				}
				break;
			}
		}
		nhanVienService.createDanhGiaNhanVien(list);
		return "redirect:/quantridanhgia/nhanvien/danhgianhanvien";
	}

	@RequestMapping("/danhgianhanvien/add/{nhanvien}/{id}")
	public String createDanhGiaNhanVien(Model model, @PathVariable("id") int id,
			@PathVariable("nhanvien") int nhanVien) {
		HoSoNhanVien hoSo = nhanVienService.getHoSoNhanVien(nhanVien);
		PhongBan phongBan = hoSo.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		if (nhanVienService.getDanhGiaBanThan(hoSo, lich.getKyDanhGia()) != null) {
			model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(hoSo, lich.getKyDanhGia()));
		}
		model.addAttribute("command", nhanVienService.getDanhGiaNhanVien(id));
		return "QuanTriDanhGia/nhanvien/formdanhgianhanvien";
	}

	@RequestMapping("/danhgianhanvien/edit/{nhanvien}/{id}")
	public String updateDanhGiaNhanVien(Model model, @PathVariable("id") int id,
			@PathVariable("nhanvien") int nhanVien) {
		HoSoNhanVien hoSo = nhanVienService.getHoSoNhanVien(nhanVien);
		PhongBan phongBan = hoSo.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		if (nhanVienService.getDanhGiaBanThan(hoSo, lich.getKyDanhGia()) != null) {
			model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(hoSo, lich.getKyDanhGia()));
		}
		model.addAttribute("command", nhanVienService.getDanhGiaNhanVien(id));
		return "QuanTriDanhGia/nhanvien/formdanhgianhanvien";
	}

	@RequestMapping(value = "/danhgianhanvien/submit", method = RequestMethod.POST)
	public String submitDanhGiaNhanVien(Model model, @ModelAttribute("command") @Valid DanhGiaNhanVien danhGia,
			BindingResult result) {
		if (result.hasErrors()) {
			HoSoNhanVien hoSo = danhGia.getNhanVien();
			PhongBan phongBan = hoSo.getPhongBan();
			LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
			model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(hoSo, lich.getKyDanhGia()));
			return "QuanTriDanhGia/nhanvien/formdanhgianhanvien";
		}
		nhanVienService.updateDanhGiaNhanVien(danhGia);
		return "redirect:/quantridanhgia/nhanvien/danhgianhanvien";
	}

	@RequestMapping("/nhanviendanhgia")
	public String getListNhanVienDanhGia(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = getInfo();
		PhongBan phongBan = nhanVien.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		model.addAttribute("listDanhGia", nhanVienService.getListNhanVienDanhGia(nhanVien, lich.getKyDanhGia()));
		return "QuanTriDanhGia/nhanvien/nhanviendanhgia";
	}

	@RequestMapping("/danhgianhanvien/view/{id}")
	public String viewDanhGiaNhanVien(Model model, @PathVariable int id) {
		model.addAttribute("danhGia", nhanVienService.getNhanVienDanhGia(id));
		return "QuanTriDanhGia/nhanvien/viewdanhgia";
	}

	@RequestMapping("/nhanviendanhgia/view/{id}")
	public String viewNhanVienDanhGia(Model model, @PathVariable int id) {
		model.addAttribute("danhGia", nhanVienService.getNhanVienDanhGia(id));
		return "QuanTriDanhGia/nhanvien/viewdanhgianhanvien";
	}

	@RequestMapping("/danhgiacuatruongphong")
	public String viewDanhGiaCuaTruongPhong(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = getInfo();
		PhongBan phongBan = nhanVien.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		if (lich != null) {
			model.addAttribute("danhGia", nhanVienService.getDanhGiaCuaTruongPhong(nhanVien, lich.getKyDanhGia()));
		}
		return "QuanTriDanhGia/nhanvien/danhgiacuatruongphong";
	}

	@RequestMapping("/danhgianhanvien/exportcheckpoint")
	public ModelAndView exportExcelFile() {
		ModelAndView model = new ModelAndView("excelHandler");
		HoSoNhanVien nhanVien = getInfo();
		PhongBan phongBan = nhanVien.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		List<DanhGiaNhanVien> list = nhanVienService.getListDanhGiaNhanVien(nhanVien, lich.getKyDanhGia());
		model.addObject("listDanhGia", list);
		return model;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/uploadcheckpoint", method = RequestMethod.POST)
	public String exportExcelFile(@RequestParam MultipartFile file, HttpSession session) throws IOException {
//		HoSoNhanVien nhanVien = getInfo();
//		PhongBan phongBan = nhanVien.getPhongBan();
//		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
//		List<DanhGiaNhanVien> list = nhanVienService.getListDanhGiaNhanVien(nhanVien.getMaNhanVien(),
//				lich.getKyDanhGia());
//		

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		ServletContext context = session.getServletContext();

		String uploadPath = context.getRealPath(UPLOAD_DIRECTORY);
		System.out.println(uploadPath);

		File path = new File(uploadPath);
		if (!path.exists()) {
			path.mkdirs();
		}
		File filePath = new File(uploadPath + File.separator + file.getOriginalFilename());
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(filePath));
		stream.write(bytes);
		stream.flush();
		stream.close();
//		list = readExcelFile(filePath.getPath(), list);

		return "redirect:/quantridanhgia/nhanvien/danhgianhanvien";
	}

	@SuppressWarnings("resource")
	public List<DanhGiaNhanVien> readExcelFile(String file, List<DanhGiaNhanVien> danhGia) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.getSheetAt(0);
		int rowNum = 3;
		for (DanhGiaNhanVien x : danhGia) {
			for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
				Row row = sheet.getRow(rowNum++);
				if ((int) row.getCell(0).getNumericCellValue() == x.getNhanVien().getMaNhanVien()) {
					x.setKyLuatCongViec(row.getCell(3).getStringCellValue());
					x.setTinhThanLamViec(row.getCell(4).getStringCellValue());
					x.setKhoiLuongCongViec(row.getCell(5).getStringCellValue());
					x.setKetQuaCongViec(row.getCell(6).getStringCellValue());
					x.setKyNangTichLuy(row.getCell(7).getStringCellValue());
					x.setDinhHuong(row.getCell(8).getStringCellValue());
					x.setXepLoai((int) row.getCell(9).getNumericCellValue());
				}
			}
		}
		return danhGia;
	}
}
