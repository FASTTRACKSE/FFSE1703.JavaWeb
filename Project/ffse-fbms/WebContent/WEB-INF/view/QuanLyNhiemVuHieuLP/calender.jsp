<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="row">
	<div class="col-xs-12">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title">Background Events</h4>
				<a class="heading-elements-toggle"><i
					class="fa fa-ellipsis-v font-medium-3"></i></a>
				<div class="heading-elements">
					<ul class="list-inline mb-0">
						<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
						<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
						<li><a data-action="close"><i class="ft-x"></i></a></li>
					</ul>
				</div>
			</div>
			<div class="card-body collapse in">
				<div class="card-block">
					<p class="card-text">
						Events that appear as background highlights can be achieved by
						setting an Event Object's rendering property to
						<code>"background"</code>
						. Background events that are
						<code>timed</code>
						will only be rendered on the time slots in agenda view. Background
						events that are
						<code>all-day</code>
						will only be rendered in month view or the all-day slots of agenda
						view. The color of background events can be manipulated by
						targeting the
						<code>fc-bgevent</code>
						className, one of your own custom classNames provided by the Event
						Object's
						<code>className</code>
						property, or by explicitly specifying a color with each Event
						Object's or Event Source's
						<code>color</code>
						or
						<code>backgroundColor properties</code>
						.
					</p>
					<div id='fc-bg-events'></div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />