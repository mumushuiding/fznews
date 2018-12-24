package com.lt.cloud.controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.cloud.annotation.NoRepeatSubmit;
import com.lt.cloud.config.SettingsErrorCode;
import com.lt.cloud.pojo.Invoice;
import com.lt.cloud.pojo.InvoiceReceiver;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.PojosWrapper;
import com.lt.cloud.pojo.User;
import com.lt.cloud.service.InvoiceService;
import com.lt.cloud.service.PaymentService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;

@RestController
@RefreshScope
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	@RequestMapping("/invoice/findAll")
	public Mono<String> findAll(@RequestBody String receiver){
		return Mono.just(this.invoiceService.findAll(receiver));
	}
	@RequestMapping("/invoice/save")
	@NoRepeatSubmit
	public String save(@RequestBody String json) {

		return this.invoiceService.saveNew(json)==true?SettingsErrorCode.SERVER_SUCCESS:SettingsErrorCode.SERVER_ERROR;
	
	}
	@RequestMapping("/invoice/delete")
	@NoRepeatSubmit
	public String delete(@RequestBody String json) {
		return this.invoiceService.deleteInvoice(json)==true?SettingsErrorCode.SERVER_SUCCESS:SettingsErrorCode.SERVER_ERROR;
	}

}
