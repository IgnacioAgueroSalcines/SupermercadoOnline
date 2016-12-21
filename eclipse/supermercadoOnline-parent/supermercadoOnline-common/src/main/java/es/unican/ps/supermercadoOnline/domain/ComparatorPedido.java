package es.unican.ps.supermercadoOnline.domain;

import java.util.Comparator;

public class ComparatorPedido implements Comparator<Pedido>{

	private static ComparatorPedido instance;
	
	public static ComparatorPedido getInstance(){
		if(instance!=null){
			instance=new ComparatorPedido();
		}
		return instance;
	}
	
	@Override
	public int compare(Pedido o1, Pedido o2) {
		int res=0;
		if(o1.getFecha().getTime() > o2.getFecha().getTime()){
			res=1;
		}else if(o1.getFecha().getTime() < o2.getFecha().getTime()){
			res=-1;
		}
		return res;
	}

}
