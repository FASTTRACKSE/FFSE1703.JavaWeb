package fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


public interface DatatableCVService {

	public String getSearchQuery(HttpServletRequest request, String[] columnNames, String customCondition);

	public String getSortQuery(HttpServletRequest request, String[] columnNames);

	public String getSqlQuery(String selectQuery, HttpServletRequest request, String[] columnNames,
			String customCondition);
	
//	public String getJsonChucDanh(String recordsTotal, String recordsFiltered, List<CongViec> list);

}
