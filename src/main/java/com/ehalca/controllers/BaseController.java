/**
 * 
 */
package com.ehalca.controllers;

import java.io.File;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.scheduling.SchedulingTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import ehalca.ilogshower.LogContentController;
import ehalca.ilogshower.logfile.LogFile;
import ehalca.ilogshower.logfile.MessageLogFileCriteria;
import ehalca.ilogshower.logfile.MessageSearchLogFileCriteria;
import ehalca.ilogshower.logfile.SearchLogFileCriteria;
import ehalca.ilogshower.service.FileLogService;
import ehalca.ilogshower.transport.FileLogConnectRequest;
import ehalca.ilogshower.transport.InitLogFileResponse;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

/**
 * @author Hulk
 *
 */
@Controller
public class BaseController extends LogContentController  {
	
	@MessageMapping("/file")
	public void onConnect(FileLogConnectRequest request, SimpMessageHeaderAccessor headerAccessor){
		ObjectMapper mapper = new ObjectMapper();
		MessageLogFileCriteria criteria = new MessageSearchLogFileCriteria(mapper.convertValue(request, Map.class));
		super.onConnect(criteria, headerAccessor);
	}
        
        @MessageMapping("/update")
	public void onUpdate(FileLogConnectRequest request, SimpMessageHeaderAccessor headerAccessor){
		ObjectMapper mapper = new ObjectMapper();
		MessageLogFileCriteria criteria = new MessageSearchLogFileCriteria(mapper.convertValue(request, Map.class));
		super.onUpdate(criteria, headerAccessor);
	}
        
        @MessageMapping("/stop")
	public void onStop(FileLogConnectRequest request, SimpMessageHeaderAccessor headerAccessor){
		ObjectMapper mapper = new ObjectMapper();
		MessageLogFileCriteria criteria = new MessageSearchLogFileCriteria(mapper.convertValue(request, Map.class));
		super.onStop(criteria, headerAccessor);
	}
	
        
	
	@RequestMapping("/page")
	public ModelAndView getPage (){
		return new ModelAndView("page");
	}
	
	@RequestMapping(value = "/initFile", method = RequestMethod.GET, produces = "application/json")
	@Override
	public @ResponseBody InitLogFileResponse initLogFile (@RequestParam Map<String, Object> params){
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

	@Override
	public SchedulingTaskExecutor getReadExecutor() {
		return null;
	}
}
