package br.com.dio.model;


import java.util.Collection;
import java.util.List;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


import static br.com.dio.model.GameStatusEnum.COMPLETE;
import static br.com.dio.model.GameStatusEnum.INCOMPLETE;
import static br.com.dio.model.GameStatusEnum.NON_STARTED;
import static br.com.dio.model.GameStatusEnum.STARTED;


public class Board {

  private final List<List<Space>> spaces;


  public Board(final List<List<Space>> spaces){
    this.spaces = spaces;
  }

  public List<List<Space>> getSpaces(){
    return spaces;
  }

  public GameStatusEnum getStatus(){
	  if (spaces.stream().flatMap(Collection::stream).noneMatch(s -> s.isFixed() && nonNull(s.getAtual()))){
          return NON_STARTED;
      }
	  else if(spaces.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixed() && nonNull(s.getAtual()))) {
		  return STARTED;
	  }

      return spaces.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getAtual())) ? INCOMPLETE : COMPLETE;
  }
  
  public boolean hasError() {
	  if(getStatus() == NON_STARTED) {
		  return false;
	  }
	  return spaces.stream().flatMap(Collection::stream)
			  .anyMatch(s -> nonNull(s.getAtual()) && !s.getAtual().equals(s.getExpected()));
  }
  
  public boolean changeValues(final int col, final int row, final Integer values) {
	  var space = spaces.get(col).get(row);
	  
	  
	  if(space.isFixed()) {
		  return false;
	  }
	  spaces.get(col).get(row).setAtual(values);
	  return true;
	  
  }
  
  public boolean clearValue(final int col, final int row, final Integer values) {
	  var space = spaces.get(col).get(row);
	  
	  if(space.isFixed()) {
		  return false;
	  }
	  space.clearSpace();
	  return true;
  }
  
  public void resert() {
	  spaces.forEach(s -> s.forEach(Space::clearSpace));
  }
  
  public boolean gameIsFinished() {
	  return !hasError() && getStatus() == COMPLETE;
  }

}

