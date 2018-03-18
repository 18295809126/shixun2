package com.jk.model.tree;

import java.io.Serializable;

/**
 * 房源  tree
 */
public class Tree implements Serializable {

	private Integer  id;

	private String  title;

	private String href;

	/**
	 * 是否打开
	 */
	private Boolean spread = false;

	private String icon;

	private Integer pid;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "HouseTree{" +
				"id=" + id +
				", title='" + title + '\'' +
				", href='" + href + '\'' +
				", spread=" + spread +
				", icon='" + icon + '\'' +
				", pid=" + pid +
				'}';
	}
}
