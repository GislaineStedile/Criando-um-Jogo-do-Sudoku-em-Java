package br.com.dio.model;

public enum GameStatusEnum {
	NON_STARTED("Não começou"),
	INCOMPLETE("Está incompleto"),
	COMPLETE("Está completo"),
	STARTED("Começou");
	
	private String label;

    GameStatusEnum(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

	@Override
	public String toString() {
	    return label;
	}
}

