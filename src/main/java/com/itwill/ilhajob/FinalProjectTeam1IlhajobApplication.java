package com.itwill.ilhajob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itwill.ilhajob.app.App;
import com.itwill.ilhajob.blog.Blog;
import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.cv.Cv;
import com.itwill.ilhajob.recruit.Recruit;
import com.itwill.ilhajob.review.Review;
import com.itwill.ilhajob.user.User;

@SpringBootApplication(scanBasePackageClasses = {User.class, Corp.class, App.class, Recruit.class, Cv.class, Blog.class, Review.class})
public class FinalProjectTeam1IlhajobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectTeam1IlhajobApplication.class, args);
	}

}
