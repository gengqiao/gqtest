package com.gq;

 class MyThread  extends Thread{
	private int ticket=10;
	
	
  public void run(){
	  for(int i=0;i<20;i++){
		  if(this.ticket>0){
			  System.out.println(this.getName()+"测试"+"ticket"+this.ticket--);
			  
		  }
	  }
  }

}
