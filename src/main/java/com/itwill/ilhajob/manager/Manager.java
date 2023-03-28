package com.itwill.ilhajob.manager;

import com.itwill.ilhajob.corpimage.CorpImage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
		manager_email                 		VARCHAR2(40)		 NOT NULL,
		manager_name                  		VARCHAR2(20)		 NULL ,
		manager_position              		VARCHAR2(30)		 NOT NULL,
		manager_phone                 		VARCHAR2(20)		 NOT NULL,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Manager {
	String managerEmail;
	String managerName;
	String managerPosition;
	String manager_phone;
	String corp_id;
}
