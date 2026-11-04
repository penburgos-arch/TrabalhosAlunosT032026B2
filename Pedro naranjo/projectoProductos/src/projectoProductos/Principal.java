package projectoProductos;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Principal {
	static Scanner scan = new Scanner(System.in);
	static List<Producto> productu = new ArrayList<Producto>(); 

	public static void main(String[] args) {
		mostrarmenu();
	}

	public static void mostrarmenu() {
		
	int escolha = 0;
	do {
		System.out.println("=====MENU=====");
		System.out.println("1- CADRASTRAR PRODUTO");
		System.out.println("2- MOSTRAR ESTOQUE");
		System.out.println("3- BUSCAR POR ID");
		System.out.println("4- ALTERAR PRODUCTO");
		System.out.println("5- ELIMINAR PRODUTO");
		System.out.println("6- SAIR");
		escolha= scan.nextInt();
		scan.nextLine();
		validarescolha(escolha);
	}while(escolha != 0);
	}

	public static void validarescolha(int escolha) {
		switch(escolha) {
		case 1:{
			cadrastro();
			break;
		}
		case 2:{
			mostrarestoque();
			break;
		}
		case 3:{
			buscarProducto();
			break;
		}
		case 4:{
			alterarproducto();
			break;
		}
		case 5:{
			eliminarProduto();
			break;
		}
		case 6:{
			System.out.println("obrigqado por usar o sistema");
			break;
		}
		default:{
			System.out.println("opcao invalida");
			break;
		}
		}
	}

	public static void buscarProducto() {
		if(productu.isEmpty()) {
			System.out.println("nenum producto cadrastrado");
			return;
		}
		System.out.println("digite o id do producto quer apagar");
		int buscaid = scan.nextInt();
		scan.nextLine();
		for(Producto producto: productu) {
			if(producto.getID() == buscaid) {
				System.out.println("nome: " + producto.getNome());
				System.out.println("preço: " + producto.getPreco());
				System.out.println("quantidade" + producto.getQuantidade());
				System.out.println("ID: " + producto.getID());
			}
		}
		
	}

	public static void eliminarProduto() {
		mostrarestoque();
		if(productu.isEmpty()) {
			System.out.println("nenum producto cadrastrado");
			return;
		}
		System.out.println("digite o id do producto");
		int buscaid = scan.nextInt();
		scan.nextLine();
		
		for(Producto producto: productu) {
			if(producto.getID() == buscaid) {
				System.out.println("\ndeseja eliminar: ");
				System.out.println("nome: " + producto.getNome());
				System.out.println("preço: " + producto.getPreco());
				System.out.println("quantidade" + producto.getQuantidade());
				System.out.println("ID: " + producto.getID());
				System.out.println("1-SIM");
				System.out.println("2-NAO");
				int confirmar = scan.nextInt();
				scan.nextLine();
				if( confirmar == 1) {
					productu.remove(producto);
					System.out.println("producto removido com sucesso");
					return;
				}else {
					System.out.println("producto nao foi removido");
					return;
				}
				
			}
		}
		
		
	}

	public static void alterarproducto() {
		mostrarestoque();
		if(productu.isEmpty()) {
			System.out.println("nao tem productos cadrastrados");
			return;
		}
		System.out.println("digite o numero de id do carro que queria actualizar");
		int buscaid = scan.nextInt();
		scan.nextLine();
		for(Producto producto: productu) {
			if(producto.getID()== buscaid) {
				System.out.println("digite o novo nome do produto");
				producto.setNome(scan.nextLine());
				System.out.println("digite o novo preço do producto");
				if(producto.getPreco()<=0) {
					System.out.println("novo preço invalido");
					return;
				}else {
					producto.setPreco(scan.nextDouble());
					scan.nextLine();
				}
				System.out.println("entre com a nova quantidade");
				if(producto.getQuantidade()<=0) {
					System.out.println("nova quantidade invalida");
					return;
				}else {
					producto.setQuantidade(scan.nextInt());
					scan.nextLine();
				}
				
			}
		}
		
	}

	public static void mostrarestoque() {
		if(productu.isEmpty()) {
			System.out.println("nenhum producto cadrastrado");
			return;
		}
		System.out.println(" ");
		System.out.println("=========ESTOQUE=========");
		
		for(int i = 0; i<productu.size();i++) {
			Producto vproducto = productu.get(i);
			System.out.println("nome: " + vproducto.getNome());
			System.out.println("preço: " + vproducto.getPreco());
			System.out.println("quantidade" + vproducto.getQuantidade());
			System.out.println("ID: " + vproducto.getID());
		}
	}

	public static void cadrastro() {
		Producto novoproducto = new Producto();
		System.out.println("digite o nome do producto");
		novoproducto.setNome(scan.nextLine());
		System.out.println("digite o preço do producto");
		novoproducto.setPreco(scan.nextDouble());
		scan.nextLine();
		if(novoproducto.getPreco() <= 0) {
			System.out.println("preço invalido");
			return;
		}
		System.out.println("digite a quantidade do producto");
		novoproducto.setQuantidade(scan.nextInt());
		scan.nextLine();
		if(novoproducto.getQuantidade()<=0) {
			System.out.println("quantidade invalida");
			return;
		}
		System.out.println("digite o ID do producto");
		novoproducto.setID(scan.nextInt());
		scan.nextLine();//mejorar por si hay otro id igual(usa un for)

		if(novoproducto.getID()<=0) {
			System.out.println("ID invalido");
			return;
		}
			
		productu.add(novoproducto);
		System.out.println("producto cadrastrado com sucesso");
	}
	

}
