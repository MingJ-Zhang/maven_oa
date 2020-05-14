package com.tledu.zmj.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tledu.zmj.auth.Admin;
import com.tledu.zmj.auth.RoleType;
import com.tledu.zmj.dto.NoteDto;
import com.tledu.zmj.model.Note;
import com.tledu.zmj.model.User;
import com.tledu.zmj.service.INoteService;
import com.tledu.zmj.util.AjaxObj;
import com.tledu.zmj.util.Pager;

@Controller
@RequestMapping("/myNote")
public class NoteController extends IsRoleController{
	private INoteService noteService;

	public INoteService getNoteService() {
		return noteService;
	}

	@Autowired
	public void setNoteService(INoteService noteService) {
		this.noteService = noteService;
	}
	
	@RequestMapping("/list")
	@Admin(RoleType.Login)
	public String list() {
		return "myNote/list";
	}


	@RequestMapping("/pager")
	@ResponseBody
	@Admin(RoleType.Login)
	public Pager<Note> pager(int page, int limit, String sreach)
			throws UnsupportedEncodingException {
		// 如果不需要模糊查询,设置为空字符串,这样不会影响SQL中的like模糊查询
		if (sreach == null || sreach.trim().equals("")) {
			sreach = "";
		} else {
			// GET请求,汉字会乱码,需要转码
			sreach = sreach.trim();
			sreach = new String(sreach.getBytes("ISO-8859-1"), "UTF-8");
			log("搜索便签 : { " + sreach + " }");
		}
		Pager<Note> pager = noteService.find(sreach, page, limit);
		System.out.println(pager.getData());
		return pager;
	}

	@RequestMapping("/add")
	public String add(Model model, HttpSession session) {
		// 需要把登陆的用户和会议类型传递到页面
		User user = (User) session.getAttribute("loginUser");
		model.addAttribute("user", user);
		return "myNote/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObj add(Note note) {

		try {
			// 设置创建时间
			note.setCreat_date(new Date());
			noteService.add(note);
			log("添加便签 : "
					+ JSON.toJSONString(note,
							SerializerFeature.WriteMapNullValue));
			return new AjaxObj(1, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxObj(0, "添加失败");
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObj delete(int id) {
		try {
			noteService.delete(id);
			log("删除便签 : { ID : " + id + "}");
			return new AjaxObj(1, "删除成功");
		} catch (Exception e) {
			return new AjaxObj(0, e.getMessage());
		}
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
	@ResponseBody
	// 如果是数组传递,会在name后面添加一个[]
	// ids[] 来进行映射
	public AjaxObj delete(@RequestParam("ids[]") int[] ids) {
		try {
			String idsString = "";
			for (int id : ids) {
				noteService.delete(id);
				idsString += "," + id;
			}
			log("删除便签 : { Ids : " + idsString.substring(1) + "}");
			return new AjaxObj(1, "删除成功");
		} catch (Exception e) {
			return new AjaxObj(0, e.getMessage());
		}
	}

	@RequestMapping("/update")
	public String update(int id, Model model) {
		Note note = noteService.load(id);
		model.addAttribute("note", note);
		return "myNote/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObj update(Note note) {

		try {

			// JSON.toJSONString : 把对象转换为JSON {id:1,name:xxx}
			// SerializerFeature.WriteMapNullValue 如果值为null 就不显示该字段
			noteService.update(note);
			log("更新便签 : "
					+ JSON.toJSONString(note,
							SerializerFeature.WriteMapNullValue));
			return new AjaxObj(1, "更新成功");
		} catch (Exception e) {
			return new AjaxObj(0, "更新失败");
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObj edit(NoteDto noteDto) {

		try {
			// JSON.toJSONString : 把对象转换为JSON {id:1,name:xxx}
			// SerializerFeature.WriteMapNullValue 如果值为null 就不显示该字段
			Note note = noteDto.getNote();
			noteService.edit(note);
			log("edit更新便签 : "
					+ JSON.toJSONString(note,
							SerializerFeature.WriteMapNullValue));
			return new AjaxObj(1, "更新成功");
		} catch (Exception e) {
			return new AjaxObj(0, "更新失败");
		}
	}
}
