package com.sts.testautomation.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "QRaterRq")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class QRaterRq {
	@XmlElement
	public Header Header;
	@XmlElement
	public Policy Policy;

	@Override
	public String toString() {
		return "QRaterRq{" +
				"Header=" + Header +
				", Policy=" + Policy +
				'}';
	}
}
