package hibernate.taglib;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTaglib extends SimpleTagSupport {

	private float step = 3;
	private String uri;
	private int offset;
	private int count;
	private String previous;
	private String next;

	private Writer getWriter() {
		JspWriter out = getJspContext().getOut();
		return out;
	}

	@Override
	public void doTag() throws JspException {
		Writer out = getWriter();

		int c_page = (int) (offset / step) + 1;
		int l_page = (int) Math.ceil(count / step);

		try {
			out.write("<nav>");
			out.write("<ul class=\"pagination justify-content-center\">");

			if (c_page == 1)
				out.write(constructLink(1, previous, "disabled", true));
			else
				out.write(constructLink(1, previous, null, false));

			for (int page = c_page - 2; page <= c_page + 2; page++) {
				if (page > 0 && page <= l_page) {
					if (page == c_page)
						out.write(constructLink(c_page, String.valueOf(c_page), "active", true));
					else
						out.write(constructLink(page, String.valueOf(page), null, false));
				}
				if (page >= l_page) {
					break;
				}
			}

			if (c_page == l_page)
				out.write(constructLink(l_page, next, "disabled", true));
			else
				out.write(constructLink(l_page, next, null, false));

			out.write("</ul>");
			out.write("</nav>");
		} catch (java.io.IOException ex) {
			throw new JspException("Error in Paginator tag", ex);
		}
	}

	private String constructLink(int page, String text, String className, boolean disabled) {
		String s_step = "";
		if (step != 3) {
			s_step = "&step=" + (int) step;
		}
		StringBuilder link = new StringBuilder("<li");
		if (className != null) {
			link.append(" class=\"page-item ");
			link.append(className);
			link.append("\"");
		}
		if (disabled)
			link.append(">").append("<a class=\"page-link\" href=\"javascript:void(0);\">" + text + "</a></li>");
		else
			link.append(">").append(
					"<a class=\"page-link\" href=\"" + uri + "?page=" + page + s_step + "\">" + text + "</a></li>");
		return link.toString();
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public float getstep() {
		return step;
	}

	public void setstep(float step) {
		this.step = step;
	}

}