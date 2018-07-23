package model.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.dao.StudentDAO;

@ManagedBean
@SessionScoped
public class Paginator {
	

	private int limits;
	private int totalStudent;
	private int pageIndex;
	private int totalPages;

	public void setUserLists(int countRecords) {
		this.limits = 4;
		this.pageIndex = 1;
		totalStudent = countRecords;

        if (limits > 0) {
            totalPages = limits <= 0 ? 1 : totalStudent / limits;

            if (totalStudent % limits > 0) {
                totalPages++;
            }

            if (totalPages == 0) {
            	totalPages = 1;
            }
        } else {
            limits = 1;
            totalPages = 1;
        }

	}

	public void next() {
		if (this.pageIndex < totalPages) {
			this.pageIndex += 1;
		}
	}

	public void prev() {
		if (this.pageIndex > 1) {
			this.pageIndex--;
		}
	}

	public void firstPage() {
		this.pageIndex = 1;
	}

	public void lastPage() {
		this.pageIndex = totalPages;
	}

	public int getLimits() {
		return limits;
	}

	public int getRecordsTotal() {
		return totalStudent;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getFromIndex() {
		return (pageIndex * limits) - limits;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}
