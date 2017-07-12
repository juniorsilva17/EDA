package ArvRubNeg;

import Veiculo.Veiculo;

public class NodeRB {
	Veiculo veiculo;
	boolean isRED;
	NodeRB left=null,right=null,parent=null;
	
	public NodeRB(Veiculo veiculo,NodeRB P,boolean C){
		this.veiculo = veiculo;
		this.parent=P;
		this.isRED=C;
	}			
}
