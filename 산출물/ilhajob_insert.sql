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

insert into corp(CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE,
CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('DBtest1','1111','더문랩스','02-1111-1111','123-456-7890','http://www.DBtest1.com','2021-01-01','45','1000000000','DB회사입니다.1','칼퇴','서울시 강남구','1',null,null);
insert into corp(CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE,
CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('DBtest2','2222','마켓링크','02-2222-2222','123-456-7899','http://www.DBtest2.com','2020-01-02','20','2000000000','DB회사입니다.2','칼퇴','서울시 서초구','1',null,null);
insert into corp(CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE,
CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('DBtest3','3333','디비에프아이에스','02-3333-3333','123-456-7898','http://www.DBtest3.com','2020-01-03','30','3000000000','DB회사입니다.3','칼퇴','서울시 중랑구','1',null,null);
insert into corp(CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE,
CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('DBtest4','4444','대보정보통신','02-4444-4444','123-456-7897','http://www.DBtest4.com','2020-01-04','40','4000000000','DB회사입니다.4','칼퇴','서울시 도봉구','1',null,null);
insert into corp(CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE,
CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('DBtest5','5555','오앤이데이타','02-5555-5555','123-456-7896','http://www.DBtest5.com','2020-01-05','50','5000000000','DB회사입니다.5','칼퇴','서울시 광진구','1',null,null);
insert into corp(CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE,
CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('DBtest6','6666','앱노리','02-6666-6666','123-456-7895','http://www.DBtest6.com','2020-01-06','60','6000000000','DB회사입니다.6','칼퇴','서울시 송파구','1',null,null);

insert into corp (CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE,CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID)  
values('corp_13', '1313', '다큐브(daquv)', '02-456-7891', '763-87-02018', 'http://daquv.com', '2021-01-19', '20', '0',
'다큐브는 국내 최초 기업 맞춤형 음성비서 서비스를 제공하는 B2B 전문기업 입니다. ', '연금,보험,휴무,보상,주거비지원','서울시 영등포구 여의나루로 67 신송빌딩 12 층', '1', null, null );

insert into corp (CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE, CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID)  
values('corp_14', '1414', '(주)다이얼커뮤니케이션즈', '1577-7530', '206-81-84553', ' http://www.maaltalk.com/', '2003-09-06', '18', '12408000000',
'(주)다이얼커뮤니케이션즈는 MaalTalk, VoIP Solutions, 화상회의솔루션 의 기술을 바탕으로 최적의 통합 커뮤니케이션 서비스를 제공하는 사업을 하고 있습니다.', '연금,보험,휴무,보상', '서울 강서구 공항대로 168 (마곡동) 마곡 747 타워 411~413 ', '1', null, null);

insert into corp (CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE, CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('corp_15', '1515', '(주) 테이블링', '02-1899-9195', '842-86-00373', 'http://www.tabling.co.kr/', '2016-04-14', '78', '456300000000',
'테이블링은 스마트하게 예약과 대기가 가능한 서비스로 디지털 트렌스포메이션으로 탐색에서
부터 식사 이후 까지의 모든 과정에서의 낭비가 없어진 세상 이라는 비전으로 전진 하고 있습
니다.','연금,보험,휴무,보상,휴가',  '서울 강남구 영동대로 502 (삼성동) 위메프',  '1', null, null );

insert into corp (CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE, CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('corp_16', '1616', '무신사', '1544-7199', '211-88-79575', 'https://www.musinsa.com', '2012-06-25', '1329', '402400000000',
'무신사는 700 만 회원을 보유한 국내 1 위 온라인 패션 플랫폼입니다. 스트릿, 글로벌 명품, 디
자이너 등 5 천여 개 브랜드가 입점한 「무신사 스토어」와 국내·외 최신 패션 트렌드와 정보를
전달하는 패션 매거진 「무신사 매거진」을 운영하고 있습니다.', '연금,보험,휴무,보상,포인트지급', '서울 성동구 아차산로 13 길 11, 1 층',  '1', null, null );

insert into corp (CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE, CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('corp_17', '1717', '하이브', '02-3444-0105', '120-86-78223', 'https://www.hybecorp.com','2005-02-04', '633', '402440650000',
'하이브(HYBE)는 “We believe in music”이라는 미션 아래 음악 산업의 비즈니스 모델을 혁신하
는 기업입니다. 하이브는 음악에 기반한 세계 최고의 엔터테인먼트 라이프스타일 플랫폼 기업을
지향합니다.',
'연금,보험,휴무,보상,자율출퇴근', '서울시 용산구 한강대로 42',  '1', null, null );

insert into corp (CORP_ID,CORP_PASSWORD,CORP_NAME,CORP_PHONE,CORP_BUSINESS_NO,CORP_WEBSITE, CORP_EST,CORP_SIZE,CORP_SALES,CORP_COMMENT,CORP_WELFARE,CORP_ADDRESS,CORP_STATUS,JOB_ID,ROLE_ID) 
values('corp_18', '1818', '슈피겐코리아(Spigen)', '02-862-3452', '120-87-36593', 'http://www.spigen.co.kr', '2009-02-18', '386', '265970000000',
'슈피겐코리아는 모바일 액세서리 및 소형 전자기기를 제조하여 전 세계에 팔고 있는 제조·유
통 기업입니다.',
'연금,보험,휴무,보상,원격근무', '서울특별시 강남구 봉은사로 446 슈피겐 HQ A 동', '1', null, null);

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

insert into recruit(RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID) 
values(recruit_rc_seq_SEQ.nextval,'DB개발자 모집합니다','신입','DB개발자 신입모집합니다.','없음',3000,'2023-04-05',0,'DBtest1');
insert into recruit(RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID) 
values(recruit_rc_seq_seq.nextval,'DB개발자 모집합니다','신입','DB개발자 신입모집합니다.','없음',3000,'2023-04-05',0,'DBtest2');
insert into recruit(RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID) 
values(recruit_rc_seq_seq.nextval,'DB개발자 모집합니다','신입','DB개발자 신입모집합니다.','없음',3000,'2023-04-05',0,'DBtest3');
insert into recruit(RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID) 
values(recruit_rc_seq_seq.nextval,'DB개발자 모집합니다','신입','DB개발자 신입모집합니다.','없음',3000,'2023-04-05',0,'DBtest4');
insert into recruit(RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID) 
values(recruit_rc_seq_seq.nextval,'DB개발자 모집합니다','신입','DB개발자 신입모집합니다.','없음',3000,'2023-04-05',0,'DBtest5');
insert into recruit(RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID) 
values(recruit_rc_seq_seq.nextval,'DB개발자 모집합니다','신입','DB개발자 신입모집합니다.','없음',3000,'2023-04-05',0,'DBtest6');

insert into recruit (RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID)
values (recruit_recruit_seq_SEQ.nextval, '다큐브- 시니어 백엔드 개발자', '경력', '다큐브팀과 함께 국내 최초 기업용 음성비서를 만들어갈 동료를 찾고 있습니다.',
 'Springboot경험이 있는 분' ,5300, sysdate+30, 0, 'corp_13');

insert into recruit (RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID)
values (recruit_recruit_seq_SEQ.nextval, '개발자 구인[백엔드,프론트엔드,Android,iOS]', '신입', '구성원의 성장을 테이블링의 성장이라 생각하고 구성원분들에게 긍정적인 동기부여를 할 수
있도록 노력하고 있습니다.','무' ,0, sysdate+30, 0, 'corp_14');

insert into recruit (RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID)
values (recruit_recruit_seq_SEQ.nextval, '프론트엔드 개발자 채용[테이블링]', '신입/경력', '메타넷그룹의 사업 확장과 비즈니스 성장에 함께할 IT 전문성을 가진 인재들을 모십니다.', '무' ,3600, sysdate+30, 0, 'corp_15');

insert into recruit (RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID)
values (recruit_recruit_seq_SEQ.nextval, 'Backend Engineer (플랫폼서비스본부)', '경력', ' 무신사와 함께 한국을 넘어 글로벌 무대에서 경쟁력 있는 서비
스를 만들어갈 인재를 찾고 있습니다.','3년 이상의 개발 경력' ,0, sysdate+30, 0, 'corp_16');

insert into recruit (RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID)
values (recruit_recruit_seq_SEQ.nextval, '[Binary] 웹 프론트엔드 개발자', '경력', '하이브의 연구 및 개발 법인 바이너리코리아의 웹 프론트엔드 개발자 포지션으로서 사용자 중
심의 신규 서비스를 개발하고 운영합니다.','2년 이상 프론트 개발 경력' ,3700, sysdate+30, 0, 'corp_17');

insert into recruit (RC_SEQ,RC_TITLE,RC_POSITION,RC_CONTENT,RC_QUALIFICATION,RC_SALARY,RC_DEADLINE,RC_READ_COUNT,CORP_ID)
values (recruit_recruit_seq_SEQ.nextval, '웹 개발 (JAVA/SPRING)', '신입/경력', '부서 간 협업을 위한 개발 프로젝트를 진행하고, 전사적인 성과창출을 위한 시스템 혁신을 위해 웹 개발을 담당 해주실 분을 모시고 있습니다.',
'Spring Framework 기반 개발가능' ,0, sysdate+30, 0, 'corp_18');

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


