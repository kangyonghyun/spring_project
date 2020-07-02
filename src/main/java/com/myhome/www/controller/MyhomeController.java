package com.myhome.www.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myhome.www.article.dto.Article;
import com.myhome.www.article.service.ArticleService;
import com.myhome.www.item.service.ItemCommand;
import com.myhome.www.item.service.ItemService;

@Controller
public class MyhomeController {

	@Resource(name = "itemService")
	private ItemService itemService;
	
	@Resource(name = "articleService")
	private ArticleService articleService;
	
	//크롤링
	@Autowired
	 private CrawlingParser crawlingParser;
	
	//index화면 페이지
	@RequestMapping(value = "/")
	public String indexPage(Model model) throws Exception {
		
		//상품 8개만 조회
		List<ItemCommand> itemCommandList = itemService.selectItemForIndex();
		model.addAttribute("itemCommandList", itemCommandList);
		
		//게시글 8개만 조회
		List<Article> articleList = articleService.selectArticleForIndex();
		model.addAttribute("articleList", articleList);
		return "index";
	}
	
	 //검색하기
	 @RequestMapping(value = "/search")
	 public String searchItem(@RequestParam("keyword") String keyword, Model model) throws Exception {
		 
		 //상품 조회
		 List<ItemCommand> itemList = itemService.selectSearchItemList(keyword);
		 model.addAttribute("itemList", itemList);
		 
		 //게시글 조회
		 List<Article> articleList = articleService.selectSearchArticleList(keyword); 
		 model.addAttribute("articleList", articleList);
		 return "search";
	 }
	 
	 //크롤링하기
	 @RequestMapping(value = "/admin/itemCrawling")
	 public String crawling() throws Exception {
		 
		 crawlingParser.naver_top_news();
		 return "index";
	 }
}
