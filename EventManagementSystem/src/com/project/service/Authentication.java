
package com.project.service;

import com.project.pojo.Event;

public interface Authentication {
	
	public boolean authenticate(String userId,String password);

}
