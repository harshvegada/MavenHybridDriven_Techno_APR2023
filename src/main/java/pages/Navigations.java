package pages;

import base.ControlActions;

public class Navigations extends ControlActions {

	// more -> Organization Chart -> xyz -> pqr -> Config

	public Navigations navigate_to(String path) {
		String[] pathArr = path.split("->");
		for(int index=0;index<pathArr.length;index++) {
			if(index==0 || index==pathArr.length-1) {
				getElement("XPATH","//a[contains(text(),'"+pathArr[index]+"')]", true).click();	
			}else {
				mouseHover("XPATH", "//a[contains(text(),'"+pathArr[index]+"')]");
			}
		}
		return this;
	}
}
