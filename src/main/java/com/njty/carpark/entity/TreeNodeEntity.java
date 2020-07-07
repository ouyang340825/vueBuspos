/**
 * 文件名称：TreeNodeModel.java
 * 版权所有：Copyright njty
 * 创建时间：2012-07-31
 * 创 建 人：wangcl (ln_admin@yeah.net)
 * 功能描述：
 **/
package com.njty.carpark.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangcl
 * @version v1.001
 * @since   v1.001
 */
public class TreeNodeEntity implements Serializable
{
	private static final long serialVersionUID = -3249772944623800908L;
	
	private int id;
	private int pid;
	private int leaf;
	private String text;
	private String title;
	private List<?> children;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getPid()
	{
		return pid;
	}

	public void setPid(int pid)
	{
		this.pid = pid;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public List<?> getChildren()
	{
		return children;
	}

	public void setChildren(List<?> children)
	{
		this.children = children;
	}

	public int getLeaf()
	{
		return leaf;
	}

	public void setLeaf(int leaf)
	{
		this.leaf = leaf;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
