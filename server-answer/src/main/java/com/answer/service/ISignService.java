package com.answer.service;

import com.answer.domain.Result;

public interface ISignService {
	public abstract Result userSign(String wxSession);
	
	public Result isSign(String wxSession);
}
