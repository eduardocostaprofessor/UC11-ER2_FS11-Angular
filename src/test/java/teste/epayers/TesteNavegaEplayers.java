package teste.epayers;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteNavegaEplayers {

	ChromeDriver driver;// driver do navegador

	@Before
	public void PreTeste() {
		// configura o caminho do chromedriver
		System.setProperty("webdriver.chrome.driver", "/Users/eduardocosta/eclipse/webdriver/chromedriver");

		driver = new ChromeDriver();// abrir o navegador
//		driver.manage().window().maximize();// maximizar o navegador
		driver.get("http://localhost:4200/");
		driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]")).click();// clicar no link de login

	}

	//

	@Test
	public void TesteNagacao() {

		// criar os WebElements
		WebElement inputEmail = driver.findElement(By.id("usuario"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement inputSubmit = driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button[1]"));
		String[] listaEmails = { "jose@email.com", "eduardo@email.com", "email sem formato", "eduardo@email.com",
				"eduardo@email.com" };
		String[] listaSenhas = { "senhaum", "outrasenha", "senhaerrada", "12345678", "123" };

		for (int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {

			try {
				// limpar os campos
				inputEmail.clear();
				inputSenha.clear();

				// preencher os campos e submeter o formulário
				inputEmail.sendKeys(listaEmails[tentativas]);
				inputSenha.sendKeys(listaSenhas[tentativas]);
				inputSubmit.click();

				Thread.sleep(3000);// espera 3 segundos

			} catch (InterruptedException error) {
				error.printStackTrace();
			}

		}

	}

	@After
	public void FinalizarTeste() {
		
		try {
			Thread.sleep(2000);//espera 3 segundos
			driver.quit();
		} catch( Exception error ) {
			error.printStackTrace();
		}
		
	}

}
