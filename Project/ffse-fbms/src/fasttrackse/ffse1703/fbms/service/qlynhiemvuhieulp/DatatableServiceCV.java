package fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;

public interface DatatableServiceCV {

	public String getSearchQuery(HttpServletRequest request, String[] columnNames, String customCondition);

	public String getSortQuery(HttpServletRequest request, String[] columnNames);

	public String getSqlQuery(String selectQuery, HttpServletRequest request, String[] columnNames,
			String customCondition);
	
	public String getJsonNhiemVu(String recordsTotal, String recordsFiltered, List<QLyNhiemVuEntity> list);
	
}
