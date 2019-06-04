package com.newroad.acl.system.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class TreeNode implements Serializable{
	private String id;
	private String text;
	private String state;
	private Boolean checked;
	private Map<String, Object> attributes=new HashMap<String, Object>();
	private List<TreeNode> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public void addAttributes(String key,Object value) {
		this.attributes.put(key, value);
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	public TreeNode(String id, String text, String state, Boolean checked, Map<String, Object> attributes,
			List<TreeNode> children) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
		this.children = children;
	}
	public TreeNode() {
		super();
	}
	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", text=" + text + ", state=" + state + ", checked=" + checked + ", attributes="
				+ attributes + ", children=" + children + "]";
	}
	
}
