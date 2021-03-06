package cenario2.testesSemTestrunner;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import constantes.CategoriasMenu;
import core.ChromeDriverManager;
import pageobjects.AutomationPracticePag;
import pageobjects.ConfirmacaoMenuPag;
import pageobjects.ListaComparacaoPag;
import pageobjects.MenuPrincipal;
import pageobjects.TopsPag;
import verificador.Verificar;

public class CDT07 {

	@Test
	public void teste07() {
		ChromeDriverManager cdm = new ChromeDriverManager();
		WebDriver wd = cdm.createWebDriver();
		cdm.setWebdriver(wd);
		AutomationPracticePag.acessar(wd);
		ChromeDriverManager.moverMouseAte(MenuPrincipal.botaoCategoria(CategoriasMenu.WOMEN));
		MenuPrincipal.botaoSubcategoria(CategoriasMenu.TOPS).click();
		ChromeDriverManager.moverMouseAte(TopsPag.cardProduto("Faded Short Sleeve T-shirts"));
		TopsPag.botaoAddToCompare("Faded Short Sleeve T-shirts").click();
		ChromeDriverManager.moverMouseAte(TopsPag.cardProduto("Blouse"));
		TopsPag.botaoAddToCompare("Blouse").click();
		
		TopsPag.botaoCompare().click();
		ListaComparacaoPag.botaoAddToCart("Faded Short Sleeve T-shirts").click();
		ConfirmacaoMenuPag.botaoVoltarParaShopping().click();
		ListaComparacaoPag.botaoAddToCart("Blouse").click();
		ConfirmacaoMenuPag.botaoVoltarParaShopping().click();
		ListaComparacaoPag.botaoRemover("Faded Short Sleeve T-shirts").click();
		ListaComparacaoPag.botaoRemover("Blouse").click();
		
		Verificar.seNaoHaProdutosListaComparacao();
	}

}
