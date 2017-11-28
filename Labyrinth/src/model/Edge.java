package model;

import org.jgrapht.graph.DefaultEdge;

/*
 * La classe Edge est implémentée pour permettre l'ajout de portes ouvertes et fermées.
 */

@SuppressWarnings("serial")
public class Edge extends DefaultEdge implements Comparable<Edge> {

	public enum Type{
		OPENED_DOOR,
		CLOSED_DOOR,
		CORRIDOR;
	};
	
	private Type type;
	
	public Edge(Type type) {
		super();
		this.type = type;
	}
	
	//Par défaut on considère un edge comme un couloir.
	public Edge() {
		super();
		this.type = Type.CORRIDOR;
	}
	
	public Cell getSource() {
		return (Cell) super.getSource();
	}
	
	public Cell getTarget() {
		return (Cell) super.getTarget();
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int compareTo(Edge o) {
		int source = this.getSource().compareTo((o).getSource());
		if(source != 0)
			return source;
		else {
			return this.getTarget().compareTo((o).getTarget());
		}
	}
	
}