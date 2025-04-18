package br.com.dio.model;

public class Space {

	  private Integer atual;
	  private final int expected;
	  private final boolean fixed;


	  public Space(final int expected,final boolean fixed){
	    this.expected = expected;
	    this.fixed = fixed;
	    if(fixed){
	      this.atual = expected;
	    }
	  }

	  public Integer getAtual(){
	    return atual;
	  }

	  public void setAtual(Integer atual){
	    if(!fixed){
	      this.atual = atual;
	    }
	  }

	  public void clearSpace(){
	    setAtual(null);
	  }

	  public int getExpected(){
	    return expected;
	  }

	  public boolean isFixed(){
	    return fixed;
	  }

	}

