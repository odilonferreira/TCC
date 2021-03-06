package verificador;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.ChromeDriverManager;
import funcoes.Delay;

public class Verificar {
	
	private static String descontoProduto(int linhaProduto) {
		String xpath = "(//*[@class='price-percent-reduction' and ancestor::div[contains(@class, 'right-block')]])[" + linhaProduto + "]";
		String desconto = ChromeDriverManager.encontrarElemento(By.xpath(xpath)).getText();
		return desconto;
	}
	
	public static void seProdutoTemDescontoDe(int linhaProduto, String desconto) {
		Assert.assertTrue(descontoProduto(linhaProduto).contains(desconto));
	}
	
	public static void seExisteAlgumProdutoComDesconto() {
		String xpath = "span[@class='discount']";
		Assert.assertTrue(ChromeDriverManager.encontrarElemento(By.xpath(xpath)).isDisplayed());
	}
	
	public static void seElementoContemTexto(WebElement we, String texto) {
		Assert.assertTrue(we.getText().contains(texto));
	}
	
	public static void seElementoTemTexto(WebElement we, String texto) {
		Assert.assertTrue(we.getText().equals(texto));
	}
	
	public static void seElementoEstaVisivel(WebElement we) {
		Assert.assertTrue(we.isDisplayed());
	}
	
	public static void seElementoEstaHabilitado(WebElement we) {
		Assert.assertTrue(we.isEnabled());
	}
	
	public static void seElementoEstaSelecionado(WebElement we) {
		Assert.assertTrue(we.isSelected());
	}
	
	public static void seExisteUsuarioLogado() {
		String xpath = "//a[@class='account']";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		Assert.assertTrue(we.isDisplayed());
	}
	
	public static void seUsuarioLogadoPossuiNome(String nomeUsuario) {
		String xpath = "//a[@class='account']/span";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		seElementoTemTexto(we, nomeUsuario);
	}
	
	public static void seTotalDaCompraEhDe(String totalCompra) {
		String xpath = "//span[@id='total_price']";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		seElementoTemTexto(we, "$" + totalCompra);
	}
	
	public static void seTelefoneFixoDoEnderecoDeEntregaFoiAtualizadoCom(String telAtualizado) {
		String xpath = "//li[@class='address_phone' and ancestor::*[@id='address_delivery']]";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		seElementoTemTexto(we, telAtualizado);
	}
	
	public static void seTelefoneMovelDoEnderecoDeEntregaFoiAtualizadoCom(String telAtualizado) {
		String xpath = "//li[@class='address_phone_mobile' and ancestor::*[@id='address_delivery']]";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		seElementoTemTexto(we, telAtualizado);
	}
	
	public static void sePagamentoFoiCompletado() {
		String xpath = "//*[text()='Your order on My Store is complete.']";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		Assert.assertTrue(we.isDisplayed());
	}

	public static void seCarrinhoEstaVazio() {
		String xpath = "//*[text()='Your shopping cart is empty.']";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		Assert.assertTrue(we.isDisplayed());
	}
	
	public static void quantosProdutosExistemNaListaDeComparacao(int numeroProdutos) {
		Delay.de(1000);
		String xpath = "(//button[contains(@class, 'bt_compare')]//*[@class='total-compare-val'])[1]";
		WebElement we = ChromeDriverManager.encontrarElemento(By.xpath(xpath));
		Assert.assertTrue(we.getText().equals(Integer.toString(numeroProdutos)));
	}
	
	public static void seNaoHaProdutosListaComparacao() {
		String xpath = "//td[contains(@style,'display: none')]";
		Assert.assertTrue(!ChromeDriverManager.encontrarElementosSemEspera(By.xpath(xpath)).isEmpty());
	}
	
	public static void seHaAlertaErroParaCampo(String campo) {
		String xpath = "//div[contains(@class, 'alert-danger')]//b[text()='" + campo + "']";
		Assert.assertTrue(ChromeDriverManager.encontrarElemento(By.xpath(xpath)).isDisplayed());
	}
	
	public static void seHaUmaListaDeDesejosCriada() {
		String xpath = "//div[@id='mywishlist']//div[@id='block-history']//tr[contains(@id, 'wishlist')]";
		Assert.assertTrue(!ChromeDriverManager.encontrarElementosSemEspera(By.xpath(xpath)).isEmpty());
	}

}
