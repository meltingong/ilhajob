/**********************job insert************************/
insert into job(job_id, job_name) values(1,'직군이름1');
insert into job(job_id, job_name) values(2,'직군이름2');
insert into job(job_id, job_name) values(3,'직군이름3');
insert into job(job_id, job_name) values(4,'직군이름4');
insert into job(job_id, job_name) values(5,'직군이름5');
insert into job(job_id, job_name) values(6,'직군이름6');

/**********************user_roles insert************************/
insert into user_roles(role_id, role_name) values(1,'직무1');
insert into user_roles(role_id, role_name) values(2,'직무2');
insert into user_roles(role_id, role_name) values(3,'직무3');
insert into user_roles(role_id, role_name) values(4,'직무4');
insert into user_roles(role_id, role_name) values(5,'직무5');
insert into user_roles(role_id, role_name) values(6,'직무6');




/*********************************기업관련*********************************/
/**********************corp insert************************/
insert into corp(corp_id, corp_password, corp_name) values('기업1@corp.com','1111','테스트기업1');
insert into corp(corp_id, corp_password, corp_name) values('기업2@corp.com','2222','테스트기업2');
insert into corp(corp_id, corp_password, corp_name) values('기업3@corp.com','3333','테스트기업3');
insert into corp(corp_id, corp_password, corp_name) values('기업4@corp.com','4444','테스트기업4');
insert into corp(corp_id, corp_password, corp_name) values('기업5@corp.com','5555','테스트기업5');
insert into corp(corp_id, corp_password, corp_name) values('기업6@corp.com','6666','테스트기업6');

/**********************manage insert*********************/

/**********************recruit insert*********************/

/**********************review insert*********************/

/**********************corp_image insert*********************/





/*********************************개인회원관련********************************/
/**********************userinfo insert************************/
insert into userinfo(user_email, user_password) values('테스트1@test.com','1111');
insert into userinfo(user_email, user_password) values('테스트2@test.com','2222');

/**********************education insert************************/

/**********************awards insert***************************/

/**********************experience insert*************************/

/**********************CV insert*************************/

/**********************recruit_scrap insert*************************/




/***************************************관계테이블**********************************/
/**********************app insert*************************/

/**********************message insert*************************/



/*****************************************태그************************************/
/**********************tag insert**************************/

/**********************corp_tag insert**************************/

/**********************recruit_tag insert**************************/

/**********************crop_bookmark insert**************************/




/*********************************결제관련********************************/
/**********************product insert**************************/

/**********************orders insert**************************/

/**********************payment insert**************************/




/*********************************블로그게시판관련********************************/
/**********************blog_cate insert**************************/

/**********************blog insert**************************/

/**********************blog_comment insert**************************/




/**********************admin insert*************************/

commit;


