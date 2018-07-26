package svModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="pagination")
@SessionScoped
public class Pagination {
	private int record = 3;
	private int total ;
	private int index = 1;
	private int pages;
	public void setSVList(int countSV) {
		this.total = countSV;
		if(record >0) {
			pages = total / record ;
			if(total % record >0) {
				pages++;
			}
			if(pages == 0) {
				pages = 1;
			}
		}
	}
	public void next() {
		if(this.index < pages) {
			this.index += 1;
		}
	}
	public void prev() {
		if(this.index>1) {
			this.index--;
		}
	}
	public void firstPage() {
		this.index = 1;
	}
	public void lastPage() {
		this.index = pages;
	}
	public int getRecord() {
		return record;
	}
	public void setRecord(int record) {
		this.record = record;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getFromIndex() {
		return (index*record)-record;
	}
}
