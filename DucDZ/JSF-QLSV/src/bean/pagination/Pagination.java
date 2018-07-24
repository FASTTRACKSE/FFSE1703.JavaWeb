package bean.pagination;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pagination")
@SessionScoped
public class Pagination {

	private int records = 3;
	private int recordsTotal;
	private int pageIndex = 1;
	private int pages;

	public void setStudentList(int countRecords) {
		this.recordsTotal = countRecords;

		if (records > 0) {
			pages = recordsTotal / records;

			if (recordsTotal % records > 0) {
				pages++;
			}

			if (pages == 0) {
				pages = 1;
			}
} 
//		else {
//			records = 1;
//			pages = 1;
//		}
	}

	public void next() {
		if (this.pageIndex < pages) {
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
		this.pageIndex = pages;
	}

	public int getRecords() {
		return records;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getPages() {
		return pages;
	}

	public int getFromIndex() {
		return (pageIndex * records) - records;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}
