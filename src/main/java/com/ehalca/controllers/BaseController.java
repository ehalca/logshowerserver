/**
 * 
 */
package com.ehalca.controllers;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ehalca.ilogshower.LogContentController;
import ehalca.ilogshower.logfile.LogFile;
import ehalca.ilogshower.logfile.SearchLogFileCriteria;
import ehalca.ilogshower.service.FileLogService;
import ehalca.ilogshower.transport.InitLogFileResponse;

/**
 * @author Hulk
 *
 */
@Controller
public class BaseController extends LogContentController  {

	@RequestMapping("/page")
	public ModelAndView getPage (){
		return new ModelAndView("page");
	}
	
	@RequestMapping(value = "/initFile", method = RequestMethod.GET, produces = "application/json")
	@Override
	public @ResponseBody InitLogFileResponse initLogFile (@RequestParam Map<String, String> params){
		return super.initLogFile(params);
	}

	@Override
	public FileLogService getFileLogService() {
		return new FileLogService() {
			
			@Override
			public LogFile getLogFile(SearchLogFileCriteria criteria) {
				return new LogFile(new File("D:\\work\\jora.txt"));
			}
		};
	}
}
