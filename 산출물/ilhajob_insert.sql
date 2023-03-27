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



desc corp;
/*********************************기업관련*********************************/
/**********************corp insert************************/
insert into corp(corp_id, corp_password, corp_name) values('기업1@corp.com','1111','테스트기업1');
insert into corp(corp_id, corp_password, corp_name) values('기업2@corp.com','2222','테스트기업2');
insert into corp(corp_id, corp_password, corp_name) values('기업3@corp.com','3333','테스트기업3');
insert into corp(corp_id, corp_password, corp_name) values('기업4@corp.com','4444','테스트기업4');
insert into corp(corp_id, corp_password, corp_name) values('기업5@corp.com','5555','테스트기업5');
insert into corp(corp_id, corp_password, corp_name) values('기업6@corp.com','6666','테스트기업6');

insert into corp (corp_id, corp_password, corp_name, corp_phone, corp_business_no, corp_website, corp_est, corp_size, corp_sales, corp_comment, corp_welfare, job_id, corp_address, corp_status, role_id) 
values('corp_01', '1111', '신세계아이앤씨', 0233971234, 1111111111, 'http://shinsegae-inc.com', '1997-02-10', 1339, 5881000000,
'신세계아이앤씨는 디지털 기술로 새로운 영역에서 새로운 가치를 만들어내는 글로벌 리테일테크 전문기업입니다.', '연금,보험,휴무,보상,편의', 1, '서울 중구 남대문시장10길 2 (회현동1가, MESA) 21층', 0 ,2);

insert into corp (corp_id, corp_password, corp_name, corp_phone, corp_business_no, corp_website, corp_est, corp_size, corp_sales, corp_comment, corp_welfare, job_id, corp_address, corp_status, role_id) 
values('corp_02', '2222', '우아한청년들', 07043525581, 2222222222, ' http://career.woowayouths.com', '2015-11-10', 250, 2877000000,
'새로운 배달 인프라, 당신과 우아한청년들이 함께합니다.', '연금,보험,휴무,보상,편의',  1, '서울 송파구 올림픽로35다길 32 (신천동) , 9층(예전빌딩)',  0, 2 );

insert into corp (corp_id, corp_password, corp_name, corp_phone, corp_business_no, corp_website, corp_est, corp_size, corp_sales, corp_comment, corp_welfare, job_id, corp_address, corp_status, role_id) 
values('corp_03', '3333', '메타넷디지털(주)', 0237045114, 3333333333, 'http://metanetglobal.com', '1989-01-21', 1200, 570000000,
'메타넷디지털은 국내 IT산업의 선두반열에서 첨단의 정보기술을 개발해온 종합정보 서비스 회사입니다.','연금,보험,휴무,보상,편의',  1, '서울 종로구 종로33길 15 연강빌딩',  0, 1 );

insert into corp (corp_id, corp_password, corp_name, corp_phone, corp_business_no, corp_website, corp_est, corp_size, corp_sales, corp_comment, corp_welfare, job_id, corp_address, corp_status, role_id) 
values('corp_04', '4444', '제이엘케이', 0269256189, 4444444444, 'http://jikgroup.com', '2014-12-15', 80, 4000000000,
'제이엘케이는 의료진단 분야, 원격의료분야, 데이터분야에서 세계를 선도하는 인공지능 플랫폼 기업입니다.', '연금,보험,휴무,보상,편의',  1, '서울 강남구 테헤란로33길 5 (역삼동, JLK타워) JLK타워',  0, 1 );

insert into corp (corp_id, corp_password, corp_name, corp_phone, corp_business_no, corp_website, corp_est, corp_size, corp_sales, corp_comment, corp_welfare, job_id, corp_address, corp_status, role_id) 
values('corp_05', '5555', '에이치엠엠', 0237065114, 5555555555, 'http://hmm21.com','1976-09-19', 1785, 1800000000,
'반드시 승리하고 미래를 창조하는 현대상선 그룹입니다.', '연금,보험,휴무,보상,편의',  2, '서울 종로구 연지동 1-7 현대그룹빌딩 현대상선',  1, 2 );

