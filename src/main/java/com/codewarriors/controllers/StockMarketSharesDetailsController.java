package com.codewarriors.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import models.Company;
import models.Market;
import models.Turn;

@RestController
@RequestMapping("/stockMarket")
public class StockMarketSharesDetailsController {
	
	@GetMapping("/getMarketPrices")
	public Market getStokMarketSharsPrices() {
		List<Company> companies= new ArrayList<Company>();
		Market market=new Market();
		market.setGameTime(60);// game time is 0s
		market.setTurnTime(6);// companies stock price will change after 6s
		for(int j=1;j<=5;j++) {			
			Company company=new Company();
			List<Turn> turnList= new ArrayList<Turn>();
			switch(j){
			case 1:
				company.setCompanyName("aaaa");
				company.setSectorName("financial");
				break;
			case 2:
				company.setCompanyName("bbbb");
				company.setSectorName("financial");
				break;
			case 3:
				company.setCompanyName("cccc");
				company.setSectorName("Technology");
				break;
			case 4:
				company.setCompanyName("dddd");
				company.setSectorName("Manufacturing");
				break;
			case 5:
				company.setCompanyName("eeee");
				company.setSectorName("Consumer servise");
				break;
			}
			
			
			for(int i=1;i<=10;i++) {
				Turn turn=new Turn();
				turn.setTurnId(i);
				turn.setPrice(i+100);
				turnList.add(turn);			
				
			}
			company.setTurns(turnList);
			
			companies.add(company);
			
			
		}
		market.setCompanies(companies);
		
		
		return market;
	}

}
