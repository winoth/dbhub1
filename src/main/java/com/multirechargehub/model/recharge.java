package com.multirechargehub.model;

import java.sql.Date;
import java.sql.Timestamp;


public class recharge {
	private int _mno;
	private String _operetaor;
	private int _amt;
	private String _cusid;
	private String _trnid;
	private String _cuoponcode;
	private int _status;
	private Date _rdate;
	private Timestamp _rtime;
	
	
	public int get_mno() {
		return _mno;
	}
	public void set_mno(int _mno) {
		this._mno = _mno;
	}
	public String get_operetaor() {
		return _operetaor;
	}
	public void set_operetaor(String _operetaor) {
		this._operetaor = _operetaor;
	}
	public int get_amt() {
		return _amt;
	}
	public void set_amt(int _amt) {
		this._amt = _amt;
	}
	public String get_cusid() {
		return _cusid;
	}
	public void set_cusid(String _cusid) {
		this._cusid = _cusid;
	}
	public String get_trnid() {
		return _trnid;
	}
	public void set_trnid(String _trnid) {
		this._trnid = _trnid;
	}
	public String get_cuoponcode() {
		return _cuoponcode;
	}
	public void set_cuoponcode(String _cuoponcode) {
		this._cuoponcode = _cuoponcode;
	}
	public int get_status() {
		return _status;
	}
	public void set_status(int _status) {
		this._status = _status;
	}
	public Date get_rdate() {
		return _rdate;
	}
	public void set_rdate(Date _rdate) {
		this._rdate = _rdate;
	}
	public Timestamp get_rtime() {
		return _rtime;
	}
	public void set_rtime(Timestamp _rtime) {
		this._rtime = _rtime;
	}
	
	
	

}