insert into corp (corp_id, corp_password, corp_name, corp_phone, corp_business_no, corp_website, corp_est, corp_size, corp_sales, corp_comment, corp_welfare, job_id, corp_address, corp_status, role_id) 
values('corp_06', '6666', '랜드소프트(주)', 0708864477, 6666666666, 'http://landsoft.co.kr', '2018-05-09', 50, 150000000,
'랜드소프트 주식공 정보시스템 기업으로 2018년 국내 전문가들이 모여 시작해 매년 매출액이 200%이상 성장하고 있는 강소기업입니다.', '연금,보험,휴무,보상,편의',  2, '서울 서초구 서래로 37 (반포동) 2,3층',  3, 3 );


/**********************manage insert*********************/

/**********************recruit insert*********************/
insert into recruit (recruit_seq, recruit_title, recruit_position, recruit_content, recruit_career_level, recruit_qualification, recruit_salary, recruit_deadline, recruit_experience, recruit_read_count, corp_id)
values (recruit_recruit_seq_SEQ.nextval, 'SW개발/보안 경력직 모집', '경력직', '글로벌 리테일테크 전문기업 신세계아이앤씨에서 함께할 인재를 찾습니다.',
'정규직', '무' ,4500, sysdate+30, '경력무관', 0, 'corp_01');

insert into recruit (recruit_seq, recruit_title, recruit_position, recruit_content, recruit_career_level, recruit_qualification, recruit_salary, recruit_deadline, recruit_experience, recruit_read_count, corp_id)
values (recruit_recruit_seq_SEQ.nextval, '부분별 경력/신입 인재영입', '신입/경력', '우아한 청년들에서 귀한 분을 모십니다.',
'정규직/계약직', '무' ,4000, sysdate+30, '경력무관', 0, 'corp_02');

insert into recruit (recruit_seq, recruit_title, recruit_position, recruit_content, recruit_career_level, recruit_qualification, recruit_salary, recruit_deadline, recruit_experience, recruit_read_count, corp_id)
values (recruit_recruit_seq_SEQ.nextval, '메타넷 그룹 경력직 공개채용', '경력직', '메타넷그룹의 사업 확장과 비즈니스 성장에 함께할 IT 전문성을 가진 인재들을 모십니다.',
'정규직', '무' ,3600, sysdate+30, '경력무관', 0, 'corp_03');

insert into recruit (recruit_seq, recruit_title, recruit_position, recruit_content, recruit_career_level, recruit_qualification, recruit_salary, recruit_deadline, recruit_experience, recruit_read_count, corp_id)
values (recruit_recruit_seq_SEQ.nextval, '데이터베이스 관리자(DBA)모집', '경력직', 'JLK와 함께 성장하는 열정과 패기가 넘치는 global 인재를 모집합니다.',
'정규직', '대졸이상' ,3500, sysdate+30, '3년 이상', 0, 'corp_04');

insert into recruit (recruit_seq, recruit_title, recruit_position, recruit_content, recruit_career_level, recruit_qualification, recruit_salary, recruit_deadline, recruit_experience, recruit_read_count, corp_id)
values (recruit_recruit_seq_SEQ.nextval, '2023 IT 경력직 수시채용', '경력직', '저희 HMM 그룹과 최고 수준의 역량을 바탕으로 동반 성장의 파트너십에 기반하여 함께 성장할 인재를 찾습니다.',
'정규직', '무' ,5000, sysdate+30, '5년 이상', 0, 'corp_05');

insert into recruit (recruit_seq, recruit_title, recruit_position, recruit_content, recruit_career_level, recruit_qualification, recruit_salary, recruit_deadline, recruit_experience, recruit_read_count, corp_id)
values (recruit_recruit_seq_SEQ.nextval, '자바 개발자 인재 채용', '경력직', '대한민국 SI/SM의 NEW Leader, 랜드소프트가 함께할 인재를 찾습니다.',
'정규직', '무' ,4000, sysdate+30, '3년 이상', 0, 'corp_06');

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


