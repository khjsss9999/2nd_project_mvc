package com.ict.khj.dao;

public class EventVO {
	private String event_idx, mt20id, prfnm, prfpdfrom, prfpdto,
	fcltynm, poster, area, genrenm, prfstate, openrun;

	public String getEvent_idx() {
		return event_idx;
	}

	public void setEvent_idx(String event_idx) {
		this.event_idx = event_idx;
	}

	public String getMt20id() {
		return mt20id;
	}

	public void setMt20id(String mt20id) {
		this.mt20id = mt20id;
	}

	public String getPrfnm() {
		return prfnm;
	}

	public void setPrfnm(String prfnm) {
		this.prfnm = prfnm;
	}

	public String getPrfpdfrom() {
		return prfpdfrom;
	}

	public void setPrfpdfrom(String prfpdfrom) {
		this.prfpdfrom = prfpdfrom;
	}

	public String getPrfpdto() {
		return prfpdto;
	}

	public void setPrfpdto(String prfpdto) {
		this.prfpdto = prfpdto;
	}

	public String getFcltynm() {
		return fcltynm;
	}

	public void setFcltynm(String fcltynm) {
		this.fcltynm = fcltynm;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getGenrenm() {
		return genrenm;
	}

	public void setGenrenm(String genrenm) {
		this.genrenm = genrenm;
	}

	public String getPrfstate() {
		return prfstate;
	}

	public void setPrfstate(String prfstate) {
		this.prfstate = prfstate;
	}

	public String getOpenrun() {
		return openrun;
	}

	public void setOpenrun(String openrun) {
		this.openrun = openrun;
	}
	
	@Override
	public String toString() {

		return "EventVO [mt20id=" + mt20id + ", prfnm=" + prfnm + ", prfpdfrom=" + prfpdfrom + ", prfpdto=" + prfpdto
                + ", fcltynm=" + fcltynm + ", poster=" + poster + ", area=" + area + ", genrenm=" + genrenm + ", openrun="
                + openrun + ", prfstate=" + prfstate + "]";
	}
	
}
