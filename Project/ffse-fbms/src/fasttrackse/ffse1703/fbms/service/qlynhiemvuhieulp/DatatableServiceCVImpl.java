package fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;


@Service

public class DatatableServiceCVImpl implements DatatableServiceCV {

	@Autowired
	private QLyNhiemVuService qLyNhiemVuService;

	@Override
	public String getSearchQuery(HttpServletRequest request, String[] columnNames, String customCondition) {

		int colLength = columnNames.length;
		String sSearch = (request.getParameter("sSearch") != null ? request.getParameter("sSearch") : "");
		String globeSearch = "where " + customCondition;
		boolean existCustom = !customCondition.isEmpty();

		if (!sSearch.isEmpty()) {
			for (int i = 0; i < colLength; i++) {
				if (i == 0) {
					if (existCustom) {
						globeSearch += " and ";
					}
					globeSearch += "(" + columnNames[i] + " like '%" + sSearch + "%' ";
				} else {
					globeSearch += "or " + columnNames[i] + " like '%" + sSearch + "%' ";
				}
			}
			globeSearch += ")";
			sSearch = globeSearch;
		}

		return !existCustom ? sSearch : globeSearch;
	}

	@Override
	public String getSortQuery(HttpServletRequest request, String[] columnNames) {

		int colLength = columnNames.length;
		List<String> sortNames = new ArrayList<String>();
		List<String> sortDirections = new ArrayList<String>();

		for (int i = 0; i < colLength; i++) {
			String colIndex = (request.getParameter("iSortCol_" + i) != null ? request.getParameter("iSortCol_" + i) : "");
			if (colIndex != "") {
				String sortName = columnNames[Integer.parseInt(colIndex)];
				String sortDirection = request.getParameter("sSortDir_" + i);

				sortNames.add(sortName);
				sortDirections.add(sortDirection);
			} else {
				break;
			}
		}

		int sortLength = sortNames.size();
		String sort = " order by ";
		for (int i = 0; i < sortLength; i++) {
			sort += sortNames.get(i) + " " + sortDirections.get(i);
			if (i != sortLength - 1) {
				sort += ", ";
			}
		}

		if (sortLength != 0) {
			return sort;
		}

		return "";
	}

	@Override
	public String getSqlQuery(String selectQuery, HttpServletRequest request, String[] columnNames,
			String customCondition) {
		return selectQuery + getSearchQuery(request, columnNames, customCondition) + getSortQuery(request, columnNames);
	}

	@Override
	public String getJsonNhiemVu(String recordsTotal, String recordsFiltered, List<QLyNhiemVuEntity> list) {
		String json = "{\"recordsTotal\":" + recordsTotal + ",\"recordsFiltered\":" + recordsFiltered + ",\"aaData\":[";
		int j = list.size();
		int i = 0;
		for (QLyNhiemVuEntity nv : list) {
			i++;
			if (i == j) {
				json += qLyNhiemVuService.toJson(nv);
			} else {
				json += qLyNhiemVuService.toJson(nv) + ",";
			}
		}
		json += "]}";

		return json;
	}
}
