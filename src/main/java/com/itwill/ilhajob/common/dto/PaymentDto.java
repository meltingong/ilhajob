package com.itwill.ilhajob.common.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
	private long id;
	private String payment_method;
	private int payment_price;
	private LocalDateTime payment_date;
	private long ordersId;
	private Long userId;
	private Long corpId;
}
