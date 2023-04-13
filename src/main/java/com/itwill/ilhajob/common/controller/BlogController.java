package com.itwill.ilhajob.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.common.dto.BlogCommentDto;
import com.itwill.ilhajob.common.dto.BlogDto;
import com.itwill.ilhajob.common.entity.Blog;
import com.itwill.ilhajob.common.service.BlogCommentService;
import com.itwill.ilhajob.common.service.BlogService;


@Controller
public class BlogController {

	public BlogController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private BlogCommentService blogCommentService;
	
	
	@GetMapping("/blog-list")
	public String blog_list(@PageableDefault(page=0, size=9, sort="id", direction=Sort.Direction.DESC) Pageable pageable, Model model) {
	    Page<BlogDto> blogList = blogService.findAll(pageable);
	    int nowPage = blogList.getPageable().getPageNumber();
	    model.addAttribute("blogList", blogList);
	    model.addAttribute("nowPage",nowPage);
        model.addAttribute("totalPage", blogList.getTotalPages());

	    return "blog-list";
	}
	
	/*블로그 전체 리스트
	
	@RequestMapping("/blog-list")
	public String blog_list(Model model) throws Exception{
		String forwardPath = "";
		List<BlogDto> blogList = blogService.selectAll();
		model.addAttribute("blogList", blogList);
		forwardPath="blog-list";
		
		return forwardPath;
	}
	*/
	
	/*새 블로그 작성*/  
	@RequestMapping("/blog-write-form")
	public String blog_write_form() {
		return "blog-write-form";
	}

	
	@PostMapping("/blog_write_action")
	public String blog_write_action(@ModelAttribute BlogDto blog,
									RedirectAttributes redirectAttributes)throws Exception {
		blogService.insertBlog(blog);
		// redirectAttributes.addAttribute("id",blog); 글쓰고나서 리스트말고 작성한 글로 가는거..안되네..
		return "redirect:blog-single";
		 
		}
	
	/*
	 * int guest_no = guestService.insertGuest(guest);
		redirectAttributes.addAttribute("guest_no",guest_no);
		return "redirect:guest_view";
	}
	 */

	
	/*블로그 상세*/
	//블로그 Seq가 없을 때
	@RequestMapping(value = "/blog-single",params = "!id")
	public String blog_view() {
		return "redirect:blog-list";	
	}
	//블로그 Seq가 있을때
	@RequestMapping(value = "/blog-single", params = "id")
	public String blog_view(@RequestParam("id") Long id , Model model, @ModelAttribute BlogCommentDto blogCommentDto) throws Exception{
		//블로그 상세내용 불러오기
		BlogDto blogDto = blogService.findBlog(id);
		model.addAttribute("blog", blogDto);
		
		//블로그 조회수 업데이트
		model.addAttribute("blogReadCount", blogService.updateViews(id));
		
    
		//댓글리스트 불러오기...안되네.....
		List<BlogCommentDto> blogCommentList = blogCommentService.selectByBlogComment(id);
		model.addAttribute("blogCommentList", blogCommentList);
		
		return "blog-single";
	}
	
	/*블로그 수정 안됨..*/

	@PostMapping(value="/blog-modify-form",params = "!id")
	public String blog_modify_form() {
		return "redirect:blog-list";
	}
	
	@PostMapping(value="/blog-modify-form", params = "id")
	public String blog_modify_form(@RequestParam("id") Long id,Model model) throws Exception{
		BlogDto blogDto = blogService.findBlog(id);
		model.addAttribute("blog", blogDto);
		return "blog-modify-form";
	}
	
	/*
	@PostMapping(value="/blog_modify_action")
	public String blog_modify_action(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes) throws Exception{
		blogService.updateBlog(blog);
		redirectAttributes.addAttribute("blogSeq", blog.getBlogSeq());
		return "redirect:blog-single";
	}
	 */
	
	/*삭제
	@PostMapping(value = "/blog-remove-action")
	public String blog_remove_action(@RequestParam Long id) throws Exception{
		blogService.deleteBlog(id);
		return "redirect:blog-list";
	}
	
	@PostMapping(value = "/blog_remove_action", params = "id")
	public String blog_remove_action(@RequestParam("id") Long id, Model model) throws Exception{
		BlogDto blogDto = blogService.deleteBlog(id);
		model.addAttribute("blog", blogDto);
		return "redirect:blog_list";
	}
	*/
	
	/*
	 * 블로그 댓글 작성..안됨ㅠㅠㅋ
	 */

	@PostMapping("/blogcomment_write_action")
	public String blogcomment_write_action(@ModelAttribute BlogCommentDto blogCommentDto,
									RedirectAttributes redirectAttributes)throws Exception {
		blogCommentService.insertBlogComment(blogCommentDto);
		return "redirect:blog-single";
	
	}
	

}