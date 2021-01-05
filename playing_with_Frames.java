// demo site used: "https://www.steegle.com/google-sites/iframes"

public void clickFrameHistory_gsite(String theFrame) {
		try {
			Thread.sleep(5000); //better to use some wait since frames takes a bit time to get completely loaded
			element = driver.findElement(By.id(theFrame));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //To Scroll to Frame's position on page
			driver.switchTo().frame(theFrame); //Switching to frame is necessary to access its elements
			
			Thread.sleep(5000);
			driver.switchTo().frame("innerFrame"); //once inside above frame, can directly switch into nested frame

			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"ca-history\"]")).click(); //better to use xpath to access elements of frame
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
  public void clickLinkInNestedFrame(String theFrameClass){
  //To click a link (different origin), opening in another tab (successful)
			element = driver.findElement(By.xpath(theFrameClass)); // better to use Abs xpath for first ever frame
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
			driver.switchTo().frame(element); Thread.sleep(5000);
			driver.switchTo().frame("sandboxFrame"); Thread.sleep(5000);
			driver.switchTo().frame("userHtmlFrame"); Thread.sleep(5000);
			driver.switchTo().frame("twitter-widget-0"); Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div/div[1]/h1/span/a")).click(); // better to use Abs Xpath
 }
