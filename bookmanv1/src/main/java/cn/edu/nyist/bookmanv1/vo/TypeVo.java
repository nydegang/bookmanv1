package cn.edu.nyist.bookmanv1.vo;

import java.io.Serializable;
/**
 * 
 * @author 南阳德刚版权所有,企鹅号:2855128836<br>
 *2018年5月13日上午11:00:03<br>
 * 说明:遵循JavaBean要求书写
 */
public class TypeVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
	public TypeVo() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
