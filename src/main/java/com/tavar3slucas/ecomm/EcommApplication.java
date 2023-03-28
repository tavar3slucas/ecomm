package com.tavar3slucas.ecomm;

import com.tavar3slucas.ecomm.domain.Categoria;
import com.tavar3slucas.ecomm.domain.Cidade;
import com.tavar3slucas.ecomm.domain.Cliente;
import com.tavar3slucas.ecomm.domain.Endereco;
import com.tavar3slucas.ecomm.domain.Estado;
import com.tavar3slucas.ecomm.domain.Pagamento;
import com.tavar3slucas.ecomm.domain.PagamentoComBoleto;
import com.tavar3slucas.ecomm.domain.PagamentoComCartao;
import com.tavar3slucas.ecomm.domain.Pedido;
import com.tavar3slucas.ecomm.domain.Produto;
import com.tavar3slucas.ecomm.enums.EstadoPagamento;
import com.tavar3slucas.ecomm.enums.TipoCliente;
import com.tavar3slucas.ecomm.repository.CategoriaRepository;
import com.tavar3slucas.ecomm.repository.CidadeRepository;
import com.tavar3slucas.ecomm.repository.ClienteRepository;
import com.tavar3slucas.ecomm.repository.EnderecoRepository;
import com.tavar3slucas.ecomm.repository.EstadoRepository;
import com.tavar3slucas.ecomm.repository.PagamentoRepository;
import com.tavar3slucas.ecomm.repository.PedidoRepository;
import com.tavar3slucas.ecomm.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class EcommApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Produto p1 = new Produto(null,"Computador",2000.0);
		Produto p2 = new Produto(null,"Impressora",800.0);
		Produto p3 = new Produto(null,"Mouse",80.0);
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		Cidade cidade1 = new Cidade(null,"Uberlândia",est1);
		Cidade cidade2 = new Cidade(null,"São Paulo",est2);
		Cidade cidade3 = new Cidade(null,"Campinas",est2);

		est1.getCidades().addAll(Arrays.asList(cidade1));
		est2.getCidades().addAll(Arrays.asList(cidade2,cidade3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));

		Cliente cliente1 = new Cliente(null, "Maria Silva", "mariasilva@gmail", "17758022804", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("27363323" , "93838393"));

		Endereco endereco1 = new Endereco(null,"Ruas Flores", "300", "Apto 303", "Jardim", "38220834", cliente1,cidade1);
		Endereco endereco2 = new Endereco(null,"Avenida Matos", "105", "Sala 800", "Centro", "38777012", cliente1,cidade2);

		cliente1.getEnderecos().addAll(Arrays.asList(endereco1,endereco2));

		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido pedido1 = new Pedido(null,sdf.parse("18/12/2022 11:30"),cliente1,endereco1);
		Pedido pedido2 = new Pedido(null,sdf.parse("10/10/2022 19:30"),cliente1,endereco2);
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,pedido1,6);
		pedido1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,pedido2,sdf.parse("20/10/2022 00:00"),
				null);
		pedido2.setPagamento(pagto2);
		cliente1.getPedidos().addAll(Arrays.asList(pedido1,pedido2));

		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
	}
}
