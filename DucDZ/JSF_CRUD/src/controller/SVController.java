package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import bean.SinhVien;
import dao.SVDao;

@ManagedBean(name = "svControl")
@SessionScoped
public class SVController {
	private int pageCurrent, pageTotal, perPage, pageJump;
	private ArrayList<SinhVien> listSV;
	private SVDao dao;
	private Logger logger = Logger.getLogger(getClass().getName());

	public SVController() throws SQLException {
		pageCurrent = 1;
		pageTotal = 1;
		perPage = 5;
		pageJump = 2;
		listSV = new ArrayList<SinhVien>();
		dao = SVDao.getInstance();
		FacesContext ctx = FacesContext.getCurrentInstance();
		this.perPage = Integer.parseInt(ctx.getExternalContext().getInitParameter("paging_size"));
		this.pageJump = Integer.parseInt(ctx.getExternalContext().getInitParameter("paging_jump"));
		loadSVToArrayList();
	}

	public ArrayList<SinhVien> getListSV() {
		return listSV;
	}

	public void setListSV(ArrayList<SinhVien> listSV) {
		this.listSV = listSV;
	}

	public void loadSVToArrayList() {
		logger.info("Loading SV");
		listSV.clear();
		countPageTotal();
		try {
			listSV = dao.listSinhVien(pageCurrent, perPage);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error loading SV", e);
			addErrorMessage(e);
		}
	}

	public String loadSV(int svID) {
		logger.info("Loading student: " + svID);
		try {
			SinhVien sv = dao.getSV(svID);
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> requestMap = externalContext.getSessionMap();
			requestMap.put("sv", sv);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error loading student id:" + svID);
			addErrorMessage(e);
			return null;
		}
		return "updateSV.xhtml?faces-redirect=true";
	}

	public String addSV(SinhVien sv) {
		logger.info("Add SV :" + sv);
		try {
			dao.addSV(sv);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error Adding SV");
			addErrorMessage(e);
			return null;
		}
		return "listSV.xhtml?faces-redirect=true";
	}

	public String updateSV(SinhVien sv) {
		logger.info("updating student: " + sv);
		String page = "";
		System.out.println(sv.getId());
		try {
			if (dao.updateSV(sv) == true) {
				page = "listSV.xhtml?faces-redirect=true";
			}
		} catch (SQLException exc) {
			logger.log(Level.SEVERE, "Error updating student: " + sv, exc);
			addErrorMessage(exc);
		}
		loadSVToArrayList();
		return page;
	}

	public String deleteSV(int svID) {
		logger.info("Delete SV id: " + svID);
		try {
			dao.deleteSV(svID);
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Error Delete SV id: " + svID, ex);
			addErrorMessage(ex);
			return null;
		}
		loadSVToArrayList();
		return "listSV.xhtml";
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public String getFirstPage() {
		this.pageCurrent = 1;
		loadSVToArrayList();
		return "listSV.xhtml";
	}

	public String getLastPage() {
		this.pageCurrent = pageTotal;
		loadSVToArrayList();
		return "listSV.xhtml";
	}

	public String getPrevPage() {
		if (pageCurrent > 1) {
			pageCurrent--;
			loadSVToArrayList();
		}
		return "listSV.xhtml";
	}

	public String getNextPage() {
		if (pageCurrent < pageTotal) {
			pageCurrent++;
			loadSVToArrayList();
		}
		return "listSV.xhtml";
	}

	public String getFastPrevPage() {
		if (pageCurrent > pageJump) {
			pageCurrent -= pageJump;
		} else {
			pageCurrent = 1;
		}
		loadSVToArrayList();
		return "listSV.xhtml";
	}

	public String getFastNextPage() {
		if (pageCurrent < pageTotal - pageJump) {
			pageCurrent += pageJump;
		} else {
			pageCurrent = pageTotal;
		}
		loadSVToArrayList();
		return "listSV.xhtml";
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public void countPageTotal() {
		int totalSV = 0;
		logger.info("Get total SV");
		try {
			totalSV = dao.countSV();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error count SV", e);
			addErrorMessage(e);
		}
		pageTotal = (int) Math.ceil((double) totalSV / (double) perPage);
		if (pageCurrent > pageTotal) {
			pageCurrent = pageTotal;
		}
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
