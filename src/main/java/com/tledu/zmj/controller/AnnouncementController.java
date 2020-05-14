package com.tledu.zmj.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tledu.zmj.auth.Admin;
import com.tledu.zmj.auth.RoleType;
import com.tledu.zmj.model.Message;
import com.tledu.zmj.service.IMessageService;
import com.tledu.zmj.util.Pager;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController extends IsRoleController{
	private IMessageService messageService;

	public IMessageService getMessageService() {
		return messageService;
	}

	@Autowired
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	@RequestMapping("/list")
	@Admin(RoleType.Login)
	public String list() {
		return "announcement/list";
	}
	@RequestMapping("/pager")
	@ResponseBody
	@Admin(RoleType.Login)
	public Pager<Message> pager(int page, int limit, String sreach)
			throws UnsupportedEncodingException {
		// 如果不需要模糊查询,设置为空字符串,这样不会影响SQL中的like模糊查询
		if (sreach == null || sreach.trim().equals("")) {
			sreach = "";
		} else {
			// GET请求,汉字会乱码,需要转码
			sreach = sreach.trim();
			sreach = new String(sreach.getBytes("ISO-8859-1"), "UTF-8");
			log("搜索消息 : { " + sreach + " }");
		}
		Pager<Message> pager = messageService.find2(page, limit);
		return pager;
	}
	@RequestMapping("/ann")
	@ResponseBody
	@Admin(RoleType.Login)
	public List<Message> pager(){
		System.out.println(messageService.ann());
		return messageService.ann();
			
	}
}
