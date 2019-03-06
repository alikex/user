package com.entity;

import java.util.List;

/**
 * 
 * @author hp
 *	封装分页相关的参数信息
 */
public class Page {
	private Integer pageNo = 1;//当前页的页码
	private Integer pageSize = 20;//每页显示的记录数
	private Integer rowCount;//总记录数
	private Integer pageCount;//总页数
	private List data;//存储查询到的分页数据
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		// 判断当前页码，如果页码大于零，则显示为当前的pageNo页面，否则pageNo为1，即第一页
		if (pageNo > 0) {
			this.pageNo = pageNo;
		} else {
			this.pageNo = 1;
		}
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		// 设置每页显示数据的条数
		if (pageSize > 0) {
				this.pageSize = pageSize;
		} else {
				this.pageSize = 5;
		}
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		if (rowCount > 0) {
			//总记录数
			this.rowCount = rowCount;
			//计算总页数
			this.pageCount = (this.rowCount % this.pageSize == 0) ? (this.rowCount / this.pageSize)
					: (this.rowCount / this.pageSize + 1);
		}
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
}
