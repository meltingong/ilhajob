-- 회원 추가정보 업데이트
update userinfo set
user_name='이름1',
user_phone='010-1234-5678',
user_sex='성별',
user_address='주소',
user_age=99,
user_final_education='x대학교',
user_language='토익xxx',
user_skills='기술',
user_image='default.jpg',
user_status='F',
sns_type='카카오?',
sns_id='2720506301811636',
job_id=2,
role_id=4  
where user_email='테스트1@test.com';

--기업회원 추가정보 업데이트
update corp set
corp_phone='02-1234-5678',
corp_business_no='11024266788',
corp_website='corp1@crop.com',
corp_est=sysdate,
corp_size='50',
corp_sales='100억',
corp_comment='ㅎ...ㅎ.ㅎ.ㅎ.ㅎ.ㅎ.ㅎ.ㅎ.ㅎ',
corp_welfare='^&^&^&^&^&^&^&^',
corp_address='@!$@!%@#^^$^%&$',
corp_status='F',
job_id=2,
role_id=1
where corp_id='기업1@corp.com';




--rollback;














